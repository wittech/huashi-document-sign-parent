package com.louis.kitty.admin.sevice.impl;

import com.alibaba.fastjson.JSON;
import com.louis.kitty.admin.dao.LoanDocMapper;
import com.louis.kitty.admin.model.DocCommonModel;
import com.louis.kitty.admin.model.LoanBasis;
import com.louis.kitty.admin.model.LoanDoc;
import com.louis.kitty.admin.office.*;
import com.louis.kitty.admin.sevice.LoanDocService;
import com.louis.kitty.core.page.ColumnFilter;
import com.louis.kitty.core.page.MybatisPageHelper;
import com.louis.kitty.core.page.PageRequest;
import com.louis.kitty.core.page.PageResult;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Future;

@Service
public class LoanDocServiceImpl extends AbstractDocService implements LoanDocService {

    @Resource
    private LoanDocMapper loanDocMapper;

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
    @Autowired
    private PersonalLoanInvestigationReportTool personalLoanInvestigationReportTool;
    @Autowired
    private LoanPhotoTool loanPhotoTool;

    private DocCommonModel pickupModel(Long loanBasisId) {
        LoanBasis loanBasis = getLoanBais(loanBasisId);
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

    @Override
    protected List<Future<Boolean>> asyncExecute(DocCommonModel model) {
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
            futureList.add(personalLoanInvestigationReportTool.execute(model));
            futureList.add(loanPhotoTool.execute(model));
        } catch (Exception e) {
            log.error("async execute doc build failed by model[{}]", JSON.toJSONString(model), e);
        }

        log.info("async building docs end...");
        return futureList;
    }

    private List<String> findFileNamesByIds(String loanDocIds, boolean isPdf) {
        if (StringUtils.isEmpty(loanDocIds)) {
            log.error("loanDocIds[{}] is empty", loanDocIds);
            return null;
        }

        String[] loanDocIdArray = loanDocIds.split(",");
        List<LoanDoc> loanDocList = loanDocMapper.findByIds(Arrays.asList(loanDocIdArray));

        List<String> fileNames = new ArrayList<>();
        for (LoanDoc loanDoc : loanDocList) {
            if (loanDoc == null) {
                continue;
            }

            if (isPdf) {
                fileNames.add(loanDoc.getPdfPath());
            } else {
                fileNames.add(loanDoc.getDocPath());
            }
        }

        return fileNames;
    }

    @Override
    public ResponseEntity<InputStreamResource> download(String loanDocIds) {
        List<String> fileNames = findFileNamesByIds(loanDocIds, false);
        if (CollectionUtils.isEmpty(fileNames)) {
            log.warn("Can not find any data by loanDocIds[{}]", loanDocIds);
            return null;
        }

        ResponseEntity<InputStreamResource> resourceResponseEntity = getZipFile(fileNames);
        if (resourceResponseEntity != null) {
            addOneIfDownload(loanDocIds);
        }

        return resourceResponseEntity;
    }

    @Override
    public String print(String loanDocIds, String watermark) {
        List<String> fileNames = findFileNamesByIds(loanDocIds, true);
        if (CollectionUtils.isEmpty(fileNames)) {
            log.warn("Can not find any data by loanDocIds[{}]", loanDocIds);
            return null;
        }

        String pdfUrl = getPrintPdf(fileNames, watermark);
        if (StringUtils.isNotEmpty(pdfUrl)) {
            addOneIfPrint(loanDocIds);
        }

        return pdfUrl;
    }

    @Override
    public List<LoanDoc> queryByLoanBasisId(Long loanBasisId, String category) {
        List<String> categories = null;
        if (StringUtils.isNotEmpty(category)) {
            categories = Arrays.asList(category.split(","));
        }

        return loanDocMapper.findByLoanBasisId(loanBasisId, categories);
    }

    private void addOneIfDownload(String loanDocIds) {
        if (StringUtils.isEmpty(loanDocIds)) {
            return;
        }

        loanDocMapper.addOneIfDownload(Arrays.asList(loanDocIds.split(",")));
    }

    private void addOneIfPrint(String loanDocIds) {
        if (StringUtils.isEmpty(loanDocIds)) {
            return;
        }

        loanDocMapper.addOneIfPrint(Arrays.asList(loanDocIds.split(",")));
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
