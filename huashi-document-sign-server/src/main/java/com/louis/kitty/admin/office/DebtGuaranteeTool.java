package com.louis.kitty.admin.office;

import com.alibaba.druid.util.StringUtils;
import com.louis.kitty.admin.constants.DocConstants;
import org.springframework.stereotype.Component;

@Component
public class DebtGuaranteeTool extends AbstractOfficeTool {

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
        VARIABLES_IN_MODEL.put("applyPersonName", "张三");
        VARIABLES_IN_MODEL.put("applyPersonIdentityNumber", "1427331888xxxxxx");
        VARIABLES_IN_MODEL.put("applyPersonMaritalText", "离异未再婚");
        VARIABLES_IN_MODEL.put("threeChoicesOne", "2");
        VARIABLES_IN_MODEL.put("originalSpouseName", "翠花");
        VARIABLES_IN_MODEL.put("divorceYear", "2019");
        VARIABLES_IN_MODEL.put("divorceMonth", "5");
        VARIABLES_IN_MODEL.put("divorceDay", "6");
        VARIABLES_IN_MODEL.put("divorceType", setDivorceTypes(""));
        VARIABLES_IN_MODEL.put("originalSpouseName2", "翠花");
        VARIABLES_IN_MODEL.put("divorceYear2", "2019");
        VARIABLES_IN_MODEL.put("divorceMonth2", "5");
        VARIABLES_IN_MODEL.put("divorceDay2", "6");
    }

    @Override
    protected String modelFileName() {
        return "借款保证承诺书（个人）";
    }

    @Override
    protected int sort() {
        return 1_3_0;
    }

    @Override
    protected DocConstants.DocType docType() {
        return DocConstants.DocType.WORD;
    }
}
