package com.louis.kitty.admin.office;

import com.louis.kitty.admin.constants.BankConstants;
import com.louis.kitty.admin.constants.DocConstants;
import com.louis.kitty.admin.model.DocCommonModel;
import com.louis.kitty.admin.model.RelatedPersonnelInformation;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class DebtConfirmationTool extends AbstractOfficeTool {

    private void guaranteePerson(RelatedPersonnelInformation relatedPersonnelInformation, DocCommonModel docCommonModel) {
        Map<String, Object> variables = newRound();
        variables.put("bankBranchName", BankConstants.BANK_BRANCH_NAME);
        variables.put("guaranteePersonName", relatedPersonnelInformation.getName());
        variables.put("applyPersonName", docCommonModel.getBorrower().getName());
        variables.put("applyMoneyRMB", docCommonModel.getApplyMoneyRMB());
        variables.put("applyMoney", docCommonModel.getLoanBusinessInformation().getApplicationAmount());
        variables.put("moneyUsage", docCommonModel.getLoanBusinessInformation().getDescription());
    }

    @Override
    protected void fillVariable(DocCommonModel docCommonModel) {
        if(CollectionUtils.isNotEmpty(docCommonModel.getGuarantorList())) {
            for(RelatedPersonnelInformation relatedPersonnelInformation : docCommonModel.getGuarantorList()) {
                guaranteePerson(relatedPersonnelInformation, docCommonModel);
            }
        }

        if(CollectionUtils.isNotEmpty(docCommonModel.getMortgageGuarantorList())) {
            for(RelatedPersonnelInformation relatedPersonnelInformation : docCommonModel.getMortgageGuarantorList()) {
                guaranteePerson(relatedPersonnelInformation, docCommonModel);
            }
        }
    }

    @Override
    protected String modelFileName() {
        return "债务（担保）确认书";
    }

    @Override
    protected int sort() {
        return 2_7_00;
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
