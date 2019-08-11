package com.louis.kitty.admin.office;

import com.louis.kitty.admin.constants.BankConstants;
import com.louis.kitty.admin.constants.DocConstants;
import com.louis.kitty.admin.model.DocCommonModel;
import com.louis.kitty.admin.model.RelatedPersonnelInformation;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;

@Component
public class FaceToFaceConversationTool extends AbstractOfficeTool {

    @Override
    protected void fillVariable(DocCommonModel docCommonModel) {
        Map<String, Object> variables = newRound();
        variables.put("bankBranchName", BankConstants.BANK_BRANCH_NAME);
        variables.put("applyFamilyPersonName", docCommonModel.getApplyFamilyName());

        // 1.11
        variables.put("moneyUsage", docCommonModel.getLoanBusinessInformation().getDescription());

        setGuaranteeNames(docCommonModel, variables);
    }

    private void setGuaranteeNames(DocCommonModel docCommonModel, Map<String, Object> variables) {
        String names = "";

        if (CollectionUtils.isNotEmpty(docCommonModel.getGuarantorList())) {
            for (RelatedPersonnelInformation relatedPersonnelInformation : docCommonModel.getGuarantorList()) {
                names += relatedPersonnelInformation.getName() + "、";
            }
        }

        if (CollectionUtils.isNotEmpty(docCommonModel.getMortgageGuarantorList())) {
            for (RelatedPersonnelInformation relatedPersonnelInformation : docCommonModel.getMortgageGuarantorList()) {
                names += relatedPersonnelInformation.getName() + "、";
            }
        }

        variables.put("guaranteeNames", StringUtils.isEmpty(names) ? "" : names.substring(0, names.length() - 1));
    }

    @Override
    protected String modelFileName() {
        return "个人借款面谈记录";
    }

    @Override
    protected int sort() {
        return 1_9_00;
    }

    @Override
    protected DocConstants.DocType docType() {
        return DocConstants.DocType.WORD;
    }
}
