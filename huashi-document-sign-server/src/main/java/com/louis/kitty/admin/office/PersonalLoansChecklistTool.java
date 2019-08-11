package com.louis.kitty.admin.office;

import com.louis.kitty.admin.constants.DocConstants;
import com.louis.kitty.admin.model.DocCommonModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PersonalLoansChecklistTool extends AbstractOfficeTool {

    private String setExistsOption(Boolean exists) {
        String existsDes;
        if (exists == null) {
            existsDes = "有□无□";
        } else if (exists) {
            existsDes = "有☑无□";
        } else {
            existsDes = "有□无☑";
        }

        return existsDes;
    }

    private String setRightOption(Boolean right) {
        String rightDes;
        if (right == null) {
            rightDes = "是□否□";
        } else if (right) {
            rightDes = "是☑否□";
        } else {
            rightDes = "是□否☑";
        }

        return rightDes;
    }

    private void setNoImplementedList(List<Map<String, Object>> noImplementedList, Map<String, Object> variables) {
        StringBuilder data = new StringBuilder();
        int index = 0;
        for (Map<String, Object> noImplemented : noImplementedList) {
            index++;
            data.append("<w:p>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\" w:cs=\"宋体\"/>\n" +
                    "\t  <w:kern w:val=\"0\"/>\n" +
                    "\t  <w:sz w:val=\"20\"/>\n" +
                    "\t  <w:szCs w:val=\"20\"/>\n" +
                    "\t  <w:lang w:bidi=\"ar\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t>" + (index) + ".未落实</w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\" w:cs=\"宋体\"/>\n" +
                    "\t  <w:kern w:val=\"0\"/>\n" +
                    "\t  <w:sz w:val=\"20\"/>\n" +
                    "\t  <w:szCs w:val=\"20\"/>\n" +
                    "\t  <w:u w:val=\"single\"/>\n" +
                    "\t  <w:lang w:bidi=\"ar\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t xml:space=\"preserve\">"+noImplemented.get("item")+"</w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\" w:cs=\"宋体\"/>\n" +
                    "\t  <w:kern w:val=\"0\"/>\n" +
                    "\t  <w:sz w:val=\"20\"/>\n" +
                    "\t  <w:szCs w:val=\"20\"/>\n" +
                    "\t  <w:lang w:bidi=\"ar\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t xml:space=\"preserve\"> ，原因：</w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\" w:cs=\"宋体\"/>\n" +
                    "\t  <w:kern w:val=\"0\"/>\n" +
                    "\t  <w:sz w:val=\"20\"/>\n" +
                    "\t  <w:szCs w:val=\"20\"/>\n" +
                    "\t  <w:u w:val=\"single\"/>\n" +
                    "\t  <w:lang w:bidi=\"ar\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t xml:space=\"preserve\">"+noImplemented.get("reason")+"</w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\" w:cs=\"宋体\"/>\n" +
                    "\t  <w:kern w:val=\"0\"/>\n" +
                    "\t  <w:sz w:val=\"20\"/>\n" +
                    "\t  <w:szCs w:val=\"20\"/>\n" +
                    "\t  <w:lang w:bidi=\"ar\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t xml:space=\"preserve\"> ，拟采取措施</w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\" w:cs=\"宋体\"/>\n" +
                    "\t  <w:kern w:val=\"0\"/>\n" +
                    "\t  <w:sz w:val=\"20\"/>\n" +
                    "\t  <w:szCs w:val=\"20\"/>\n" +
                    "\t  <w:u w:val=\"single\"/>\n" +
                    "\t  <w:lang w:bidi=\"ar\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t xml:space=\"preserve\">"+noImplemented.get("measures")+"</w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\" w:cs=\"宋体\"/>\n" +
                    "\t  <w:kern w:val=\"0\"/>\n" +
                    "\t  <w:sz w:val=\"20\"/>\n" +
                    "\t  <w:szCs w:val=\"20\"/>\n" +
                    "\t  <w:lang w:bidi=\"ar\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t>；</w:t>\n" +
                    "  </w:r>\n" +
                    "</w:p>");
        }

        variables.put("noImplementedList", data.toString());
    }

    @Override
    protected void fillVariable(DocCommonModel docCommonModel) {
//        Map<String, Object> variables = newRound();
//
//        // 1.17. post_loan_check贷后检查信息表
//        // check_time
//        variables.put("checkTimeYear", "2019");
//        variables.put("checkTimeMonth", "5");
//        variables.put("checkTimeDay", "22");
//
//
//        variables.put("applyPersonName", "罗永芳");
//        variables.put("borrowingStartPeriodYear", "2019");
//        variables.put("borrowingStartPeriodMonth", "5");
//
//        variables.put("borrowingStartPeriodDay", "25");
//        variables.put("borrowingEndPeriodYear", "2022");
//        variables.put("borrowingEndPeriodMonth", "5");
//        variables.put("borrowingEndPeriodDay", "25");
//
//        // 1.1. loan_basis借口人基础信息表   application_matters
//        variables.put("applicationMatters", "抵押贷款NSS");
//        variables.put("moneyUsage", "用于深思可可");
//
//        variables.put("applyMoneyRMB", "贰佰万元整");
//
//        // 抵押、质押、保证
//        variables.put("guaranteeMethodMark1", "√");
//        variables.put("guaranteeMethodMark2", "√");
//        variables.put("guaranteeMethodMark3", "");
//        variables.put("guaranteeMethodMark4", "");
//
//        // 1.17. post_loan_check贷后检查信息表 是否，有无
//        variables.put("paymentMethodWithdrawalCheck", setExistsOption(null));
//        variables.put("contractualAgreementCheck", setExistsOption(null));
//        variables.put("intendedUseCheck", setExistsOption(null));
//
//        variables.put("isComplete", setRightOption(true));
//        variables.put("completeCheck", setRightOption(true));
//        variables.put("hasImplementedCheck", setRightOption(true));
//
//
//        // post_loan_not_implemented
//        List<Map<String, Object>> noImplementedList = new ArrayList<>();
//        Map<String, Object> setNoImplemented = new HashMap<>();
//        setNoImplemented.put("item", "少时诵诗书多所付所");
//        setNoImplemented.put("reason", "ssdfsad发生大幅度");
//        setNoImplemented.put("measures", "oiiduoer");
//        noImplementedList.add(setNoImplemented);
//
//        setNoImplementedList(noImplementedList, variables);
    }

    @Override
    protected String modelFileName() {
        return "个人贷款贷后检查表";
    }

    @Override
    protected int sort() {
        return 3_6_0;
    }

    @Override
    protected DocConstants.DocType docType() {
        return DocConstants.DocType.WORD;
    }
}
