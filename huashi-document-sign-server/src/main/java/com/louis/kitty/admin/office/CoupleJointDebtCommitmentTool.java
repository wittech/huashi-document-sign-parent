package com.louis.kitty.admin.office;

import com.louis.kitty.admin.constants.BankConstants;
import com.louis.kitty.admin.constants.DocConstants;
import com.louis.kitty.admin.model.DocCommonModel;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CoupleJointDebtCommitmentTool extends AbstractOfficeTool {

    @Override
    protected void fillVariable(DocCommonModel docCommonModel) {
        // 如果无配偶，则文档不生成
        if (docCommonModel.getBorrowerCouple() == null) {
            return;
        }

        Map<String, Object> variables = newRound();
        variables.put("bankBranchName", BankConstants.BANK_BRANCH_NAME);
        variables.put("applyPersonName", docCommonModel.getBorrower().getName());
        variables.put("applyPersonIdentityNumber", docCommonModel.getBorrower().getIdentityNumber());
        variables.put("coupleName", docCommonModel.getBorrowerCouple().getName());
        variables.put("coupleIdentityNumber", docCommonModel.getBorrowerCouple().getIdentityNumber());
        variables.put("coupleContactNumber", docCommonModel.getBorrowerCouple().getContactNumber());

        // 1.16. contract_information合同信息表
        variables.put("personalLoanContractNo", docCommonModel.getContractInformation().getPersonalLoanContractNo());
        variables.put("applyMoneyRMB", docCommonModel.getApplyMoneyRMB());
        variables.put("applicationPeriod", docCommonModel.getLoanBusinessInformation().getApplicationPeriod());
    }

    @Override
    protected String modelFileName() {
        return "借款人配偶共同债务承诺书";
    }

    @Override
    protected int sort() {
        return 2_4_00;
    }

    @Override
    protected DocConstants.DocType docType() {
        return DocConstants.DocType.WORD;
    }

    @Override
    protected DocConstants.DocCategory category() {
        return DocConstants.DocCategory.SIGNATURE_MARK;
    }
}
