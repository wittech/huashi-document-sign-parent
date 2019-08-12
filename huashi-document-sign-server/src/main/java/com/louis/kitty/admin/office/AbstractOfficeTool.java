package com.louis.kitty.admin.office;

import com.alibaba.druid.util.StringUtils;
import com.louis.kitty.admin.constants.DocConstants;
import com.louis.kitty.admin.dao.LoanDocMapper;
import com.louis.kitty.admin.model.DocCommonModel;
import com.louis.kitty.admin.model.LoanDoc;
import com.louis.kitty.admin.util.FileDirectoryUtil;
import com.louis.kitty.admin.util.OfficeUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;

@Slf4j
public abstract class AbstractOfficeTool {

    @Value("${storage.model.home}")
    private String modelHome;
    @Value("${storage.model.target}")
    private String docTarget;

    @Resource
    private LoanDocMapper loanDocMapper;

    /**
     * 生成文件分隔符
     */
    private static final String DOC_FILE_SPLIT_CHAR = "-";

    /**
     * 默认编码
     */
    private static final String DEFAULT_ENCODING = "UTF-8";

    /**
     * 模板变量
     */
    protected final List<Map<String, Object>> VARIABLES_IN_MODEL = new CopyOnWriteArrayList<>();

    /**
     * 填充变量
     */
    protected abstract void fillVariable(DocCommonModel docCommonModel);

    /**
     * 写入磁盘
     */
    private void write2Disk(String storagePath, String data) throws IOException {
        storagePath = storagePath + docType().getSuffixName();
        byte[] targetFileData = data.getBytes(Charset.forName(DEFAULT_ENCODING));

        Files.write(Paths.get(storagePath), targetFileData);
    }

    /**
     * 文件拷贝
     *
     * @param sourcePath 原文件路径
     * @param targetPath 拷贝后文件路径
     * @return 文件大小
     * @throws IOException IO
     */
    private long transformPdf(String sourcePath, String targetPath) throws Exception {
        if (docType() == DocConstants.DocType.WORD || docType() == DocConstants.DocType.WORD_07) {
            OfficeUtil.word2Pdf(sourcePath, targetPath);
        } else if (docType() == DocConstants.DocType.EXCEL || docType() == DocConstants.DocType.EXCEL_07) {
            OfficeUtil.excel2Pdf(sourcePath, targetPath);
        }

        byte[] data = Files.readAllBytes(Paths.get(targetPath));
        if (data.length == 0) {
            throw new IOException("Path[" + sourcePath + "] data can not be '0'");
        }
//        Files.copy(Paths.get(sourcePath), Paths.get(targetPath));

        return data.length;
    }

    /**
     * 模板文件名称（包含路径）
     *
     * @return 返回路径名称
     */
    protected abstract String modelFileName();

    /**
     * 文件排序，从1开始，正序
     *
     * @return 排序数值
     */
    protected abstract int sort();

    /**
     * 设置落地文件类型
     *
     * @return 文件类型
     */
    protected abstract DocConstants.DocType docType();

    /**
     * 是否仅拷贝文件（指有些文件指从模板地址拷贝到目标地址，不做任何参数转义情况）
     *
     * @return true/false（一般默认false, 提供子类重写）
     */
    protected boolean isOnlyCloneFile() {
        return false;
    }

    protected Map<String, Object> newRound() {
        Map<String, Object> variables = new HashMap<>();
        VARIABLES_IN_MODEL.add(variables);
        return variables;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean persistence(Long basisLoanId, Long docSize, String targetDocFullName, int secondSort) {
        int rows = delete(basisLoanId, null);
        log.info("pre-delete loan doc rows are '{}' by loanBasisId[{}]", rows, basisLoanId);

        return save(basisLoanId, docSize, targetDocFullName, secondSort);
    }

    /**
     * 保存记录至库表
     *
     * @param basisLoanId 基础借贷ID
     * @return 处理结果
     */

    private boolean save(Long basisLoanId, Long docSize, String targetDocFullName, int secondSort) {
        LoanDoc loanDoc = LoanDoc.builder().loanBasisId(basisLoanId).docName(modelFileName())
                .docPath(targetDocFullName).docSize(docSize).downloadTimes(0)
                .printTimes(0).sort(sort() + secondSort)
                .createTime(new Date()).build();

        return loanDocMapper.add(loanDoc) > 0;
    }

    /**
     * 保存记录至库表
     *
     * @param loanBasisId 基础借贷ID
     * @param type        类型
     * @return 处理结果
     */
    private int delete(Long loanBasisId, Integer type) {
        return loanDocMapper.deleteByLoanBasisId(loanBasisId);
    }

    /**
     * 文件拷贝流程
     *
     * @return 处理结果
     */
    private Future<Boolean> clone(DocCommonModel docCommonModel) {
        try {
            // 最终生成文件的全路径（包含文件名称）
            String targetDocFullName = targetDocFullNameWithoutTail("")
                    + DocConstants.DocType.PDF.getSuffixName();

            long docSize = transformPdf(getModelFullPath(docType().getSuffixName()), targetDocFullName);

            return new AsyncResult<>(persistence(docCommonModel.getLoanBasis().getId(), docSize,
                    targetDocFullName, 0));
        } catch (Exception e) {
            log.error("clone failed by basisLoanId[{}]", docCommonModel.getLoanBasis().getId(), e);
            return new AsyncResult<>(false);
        }
    }

    /**
     * 处理
     *
     * @param docCommonModel 借贷基础信息表
     * @return 处理成功与否
     */
    @Async
    public Future<Boolean> execute(DocCommonModel docCommonModel) {
        if (isOnlyCloneFile()) {
            return clone(docCommonModel);
        }

        return generate(docCommonModel);
    }

    private boolean isSingle() {
        return VARIABLES_IN_MODEL.size() == 1;
    }

    private Future<Boolean> generate(DocCommonModel docCommonModel) {
        try {
            String xmlContent = readXml();

            // 组装替换变量
            fillVariable(docCommonModel);

            int index = 1;
            for (Map<String, Object> variables : VARIABLES_IN_MODEL) {
                // 替换参数生成新的XML内容
                xmlContent = translate(xmlContent, variables);

                // 最终生成文件的全路径（包含文件名称）
                String targetDocFullName = targetDocFullNameWithoutTail(indexInMultiDocs(index));

                // 生成模板替换后的文件
                write2Disk(targetDocFullName, xmlContent);

                // 将office文件转换为PDF文件
                long docSize = transformPdf(targetDocFullName + docType().getSuffixName(),
                        targetDocFullName + DocConstants.DocType.PDF.getSuffixName());

                persistence(docCommonModel.getLoanBasis().getId(), docSize,
                        targetDocFullName + DocConstants.DocType.PDF.getSuffixName(),
                        index);

                index++;
            }

            return new AsyncResult<>(true);
        } catch (Exception e) {
            log.error("Handler failed by basisLoanId[{}]", docCommonModel.getLoanBasis().getId(), e);
            return new AsyncResult<>(false);
        }
    }

    /**
     * 替换变量
     *
     * @param modelContent XML模板内容
     * @return 替换变量后的模板内容
     */
    private String translate(String modelContent, Map<String, Object> variables) {
        for (Map.Entry<String, Object> entry : variables.entrySet()) {
            modelContent = modelContent.replace("{{" + entry.getKey() + "}}", entry.getValue().toString());
        }

        // 替换未设置的变量  为空值

        return modelContent;
    }

    private String getModelFullPath() {
        return getModelFullPath(DocConstants.MODEL_SUFFIX_NAME);
    }

    private String getModelFullPath(String modelSuffixName) {
        return modelHome + modelFileName() + modelSuffixName;
    }

    private String readXml() throws Exception {
        if (StringUtils.isEmpty(modelFileName())) {
            throw new IllegalArgumentException("model path can not be empty");
        }

        return new String(readFile(getModelFullPath()), Charset.forName(DEFAULT_ENCODING));
    }

    private byte[] readFile(String path) throws IOException {
        return Files.readAllBytes(Paths.get(path));
    }


    /**
     * 设置YES 选项
     *
     * @param yes 是否选中
     * @return 最终标签
     */
    protected String setYesOption(Integer yes) {
        String yesDes;
        if (yes == null) {
            yesDes = "□是  □否";
        } else if (yes == 1) {
            yesDes = "☑是  □否";
        } else {
            yesDes = "□是  ☑否";
        }

        return yesDes;
    }

    private String indexInMultiDocs(int sort) {
        if (isSingle()) {
            return "";
        }

        return DOC_FILE_SPLIT_CHAR + sort;
    }

    /**
     * 最终文件名称（不包含扩展名，后面自行拼接）
     *
     * @param indexInMultiDocs 多级文档索引
     * @return 没有扩展名的绝对路径名称
     */
    private String targetDocFullNameWithoutTail(String indexInMultiDocs) {
        FileDirectoryUtil.DirMeta docMeta = FileDirectoryUtil.createDir(docTarget);
        if (!docMeta.isResult()) {
            throw new RuntimeException(docMeta.getMsg());
        }

        return docMeta.getPath() + modelFileName() + indexInMultiDocs + DOC_FILE_SPLIT_CHAR
                + datetimeTitle();
    }

    private static String datetimeTitle() {
        return new SimpleDateFormat("yyyyMMddHHmmSS").format(new Date());
    }

    protected String getValue(List<Map<String, Object>> list, int index, String key) {
        // 如果集合无数据，或者当前索引值 大于等于集合大小则返回空，因为前三行必须显示，顾以空填充
        if (CollectionUtils.isEmpty(list) || index >= list.size()) {
            return "";
        }

        return list.get(index).getOrDefault(key, "").toString();
    }

}
