package com.louis.kitty.admin.sevice.impl;

import com.itextpdf.text.DocumentException;
import com.louis.kitty.admin.constants.DocConstants;
import com.louis.kitty.admin.constants.LoanConstants;
import com.louis.kitty.admin.model.*;
import com.louis.kitty.admin.sevice.*;
import com.louis.kitty.admin.util.*;
import org.apache.commons.collections4.CollectionUtils;
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

    protected LoanBasis getLoanBais(Long loanBasisId) {
        return loanBasisService.findById(loanBasisId);
    }

    protected void setRelatedPersonnelInformations(DocCommonModel model) {
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

    protected void setLoanBusinessInformation(DocCommonModel model) {
        LoanBusinessInformation loanBusinessInformation = loanBusinessInformationService.findByBasisId(model.getLoanBasicId());
        if (loanBusinessInformation == null) {
            return;
        }

        model.setLoanBusinessInformation(loanBusinessInformation);
    }

    protected void setContractInformation(DocCommonModel model) {
        ContractInformation contractInformation = contractInformationService.findByLoanBasisId(model.getLoanBasicId());
        if (contractInformation == null) {
            return;
        }

        model.setContractInformation(contractInformation);
    }

    protected void setPawnList(DocCommonModel model) {
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

    protected void setRepaymentPlanList(DocCommonModel model) {
        List<RepaymentPlan> repaymentPlanList = repaymentPlanService.findByIoanBusinessInformationId(model.getLoanBusinessInformationId());
        if (CollectionUtils.isEmpty(repaymentPlanList)) {
            return;
        }

        model.setRepaymentPlanList(repaymentPlanList);
    }

    protected void setCounterpartyInformationList(DocCommonModel model) {
        List<CounterpartyInformation> counterpartyInformationList = counterpartyInformationService.findByIoanBusinessInformationId(model.getLoanBusinessInformationId());
        if (CollectionUtils.isEmpty(counterpartyInformationList)) {
            return;
        }

        model.setCounterpartyInformationList(counterpartyInformationList);
    }

    protected int getResult(List<Future<Boolean>> futureList) {
        if (CollectionUtils.isEmpty(futureList)) {
            return 0;
        }

        int result;
        while (true) {
            result = 0;
            int doneCount = 0;
            for (Future<Boolean> future : futureList) {
                if (!future.isDone()) {
                    break;
                }

                try {
                    if (future.get()) {
                        result += 1;
                    }
                } catch (InterruptedException | ExecutionException e) {
                    log.warn("ignored by msg [{}]", e.getMessage());
                }

                doneCount++;
            }

            if (doneCount == futureList.size()) {
                break;
            }

            log.info("total count is '{}', finish count is '{}'", futureList.size(), doneCount);

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
            }
        }

        return result;
    }

    protected abstract List<Future<Boolean>> asyncExecute(DocCommonModel model);

    protected String getDateTimeFileName(int size) {
        return new SimpleDateFormat("yyyyMMddHHmmSS").format(new Date()) + "-" + size
                + "-" + RandomUtil.randomCode();
    }

    /**
     * 获取携带日期格式路径
     *
     * @param dir 原路径
     * @return 原路径追加日期后的路径
     */
    protected FileDirectoryUtil.DirMeta getDirWithDate(String dir) {
        return FileDirectoryUtil.createDir(dir);
    }

    /**
     * 返回 将文件压缩成ZIP包数据流
     *
     * @param docFileNames 需要压缩的文件名称数组
     * @return ZIP数据流
     */
    protected ResponseEntity<InputStreamResource> getZipFile(List<String> docFileNames) {
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
     * @return PDF URL路径： 如果为NULL则前端不处理
     */
    protected String getPrintPdf(List<String> pdfFileNames) {
        if (CollectionUtils.isEmpty(pdfFileNames)) {
            log.warn("Can not find any pdf files");
            return null;
        }

        FileDirectoryUtil.DirMeta dirMeta = getDirWithDate(docPrintFileTarget);
        String targetPdfFileName = getDateTimeFileName(pdfFileNames.size()) + DocConstants.DocType.PDF.getSuffixName();

        try {
            PdfUtil.mergeFiles(pdfFileNames.toArray(new String[]{}),
                    dirMeta.getPath() + File.separator + targetPdfFileName);

            return docDomain + dirMeta.getDate() + "/" + targetPdfFileName;

        } catch (IOException | DocumentException e) {
            log.error("pdfFileNames[{}] doc print pdf merge failed", pdfFileNames, e);
            return null;
        }
    }

}
