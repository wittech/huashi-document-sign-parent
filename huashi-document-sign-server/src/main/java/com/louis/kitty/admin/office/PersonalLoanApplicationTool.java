package com.louis.kitty.admin.office;

import com.alibaba.druid.util.StringUtils;
import com.louis.kitty.admin.constants.BankConstants;
import com.louis.kitty.admin.constants.DocConstants;
import com.louis.kitty.admin.model.DocCommonModel;
import com.louis.kitty.admin.model.HouseholdIncome;
import com.louis.kitty.admin.model.Pawn;
import com.louis.kitty.admin.model.RelatedPersonnelInformation;
import com.louis.kitty.admin.sevice.HouseholdIncomeService;
import com.louis.kitty.admin.util.RmbUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 个人借款申请表
 */

@Component
public class PersonalLoanApplicationTool extends AbstractOfficeTool {

    @Autowired
    private HouseholdIncomeService householdIncomeService;

    /**
     * 设置担保情况---保证担保参数数据
     *
     * @param isChoose      保证担保是否勾选
     * @param guaranteeList 保证担保参数集合信息
     */
    private void setGuaranteeListText(boolean isChoose, List<Map<String, Object>> guaranteeList, Map<String, Object> variables) {
        StringBuilder data = new StringBuilder();
        data.append("<w:tr>" + "  " +
                "<w:tblPrEx>" +
                "<w:tblCellMar>" + "  " +
                "<w:top w:w=\"0\" w:type=\"dxa\"/>" +
                "  <w:left w:w=\"108\" w:type=\"dxa\"/>" +
                "  <w:bottom w:w=\"0\" w:type=\"dxa\"/>" +
                "  <w:right w:w=\"108\" w:type=\"dxa\"/>" +
                "</w:tblCellMar>" + "  </w:tblPrEx>" +
                "  <w:trPr>" +
                "<w:gridBefore w:val=\"1\"/>" +
                "<w:wBefore w:w=\"10\" w:type=\"dxa\"/>" +
                "<w:trHeight w:val=\"295\" w:h-rule=\"atLeast\"/>" +
                "  </w:trPr>" + "  <w:tc>" + "<w:tcPr>" +
                "  <w:tcW w:w=\"1100\" w:type=\"dxa\"/>" +
                "  <w:gridSpan w:val=\"2\"/>" +
                "  <w:vmerge w:val=\"restart\"/>" +
                "  <w:tcBorders>" +
                "<w:top w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" + "<w:left w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" + "<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"000000\"/>" + "<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" + "  </w:tcBorders>" + "  <w:shd w:val=\"pct-10\" w:color=\"auto\" w:fill=\"auto\"/>" + "  <w:noWrap w:val=\"0\"/>" + "  <w:vAlign w:val=\"center\"/>" + "</w:tcPr>" + "<w:p>" + "  <w:pPr>" + "<w:widowControl/>" + "<w:jc w:val=\"left\"/>" + "<w:rPr>" + "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>" + "  <w:kern w:val=\"0\"/>" + "  <w:sz w:val=\"15\"/>" + "  <w:sz-cs w:val=\"15\"/>" + "</w:rPr>" + "  </w:pPr>" + "  <w:r>" + "<w:rPr>" + "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>" + "  <w:kern w:val=\"0\"/>" + "  <w:sz w:val=\"15\"/>" + "  <w:sz-cs w:val=\"15\"/>" + "</w:rPr>" + "<w:t> ").append(isChoose ? "☑" : "□").append("保证担保</w:t>").append("  </w:r>").append("</w:p>").append("  </w:tc>").append("  <w:tc>").append("<w:tcPr>").append("  <w:tcW w:w=\"1217\" w:type=\"dxa\"/>").append("  <w:tcBorders>").append("<w:top w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:left w:val=\"nil\"/>").append("<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("  </w:tcBorders>").append("  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>").append("  <w:noWrap w:val=\"0\"/>").append("  <w:vAlign w:val=\"center\"/>").append("</w:tcPr>").append("<w:p>").append("  <w:pPr>").append("<w:widowControl/>").append("<w:jc w:val=\"center\"/>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("  </w:pPr>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("<w:t>担保人姓名1</w:t>").append("  </w:r>").append("</w:p>").append("  </w:tc>").append("  <w:tc>").append("<w:tcPr>").append("  <w:tcW w:w=\"951\" w:type=\"dxa\"/>").append("  <w:gridSpan w:val=\"2\"/>").append("  <w:tcBorders>").append("<w:top w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:left w:val=\"nil\"/>").append("<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:right w:val=\"nil\"/>").append("  </w:tcBorders>").append("  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>").append("  <w:noWrap w:val=\"0\"/>").append("  <w:vAlign w:val=\"center\"/>").append("</w:tcPr>").append("<w:p>").append("  <w:pPr>").append("<w:widowControl/>").append("<w:jc w:val=\"left\"/>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("  <w:lang w:val=\"EN-US\" w:fareast=\"ZH-CN\"/>").append("</w:rPr>").append("  </w:pPr>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("<w:t>").append(getValue(guaranteeList, 0, "name")).append("</w:t>").append("  </w:r>").append("</w:p>").append("  </w:tc>").append("  <w:tc>").append("<w:tcPr>").append("  <w:tcW w:w=\"741\" w:type=\"dxa\"/>").append("  <w:gridSpan w:val=\"2\"/>").append("  <w:tcBorders>").append("<w:top w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:left w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("  </w:tcBorders>").append("  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>").append("  <w:noWrap w:val=\"0\"/>").append("  <w:vAlign w:val=\"center\"/>").append("</w:tcPr>").append("<w:p>").append("  <w:pPr>").append("<w:widowControl/>").append("<w:ind w:left=\"-7\" w:left-chars=\"-52\" w:right=\"-107\" w:right-chars=\"-51\" w:hanging=\"102\" w:hanging-chars=\"68\"/>").append("<w:jc w:val=\"center\"/>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("  </w:pPr>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("<w:t>身份证号</w:t>").append("  </w:r>").append("</w:p>").append("  </w:tc>").append("  <w:tc>").append("<w:tcPr>").append("  <w:tcW w:w=\"1763\" w:type=\"dxa\"/>").append("  <w:gridSpan w:val=\"3\"/>").append("  <w:tcBorders>").append("<w:top w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:left w:val=\"nil\"/>").append("<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"000000\"/>").append("  </w:tcBorders>").append("  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>").append("  <w:noWrap w:val=\"0\"/>").append("  <w:vAlign w:val=\"center\"/>").append("</w:tcPr>").append("<w:p>").append("  <w:pPr>").append("<w:widowControl/>").append("<w:jc w:val=\"left\"/>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"FF0000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("  <w:lang w:val=\"EN-US\" w:fareast=\"ZH-CN\"/>").append("</w:rPr>").append("  </w:pPr>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("<w:t>").append(getValue(guaranteeList, 0, "idcard")).append("</w:t>").append("  </w:r>").append("  ").append("</w:p>").append("  </w:tc>").append("  <w:tc>").append("<w:tcPr>").append("  <w:tcW w:w=\"1637\" w:type=\"dxa\"/>").append("  <w:gridSpan w:val=\"2\"/>").append("  <w:tcBorders>").append("<w:top w:val=\"nil\"/>").append("<w:left w:val=\"nil\"/>").append("<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("  </w:tcBorders>").append("  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>").append("  <w:noWrap w:val=\"0\"/>").append("  <w:vAlign w:val=\"center\"/>").append("</w:tcPr>").append("<w:p>").append("  <w:pPr>").append("<w:widowControl/>").append("<w:jc w:val=\"left\"/>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("  </w:pPr>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("<w:t>电话：").append(getValue(guaranteeList, 0, "mobile")).append("</w:t>").append("  </w:r>").append("</w:p>").append("  </w:tc>").append("  <w:tc>").append("<w:tcPr>").append("  <w:tcW w:w=\"2814\" w:type=\"dxa\"/>").append("  <w:gridSpan w:val=\"3\"/>").append("  <w:tcBorders>").append("<w:top w:val=\"nil\"/>").append("<w:left w:val=\"nil\"/>").append("<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("  </w:tcBorders>").append("  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>").append("  <w:noWrap w:val=\"0\"/>").append("  <w:vAlign w:val=\"center\"/>").append("</w:tcPr>").append("<w:p>").append("  <w:pPr>").append("<w:widowControl/>").append("<w:spacing w:line=\"240\" w:line-rule=\"exact\"/>").append("<w:jc w:val=\"left\"/>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("  </w:pPr>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("<w:t> 地址：").append(getValue(guaranteeList, 0, "address")).append("</w:t>").append("  </w:r>").append("</w:p>").append("  </w:tc>").append("</w:tr>");

        int loopSize = guaranteeList.size() > 3 ? guaranteeList.size() : 3;
        for (int i = 1; i < loopSize; i++) {
            data.append("<w:tr>" + "  <w:tblPrEx>" + "<w:tblCellMar>" + "  <w:top w:w=\"0\" w:type=\"dxa\"/>" + "  <w:left w:w=\"108\" w:type=\"dxa\"/>" + "  <w:bottom w:w=\"0\" w:type=\"dxa\"/>" + "  <w:right w:w=\"108\" w:type=\"dxa\"/>" + "</w:tblCellMar>" + "  </w:tblPrEx>" + "  <w:trPr>" + "<w:gridBefore w:val=\"1\"/>" + "<w:wBefore w:w=\"10\" w:type=\"dxa\"/>" + "<w:trHeight w:val=\"243\" w:h-rule=\"atLeast\"/>" + "  </w:trPr>" + "  <w:tc>" + "<w:tcPr>" + "  <w:tcW w:w=\"1100\" w:type=\"dxa\"/>" + "  <w:gridSpan w:val=\"2\"/>" + "  <w:vmerge w:val=\"continue\"/>" + "  <w:tcBorders>" + "<w:top w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" + "<w:left w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" + "<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"000000\"/>" + "<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" + "  </w:tcBorders>" + "  <w:shd w:val=\"pct-10\" w:color=\"auto\" w:fill=\"auto\"/>" + "  <w:noWrap w:val=\"0\"/>" + "  <w:vAlign w:val=\"center\"/>" + "</w:tcPr>" + "<w:p>" + "  <w:pPr>" + "<w:widowControl/>" + "<w:jc w:val=\"left\"/>" + "<w:rPr>" + "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>" + "  <w:kern w:val=\"0\"/>" + "  <w:sz w:val=\"15\"/>" + "  <w:sz-cs w:val=\"15\"/>" + "</w:rPr>" + "  </w:pPr>" + "</w:p>" + "  </w:tc>" + "  <w:tc>" + "<w:tcPr>" + "  <w:tcW w:w=\"1217\" w:type=\"dxa\"/>" + "  <w:tcBorders>" + "<w:top w:val=\"nil\"/>" + "<w:left w:val=\"nil\"/>" + "<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" + "<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" + "  </w:tcBorders>" + "  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>" + "  <w:noWrap w:val=\"0\"/>" + "  <w:vAlign w:val=\"center\"/>" + "</w:tcPr>" + "<w:p>" + "  <w:pPr>" + "<w:widowControl/>" + "<w:jc w:val=\"center\"/>" + "<w:rPr>" + "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>" + "  <w:color w:val=\"000000\"/>" + "  <w:kern w:val=\"0\"/>" + "  <w:sz w:val=\"15\"/>" + "  <w:sz-cs w:val=\"15\"/>" + "</w:rPr>" + "  </w:pPr>" + "  <w:r>" + "<w:rPr>" + "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>" + "  <w:color w:val=\"000000\"/>" + "  <w:kern w:val=\"0\"/>" + "  <w:sz w:val=\"15\"/>" + "  <w:sz-cs w:val=\"15\"/>" + "</w:rPr>" + "<w:t>担保人姓名").append(i + 1).append("</w:t>").append("  </w:r>").append("</w:p>").append("  </w:tc>").append("  <w:tc>").append("<w:tcPr>").append("  <w:tcW w:w=\"951\" w:type=\"dxa\"/>").append("  <w:gridSpan w:val=\"2\"/>").append("  <w:tcBorders>").append("<w:top w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:left w:val=\"nil\"/>").append("<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:right w:val=\"nil\"/>").append("  </w:tcBorders>").append("  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>").append("  <w:noWrap w:val=\"0\"/>").append("  <w:vAlign w:val=\"center\"/>").append("</w:tcPr>").append("<w:p>").append("  <w:pPr>").append("<w:widowControl/>").append("<w:jc w:val=\"left\"/>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("  <w:lang w:val=\"EN-US\" w:fareast=\"ZH-CN\"/>").append("</w:rPr>").append("  </w:pPr>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("<w:t>").append(getValue(guaranteeList, i, "name")).append("</w:t>").append("  </w:r>").append("</w:p>").append("  </w:tc>").append("  <w:tc>").append("<w:tcPr>").append("  <w:tcW w:w=\"741\" w:type=\"dxa\"/>").append("  <w:gridSpan w:val=\"2\"/>").append("  <w:tcBorders>").append("<w:top w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:left w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("  </w:tcBorders>").append("  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>").append("  <w:noWrap w:val=\"0\"/>").append("  <w:vAlign w:val=\"center\"/>").append("</w:tcPr>").append("<w:p>").append("  <w:pPr>").append("<w:widowControl/>").append("<w:ind w:left=\"-7\" w:left-chars=\"-52\" w:right=\"-107\" w:right-chars=\"-51\" w:hanging=\"102\" w:hanging-chars=\"68\"/>").append("<w:jc w:val=\"center\"/>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("  </w:pPr>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("<w:t>身份证号</w:t>").append("  </w:r>").append("</w:p>").append("  </w:tc>").append("  <w:tc>").append("<w:tcPr>").append("  <w:tcW w:w=\"1763\" w:type=\"dxa\"/>").append("  <w:gridSpan w:val=\"3\"/>").append("  <w:tcBorders>").append("<w:top w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:left w:val=\"nil\"/>").append("<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"000000\"/>").append("  </w:tcBorders>").append("  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>").append("  <w:noWrap w:val=\"0\"/>").append("  <w:vAlign w:val=\"center\"/>").append("</w:tcPr>").append("<w:p>").append("  <w:pPr>").append("<w:widowControl/>").append("<w:jc w:val=\"left\"/>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"FF0000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("  <w:lang w:val=\"EN-US\" w:fareast=\"ZH-CN\"/>").append("</w:rPr>").append("  </w:pPr>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("<w:t>").append(getValue(guaranteeList, i, "idcard")).append("</w:t>").append("  </w:r>").append("  ").append("</w:p>").append("  </w:tc>").append("  <w:tc>").append("<w:tcPr>").append("  <w:tcW w:w=\"1637\" w:type=\"dxa\"/>").append("  <w:gridSpan w:val=\"2\"/>").append("  <w:tcBorders>").append("<w:top w:val=\"nil\"/>").append("<w:left w:val=\"nil\"/>").append("<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("  </w:tcBorders>").append("  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>").append("  <w:noWrap w:val=\"0\"/>").append("  <w:vAlign w:val=\"center\"/>").append("</w:tcPr>").append("<w:p>").append("  <w:pPr>").append("<w:widowControl/>").append("<w:jc w:val=\"left\"/>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("  </w:pPr>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("<w:t>电话：").append(getValue(guaranteeList, i, "mobile")).append("</w:t>").append("  </w:r>").append("</w:p>").append("  </w:tc>").append("  <w:tc>").append("<w:tcPr>").append("  <w:tcW w:w=\"2814\" w:type=\"dxa\"/>").append("  <w:gridSpan w:val=\"3\"/>").append("  <w:tcBorders>").append("<w:top w:val=\"nil\"/>").append("<w:left w:val=\"nil\"/>").append("<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("  </w:tcBorders>").append("  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>").append("  <w:noWrap w:val=\"0\"/>").append("  <w:vAlign w:val=\"center\"/>").append("</w:tcPr>").append("<w:p>").append("  <w:pPr>").append("<w:widowControl/>").append("<w:spacing w:line=\"240\" w:line-rule=\"exact\"/>").append("<w:jc w:val=\"left\"/>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("  </w:pPr>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("<w:t> 地址：").append(getValue(guaranteeList, i, "address")).append("</w:t>").append("  </w:r>").append("</w:p>").append("  </w:tc>").append("</w:tr>");
        }


        variables.put("guaranteeList", data.toString());
    }

    /**
     * 设置担保情况---抵押担保参数数据
     *
     * @param isChoose     抵押担保是否勾选
     * @param mortgageList 抵押担保参数集合信息
     */
    private void setMortgageListText(boolean isChoose, List<Map<String, Object>> mortgageList, Map<String, Object> variables) {
        StringBuilder data = new StringBuilder();
        data.append("<w:tr>" + "  <w:tblPrEx>" + "<w:tblCellMar>" + "  <w:top w:w=\"0\" w:type=\"dxa\"/>" + "  <w:left w:w=\"108\" w:type=\"dxa\"/>" + "  <w:bottom w:w=\"0\" w:type=\"dxa\"/>" + "  <w:right w:w=\"108\" w:type=\"dxa\"/>" + "</w:tblCellMar>" + "  </w:tblPrEx>" + "  <w:trPr>" + "<w:gridBefore w:val=\"1\"/>" + "<w:wBefore w:w=\"10\" w:type=\"dxa\"/>" + "<w:trHeight w:val=\"612\" w:h-rule=\"atLeast\"/>" + "  </w:trPr>" + "  <w:tc>" + "<w:tcPr>" + "  <w:tcW w:w=\"1100\" w:type=\"dxa\"/>" + "  <w:gridSpan w:val=\"2\"/>" + "  <w:vmerge w:val=\"restart\"/>" + "  <w:tcBorders>" + "<w:top w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" + "<w:left w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" + "<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"000000\"/>" + "<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" + "  </w:tcBorders>" + "  <w:shd w:val=\"pct-10\" w:color=\"auto\" w:fill=\"auto\"/>" + "  <w:noWrap w:val=\"0\"/>" + "  <w:vAlign w:val=\"center\"/>" + "</w:tcPr>" + "<w:p>" + "  <w:pPr>" + "<w:widowControl/>" + "<w:jc w:val=\"center\"/>" + "<w:rPr>" + "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>" + "  <w:color w:val=\"000000\"/>" + "  <w:kern w:val=\"0\"/>" + "  <w:sz w:val=\"15\"/>" + "  <w:sz-cs w:val=\"15\"/>" + "</w:rPr>" + "  </w:pPr>" + "  <w:r>" + "<w:rPr>" + "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>" + "  <w:color w:val=\"000000\"/>" + "  <w:kern w:val=\"0\"/>" + "  <w:sz w:val=\"15\"/>" + "  <w:sz-cs w:val=\"15\"/>" + "</w:rPr>" + "<w:t>").append(isChoose ? "☑" : "□").append("抵押担保</w:t>").append("  </w:r>").append("</w:p>").append("  </w:tc>").append("  <w:tc>").append("<w:tcPr>").append("  <w:tcW w:w=\"1217\" w:type=\"dxa\"/>").append("  <w:tcBorders>").append("<w:top w:val=\"nil\"/>").append("<w:left w:val=\"nil\"/>").append("<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("  </w:tcBorders>").append("  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>").append("  <w:noWrap w:val=\"0\"/>").append("  <w:vAlign w:val=\"center\"/>").append("</w:tcPr>").append("<w:p>").append("  <w:pPr>").append("<w:widowControl/>").append("<w:jc w:val=\"center\"/>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("  </w:pPr>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("<w:t> 抵押人1姓名</w:t>").append("  </w:r>").append("</w:p>").append("  </w:tc>").append("  <w:tc>").append("<w:tcPr>").append("  <w:tcW w:w=\"951\" w:type=\"dxa\"/>").append("  <w:gridSpan w:val=\"2\"/>").append("  <w:tcBorders>").append("<w:top w:val=\"nil\"/>").append("<w:left w:val=\"nil\"/>").append("<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:right w:val=\"nil\"/>").append("  </w:tcBorders>").append("  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>").append("  <w:noWrap w:val=\"0\"/>").append("  <w:vAlign w:val=\"center\"/>").append("</w:tcPr>").append("<w:p>").append("  <w:pPr>").append("<w:widowControl/>").append("<w:jc w:val=\"center\"/>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("  </w:pPr>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("<w:t>").append(getValue(mortgageList, 0, "name")).append("</w:t>").append("  </w:r>").append("</w:p>").append("  </w:tc>").append("  <w:tc>").append("<w:tcPr>").append("  <w:tcW w:w=\"741\" w:type=\"dxa\"/>").append("  <w:gridSpan w:val=\"2\"/>").append("  <w:tcBorders>").append("<w:top w:val=\"nil\"/>").append("<w:left w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:right w:val=\"nil\"/>").append("  </w:tcBorders>").append("  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>").append("  <w:noWrap w:val=\"0\"/>").append("  <w:vAlign w:val=\"center\"/>").append("</w:tcPr>").append("<w:p>").append("  <w:pPr>").append("<w:widowControl/>").append("<w:ind w:left=\"-7\" w:left-chars=\"-52\" w:right=\"-122\" w:right-chars=\"-58\" w:hanging=\"102\" w:hanging-chars=\"68\"/>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("  </w:pPr>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("<w:t> 联系电话</w:t>").append("  </w:r>").append("</w:p>").append("  </w:tc>").append("  <w:tc>").append("<w:tcPr>").append("  <w:tcW w:w=\"1289\" w:type=\"dxa\"/>").append("  <w:gridSpan w:val=\"2\"/>").append("  <w:tcBorders>").append("<w:top w:val=\"nil\"/>").append("<w:left w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("  </w:tcBorders>").append("  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>").append("  <w:noWrap w:val=\"0\"/>").append("  <w:vAlign w:val=\"center\"/>").append("</w:tcPr>").append("<w:p>").append("  <w:pPr>").append("<w:widowControl/>").append("<w:jc w:val=\"left\"/>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("  </w:pPr>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("<w:t>").append(getValue(mortgageList, 0, "mobile")).append("</w:t>").append("  </w:r>").append("</w:p>").append("  </w:tc>").append("  <w:tc>").append("<w:tcPr>").append("  <w:tcW w:w=\"4925\" w:type=\"dxa\"/>").append("  <w:gridSpan w:val=\"6\"/>").append("  <w:tcBorders>").append("<w:top w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:left w:val=\"nil\"/>").append("<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"000000\"/>").append("  </w:tcBorders>").append("  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>").append("  <w:noWrap w:val=\"0\"/>").append("  <w:vAlign w:val=\"center\"/>").append("</w:tcPr>").append("<w:p>").append("  <w:pPr>").append("<w:widowControl/>").append("<w:ind w:left=\"-8\" w:left-chars=\"-57\" w:hanging=\"112\" w:hanging-chars=\"75\"/>").append("<w:jc w:val=\"center\"/>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("  </w:pPr>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("<w:t>抵押物名称</w:t>").append("  </w:r>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("  <w:u w:val=\"single\"/>").append("</w:rPr>").append("<w:t>： ").append(getValue(mortgageList, 0, "collateralName")).append(" </w:t>").append("  </w:r>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("<w:t> 抵押物数量</w:t>").append("  </w:r>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("  <w:u w:val=\"single\"/>").append("</w:rPr>").append("<w:t>：").append(getValue(mortgageList, 0, "collateralAmount")).append("</w:t>").append("  </w:r>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("  <w:u w:val=\"single\"/>").append("</w:rPr>").append("<w:t>㎡</w:t>").append("  </w:r>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("  <w:u w:val=\"single\"/>").append("</w:rPr>").append("<w:t>     </w:t>").append("  </w:r>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("<w:t> 价值</w:t>").append("  </w:r>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("  <w:u w:val=\"single\"/>").append("</w:rPr>").append("<w:t>：").append(getValue(mortgageList, 0, "collateralFee")).append("</w:t>").append("  </w:r>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("<w:t>元</w:t>").append("  </w:r>").append("</w:p>").append("  </w:tc>").append("</w:tr>").append("<w:tr>").append("  <w:tblPrEx>").append("<w:tblCellMar>").append("  <w:top w:w=\"0\" w:type=\"dxa\"/>").append("  <w:left w:w=\"108\" w:type=\"dxa\"/>").append("  <w:bottom w:w=\"0\" w:type=\"dxa\"/>").append("  <w:right w:w=\"108\" w:type=\"dxa\"/>").append("</w:tblCellMar>").append("  </w:tblPrEx>").append("  <w:trPr>").append("<w:gridBefore w:val=\"1\"/>").append("<w:wBefore w:w=\"10\" w:type=\"dxa\"/>").append("<w:trHeight w:val=\"400\" w:h-rule=\"atLeast\"/>").append("  </w:trPr>").append("  <w:tc>").append("<w:tcPr>").append("  <w:tcW w:w=\"1100\" w:type=\"dxa\"/>").append("  <w:gridSpan w:val=\"2\"/>").append("  <w:vmerge w:val=\"continue\"/>").append("  <w:tcBorders>").append("<w:top w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:left w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"000000\"/>").append("<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("  </w:tcBorders>").append("  <w:shd w:val=\"pct-10\" w:color=\"auto\" w:fill=\"auto\"/>").append("  <w:noWrap w:val=\"0\"/>").append("  <w:vAlign w:val=\"center\"/>").append("</w:tcPr>").append("<w:p>").append("  <w:pPr>").append("<w:widowControl/>").append("<w:jc w:val=\"left\"/>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("  </w:pPr>").append("</w:p>").append("  </w:tc>").append("  <w:tc>").append("<w:tcPr>").append("  <w:tcW w:w=\"1217\" w:type=\"dxa\"/>").append("  <w:tcBorders>").append("<w:top w:val=\"nil\"/>").append("<w:left w:val=\"nil\"/>").append("<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:right w:val=\"nil\"/>").append("  </w:tcBorders>").append("  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>").append("  <w:noWrap w:val=\"0\"/>").append("  <w:vAlign w:val=\"center\"/>").append("</w:tcPr>").append("<w:p>").append("  <w:pPr>").append("<w:widowControl/>").append("<w:jc w:val=\"center\"/>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("  </w:pPr>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("<w:t> 联 系 地 址</w:t>").append("  </w:r>").append("</w:p>").append("  </w:tc>").append("  <w:tc>").append("<w:tcPr>").append("  <w:tcW w:w=\"3455\" w:type=\"dxa\"/>").append("  <w:gridSpan w:val=\"7\"/>").append("  <w:tcBorders>").append("<w:top w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:left w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"000000\"/>").append("  </w:tcBorders>").append("  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>").append("  <w:noWrap w:val=\"0\"/>").append("  <w:vAlign w:val=\"center\"/>").append("</w:tcPr>").append("<w:p>").append("  <w:pPr>").append("<w:widowControl/>").append("<w:jc w:val=\"center\"/>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("  </w:pPr>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("<w:t>").append(getValue(mortgageList, 0, "contactAddress")).append("</w:t>").append("  </w:r>").append("</w:p>").append("  </w:tc>").append("  <w:tc>").append("<w:tcPr>").append("  <w:tcW w:w=\"1637\" w:type=\"dxa\"/>").append("  <w:gridSpan w:val=\"2\"/>").append("  <w:tcBorders>").append("<w:top w:val=\"nil\"/>").append("<w:left w:val=\"nil\"/>").append("<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("  </w:tcBorders>").append("  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>").append("  <w:noWrap w:val=\"0\"/>").append("  <w:vAlign w:val=\"center\"/>").append("</w:tcPr>").append("<w:p>").append("  <w:pPr>").append("<w:widowControl/>").append("<w:jc w:val=\"center\"/>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("  </w:pPr>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("<w:t>抵押物存放地</w:t>").append("  </w:r>").append("</w:p>").append("  </w:tc>").append("  <w:tc>").append("<w:tcPr>").append("  <w:tcW w:w=\"2814\" w:type=\"dxa\"/>").append("  <w:gridSpan w:val=\"3\"/>").append("  <w:tcBorders>").append("<w:top w:val=\"nil\"/>").append("<w:left w:val=\"nil\"/>").append("<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("  </w:tcBorders>").append("  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>").append("  <w:noWrap w:val=\"0\"/>").append("  <w:vAlign w:val=\"center\"/>").append("</w:tcPr>").append("<w:p>").append("  <w:pPr>").append("<w:widowControl/>").append("<w:jc w:val=\"left\"/>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("  </w:pPr>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("<w:t>").append(getValue(mortgageList, 0, "collateralPosition")).append("</w:t>").append("  </w:r>").append("</w:p>").append("  </w:tc>").append("</w:tr>");

        int loopSize = mortgageList.size() > 2 ? mortgageList.size() : 2;
        for (int i = 1; i < loopSize; i++) {
            data.append("<w:tr>" + "  <w:tblPrEx>" + "<w:tblCellMar>" + "  <w:top w:w=\"0\" w:type=\"dxa\"/>" + "  <w:left w:w=\"108\" w:type=\"dxa\"/>" + "  <w:bottom w:w=\"0\" w:type=\"dxa\"/>" + "  <w:right w:w=\"108\" w:type=\"dxa\"/>" + "</w:tblCellMar>" + "  </w:tblPrEx>" + "  <w:trPr>" + "<w:gridBefore w:val=\"1\"/>" + "<w:wBefore w:w=\"10\" w:type=\"dxa\"/>" + "<w:trHeight w:val=\"612\" w:h-rule=\"atLeast\"/>" + "  </w:trPr>" + "  <w:tc>" + "<w:tcPr>" + "  <w:tcW w:w=\"1100\" w:type=\"dxa\"/>" + "  <w:gridSpan w:val=\"2\"/>" + "  <w:vmerge w:val=\"continue\"/>" + "  <w:tcBorders>" + "<w:top w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" + "<w:left w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" + "<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"000000\"/>" + "<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" + "  </w:tcBorders>" + "  <w:shd w:val=\"pct-10\" w:color=\"auto\" w:fill=\"auto\"/>" + "  <w:noWrap w:val=\"0\"/>" + "  <w:vAlign w:val=\"center\"/>" + "</w:tcPr>" + "<w:p>" + "  <w:pPr>" + "<w:widowControl/>" + "<w:jc w:val=\"left\"/>" + "<w:rPr>" + "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>" + "  <w:color w:val=\"000000\"/>" + "  <w:kern w:val=\"0\"/>" + "  <w:sz w:val=\"15\"/>" + "  <w:sz-cs w:val=\"15\"/>" + "</w:rPr>" + "  </w:pPr>" + "</w:p>" + "  </w:tc>" + "  <w:tc>" + "<w:tcPr>" + "  <w:tcW w:w=\"1217\" w:type=\"dxa\"/>" + "  <w:tcBorders>" + "<w:top w:val=\"nil\"/>" + "<w:left w:val=\"nil\"/>" + "<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" + "<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" + "  </w:tcBorders>" + "  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>" + "  <w:noWrap w:val=\"0\"/>" + "  <w:vAlign w:val=\"center\"/>" + "</w:tcPr>" + "<w:p>" + "  <w:pPr>" + "<w:widowControl/>" + "<w:jc w:val=\"center\"/>" + "<w:rPr>" + "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>" + "  <w:color w:val=\"000000\"/>" + "  <w:kern w:val=\"0\"/>" + "  <w:sz w:val=\"15\"/>" + "  <w:sz-cs w:val=\"15\"/>" + "</w:rPr>" + "  </w:pPr>" + "  <w:r>" + "<w:rPr>" + "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>" + "  <w:color w:val=\"000000\"/>" + "  <w:kern w:val=\"0\"/>" + "  <w:sz w:val=\"15\"/>" + "  <w:sz-cs w:val=\"15\"/>" + "</w:rPr>" + "<w:t> 抵押人").append(i + 1).append("姓名</w:t>").append("  </w:r>").append("</w:p>").append("  </w:tc>").append("  <w:tc>").append("<w:tcPr>").append("  <w:tcW w:w=\"951\" w:type=\"dxa\"/>").append("  <w:gridSpan w:val=\"2\"/>").append("  <w:tcBorders>").append("<w:top w:val=\"nil\"/>").append("<w:left w:val=\"nil\"/>").append("<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:right w:val=\"nil\"/>").append("  </w:tcBorders>").append("  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>").append("  <w:noWrap w:val=\"0\"/>").append("  <w:vAlign w:val=\"center\"/>").append("</w:tcPr>").append("<w:p>").append("  <w:pPr>").append("<w:widowControl/>").append("<w:jc w:val=\"left\"/>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("  </w:pPr>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("<w:t>").append(getValue(mortgageList, i, "name")).append("</w:t>").append("  </w:r>").append("</w:p>").append("  </w:tc>").append("  <w:tc>").append("<w:tcPr>").append("  <w:tcW w:w=\"741\" w:type=\"dxa\"/>").append("  <w:gridSpan w:val=\"2\"/>").append("  <w:tcBorders>").append("<w:top w:val=\"nil\"/>").append("<w:left w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:right w:val=\"nil\"/>").append("  </w:tcBorders>").append("  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>").append("  <w:noWrap w:val=\"0\"/>").append("  <w:vAlign w:val=\"center\"/>").append("</w:tcPr>").append("<w:p>").append("  <w:pPr>").append("<w:widowControl/>").append("<w:ind w:left=\"-7\" w:left-chars=\"-52\" w:right=\"-122\" w:right-chars=\"-58\" w:hanging=\"102\" w:hanging-chars=\"68\"/>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("  </w:pPr>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("<w:t> 联系电话</w:t>").append("  </w:r>").append("</w:p>").append("  </w:tc>").append("  <w:tc>").append("<w:tcPr>").append("  <w:tcW w:w=\"1289\" w:type=\"dxa\"/>").append("  <w:gridSpan w:val=\"2\"/>").append("  <w:tcBorders>").append("<w:top w:val=\"nil\"/>").append("<w:left w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("  </w:tcBorders>").append("  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>").append("  <w:noWrap w:val=\"0\"/>").append("  <w:vAlign w:val=\"center\"/>").append("</w:tcPr>").append("<w:p>").append("  <w:pPr>").append("<w:widowControl/>").append("<w:jc w:val=\"left\"/>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("  </w:pPr>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("<w:t>").append(getValue(mortgageList, i, "mobile")).append("</w:t>").append("  </w:r>").append("</w:p>").append("  </w:tc>").append("  <w:tc>").append("<w:tcPr>").append("  <w:tcW w:w=\"4925\" w:type=\"dxa\"/>").append("  <w:gridSpan w:val=\"6\"/>").append("  <w:tcBorders>").append("<w:top w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:left w:val=\"nil\"/>").append("<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"000000\"/>").append("  </w:tcBorders>").append("  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>").append("  <w:noWrap w:val=\"0\"/>").append("  <w:vAlign w:val=\"center\"/>").append("</w:tcPr>").append("<w:p>").append("  <w:pPr>").append("<w:widowControl/>").append("<w:ind w:left=\"-8\" w:left-chars=\"-57\" w:hanging=\"112\" w:hanging-chars=\"75\"/>").append("<w:jc w:val=\"center\"/>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("  </w:pPr>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("<w:t>抵押物名称</w:t>").append("  </w:r>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("  <w:u w:val=\"single\"/>").append("</w:rPr>").append("<w:t>： ").append(getValue(mortgageList, i, "collateralName")).append(" </w:t>").append("  </w:r>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("<w:t> 抵押物数量</w:t>").append("  </w:r>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("  <w:u w:val=\"single\"/>").append("</w:rPr>").append("<w:t>：").append(getValue(mortgageList, i, "collateralAmount")).append("</w:t>").append("  </w:r>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("  <w:u w:val=\"single\"/>").append("</w:rPr>").append("<w:t>㎡</w:t>").append("  </w:r>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("  <w:u w:val=\"single\"/>").append("</w:rPr>").append("<w:t>     </w:t>").append("  </w:r>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("<w:t> 价值</w:t>").append("  </w:r>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("  <w:u w:val=\"single\"/>").append("</w:rPr>").append("<w:t>：").append(getValue(mortgageList, i, "collateralFee")).append("</w:t>").append("  </w:r>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("<w:t>元</w:t>").append("  </w:r>").append("</w:p>").append("  </w:tc>").append("</w:tr>").append("<w:tr>\n").append("  <w:tblPrEx>\n").append("\t<w:tblCellMar>\n").append("\t  <w:top w:w=\"0\" w:type=\"dxa\"/>\n").append("\t  <w:left w:w=\"108\" w:type=\"dxa\"/>\n").append("\t  <w:bottom w:w=\"0\" w:type=\"dxa\"/>\n").append("\t  <w:right w:w=\"108\" w:type=\"dxa\"/>\n").append("\t</w:tblCellMar>\n").append("  </w:tblPrEx>\n").append("  <w:trPr>\n").append("\t<w:gridBefore w:val=\"1\"/>\n").append("\t<w:wBefore w:w=\"10\" w:type=\"dxa\"/>\n").append("\t<w:trHeight w:val=\"400\" w:h-rule=\"atLeast\"/>\n").append("  </w:trPr>\n").append("  <w:tc>\n").append("\t<w:tcPr>\n").append("\t  <w:tcW w:w=\"1100\" w:type=\"dxa\"/>\n").append("\t  <w:gridSpan w:val=\"2\"/>\n").append("\t  <w:vmerge w:val=\"continue\"/>\n").append("\t  <w:tcBorders>\n").append("\t\t<w:top w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>\n").append("\t\t<w:left w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>\n").append("\t\t<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"000000\"/>\n").append("\t\t<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>\n").append("\t  </w:tcBorders>\n").append("\t  <w:shd w:val=\"pct-10\" w:color=\"auto\" w:fill=\"auto\"/>\n").append("\t  <w:noWrap w:val=\"0\"/>\n").append("\t  <w:vAlign w:val=\"center\"/>\n").append("\t</w:tcPr>\n").append("\t<w:p>\n").append("\t  <w:pPr>\n").append("\t\t<w:widowControl/>\n").append("\t\t<w:jc w:val=\"left\"/>\n").append("\t\t<w:rPr>\n").append("\t\t  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>\n").append("\t\t  <w:color w:val=\"000000\"/>\n").append("\t\t  <w:kern w:val=\"0\"/>\n").append("\t\t  <w:sz w:val=\"15\"/>\n").append("\t\t  <w:sz-cs w:val=\"15\"/>\n").append("\t\t</w:rPr>\n").append("\t  </w:pPr>\n").append("\t</w:p>\n").append("  </w:tc>\n").append("  <w:tc>\n").append("\t<w:tcPr>\n").append("\t  <w:tcW w:w=\"1217\" w:type=\"dxa\"/>\n").append("\t  <w:tcBorders>\n").append("\t\t<w:top w:val=\"nil\"/>\n").append("\t\t<w:left w:val=\"nil\"/>\n").append("\t\t<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>\n").append("\t\t<w:right w:val=\"nil\"/>\n").append("\t  </w:tcBorders>\n").append("\t  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>\n").append("\t  <w:noWrap w:val=\"0\"/>\n").append("\t  <w:vAlign w:val=\"center\"/>\n").append("\t</w:tcPr>\n").append("\t<w:p>\n").append("\t  <w:pPr>\n").append("\t\t<w:widowControl/>\n").append("\t\t<w:jc w:val=\"center\"/>\n").append("\t\t<w:rPr>\n").append("\t\t  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>\n").append("\t\t  <w:color w:val=\"000000\"/>\n").append("\t\t  <w:kern w:val=\"0\"/>\n").append("\t\t  <w:sz w:val=\"15\"/>\n").append("\t\t  <w:sz-cs w:val=\"15\"/>\n").append("\t\t</w:rPr>\n").append("\t  </w:pPr>\n").append("\t  <w:r>\n").append("\t\t<w:rPr>\n").append("\t\t  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>\n").append("\t\t  <w:color w:val=\"000000\"/>\n").append("\t\t  <w:kern w:val=\"0\"/>\n").append("\t\t  <w:sz w:val=\"15\"/>\n").append("\t\t  <w:sz-cs w:val=\"15\"/>\n").append("\t\t</w:rPr>\n").append("\t\t<w:t> 联 系 地 址</w:t>\n").append("\t  </w:r>\n").append("\t</w:p>\n").append("  </w:tc>\n").append("  <w:tc>\n").append("\t<w:tcPr>\n").append("\t  <w:tcW w:w=\"3455\" w:type=\"dxa\"/>\n").append("\t  <w:gridSpan w:val=\"7\"/>\n").append("\t  <w:tcBorders>\n").append("\t\t<w:top w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>\n").append("\t\t<w:left w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>\n").append("\t\t<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>\n").append("\t\t<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"000000\"/>\n").append("\t  </w:tcBorders>\n").append("\t  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>\n").append("\t  <w:noWrap w:val=\"0\"/>\n").append("\t  <w:vAlign w:val=\"center\"/>\n").append("\t</w:tcPr>\n").append("\t<w:p>\n").append("\t  <w:pPr>\n").append("\t\t<w:widowControl/>\n").append("\t\t<w:jc w:val=\"center\"/>\n").append("\t\t<w:rPr>\n").append("\t\t  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>\n").append("\t\t  <w:color w:val=\"000000\"/>\n").append("\t\t  <w:kern w:val=\"0\"/>\n").append("\t\t  <w:sz w:val=\"15\"/>\n").append("\t\t  <w:sz-cs w:val=\"15\"/>\n").append("\t\t</w:rPr>\n").append("\t  </w:pPr>\n").append("\t  <w:r>\n").append("\t\t<w:rPr>\n").append("\t\t  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>\n").append("\t\t  <w:color w:val=\"000000\"/>\n").append("\t\t  <w:kern w:val=\"0\"/>\n").append("\t\t  <w:sz w:val=\"15\"/>\n").append("\t\t  <w:sz-cs w:val=\"15\"/>\n").append("\t\t</w:rPr>\n").append("\t\t<w:t>").append(getValue(mortgageList, i, "contactAddress")).append("</w:t>\n").append("\t  </w:r>\n").append("\t</w:p>\n").append("  </w:tc>\n").append("  <w:tc>\n").append("\t<w:tcPr>\n").append("\t  <w:tcW w:w=\"1637\" w:type=\"dxa\"/>\n").append("\t  <w:gridSpan w:val=\"2\"/>\n").append("\t  <w:tcBorders>\n").append("\t\t<w:top w:val=\"nil\"/>\n").append("\t\t<w:left w:val=\"nil\"/>\n").append("\t\t<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>\n").append("\t\t<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>\n").append("\t  </w:tcBorders>\n").append("\t  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>\n").append("\t  <w:noWrap w:val=\"0\"/>\n").append("\t  <w:vAlign w:val=\"center\"/>\n").append("\t</w:tcPr>\n").append("\t<w:p>\n").append("\t  <w:pPr>\n").append("\t\t<w:widowControl/>\n").append("\t\t<w:jc w:val=\"center\"/>\n").append("\t\t<w:rPr>\n").append("\t\t  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>\n").append("\t\t  <w:color w:val=\"000000\"/>\n").append("\t\t  <w:kern w:val=\"0\"/>\n").append("\t\t  <w:sz w:val=\"15\"/>\n").append("\t\t  <w:sz-cs w:val=\"15\"/>\n").append("\t\t</w:rPr>\n").append("\t  </w:pPr>\n").append("\t  <w:r>\n").append("\t\t<w:rPr>\n").append("\t\t  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>\n").append("\t\t  <w:color w:val=\"000000\"/>\n").append("\t\t  <w:kern w:val=\"0\"/>\n").append("\t\t  <w:sz w:val=\"15\"/>\n").append("\t\t  <w:sz-cs w:val=\"15\"/>\n").append("\t\t</w:rPr>\n").append("\t\t<w:t>抵押物存放地</w:t>\n").append("\t  </w:r>\n").append("\t</w:p>\n").append("  </w:tc>\n").append("  <w:tc>\n").append("\t<w:tcPr>\n").append("\t  <w:tcW w:w=\"2814\" w:type=\"dxa\"/>\n").append("\t  <w:gridSpan w:val=\"3\"/>\n").append("\t  <w:tcBorders>\n").append("\t\t<w:top w:val=\"nil\"/>\n").append("\t\t<w:left w:val=\"nil\"/>\n").append("\t\t<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>\n").append("\t\t<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>\n").append("\t  </w:tcBorders>\n").append("\t  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>\n").append("\t  <w:noWrap w:val=\"0\"/>\n").append("\t  <w:vAlign w:val=\"center\"/>\n").append("\t</w:tcPr>\n").append("\t<w:p>\n").append("\t  <w:pPr>\n").append("\t\t<w:widowControl/>\n").append("\t\t<w:jc w:val=\"left\"/>\n").append("\t\t<w:rPr>\n").append("\t\t  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>\n").append("\t\t  <w:color w:val=\"000000\"/>\n").append("\t\t  <w:kern w:val=\"0\"/>\n").append("\t\t  <w:sz w:val=\"15\"/>\n").append("\t\t  <w:sz-cs w:val=\"15\"/>\n").append("\t\t</w:rPr>\n").append("\t  </w:pPr>\n").append("\t  <w:r>\n").append("\t\t<w:rPr>\n").append("\t\t  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>\n").append("\t\t  <w:color w:val=\"000000\"/>\n").append("\t\t  <w:kern w:val=\"0\"/>\n").append("\t\t  <w:sz w:val=\"15\"/>\n").append("\t\t  <w:sz-cs w:val=\"15\"/>\n").append("\t\t</w:rPr>\n").append("\t\t<w:t>").append(getValue(mortgageList, i, "collateralPosition")).append("</w:t>\n").append("\t  </w:r>\n").append("\t</w:p>\n").append("  </w:tc>\n").append("</w:tr>");
        }

        variables.put("mortgageList", data.toString());
    }

    private String setGender(Integer gender) {
        String personSex = "";
        if (gender == null) {
            personSex = "□男 □女";
        } else if (gender == 0) {
            personSex = "☑男 □女";
        } else if (gender == 1) {
            personSex = "□男 ☑女";
        }

        return personSex;
    }

    /**
     * 0、未婚）（1、已婚）（2、离异未婚）（3、丧偶未婚）（4、其他）
     */
    private String setMaritalStatus(Integer maritalStatus) {
        String maritalStatusDes = "";
        if (maritalStatus == null) {
            maritalStatusDes = "□已婚 □未婚 □离异 □丧偶 □其他";
        } else if (maritalStatus == 1) {
            maritalStatusDes = "☑已婚 □未婚 □离异 □丧偶 □其他";
        } else if (maritalStatus == 0) {
            maritalStatusDes = "□已婚 ☑未婚 □离异 □丧偶 □其他";
        } else if (maritalStatus == 2) {
            maritalStatusDes = "□已婚 □未婚 ☑离异 □丧偶 □其他";
        } else if (maritalStatus == 3) {
            maritalStatusDes = "□已婚 □未婚 □离异 ☑丧偶 □其他";
        } else if (maritalStatus == 4) {
            maritalStatusDes = "□已婚 □未婚 □离异 □丧偶 ☑其他";
        }

        return maritalStatusDes;
    }

    /**
     * 常用通信地址 （0、现居住地址）（1、单位地址）（2、其他）
     */
    private String setContactAddress(Integer contactAddress) {
        String contactAddressDes = "";
        if (contactAddress == null) {
            contactAddressDes = "□现居住地址 □单位地址 □其他";
        } else if (contactAddress == 0) {
            contactAddressDes = "☑现居住地址 □单位地址 □其他";
        } else if (contactAddress == 1) {
            contactAddressDes = "□现居住地址 ☑单位地址 □其他";
        } else if (contactAddress == 2) {
            contactAddressDes = "□现居住地址 □单位地址 ☑其他";
        }

        return contactAddressDes;
    }

    /**
     * 现住房来源（0、自有住房）（1、贷款自有）（2、单位宿舍）（3、与父母同住）（4、租赁）（5、其他）
     */
    private String setCurrentHousingSource(Integer currentHousingSource) {
        String currentHousingSourceDes = "";
        if (currentHousingSource == null) {
            currentHousingSourceDes = "□自有住房 □贷款自有 □单位宿舍 □与父母同住 □租赁 □其他";
        } else if (currentHousingSource == 0) {
            currentHousingSourceDes = "☑自有住房 □贷款自有 □单位宿舍 □与父母同住 □租赁 □其他";
        } else if (currentHousingSource == 1) {
            currentHousingSourceDes = "□自有住房 ☑贷款自有 □单位宿舍 □与父母同住 □租赁 □其他";
        } else if (currentHousingSource == 2) {
            currentHousingSourceDes = "□自有住房 □贷款自有 ☑单位宿舍 □与父母同住 □租赁 □其他";
        } else if (currentHousingSource == 3) {
            currentHousingSourceDes = "□自有住房 □贷款自有 □单位宿舍 ☑与父母同住 □租赁 □其他";
        } else if (currentHousingSource == 4) {
            currentHousingSourceDes = "□自有住房 □贷款自有 □单位宿舍 □与父母同住 ☑租赁 □其他";
        } else if (currentHousingSource == 5) {
            currentHousingSourceDes = "□自有住房 □贷款自有 □单位宿舍 □与父母同住 □租赁 ☑其他";
        }

        return currentHousingSourceDes;
    }

    /**
     * 文化程度 （0、研究生及以上）（1、本科）（2、大专）（3、中专/高中）（4、初中）（5、其他）
     */
    private String setEducationalLevel(Integer educationalLevel) {
        String educationalLevelDes = "";
        if (educationalLevel == null) {
            educationalLevelDes = "□研究生及以上 □本科 □大专 □中专/高中 □初中 □其他";
        } else if (educationalLevel == 0) {
            educationalLevelDes = "☑研究生及以上 □本科 □大专 □中专/高中 □初中 □其他";
        } else if (educationalLevel == 1) {
            educationalLevelDes = "□研究生及以上 ☑本科 □大专 □中专/高中 □初中 □其他";
        } else if (educationalLevel == 2) {
            educationalLevelDes = "□研究生及以上 □本科 ☑大专 □中专/高中 □初中 □其他";
        } else if (educationalLevel == 3) {
            educationalLevelDes = "□研究生及以上 □本科 □大专 ☑中专/高中 □初中 □其他";
        } else if (educationalLevel == 4) {
            educationalLevelDes = "□研究生及以上 □本科 □大专 □中专/高中 ☑初中 □其他";
        } else if (educationalLevel == 5) {
            educationalLevelDes = "□研究生及以上 □本科 □大专 □中专/高中 □初中 ☑其他";
        }

        return educationalLevelDes;
    }

    /**
     * 用途 1经营 2自建房 3购房 4购车 5住房装修 6购买大额耐用消费品 7旅游消费 8留学 9子女教育 10其他
     */
    private static String setUsage(Integer usage) {
        String usageDes = "";
        if (usage == null) {
            usageDes = "□经营□自建房□购房□购车□住房装修□购买大额耐用消费品□旅游消费□留学□子女教育□其他";
        } else if (usage == 1) {
            usageDes = "☑经营□自建房□购房□购车□住房装修□购买大额耐用消费品□旅游消费□留学□子女教育□其他";
        } else if (usage == 2) {
            usageDes = "□经营☑自建房□购房□购车□住房装修□购买大额耐用消费品□旅游消费□留学□子女教育□其他";
        } else if (usage == 3) {
            usageDes = "□经营□自建房☑购房□购车□住房装修□购买大额耐用消费品□旅游消费□留学□子女教育□其他";
        } else if (usage == 4) {
            usageDes = "□经营□自建房□购房☑购车□住房装修□购买大额耐用消费品□旅游消费□留学□子女教育□其他";
        } else if (usage == 5) {
            usageDes = "□经营□自建房□购房□购车☑住房装修□购买大额耐用消费品□旅游消费□留学□子女教育□其他";
        } else if (usage == 6) {
            usageDes = "□经营□自建房□购房□购车□住房装修☑购买大额耐用消费品□旅游消费□留学□子女教育□其他";
        } else if (usage == 7) {
            usageDes = "□经营□自建房□购房□购车□住房装修□购买大额耐用消费品☑旅游消费□留学□子女教育□其他";
        } else if (usage == 8) {
            usageDes = "□经营□自建房□购房□购车□住房装修□购买大额耐用消费品□旅游消费☑留学□子女教育□其他";
        } else if (usage == 9) {
            usageDes = "□经营□自建房□购房□购车□住房装修□购买大额耐用消费品□旅游消费□留学☑子女教育□其他";
        } else if (usage == 10) {
            usageDes = "□经营□自建房□购房□购车□住房装修□购买大额耐用消费品□旅游消费□留学□子女教育☑其他";
        }

        return usageDes;
    }

    /**
     * 还款方式 1利随本清 2按月结息，到期一次性还本 3按月结息，分期还本 4按季结息，分期还本 5等额本金 6等额本息 7其他
     */
    private String setPaymentMethod(Integer paymentMethod) {
        String paymentMethodDes = "";
        if (paymentMethod == null) {
            paymentMethodDes = "□利随本清 □按月结息，到期一次性还本 □按月结息，分期还本 □按季结息，分期还本 □等额本金 □等额本息 □其他";
        } else if (paymentMethod == 1) {
            paymentMethodDes = "☑利随本清 □按月结息，到期一次性还本 □按月结息，分期还本 □按季结息，分期还本 □等额本金 □等额本息 □其他";
        } else if (paymentMethod == 2) {
            paymentMethodDes = "□利随本清 ☑按月结息，到期一次性还本 □按月结息，分期还本 □按季结息，分期还本 □等额本金 □等额本息 □其他";
        } else if (paymentMethod == 3) {
            paymentMethodDes = "□利随本清 □按月结息，到期一次性还本 ☑按月结息，分期还本 □按季结息，分期还本 □等额本金 □等额本息 □其他";
        } else if (paymentMethod == 4) {
            paymentMethodDes = "□利随本清 □按月结息，到期一次性还本 □按月结息，分期还本 ☑按季结息，分期还本 □等额本金 □等额本息 □其他";
        } else if (paymentMethod == 5) {
            paymentMethodDes = "□利随本清 □按月结息，到期一次性还本 □按月结息，分期还本 □按季结息，分期还本 ☑等额本金 □等额本息 □其他";
        } else if (paymentMethod == 6) {
            paymentMethodDes = "□利随本清 □按月结息，到期一次性还本 □按月结息，分期还本 □按季结息，分期还本 □等额本金 ☑等额本息 □其他";
        } else if (paymentMethod == 7) {
            paymentMethodDes = "□利随本清 □按月结息，到期一次性还本 □按月结息，分期还本 □按季结息，分期还本 □等额本金 □等额本息 ☑其他";
        }

        return paymentMethodDes;
    }

    private void setHouseholdIncome(DocCommonModel docCommonModel, Map<String, Object> variables) {
        HouseholdIncome householdIncome = householdIncomeService.findByRpiId(docCommonModel.getBorrower().getId());
        if (householdIncome == null) {
            return;
        }

        // 申请人家庭收支情况--家庭总收入  household_income

        variables.put("totalRevenue", RmbUtil.number2CNMontrayUnit(new BigDecimal(householdIncome.getTotalRevenue())));
        variables.put("applicantAnnualIncome",
                RmbUtil.number2CNMontrayUnit(new BigDecimal(householdIncome.getApplicantAnnualIncome())));
        variables.put("applicantOperatingIncome",
                RmbUtil.number2CNMontrayUnit(new BigDecimal(householdIncome.getApplicantOperatingIncome())));
        variables.put("applicantOtherIncome",
                RmbUtil.number2CNMontrayUnit(new BigDecimal(householdIncome.getApplicantOtherIncome())));

        variables.put("spouseAnnualIncome",
                RmbUtil.number2CNMontrayUnit(new BigDecimal(householdIncome.getSpouseAnnualIncome())));
        variables.put("spouseOperatingIncome",
                RmbUtil.number2CNMontrayUnit(new BigDecimal(householdIncome.getSpouseOperatingIncome())));
        variables.put("spouseOtherIncome",
                RmbUtil.number2CNMontrayUnit(new BigDecimal(householdIncome.getSpouseOtherIncome())));


        // 申请人家庭收支情况--家庭总支出  household_income
        variables.put("totalAnnualExpenditure",
                RmbUtil.number2CNMontrayUnit(new BigDecimal(householdIncome.getTotalAnnualExpenditure())));
        variables.put("lifeTotalExpenditure",
                RmbUtil.number2CNMontrayUnit(new BigDecimal(householdIncome.getLifeTotalExpenditure())));
        variables.put("basicLifeTotalExpenditure",
                RmbUtil.number2CNMontrayUnit(new BigDecimal(householdIncome.getBasicLifeTotalExpenditure())));
        variables.put("educationExpenditure",
                RmbUtil.number2CNMontrayUnit(new BigDecimal(householdIncome.getEducationExpenditure())));
        variables.put("temporaryExpenditure",
                RmbUtil.number2CNMontrayUnit(new BigDecimal(householdIncome.getTemporaryExpenditure())));
        variables.put("debtTotalExpenditure",
                RmbUtil.number2CNMontrayUnit(new BigDecimal(householdIncome.getDebtTotalExpenditure())));
        variables.put("annualLoanExpenditure",
                RmbUtil.number2CNMontrayUnit(new BigDecimal(householdIncome.getAnnualLoanExpenditure())));
        variables.put("spouseTemporaryExpenditure",
                RmbUtil.number2CNMontrayUnit(new BigDecimal(householdIncome.getSpouseTemporaryExpenditure())));
        variables.put("supportPopulation",
                RmbUtil.number2CNMontrayUnit(new BigDecimal(householdIncome.getSupportPopulation())));
        variables.put("foreignGuaranteeLumpSum",
                RmbUtil.number2CNMontrayUnit(new BigDecimal(householdIncome.getForeignGuaranteeLumpSum())));

    }

    @Override
    protected void fillVariable(DocCommonModel docCommonModel) {
        // 根据 basisLoanId 查询一系列数据结构  related_personnel_information type =1
        Map<String, Object> variables = newRound();

        variables.put("bankBranchName", BankConstants.BANK_BRANCH_NAME);

        if (docCommonModel.getBorrower() != null) {
            variables.put("applyPersonName", docCommonModel.getBorrower().getName());
            variables.put("applyPersonSex", setGender(docCommonModel.getBorrower().getSex()));
            variables.put("applyPersonAge", docCommonModel.getBorrower().getAge());
            variables.put("applyPersonMaritalStatus", setMaritalStatus(docCommonModel.getBorrower().getMaritalStatus()));
            variables.put("applyPersonMaritalOther", "    ");

            variables.put("applyPersonIdentityNumber", docCommonModel.getBorrower().getIdentityNumber());
            variables.put("applyPersonDomicile", docCommonModel.getBorrower().getDomicile());

            variables.put("applyPersonCurrentHomeAddress", docCommonModel.getBorrower().getCurrentHomeAddress());
            variables.put("applyPersonLocalResidenceTime", docCommonModel.getBorrower().getLocalResidenceTime());


            variables.put("applyPersonContactAddress", setContactAddress(docCommonModel.getBorrower().getContactAddress()));

            variables.put("applyPersonContactNumber", docCommonModel.getBorrower().getContactNumber());
            variables.put("applyPersonEmail", docCommonModel.getBorrower().getEmail());
            variables.put("applyPersonQQ", docCommonModel.getBorrower().getQq());
            variables.put("applyPersonWeChat", docCommonModel.getBorrower().getWechat());

            variables.put("applyPersonEducationalLevel", setEducationalLevel(docCommonModel.getBorrower().getEducationalLevel()));
            variables.put("applyPersonEducationalLevelOther", docCommonModel.getBorrower().getEducationalLevelValue());

            variables.put("applyPersonCurrentHousingSource", setCurrentHousingSource(docCommonModel.getBorrower().getCurrentHousingSource()));
            variables.put("applyPersonCurrentHousingOther", docCommonModel.getBorrower().getCurrentHousingSourceValue());

            variables.put("applyPersonEmployer", docCommonModel.getBorrower().getEmployer());


            variables.put("applyPersonPosition", docCommonModel.getBorrower().getPosition());
            variables.put("applyPersonUnitWorkingYears", docCommonModel.getBorrower().getUnitWorkingYears());
            variables.put("applyPersonCompanyName", docCommonModel.getBorrower().getCompanyName());
            variables.put("applyPersonShareholdingRatio", docCommonModel.getBorrower().getLocalResidenceTime());
            variables.put("applyPersonYearsOperation", docCommonModel.getBorrower().getYearsOperation());
        }


        // 以下信息为配偶信息   related_personnel_information  type = 2
        if (docCommonModel.getBorrowerCouple() != null) {
            variables.put("coupleName", docCommonModel.getBorrowerCouple().getName());
            variables.put("coupleSex", setGender(docCommonModel.getBorrowerCouple().getSex()));
            variables.put("coupleAge", docCommonModel.getBorrowerCouple().getAge());
            variables.put("coupleIdentityNumber", docCommonModel.getBorrowerCouple().getIdentityNumber());
            variables.put("coupleDomicile", docCommonModel.getBorrowerCouple().getDomicile());
            variables.put("coupleCurrentHomeAddress", docCommonModel.getBorrowerCouple().getCurrentHomeAddress());
            variables.put("coupleLocalResidenceTime", docCommonModel.getBorrowerCouple().getLocalResidenceTime());
            variables.put("coupleContactAddress", setContactAddress(docCommonModel.getBorrowerCouple().getContactAddress()));
            variables.put("coupleContactNumber", docCommonModel.getBorrowerCouple().getContactNumber());
            variables.put("coupleEmail", docCommonModel.getBorrowerCouple().getEmail());
            variables.put("coupleQQ", docCommonModel.getBorrowerCouple().getQq());
            variables.put("coupleWeChat", docCommonModel.getBorrowerCouple().getWechat());
            variables.put("coupleEducationalLevel", setEducationalLevel(docCommonModel.getBorrowerCouple().getEducationalLevel()));
            variables.put("coupleEducationalLevelOther", docCommonModel.getBorrowerCouple().getEducationalLevelValue());
            variables.put("coupleCurrentHousingSource", setCurrentHousingSource(docCommonModel.getBorrowerCouple().getCurrentHousingSource()));
            variables.put("coupleCurrentHousingOther", docCommonModel.getBorrowerCouple().getCurrentHousingSourceValue());
            variables.put("coupleEmployer", docCommonModel.getBorrowerCouple().getEmployer());
            variables.put("couplePosition", docCommonModel.getBorrowerCouple().getPosition());
            variables.put("coupleUnitWorkingYears", docCommonModel.getBorrowerCouple().getUnitWorkingYears());
            variables.put("coupleCompanyName", docCommonModel.getBorrowerCouple().getCompanyName());
            variables.put("coupleShareholdingRatio", docCommonModel.getBorrowerCouple().getShareholdingRatio());
            variables.put("coupleYearsOperation", docCommonModel.getBorrowerCouple().getYearsOperation());

        }
        // 申请人家庭收支情况
        setHouseholdIncome(docCommonModel, variables);

        // 申请借款情况  loan_business_information
        if (docCommonModel.getLoanBusinessInformation() != null) {
            variables.put("applicationsAmount", docCommonModel.getLoanBusinessInformation().getApplicationAmount());
            variables.put("applicationDeadline", docCommonModel.getLoanBusinessInformation().getApplicationPeriod());
            variables.put("isRound", setYesOption(docCommonModel.getLoanBusinessInformation().getCycleQuota()));

            variables.put("usage", setUsage(docCommonModel.getLoanBusinessInformation().getUseInfo()));
            variables.put("usageOther", docCommonModel.getLoanBusinessInformation().getDescription());

            variables.put("paymentMethod", setPaymentMethod(docCommonModel.getLoanBusinessInformation().getRepayment()));
            variables.put("paymentMethodOther", docCommonModel.getLoanBusinessInformation().getValue());

            variables.put("isCombinedLoans",
                    setYesOption(docCommonModel.getLoanBusinessInformation().getWhetherProvidentFundCombinationLoan()));
            variables.put("publicLoanCommitment", docCommonModel.getLoanBusinessInformation().getProvidentFundLoanAmount());
        }

        // 担保情况  related_personnel_information
        setGuaranteeList(docCommonModel, variables);

        // 1.9. pawn抵押物信息表 关联查询 按关联人为基准查询，抵押物可能重复显示（人ID多个拆分）
        setMortgageList(docCommonModel, variables);
    }

    private Map<String, Object> guarantee(String name, String idcard, String mobile, String address) {
        Map<String, Object> tempMap = new HashMap<>();
        tempMap.put("name", name);
        tempMap.put("idcard", idcard);
        tempMap.put("mobile", mobile);
        tempMap.put("address", address);
        return tempMap;
    }

    private void setGuaranteeList(DocCommonModel docCommonModel, Map<String, Object> variables) {
        List<Map<String, Object>> guaranteeList = new ArrayList<>();
        if (!docCommonModel.isContainsGuarantee() || CollectionUtils.isEmpty(docCommonModel.getGuarantorList())) {
            // 如果没有数据，需要初始化空数据进去，为了客户可以自己填充数据，保障表格样式统一
            guaranteeList.add(guarantee("", "", "", ""));

        } else {
            for (RelatedPersonnelInformation relatedPersonnelInformation : docCommonModel.getGuarantorList()) {
                guaranteeList.add(guarantee(relatedPersonnelInformation.getName(),
                        relatedPersonnelInformation.getIdentityNumber(),
                        relatedPersonnelInformation.getContactNumber(),
                        relatedPersonnelInformation.getCurrentHomeAddress()));
            }
        }

        // loan_basis 判断 isChoose 标准（可多选） guarantee_method 担保方式 逗号分隔 例如 保证,抵押
        // 如果 isChoose 未选中，则不需要查询后面的关联数据，  related_personnel_information 交叉type, 2,4; 3,4
        setGuaranteeListText(docCommonModel.isContainsGuarantee(), guaranteeList, variables);
    }

    private Map<String, Object> mortgage(String name, String mobile, String collateralType, String collateralArea,
                                         String collateralFee, String contactAddress, String collateralPosition) {
        Map<String, Object> tempMap1 = new HashMap<>();
        tempMap1.put("name", name);
        tempMap1.put("mobile", mobile);
        tempMap1.put("collateralName", collateralType);
        tempMap1.put("collateralAmount", collateralArea + "㎡");
        tempMap1.put("collateralFee", collateralFee);
        tempMap1.put("contactAddress", contactAddress);
        tempMap1.put("collateralPosition", collateralPosition);
        return tempMap1;
    }

    private void setMortgageList(DocCommonModel docCommonModel, Map<String, Object> variables) {
        List<Map<String, Object>> mortgageList = new ArrayList<>();
        if (!docCommonModel.isContainsMortgage() || CollectionUtils.isEmpty(docCommonModel.getPawnList())) {
            // 如果没有数据，需要初始化空数据进去，为了客户可以自己填充数据，保障表格样式统一
            mortgageList.add(mortgage("", "", "", "",
                    "", "", ""));

        } else {
            for (Pawn pawn : docCommonModel.getPawnList()) {
                String name = "";
                String mobile = "";
                String address = "";

                for (RelatedPersonnelInformation relatedPersonnelInformation : pawn.getRelatedPersonnelInformationList()) {
                    name += StringUtils.isEmpty(name) ? relatedPersonnelInformation.getName() :
                            "、" + relatedPersonnelInformation.getName();

                    mobile += StringUtils.isEmpty(mobile) ? relatedPersonnelInformation.getContactNumber() :
                            "、" + relatedPersonnelInformation.getContactNumber();

                    address += StringUtils.isEmpty(address) ? relatedPersonnelInformation.getCurrentHomeAddress() :
                            ";" + relatedPersonnelInformation.getCurrentHomeAddress();

                }

                // 抵押物类型 0房屋 1土地
                String collateralType = "";
                String collateralAmount = "";
                if(pawn.getMortgageType() == 1) {
                    collateralType = "土地";
                    collateralAmount = pawn.getLandOccupationArea();
                } else {
                    collateralType = "房产";
                    collateralAmount = pawn.getBuildingArea();
                }

                mortgageList.add(mortgage(name, mobile, collateralType, collateralAmount,
                        pawn.getValue(), address, pawn.getCollateralDeposit()));
            }
        }

        // loan_basis 判断 isChoose 标准（可多选） guarantee_method 担保方式 逗号分隔 例如 保证,抵押
        // 如果 isChoose 未选中，则不需要查询后面的关联数据，  related_personnel_information 交叉type, 2,4; 3,4
        setMortgageListText(docCommonModel.isContainsMortgage(), mortgageList, variables);
    }

    @Override
    protected String modelFileName() {
        return "个人借款申请表";
    }

    @Override
    protected DocConstants.DocType docType() {
        return DocConstants.DocType.WORD;
    }

    @Override
    protected int sort() {
        return 1_1_00;
    }

}
