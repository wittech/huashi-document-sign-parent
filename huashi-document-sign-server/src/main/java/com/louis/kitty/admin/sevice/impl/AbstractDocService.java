package com.louis.kitty.admin.sevice.impl;

import com.itextpdf.text.DocumentException;
import com.louis.kitty.admin.constants.DocConstants;
import com.louis.kitty.admin.constants.LoanConstants;
import com.louis.kitty.admin.model.*;
import com.louis.kitty.admin.sevice.*;
import com.louis.kitty.admin.util.*;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public abstract class AbstractDocService {

    @Value("${storage.model.download}")
    private String docDownloadFileTarget;

    @Value("${storage.model.print}")
    private String docPrintFileTarget;

    @Value("${storage.model.domain}")
    private String docDomain;

    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private LoanBasisService loanBasisService;
    @Autowired
    private RelatedPersonnelInformationService relatedPersonnelInformationService;
    @Autowired
    private LoanBusinessInformationService loanBusinessInformationService;
    @Autowired
    private ContractInformationService contractInformationService;
    @Autowired
    private PawnService pawnService;
    @Autowired
    private PawnPersonnelMappingService pawnPersonnelMappingService;
    @Autowired
    private CounterpartyInformationService counterpartyInformationService;
    @Autowired
    private RepaymentPlanService repaymentPlanService;

    LoanBasis getLoanBais(Long loanBasisId) {
        return loanBasisService.findById(loanBasisId);
    }

    void setRelatedPersonnelInformations(DocCommonModel model) {
        List<RelatedPersonnelInformation> list = relatedPersonnelInformationService.findByBaseIdList(model.getLoanBasicId());
        if (CollectionUtils.isEmpty(list)) {
            return;
        }

        for (RelatedPersonnelInformation relatedPersonnelInformation : list) {
            if (relatedPersonnelInformation == null) {
                continue;
            }

            if (relatedPersonnelInformation.getType() == null) {
                model.getOtherPartyList().add(relatedPersonnelInformation);
            } else if (LoanConstants.PersonnelType.BORROWER.getCode() == relatedPersonnelInformation.getType()) {
                model.setBorrower(relatedPersonnelInformation);
            } else if (LoanConstants.PersonnelType.BORROWER_COUPLE.getCode() == relatedPersonnelInformation.getType()) {
                model.setBorrowerCouple(relatedPersonnelInformation);
            } else if (LoanConstants.PersonnelType.MORTGAGE_GUARANTOR.getCode() == relatedPersonnelInformation.getType()) {
                model.getMortgageGuarantorList().add(relatedPersonnelInformation);
            } else if (LoanConstants.PersonnelType.GUARANTOR.getCode() == relatedPersonnelInformation.getType()) {
                model.getGuarantorList().add(relatedPersonnelInformation);
            } else if (LoanConstants.PersonnelType.GUARANTOR_BOTH.getCode() == relatedPersonnelInformation.getType()) {
                model.getMortgageGuarantorList().add(relatedPersonnelInformation);
                model.getGuarantorList().add(relatedPersonnelInformation);
            }
        }
    }

    void setLoanBusinessInformation(DocCommonModel model) {
        LoanBusinessInformation loanBusinessInformation = loanBusinessInformationService.findByBasisId(model.getLoanBasicId());
        if (loanBusinessInformation == null) {
            return;
        }

        model.setLoanBusinessInformation(loanBusinessInformation);
    }

    void setContractInformation(DocCommonModel model) {
        ContractInformation contractInformation = contractInformationService.findByLoanBasisId(model.getLoanBasicId());
        if (contractInformation == null) {
            return;
        }

        model.setContractInformation(contractInformation);
    }

    void setPawnList(DocCommonModel model) {
        if (!model.isContainsMortgage()) {
            log.info("ignored cause by loanBasisId[{}] is not belong to mortgage");
            return;
        }

        List<Pawn> pawnList = pawnService.findByLoanBasisId(model.getLoanBasicId());
        if (CollectionUtils.isEmpty(pawnList)) {
            return;
        }

        for (Pawn pawn : pawnList) {
            pawn.getRelatedPersonnelInformationList().addAll(pawnPersonnelMappingService.findByPawnId(pawn.getId()));
        }

        model.setPawnList(pawnList);
    }

    void setRepaymentPlanList(DocCommonModel model) {
        List<RepaymentPlan> repaymentPlanList = repaymentPlanService.findByIoanBusinessInformationId(model.getLoanBusinessInformationId());
        if (CollectionUtils.isEmpty(repaymentPlanList)) {
            return;
        }

        model.setRepaymentPlanList(repaymentPlanList);
    }

    void setCounterpartyInformationList(DocCommonModel model) {
        List<CounterpartyInformation> counterpartyInformationList = counterpartyInformationService.findByIoanBusinessInformationId(model.getLoanBusinessInformationId());
        if (CollectionUtils.isEmpty(counterpartyInformationList)) {
            return;
        }

        model.setCounterpartyInformationList(counterpartyInformationList);
    }

    private void rest() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            log.warn("ignored by '{}'", e.getMessage());
        }
    }

    int getResult(List<Future<Boolean>> futureList) {
        if (CollectionUtils.isEmpty(futureList)) {
            return 0;
        }

        long startTime = System.currentTimeMillis();
        int result;
        while (true) {
            result = 0;
            int doneCount = 0;
            for (Future<Boolean> future : futureList) {
                if (!future.isDone()) {
                    break;
                }

                doneCount++;
                try {
                    if (future.get()) {
                        result += 1;
                    }
                } catch (InterruptedException | ExecutionException e) {
                    log.warn("ignored by msg [{}]", e.getMessage());
                }
            }

            log.info("total count is '{}', finish count is '{}'", futureList.size(), doneCount);

            if (doneCount == futureList.size()) {
                break;
            }

            rest();
        }

        log.info("Getting async result cost {} ms", (System.currentTimeMillis() - startTime));

        return result;
    }

    protected abstract List<Future<Boolean>> asyncExecute(DocCommonModel model);

    private String getDateTimeFileName(int size) {
        return new SimpleDateFormat("yyyyMMddHHmmSS").format(new Date()) + "-" + size
                + "-" + RandomUtil.randomCode();
    }

    /**
     * 获取携带日期格式路径
     *
     * @param dir 原路径
     * @return 原路径追加日期后的路径
     */
    private FileDirectoryUtil.DirMeta getDirWithDate(String dir) {
        return FileDirectoryUtil.createDir(dir);
    }

    /**
     * 返回 将文件压缩成ZIP包数据流
     *
     * @param docFileNames 需要压缩的文件名称数组
     * @return ZIP数据流
     */
    ResponseEntity<InputStreamResource> getZipFile(List<String> docFileNames) {
        if (CollectionUtils.isEmpty(docFileNames)) {
            log.warn("Can not find any zip files");
            return null;
        }

        FileDirectoryUtil.DirMeta dirMeta = getDirWithDate(docDownloadFileTarget);
        String targetFileName = getDateTimeFileName(docFileNames.size()) + DocConstants.DocType.ZIP.getSuffixName();
        String targetFileFullName = dirMeta.getPath() + File.separator + targetFileName;

        boolean isZipOk = ZipUtil.zip(docFileNames.toArray(new String[]{}), targetFileFullName);
        if (!isZipOk) {
            log.error("docFileNames[{}] zip failed", docFileNames);
            return null;
        }

        return FileDownloadUtil.download(targetFileFullName, targetFileName);
    }

    /**
     * 获取最终合并多个PDF文件后的 PDF URL路径
     *
     * @param pdfFileNames 需要合并的PDF文件集合
     * @param watermark    pdf水印文字
     * @return PDF URL路径： 如果为NULL则前端不处理
     */
    String getPrintPdf(List<String> pdfFileNames, String watermark) {
        if (CollectionUtils.isEmpty(pdfFileNames)) {
            log.warn("Can not find any pdf files");
            return null;
        }

        FileDirectoryUtil.DirMeta dirMeta = getDirWithDate(docPrintFileTarget);

        String targetPdfFileName = getDateTimeFileName(pdfFileNames.size()) + DocConstants.DocType.PDF.getSuffixName();
        try {
            // 合并pdf后的新PDF全路径（系统盘符绝对路径）
            String targetPdfFullFileName = dirMeta.getPath() + File.separator + targetPdfFileName;

            PdfUtil.mergeFiles(pdfFileNames.toArray(new String[]{}), targetPdfFullFileName);

            // 添加水印
            targetPdfFileName = addPdfWatermark(dirMeta.getPath() + File.separator, targetPdfFileName,
                    watermark);

            // 返回网络路径地址
            return docDomain + dirMeta.getDate() + "/" + targetPdfFileName;

        } catch (IOException | DocumentException e) {
            log.error("pdfFileNames[{}] doc print pdf merge failed", pdfFileNames, e);
            return null;
        }
    }

    private String addPdfWatermark(String directory, String pdfFileName, String watermark) {
        if (StringUtils.isBlank(watermark)) {
            return pdfFileName;
        }

        try {
            // 水印PDF名称
            String watermarkPdfFileName = "WM-" + pdfFileName;
            PdfUtil.waterMark(directory + pdfFileName, directory + watermarkPdfFileName, watermark);

            log.info("pdfFileName[{}] add watermark[{}] successfully, target file name is '{}'",
                    pdfFileName);

            return watermarkPdfFileName;
        } catch (Exception e) {
            log.error("pdfFileName[{}] add watermark[{}] failed", pdfFileName, watermark, e);
            return pdfFileName;
        }
    }

}
