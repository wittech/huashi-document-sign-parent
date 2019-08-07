package com.louis.kitty.admin.office;

import com.alibaba.druid.util.StringUtils;
import com.louis.kitty.admin.constants.DocConstants;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class MaritalStatusProofTool extends AbstractOfficeTool {

    private String setDivorceTypes(String divorceType) {
        String divorceTypeDes = "";
        if (StringUtils.isEmpty(divorceType)) {
            divorceTypeDes = "☐协议离婚   ☐诉讼离婚";
        } else if ("协议离婚".equals(divorceType)) {
            divorceTypeDes = "☑协议离婚   ☐诉讼离婚";
        } else if ("诉讼离婚".equals(divorceType)) {
            divorceTypeDes = "☐协议离婚   ☑诉讼离婚";
        }

        return divorceTypeDes;
    }

    @Override
    protected void fillVariable(Long basisLoanId) {
        Map<String, Object> variables = newRound();
        variables.put("applyPersonName", "张三");
        variables.put("applyPersonIdentityNumber", "1427331888xxxxxx");
        variables.put("applyPersonMaritalText", "离异未再婚");
        variables.put("threeChoicesOne", "2");
        variables.put("originalSpouseName", "翠花");
        variables.put("divorceYear", "2019");
        variables.put("divorceMonth", "5");
        variables.put("divorceDay", "6");
        variables.put("divorceType", setDivorceTypes(""));
        variables.put("originalSpouseName2", "翠花");
        variables.put("divorceYear2", "2019");
        variables.put("divorceMonth2", "5");
        variables.put("divorceDay2", "6");
    }

    @Override
    protected String modelFileName() {
        return "婚姻状况声明";
    }

    @Override
    protected int sort() {
        return 1_2_0;
    }

    @Override
    protected DocConstants.DocType docType() {
        return DocConstants.DocType.WORD;
    }
}
