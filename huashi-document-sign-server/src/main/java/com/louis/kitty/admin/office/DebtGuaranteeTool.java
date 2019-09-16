package com.louis.kitty.admin.office;

import com.louis.kitty.admin.constants.BankConstants;
import com.louis.kitty.admin.constants.DocConstants;
import com.louis.kitty.admin.model.DocCommonModel;
import com.louis.kitty.admin.model.RelatedPersonnelInformation;
import com.louis.kitty.admin.util.RmbUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DebtGuaranteeTool extends AbstractOfficeTool {

    private void setGuaranteeListText(List<Map<String, Object>> guaranteeList, Map<String, Object> variables) {
        StringBuilder data = new StringBuilder();
        for (Map<String, Object> guarantee : guaranteeList) {
            data.append("<w:tr>\n" + "  <w:tblPrEx>\n" + "\t<w:tblBorders>\n" + "\t  <w:top w:val=\"single\" w:color=\"auto\" w:sz=\"4\" w:space=\"0\"/>\n" + "\t  <w:left w:val=\"single\" w:color=\"auto\" w:sz=\"4\" w:space=\"0\"/>\n" + "\t  <w:bottom w:val=\"single\" w:color=\"auto\" w:sz=\"4\" w:space=\"0\"/>\n" + "\t  <w:right w:val=\"single\" w:color=\"auto\" w:sz=\"4\" w:space=\"0\"/>\n" + "\t  <w:insideH w:val=\"single\" w:color=\"auto\" w:sz=\"4\" w:space=\"0\"/>\n" + "\t  <w:insideV w:val=\"single\" w:color=\"auto\" w:sz=\"4\" w:space=\"0\"/>\n" + "\t</w:tblBorders>\n" + "\t<w:tblLayout w:type=\"fixed\"/>\n" + "\t<w:tblCellMar>\n" + "\t  <w:top w:w=\"0\" w:type=\"dxa\"/>\n" + "\t  <w:left w:w=\"108\" w:type=\"dxa\"/>\n" + "\t  <w:bottom w:w=\"0\" w:type=\"dxa\"/>\n" + "\t  <w:right w:w=\"108\" w:type=\"dxa\"/>\n" + "\t</w:tblCellMar>\n" + "  </w:tblPrEx>\n" + "  <w:trPr>\n" + "\t<w:trHeight w:val=\"630\" w:hRule=\"atLeast\"/>\n" + "  </w:trPr>\n" + "  <w:tc>\n" + "\t<w:tcPr>\n" + "\t  <w:tcW w:w=\"1800\" w:type=\"dxa\"/>\n" + "\t  <w:noWrap w:val=\"0\"/>\n" + "\t  <w:vAlign w:val=\"top\"/>\n" + "\t</w:tcPr>\n" + "\t<w:p>\n" + "\t  <w:pPr>\n" + "\t\t<w:spacing w:line=\"480\" w:lineRule=\"auto\"/>\n" + "\t\t<w:rPr>\n" + "\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋\" w:hAnsi=\"仿宋\" w:eastAsia=\"仿宋\"/>\n" + "\t\t  <w:szCs w:val=\"21\"/>\n" + "\t\t</w:rPr>\n" + "\t  </w:pPr>\n" + "\t  <w:r>\n" + "\t\t<w:rPr>\n" + "\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋\" w:hAnsi=\"仿宋\" w:eastAsia=\"仿宋\"/>\n" + "\t\t  <w:szCs w:val=\"21\"/>\n" + "\t\t</w:rPr>\n" + "\t\t<w:t>保 证 人 名 称</w:t>\n" + "\t  </w:r>\n" + "\t</w:p>\n" + "  </w:tc>\n" + "  <w:tc>\n" + "\t<w:tcPr>\n" + "\t  <w:tcW w:w=\"3836\" w:type=\"dxa\"/>\n" + "\t  <w:noWrap w:val=\"0\"/>\n" + "\t  <w:vAlign w:val=\"top\"/>\n" + "\t</w:tcPr>\n" + "\t<w:p>\n" + "\t  <w:pPr>\n" + "\t\t<w:spacing w:line=\"480\" w:lineRule=\"auto\"/>\n" + "\t\t<w:rPr>\n" + "\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋\" w:hAnsi=\"仿宋\" w:eastAsia=\"仿宋\"/>\n" + "\t\t  <w:szCs w:val=\"21\"/>\n" + "\t\t</w:rPr>\n" + "\t  </w:pPr>\n" + "\t  <w:r>\n" + "\t\t<w:rPr>\n" + "\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋\" w:hAnsi=\"仿宋\" w:eastAsia=\"仿宋\"/>\n" + "\t\t  <w:szCs w:val=\"21\"/>\n" + "\t\t</w:rPr>\n" + "\t\t<w:t>").append(guarantee.get("name")).append("</w:t>\n").append("\t  </w:r>\n").append("\t</w:p>\n").append("  </w:tc>\n").append("  <w:tc>\n").append("\t<w:tcPr>\n").append("\t  <w:tcW w:w=\"1260\" w:type=\"dxa\"/>\n").append("\t  <w:noWrap w:val=\"0\"/>\n").append("\t  <w:vAlign w:val=\"top\"/>\n").append("\t</w:tcPr>\n").append("\t<w:p>\n").append("\t  <w:pPr>\n").append("\t\t<w:spacing w:line=\"480\" w:lineRule=\"auto\"/>\n").append("\t\t<w:rPr>\n").append("\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋\" w:hAnsi=\"仿宋\" w:eastAsia=\"仿宋\"/>\n").append("\t\t  <w:szCs w:val=\"21\"/>\n").append("\t\t</w:rPr>\n").append("\t  </w:pPr>\n").append("\t  <w:r>\n").append("\t\t<w:rPr>\n").append("\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋\" w:hAnsi=\"仿宋\" w:eastAsia=\"仿宋\"/>\n").append("\t\t  <w:szCs w:val=\"21\"/>\n").append("\t\t</w:rPr>\n").append("\t\t<w:t>配偶名称</w:t>\n").append("\t  </w:r>\n").append("\t</w:p>\n").append("  </w:tc>\n").append("  <w:tc>\n").append("\t<w:tcPr>\n").append("\t  <w:tcW w:w=\"1800\" w:type=\"dxa\"/>\n").append("\t  <w:noWrap w:val=\"0\"/>\n").append("\t  <w:vAlign w:val=\"top\"/>\n").append("\t</w:tcPr>\n").append("\t<w:p>\n").append("\t  <w:pPr>\n").append("\t\t<w:spacing w:line=\"480\" w:lineRule=\"auto\"/>\n").append("\t\t<w:rPr>\n").append("\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋\" w:hAnsi=\"仿宋\" w:eastAsia=\"仿宋\"/>\n").append("\t\t  <w:szCs w:val=\"21\"/>\n").append("\t\t</w:rPr>\n").append("\t  </w:pPr>\n").append("\t  <w:r>\n").append("\t\t<w:rPr>\n").append("\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋\" w:hAnsi=\"仿宋\" w:eastAsia=\"仿宋\"/>\n").append("\t\t  <w:szCs w:val=\"21\"/>\n").append("\t\t</w:rPr>\n").append("\t\t<w:t>").append(guarantee.get("coupleName")).append("</w:t>\n").append("\t  </w:r>\n").append("\t</w:p>\n").append("  </w:tc>\n").append("</w:tr>\n").append("<w:tr>\n").append("  <w:tblPrEx>\n").append("\t<w:tblBorders>\n").append("\t  <w:top w:val=\"single\" w:color=\"auto\" w:sz=\"4\" w:space=\"0\"/>\n").append("\t  <w:left w:val=\"single\" w:color=\"auto\" w:sz=\"4\" w:space=\"0\"/>\n").append("\t  <w:bottom w:val=\"single\" w:color=\"auto\" w:sz=\"4\" w:space=\"0\"/>\n").append("\t  <w:right w:val=\"single\" w:color=\"auto\" w:sz=\"4\" w:space=\"0\"/>\n").append("\t  <w:insideH w:val=\"single\" w:color=\"auto\" w:sz=\"4\" w:space=\"0\"/>\n").append("\t  <w:insideV w:val=\"single\" w:color=\"auto\" w:sz=\"4\" w:space=\"0\"/>\n").append("\t</w:tblBorders>\n").append("\t<w:tblLayout w:type=\"fixed\"/>\n").append("\t<w:tblCellMar>\n").append("\t  <w:top w:w=\"0\" w:type=\"dxa\"/>\n").append("\t  <w:left w:w=\"108\" w:type=\"dxa\"/>\n").append("\t  <w:bottom w:w=\"0\" w:type=\"dxa\"/>\n").append("\t  <w:right w:w=\"108\" w:type=\"dxa\"/>\n").append("\t</w:tblCellMar>\n").append("  </w:tblPrEx>\n").append("  <w:trPr>\n").append("\t<w:trHeight w:val=\"600\" w:hRule=\"atLeast\"/>\n").append("  </w:trPr>\n").append("  <w:tc>\n").append("\t<w:tcPr>\n").append("\t  <w:tcW w:w=\"1800\" w:type=\"dxa\"/>\n").append("\t  <w:noWrap w:val=\"0\"/>\n").append("\t  <w:vAlign w:val=\"top\"/>\n").append("\t</w:tcPr>\n").append("\t<w:p>\n").append("\t  <w:pPr>\n").append("\t\t<w:spacing w:line=\"480\" w:lineRule=\"auto\"/>\n").append("\t\t<w:rPr>\n").append("\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋\" w:hAnsi=\"仿宋\" w:eastAsia=\"仿宋\"/>\n").append("\t\t  <w:szCs w:val=\"21\"/>\n").append("\t\t</w:rPr>\n").append("\t  </w:pPr>\n").append("\t  <w:r>\n").append("\t\t<w:rPr>\n").append("\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋\" w:hAnsi=\"仿宋\" w:eastAsia=\"仿宋\"/>\n").append("\t\t  <w:szCs w:val=\"21\"/>\n").append("\t\t</w:rPr>\n").append("\t\t<w:t>地 址</w:t>\n").append("\t  </w:r>\n").append("\t</w:p>\n").append("  </w:tc>\n").append("  <w:tc>\n").append("\t<w:tcPr>\n").append("\t  <w:tcW w:w=\"3836\" w:type=\"dxa\"/>\n").append("\t  <w:noWrap w:val=\"0\"/>\n").append("\t  <w:vAlign w:val=\"top\"/>\n").append("\t</w:tcPr>\n").append("\t<w:p>\n").append("\t  <w:pPr>\n").append("\t\t<w:rPr>\n").append("\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋\" w:hAnsi=\"仿宋\" w:eastAsia=\"仿宋\"/>\n").append("\t\t  <w:szCs w:val=\"21\"/>\n").append("\t\t</w:rPr>\n").append("\t  </w:pPr>\n").append("\t  <w:r>\n").append("\t\t<w:rPr>\n").append("\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋\" w:hAnsi=\"仿宋\" w:eastAsia=\"仿宋\"/>\n").append("\t\t  <w:szCs w:val=\"21\"/>\n").append("\t\t</w:rPr>\n").append("\t\t<w:t>").append(guarantee.get("address")).append("</w:t>\n").append("\t  </w:r>\n").append("\t</w:p>\n").append("  </w:tc>\n").append("  <w:tc>\n").append("\t<w:tcPr>\n").append("\t  <w:tcW w:w=\"1260\" w:type=\"dxa\"/>\n").append("\t  <w:noWrap w:val=\"0\"/>\n").append("\t  <w:vAlign w:val=\"top\"/>\n").append("\t</w:tcPr>\n").append("\t<w:p>\n").append("\t  <w:pPr>\n").append("\t\t<w:spacing w:line=\"480\" w:lineRule=\"auto\"/>\n").append("\t\t<w:rPr>\n").append("\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋\" w:hAnsi=\"仿宋\" w:eastAsia=\"仿宋\"/>\n").append("\t\t  <w:szCs w:val=\"21\"/>\n").append("\t\t</w:rPr>\n").append("\t  </w:pPr>\n").append("\t  <w:r>\n").append("\t\t<w:rPr>\n").append("\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋\" w:hAnsi=\"仿宋\" w:eastAsia=\"仿宋\"/>\n").append("\t\t  <w:szCs w:val=\"21\"/>\n").append("\t\t</w:rPr>\n").append("\t\t<w:t>联系电话</w:t>\n").append("\t  </w:r>\n").append("\t</w:p>\n").append("  </w:tc>\n").append("  <w:tc>\n").append("\t<w:tcPr>\n").append("\t  <w:tcW w:w=\"1800\" w:type=\"dxa\"/>\n").append("\t  <w:noWrap w:val=\"0\"/>\n").append("\t  <w:vAlign w:val=\"top\"/>\n").append("\t</w:tcPr>\n").append("\t<w:p>\n").append("\t  <w:pPr>\n").append("\t\t<w:spacing w:line=\"480\" w:lineRule=\"auto\"/>\n").append("\t\t<w:rPr>\n").append("\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋\" w:hAnsi=\"仿宋\" w:eastAsia=\"仿宋\"/>\n").append("\t\t  <w:szCs w:val=\"21\"/>\n").append("\t\t</w:rPr>\n").append("\t  </w:pPr>\n").append("\t  <w:r>\n").append("\t\t<w:rPr>\n").append("\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋\" w:hAnsi=\"仿宋\" w:eastAsia=\"仿宋\"/>\n").append("\t\t  <w:szCs w:val=\"21\"/>\n").append("\t\t</w:rPr>\n").append("\t\t<w:t>").append(guarantee.get("mobile")).append("</w:t>\n").append("\t  </w:r>\n").append("\t</w:p>\n").append("  </w:tc>\n").append("</w:tr>");
        }

        variables.put("guaranteeList", data.toString());
    }

    private void setGuaranteeSignatureListText(List<Map<String, Object>> guaranteeSignatureList, Map<String, Object> variables) {
        StringBuilder data = new StringBuilder();
        for (int i = 0; i < guaranteeSignatureList.size(); i++) {
            data.append("<w:p>\n" +
                    "  <w:pPr>\n" +
                    "\t<w:spacing w:line=\"600\" w:lineRule=\"auto\"/>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋\" w:hAnsi=\"仿宋\" w:eastAsia=\"仿宋\"/>\n" +
                    "\t  <w:szCs w:val=\"21\"/>\n" +
                    "\t</w:rPr>\n" +
                    "  </w:pPr>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋\" w:hAnsi=\"仿宋\" w:eastAsia=\"仿宋\"/>\n" +
                    "\t  <w:szCs w:val=\"21\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t>" + (i + 1) + "、保证人 ： （签字及手模）　　　保证人配偶：　　　　　（签字及手模）</w:t>\n" +
                    "  </w:r>\n" +
                    "</w:p>");
        }

        variables.put("guaranteeSignatureList", data.toString());
    }

    @Override
    protected void fillVariable(DocCommonModel docCommonModel) {
        Map<String, Object> variables = newRound();
        variables.put("bankBranchName", BankConstants.BANK_BRANCH_NAME);

        // related_personnel_information相关人员信息表
        variables.put("applyPersonName", docCommonModel.getBorrower().getName());
        variables.put("applyPersonIdentityNumber", docCommonModel.getBorrower().getIdentityNumber());

        // 1.11. loan_business_information贷款业务信息表
        variables.put("applyMoneyRMB", RmbUtil.rmb(new BigDecimal(docCommonModel.getLoanBusinessInformation().getApplicationAmount())));
        variables.put("moneyUsage", docCommonModel.getLoanBusinessInformation().getDescription());

        setGuaranteeList(docCommonModel, variables);
    }

    private Map<String, Object> guarantee(String name, String coupleName, String mobile, String address) {
        Map<String, Object> tempMap = new HashMap<>();
        tempMap.put("name", name);
        tempMap.put("coupleName", coupleName);
        tempMap.put("mobile", mobile);
        tempMap.put("address", address);
        return tempMap;
    }

    private Map<Long, String> fillCoupleInfo(DocCommonModel model) {
        Map<Long, String> coupleMap = new HashMap<>();
        for (RelatedPersonnelInformation relatedPersonnelInformation : model.getGuarantorList()) {
            if (relatedPersonnelInformation.getCoupleId() == null || relatedPersonnelInformation.getCoupleId() == 0) {
                continue;
            }

            coupleMap.put(relatedPersonnelInformation.getCoupleId(), relatedPersonnelInformation.getName());
        }

        return coupleMap;
    }


    private void setGuaranteeList(DocCommonModel model, Map<String, Object> variables) {
        // related_personnel_information  3和4类型, 先查询 主加人， 跟根据主加人配偶ID查询姓名拼接
        List<Map<String, Object>> guaranteeList = new ArrayList<>();

        if (CollectionUtils.isEmpty(model.getGuarantorList())) {
            return;
        }

        Map<Long, String> coupleMap = fillCoupleInfo(model);
        for (RelatedPersonnelInformation relatedPersonnelInformation : model.getGuarantorList()) {
            guaranteeList.add(guarantee(relatedPersonnelInformation.getName(),
                    coupleMap.get(relatedPersonnelInformation.getId()) == null ? "" :
                            coupleMap.get(relatedPersonnelInformation.getId()),
                    relatedPersonnelInformation.getContactNumber(),
                    relatedPersonnelInformation.getCurrentHomeAddress()));

        }

        setGuaranteeListText(guaranteeList, variables);

        setGuaranteeSignatureListText(guaranteeList, variables);
    }

    @Override
    protected String modelFileName() {
        return "借款保证承诺书（个人）";
    }

    @Override
    protected int sort() {
        return 1_3_00;
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
