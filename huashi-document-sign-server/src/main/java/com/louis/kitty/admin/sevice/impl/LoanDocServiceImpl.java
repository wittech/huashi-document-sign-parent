package com.louis.kitty.admin.sevice.impl;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.itextpdf.text.DocumentException;
import com.louis.kitty.admin.constants.DocConstants;
import com.louis.kitty.admin.constants.LoanConstants;
import com.louis.kitty.admin.dao.LoanDocMapper;
import com.louis.kitty.admin.model.*;
import com.louis.kitty.admin.office.*;
import com.louis.kitty.admin.sevice.*;
import com.louis.kitty.admin.util.*;
import com.louis.kitty.core.page.ColumnFilter;
import com.louis.kitty.core.page.MybatisPageHelper;
import com.louis.kitty.core.page.PageRequest;
import com.louis.kitty.core.page.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Slf4j
@Service
public class LoanDocServiceImpl implements LoanDocService {

    @Value("${storage.model.download}")
    private String docDownloadFileTarget;

    @Value("${storage.model.print}")
    private String docPrintFileTarget;

    @Value("${storage.model.domain}")
    private String docDomain;

    @Resource
    private LoanDocMapper loanDocMapper;
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

    @Autowired
    private AuthenticityCommitmentTool authenticityCommitmentTool;
    @Autowired
    private AuthorizationLetterTool authorizationLetterTool;
    @Autowired
    private BusinessCooperationAgreementTool businessCooperationAgreementTool;
    @Autowired
    private CollateralNotRentGuaranteeTool collateralNotRentGuaranteeTool;
    @Autowired
    private ContractReceiptTool contractReceiptTool;
    @Autowired
    private CoupleJointDebtCommitmentTool coupleJointDebtCommitmentTool;
    @Autowired
    private DebtConfirmationTool debtConfirmationTool;
    @Autowired
    private DebtGuaranteeTool debtGuaranteeTool;
    @Autowired
    private FaceToFaceConversationTool faceToFaceConversationTool;
    @Autowired
    private HonestyNotificationTool honestyNotificationTool;
    @Autowired
    private ImmovablesRegistrationTool immovablesRegistrationTool;
    @Autowired
    private LenderRelationshipTool lenderRelationshipTool;
    @Autowired
    private LoanApprovalTool loanApprovalTool;
    @Autowired
    private LoanMortgagePledgeTool loanMortgagePledgeTool;
    @Autowired
    private MaritalStatusProofTool maritalStatusProofTool;
    @Autowired
    private MortgageGuaranteeContractTool mortgageGuaranteeContractTool;
    @Autowired
    private MortgageListTool mortgageListTool;
    @Autowired
    private MortgageQuartetAgreementTool mortgageQuartetAgreementTool;
    @Autowired
    private PersonalLoanApplicationTool personalLoanApplicationTool;
    @Autowired
    private PersonalLoanContractTool personalLoanContractTool;
    @Autowired
    private SuretyBondsContractTool suretyBondsContractTool;
    @Autowired
    private ValuationConfirmationTool valuationConfirmationTool;
    @Autowired
    private WithdrawalCertificateTool withdrawalCertificateTool;


    private DocCommonModel pickupModel(Long loanBasisId) {
        LoanBasis loanBasis = loanBasisService.findById(loanBasisId);
        if (loanBasis == null) {
            log.warn("Can not find any data by id[{}]", loanBasisId);
            return null;
        }

        DocCommonModel model = new DocCommonModel();
        model.setLoanBasis(loanBasis);

        // 相关人信息数据
        setRelatedPersonnelInformations(model);

        // 借贷业务信息
        setLoanBusinessInformation(model);

        // 设置合同信息
        setContractInformation(model);

        // 设置抵押物信息
        setPawnList(model);

        // 还款计划
        setRepaymentPlanList(model);

        // 交易对手
        setCounterpartyInformationList(model);

        return model;
    }

    private void setRelatedPersonnelInformations(DocCommonModel model) {
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

    private void setLoanBusinessInformation(DocCommonModel model) {
        LoanBusinessInformation loanBusinessInformation = loanBusinessInformationService.findByBasisId(model.getLoanBasicId());
        if (loanBusinessInformation == null) {
            return;
        }

        model.setLoanBusinessInformation(loanBusinessInformation);
    }

    private void setContractInformation(DocCommonModel model) {
        ContractInformation contractInformation = contractInformationService.findByLoanBasisId(model.getLoanBasicId());
        if (contractInformation == null) {
            return;
        }

        model.setContractInformation(contractInformation);
    }

    private void setPawnList(DocCommonModel model) {
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

    private void setRepaymentPlanList(DocCommonModel model) {
        List<RepaymentPlan> repaymentPlanList = repaymentPlanService.findByIoanBusinessInformationId(model.getLoanBusinessInformationId());
        if (CollectionUtils.isEmpty(repaymentPlanList)) {
            return;
        }

        model.setRepaymentPlanList(repaymentPlanList);
    }

    private void setCounterpartyInformationList(DocCommonModel model) {
        List<CounterpartyInformation> counterpartyInformationList = counterpartyInformationService.findByIoanBusinessInformationId(model.getLoanBusinessInformationId());
        if (CollectionUtils.isEmpty(counterpartyInformationList)) {
            return;
        }

        model.setCounterpartyInformationList(counterpartyInformationList);
    }

    @Override
    public int born(Long loanBasisId) throws Exception {
        if (loanBasisId == null) {
            throw new IllegalArgumentException("参数为空");
        }

        DocCommonModel model = pickupModel(loanBasisId);
        if (model == null) {
            log.warn("pickupModel by loanBasisId[{}] null", loanBasisId);
            return 0;
        }

        long startTime = System.currentTimeMillis();
        try {

            // 清除原有记录,后续要考虑持续追加的类型，不能直接删除
            loanDocMapper.deleteByLoanBasisId(loanBasisId);

            List<Future<Boolean>> futureList = asyncExecute(model);

            return getResult(futureList);
        } finally {
            log.info("build doc process cost {} ms", (System.currentTimeMillis() - startTime));
        }
    }

    private int getResult(List<Future<Boolean>> futureList) {
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

    private List<Future<Boolean>> asyncExecute(DocCommonModel model) {
        List<Future<Boolean>> futureList = new ArrayList<>();
        try {
            log.info("async building docs start...");
            futureList.add(authenticityCommitmentTool.execute(model));
            futureList.add(authorizationLetterTool.execute(model));
            futureList.add(businessCooperationAgreementTool.execute(model));
            futureList.add(collateralNotRentGuaranteeTool.execute(model));
            futureList.add(contractReceiptTool.execute(model));
            futureList.add(coupleJointDebtCommitmentTool.execute(model));
            futureList.add(debtConfirmationTool.execute(model));
            futureList.add(debtGuaranteeTool.execute(model));
            futureList.add(faceToFaceConversationTool.execute(model));
            futureList.add(honestyNotificationTool.execute(model));
            futureList.add(immovablesRegistrationTool.execute(model));
            futureList.add(lenderRelationshipTool.execute(model));
            futureList.add(loanApprovalTool.execute(model));
            futureList.add(loanMortgagePledgeTool.execute(model));
            futureList.add(maritalStatusProofTool.execute(model));
            futureList.add(mortgageGuaranteeContractTool.execute(model));
            futureList.add(mortgageListTool.execute(model));
            futureList.add(mortgageQuartetAgreementTool.execute(model));
            futureList.add(personalLoanApplicationTool.execute(model));
            futureList.add(personalLoanContractTool.execute(model));
            futureList.add(suretyBondsContractTool.execute(model));
            futureList.add(valuationConfirmationTool.execute(model));
            futureList.add(withdrawalCertificateTool.execute(model));
        } catch (Exception e) {
            log.error("async execute doc build failed by model[{}]", JSON.toJSONString(model), e);
        }

        log.info("async building docs end...");
        return futureList;
    }

    private String getDateTimeFileName(int size) {
        return new SimpleDateFormat("yyyyMMddHHmmSS").format(new Date()) + "-" + size
                + "-" + RandomUtil.randomCode();
    }

    private String getDirWithDate(String dir) {
        return FileDirectoryUtil.createDir(dir).getPath() + File.separator;
    }

    @Override
    public ResponseEntity<InputStreamResource> download(String loanDocIds) {
        if (StringUtils.isEmpty(loanDocIds)) {
            log.error("loanDocIds[{}] is empty", loanDocIds);
            return null;
        }

        String[] loanDocIdArray = loanDocIds.split(",");
        List<LoanDoc> loanDocList = loanDocMapper.findByIds(Arrays.asList(loanDocIdArray));

        List<String> zipFileNames = new ArrayList<>();
        for (LoanDoc loanDoc : loanDocList) {
            if (loanDoc == null) {
                continue;
            }

            zipFileNames.add(loanDoc.getDocPath());
        }

        String targetFileName = getDateTimeFileName(loanDocList.size()) + DocConstants.DocType.ZIP.getSuffixName();
        String targetFileFullName = getDirWithDate(docDownloadFileTarget) + targetFileName;

        boolean isZipOk = ZipUtil.zip(zipFileNames.toArray(new String[]{}), targetFileFullName);
        if (!isZipOk) {
            log.error("loanDocIds[{}] zip failed", loanDocIds);
            return null;
        }

        addOneIfDownload(loanDocIds);

        return FileDownloadUtil.download(targetFileFullName, targetFileName);
    }

    @Override
    public String print(String loanDocIds) {
        if (StringUtils.isEmpty(loanDocIds)) {
            log.error("loanDocIds[{}] is empty", loanDocIds);
            return null;
        }

        String[] loanDocIdArray = loanDocIds.split(",");
        List<LoanDoc> loanDocList = loanDocMapper.findByIds(Arrays.asList(loanDocIdArray));

        List<String> pdfFileNames = new ArrayList<>();
        for (LoanDoc loanDoc : loanDocList) {
            if (loanDoc == null) {
                continue;
            }

            pdfFileNames.add(loanDoc.getPdfPath());
        }

        String targetPdfFileName = getDateTimeFileName(loanDocList.size()) + DocConstants.DocType.PDF.getSuffixName();

        try {
            PdfUtil.mergeFiles(pdfFileNames.toArray(new String[]{}),
                    getDirWithDate(docPrintFileTarget) + targetPdfFileName);

            return docDomain + FileDirectoryUtil.getDate() + "/" + targetPdfFileName;

        } catch (IOException | DocumentException e) {
            log.error("loanDocIds[{}] doc print failed", loanDocIds, e);
            return null;
        }
    }

    @Override
    public ResponseEntity<InputStreamResource> downloadAllDoc(Long loaBasisId) {
        return null;
    }

    @Override
    public List<LoanDoc> queryByLoanBasisId(Long loanBasisId) {
        return loanDocMapper.findByLoanBasisId(loanBasisId);
    }

    @Override
    public boolean addOneIfDownload(String loanDocIds) {
        if (StringUtils.isEmpty(loanDocIds)) {
            return false;
        }

        return loanDocMapper.addOneIfDownload(Arrays.asList(loanDocIds.split(","))) > 0;
    }

    @Override
    public boolean addOneIfPrint(String loanDocIds) {
        if (StringUtils.isEmpty(loanDocIds)) {
            return false;
        }

        return loanDocMapper.addOneIfPrint(Arrays.asList(loanDocIds.split(","))) > 0;
    }

    @Override
    public int save(LoanDoc record) {
        if (record.getId() == null || record.getId() == 0) {
            return loanDocMapper.add(record);
        }

        return loanDocMapper.update(record);
    }

    @Override
    public int delete(LoanDoc record) {
        return loanDocMapper.delete(record.getId());
    }

    @Override
    public int delete(List<LoanDoc> records) {
        for (LoanDoc record : records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public LoanDoc findById(Long id) {
        return loanDocMapper.findById(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        ColumnFilter columnFilter = pageRequest.getColumnFilter("name");
        if (columnFilter != null) {
            return MybatisPageHelper.findPage(pageRequest, loanDocMapper, "findPageByName", columnFilter.getValue());
        }
        return MybatisPageHelper.findPage(pageRequest, loanDocMapper);
    }
}
