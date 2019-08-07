package com.louis.kitty.admin.office;

import com.louis.kitty.admin.constants.DocConstants;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class FaceToFaceConversationTool extends AbstractOfficeTool {

    @Override
    protected void fillVariable(Long basisLoanId) {
        Map<String, Object> variables = newRound();
        variables.put("bankBranchName", "城北支行");
        variables.put("applyFamilyPersonName", "罗永芳、唐建国");
        variables.put("guaranteeNames", "'罗永芳、唐建国");
        variables.put("moneyUsage", "'贷款经营池塘");
    }

    @Override
    protected String modelFileName() {
        return "个人借款面谈记录";
    }

    @Override
    protected int sort() {
        return 1_9_0;
    }

    @Override
    protected DocConstants.DocType docType() {
        return DocConstants.DocType.WORD;
    }
}
