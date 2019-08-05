package com.louis.kitty.admin.office;

import com.alibaba.druid.util.StringUtils;
import com.louis.kitty.admin.constants.DocConstants;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 个人借款申请表
 */

@Component
public class PersonalLoanApplicationTool extends AbstractOfficeTool {

    private String getValue(List<Map<String, Object>> list, int index, String key) {
        // 如果集合无数据，或者当前索引值 大于等于集合大小则返回空，因为前三行必须显示，顾以空填充
        if (CollectionUtils.isEmpty(list) || index >= list.size()) {
            return "";
        }

        return list.get(index).getOrDefault(key, "").toString();
    }


    /**
     * 设置担保情况---保证担保参数数据
     * @param isChoose 保证担保是否勾选
     * @param guaranteeList 保证担保参数集合信息
     */
    private void setGuaranteeList(boolean isChoose, List<Map<String, Object>> guaranteeList) {
        StringBuilder data = new StringBuilder();
        data.append("<w:tr>" + "  <w:tblPrEx>" + "<w:tblCellMar>" + "  <w:top w:w=\"0\" w:type=\"dxa\"/>" + "  <w:left w:w=\"108\" w:type=\"dxa\"/>" + "  <w:bottom w:w=\"0\" w:type=\"dxa\"/>" + "  <w:right w:w=\"108\" w:type=\"dxa\"/>" + "</w:tblCellMar>" + "  </w:tblPrEx>" + "  <w:trPr>" + "<w:gridBefore w:val=\"1\"/>" + "<w:wBefore w:w=\"10\" w:type=\"dxa\"/>" + "<w:trHeight w:val=\"295\" w:h-rule=\"atLeast\"/>" + "  </w:trPr>" + "  <w:tc>" + "<w:tcPr>" + "  <w:tcW w:w=\"1100\" w:type=\"dxa\"/>" + "  <w:gridSpan w:val=\"2\"/>" + "  <w:vmerge w:val=\"restart\"/>" + "  <w:tcBorders>" + "<w:top w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" + "<w:left w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" + "<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"000000\"/>" + "<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" + "  </w:tcBorders>" + "  <w:shd w:val=\"pct-10\" w:color=\"auto\" w:fill=\"auto\"/>" + "  <w:noWrap w:val=\"0\"/>" + "  <w:vAlign w:val=\"center\"/>" + "</w:tcPr>" + "<w:p>" + "  <w:pPr>" + "<w:widowControl/>" + "<w:jc w:val=\"left\"/>" + "<w:rPr>" + "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>" + "  <w:kern w:val=\"0\"/>" + "  <w:sz w:val=\"15\"/>" + "  <w:sz-cs w:val=\"15\"/>" + "</w:rPr>" + "  </w:pPr>" + "  <w:r>" + "<w:rPr>" + "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>" + "  <w:kern w:val=\"0\"/>" + "  <w:sz w:val=\"15\"/>" + "  <w:sz-cs w:val=\"15\"/>" + "</w:rPr>" + "<w:t> ").append(isChoose ? "☑" : "□").append("保证担保</w:t>").append("  </w:r>").append("</w:p>").append("  </w:tc>").append("  <w:tc>").append("<w:tcPr>").append("  <w:tcW w:w=\"1217\" w:type=\"dxa\"/>").append("  <w:tcBorders>").append("<w:top w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:left w:val=\"nil\"/>").append("<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("  </w:tcBorders>").append("  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>").append("  <w:noWrap w:val=\"0\"/>").append("  <w:vAlign w:val=\"center\"/>").append("</w:tcPr>").append("<w:p>").append("  <w:pPr>").append("<w:widowControl/>").append("<w:jc w:val=\"center\"/>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("  </w:pPr>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("<w:t>担保人姓名1</w:t>").append("  </w:r>").append("</w:p>").append("  </w:tc>").append("  <w:tc>").append("<w:tcPr>").append("  <w:tcW w:w=\"951\" w:type=\"dxa\"/>").append("  <w:gridSpan w:val=\"2\"/>").append("  <w:tcBorders>").append("<w:top w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:left w:val=\"nil\"/>").append("<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:right w:val=\"nil\"/>").append("  </w:tcBorders>").append("  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>").append("  <w:noWrap w:val=\"0\"/>").append("  <w:vAlign w:val=\"center\"/>").append("</w:tcPr>").append("<w:p>").append("  <w:pPr>").append("<w:widowControl/>").append("<w:jc w:val=\"left\"/>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("  <w:lang w:val=\"EN-US\" w:fareast=\"ZH-CN\"/>").append("</w:rPr>").append("  </w:pPr>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("<w:t>").append(getValue(guaranteeList, 0, "name")).append("</w:t>").append("  </w:r>").append("</w:p>").append("  </w:tc>").append("  <w:tc>").append("<w:tcPr>").append("  <w:tcW w:w=\"741\" w:type=\"dxa\"/>").append("  <w:gridSpan w:val=\"2\"/>").append("  <w:tcBorders>").append("<w:top w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:left w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("  </w:tcBorders>").append("  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>").append("  <w:noWrap w:val=\"0\"/>").append("  <w:vAlign w:val=\"center\"/>").append("</w:tcPr>").append("<w:p>").append("  <w:pPr>").append("<w:widowControl/>").append("<w:ind w:left=\"-7\" w:left-chars=\"-52\" w:right=\"-107\" w:right-chars=\"-51\" w:hanging=\"102\" w:hanging-chars=\"68\"/>").append("<w:jc w:val=\"center\"/>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("  </w:pPr>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("<w:t>身份证号</w:t>").append("  </w:r>").append("</w:p>").append("  </w:tc>").append("  <w:tc>").append("<w:tcPr>").append("  <w:tcW w:w=\"1763\" w:type=\"dxa\"/>").append("  <w:gridSpan w:val=\"3\"/>").append("  <w:tcBorders>").append("<w:top w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:left w:val=\"nil\"/>").append("<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"000000\"/>").append("  </w:tcBorders>").append("  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>").append("  <w:noWrap w:val=\"0\"/>").append("  <w:vAlign w:val=\"center\"/>").append("</w:tcPr>").append("<w:p>").append("  <w:pPr>").append("<w:widowControl/>").append("<w:jc w:val=\"left\"/>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"FF0000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("  <w:lang w:val=\"EN-US\" w:fareast=\"ZH-CN\"/>").append("</w:rPr>").append("  </w:pPr>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("<w:t>").append(getValue(guaranteeList, 0, "idcard")).append("</w:t>").append("  </w:r>").append("  ").append("</w:p>").append("  </w:tc>").append("  <w:tc>").append("<w:tcPr>").append("  <w:tcW w:w=\"1637\" w:type=\"dxa\"/>").append("  <w:gridSpan w:val=\"2\"/>").append("  <w:tcBorders>").append("<w:top w:val=\"nil\"/>").append("<w:left w:val=\"nil\"/>").append("<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("  </w:tcBorders>").append("  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>").append("  <w:noWrap w:val=\"0\"/>").append("  <w:vAlign w:val=\"center\"/>").append("</w:tcPr>").append("<w:p>").append("  <w:pPr>").append("<w:widowControl/>").append("<w:jc w:val=\"left\"/>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("  </w:pPr>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("<w:t>电话：").append(getValue(guaranteeList, 0, "mobile")).append("</w:t>").append("  </w:r>").append("</w:p>").append("  </w:tc>").append("  <w:tc>").append("<w:tcPr>").append("  <w:tcW w:w=\"2814\" w:type=\"dxa\"/>").append("  <w:gridSpan w:val=\"3\"/>").append("  <w:tcBorders>").append("<w:top w:val=\"nil\"/>").append("<w:left w:val=\"nil\"/>").append("<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("  </w:tcBorders>").append("  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>").append("  <w:noWrap w:val=\"0\"/>").append("  <w:vAlign w:val=\"center\"/>").append("</w:tcPr>").append("<w:p>").append("  <w:pPr>").append("<w:widowControl/>").append("<w:spacing w:line=\"240\" w:line-rule=\"exact\"/>").append("<w:jc w:val=\"left\"/>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("  </w:pPr>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("<w:t> 地址：").append(getValue(guaranteeList, 0, "address")).append("</w:t>").append("  </w:r>").append("</w:p>").append("  </w:tc>").append("</w:tr>");

        int loopSize = guaranteeList.size() > 3 ? guaranteeList.size() : 3;
        for (int i = 1; i < loopSize; i++) {
            data.append("<w:tr>" + "  <w:tblPrEx>" + "<w:tblCellMar>" + "  <w:top w:w=\"0\" w:type=\"dxa\"/>" + "  <w:left w:w=\"108\" w:type=\"dxa\"/>" + "  <w:bottom w:w=\"0\" w:type=\"dxa\"/>" + "  <w:right w:w=\"108\" w:type=\"dxa\"/>" + "</w:tblCellMar>" + "  </w:tblPrEx>" + "  <w:trPr>" + "<w:gridBefore w:val=\"1\"/>" + "<w:wBefore w:w=\"10\" w:type=\"dxa\"/>" + "<w:trHeight w:val=\"243\" w:h-rule=\"atLeast\"/>" + "  </w:trPr>" + "  <w:tc>" + "<w:tcPr>" + "  <w:tcW w:w=\"1100\" w:type=\"dxa\"/>" + "  <w:gridSpan w:val=\"2\"/>" + "  <w:vmerge w:val=\"continue\"/>" + "  <w:tcBorders>" + "<w:top w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" + "<w:left w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" + "<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"000000\"/>" + "<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" + "  </w:tcBorders>" + "  <w:shd w:val=\"pct-10\" w:color=\"auto\" w:fill=\"auto\"/>" + "  <w:noWrap w:val=\"0\"/>" + "  <w:vAlign w:val=\"center\"/>" + "</w:tcPr>" + "<w:p>" + "  <w:pPr>" + "<w:widowControl/>" + "<w:jc w:val=\"left\"/>" + "<w:rPr>" + "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>" + "  <w:kern w:val=\"0\"/>" + "  <w:sz w:val=\"15\"/>" + "  <w:sz-cs w:val=\"15\"/>" + "</w:rPr>" + "  </w:pPr>" + "</w:p>" + "  </w:tc>" + "  <w:tc>" + "<w:tcPr>" + "  <w:tcW w:w=\"1217\" w:type=\"dxa\"/>" + "  <w:tcBorders>" + "<w:top w:val=\"nil\"/>" + "<w:left w:val=\"nil\"/>" + "<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" + "<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" + "  </w:tcBorders>" + "  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>" + "  <w:noWrap w:val=\"0\"/>" + "  <w:vAlign w:val=\"center\"/>" + "</w:tcPr>" + "<w:p>" + "  <w:pPr>" + "<w:widowControl/>" + "<w:jc w:val=\"center\"/>" + "<w:rPr>" + "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>" + "  <w:color w:val=\"000000\"/>" + "  <w:kern w:val=\"0\"/>" + "  <w:sz w:val=\"15\"/>" + "  <w:sz-cs w:val=\"15\"/>" + "</w:rPr>" + "  </w:pPr>" + "  <w:r>" + "<w:rPr>" + "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>" + "  <w:color w:val=\"000000\"/>" + "  <w:kern w:val=\"0\"/>" + "  <w:sz w:val=\"15\"/>" + "  <w:sz-cs w:val=\"15\"/>" + "</w:rPr>" + "<w:t>担保人姓名").append(i + 1).append("</w:t>").append("  </w:r>").append("</w:p>").append("  </w:tc>").append("  <w:tc>").append("<w:tcPr>").append("  <w:tcW w:w=\"951\" w:type=\"dxa\"/>").append("  <w:gridSpan w:val=\"2\"/>").append("  <w:tcBorders>").append("<w:top w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:left w:val=\"nil\"/>").append("<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:right w:val=\"nil\"/>").append("  </w:tcBorders>").append("  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>").append("  <w:noWrap w:val=\"0\"/>").append("  <w:vAlign w:val=\"center\"/>").append("</w:tcPr>").append("<w:p>").append("  <w:pPr>").append("<w:widowControl/>").append("<w:jc w:val=\"left\"/>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("  <w:lang w:val=\"EN-US\" w:fareast=\"ZH-CN\"/>").append("</w:rPr>").append("  </w:pPr>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("<w:t>").append(getValue(guaranteeList, i, "name")).append("</w:t>").append("  </w:r>").append("</w:p>").append("  </w:tc>").append("  <w:tc>").append("<w:tcPr>").append("  <w:tcW w:w=\"741\" w:type=\"dxa\"/>").append("  <w:gridSpan w:val=\"2\"/>").append("  <w:tcBorders>").append("<w:top w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:left w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("  </w:tcBorders>").append("  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>").append("  <w:noWrap w:val=\"0\"/>").append("  <w:vAlign w:val=\"center\"/>").append("</w:tcPr>").append("<w:p>").append("  <w:pPr>").append("<w:widowControl/>").append("<w:ind w:left=\"-7\" w:left-chars=\"-52\" w:right=\"-107\" w:right-chars=\"-51\" w:hanging=\"102\" w:hanging-chars=\"68\"/>").append("<w:jc w:val=\"center\"/>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("  </w:pPr>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("<w:t>身份证号</w:t>").append("  </w:r>").append("</w:p>").append("  </w:tc>").append("  <w:tc>").append("<w:tcPr>").append("  <w:tcW w:w=\"1763\" w:type=\"dxa\"/>").append("  <w:gridSpan w:val=\"3\"/>").append("  <w:tcBorders>").append("<w:top w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:left w:val=\"nil\"/>").append("<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"000000\"/>").append("  </w:tcBorders>").append("  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>").append("  <w:noWrap w:val=\"0\"/>").append("  <w:vAlign w:val=\"center\"/>").append("</w:tcPr>").append("<w:p>").append("  <w:pPr>").append("<w:widowControl/>").append("<w:jc w:val=\"left\"/>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"FF0000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("  <w:lang w:val=\"EN-US\" w:fareast=\"ZH-CN\"/>").append("</w:rPr>").append("  </w:pPr>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("<w:t>").append(getValue(guaranteeList, i, "idcard")).append("</w:t>").append("  </w:r>").append("  ").append("</w:p>").append("  </w:tc>").append("  <w:tc>").append("<w:tcPr>").append("  <w:tcW w:w=\"1637\" w:type=\"dxa\"/>").append("  <w:gridSpan w:val=\"2\"/>").append("  <w:tcBorders>").append("<w:top w:val=\"nil\"/>").append("<w:left w:val=\"nil\"/>").append("<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("  </w:tcBorders>").append("  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>").append("  <w:noWrap w:val=\"0\"/>").append("  <w:vAlign w:val=\"center\"/>").append("</w:tcPr>").append("<w:p>").append("  <w:pPr>").append("<w:widowControl/>").append("<w:jc w:val=\"left\"/>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("  </w:pPr>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("<w:t>电话：").append(getValue(guaranteeList, i, "mobile")).append("</w:t>").append("  </w:r>").append("</w:p>").append("  </w:tc>").append("  <w:tc>").append("<w:tcPr>").append("  <w:tcW w:w=\"2814\" w:type=\"dxa\"/>").append("  <w:gridSpan w:val=\"3\"/>").append("  <w:tcBorders>").append("<w:top w:val=\"nil\"/>").append("<w:left w:val=\"nil\"/>").append("<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("  </w:tcBorders>").append("  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>").append("  <w:noWrap w:val=\"0\"/>").append("  <w:vAlign w:val=\"center\"/>").append("</w:tcPr>").append("<w:p>").append("  <w:pPr>").append("<w:widowControl/>").append("<w:spacing w:line=\"240\" w:line-rule=\"exact\"/>").append("<w:jc w:val=\"left\"/>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("  </w:pPr>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("<w:t> 地址：").append(getValue(guaranteeList, i, "address")).append("</w:t>").append("  </w:r>").append("</w:p>").append("  </w:tc>").append("</w:tr>");
        }


        VARIABLES_IN_MODEL.put("guaranteeList", data.toString());
    }

    /**
     * 设置担保情况---抵押担保参数数据
     * @param isChoose 抵押担保是否勾选
     * @param mortgageList 抵押担保参数集合信息
     */
    private void setMortgageList(boolean isChoose, List<Map<String, Object>> mortgageList) {
        StringBuilder data = new StringBuilder();
        data.append("<w:tr>" + "  <w:tblPrEx>" + "<w:tblCellMar>" + "  <w:top w:w=\"0\" w:type=\"dxa\"/>" + "  <w:left w:w=\"108\" w:type=\"dxa\"/>" + "  <w:bottom w:w=\"0\" w:type=\"dxa\"/>" + "  <w:right w:w=\"108\" w:type=\"dxa\"/>" + "</w:tblCellMar>" + "  </w:tblPrEx>" + "  <w:trPr>" + "<w:gridBefore w:val=\"1\"/>" + "<w:wBefore w:w=\"10\" w:type=\"dxa\"/>" + "<w:trHeight w:val=\"612\" w:h-rule=\"atLeast\"/>" + "  </w:trPr>" + "  <w:tc>" + "<w:tcPr>" + "  <w:tcW w:w=\"1100\" w:type=\"dxa\"/>" + "  <w:gridSpan w:val=\"2\"/>" + "  <w:vmerge w:val=\"restart\"/>" + "  <w:tcBorders>" + "<w:top w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" + "<w:left w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" + "<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"000000\"/>" + "<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" + "  </w:tcBorders>" + "  <w:shd w:val=\"pct-10\" w:color=\"auto\" w:fill=\"auto\"/>" + "  <w:noWrap w:val=\"0\"/>" + "  <w:vAlign w:val=\"center\"/>" + "</w:tcPr>" + "<w:p>" + "  <w:pPr>" + "<w:widowControl/>" + "<w:jc w:val=\"center\"/>" + "<w:rPr>" + "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>" + "  <w:color w:val=\"000000\"/>" + "  <w:kern w:val=\"0\"/>" + "  <w:sz w:val=\"15\"/>" + "  <w:sz-cs w:val=\"15\"/>" + "</w:rPr>" + "  </w:pPr>" + "  <w:r>" + "<w:rPr>" + "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>" + "  <w:color w:val=\"000000\"/>" + "  <w:kern w:val=\"0\"/>" + "  <w:sz w:val=\"15\"/>" + "  <w:sz-cs w:val=\"15\"/>" + "</w:rPr>" + "<w:t>").append(isChoose ? "☑" : "□").append("抵押担保</w:t>").append("  </w:r>").append("</w:p>").append("  </w:tc>").append("  <w:tc>").append("<w:tcPr>").append("  <w:tcW w:w=\"1217\" w:type=\"dxa\"/>").append("  <w:tcBorders>").append("<w:top w:val=\"nil\"/>").append("<w:left w:val=\"nil\"/>").append("<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("  </w:tcBorders>").append("  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>").append("  <w:noWrap w:val=\"0\"/>").append("  <w:vAlign w:val=\"center\"/>").append("</w:tcPr>").append("<w:p>").append("  <w:pPr>").append("<w:widowControl/>").append("<w:jc w:val=\"center\"/>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("  </w:pPr>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("<w:t> 抵押人1姓名</w:t>").append("  </w:r>").append("</w:p>").append("  </w:tc>").append("  <w:tc>").append("<w:tcPr>").append("  <w:tcW w:w=\"951\" w:type=\"dxa\"/>").append("  <w:gridSpan w:val=\"2\"/>").append("  <w:tcBorders>").append("<w:top w:val=\"nil\"/>").append("<w:left w:val=\"nil\"/>").append("<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:right w:val=\"nil\"/>").append("  </w:tcBorders>").append("  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>").append("  <w:noWrap w:val=\"0\"/>").append("  <w:vAlign w:val=\"center\"/>").append("</w:tcPr>").append("<w:p>").append("  <w:pPr>").append("<w:widowControl/>").append("<w:jc w:val=\"center\"/>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("  </w:pPr>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("<w:t>").append(getValue(mortgageList, 0, "name")).append("</w:t>").append("  </w:r>").append("</w:p>").append("  </w:tc>").append("  <w:tc>").append("<w:tcPr>").append("  <w:tcW w:w=\"741\" w:type=\"dxa\"/>").append("  <w:gridSpan w:val=\"2\"/>").append("  <w:tcBorders>").append("<w:top w:val=\"nil\"/>").append("<w:left w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:right w:val=\"nil\"/>").append("  </w:tcBorders>").append("  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>").append("  <w:noWrap w:val=\"0\"/>").append("  <w:vAlign w:val=\"center\"/>").append("</w:tcPr>").append("<w:p>").append("  <w:pPr>").append("<w:widowControl/>").append("<w:ind w:left=\"-7\" w:left-chars=\"-52\" w:right=\"-122\" w:right-chars=\"-58\" w:hanging=\"102\" w:hanging-chars=\"68\"/>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("  </w:pPr>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("<w:t> 联系电话</w:t>").append("  </w:r>").append("</w:p>").append("  </w:tc>").append("  <w:tc>").append("<w:tcPr>").append("  <w:tcW w:w=\"1289\" w:type=\"dxa\"/>").append("  <w:gridSpan w:val=\"2\"/>").append("  <w:tcBorders>").append("<w:top w:val=\"nil\"/>").append("<w:left w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("  </w:tcBorders>").append("  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>").append("  <w:noWrap w:val=\"0\"/>").append("  <w:vAlign w:val=\"center\"/>").append("</w:tcPr>").append("<w:p>").append("  <w:pPr>").append("<w:widowControl/>").append("<w:jc w:val=\"left\"/>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("  </w:pPr>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("<w:t>").append(getValue(mortgageList, 0, "mobile")).append("</w:t>").append("  </w:r>").append("</w:p>").append("  </w:tc>").append("  <w:tc>").append("<w:tcPr>").append("  <w:tcW w:w=\"4925\" w:type=\"dxa\"/>").append("  <w:gridSpan w:val=\"6\"/>").append("  <w:tcBorders>").append("<w:top w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:left w:val=\"nil\"/>").append("<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"000000\"/>").append("  </w:tcBorders>").append("  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>").append("  <w:noWrap w:val=\"0\"/>").append("  <w:vAlign w:val=\"center\"/>").append("</w:tcPr>").append("<w:p>").append("  <w:pPr>").append("<w:widowControl/>").append("<w:ind w:left=\"-8\" w:left-chars=\"-57\" w:hanging=\"112\" w:hanging-chars=\"75\"/>").append("<w:jc w:val=\"center\"/>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("  </w:pPr>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("<w:t>抵押物名称</w:t>").append("  </w:r>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("  <w:u w:val=\"single\"/>").append("</w:rPr>").append("<w:t>： ").append(getValue(mortgageList, 0, "collateralName")).append(" </w:t>").append("  </w:r>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("<w:t> 抵押物数量</w:t>").append("  </w:r>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("  <w:u w:val=\"single\"/>").append("</w:rPr>").append("<w:t>：").append(getValue(mortgageList, 0, "collateralAmount")).append("</w:t>").append("  </w:r>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("  <w:u w:val=\"single\"/>").append("</w:rPr>").append("<w:t>㎡</w:t>").append("  </w:r>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("  <w:u w:val=\"single\"/>").append("</w:rPr>").append("<w:t>     </w:t>").append("  </w:r>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("<w:t> 价值</w:t>").append("  </w:r>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("  <w:u w:val=\"single\"/>").append("</w:rPr>").append("<w:t>：").append(getValue(mortgageList, 0, "collateralFee")).append("</w:t>").append("  </w:r>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("<w:t>元</w:t>").append("  </w:r>").append("</w:p>").append("  </w:tc>").append("</w:tr>").append("<w:tr>").append("  <w:tblPrEx>").append("<w:tblCellMar>").append("  <w:top w:w=\"0\" w:type=\"dxa\"/>").append("  <w:left w:w=\"108\" w:type=\"dxa\"/>").append("  <w:bottom w:w=\"0\" w:type=\"dxa\"/>").append("  <w:right w:w=\"108\" w:type=\"dxa\"/>").append("</w:tblCellMar>").append("  </w:tblPrEx>").append("  <w:trPr>").append("<w:gridBefore w:val=\"1\"/>").append("<w:wBefore w:w=\"10\" w:type=\"dxa\"/>").append("<w:trHeight w:val=\"400\" w:h-rule=\"atLeast\"/>").append("  </w:trPr>").append("  <w:tc>").append("<w:tcPr>").append("  <w:tcW w:w=\"1100\" w:type=\"dxa\"/>").append("  <w:gridSpan w:val=\"2\"/>").append("  <w:vmerge w:val=\"continue\"/>").append("  <w:tcBorders>").append("<w:top w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:left w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"000000\"/>").append("<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("  </w:tcBorders>").append("  <w:shd w:val=\"pct-10\" w:color=\"auto\" w:fill=\"auto\"/>").append("  <w:noWrap w:val=\"0\"/>").append("  <w:vAlign w:val=\"center\"/>").append("</w:tcPr>").append("<w:p>").append("  <w:pPr>").append("<w:widowControl/>").append("<w:jc w:val=\"left\"/>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("  </w:pPr>").append("</w:p>").append("  </w:tc>").append("  <w:tc>").append("<w:tcPr>").append("  <w:tcW w:w=\"1217\" w:type=\"dxa\"/>").append("  <w:tcBorders>").append("<w:top w:val=\"nil\"/>").append("<w:left w:val=\"nil\"/>").append("<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:right w:val=\"nil\"/>").append("  </w:tcBorders>").append("  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>").append("  <w:noWrap w:val=\"0\"/>").append("  <w:vAlign w:val=\"center\"/>").append("</w:tcPr>").append("<w:p>").append("  <w:pPr>").append("<w:widowControl/>").append("<w:jc w:val=\"center\"/>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("  </w:pPr>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("<w:t> 联 系 地 址</w:t>").append("  </w:r>").append("</w:p>").append("  </w:tc>").append("  <w:tc>").append("<w:tcPr>").append("  <w:tcW w:w=\"3455\" w:type=\"dxa\"/>").append("  <w:gridSpan w:val=\"7\"/>").append("  <w:tcBorders>").append("<w:top w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:left w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"000000\"/>").append("  </w:tcBorders>").append("  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>").append("  <w:noWrap w:val=\"0\"/>").append("  <w:vAlign w:val=\"center\"/>").append("</w:tcPr>").append("<w:p>").append("  <w:pPr>").append("<w:widowControl/>").append("<w:jc w:val=\"center\"/>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("  </w:pPr>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("<w:t>").append(getValue(mortgageList, 0, "contactAddress")).append("</w:t>").append("  </w:r>").append("</w:p>").append("  </w:tc>").append("  <w:tc>").append("<w:tcPr>").append("  <w:tcW w:w=\"1637\" w:type=\"dxa\"/>").append("  <w:gridSpan w:val=\"2\"/>").append("  <w:tcBorders>").append("<w:top w:val=\"nil\"/>").append("<w:left w:val=\"nil\"/>").append("<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("  </w:tcBorders>").append("  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>").append("  <w:noWrap w:val=\"0\"/>").append("  <w:vAlign w:val=\"center\"/>").append("</w:tcPr>").append("<w:p>").append("  <w:pPr>").append("<w:widowControl/>").append("<w:jc w:val=\"center\"/>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("  </w:pPr>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("<w:t>抵押物存放地</w:t>").append("  </w:r>").append("</w:p>").append("  </w:tc>").append("  <w:tc>").append("<w:tcPr>").append("  <w:tcW w:w=\"2814\" w:type=\"dxa\"/>").append("  <w:gridSpan w:val=\"3\"/>").append("  <w:tcBorders>").append("<w:top w:val=\"nil\"/>").append("<w:left w:val=\"nil\"/>").append("<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("  </w:tcBorders>").append("  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>").append("  <w:noWrap w:val=\"0\"/>").append("  <w:vAlign w:val=\"center\"/>").append("</w:tcPr>").append("<w:p>").append("  <w:pPr>").append("<w:widowControl/>").append("<w:jc w:val=\"left\"/>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("  </w:pPr>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("<w:t>").append(getValue(mortgageList, 0, "collateralPosition")).append("</w:t>").append("  </w:r>").append("</w:p>").append("  </w:tc>").append("</w:tr>");

        int loopSize = mortgageList.size() > 2 ? mortgageList.size() : 2;
        for (int i = 1; i < loopSize; i++) {
            data.append("<w:tr>" + "  <w:tblPrEx>" + "<w:tblCellMar>" + "  <w:top w:w=\"0\" w:type=\"dxa\"/>" + "  <w:left w:w=\"108\" w:type=\"dxa\"/>" + "  <w:bottom w:w=\"0\" w:type=\"dxa\"/>" + "  <w:right w:w=\"108\" w:type=\"dxa\"/>" + "</w:tblCellMar>" + "  </w:tblPrEx>" + "  <w:trPr>" + "<w:gridBefore w:val=\"1\"/>" + "<w:wBefore w:w=\"10\" w:type=\"dxa\"/>" + "<w:trHeight w:val=\"612\" w:h-rule=\"atLeast\"/>" + "  </w:trPr>" + "  <w:tc>" + "<w:tcPr>" + "  <w:tcW w:w=\"1100\" w:type=\"dxa\"/>" + "  <w:gridSpan w:val=\"2\"/>" + "  <w:vmerge w:val=\"continue\"/>" + "  <w:tcBorders>" + "<w:top w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" + "<w:left w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" + "<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"000000\"/>" + "<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" + "  </w:tcBorders>" + "  <w:shd w:val=\"pct-10\" w:color=\"auto\" w:fill=\"auto\"/>" + "  <w:noWrap w:val=\"0\"/>" + "  <w:vAlign w:val=\"center\"/>" + "</w:tcPr>" + "<w:p>" + "  <w:pPr>" + "<w:widowControl/>" + "<w:jc w:val=\"left\"/>" + "<w:rPr>" + "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>" + "  <w:color w:val=\"000000\"/>" + "  <w:kern w:val=\"0\"/>" + "  <w:sz w:val=\"15\"/>" + "  <w:sz-cs w:val=\"15\"/>" + "</w:rPr>" + "  </w:pPr>" + "</w:p>" + "  </w:tc>" + "  <w:tc>" + "<w:tcPr>" + "  <w:tcW w:w=\"1217\" w:type=\"dxa\"/>" + "  <w:tcBorders>" + "<w:top w:val=\"nil\"/>" + "<w:left w:val=\"nil\"/>" + "<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" + "<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" + "  </w:tcBorders>" + "  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>" + "  <w:noWrap w:val=\"0\"/>" + "  <w:vAlign w:val=\"center\"/>" + "</w:tcPr>" + "<w:p>" + "  <w:pPr>" + "<w:widowControl/>" + "<w:jc w:val=\"center\"/>" + "<w:rPr>" + "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>" + "  <w:color w:val=\"000000\"/>" + "  <w:kern w:val=\"0\"/>" + "  <w:sz w:val=\"15\"/>" + "  <w:sz-cs w:val=\"15\"/>" + "</w:rPr>" + "  </w:pPr>" + "  <w:r>" + "<w:rPr>" + "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>" + "  <w:color w:val=\"000000\"/>" + "  <w:kern w:val=\"0\"/>" + "  <w:sz w:val=\"15\"/>" + "  <w:sz-cs w:val=\"15\"/>" + "</w:rPr>" + "<w:t> 抵押人").append(i + 1).append("姓名</w:t>").append("  </w:r>").append("</w:p>").append("  </w:tc>").append("  <w:tc>").append("<w:tcPr>").append("  <w:tcW w:w=\"951\" w:type=\"dxa\"/>").append("  <w:gridSpan w:val=\"2\"/>").append("  <w:tcBorders>").append("<w:top w:val=\"nil\"/>").append("<w:left w:val=\"nil\"/>").append("<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:right w:val=\"nil\"/>").append("  </w:tcBorders>").append("  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>").append("  <w:noWrap w:val=\"0\"/>").append("  <w:vAlign w:val=\"center\"/>").append("</w:tcPr>").append("<w:p>").append("  <w:pPr>").append("<w:widowControl/>").append("<w:jc w:val=\"left\"/>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("  </w:pPr>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("<w:t>").append(getValue(mortgageList, i, "name")).append("</w:t>").append("  </w:r>").append("</w:p>").append("  </w:tc>").append("  <w:tc>").append("<w:tcPr>").append("  <w:tcW w:w=\"741\" w:type=\"dxa\"/>").append("  <w:gridSpan w:val=\"2\"/>").append("  <w:tcBorders>").append("<w:top w:val=\"nil\"/>").append("<w:left w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:right w:val=\"nil\"/>").append("  </w:tcBorders>").append("  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>").append("  <w:noWrap w:val=\"0\"/>").append("  <w:vAlign w:val=\"center\"/>").append("</w:tcPr>").append("<w:p>").append("  <w:pPr>").append("<w:widowControl/>").append("<w:ind w:left=\"-7\" w:left-chars=\"-52\" w:right=\"-122\" w:right-chars=\"-58\" w:hanging=\"102\" w:hanging-chars=\"68\"/>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("  </w:pPr>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("<w:t> 联系电话</w:t>").append("  </w:r>").append("</w:p>").append("  </w:tc>").append("  <w:tc>").append("<w:tcPr>").append("  <w:tcW w:w=\"1289\" w:type=\"dxa\"/>").append("  <w:gridSpan w:val=\"2\"/>").append("  <w:tcBorders>").append("<w:top w:val=\"nil\"/>").append("<w:left w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("  </w:tcBorders>").append("  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>").append("  <w:noWrap w:val=\"0\"/>").append("  <w:vAlign w:val=\"center\"/>").append("</w:tcPr>").append("<w:p>").append("  <w:pPr>").append("<w:widowControl/>").append("<w:jc w:val=\"left\"/>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("  </w:pPr>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("<w:t>").append(getValue(mortgageList, i, "mobile")).append("</w:t>").append("  </w:r>").append("</w:p>").append("  </w:tc>").append("  <w:tc>").append("<w:tcPr>").append("  <w:tcW w:w=\"4925\" w:type=\"dxa\"/>").append("  <w:gridSpan w:val=\"6\"/>").append("  <w:tcBorders>").append("<w:top w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:left w:val=\"nil\"/>").append("<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>").append("<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"000000\"/>").append("  </w:tcBorders>").append("  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>").append("  <w:noWrap w:val=\"0\"/>").append("  <w:vAlign w:val=\"center\"/>").append("</w:tcPr>").append("<w:p>").append("  <w:pPr>").append("<w:widowControl/>").append("<w:ind w:left=\"-8\" w:left-chars=\"-57\" w:hanging=\"112\" w:hanging-chars=\"75\"/>").append("<w:jc w:val=\"center\"/>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("  </w:pPr>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("<w:t>抵押物名称</w:t>").append("  </w:r>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("  <w:u w:val=\"single\"/>").append("</w:rPr>").append("<w:t>： ").append(getValue(mortgageList, i, "collateralName")).append(" </w:t>").append("  </w:r>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("<w:t> 抵押物数量</w:t>").append("  </w:r>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("  <w:u w:val=\"single\"/>").append("</w:rPr>").append("<w:t>：").append(getValue(mortgageList, i, "collateralAmount")).append("</w:t>").append("  </w:r>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("  <w:u w:val=\"single\"/>").append("</w:rPr>").append("<w:t>㎡</w:t>").append("  </w:r>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("  <w:u w:val=\"single\"/>").append("</w:rPr>").append("<w:t>     </w:t>").append("  </w:r>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("<w:t> 价值</w:t>").append("  </w:r>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("  <w:u w:val=\"single\"/>").append("</w:rPr>").append("<w:t>：").append(getValue(mortgageList, i, "collateralFee")).append("</w:t>").append("  </w:r>").append("  <w:r>").append("<w:rPr>").append("  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>").append("  <w:color w:val=\"000000\"/>").append("  <w:kern w:val=\"0\"/>").append("  <w:sz w:val=\"15\"/>").append("  <w:sz-cs w:val=\"15\"/>").append("</w:rPr>").append("<w:t>元</w:t>").append("  </w:r>").append("</w:p>").append("  </w:tc>").append("</w:tr>").append("<w:tr>\n").append("  <w:tblPrEx>\n").append("\t<w:tblCellMar>\n").append("\t  <w:top w:w=\"0\" w:type=\"dxa\"/>\n").append("\t  <w:left w:w=\"108\" w:type=\"dxa\"/>\n").append("\t  <w:bottom w:w=\"0\" w:type=\"dxa\"/>\n").append("\t  <w:right w:w=\"108\" w:type=\"dxa\"/>\n").append("\t</w:tblCellMar>\n").append("  </w:tblPrEx>\n").append("  <w:trPr>\n").append("\t<w:gridBefore w:val=\"1\"/>\n").append("\t<w:wBefore w:w=\"10\" w:type=\"dxa\"/>\n").append("\t<w:trHeight w:val=\"400\" w:h-rule=\"atLeast\"/>\n").append("  </w:trPr>\n").append("  <w:tc>\n").append("\t<w:tcPr>\n").append("\t  <w:tcW w:w=\"1100\" w:type=\"dxa\"/>\n").append("\t  <w:gridSpan w:val=\"2\"/>\n").append("\t  <w:vmerge w:val=\"continue\"/>\n").append("\t  <w:tcBorders>\n").append("\t\t<w:top w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>\n").append("\t\t<w:left w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>\n").append("\t\t<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"000000\"/>\n").append("\t\t<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>\n").append("\t  </w:tcBorders>\n").append("\t  <w:shd w:val=\"pct-10\" w:color=\"auto\" w:fill=\"auto\"/>\n").append("\t  <w:noWrap w:val=\"0\"/>\n").append("\t  <w:vAlign w:val=\"center\"/>\n").append("\t</w:tcPr>\n").append("\t<w:p>\n").append("\t  <w:pPr>\n").append("\t\t<w:widowControl/>\n").append("\t\t<w:jc w:val=\"left\"/>\n").append("\t\t<w:rPr>\n").append("\t\t  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>\n").append("\t\t  <w:color w:val=\"000000\"/>\n").append("\t\t  <w:kern w:val=\"0\"/>\n").append("\t\t  <w:sz w:val=\"15\"/>\n").append("\t\t  <w:sz-cs w:val=\"15\"/>\n").append("\t\t</w:rPr>\n").append("\t  </w:pPr>\n").append("\t</w:p>\n").append("  </w:tc>\n").append("  <w:tc>\n").append("\t<w:tcPr>\n").append("\t  <w:tcW w:w=\"1217\" w:type=\"dxa\"/>\n").append("\t  <w:tcBorders>\n").append("\t\t<w:top w:val=\"nil\"/>\n").append("\t\t<w:left w:val=\"nil\"/>\n").append("\t\t<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>\n").append("\t\t<w:right w:val=\"nil\"/>\n").append("\t  </w:tcBorders>\n").append("\t  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>\n").append("\t  <w:noWrap w:val=\"0\"/>\n").append("\t  <w:vAlign w:val=\"center\"/>\n").append("\t</w:tcPr>\n").append("\t<w:p>\n").append("\t  <w:pPr>\n").append("\t\t<w:widowControl/>\n").append("\t\t<w:jc w:val=\"center\"/>\n").append("\t\t<w:rPr>\n").append("\t\t  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>\n").append("\t\t  <w:color w:val=\"000000\"/>\n").append("\t\t  <w:kern w:val=\"0\"/>\n").append("\t\t  <w:sz w:val=\"15\"/>\n").append("\t\t  <w:sz-cs w:val=\"15\"/>\n").append("\t\t</w:rPr>\n").append("\t  </w:pPr>\n").append("\t  <w:r>\n").append("\t\t<w:rPr>\n").append("\t\t  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>\n").append("\t\t  <w:color w:val=\"000000\"/>\n").append("\t\t  <w:kern w:val=\"0\"/>\n").append("\t\t  <w:sz w:val=\"15\"/>\n").append("\t\t  <w:sz-cs w:val=\"15\"/>\n").append("\t\t</w:rPr>\n").append("\t\t<w:t> 联 系 地 址</w:t>\n").append("\t  </w:r>\n").append("\t</w:p>\n").append("  </w:tc>\n").append("  <w:tc>\n").append("\t<w:tcPr>\n").append("\t  <w:tcW w:w=\"3455\" w:type=\"dxa\"/>\n").append("\t  <w:gridSpan w:val=\"7\"/>\n").append("\t  <w:tcBorders>\n").append("\t\t<w:top w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>\n").append("\t\t<w:left w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>\n").append("\t\t<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>\n").append("\t\t<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"000000\"/>\n").append("\t  </w:tcBorders>\n").append("\t  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>\n").append("\t  <w:noWrap w:val=\"0\"/>\n").append("\t  <w:vAlign w:val=\"center\"/>\n").append("\t</w:tcPr>\n").append("\t<w:p>\n").append("\t  <w:pPr>\n").append("\t\t<w:widowControl/>\n").append("\t\t<w:jc w:val=\"center\"/>\n").append("\t\t<w:rPr>\n").append("\t\t  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>\n").append("\t\t  <w:color w:val=\"000000\"/>\n").append("\t\t  <w:kern w:val=\"0\"/>\n").append("\t\t  <w:sz w:val=\"15\"/>\n").append("\t\t  <w:sz-cs w:val=\"15\"/>\n").append("\t\t</w:rPr>\n").append("\t  </w:pPr>\n").append("\t  <w:r>\n").append("\t\t<w:rPr>\n").append("\t\t  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>\n").append("\t\t  <w:color w:val=\"000000\"/>\n").append("\t\t  <w:kern w:val=\"0\"/>\n").append("\t\t  <w:sz w:val=\"15\"/>\n").append("\t\t  <w:sz-cs w:val=\"15\"/>\n").append("\t\t</w:rPr>\n").append("\t\t<w:t>").append(getValue(mortgageList, i, "contactAddress")).append("</w:t>\n").append("\t  </w:r>\n").append("\t</w:p>\n").append("  </w:tc>\n").append("  <w:tc>\n").append("\t<w:tcPr>\n").append("\t  <w:tcW w:w=\"1637\" w:type=\"dxa\"/>\n").append("\t  <w:gridSpan w:val=\"2\"/>\n").append("\t  <w:tcBorders>\n").append("\t\t<w:top w:val=\"nil\"/>\n").append("\t\t<w:left w:val=\"nil\"/>\n").append("\t\t<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>\n").append("\t\t<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>\n").append("\t  </w:tcBorders>\n").append("\t  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>\n").append("\t  <w:noWrap w:val=\"0\"/>\n").append("\t  <w:vAlign w:val=\"center\"/>\n").append("\t</w:tcPr>\n").append("\t<w:p>\n").append("\t  <w:pPr>\n").append("\t\t<w:widowControl/>\n").append("\t\t<w:jc w:val=\"center\"/>\n").append("\t\t<w:rPr>\n").append("\t\t  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>\n").append("\t\t  <w:color w:val=\"000000\"/>\n").append("\t\t  <w:kern w:val=\"0\"/>\n").append("\t\t  <w:sz w:val=\"15\"/>\n").append("\t\t  <w:sz-cs w:val=\"15\"/>\n").append("\t\t</w:rPr>\n").append("\t  </w:pPr>\n").append("\t  <w:r>\n").append("\t\t<w:rPr>\n").append("\t\t  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>\n").append("\t\t  <w:color w:val=\"000000\"/>\n").append("\t\t  <w:kern w:val=\"0\"/>\n").append("\t\t  <w:sz w:val=\"15\"/>\n").append("\t\t  <w:sz-cs w:val=\"15\"/>\n").append("\t\t</w:rPr>\n").append("\t\t<w:t>抵押物存放地</w:t>\n").append("\t  </w:r>\n").append("\t</w:p>\n").append("  </w:tc>\n").append("  <w:tc>\n").append("\t<w:tcPr>\n").append("\t  <w:tcW w:w=\"2814\" w:type=\"dxa\"/>\n").append("\t  <w:gridSpan w:val=\"3\"/>\n").append("\t  <w:tcBorders>\n").append("\t\t<w:top w:val=\"nil\"/>\n").append("\t\t<w:left w:val=\"nil\"/>\n").append("\t\t<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>\n").append("\t\t<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>\n").append("\t  </w:tcBorders>\n").append("\t  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>\n").append("\t  <w:noWrap w:val=\"0\"/>\n").append("\t  <w:vAlign w:val=\"center\"/>\n").append("\t</w:tcPr>\n").append("\t<w:p>\n").append("\t  <w:pPr>\n").append("\t\t<w:widowControl/>\n").append("\t\t<w:jc w:val=\"left\"/>\n").append("\t\t<w:rPr>\n").append("\t\t  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>\n").append("\t\t  <w:color w:val=\"000000\"/>\n").append("\t\t  <w:kern w:val=\"0\"/>\n").append("\t\t  <w:sz w:val=\"15\"/>\n").append("\t\t  <w:sz-cs w:val=\"15\"/>\n").append("\t\t</w:rPr>\n").append("\t  </w:pPr>\n").append("\t  <w:r>\n").append("\t\t<w:rPr>\n").append("\t\t  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>\n").append("\t\t  <w:color w:val=\"000000\"/>\n").append("\t\t  <w:kern w:val=\"0\"/>\n").append("\t\t  <w:sz w:val=\"15\"/>\n").append("\t\t  <w:sz-cs w:val=\"15\"/>\n").append("\t\t</w:rPr>\n").append("\t\t<w:t>").append(getValue(mortgageList, i, "collateralPosition")).append("</w:t>\n").append("\t  </w:r>\n").append("\t</w:p>\n").append("  </w:tc>\n").append("</w:tr>");
        }

        VARIABLES_IN_MODEL.put("mortgageList", data.toString());
    }

    private String setGender(String gender) {
        String personSex = "";
        if (StringUtils.isEmpty(gender)) {
            personSex = "□男 □女";
        } else if ("男".equals(gender)) {
            personSex = "☑男 □女";
        } else if ("女".equals(gender)) {
            personSex = "□男 ☑女";
        }

        return personSex;
    }

    private String setMaritalStatus(String maritalStatus) {
        String maritalStatusDes = "";
        if (StringUtils.isEmpty(maritalStatus)) {
            maritalStatusDes = "□已婚 □未婚 □离异 □丧偶 □其他";
        } else if ("已婚".equals(maritalStatus)) {
            maritalStatusDes = "☑已婚 □未婚 □离异 □丧偶 □其他";
        } else if ("未婚".equals(maritalStatus)) {
            maritalStatusDes = "□已婚 ☑未婚 □离异 □丧偶 □其他";
        } else if ("离异".equals(maritalStatus)) {
            maritalStatusDes = "□已婚 □未婚 ☑离异 □丧偶 □其他";
        } else if ("丧偶".equals(maritalStatus)) {
            maritalStatusDes = "□已婚 □未婚 □离异 ☑丧偶 □其他";
        } else if ("其他".equals(maritalStatus)) {
            maritalStatusDes = "□已婚 □未婚 □离异 □丧偶 ☑其他";
        }

        return maritalStatusDes;
    }

    private String setContactAddress(String contactAddress) {
        String contactAddressDes = "";
        if (StringUtils.isEmpty(contactAddress)) {
            contactAddressDes = "□现居住地址 □单位地址 □其他";
        } else if ("现居住地址".equals(contactAddress)) {
            contactAddressDes = "☑现居住地址 □单位地址 □其他";
        } else if ("单位地址".equals(contactAddress)) {
            contactAddressDes = "□现居住地址 ☑单位地址 □其他";
        } else if ("其他".equals(contactAddress)) {
            contactAddressDes = "□现居住地址 □单位地址 ☑其他";
        }

        return contactAddressDes;
    }

    private String setCurrentHousingSource(String currentHousingSource) {
        String currentHousingSourceDes = "";
        if (StringUtils.isEmpty(currentHousingSource)) {
            currentHousingSourceDes = "□自有住房 □贷款自有 □单位宿舍 □与父母同住 □租赁 □其他";
        } else if ("自有住房".equals(currentHousingSource)) {
            currentHousingSourceDes = "☑自有住房 □贷款自有 □单位宿舍 □与父母同住 □租赁 □其他";
        } else if ("贷款自有".equals(currentHousingSource)) {
            currentHousingSourceDes = "□自有住房 ☑贷款自有 □单位宿舍 □与父母同住 □租赁 □其他";
        } else if ("单位宿舍".equals(currentHousingSource)) {
            currentHousingSourceDes = "□自有住房 □贷款自有 ☑单位宿舍 □与父母同住 □租赁 □其他";
        } else if ("与父母同住".equals(currentHousingSource)) {
            currentHousingSourceDes = "□自有住房 □贷款自有 □单位宿舍 ☑与父母同住 □租赁 □其他";
        } else if ("租赁".equals(currentHousingSource)) {
            currentHousingSourceDes = "□自有住房 □贷款自有 □单位宿舍 □与父母同住 ☑租赁 □其他";
        } else if ("其他".equals(currentHousingSource)) {
            currentHousingSourceDes = "□自有住房 □贷款自有 □单位宿舍 □与父母同住 □租赁 ☑其他";
        }

        return currentHousingSourceDes;
    }

    private String setEducationalLevel(String educationalLevel) {
        String educationalLevelDes = "";
        if (StringUtils.isEmpty(educationalLevel)) {
            educationalLevelDes = "□研究生及以上 □本科 □大专 □中专/高中 □初中 □其他";
        } else if ("研究生及以上".equals(educationalLevel)) {
            educationalLevelDes = "☑研究生及以上 □本科 □大专 □中专/高中 □初中 □其他";
        } else if ("本科".equals(educationalLevel)) {
            educationalLevelDes = "□研究生及以上 ☑本科 □大专 □中专/高中 □初中 □其他";
        } else if ("大专".equals(educationalLevel)) {
            educationalLevelDes = "□研究生及以上 □本科 ☑大专 □中专/高中 □初中 □其他";
        } else if ("中专/高中".equals(educationalLevel)) {
            educationalLevelDes = "□研究生及以上 □本科 □大专 ☑中专/高中 □初中 □其他";
        } else if ("初中".equals(educationalLevel)) {
            educationalLevelDes = "□研究生及以上 □本科 □大专 □中专/高中 ☑初中 □其他";
        } else if ("其他".equals(educationalLevel)) {
            educationalLevelDes = "□研究生及以上 □本科 □大专 □中专/高中 □初中 ☑其他";
        }

        return educationalLevelDes;
    }

    private static String setUsage(String usage) {
        String usageDes = "";
        if (StringUtils.isEmpty(usage)) {
            usageDes = "□经营□自建房□购房□购车□住房装修□购买大额耐用消费品□旅游消费□留学□子女教育□其他";
        } else if ("经营".equals(usage)) {
            usageDes = "☑经营□自建房□购房□购车□住房装修□购买大额耐用消费品□旅游消费□留学□子女教育□其他";
        } else if ("自建房".equals(usage)) {
            usageDes = "□经营☑自建房□购房□购车□住房装修□购买大额耐用消费品□旅游消费□留学□子女教育□其他";
        } else if ("购房".equals(usage)) {
            usageDes = "□经营□自建房☑购房□购车□住房装修□购买大额耐用消费品□旅游消费□留学□子女教育□其他";
        } else if ("购车".equals(usage)) {
            usageDes = "□经营□自建房□购房☑购车□住房装修□购买大额耐用消费品□旅游消费□留学□子女教育□其他";
        } else if ("住房装修".equals(usage)) {
            usageDes = "□经营□自建房□购房□购车☑住房装修□购买大额耐用消费品□旅游消费□留学□子女教育□其他";
        } else if ("购买大额耐用消费品".equals(usage)) {
            usageDes = "□经营□自建房□购房□购车□住房装修☑购买大额耐用消费品□旅游消费□留学□子女教育□其他";
        } else if ("旅游消费".equals(usage)) {
            usageDes = "□经营□自建房□购房□购车□住房装修□购买大额耐用消费品☑旅游消费□留学□子女教育□其他";
        } else if ("留学".equals(usage)) {
            usageDes = "□经营□自建房□购房□购车□住房装修□购买大额耐用消费品□旅游消费☑留学□子女教育□其他";
        } else if ("子女教育".equals(usage)) {
            usageDes = "□经营□自建房□购房□购车□住房装修□购买大额耐用消费品□旅游消费□留学☑子女教育□其他";
        } else if ("其他".equals(usage)) {
            usageDes = "□经营□自建房□购房□购车□住房装修□购买大额耐用消费品□旅游消费□留学□子女教育☑其他";
        }

        return usageDes;
    }

    private String setPaymentMethod(String paymentMethod) {
        String paymentMethodDes = "";
        if (StringUtils.isEmpty(paymentMethod)) {
            paymentMethodDes = "□利随本清 □按月结息，到期一次性还本 □按月结息，分期还本 □按季结息，分期还本 □等额本金 □等额本息 □其他";
        } else if ("利随本清".equals(paymentMethod)) {
            paymentMethodDes = "☑利随本清 □按月结息，到期一次性还本 □按月结息，分期还本 □按季结息，分期还本 □等额本金 □等额本息 □其他";
        } else if ("按月结息，到期一次性还本".equals(paymentMethod)) {
            paymentMethodDes = "□利随本清 ☑按月结息，到期一次性还本 □按月结息，分期还本 □按季结息，分期还本 □等额本金 □等额本息 □其他";
        } else if ("按月结息，分期还本".equals(paymentMethod)) {
            paymentMethodDes = "□利随本清 □按月结息，到期一次性还本 ☑按月结息，分期还本 □按季结息，分期还本 □等额本金 □等额本息 □其他";
        } else if ("按季结息，分期还本".equals(paymentMethod)) {
            paymentMethodDes = "□利随本清 □按月结息，到期一次性还本 □按月结息，分期还本 ☑按季结息，分期还本 □等额本金 □等额本息 □其他";
        } else if ("等额本金".equals(paymentMethod)) {
            paymentMethodDes = "□利随本清 □按月结息，到期一次性还本 □按月结息，分期还本 □按季结息，分期还本 ☑等额本金 □等额本息 □其他";
        } else if ("等额本息".equals(paymentMethod)) {
            paymentMethodDes = "□利随本清 □按月结息，到期一次性还本 □按月结息，分期还本 □按季结息，分期还本 □等额本金 ☑等额本息 □其他";
        } else if ("其他".equals(paymentMethod)) {
            paymentMethodDes = "□利随本清 □按月结息，到期一次性还本 □按月结息，分期还本 □按季结息，分期还本 □等额本金 □等额本息 ☑其他";
        }

        return paymentMethodDes;
    }
    

    @Override
    protected void fillVariable(Long basisLoanId) {
        // 根据 basisLoanId 查询一系列数据结构

        VARIABLES_IN_MODEL.put("applyPersonName", "罗永芳");
        VARIABLES_IN_MODEL.put("applyPersonSex", setGender("女"));
        VARIABLES_IN_MODEL.put("applyPersonAge", 50);
        VARIABLES_IN_MODEL.put("applyPersonMaritalStatus", setMaritalStatus("已婚"));
        VARIABLES_IN_MODEL.put("applyPersonMaritalOther", "");

        VARIABLES_IN_MODEL.put("applyPersonIdentityNumber", "510102196901118483");
        VARIABLES_IN_MODEL.put("applyPersonDomicile", "广西桂林市象山区民主路12-1号");


        VARIABLES_IN_MODEL.put("applyPersonCurrentHomeAddress", "广西桂林市象山区民主路12-1号");
        VARIABLES_IN_MODEL.put("applyPersonLocalResidenceTime", 11);


        VARIABLES_IN_MODEL.put("applyPersonContactAddress", setContactAddress("现居住地址"));

        VARIABLES_IN_MODEL.put("applyPersonContactNumber", "15807737711");
        VARIABLES_IN_MODEL.put("applyPersonEmail", "");
        VARIABLES_IN_MODEL.put("applyPersonQQ", "");
        VARIABLES_IN_MODEL.put("applyPersonWeChat", "");

        VARIABLES_IN_MODEL.put("applyPersonEducationalLevel", setEducationalLevel(""));
        VARIABLES_IN_MODEL.put("applyPersonEducationalLevelOther", "");

        VARIABLES_IN_MODEL.put("applyPersonCurrentHousingSource", setCurrentHousingSource("单位宿舍"));
        VARIABLES_IN_MODEL.put("applyPersonCurrentHousingOther", "");

        VARIABLES_IN_MODEL.put("applyPersonEmployer", "");


        VARIABLES_IN_MODEL.put("applyPersonPosition", "");
        VARIABLES_IN_MODEL.put("applyPersonUnitWorkingYears", "");
        VARIABLES_IN_MODEL.put("applyPersonCompanyName", "");
        VARIABLES_IN_MODEL.put("applyPersonShareholdingRatio", "");
        VARIABLES_IN_MODEL.put("applyPersonYearsOperation", "");


        // 以下信息为配偶信息
        VARIABLES_IN_MODEL.put("coupleName", "唐建国");
        VARIABLES_IN_MODEL.put("coupleSex", setGender("男"));
        VARIABLES_IN_MODEL.put("coupleAge", 65);
        VARIABLES_IN_MODEL.put("coupleIdentityNumber", "45030519540601001X");
        VARIABLES_IN_MODEL.put("coupleDomicile", "广西桂林市象山区民主路12-1号");
        VARIABLES_IN_MODEL.put("coupleCurrentHomeAddress", "广西桂林市象山区民主路12-1号");
        VARIABLES_IN_MODEL.put("coupleLocalResidenceTime", 11);
        VARIABLES_IN_MODEL.put("coupleContactAddress", setContactAddress("现居住地址"));
        VARIABLES_IN_MODEL.put("coupleContactNumber", "13707737775");
        VARIABLES_IN_MODEL.put("coupleEmail", "");
        VARIABLES_IN_MODEL.put("coupleQQ", "");

        VARIABLES_IN_MODEL.put("coupleWeChat", "");
        VARIABLES_IN_MODEL.put("coupleEducationalLevel", setEducationalLevel(""));
        VARIABLES_IN_MODEL.put("coupleEducationalLevelOther", "");

        VARIABLES_IN_MODEL.put("coupleCurrentHousingSource", setCurrentHousingSource("单位宿舍"));
        VARIABLES_IN_MODEL.put("coupleCurrentHousingOther", "");


        VARIABLES_IN_MODEL.put("coupleEmployer", "");
        VARIABLES_IN_MODEL.put("couplePosition", "");
        VARIABLES_IN_MODEL.put("coupleUnitWorkingYears", "");

        VARIABLES_IN_MODEL.put("coupleCompanyName", "");
        VARIABLES_IN_MODEL.put("coupleShareholdingRatio", "");
        VARIABLES_IN_MODEL.put("coupleYearsOperation", "");


        // 申请人家庭收支情况

        // 申请人家庭收支情况--家庭总收入
        VARIABLES_IN_MODEL.put("totalRevenue", "300万");
        VARIABLES_IN_MODEL.put("applicantAnnualIncome", "");
        VARIABLES_IN_MODEL.put("applicantOperatingIncome", "150万");
        VARIABLES_IN_MODEL.put("applicantOtherIncome", "150万");

        VARIABLES_IN_MODEL.put("spouseAnnualIncome", "");
        VARIABLES_IN_MODEL.put("spouseOperatingIncome", "");
        VARIABLES_IN_MODEL.put("spouseOtherIncome", "");

        // 申请人家庭收支情况--家庭总支出
        VARIABLES_IN_MODEL.put("totalAnnualExpenditure", "80万");
        VARIABLES_IN_MODEL.put("lifeTotalExpenditure", "");
        VARIABLES_IN_MODEL.put("basicLifeTotalExpenditure", "20万");
        VARIABLES_IN_MODEL.put("educationExpenditure", "");
        VARIABLES_IN_MODEL.put("temporaryExpenditure", "");
        VARIABLES_IN_MODEL.put("debtTotalExpenditure", "");
        VARIABLES_IN_MODEL.put("annualLoanExpenditure", "");
        VARIABLES_IN_MODEL.put("spouseTemporaryExpenditure", "");
        VARIABLES_IN_MODEL.put("supportPopulation", "");
        VARIABLES_IN_MODEL.put("foreignGuaranteeLumpSum", "");

        // 申请借款情况
        VARIABLES_IN_MODEL.put("applicationsAmount", "贰佰万");
        VARIABLES_IN_MODEL.put("applicationDeadline", "叁");
        VARIABLES_IN_MODEL.put("isRound", setYesOption("是"));

        VARIABLES_IN_MODEL.put("usage", setUsage("其他"));
        VARIABLES_IN_MODEL.put("usageOther", "用于归还借款人罗永芳在广西桂林漓江农村合作银行合同编号为361102150060192、展期协议编号为：361126180056081合同项下所欠债务。");

        VARIABLES_IN_MODEL.put("paymentMethod", setPaymentMethod("按月结息，分期还本"));
        VARIABLES_IN_MODEL.put("paymentMethodOther", "");

        VARIABLES_IN_MODEL.put("isCombinedLoans", setYesOption(""));
        VARIABLES_IN_MODEL.put("publicLoanCommitment", "");

        List<Map<String, Object>> guaranteeList = new ArrayList<>();
        Map<String, Object> tempMap = new HashMap<>();
        tempMap.put("name", "唐建国");
        tempMap.put("idcard", "45030519540601001X");
        tempMap.put("mobile", "13707737775");
        tempMap.put("address", "广西桂林市叠彩区铁佛路6号2栋2单元501室");
        guaranteeList.add(tempMap);

        tempMap = new HashMap<>();
        tempMap.put("name", "ttt");
        tempMap.put("idcard", "33233333");
        tempMap.put("mobile", "33333");
        tempMap.put("address", "323234234234");
        guaranteeList.add(tempMap);

        tempMap = new HashMap<>();
        tempMap.put("name", "aaaaaa");
        tempMap.put("idcard", "3434343435345");
        tempMap.put("mobile", "343435534");
        tempMap.put("address", "szsadaerwerwer");
        guaranteeList.add(tempMap);

        tempMap = new HashMap<>();
        tempMap.put("name", "adfadsf");
        tempMap.put("idcard", "43334344343434");
        tempMap.put("mobile", "444444");
        tempMap.put("address", "3444444444444");
        guaranteeList.add(tempMap);

        tempMap = new HashMap<>();
        tempMap.put("name", "hhhhhhh");
        tempMap.put("idcard", "4444");
        tempMap.put("mobile", "232342");
        tempMap.put("address", "aaaaaaaaaaaa");
        guaranteeList.add(tempMap);

        setGuaranteeList(true, guaranteeList);

        List<Map<String, Object>> mortgageList = new ArrayList<>();
        Map<String, Object> tempMap1 = new HashMap<>();
        tempMap1.put("name", "唐建国");
        tempMap1.put("mobile", "13707737775");
        tempMap1.put("collateralName", "房产");
        tempMap1.put("collateralAmount", "320.55㎡");
        tempMap1.put("collateralFee", "309.33万");
        tempMap1.put("contactAddress", "广西桂林市叠彩区铁佛路6号2栋2单元501室");
        tempMap1.put("collateralPosition", "秀峰区中山中路38号智能办公大厦五层503、504号办公用房");
        mortgageList.add(tempMap1);

        tempMap1 = new HashMap<>();
        tempMap1.put("name", "罗永芳");
        tempMap1.put("mobile", "15807737711");
        tempMap1.put("collateralName", "房产");
        tempMap1.put("collateralAmount", "320.55㎡");
        tempMap1.put("collateralFee", "309.33万");
        tempMap1.put("contactAddress", "广西桂林市象山区民主路12-1号");
        tempMap1.put("collateralPosition", "秀峰区中山中路38号智能办公大厦五层503、504号办公用房");
        mortgageList.add(tempMap1);

        tempMap1 = new HashMap<>();
        tempMap1.put("name", "罗永芳222");
        tempMap1.put("mobile", "232323");
        tempMap1.put("collateralName", "房产");
        tempMap1.put("collateralAmount", "311.55㎡");
        tempMap1.put("collateralFee", "3119.33万");
        tempMap1.put("contactAddress", "2323232-1号");
        tempMap1.put("collateralPosition", "333333334、504号办公用房");
        mortgageList.add(tempMap1);

        tempMap1 = new HashMap<>();
        tempMap1.put("name", "罗2223");
        tempMap1.put("mobile", "33343434");
        tempMap1.put("collateralName", "房产");
        tempMap1.put("collateralAmount", "340.55㎡");
        tempMap1.put("collateralFee", "309333.33万");
        tempMap1.put("contactAddress", "234234-1号");
        tempMap1.put("collateralPosition", "45455544344、444f2334");
        mortgageList.add(tempMap1);

        setMortgageList(true, mortgageList);
    }

    @Override
    protected String modelFileName() {
        return "个人借款申请表";
    }

    @Override
    protected DocConstants.DocType docType() {
        return DocConstants.DocType.WORD;
    }

}
