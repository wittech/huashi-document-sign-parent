package com.louis.kitty.admin.office;

import com.louis.kitty.admin.constants.DocConstants;
import com.louis.kitty.admin.util.RmbUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 广西农村合作金融机构信贷业务呈批表
 */

@Component
public class LoanApprovalTool extends AbstractOfficeTool{


    @Override
    protected void fillVariable(Long basisLoanId) {
        VARIABLES_IN_MODEL.put("contractNo", System.currentTimeMillis() + "");
        VARIABLES_IN_MODEL.put("applyTime", "2019年6月14日");
        VARIABLES_IN_MODEL.put("bankBranchName", "广西桂林漓江农村合作银行城北支行");
        VARIABLES_IN_MODEL.put("bankPhone", "0773-2624239");
        VARIABLES_IN_MODEL.put("applyPersonName", "罗永芳");
        VARIABLES_IN_MODEL.put("applyPersonNo", "10226292846");
        VARIABLES_IN_MODEL.put("applySubject", "个人经营性贷款");
        VARIABLES_IN_MODEL.put("applyMoney", "2000000");
        VARIABLES_IN_MODEL.put("moneyUsage", "流动资金");
        VARIABLES_IN_MODEL.put("deadlineMonth", "36");
        VARIABLES_IN_MODEL.put("deadlineYear", "叁年");
        VARIABLES_IN_MODEL.put("applyRate", "7.6%");
        VARIABLES_IN_MODEL.put("marginRate", "0%");
        VARIABLES_IN_MODEL.put("guarantee", "抵押");
        VARIABLES_IN_MODEL.put("isNewer", "是");
        VARIABLES_IN_MODEL.put("isNewerDes", VARIABLES_IN_MODEL.get("isNewer").toString().equals("是") ? "新增贷款" : "续贷");

        VARIABLES_IN_MODEL.put("originBalance", "0");
        VARIABLES_IN_MODEL.put("applyMoneyRMB", RmbUtil.number2CNMontrayUnit(new BigDecimal(VARIABLES_IN_MODEL.get("applyMoney").toString())));
        VARIABLES_IN_MODEL.put("floatingRate", "70");
        VARIABLES_IN_MODEL.put("payBackMethod", "协议还本");

        List<Map<String, Object>> collateralList = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            Map<String, Object> tempMap = new HashMap<>();
            tempMap.put("no", i + 1);
            tempMap.put("name", "秀峰区中山中路38号智能办公大厦五层503号、504号办公用房" + i);
            tempMap.put("personName", "王" + i);
            tempMap.put("unit", "320.55㎡");
            tempMap.put("money", "3093300");
            collateralList.add(tempMap);
        }

        setCollateralList(collateralList);

        List<Map<String, Object>> guarantorList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Map<String, Object> tempMap = new HashMap<>();
            tempMap.put("no", i + 1);
            tempMap.put("personName", "王" + i);
            tempMap.put("personCustomerNo", System.currentTimeMillis() + "_" + (i + 1));
            guarantorList.add(tempMap);
        }

        setGuarantorList(guarantorList);

        VARIABLES_IN_MODEL.put("applyPersonMerge", collateralList.size() + 5);
        VARIABLES_IN_MODEL.put("collateralMerge", collateralList.size() + 1);
    }

    private void setCollateralList(List<Map<String, Object>> collateralList) {
        if (CollectionUtils.isEmpty(collateralList)) {
            VARIABLES_IN_MODEL.put("collateralList", "");
            return;
        }

        StringBuilder data = new StringBuilder();
        for (Map<String, Object> map : collateralList) {

            data.append("<Row ss:Height=\"44\">")
                    .append("<Cell ss:Index=\"3\" ss:StyleID=\"s63\">")
                    .append("<Data ss:Type=\"Number\">").append(map.get("no")).append("</Data>")
                    .append("</Cell>")
                    .append("<Cell ss:StyleID=\"s115\" ss:MergeAcross=\"2\">")
                    .append("<Data ss:Type=\"String\">").append(map.get("name")).append("</Data>")
                    .append("</Cell>")
                    .append("<Cell ss:StyleID=\"s116\" ss:MergeAcross=\"3\">")
                    .append("<Data ss:Type=\"String\">").append(map.get("personName")).append("</Data>")
                    .append("</Cell>")
                    .append("<Cell ss:StyleID=\"s117\" ss:MergeAcross=\"1\">")
                    .append("<ss:Data xmlns=\"http://www.w3.org/TR/REC-html40\" ss:Type=\"String\">")
                    .append(map.get("unit")).append("</ss:Data>")
                    .append("</Cell>")
                    .append("<Cell ss:StyleID=\"s118\" ss:MergeAcross=\"4\">")
                    .append("<Data ss:Type=\"Number\">").append(map.get("money")).append("</Data>")
                    .append("</Cell>")
                    .append("</Row>");
        }
        VARIABLES_IN_MODEL.put("collateralList", data.toString());
    }

    private void setGuarantorList(List<Map<String, Object>> guarantorList) {
        if (CollectionUtils.isEmpty(guarantorList)) {
            VARIABLES_IN_MODEL.put("guarantorList", "");
            return;
        }

        StringBuilder data = new StringBuilder();
        for (Map<String, Object> map : guarantorList) {

            data.append("<Row ss:Height=\"16\">")
                    .append("<Cell ss:StyleID=\"s55\"/>")
                    .append("<Cell ss:StyleID=\"s66\"/>")
                    .append("<Cell ss:StyleID=\"s63\">")
                    .append("<Data ss:Type=\"Number\">").append(map.get("no")).append("</Data>")
                    .append("</Cell>")
                    .append("<Cell ss:StyleID=\"s121\" ss:MergeAcross=\"6\">")
                    .append("<Data ss:Type=\"String\">").append(map.get("personName")).append("</Data>")
                    .append("</Cell>")
                    .append("<Cell ss:StyleID=\"s122\" ss:MergeAcross=\"6\">")
                    .append("<Data ss:Type=\"String\">").append(map.get("personCustomerNo")).append("</Data>")
                    .append("</Cell>")
                    .append("</Row>");
        }
        VARIABLES_IN_MODEL.put("guarantorList", data.toString());
    }

    @Override
    protected String modelFileName() {
        return "信贷业务呈批表";
    }

    @Override
    protected DocConstants.DocType docType() {
        return DocConstants.DocType.EXCEL;
    }

    @Override
    protected int sort() {
        return 1_0_0;
    }
}
