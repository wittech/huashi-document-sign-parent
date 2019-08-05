package com.louis.kitty.admin.office;

import com.alibaba.druid.util.StringUtils;
import com.louis.kitty.admin.constants.DocConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public abstract class AbstractOfficeTool {

    @Value("${storage.model.home}")
    private String modelHome;
    @Value("${storage.model.target}")
    private String docTarget;

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
    protected final Map<String, Object> VARIABLES_IN_MODEL = new ConcurrentHashMap<>();

    /**
     * 填充变量
     */
    protected abstract void fillVariable(Long basisLoanId);

    /**
     * 写入磁盘
     */
    private void write2Disk(String storagePath, String data) throws IOException {
        // 创建目录
//        FileDirectoryUtil.createDir();

        Files.write(Paths.get(storagePath), data.getBytes(Charset.forName(DEFAULT_ENCODING)));
    }

    /**
     * 模板文件名称（包含路径）
     *
     * @return 返回路径名称
     */
    protected abstract String modelFileName();

    /**
     * 设置落地文件类型
     * @return 文件类型
     */
    protected abstract DocConstants.DocType docType();

    /**
     * 处理
     * @param basisLoanId 借贷基础ID
     * @return 处理成功与否
     */
    public boolean execute(Long basisLoanId) {
        try {
            String xmlContent = readXml();

            // 组装替换变量
            fillVariable(basisLoanId);

            // 替换参数生成新的XML内容
            xmlContent = translate(xmlContent);

            write2Disk(targetDocFullName(), xmlContent);

            return true;
        } catch (Exception e) {
            log.error("Handler failed by basisLoanId[{}]", basisLoanId, e);
            return false;
        }
    }


    /**
     * 替换变量
      * @param modelContent XML模板内容
     * @return 替换变量后的模板内容
     */
    private String translate(String modelContent) {
        for (Map.Entry<String, Object> entry : VARIABLES_IN_MODEL.entrySet()) {
            modelContent = modelContent.replace("{{" + entry.getKey() + "}}", entry.getValue().toString());
        }

        return modelContent;
    }

    private String getModelFullPath() {
        return modelHome + modelFileName() + DocConstants.MODEL_SUFFIX_NAME;
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
    protected String setYesOption(String yes) {
        String yesDes = "";
        if (StringUtils.isEmpty(yes)) {
            yesDes = "□是  □否";
        } else if ("是".equals(yes)) {
            yesDes = "☑是  □否";
        } else if ("否".equals(yes)) {
            yesDes = "□是  ☑否";
        }

        return yesDes;
    }

    private String targetDocFullName() {
        return  docTarget + modelFileName() + DOC_FILE_SPLIT_CHAR + datetimeTitle() + docType().getSuffixName();
    }

    private static String datetimeTitle() {
        return new SimpleDateFormat("yyyyMMddHHmmSS").format(new Date());
    }

}
