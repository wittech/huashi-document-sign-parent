package com.louis.kitty.admin.office;

import com.louis.kitty.admin.constants.DocConstants;
import com.louis.kitty.admin.model.DocCommonModel;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Map;

@Component
public class MaritalStatusProofTool extends AbstractOfficeTool {

    private String setDivorceTypes(Integer divorceType) {
        String divorceTypeDes = "";
        if (divorceType == null) {
            divorceTypeDes = "☐协议离婚   ☐诉讼离婚";
        } else if (divorceType == 1) {
            divorceTypeDes = "☑协议离婚   ☐诉讼离婚";
        } else if (divorceType == 2) {
            divorceTypeDes = "☐协议离婚   ☑诉讼离婚";
        }

        return divorceTypeDes;
    }

    /**
     * 婚姻状况（0、未婚）（1、已婚）（2、离异未婚）（3、丧偶未婚）（4、其他）
     */
    private String maritalStatus(Integer maritalStatus) {
        if(maritalStatus == null) {
            return "";
        } else if(maritalStatus == 0) {
            return "未婚";
        } else if(maritalStatus == 1) {
            return "已婚";
        } else if(maritalStatus == 2) {
            return "离异未婚";
        } else if(maritalStatus == 3) {
            return "丧偶未婚";
        } else if(maritalStatus == 4) {
            return "其他";
        }

        return "";
    }

    @Override
    protected void fillVariable(DocCommonModel docCommonModel) {
        Map<String, Object> variables = newRound();

        // 如果婚姻状况为 已婚或其他 则变量全部替换空

        // marital_status
        //婚姻状况（0、未婚）（1、已婚）（2、离异未婚）（3、丧偶未婚）（4、其他）
        variables.put("applyPersonMaritalText", maritalStatus(docCommonModel.getBorrower().getMaritalStatus()));

        // 1.2. related_personnel_information相关人员信息表
        variables.put("applyPersonName", docCommonModel.getBorrower().getName());
        variables.put("applyPersonIdentityNumber", docCommonModel.getBorrower().getIdentityNumber());

        // 转换年月日
        Calendar ca = Calendar.getInstance();
        ca.setTime(docCommonModel.getBorrower().getDivorceTime());

        // 0->1, 2->2, 3->3
        if(docCommonModel.getBorrower().getMaritalStatus() == 0) {
            variables.put("threeChoicesOne", "1");

            variables.put("originalSpouseName", "");
            variables.put("divorceYear", "");
            variables.put("divorceMonth", "");
            variables.put("divorceDay", "");
            variables.put("divorceType", setDivorceTypes(null));
            variables.put("originalSpouseName2", "");
            variables.put("divorceYear2", "");
            variables.put("divorceMonth2", "");
            variables.put("divorceDay2", "");

        } else if(docCommonModel.getBorrower().getMaritalStatus() == 2) {
            variables.put("threeChoicesOne", "2");

            variables.put("originalSpouseName", docCommonModel.getBorrower().getOriginalSpouseName());
            variables.put("divorceYear", ca.get(Calendar.YEAR));
            variables.put("divorceMonth", ca.get(Calendar.MONTH));
            variables.put("divorceDay", ca.get(Calendar.DAY_OF_MONTH));
            variables.put("divorceType", setDivorceTypes(docCommonModel.getBorrower().getDivorceMethod()));

            variables.put("originalSpouseName2", "");
            variables.put("divorceYear2", "");
            variables.put("divorceMonth2", "");
            variables.put("divorceDay2", "");

        } else if(docCommonModel.getBorrower().getMaritalStatus() == 3) {
            variables.put("threeChoicesOne", "3");

            variables.put("originalSpouseName2", docCommonModel.getBorrower().getOriginalSpouseName());
            variables.put("divorceYear2", ca.get(Calendar.YEAR));
            variables.put("divorceMonth2", ca.get(Calendar.MONTH));
            variables.put("divorceDay2", ca.get(Calendar.DAY_OF_MONTH));

            variables.put("originalSpouseName", "");
            variables.put("divorceYear", "");
            variables.put("divorceMonth", "");
            variables.put("divorceDay", "");
        }

    }

    @Override
    protected String modelFileName() {
        return "婚姻状况声明";
    }

    @Override
    protected int sort() {
        return 1_5_00;
    }

    @Override
    protected DocConstants.DocType docType() {
        return DocConstants.DocType.WORD;
    }
}
