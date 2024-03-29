package com.huashi.bank.test.xml;

import com.alibaba.druid.util.StringUtils;
import com.louis.kitty.admin.util.RmbUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class XmlToWord1Test {

    private static final String DIR = "/Users/tenx/Documents/test/model/xml/";

    String sourceDoc;
    String targetDoc;

    String xmlContent;

    private final Map<String, Object> variables = new HashMap<>();

    @Before
    public void init() {
        sourceDoc = "/个人借款申请表.xml";
        targetDoc = "/个人借款申请表_113.doc";
    }

    private void readXml() throws Exception {
        xmlContent = new String(Files.readAllBytes(Paths.get(DIR + sourceDoc)), Charset.forName("UTF-8"));
        log.info(xmlContent);
    }

    private String getValue(List<Map<String, Object>> list, int index, String key) {
        // 如果集合无数据，或者当前索引值 大于等于集合大小则返回空，因为前三行必须显示，顾以空填充
        if (CollectionUtils.isEmpty(list) || index >= list.size()) {
            return "";
        }

        return list.get(index).getOrDefault(key, "").toString();
    }

    private void buildGuaranteeList(boolean isChoose, List<Map<String, Object>> guaranteeList) {
        StringBuilder data = new StringBuilder();
        data.append("<w:tr>" +
                "  <w:tblPrEx>" +
                "<w:tblCellMar>" +
                "  <w:top w:w=\"0\" w:type=\"dxa\"/>" +
                "  <w:left w:w=\"108\" w:type=\"dxa\"/>" +
                "  <w:bottom w:w=\"0\" w:type=\"dxa\"/>" +
                "  <w:right w:w=\"108\" w:type=\"dxa\"/>" +
                "</w:tblCellMar>" +
                "  </w:tblPrEx>" +
                "  <w:trPr>" +
                "<w:gridBefore w:val=\"1\"/>" +
                "<w:wBefore w:w=\"10\" w:type=\"dxa\"/>" +
                "<w:trHeight w:val=\"295\" w:h-rule=\"atLeast\"/>" +
                "  </w:trPr>" +
                "  <w:tc>" +
                "<w:tcPr>" +
                "  <w:tcW w:w=\"1100\" w:type=\"dxa\"/>" +
                "  <w:gridSpan w:val=\"2\"/>" +
                "  <w:vmerge w:val=\"restart\"/>" +
                "  <w:tcBorders>" +
                "<w:top w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                "<w:left w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                "<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"000000\"/>" +
                "<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                "  </w:tcBorders>" +
                "  <w:shd w:val=\"pct-10\" w:color=\"auto\" w:fill=\"auto\"/>" +
                "  <w:noWrap w:val=\"0\"/>" +
                "  <w:vAlign w:val=\"center\"/>" +
                "</w:tcPr>" +
                "<w:p>" +
                "  <w:pPr>" +
                "<w:widowControl/>" +
                "<w:jc w:val=\"left\"/>" +
                "<w:rPr>" +
                "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>" +
                "  <w:kern w:val=\"0\"/>" +
                "  <w:sz w:val=\"15\"/>" +
                "  <w:sz-cs w:val=\"15\"/>" +
                "</w:rPr>" +
                "  </w:pPr>" +
                "  <w:r>" +
                "<w:rPr>" +
                "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>" +
                "  <w:kern w:val=\"0\"/>" +
                "  <w:sz w:val=\"15\"/>" +
                "  <w:sz-cs w:val=\"15\"/>" +
                "</w:rPr>" +
                "<w:t> " + (isChoose ? "☑" : "□") + "保证担保</w:t>" +
                "  </w:r>" +
                "</w:p>" +
                "  </w:tc>" +
                "  <w:tc>" +
                "<w:tcPr>" +
                "  <w:tcW w:w=\"1217\" w:type=\"dxa\"/>" +
                "  <w:tcBorders>" +
                "<w:top w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                "<w:left w:val=\"nil\"/>" +
                "<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                "<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                "  </w:tcBorders>" +
                "  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>" +
                "  <w:noWrap w:val=\"0\"/>" +
                "  <w:vAlign w:val=\"center\"/>" +
                "</w:tcPr>" +
                "<w:p>" +
                "  <w:pPr>" +
                "<w:widowControl/>" +
                "<w:jc w:val=\"center\"/>" +
                "<w:rPr>" +
                "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>" +
                "  <w:color w:val=\"000000\"/>" +
                "  <w:kern w:val=\"0\"/>" +
                "  <w:sz w:val=\"15\"/>" +
                "  <w:sz-cs w:val=\"15\"/>" +
                "</w:rPr>" +
                "  </w:pPr>" +
                "  <w:r>" +
                "<w:rPr>" +
                "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>" +
                "  <w:color w:val=\"000000\"/>" +
                "  <w:kern w:val=\"0\"/>" +
                "  <w:sz w:val=\"15\"/>" +
                "  <w:sz-cs w:val=\"15\"/>" +
                "</w:rPr>" +
                "<w:t>担保人姓名1</w:t>" +
                "  </w:r>" +
                "</w:p>" +
                "  </w:tc>" +
                "  <w:tc>" +
                "<w:tcPr>" +
                "  <w:tcW w:w=\"951\" w:type=\"dxa\"/>" +
                "  <w:gridSpan w:val=\"2\"/>" +
                "  <w:tcBorders>" +
                "<w:top w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                "<w:left w:val=\"nil\"/>" +
                "<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                "<w:right w:val=\"nil\"/>" +
                "  </w:tcBorders>" +
                "  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>" +
                "  <w:noWrap w:val=\"0\"/>" +
                "  <w:vAlign w:val=\"center\"/>" +
                "</w:tcPr>" +
                "<w:p>" +
                "  <w:pPr>" +
                "<w:widowControl/>" +
                "<w:jc w:val=\"left\"/>" +
                "<w:rPr>" +
                "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>" +
                "  <w:color w:val=\"000000\"/>" +
                "  <w:kern w:val=\"0\"/>" +
                "  <w:sz w:val=\"15\"/>" +
                "  <w:sz-cs w:val=\"15\"/>" +
                "  <w:lang w:val=\"EN-US\" w:fareast=\"ZH-CN\"/>" +
                "</w:rPr>" +
                "  </w:pPr>" +
                "  <w:r>" +
                "<w:rPr>" +
                "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>" +
                "  <w:color w:val=\"000000\"/>" +
                "  <w:kern w:val=\"0\"/>" +
                "  <w:sz w:val=\"15\"/>" +
                "  <w:sz-cs w:val=\"15\"/>" +
                "</w:rPr>" +
                "<w:t>" + getValue(guaranteeList, 0, "name") + "</w:t>" +
                "  </w:r>" +
                "</w:p>" +
                "  </w:tc>" +
                "  <w:tc>" +
                "<w:tcPr>" +
                "  <w:tcW w:w=\"741\" w:type=\"dxa\"/>" +
                "  <w:gridSpan w:val=\"2\"/>" +
                "  <w:tcBorders>" +
                "<w:top w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                "<w:left w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                "<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                "<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                "  </w:tcBorders>" +
                "  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>" +
                "  <w:noWrap w:val=\"0\"/>" +
                "  <w:vAlign w:val=\"center\"/>" +
                "</w:tcPr>" +
                "<w:p>" +
                "  <w:pPr>" +
                "<w:widowControl/>" +
                "<w:ind w:left=\"-7\" w:left-chars=\"-52\" w:right=\"-107\" w:right-chars=\"-51\" w:hanging=\"102\" w:hanging-chars=\"68\"/>" +
                "<w:jc w:val=\"center\"/>" +
                "<w:rPr>" +
                "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>" +
                "  <w:color w:val=\"000000\"/>" +
                "  <w:kern w:val=\"0\"/>" +
                "  <w:sz w:val=\"15\"/>" +
                "  <w:sz-cs w:val=\"15\"/>" +
                "</w:rPr>" +
                "  </w:pPr>" +
                "  <w:r>" +
                "<w:rPr>" +
                "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>" +
                "  <w:color w:val=\"000000\"/>" +
                "  <w:kern w:val=\"0\"/>" +
                "  <w:sz w:val=\"15\"/>" +
                "  <w:sz-cs w:val=\"15\"/>" +
                "</w:rPr>" +
                "<w:t>身份证号</w:t>" +
                "  </w:r>" +
                "</w:p>" +
                "  </w:tc>" +
                "  <w:tc>" +
                "<w:tcPr>" +
                "  <w:tcW w:w=\"1763\" w:type=\"dxa\"/>" +
                "  <w:gridSpan w:val=\"3\"/>" +
                "  <w:tcBorders>" +
                "<w:top w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                "<w:left w:val=\"nil\"/>" +
                "<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                "<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"000000\"/>" +
                "  </w:tcBorders>" +
                "  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>" +
                "  <w:noWrap w:val=\"0\"/>" +
                "  <w:vAlign w:val=\"center\"/>" +
                "</w:tcPr>" +
                "<w:p>" +
                "  <w:pPr>" +
                "<w:widowControl/>" +
                "<w:jc w:val=\"left\"/>" +
                "<w:rPr>" +
                "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>" +
                "  <w:color w:val=\"FF0000\"/>" +
                "  <w:kern w:val=\"0\"/>" +
                "  <w:sz w:val=\"15\"/>" +
                "  <w:sz-cs w:val=\"15\"/>" +
                "  <w:lang w:val=\"EN-US\" w:fareast=\"ZH-CN\"/>" +
                "</w:rPr>" +
                "  </w:pPr>" +
                "  <w:r>" +
                "<w:rPr>" +
                "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>" +
                "  <w:color w:val=\"000000\"/>" +
                "  <w:kern w:val=\"0\"/>" +
                "  <w:sz w:val=\"15\"/>" +
                "  <w:sz-cs w:val=\"15\"/>" +
                "</w:rPr>" +
                "<w:t>" + getValue(guaranteeList, 0, "idcard") + "</w:t>" +
                "  </w:r>" +
                "  " +
                "</w:p>" +
                "  </w:tc>" +
                "  <w:tc>" +
                "<w:tcPr>" +
                "  <w:tcW w:w=\"1637\" w:type=\"dxa\"/>" +
                "  <w:gridSpan w:val=\"2\"/>" +
                "  <w:tcBorders>" +
                "<w:top w:val=\"nil\"/>" +
                "<w:left w:val=\"nil\"/>" +
                "<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                "<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                "  </w:tcBorders>" +
                "  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>" +
                "  <w:noWrap w:val=\"0\"/>" +
                "  <w:vAlign w:val=\"center\"/>" +
                "</w:tcPr>" +
                "<w:p>" +
                "  <w:pPr>" +
                "<w:widowControl/>" +
                "<w:jc w:val=\"left\"/>" +
                "<w:rPr>" +
                "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>" +
                "  <w:kern w:val=\"0\"/>" +
                "  <w:sz w:val=\"15\"/>" +
                "  <w:sz-cs w:val=\"15\"/>" +
                "</w:rPr>" +
                "  </w:pPr>" +
                "  <w:r>" +
                "<w:rPr>" +
                "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>" +
                "  <w:kern w:val=\"0\"/>" +
                "  <w:sz w:val=\"15\"/>" +
                "  <w:sz-cs w:val=\"15\"/>" +
                "</w:rPr>" +
                "<w:t>电话：" + getValue(guaranteeList, 0, "mobile") + "</w:t>" +
                "  </w:r>" +
                "</w:p>" +
                "  </w:tc>" +
                "  <w:tc>" +
                "<w:tcPr>" +
                "  <w:tcW w:w=\"2814\" w:type=\"dxa\"/>" +
                "  <w:gridSpan w:val=\"3\"/>" +
                "  <w:tcBorders>" +
                "<w:top w:val=\"nil\"/>" +
                "<w:left w:val=\"nil\"/>" +
                "<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                "<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                "  </w:tcBorders>" +
                "  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>" +
                "  <w:noWrap w:val=\"0\"/>" +
                "  <w:vAlign w:val=\"center\"/>" +
                "</w:tcPr>" +
                "<w:p>" +
                "  <w:pPr>" +
                "<w:widowControl/>" +
                "<w:spacing w:line=\"240\" w:line-rule=\"exact\"/>" +
                "<w:jc w:val=\"left\"/>" +
                "<w:rPr>" +
                "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>" +
                "  <w:color w:val=\"000000\"/>" +
                "  <w:kern w:val=\"0\"/>" +
                "  <w:sz w:val=\"15\"/>" +
                "  <w:sz-cs w:val=\"15\"/>" +
                "</w:rPr>" +
                "  </w:pPr>" +
                "  <w:r>" +
                "<w:rPr>" +
                "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>" +
                "  <w:color w:val=\"000000\"/>" +
                "  <w:kern w:val=\"0\"/>" +
                "  <w:sz w:val=\"15\"/>" +
                "  <w:sz-cs w:val=\"15\"/>" +
                "</w:rPr>" +
                "<w:t> 地址：" + getValue(guaranteeList, 0, "address") + "</w:t>" +
                "  </w:r>" +
                "</w:p>" +
                "  </w:tc>" +
                "</w:tr>");

        int loopSize = guaranteeList.size() > 3 ? guaranteeList.size() : 3;
        for (int i = 1; i < loopSize; i++) {
            data.append("<w:tr>" +
                    "  <w:tblPrEx>" +
                    "<w:tblCellMar>" +
                    "  <w:top w:w=\"0\" w:type=\"dxa\"/>" +
                    "  <w:left w:w=\"108\" w:type=\"dxa\"/>" +
                    "  <w:bottom w:w=\"0\" w:type=\"dxa\"/>" +
                    "  <w:right w:w=\"108\" w:type=\"dxa\"/>" +
                    "</w:tblCellMar>" +
                    "  </w:tblPrEx>" +
                    "  <w:trPr>" +
                    "<w:gridBefore w:val=\"1\"/>" +
                    "<w:wBefore w:w=\"10\" w:type=\"dxa\"/>" +
                    "<w:trHeight w:val=\"243\" w:h-rule=\"atLeast\"/>" +
                    "  </w:trPr>" +
                    "  <w:tc>" +
                    "<w:tcPr>" +
                    "  <w:tcW w:w=\"1100\" w:type=\"dxa\"/>" +
                    "  <w:gridSpan w:val=\"2\"/>" +
                    "  <w:vmerge w:val=\"continue\"/>" +
                    "  <w:tcBorders>" +
                    "<w:top w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                    "<w:left w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                    "<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"000000\"/>" +
                    "<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                    "  </w:tcBorders>" +
                    "  <w:shd w:val=\"pct-10\" w:color=\"auto\" w:fill=\"auto\"/>" +
                    "  <w:noWrap w:val=\"0\"/>" +
                    "  <w:vAlign w:val=\"center\"/>" +
                    "</w:tcPr>" +
                    "<w:p>" +
                    "  <w:pPr>" +
                    "<w:widowControl/>" +
                    "<w:jc w:val=\"left\"/>" +
                    "<w:rPr>" +
                    "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>" +
                    "  <w:kern w:val=\"0\"/>" +
                    "  <w:sz w:val=\"15\"/>" +
                    "  <w:sz-cs w:val=\"15\"/>" +
                    "</w:rPr>" +
                    "  </w:pPr>" +
                    "</w:p>" +
                    "  </w:tc>" +
                    "  <w:tc>" +
                    "<w:tcPr>" +
                    "  <w:tcW w:w=\"1217\" w:type=\"dxa\"/>" +
                    "  <w:tcBorders>" +
                    "<w:top w:val=\"nil\"/>" +
                    "<w:left w:val=\"nil\"/>" +
                    "<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                    "<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                    "  </w:tcBorders>" +
                    "  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>" +
                    "  <w:noWrap w:val=\"0\"/>" +
                    "  <w:vAlign w:val=\"center\"/>" +
                    "</w:tcPr>" +
                    "<w:p>" +
                    "  <w:pPr>" +
                    "<w:widowControl/>" +
                    "<w:jc w:val=\"center\"/>" +
                    "<w:rPr>" +
                    "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>" +
                    "  <w:color w:val=\"000000\"/>" +
                    "  <w:kern w:val=\"0\"/>" +
                    "  <w:sz w:val=\"15\"/>" +
                    "  <w:sz-cs w:val=\"15\"/>" +
                    "</w:rPr>" +
                    "  </w:pPr>" +
                    "  <w:r>" +
                    "<w:rPr>" +
                    "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>" +
                    "  <w:color w:val=\"000000\"/>" +
                    "  <w:kern w:val=\"0\"/>" +
                    "  <w:sz w:val=\"15\"/>" +
                    "  <w:sz-cs w:val=\"15\"/>" +
                    "</w:rPr>" +
                    "<w:t>担保人姓名" + (i + 1) + "</w:t>" +
                    "  </w:r>" +
                    "</w:p>" +
                    "  </w:tc>" +
                    "  <w:tc>" +
                    "<w:tcPr>" +
                    "  <w:tcW w:w=\"951\" w:type=\"dxa\"/>" +
                    "  <w:gridSpan w:val=\"2\"/>" +
                    "  <w:tcBorders>" +
                    "<w:top w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                    "<w:left w:val=\"nil\"/>" +
                    "<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                    "<w:right w:val=\"nil\"/>" +
                    "  </w:tcBorders>" +
                    "  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>" +
                    "  <w:noWrap w:val=\"0\"/>" +
                    "  <w:vAlign w:val=\"center\"/>" +
                    "</w:tcPr>" +
                    "<w:p>" +
                    "  <w:pPr>" +
                    "<w:widowControl/>" +
                    "<w:jc w:val=\"left\"/>" +
                    "<w:rPr>" +
                    "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>" +
                    "  <w:color w:val=\"000000\"/>" +
                    "  <w:kern w:val=\"0\"/>" +
                    "  <w:sz w:val=\"15\"/>" +
                    "  <w:sz-cs w:val=\"15\"/>" +
                    "  <w:lang w:val=\"EN-US\" w:fareast=\"ZH-CN\"/>" +
                    "</w:rPr>" +
                    "  </w:pPr>" +
                    "  <w:r>" +
                    "<w:rPr>" +
                    "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>" +
                    "  <w:color w:val=\"000000\"/>" +
                    "  <w:kern w:val=\"0\"/>" +
                    "  <w:sz w:val=\"15\"/>" +
                    "  <w:sz-cs w:val=\"15\"/>" +
                    "</w:rPr>" +
                    "<w:t>" + getValue(guaranteeList, i, "name") + "</w:t>" +
                    "  </w:r>" +
                    "</w:p>" +
                    "  </w:tc>" +
                    "  <w:tc>" +
                    "<w:tcPr>" +
                    "  <w:tcW w:w=\"741\" w:type=\"dxa\"/>" +
                    "  <w:gridSpan w:val=\"2\"/>" +
                    "  <w:tcBorders>" +
                    "<w:top w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                    "<w:left w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                    "<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                    "<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                    "  </w:tcBorders>" +
                    "  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>" +
                    "  <w:noWrap w:val=\"0\"/>" +
                    "  <w:vAlign w:val=\"center\"/>" +
                    "</w:tcPr>" +
                    "<w:p>" +
                    "  <w:pPr>" +
                    "<w:widowControl/>" +
                    "<w:ind w:left=\"-7\" w:left-chars=\"-52\" w:right=\"-107\" w:right-chars=\"-51\" w:hanging=\"102\" w:hanging-chars=\"68\"/>" +
                    "<w:jc w:val=\"center\"/>" +
                    "<w:rPr>" +
                    "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>" +
                    "  <w:color w:val=\"000000\"/>" +
                    "  <w:kern w:val=\"0\"/>" +
                    "  <w:sz w:val=\"15\"/>" +
                    "  <w:sz-cs w:val=\"15\"/>" +
                    "</w:rPr>" +
                    "  </w:pPr>" +
                    "  <w:r>" +
                    "<w:rPr>" +
                    "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>" +
                    "  <w:color w:val=\"000000\"/>" +
                    "  <w:kern w:val=\"0\"/>" +
                    "  <w:sz w:val=\"15\"/>" +
                    "  <w:sz-cs w:val=\"15\"/>" +
                    "</w:rPr>" +
                    "<w:t>身份证号</w:t>" +
                    "  </w:r>" +
                    "</w:p>" +
                    "  </w:tc>" +
                    "  <w:tc>" +
                    "<w:tcPr>" +
                    "  <w:tcW w:w=\"1763\" w:type=\"dxa\"/>" +
                    "  <w:gridSpan w:val=\"3\"/>" +
                    "  <w:tcBorders>" +
                    "<w:top w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                    "<w:left w:val=\"nil\"/>" +
                    "<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                    "<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"000000\"/>" +
                    "  </w:tcBorders>" +
                    "  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>" +
                    "  <w:noWrap w:val=\"0\"/>" +
                    "  <w:vAlign w:val=\"center\"/>" +
                    "</w:tcPr>" +
                    "<w:p>" +
                    "  <w:pPr>" +
                    "<w:widowControl/>" +
                    "<w:jc w:val=\"left\"/>" +
                    "<w:rPr>" +
                    "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>" +
                    "  <w:color w:val=\"FF0000\"/>" +
                    "  <w:kern w:val=\"0\"/>" +
                    "  <w:sz w:val=\"15\"/>" +
                    "  <w:sz-cs w:val=\"15\"/>" +
                    "  <w:lang w:val=\"EN-US\" w:fareast=\"ZH-CN\"/>" +
                    "</w:rPr>" +
                    "  </w:pPr>" +
                    "  <w:r>" +
                    "<w:rPr>" +
                    "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>" +
                    "  <w:color w:val=\"000000\"/>" +
                    "  <w:kern w:val=\"0\"/>" +
                    "  <w:sz w:val=\"15\"/>" +
                    "  <w:sz-cs w:val=\"15\"/>" +
                    "</w:rPr>" +
                    "<w:t>" + getValue(guaranteeList, i, "idcard") + "</w:t>" +
                    "  </w:r>" +
                    "  " +
                    "</w:p>" +
                    "  </w:tc>" +
                    "  <w:tc>" +
                    "<w:tcPr>" +
                    "  <w:tcW w:w=\"1637\" w:type=\"dxa\"/>" +
                    "  <w:gridSpan w:val=\"2\"/>" +
                    "  <w:tcBorders>" +
                    "<w:top w:val=\"nil\"/>" +
                    "<w:left w:val=\"nil\"/>" +
                    "<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                    "<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                    "  </w:tcBorders>" +
                    "  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>" +
                    "  <w:noWrap w:val=\"0\"/>" +
                    "  <w:vAlign w:val=\"center\"/>" +
                    "</w:tcPr>" +
                    "<w:p>" +
                    "  <w:pPr>" +
                    "<w:widowControl/>" +
                    "<w:jc w:val=\"left\"/>" +
                    "<w:rPr>" +
                    "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>" +
                    "  <w:kern w:val=\"0\"/>" +
                    "  <w:sz w:val=\"15\"/>" +
                    "  <w:sz-cs w:val=\"15\"/>" +
                    "</w:rPr>" +
                    "  </w:pPr>" +
                    "  <w:r>" +
                    "<w:rPr>" +
                    "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>" +
                    "  <w:kern w:val=\"0\"/>" +
                    "  <w:sz w:val=\"15\"/>" +
                    "  <w:sz-cs w:val=\"15\"/>" +
                    "</w:rPr>" +
                    "<w:t>电话：" + getValue(guaranteeList, i, "mobile") + "</w:t>" +
                    "  </w:r>" +
                    "</w:p>" +
                    "  </w:tc>" +
                    "  <w:tc>" +
                    "<w:tcPr>" +
                    "  <w:tcW w:w=\"2814\" w:type=\"dxa\"/>" +
                    "  <w:gridSpan w:val=\"3\"/>" +
                    "  <w:tcBorders>" +
                    "<w:top w:val=\"nil\"/>" +
                    "<w:left w:val=\"nil\"/>" +
                    "<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                    "<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                    "  </w:tcBorders>" +
                    "  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>" +
                    "  <w:noWrap w:val=\"0\"/>" +
                    "  <w:vAlign w:val=\"center\"/>" +
                    "</w:tcPr>" +
                    "<w:p>" +
                    "  <w:pPr>" +
                    "<w:widowControl/>" +
                    "<w:spacing w:line=\"240\" w:line-rule=\"exact\"/>" +
                    "<w:jc w:val=\"left\"/>" +
                    "<w:rPr>" +
                    "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>" +
                    "  <w:color w:val=\"000000\"/>" +
                    "  <w:kern w:val=\"0\"/>" +
                    "  <w:sz w:val=\"15\"/>" +
                    "  <w:sz-cs w:val=\"15\"/>" +
                    "</w:rPr>" +
                    "  </w:pPr>" +
                    "  <w:r>" +
                    "<w:rPr>" +
                    "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>" +
                    "  <w:color w:val=\"000000\"/>" +
                    "  <w:kern w:val=\"0\"/>" +
                    "  <w:sz w:val=\"15\"/>" +
                    "  <w:sz-cs w:val=\"15\"/>" +
                    "</w:rPr>" +
                    "<w:t> 地址：" + getValue(guaranteeList, i, "address") + "</w:t>" +
                    "  </w:r>" +
                    "</w:p>" +
                    "  </w:tc>" +
                    "</w:tr>");
        }


        variables.put("guaranteeList", data.toString());
    }

    private void buildGuarantorList(boolean isChoose, List<Map<String, Object>> mortgageList) {
        StringBuilder data = new StringBuilder();
        data.append("<w:tr>" +
                "  <w:tblPrEx>" +
                "<w:tblCellMar>" +
                "  <w:top w:w=\"0\" w:type=\"dxa\"/>" +
                "  <w:left w:w=\"108\" w:type=\"dxa\"/>" +
                "  <w:bottom w:w=\"0\" w:type=\"dxa\"/>" +
                "  <w:right w:w=\"108\" w:type=\"dxa\"/>" +
                "</w:tblCellMar>" +
                "  </w:tblPrEx>" +
                "  <w:trPr>" +
                "<w:gridBefore w:val=\"1\"/>" +
                "<w:wBefore w:w=\"10\" w:type=\"dxa\"/>" +
                "<w:trHeight w:val=\"612\" w:h-rule=\"atLeast\"/>" +
                "  </w:trPr>" +
                "  <w:tc>" +
                "<w:tcPr>" +
                "  <w:tcW w:w=\"1100\" w:type=\"dxa\"/>" +
                "  <w:gridSpan w:val=\"2\"/>" +
                "  <w:vmerge w:val=\"restart\"/>" +
                "  <w:tcBorders>" +
                "<w:top w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                "<w:left w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                "<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"000000\"/>" +
                "<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                "  </w:tcBorders>" +
                "  <w:shd w:val=\"pct-10\" w:color=\"auto\" w:fill=\"auto\"/>" +
                "  <w:noWrap w:val=\"0\"/>" +
                "  <w:vAlign w:val=\"center\"/>" +
                "</w:tcPr>" +
                "<w:p>" +
                "  <w:pPr>" +
                "<w:widowControl/>" +
                "<w:jc w:val=\"center\"/>" +
                "<w:rPr>" +
                "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>" +
                "  <w:color w:val=\"000000\"/>" +
                "  <w:kern w:val=\"0\"/>" +
                "  <w:sz w:val=\"15\"/>" +
                "  <w:sz-cs w:val=\"15\"/>" +
                "</w:rPr>" +
                "  </w:pPr>" +
                "  <w:r>" +
                "<w:rPr>" +
                "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>" +
                "  <w:color w:val=\"000000\"/>" +
                "  <w:kern w:val=\"0\"/>" +
                "  <w:sz w:val=\"15\"/>" +
                "  <w:sz-cs w:val=\"15\"/>" +
                "</w:rPr>" +
                "<w:t>" + (isChoose ? "☑" : "□") + "抵押担保</w:t>" +
                "  </w:r>" +
                "</w:p>" +
                "  </w:tc>" +
                "  <w:tc>" +
                "<w:tcPr>" +
                "  <w:tcW w:w=\"1217\" w:type=\"dxa\"/>" +
                "  <w:tcBorders>" +
                "<w:top w:val=\"nil\"/>" +
                "<w:left w:val=\"nil\"/>" +
                "<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                "<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                "  </w:tcBorders>" +
                "  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>" +
                "  <w:noWrap w:val=\"0\"/>" +
                "  <w:vAlign w:val=\"center\"/>" +
                "</w:tcPr>" +
                "<w:p>" +
                "  <w:pPr>" +
                "<w:widowControl/>" +
                "<w:jc w:val=\"center\"/>" +
                "<w:rPr>" +
                "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>" +
                "  <w:color w:val=\"000000\"/>" +
                "  <w:kern w:val=\"0\"/>" +
                "  <w:sz w:val=\"15\"/>" +
                "  <w:sz-cs w:val=\"15\"/>" +
                "</w:rPr>" +
                "  </w:pPr>" +
                "  <w:r>" +
                "<w:rPr>" +
                "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>" +
                "  <w:color w:val=\"000000\"/>" +
                "  <w:kern w:val=\"0\"/>" +
                "  <w:sz w:val=\"15\"/>" +
                "  <w:sz-cs w:val=\"15\"/>" +
                "</w:rPr>" +
                "<w:t> 抵押人1姓名</w:t>" +
                "  </w:r>" +
                "</w:p>" +
                "  </w:tc>" +
                "  <w:tc>" +
                "<w:tcPr>" +
                "  <w:tcW w:w=\"951\" w:type=\"dxa\"/>" +
                "  <w:gridSpan w:val=\"2\"/>" +
                "  <w:tcBorders>" +
                "<w:top w:val=\"nil\"/>" +
                "<w:left w:val=\"nil\"/>" +
                "<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                "<w:right w:val=\"nil\"/>" +
                "  </w:tcBorders>" +
                "  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>" +
                "  <w:noWrap w:val=\"0\"/>" +
                "  <w:vAlign w:val=\"center\"/>" +
                "</w:tcPr>" +
                "<w:p>" +
                "  <w:pPr>" +
                "<w:widowControl/>" +
                "<w:jc w:val=\"center\"/>" +
                "<w:rPr>" +
                "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>" +
                "  <w:color w:val=\"000000\"/>" +
                "  <w:kern w:val=\"0\"/>" +
                "  <w:sz w:val=\"15\"/>" +
                "  <w:sz-cs w:val=\"15\"/>" +
                "</w:rPr>" +
                "  </w:pPr>" +
                "  <w:r>" +
                "<w:rPr>" +
                "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>" +
                "  <w:color w:val=\"000000\"/>" +
                "  <w:kern w:val=\"0\"/>" +
                "  <w:sz w:val=\"15\"/>" +
                "  <w:sz-cs w:val=\"15\"/>" +
                "</w:rPr>" +
                "<w:t>" + getValue(mortgageList, 0, "name") + "</w:t>" +
                "  </w:r>" +
                "</w:p>" +
                "  </w:tc>" +
                "  <w:tc>" +
                "<w:tcPr>" +
                "  <w:tcW w:w=\"741\" w:type=\"dxa\"/>" +
                "  <w:gridSpan w:val=\"2\"/>" +
                "  <w:tcBorders>" +
                "<w:top w:val=\"nil\"/>" +
                "<w:left w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                "<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                "<w:right w:val=\"nil\"/>" +
                "  </w:tcBorders>" +
                "  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>" +
                "  <w:noWrap w:val=\"0\"/>" +
                "  <w:vAlign w:val=\"center\"/>" +
                "</w:tcPr>" +
                "<w:p>" +
                "  <w:pPr>" +
                "<w:widowControl/>" +
                "<w:ind w:left=\"-7\" w:left-chars=\"-52\" w:right=\"-122\" w:right-chars=\"-58\" w:hanging=\"102\" w:hanging-chars=\"68\"/>" +
                "<w:rPr>" +
                "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>" +
                "  <w:color w:val=\"000000\"/>" +
                "  <w:kern w:val=\"0\"/>" +
                "  <w:sz w:val=\"15\"/>" +
                "  <w:sz-cs w:val=\"15\"/>" +
                "</w:rPr>" +
                "  </w:pPr>" +
                "  <w:r>" +
                "<w:rPr>" +
                "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>" +
                "  <w:color w:val=\"000000\"/>" +
                "  <w:kern w:val=\"0\"/>" +
                "  <w:sz w:val=\"15\"/>" +
                "  <w:sz-cs w:val=\"15\"/>" +
                "</w:rPr>" +
                "<w:t> 联系电话</w:t>" +
                "  </w:r>" +
                "</w:p>" +
                "  </w:tc>" +
                "  <w:tc>" +
                "<w:tcPr>" +
                "  <w:tcW w:w=\"1289\" w:type=\"dxa\"/>" +
                "  <w:gridSpan w:val=\"2\"/>" +
                "  <w:tcBorders>" +
                "<w:top w:val=\"nil\"/>" +
                "<w:left w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                "<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                "<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                "  </w:tcBorders>" +
                "  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>" +
                "  <w:noWrap w:val=\"0\"/>" +
                "  <w:vAlign w:val=\"center\"/>" +
                "</w:tcPr>" +
                "<w:p>" +
                "  <w:pPr>" +
                "<w:widowControl/>" +
                "<w:jc w:val=\"left\"/>" +
                "<w:rPr>" +
                "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>" +
                "  <w:color w:val=\"000000\"/>" +
                "  <w:kern w:val=\"0\"/>" +
                "  <w:sz w:val=\"15\"/>" +
                "  <w:sz-cs w:val=\"15\"/>" +
                "</w:rPr>" +
                "  </w:pPr>" +
                "  <w:r>" +
                "<w:rPr>" +
                "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>" +
                "  <w:kern w:val=\"0\"/>" +
                "  <w:sz w:val=\"15\"/>" +
                "  <w:sz-cs w:val=\"15\"/>" +
                "</w:rPr>" +
                "<w:t>" + getValue(mortgageList, 0, "mobile") + "</w:t>" +
                "  </w:r>" +
                "</w:p>" +
                "  </w:tc>" +
                "  <w:tc>" +
                "<w:tcPr>" +
                "  <w:tcW w:w=\"4925\" w:type=\"dxa\"/>" +
                "  <w:gridSpan w:val=\"6\"/>" +
                "  <w:tcBorders>" +
                "<w:top w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                "<w:left w:val=\"nil\"/>" +
                "<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                "<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"000000\"/>" +
                "  </w:tcBorders>" +
                "  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>" +
                "  <w:noWrap w:val=\"0\"/>" +
                "  <w:vAlign w:val=\"center\"/>" +
                "</w:tcPr>" +
                "<w:p>" +
                "  <w:pPr>" +
                "<w:widowControl/>" +
                "<w:ind w:left=\"-8\" w:left-chars=\"-57\" w:hanging=\"112\" w:hanging-chars=\"75\"/>" +
                "<w:jc w:val=\"center\"/>" +
                "<w:rPr>" +
                "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>" +
                "  <w:color w:val=\"000000\"/>" +
                "  <w:kern w:val=\"0\"/>" +
                "  <w:sz w:val=\"15\"/>" +
                "  <w:sz-cs w:val=\"15\"/>" +
                "</w:rPr>" +
                "  </w:pPr>" +
                "  <w:r>" +
                "<w:rPr>" +
                "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>" +
                "  <w:color w:val=\"000000\"/>" +
                "  <w:kern w:val=\"0\"/>" +
                "  <w:sz w:val=\"15\"/>" +
                "  <w:sz-cs w:val=\"15\"/>" +
                "</w:rPr>" +
                "<w:t>抵押物名称</w:t>" +
                "  </w:r>" +
                "  <w:r>" +
                "<w:rPr>" +
                "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>" +
                "  <w:color w:val=\"000000\"/>" +
                "  <w:kern w:val=\"0\"/>" +
                "  <w:sz w:val=\"15\"/>" +
                "  <w:sz-cs w:val=\"15\"/>" +
                "  <w:u w:val=\"single\"/>" +
                "</w:rPr>" +
                "<w:t>： " + getValue(mortgageList, 0, "collateralName") + " </w:t>" +
                "  </w:r>" +
                "  <w:r>" +
                "<w:rPr>" +
                "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>" +
                "  <w:color w:val=\"000000\"/>" +
                "  <w:kern w:val=\"0\"/>" +
                "  <w:sz w:val=\"15\"/>" +
                "  <w:sz-cs w:val=\"15\"/>" +
                "</w:rPr>" +
                "<w:t> 抵押物数量</w:t>" +
                "  </w:r>" +
                "  <w:r>" +
                "<w:rPr>" +
                "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>" +
                "  <w:color w:val=\"000000\"/>" +
                "  <w:kern w:val=\"0\"/>" +
                "  <w:sz w:val=\"15\"/>" +
                "  <w:sz-cs w:val=\"15\"/>" +
                "  <w:u w:val=\"single\"/>" +
                "</w:rPr>" +
                "<w:t>：" + getValue(mortgageList, 0, "collateralAmount") + "</w:t>" +
                "  </w:r>" +
                "  <w:r>" +
                "<w:rPr>" +
                "  <w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\" w:cs=\"宋体\" w:hint=\"fareast\"/>" +
                "  <w:color w:val=\"000000\"/>" +
                "  <w:kern w:val=\"0\"/>" +
                "  <w:sz w:val=\"15\"/>" +
                "  <w:sz-cs w:val=\"15\"/>" +
                "  <w:u w:val=\"single\"/>" +
                "</w:rPr>" +
                "<w:t>㎡</w:t>" +
                "  </w:r>" +
                "  <w:r>" +
                "<w:rPr>" +
                "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>" +
                "  <w:color w:val=\"000000\"/>" +
                "  <w:kern w:val=\"0\"/>" +
                "  <w:sz w:val=\"15\"/>" +
                "  <w:sz-cs w:val=\"15\"/>" +
                "  <w:u w:val=\"single\"/>" +
                "</w:rPr>" +
                "<w:t>     </w:t>" +
                "  </w:r>" +
                "  <w:r>" +
                "<w:rPr>" +
                "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>" +
                "  <w:color w:val=\"000000\"/>" +
                "  <w:kern w:val=\"0\"/>" +
                "  <w:sz w:val=\"15\"/>" +
                "  <w:sz-cs w:val=\"15\"/>" +
                "</w:rPr>" +
                "<w:t> 价值</w:t>" +
                "  </w:r>" +
                "  <w:r>" +
                "<w:rPr>" +
                "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>" +
                "  <w:color w:val=\"000000\"/>" +
                "  <w:kern w:val=\"0\"/>" +
                "  <w:sz w:val=\"15\"/>" +
                "  <w:sz-cs w:val=\"15\"/>" +
                "  <w:u w:val=\"single\"/>" +
                "</w:rPr>" +
                "<w:t>：" + getValue(mortgageList, 0, "collateralFee") + "</w:t>" +
                "  </w:r>" +
                "  <w:r>" +
                "<w:rPr>" +
                "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>" +
                "  <w:color w:val=\"000000\"/>" +
                "  <w:kern w:val=\"0\"/>" +
                "  <w:sz w:val=\"15\"/>" +
                "  <w:sz-cs w:val=\"15\"/>" +
                "</w:rPr>" +
                "<w:t>元</w:t>" +
                "  </w:r>" +
                "</w:p>" +
                "  </w:tc>" +
                "</w:tr>" +
                "<w:tr>" +
                "  <w:tblPrEx>" +
                "<w:tblCellMar>" +
                "  <w:top w:w=\"0\" w:type=\"dxa\"/>" +
                "  <w:left w:w=\"108\" w:type=\"dxa\"/>" +
                "  <w:bottom w:w=\"0\" w:type=\"dxa\"/>" +
                "  <w:right w:w=\"108\" w:type=\"dxa\"/>" +
                "</w:tblCellMar>" +
                "  </w:tblPrEx>" +
                "  <w:trPr>" +
                "<w:gridBefore w:val=\"1\"/>" +
                "<w:wBefore w:w=\"10\" w:type=\"dxa\"/>" +
                "<w:trHeight w:val=\"400\" w:h-rule=\"atLeast\"/>" +
                "  </w:trPr>" +
                "  <w:tc>" +
                "<w:tcPr>" +
                "  <w:tcW w:w=\"1100\" w:type=\"dxa\"/>" +
                "  <w:gridSpan w:val=\"2\"/>" +
                "  <w:vmerge w:val=\"continue\"/>" +
                "  <w:tcBorders>" +
                "<w:top w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                "<w:left w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                "<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"000000\"/>" +
                "<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                "  </w:tcBorders>" +
                "  <w:shd w:val=\"pct-10\" w:color=\"auto\" w:fill=\"auto\"/>" +
                "  <w:noWrap w:val=\"0\"/>" +
                "  <w:vAlign w:val=\"center\"/>" +
                "</w:tcPr>" +
                "<w:p>" +
                "  <w:pPr>" +
                "<w:widowControl/>" +
                "<w:jc w:val=\"left\"/>" +
                "<w:rPr>" +
                "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>" +
                "  <w:color w:val=\"000000\"/>" +
                "  <w:kern w:val=\"0\"/>" +
                "  <w:sz w:val=\"15\"/>" +
                "  <w:sz-cs w:val=\"15\"/>" +
                "</w:rPr>" +
                "  </w:pPr>" +
                "</w:p>" +
                "  </w:tc>" +
                "  <w:tc>" +
                "<w:tcPr>" +
                "  <w:tcW w:w=\"1217\" w:type=\"dxa\"/>" +
                "  <w:tcBorders>" +
                "<w:top w:val=\"nil\"/>" +
                "<w:left w:val=\"nil\"/>" +
                "<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                "<w:right w:val=\"nil\"/>" +
                "  </w:tcBorders>" +
                "  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>" +
                "  <w:noWrap w:val=\"0\"/>" +
                "  <w:vAlign w:val=\"center\"/>" +
                "</w:tcPr>" +
                "<w:p>" +
                "  <w:pPr>" +
                "<w:widowControl/>" +
                "<w:jc w:val=\"center\"/>" +
                "<w:rPr>" +
                "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>" +
                "  <w:color w:val=\"000000\"/>" +
                "  <w:kern w:val=\"0\"/>" +
                "  <w:sz w:val=\"15\"/>" +
                "  <w:sz-cs w:val=\"15\"/>" +
                "</w:rPr>" +
                "  </w:pPr>" +
                "  <w:r>" +
                "<w:rPr>" +
                "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>" +
                "  <w:color w:val=\"000000\"/>" +
                "  <w:kern w:val=\"0\"/>" +
                "  <w:sz w:val=\"15\"/>" +
                "  <w:sz-cs w:val=\"15\"/>" +
                "</w:rPr>" +
                "<w:t> 联 系 地 址</w:t>" +
                "  </w:r>" +
                "</w:p>" +
                "  </w:tc>" +
                "  <w:tc>" +
                "<w:tcPr>" +
                "  <w:tcW w:w=\"3455\" w:type=\"dxa\"/>" +
                "  <w:gridSpan w:val=\"7\"/>" +
                "  <w:tcBorders>" +
                "<w:top w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                "<w:left w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                "<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                "<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"000000\"/>" +
                "  </w:tcBorders>" +
                "  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>" +
                "  <w:noWrap w:val=\"0\"/>" +
                "  <w:vAlign w:val=\"center\"/>" +
                "</w:tcPr>" +
                "<w:p>" +
                "  <w:pPr>" +
                "<w:widowControl/>" +
                "<w:jc w:val=\"center\"/>" +
                "<w:rPr>" +
                "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>" +
                "  <w:color w:val=\"000000\"/>" +
                "  <w:kern w:val=\"0\"/>" +
                "  <w:sz w:val=\"15\"/>" +
                "  <w:sz-cs w:val=\"15\"/>" +
                "</w:rPr>" +
                "  </w:pPr>" +
                "  <w:r>" +
                "<w:rPr>" +
                "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>" +
                "  <w:color w:val=\"000000\"/>" +
                "  <w:kern w:val=\"0\"/>" +
                "  <w:sz w:val=\"15\"/>" +
                "  <w:sz-cs w:val=\"15\"/>" +
                "</w:rPr>" +
                "<w:t>" + getValue(mortgageList, 0, "contactAddress") + "</w:t>" +
                "  </w:r>" +
                "</w:p>" +
                "  </w:tc>" +
                "  <w:tc>" +
                "<w:tcPr>" +
                "  <w:tcW w:w=\"1637\" w:type=\"dxa\"/>" +
                "  <w:gridSpan w:val=\"2\"/>" +
                "  <w:tcBorders>" +
                "<w:top w:val=\"nil\"/>" +
                "<w:left w:val=\"nil\"/>" +
                "<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                "<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                "  </w:tcBorders>" +
                "  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>" +
                "  <w:noWrap w:val=\"0\"/>" +
                "  <w:vAlign w:val=\"center\"/>" +
                "</w:tcPr>" +
                "<w:p>" +
                "  <w:pPr>" +
                "<w:widowControl/>" +
                "<w:jc w:val=\"center\"/>" +
                "<w:rPr>" +
                "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>" +
                "  <w:color w:val=\"000000\"/>" +
                "  <w:kern w:val=\"0\"/>" +
                "  <w:sz w:val=\"15\"/>" +
                "  <w:sz-cs w:val=\"15\"/>" +
                "</w:rPr>" +
                "  </w:pPr>" +
                "  <w:r>" +
                "<w:rPr>" +
                "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>" +
                "  <w:color w:val=\"000000\"/>" +
                "  <w:kern w:val=\"0\"/>" +
                "  <w:sz w:val=\"15\"/>" +
                "  <w:sz-cs w:val=\"15\"/>" +
                "</w:rPr>" +
                "<w:t>抵押物存放地</w:t>" +
                "  </w:r>" +
                "</w:p>" +
                "  </w:tc>" +
                "  <w:tc>" +
                "<w:tcPr>" +
                "  <w:tcW w:w=\"2814\" w:type=\"dxa\"/>" +
                "  <w:gridSpan w:val=\"3\"/>" +
                "  <w:tcBorders>" +
                "<w:top w:val=\"nil\"/>" +
                "<w:left w:val=\"nil\"/>" +
                "<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                "<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                "  </w:tcBorders>" +
                "  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>" +
                "  <w:noWrap w:val=\"0\"/>" +
                "  <w:vAlign w:val=\"center\"/>" +
                "</w:tcPr>" +
                "<w:p>" +
                "  <w:pPr>" +
                "<w:widowControl/>" +
                "<w:jc w:val=\"left\"/>" +
                "<w:rPr>" +
                "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>" +
                "  <w:color w:val=\"000000\"/>" +
                "  <w:kern w:val=\"0\"/>" +
                "  <w:sz w:val=\"15\"/>" +
                "  <w:sz-cs w:val=\"15\"/>" +
                "</w:rPr>" +
                "  </w:pPr>" +
                "  <w:r>" +
                "<w:rPr>" +
                "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>" +
                "  <w:color w:val=\"000000\"/>" +
                "  <w:kern w:val=\"0\"/>" +
                "  <w:sz w:val=\"15\"/>" +
                "  <w:sz-cs w:val=\"15\"/>" +
                "</w:rPr>" +
                "<w:t>" + getValue(mortgageList, 0, "collateralPosition") + "</w:t>" +
                "  </w:r>" +
                "</w:p>" +
                "  </w:tc>" +
                "</w:tr>");

        int loopSize = mortgageList.size() > 2 ? mortgageList.size() : 2;
        for (int i = 1; i < loopSize; i++) {
            data.append("<w:tr>" +
                    "  <w:tblPrEx>" +
                    "<w:tblCellMar>" +
                    "  <w:top w:w=\"0\" w:type=\"dxa\"/>" +
                    "  <w:left w:w=\"108\" w:type=\"dxa\"/>" +
                    "  <w:bottom w:w=\"0\" w:type=\"dxa\"/>" +
                    "  <w:right w:w=\"108\" w:type=\"dxa\"/>" +
                    "</w:tblCellMar>" +
                    "  </w:tblPrEx>" +
                    "  <w:trPr>" +
                    "<w:gridBefore w:val=\"1\"/>" +
                    "<w:wBefore w:w=\"10\" w:type=\"dxa\"/>" +
                    "<w:trHeight w:val=\"612\" w:h-rule=\"atLeast\"/>" +
                    "  </w:trPr>" +
                    "  <w:tc>" +
                    "<w:tcPr>" +
                    "  <w:tcW w:w=\"1100\" w:type=\"dxa\"/>" +
                    "  <w:gridSpan w:val=\"2\"/>" +
                    "  <w:vmerge w:val=\"continue\"/>" +
                    "  <w:tcBorders>" +
                    "<w:top w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                    "<w:left w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                    "<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"000000\"/>" +
                    "<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                    "  </w:tcBorders>" +
                    "  <w:shd w:val=\"pct-10\" w:color=\"auto\" w:fill=\"auto\"/>" +
                    "  <w:noWrap w:val=\"0\"/>" +
                    "  <w:vAlign w:val=\"center\"/>" +
                    "</w:tcPr>" +
                    "<w:p>" +
                    "  <w:pPr>" +
                    "<w:widowControl/>" +
                    "<w:jc w:val=\"left\"/>" +
                    "<w:rPr>" +
                    "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>" +
                    "  <w:color w:val=\"000000\"/>" +
                    "  <w:kern w:val=\"0\"/>" +
                    "  <w:sz w:val=\"15\"/>" +
                    "  <w:sz-cs w:val=\"15\"/>" +
                    "</w:rPr>" +
                    "  </w:pPr>" +
                    "</w:p>" +
                    "  </w:tc>" +
                    "  <w:tc>" +
                    "<w:tcPr>" +
                    "  <w:tcW w:w=\"1217\" w:type=\"dxa\"/>" +
                    "  <w:tcBorders>" +
                    "<w:top w:val=\"nil\"/>" +
                    "<w:left w:val=\"nil\"/>" +
                    "<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                    "<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                    "  </w:tcBorders>" +
                    "  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>" +
                    "  <w:noWrap w:val=\"0\"/>" +
                    "  <w:vAlign w:val=\"center\"/>" +
                    "</w:tcPr>" +
                    "<w:p>" +
                    "  <w:pPr>" +
                    "<w:widowControl/>" +
                    "<w:jc w:val=\"center\"/>" +
                    "<w:rPr>" +
                    "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>" +
                    "  <w:color w:val=\"000000\"/>" +
                    "  <w:kern w:val=\"0\"/>" +
                    "  <w:sz w:val=\"15\"/>" +
                    "  <w:sz-cs w:val=\"15\"/>" +
                    "</w:rPr>" +
                    "  </w:pPr>" +
                    "  <w:r>" +
                    "<w:rPr>" +
                    "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>" +
                    "  <w:color w:val=\"000000\"/>" +
                    "  <w:kern w:val=\"0\"/>" +
                    "  <w:sz w:val=\"15\"/>" +
                    "  <w:sz-cs w:val=\"15\"/>" +
                    "</w:rPr>" +
                    "<w:t> 抵押人" + (i + 1) + "姓名</w:t>" +
                    "  </w:r>" +
                    "</w:p>" +
                    "  </w:tc>" +
                    "  <w:tc>" +
                    "<w:tcPr>" +
                    "  <w:tcW w:w=\"951\" w:type=\"dxa\"/>" +
                    "  <w:gridSpan w:val=\"2\"/>" +
                    "  <w:tcBorders>" +
                    "<w:top w:val=\"nil\"/>" +
                    "<w:left w:val=\"nil\"/>" +
                    "<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                    "<w:right w:val=\"nil\"/>" +
                    "  </w:tcBorders>" +
                    "  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>" +
                    "  <w:noWrap w:val=\"0\"/>" +
                    "  <w:vAlign w:val=\"center\"/>" +
                    "</w:tcPr>" +
                    "<w:p>" +
                    "  <w:pPr>" +
                    "<w:widowControl/>" +
                    "<w:jc w:val=\"left\"/>" +
                    "<w:rPr>" +
                    "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>" +
                    "  <w:color w:val=\"000000\"/>" +
                    "  <w:kern w:val=\"0\"/>" +
                    "  <w:sz w:val=\"15\"/>" +
                    "  <w:sz-cs w:val=\"15\"/>" +
                    "</w:rPr>" +
                    "  </w:pPr>" +
                    "  <w:r>" +
                    "<w:rPr>" +
                    "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>" +
                    "  <w:color w:val=\"000000\"/>" +
                    "  <w:kern w:val=\"0\"/>" +
                    "  <w:sz w:val=\"15\"/>" +
                    "  <w:sz-cs w:val=\"15\"/>" +
                    "</w:rPr>" +
                    "<w:t>" + getValue(mortgageList, i, "name") + "</w:t>" +
                    "  </w:r>" +
                    "</w:p>" +
                    "  </w:tc>" +
                    "  <w:tc>" +
                    "<w:tcPr>" +
                    "  <w:tcW w:w=\"741\" w:type=\"dxa\"/>" +
                    "  <w:gridSpan w:val=\"2\"/>" +
                    "  <w:tcBorders>" +
                    "<w:top w:val=\"nil\"/>" +
                    "<w:left w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                    "<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                    "<w:right w:val=\"nil\"/>" +
                    "  </w:tcBorders>" +
                    "  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>" +
                    "  <w:noWrap w:val=\"0\"/>" +
                    "  <w:vAlign w:val=\"center\"/>" +
                    "</w:tcPr>" +
                    "<w:p>" +
                    "  <w:pPr>" +
                    "<w:widowControl/>" +
                    "<w:ind w:left=\"-7\" w:left-chars=\"-52\" w:right=\"-122\" w:right-chars=\"-58\" w:hanging=\"102\" w:hanging-chars=\"68\"/>" +
                    "<w:rPr>" +
                    "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>" +
                    "  <w:color w:val=\"000000\"/>" +
                    "  <w:kern w:val=\"0\"/>" +
                    "  <w:sz w:val=\"15\"/>" +
                    "  <w:sz-cs w:val=\"15\"/>" +
                    "</w:rPr>" +
                    "  </w:pPr>" +
                    "  <w:r>" +
                    "<w:rPr>" +
                    "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>" +
                    "  <w:color w:val=\"000000\"/>" +
                    "  <w:kern w:val=\"0\"/>" +
                    "  <w:sz w:val=\"15\"/>" +
                    "  <w:sz-cs w:val=\"15\"/>" +
                    "</w:rPr>" +
                    "<w:t> 联系电话</w:t>" +
                    "  </w:r>" +
                    "</w:p>" +
                    "  </w:tc>" +
                    "  <w:tc>" +
                    "<w:tcPr>" +
                    "  <w:tcW w:w=\"1289\" w:type=\"dxa\"/>" +
                    "  <w:gridSpan w:val=\"2\"/>" +
                    "  <w:tcBorders>" +
                    "<w:top w:val=\"nil\"/>" +
                    "<w:left w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                    "<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                    "<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                    "  </w:tcBorders>" +
                    "  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>" +
                    "  <w:noWrap w:val=\"0\"/>" +
                    "  <w:vAlign w:val=\"center\"/>" +
                    "</w:tcPr>" +
                    "<w:p>" +
                    "  <w:pPr>" +
                    "<w:widowControl/>" +
                    "<w:jc w:val=\"left\"/>" +
                    "<w:rPr>" +
                    "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>" +
                    "  <w:color w:val=\"000000\"/>" +
                    "  <w:kern w:val=\"0\"/>" +
                    "  <w:sz w:val=\"15\"/>" +
                    "  <w:sz-cs w:val=\"15\"/>" +
                    "</w:rPr>" +
                    "  </w:pPr>" +
                    "  <w:r>" +
                    "<w:rPr>" +
                    "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>" +
                    "  <w:color w:val=\"000000\"/>" +
                    "  <w:kern w:val=\"0\"/>" +
                    "  <w:sz w:val=\"15\"/>" +
                    "  <w:sz-cs w:val=\"15\"/>" +
                    "</w:rPr>" +
                    "<w:t>" + getValue(mortgageList, i, "mobile") + "</w:t>" +
                    "  </w:r>" +
                    "</w:p>" +
                    "  </w:tc>" +
                    "  <w:tc>" +
                    "<w:tcPr>" +
                    "  <w:tcW w:w=\"4925\" w:type=\"dxa\"/>" +
                    "  <w:gridSpan w:val=\"6\"/>" +
                    "  <w:tcBorders>" +
                    "<w:top w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                    "<w:left w:val=\"nil\"/>" +
                    "<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>" +
                    "<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"000000\"/>" +
                    "  </w:tcBorders>" +
                    "  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>" +
                    "  <w:noWrap w:val=\"0\"/>" +
                    "  <w:vAlign w:val=\"center\"/>" +
                    "</w:tcPr>" +
                    "<w:p>" +
                    "  <w:pPr>" +
                    "<w:widowControl/>" +
                    "<w:ind w:left=\"-8\" w:left-chars=\"-57\" w:hanging=\"112\" w:hanging-chars=\"75\"/>" +
                    "<w:jc w:val=\"center\"/>" +
                    "<w:rPr>" +
                    "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>" +
                    "  <w:color w:val=\"000000\"/>" +
                    "  <w:kern w:val=\"0\"/>" +
                    "  <w:sz w:val=\"15\"/>" +
                    "  <w:sz-cs w:val=\"15\"/>" +
                    "</w:rPr>" +
                    "  </w:pPr>" +
                    "  <w:r>" +
                    "<w:rPr>" +
                    "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>" +
                    "  <w:color w:val=\"000000\"/>" +
                    "  <w:kern w:val=\"0\"/>" +
                    "  <w:sz w:val=\"15\"/>" +
                    "  <w:sz-cs w:val=\"15\"/>" +
                    "</w:rPr>" +
                    "<w:t>抵押物名称</w:t>" +
                    "  </w:r>" +
                    "  <w:r>" +
                    "<w:rPr>" +
                    "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>" +
                    "  <w:color w:val=\"000000\"/>" +
                    "  <w:kern w:val=\"0\"/>" +
                    "  <w:sz w:val=\"15\"/>" +
                    "  <w:sz-cs w:val=\"15\"/>" +
                    "  <w:u w:val=\"single\"/>" +
                    "</w:rPr>" +
                    "<w:t>： " + getValue(mortgageList, i, "collateralName") + " </w:t>" +
                    "  </w:r>" +
                    "  <w:r>" +
                    "<w:rPr>" +
                    "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>" +
                    "  <w:color w:val=\"000000\"/>" +
                    "  <w:kern w:val=\"0\"/>" +
                    "  <w:sz w:val=\"15\"/>" +
                    "  <w:sz-cs w:val=\"15\"/>" +
                    "</w:rPr>" +
                    "<w:t> 抵押物数量</w:t>" +
                    "  </w:r>" +
                    "  <w:r>" +
                    "<w:rPr>" +
                    "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>" +
                    "  <w:color w:val=\"000000\"/>" +
                    "  <w:kern w:val=\"0\"/>" +
                    "  <w:sz w:val=\"15\"/>" +
                    "  <w:sz-cs w:val=\"15\"/>" +
                    "  <w:u w:val=\"single\"/>" +
                    "</w:rPr>" +
                    "<w:t>：" + getValue(mortgageList, i, "collateralAmount") + "</w:t>" +
                    "  </w:r>" +
                    "  <w:r>" +
                    "<w:rPr>" +
                    "  <w:rFonts w:ascii=\"宋体\" w:h-ansi=\"宋体\" w:cs=\"宋体\" w:hint=\"fareast\"/>" +
                    "  <w:color w:val=\"000000\"/>" +
                    "  <w:kern w:val=\"0\"/>" +
                    "  <w:sz w:val=\"15\"/>" +
                    "  <w:sz-cs w:val=\"15\"/>" +
                    "  <w:u w:val=\"single\"/>" +
                    "</w:rPr>" +
                    "<w:t>㎡</w:t>" +
                    "  </w:r>" +
                    "  <w:r>" +
                    "<w:rPr>" +
                    "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>" +
                    "  <w:color w:val=\"000000\"/>" +
                    "  <w:kern w:val=\"0\"/>" +
                    "  <w:sz w:val=\"15\"/>" +
                    "  <w:sz-cs w:val=\"15\"/>" +
                    "  <w:u w:val=\"single\"/>" +
                    "</w:rPr>" +
                    "<w:t>     </w:t>" +
                    "  </w:r>" +
                    "  <w:r>" +
                    "<w:rPr>" +
                    "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>" +
                    "  <w:color w:val=\"000000\"/>" +
                    "  <w:kern w:val=\"0\"/>" +
                    "  <w:sz w:val=\"15\"/>" +
                    "  <w:sz-cs w:val=\"15\"/>" +
                    "</w:rPr>" +
                    "<w:t> 价值</w:t>" +
                    "  </w:r>" +
                    "  <w:r>" +
                    "<w:rPr>" +
                    "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>" +
                    "  <w:color w:val=\"000000\"/>" +
                    "  <w:kern w:val=\"0\"/>" +
                    "  <w:sz w:val=\"15\"/>" +
                    "  <w:sz-cs w:val=\"15\"/>" +
                    "  <w:u w:val=\"single\"/>" +
                    "</w:rPr>" +
                    "<w:t>：" + getValue(mortgageList, i, "collateralFee") + "</w:t>" +
                    "  </w:r>" +
                    "  <w:r>" +
                    "<w:rPr>" +
                    "  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>" +
                    "  <w:color w:val=\"000000\"/>" +
                    "  <w:kern w:val=\"0\"/>" +
                    "  <w:sz w:val=\"15\"/>" +
                    "  <w:sz-cs w:val=\"15\"/>" +
                    "</w:rPr>" +
                    "<w:t>元</w:t>" +
                    "  </w:r>" +
                    "</w:p>" +
                    "  </w:tc>" +
                    "</w:tr>" +
                    "<w:tr>\n" +
                    "  <w:tblPrEx>\n" +
                    "\t<w:tblCellMar>\n" +
                    "\t  <w:top w:w=\"0\" w:type=\"dxa\"/>\n" +
                    "\t  <w:left w:w=\"108\" w:type=\"dxa\"/>\n" +
                    "\t  <w:bottom w:w=\"0\" w:type=\"dxa\"/>\n" +
                    "\t  <w:right w:w=\"108\" w:type=\"dxa\"/>\n" +
                    "\t</w:tblCellMar>\n" +
                    "  </w:tblPrEx>\n" +
                    "  <w:trPr>\n" +
                    "\t<w:gridBefore w:val=\"1\"/>\n" +
                    "\t<w:wBefore w:w=\"10\" w:type=\"dxa\"/>\n" +
                    "\t<w:trHeight w:val=\"400\" w:h-rule=\"atLeast\"/>\n" +
                    "  </w:trPr>\n" +
                    "  <w:tc>\n" +
                    "\t<w:tcPr>\n" +
                    "\t  <w:tcW w:w=\"1100\" w:type=\"dxa\"/>\n" +
                    "\t  <w:gridSpan w:val=\"2\"/>\n" +
                    "\t  <w:vmerge w:val=\"continue\"/>\n" +
                    "\t  <w:tcBorders>\n" +
                    "\t\t<w:top w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>\n" +
                    "\t\t<w:left w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>\n" +
                    "\t\t<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"000000\"/>\n" +
                    "\t\t<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>\n" +
                    "\t  </w:tcBorders>\n" +
                    "\t  <w:shd w:val=\"pct-10\" w:color=\"auto\" w:fill=\"auto\"/>\n" +
                    "\t  <w:noWrap w:val=\"0\"/>\n" +
                    "\t  <w:vAlign w:val=\"center\"/>\n" +
                    "\t</w:tcPr>\n" +
                    "\t<w:p>\n" +
                    "\t  <w:pPr>\n" +
                    "\t\t<w:widowControl/>\n" +
                    "\t\t<w:jc w:val=\"left\"/>\n" +
                    "\t\t<w:rPr>\n" +
                    "\t\t  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>\n" +
                    "\t\t  <w:color w:val=\"000000\"/>\n" +
                    "\t\t  <w:kern w:val=\"0\"/>\n" +
                    "\t\t  <w:sz w:val=\"15\"/>\n" +
                    "\t\t  <w:sz-cs w:val=\"15\"/>\n" +
                    "\t\t</w:rPr>\n" +
                    "\t  </w:pPr>\n" +
                    "\t</w:p>\n" +
                    "  </w:tc>\n" +
                    "  <w:tc>\n" +
                    "\t<w:tcPr>\n" +
                    "\t  <w:tcW w:w=\"1217\" w:type=\"dxa\"/>\n" +
                    "\t  <w:tcBorders>\n" +
                    "\t\t<w:top w:val=\"nil\"/>\n" +
                    "\t\t<w:left w:val=\"nil\"/>\n" +
                    "\t\t<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>\n" +
                    "\t\t<w:right w:val=\"nil\"/>\n" +
                    "\t  </w:tcBorders>\n" +
                    "\t  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>\n" +
                    "\t  <w:noWrap w:val=\"0\"/>\n" +
                    "\t  <w:vAlign w:val=\"center\"/>\n" +
                    "\t</w:tcPr>\n" +
                    "\t<w:p>\n" +
                    "\t  <w:pPr>\n" +
                    "\t\t<w:widowControl/>\n" +
                    "\t\t<w:jc w:val=\"center\"/>\n" +
                    "\t\t<w:rPr>\n" +
                    "\t\t  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>\n" +
                    "\t\t  <w:color w:val=\"000000\"/>\n" +
                    "\t\t  <w:kern w:val=\"0\"/>\n" +
                    "\t\t  <w:sz w:val=\"15\"/>\n" +
                    "\t\t  <w:sz-cs w:val=\"15\"/>\n" +
                    "\t\t</w:rPr>\n" +
                    "\t  </w:pPr>\n" +
                    "\t  <w:r>\n" +
                    "\t\t<w:rPr>\n" +
                    "\t\t  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>\n" +
                    "\t\t  <w:color w:val=\"000000\"/>\n" +
                    "\t\t  <w:kern w:val=\"0\"/>\n" +
                    "\t\t  <w:sz w:val=\"15\"/>\n" +
                    "\t\t  <w:sz-cs w:val=\"15\"/>\n" +
                    "\t\t</w:rPr>\n" +
                    "\t\t<w:t> 联 系 地 址</w:t>\n" +
                    "\t  </w:r>\n" +
                    "\t</w:p>\n" +
                    "  </w:tc>\n" +
                    "  <w:tc>\n" +
                    "\t<w:tcPr>\n" +
                    "\t  <w:tcW w:w=\"3455\" w:type=\"dxa\"/>\n" +
                    "\t  <w:gridSpan w:val=\"7\"/>\n" +
                    "\t  <w:tcBorders>\n" +
                    "\t\t<w:top w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>\n" +
                    "\t\t<w:left w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>\n" +
                    "\t\t<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>\n" +
                    "\t\t<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"000000\"/>\n" +
                    "\t  </w:tcBorders>\n" +
                    "\t  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>\n" +
                    "\t  <w:noWrap w:val=\"0\"/>\n" +
                    "\t  <w:vAlign w:val=\"center\"/>\n" +
                    "\t</w:tcPr>\n" +
                    "\t<w:p>\n" +
                    "\t  <w:pPr>\n" +
                    "\t\t<w:widowControl/>\n" +
                    "\t\t<w:jc w:val=\"center\"/>\n" +
                    "\t\t<w:rPr>\n" +
                    "\t\t  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>\n" +
                    "\t\t  <w:color w:val=\"000000\"/>\n" +
                    "\t\t  <w:kern w:val=\"0\"/>\n" +
                    "\t\t  <w:sz w:val=\"15\"/>\n" +
                    "\t\t  <w:sz-cs w:val=\"15\"/>\n" +
                    "\t\t</w:rPr>\n" +
                    "\t  </w:pPr>\n" +
                    "\t  <w:r>\n" +
                    "\t\t<w:rPr>\n" +
                    "\t\t  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>\n" +
                    "\t\t  <w:color w:val=\"000000\"/>\n" +
                    "\t\t  <w:kern w:val=\"0\"/>\n" +
                    "\t\t  <w:sz w:val=\"15\"/>\n" +
                    "\t\t  <w:sz-cs w:val=\"15\"/>\n" +
                    "\t\t</w:rPr>\n" +
                    "\t\t<w:t>"+getValue(mortgageList, i, "contactAddress")+"</w:t>\n" +
                    "\t  </w:r>\n" +
                    "\t</w:p>\n" +
                    "  </w:tc>\n" +
                    "  <w:tc>\n" +
                    "\t<w:tcPr>\n" +
                    "\t  <w:tcW w:w=\"1637\" w:type=\"dxa\"/>\n" +
                    "\t  <w:gridSpan w:val=\"2\"/>\n" +
                    "\t  <w:tcBorders>\n" +
                    "\t\t<w:top w:val=\"nil\"/>\n" +
                    "\t\t<w:left w:val=\"nil\"/>\n" +
                    "\t\t<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>\n" +
                    "\t\t<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>\n" +
                    "\t  </w:tcBorders>\n" +
                    "\t  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>\n" +
                    "\t  <w:noWrap w:val=\"0\"/>\n" +
                    "\t  <w:vAlign w:val=\"center\"/>\n" +
                    "\t</w:tcPr>\n" +
                    "\t<w:p>\n" +
                    "\t  <w:pPr>\n" +
                    "\t\t<w:widowControl/>\n" +
                    "\t\t<w:jc w:val=\"center\"/>\n" +
                    "\t\t<w:rPr>\n" +
                    "\t\t  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"default\"/>\n" +
                    "\t\t  <w:color w:val=\"000000\"/>\n" +
                    "\t\t  <w:kern w:val=\"0\"/>\n" +
                    "\t\t  <w:sz w:val=\"15\"/>\n" +
                    "\t\t  <w:sz-cs w:val=\"15\"/>\n" +
                    "\t\t</w:rPr>\n" +
                    "\t  </w:pPr>\n" +
                    "\t  <w:r>\n" +
                    "\t\t<w:rPr>\n" +
                    "\t\t  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>\n" +
                    "\t\t  <w:color w:val=\"000000\"/>\n" +
                    "\t\t  <w:kern w:val=\"0\"/>\n" +
                    "\t\t  <w:sz w:val=\"15\"/>\n" +
                    "\t\t  <w:sz-cs w:val=\"15\"/>\n" +
                    "\t\t</w:rPr>\n" +
                    "\t\t<w:t>抵押物存放地</w:t>\n" +
                    "\t  </w:r>\n" +
                    "\t</w:p>\n" +
                    "  </w:tc>\n" +
                    "  <w:tc>\n" +
                    "\t<w:tcPr>\n" +
                    "\t  <w:tcW w:w=\"2814\" w:type=\"dxa\"/>\n" +
                    "\t  <w:gridSpan w:val=\"3\"/>\n" +
                    "\t  <w:tcBorders>\n" +
                    "\t\t<w:top w:val=\"nil\"/>\n" +
                    "\t\t<w:left w:val=\"nil\"/>\n" +
                    "\t\t<w:bottom w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>\n" +
                    "\t\t<w:right w:val=\"single\" w:sz=\"8\" wx:bdrwidth=\"20\" w:space=\"0\" w:color=\"auto\"/>\n" +
                    "\t  </w:tcBorders>\n" +
                    "\t  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"auto\"/>\n" +
                    "\t  <w:noWrap w:val=\"0\"/>\n" +
                    "\t  <w:vAlign w:val=\"center\"/>\n" +
                    "\t</w:tcPr>\n" +
                    "\t<w:p>\n" +
                    "\t  <w:pPr>\n" +
                    "\t\t<w:widowControl/>\n" +
                    "\t\t<w:jc w:val=\"left\"/>\n" +
                    "\t\t<w:rPr>\n" +
                    "\t\t  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>\n" +
                    "\t\t  <w:color w:val=\"000000\"/>\n" +
                    "\t\t  <w:kern w:val=\"0\"/>\n" +
                    "\t\t  <w:sz w:val=\"15\"/>\n" +
                    "\t\t  <w:sz-cs w:val=\"15\"/>\n" +
                    "\t\t</w:rPr>\n" +
                    "\t  </w:pPr>\n" +
                    "\t  <w:r>\n" +
                    "\t\t<w:rPr>\n" +
                    "\t\t  <w:rFonts w:ascii=\"方正仿宋_GBK\" w:h-ansi=\"宋体\" w:fareast=\"方正仿宋_GBK\" w:cs=\"宋体\" w:hint=\"fareast\"/>\n" +
                    "\t\t  <w:color w:val=\"000000\"/>\n" +
                    "\t\t  <w:kern w:val=\"0\"/>\n" +
                    "\t\t  <w:sz w:val=\"15\"/>\n" +
                    "\t\t  <w:sz-cs w:val=\"15\"/>\n" +
                    "\t\t</w:rPr>\n" +
                    "\t\t<w:t>"+getValue(mortgageList, i, "collateralPosition")+"</w:t>\n" +
                    "\t  </w:r>\n" +
                    "\t</w:p>\n" +
                    "  </w:tc>\n" +
                    "</w:tr>");
        }

        variables.put("mortgageList", data.toString());
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

    private String setUsage(String usage) {
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


    private String setYes(String yes) {
        String yesDes = "";
        if (StringUtils.isEmpty(yes)) {
            yesDes = "□是  □否";
        } else if ("是".equals(yes)) {
            yesDes = "☑是  □否";
        } else if ("否".equals(yes)) {
            yesDes = "□是  ☑否";
        }

        return yesDes;
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


    private void setVariables() {
        variables.put("applyPersonName", "罗永芳");
        variables.put("applyPersonSex", setGender("女"));
        variables.put("applyPersonAge", 50);
        variables.put("applyPersonMaritalStatus", setMaritalStatus("已婚"));
        variables.put("applyPersonMaritalOther", "");

        variables.put("applyPersonIdentityNumber", "510102196901118483");
        variables.put("applyPersonDomicile", "广西桂林市象山区民主路12-1号");


        variables.put("applyPersonCurrentHomeAddress", "广西桂林市象山区民主路12-1号");
        variables.put("applyPersonLocalResidenceTime", 11);


        variables.put("applyPersonContactAddress", setContactAddress("现居住地址"));

        variables.put("applyPersonContactNumber", "15807737711");
        variables.put("applyPersonEmail", "");
        variables.put("applyPersonQQ", "");
        variables.put("applyPersonWeChat", "");

        variables.put("applyPersonEducationalLevel", setEducationalLevel(""));
        variables.put("applyPersonEducationalLevelOther", "");

        variables.put("applyPersonCurrentHousingSource", setCurrentHousingSource("单位宿舍"));
        variables.put("applyPersonCurrentHousingOther", "");

        variables.put("applyPersonEmployer", "");


        variables.put("applyPersonPosition", "");
        variables.put("applyPersonUnitWorkingYears", "");
        variables.put("applyPersonCompanyName", "");
        variables.put("applyPersonShareholdingRatio", "");
        variables.put("applyPersonYearsOperation", "");


        // 以下信息为配偶信息
        variables.put("coupleName", "唐建国");
        variables.put("coupleSex", setGender("男"));
        variables.put("coupleAge", 65);
        variables.put("coupleIdentityNumber", "45030519540601001X");
        variables.put("coupleDomicile", "广西桂林市象山区民主路12-1号");
        variables.put("coupleCurrentHomeAddress", "广西桂林市象山区民主路12-1号");
        variables.put("coupleLocalResidenceTime", 11);
        variables.put("coupleContactAddress", setContactAddress("现居住地址"));
        variables.put("coupleContactNumber", "13707737775");
        variables.put("coupleEmail", "");
        variables.put("coupleQQ", "");

        variables.put("coupleWeChat", "");
        variables.put("coupleEducationalLevel", setEducationalLevel(""));
        variables.put("coupleEducationalLevelOther", "");

        variables.put("coupleCurrentHousingSource", setCurrentHousingSource("单位宿舍"));
        variables.put("coupleCurrentHousingOther", "");


        variables.put("coupleEmployer", "");
        variables.put("couplePosition", "");
        variables.put("coupleUnitWorkingYears", "");

        variables.put("coupleCompanyName", "");
        variables.put("coupleShareholdingRatio", "");
        variables.put("coupleYearsOperation", "");


        // 申请人家庭收支情况

        // 申请人家庭收支情况--家庭总收入
        variables.put("totalRevenue", "300万");
        variables.put("applicantAnnualIncome", "");
        variables.put("applicantOperatingIncome", "150万");
        variables.put("applicantOtherIncome", "150万");

        variables.put("spouseAnnualIncome", "");
        variables.put("spouseOperatingIncome", "");
        variables.put("spouseOtherIncome", "");

        // 申请人家庭收支情况--家庭总支出
        variables.put("totalAnnualExpenditure", "80万");
        variables.put("lifeTotalExpenditure", "");
        variables.put("basicLifeTotalExpenditure", "20万");
        variables.put("educationExpenditure", "");
        variables.put("temporaryExpenditure", "");
        variables.put("debtTotalExpenditure", "");
        variables.put("annualLoanExpenditure", "");
        variables.put("spouseTemporaryExpenditure", "");
        variables.put("supportPopulation", "");
        variables.put("foreignGuaranteeLumpSum", "");

        // 申请借款情况
        variables.put("applicationsAmount", "贰佰万");
        variables.put("applicationDeadline", "叁");
        variables.put("isRound", setYes("是"));

        variables.put("usage", setUsage("其他"));
        variables.put("usageOther", "用于归还借款人罗永芳在广西桂林漓江农村合作银行合同编号为361102150060192、展期协议编号为：361126180056081合同项下所欠债务。");

        variables.put("paymentMethod", setPaymentMethod("按月结息，分期还本"));
        variables.put("paymentMethodOther", "");

        variables.put("isCombinedLoans", setYes(""));
        variables.put("publicLoanCommitment", "");

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

        buildGuaranteeList(true, guaranteeList);

        List<Map<String, Object>> guarantorList = new ArrayList<>();
        Map<String, Object> tempMap1 = new HashMap<>();
        tempMap1.put("name", "唐建国");
        tempMap1.put("mobile", "13707737775");
        tempMap1.put("collateralName", "房产");
        tempMap1.put("collateralAmount", "320.55㎡");
        tempMap1.put("collateralFee", "309.33万");
        tempMap1.put("contactAddress", "广西桂林市叠彩区铁佛路6号2栋2单元501室");
        tempMap1.put("collateralPosition", "秀峰区中山中路38号智能办公大厦五层503、504号办公用房");
        guarantorList.add(tempMap1);

        tempMap1 = new HashMap<>();
        tempMap1.put("name", "罗永芳");
        tempMap1.put("mobile", "15807737711");
        tempMap1.put("collateralName", "房产");
        tempMap1.put("collateralAmount", "320.55㎡");
        tempMap1.put("collateralFee", "309.33万");
        tempMap1.put("contactAddress", "广西桂林市象山区民主路12-1号");
        tempMap1.put("collateralPosition", "秀峰区中山中路38号智能办公大厦五层503、504号办公用房");
        guarantorList.add(tempMap1);

        tempMap1 = new HashMap<>();
        tempMap1.put("name", "罗永芳222");
        tempMap1.put("mobile", "232323");
        tempMap1.put("collateralName", "房产");
        tempMap1.put("collateralAmount", "311.55㎡");
        tempMap1.put("collateralFee", "3119.33万");
        tempMap1.put("contactAddress", "2323232-1号");
        tempMap1.put("collateralPosition", "333333334、504号办公用房");
        guarantorList.add(tempMap1);

        tempMap1 = new HashMap<>();
        tempMap1.put("name", "罗2223");
        tempMap1.put("mobile", "33343434");
        tempMap1.put("collateralName", "房产");
        tempMap1.put("collateralAmount", "340.55㎡");
        tempMap1.put("collateralFee", "309333.33万");
        tempMap1.put("contactAddress", "234234-1号");
        tempMap1.put("collateralPosition", "45455544344、444f2334");
        guarantorList.add(tempMap1);

        buildGuarantorList(true, guarantorList);

    }

    private void replace() {
        for (Map.Entry<String, Object> entry : variables.entrySet()) {
            xmlContent = xmlContent.replace("{{" + entry.getKey() + "}}", entry.getValue().toString());
        }
    }

    private void write2Disk() throws Exception {
        Files.write(Paths.get(DIR + targetDoc), xmlContent.getBytes(Charset.forName("UTF-8")));
    }

    @Test
    public void test() throws Exception {
        readXml();
        setVariables();
        replace();
        write2Disk();
    }


}
