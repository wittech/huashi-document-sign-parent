package com.louis.kitty.admin.office;

import com.louis.kitty.admin.constants.DocConstants;
import com.louis.kitty.admin.model.DocCommonModel;
import com.louis.kitty.common.utils.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PersonalLoanContractTool extends AbstractOfficeTool {

    private void setCoupleInfo(boolean isHasCouple, String coupleName, String coupleIdentityNumber,
                               String coupleAddress, String coupleContactNumber, Map<String, Object> variables) {
        if (!isHasCouple) {
            return;
        }

        StringBuilder data = new StringBuilder();
        data.append("<w:p>\n" +
                "\t<w:pPr>\n" +
                "\t  <w:spacing w:line=\"400\" w:lineRule=\"exact\"/>\n" +
                "\t  <w:ind w:right=\"-94\"/>\n" +
                "\t  <w:jc w:val=\"left\"/>\n" +
                "\t  <w:rPr>\n" +
                "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                "\t\t<w:bCs/>\n" +
                "\t\t<w:color w:val=\"auto\"/>\n" +
                "\t\t<w:sz w:val=\"24\"/>\n" +
                "\t  </w:rPr>\n" +
                "\t</w:pPr>\n" +
                "\t<w:r>\n" +
                "\t  <w:rPr>\n" +
                "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                "\t\t<w:bCs/>\n" +
                "\t\t<w:color w:val=\"auto\"/>\n" +
                "\t\t<w:sz w:val=\"24\"/>\n" +
                "\t\t<w:lang w:eastAsia=\"zh-CN\"/>\n" +
                "\t  </w:rPr>\n" +
                "\t  <w:t>共同借款人</w:t>\n" +
                "\t</w:r>\n" +
                "\t<w:r>\n" +
                "\t  <w:rPr>\n" +
                "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\" w:cs=\"宋体\"/>\n" +
                "\t\t<w:bCs/>\n" +
                "\t\t<w:color w:val=\"auto\"/>\n" +
                "\t\t<w:sz w:val=\"24\"/>\n" +
                "\t  </w:rPr>\n" +
                "\t  <w:t>：</w:t>\n" +
                "\t</w:r>\n" +
                "\t<w:r>\n" +
                "\t  <w:rPr>\n" +
                "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\" w:cs=\"宋体\"/>\n" +
                "\t\t<w:bCs/>\n" +
                "\t\t<w:color w:val=\"auto\"/>\n" +
                "\t\t<w:sz w:val=\"24\"/>\n" +
                "\t\t<w:u w:val=\"single\"/>\n" +
                "\t  </w:rPr>\n" +
                "\t  <w:t xml:space=\"preserve\">           " + coupleName + "                   </w:t>\n" +
                "\t</w:r>\n" +
                "  </w:p>\n" +
                "  <w:p>\n" +
                "\t<w:pPr>\n" +
                "\t  <w:pStyle w:val=\"15\"/>\n" +
                "\t  <w:spacing w:line=\"400\" w:lineRule=\"exact\"/>\n" +
                "\t  <w:rPr>\n" +
                "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                "\t\t<w:bCs/>\n" +
                "\t\t<w:color w:val=\"auto\"/>\n" +
                "\t\t<w:kern w:val=\"2\"/>\n" +
                "\t\t<w:sz w:val=\"24\"/>\n" +
                "\t\t<w:szCs w:val=\"24\"/>\n" +
                "\t  </w:rPr>\n" +
                "\t</w:pPr>\n" +
                "\t<w:r>\n" +
                "\t  <w:rPr>\n" +
                "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\" w:cs=\"宋体\"/>\n" +
                "\t\t<w:bCs/>\n" +
                "\t\t<w:color w:val=\"auto\"/>\n" +
                "\t\t<w:kern w:val=\"2\"/>\n" +
                "\t\t<w:sz w:val=\"24\"/>\n" +
                "\t\t<w:szCs w:val=\"24\"/>\n" +
                "\t  </w:rPr>\n" +
                "\t  <w:t>身份证件及号码：</w:t>\n" +
                "\t</w:r>\n" +
                "\t<w:r>\n" +
                "\t  <w:rPr>\n" +
                "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\" w:cs=\"宋体\"/>\n" +
                "\t\t<w:bCs/>\n" +
                "\t\t<w:color w:val=\"auto\"/>\n" +
                "\t\t<w:sz w:val=\"24\"/>\n" +
                "\t\t<w:szCs w:val=\"24\"/>\n" +
                "\t\t<w:u w:val=\"single\"/>\n" +
                "\t  </w:rPr>\n" +
                "\t  <w:t xml:space=\"preserve\">    " + coupleIdentityNumber + "        </w:t>\n" +
                "\t</w:r>\n" +
                "  </w:p>\n" +
                "  <w:p>\n" +
                "\t<w:pPr>\n" +
                "\t  <w:pStyle w:val=\"15\"/>\n" +
                "\t  <w:tabs>\n" +
                "\t\t<w:tab w:val=\"center\" w:pos=\"5940\"/>\n" +
                "\t  </w:tabs>\n" +
                "\t  <w:spacing w:line=\"400\" w:lineRule=\"exact\"/>\n" +
                "\t  <w:rPr>\n" +
                "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                "\t\t<w:bCs/>\n" +
                "\t\t<w:color w:val=\"auto\"/>\n" +
                "\t\t<w:kern w:val=\"2\"/>\n" +
                "\t\t<w:sz w:val=\"24\"/>\n" +
                "\t\t<w:szCs w:val=\"24\"/>\n" +
                "\t  </w:rPr>\n" +
                "\t</w:pPr>\n" +
                "\t<w:r>\n" +
                "\t  <w:rPr>\n" +
                "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\" w:cs=\"宋体\"/>\n" +
                "\t\t<w:bCs/>\n" +
                "\t\t<w:color w:val=\"auto\"/>\n" +
                "\t\t<w:kern w:val=\"2\"/>\n" +
                "\t\t<w:sz w:val=\"24\"/>\n" +
                "\t\t<w:szCs w:val=\"24\"/>\n" +
                "\t  </w:rPr>\n" +
                "\t  <w:t>住址：</w:t>\n" +
                "\t</w:r>\n" +
                "\t<w:r>\n" +
                "\t  <w:rPr>\n" +
                "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\" w:cs=\"宋体\"/>\n" +
                "\t\t<w:bCs/>\n" +
                "\t\t<w:color w:val=\"auto\"/>\n" +
                "\t\t<w:sz w:val=\"24\"/>\n" +
                "\t\t<w:szCs w:val=\"24\"/>\n" +
                "\t\t<w:u w:val=\"single\"/>\n" +
                "\t  </w:rPr>\n" +
                "\t  <w:t xml:space=\"preserve\"> " + coupleAddress + "   </w:t>\n" +
                "\t</w:r>\n" +
                "\t<w:r>\n" +
                "\t  <w:rPr>\n" +
                "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\" w:cs=\"宋体\"/>\n" +
                "\t\t<w:bCs/>\n" +
                "\t\t<w:color w:val=\"auto\"/>\n" +
                "\t\t<w:sz w:val=\"24\"/>\n" +
                "\t\t<w:szCs w:val=\"24\"/>\n" +
                "\t\t<w:u w:val=\"single\"/>\n" +
                "\t\t<w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                "\t  </w:rPr>\n" +
                "\t  <w:t xml:space=\"preserve\">     </w:t>\n" +
                "\t</w:r>\n" +
                "\t<w:r>\n" +
                "\t  <w:rPr>\n" +
                "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\" w:cs=\"宋体\"/>\n" +
                "\t\t<w:bCs/>\n" +
                "\t\t<w:color w:val=\"auto\"/>\n" +
                "\t\t<w:sz w:val=\"24\"/>\n" +
                "\t\t<w:szCs w:val=\"24\"/>\n" +
                "\t  </w:rPr>\n" +
                "\t  <w:t>邮编：</w:t>\n" +
                "\t</w:r>\n" +
                "\t<w:r>\n" +
                "\t  <w:rPr>\n" +
                "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\" w:cs=\"宋体\"/>\n" +
                "\t\t<w:bCs/>\n" +
                "\t\t<w:color w:val=\"auto\"/>\n" +
                "\t\t<w:sz w:val=\"24\"/>\n" +
                "\t\t<w:szCs w:val=\"24\"/>\n" +
                "\t\t<w:u w:val=\"single\"/>\n" +
                "\t  </w:rPr>\n" +
                "\t  <w:t xml:space=\"preserve\">  </w:t>\n" +
                "\t</w:r>\n" +
                "\t<w:r>\n" +
                "\t  <w:rPr>\n" +
                "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\" w:cs=\"宋体\"/>\n" +
                "\t\t<w:bCs/>\n" +
                "\t\t<w:color w:val=\"auto\"/>\n" +
                "\t\t<w:sz w:val=\"24\"/>\n" +
                "\t\t<w:szCs w:val=\"24\"/>\n" +
                "\t\t<w:u w:val=\"single\"/>\n" +
                "\t\t<w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                "\t  </w:rPr>\n" +
                "\t  <w:t xml:space=\"preserve\"> </w:t>\n" +
                "\t</w:r>\n" +
                "\t<w:r>\n" +
                "\t  <w:rPr>\n" +
                "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\" w:cs=\"宋体\"/>\n" +
                "\t\t<w:bCs/>\n" +
                "\t\t<w:color w:val=\"auto\"/>\n" +
                "\t\t<w:sz w:val=\"24\"/>\n" +
                "\t\t<w:szCs w:val=\"24\"/>\n" +
                "\t\t<w:u w:val=\"single\"/>\n" +
                "\t  </w:rPr>\n" +
                "\t  <w:t xml:space=\"preserve\">         </w:t>\n" +
                "\t</w:r>\n" +
                "  </w:p>\n" +
                "  <w:p>\n" +
                "\t<w:pPr>\n" +
                "\t  <w:pStyle w:val=\"15\"/>\n" +
                "\t  <w:spacing w:line=\"400\" w:lineRule=\"exact\"/>\n" +
                "\t  <w:rPr>\n" +
                "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\" w:cs=\"宋体\"/>\n" +
                "\t\t<w:bCs/>\n" +
                "\t\t<w:color w:val=\"auto\"/>\n" +
                "\t\t<w:kern w:val=\"2\"/>\n" +
                "\t\t<w:sz w:val=\"24\"/>\n" +
                "\t\t<w:szCs w:val=\"24\"/>\n" +
                "\t\t<w:u w:val=\"single\"/>\n" +
                "\t  </w:rPr>\n" +
                "\t</w:pPr>\n" +
                "\t<w:r>\n" +
                "\t  <w:rPr>\n" +
                "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\" w:cs=\"宋体\"/>\n" +
                "\t\t<w:bCs/>\n" +
                "\t\t<w:color w:val=\"auto\"/>\n" +
                "\t\t<w:kern w:val=\"2\"/>\n" +
                "\t\t<w:sz w:val=\"24\"/>\n" +
                "\t\t<w:szCs w:val=\"24\"/>\n" +
                "\t  </w:rPr>\n" +
                "\t  <w:t>电话：</w:t>\n" +
                "\t</w:r>\n" +
                "\t<w:r>\n" +
                "\t  <w:rPr>\n" +
                "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\" w:cs=\"宋体\"/>\n" +
                "\t\t<w:bCs/>\n" +
                "\t\t<w:color w:val=\"auto\"/>\n" +
                "\t\t<w:kern w:val=\"2\"/>\n" +
                "\t\t<w:sz w:val=\"24\"/>\n" +
                "\t\t<w:szCs w:val=\"24\"/>\n" +
                "\t\t<w:u w:val=\"single\"/>\n" +
                "\t  </w:rPr>\n" +
                "\t  <w:t xml:space=\"preserve\">            " + coupleContactNumber + "                  </w:t>\n" +
                "\t</w:r>\n" +
                "  </w:p>\n" +
                "  <w:p>\n" +
                "\t<w:pPr>\n" +
                "\t  <w:spacing w:line=\"400\" w:lineRule=\"exact\"/>\n" +
                "\t  <w:rPr>\n" +
                "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                "\t\t<w:bCs/>\n" +
                "\t\t<w:sz w:val=\"24\"/>\n" +
                "\t  </w:rPr>\n" +
                "\t</w:pPr>\n" +
                "  </w:p>");

        variables.put("coupleInfo", data.toString());
    }

    private void setCounterpartyInformation(List<Map<String, Object>> counterpartyInformations, Map<String, Object> variables) {
        StringBuilder data = new StringBuilder();
        for (Map<String, Object> counterparty : counterpartyInformations) {
            data.append("<w:tr>\n" +
                    "\t  <w:tblPrEx>\n" +
                    "\t\t<w:tblBorders>\n" +
                    "\t\t  <w:top w:val=\"single\" w:color=\"auto\" w:sz=\"4\" w:space=\"0\"/>\n" +
                    "\t\t  <w:left w:val=\"single\" w:color=\"auto\" w:sz=\"4\" w:space=\"0\"/>\n" +
                    "\t\t  <w:bottom w:val=\"single\" w:color=\"auto\" w:sz=\"4\" w:space=\"0\"/>\n" +
                    "\t\t  <w:right w:val=\"single\" w:color=\"auto\" w:sz=\"4\" w:space=\"0\"/>\n" +
                    "\t\t  <w:insideH w:val=\"single\" w:color=\"auto\" w:sz=\"4\" w:space=\"0\"/>\n" +
                    "\t\t  <w:insideV w:val=\"single\" w:color=\"auto\" w:sz=\"4\" w:space=\"0\"/>\n" +
                    "\t\t</w:tblBorders>\n" +
                    "\t\t<w:tblLayout w:type=\"fixed\"/>\n" +
                    "\t\t<w:tblCellMar>\n" +
                    "\t\t  <w:top w:w=\"0\" w:type=\"dxa\"/>\n" +
                    "\t\t  <w:left w:w=\"108\" w:type=\"dxa\"/>\n" +
                    "\t\t  <w:bottom w:w=\"0\" w:type=\"dxa\"/>\n" +
                    "\t\t  <w:right w:w=\"108\" w:type=\"dxa\"/>\n" +
                    "\t\t</w:tblCellMar>\n" +
                    "\t  </w:tblPrEx>\n" +
                    "\t  <w:trPr>\n" +
                    "\t\t<w:trHeight w:val=\"418\" w:hRule=\"atLeast\"/>\n" +
                    "\t  </w:trPr>\n" +
                    "\t  <w:tc>\n" +
                    "\t\t<w:tcPr>\n" +
                    "\t\t  <w:tcW w:w=\"1231\" w:type=\"dxa\"/>\n" +
                    "\t\t  <w:noWrap w:val=\"0\"/>\n" +
                    "\t\t  <w:vAlign w:val=\"top\"/>\n" +
                    "\t\t</w:tcPr>\n" +
                    "\t\t<w:p>\n" +
                    "\t\t  <w:pPr>\n" +
                    "\t\t\t<w:snapToGrid w:val=\"0\"/>\n" +
                    "\t\t\t<w:spacing w:line=\"360\" w:lineRule=\"exact\"/>\n" +
                    "\t\t\t<w:ind w:firstLine=\"240\" w:firstLineChars=\"100\"/>\n" +
                    "\t\t\t<w:jc w:val=\"both\"/>\n" +
                    "\t\t\t<w:rPr>\n" +
                    "\t\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                    "\t\t\t  <w:color w:val=\"FF0000\"/>\n" +
                    "\t\t\t  <w:sz w:val=\"24\"/>\n" +
                    "\t\t\t  <w:lang w:eastAsia=\"zh-CN\"/>\n" +
                    "\t\t\t</w:rPr>\n" +
                    "\t\t  </w:pPr>\n" +
                    "\t\t  <w:r>\n" +
                    "\t\t\t<w:rPr>\n" +
                    "\t\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                    "\t\t\t  <w:sz w:val=\"24\"/>\n" +
                    "\t\t\t  <w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                    "\t\t\t</w:rPr>\n" +
                    "\t\t\t<w:t>" + counterparty.get("name") + "</w:t>\n" +
                    "\t\t  </w:r>\n" +
                    "\t\t</w:p>\n" +
                    "\t  </w:tc>\n" +
                    "\t  <w:tc>\n" +
                    "\t\t<w:tcPr>\n" +
                    "\t\t  <w:tcW w:w=\"1425\" w:type=\"dxa\"/>\n" +
                    "\t\t  <w:noWrap w:val=\"0\"/>\n" +
                    "\t\t  <w:vAlign w:val=\"top\"/>\n" +
                    "\t\t</w:tcPr>\n" +
                    "\t\t<w:p>\n" +
                    "\t\t  <w:pPr>\n" +
                    "\t\t\t<w:snapToGrid w:val=\"0\"/>\n" +
                    "\t\t\t<w:spacing w:line=\"360\" w:lineRule=\"exact\"/>\n" +
                    "\t\t\t<w:jc w:val=\"left\"/>\n" +
                    "\t\t\t<w:rPr>\n" +
                    "\t\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                    "\t\t\t  <w:color w:val=\"FF0000\"/>\n" +
                    "\t\t\t  <w:sz w:val=\"24\"/>\n" +
                    "\t\t\t  <w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                    "\t\t\t</w:rPr>\n" +
                    "\t\t  </w:pPr>\n" +
                    "\t\t  <w:r>\n" +
                    "\t\t\t<w:rPr>\n" +
                    "\t\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                    "\t\t\t  <w:sz w:val=\"24\"/>\n" +
                    "\t\t\t  <w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                    "\t\t\t</w:rPr>\n" +
                    "\t\t\t<w:t>" + counterparty.get("accountNo") + "</w:t>\n" +
                    "\t\t  </w:r>\n" +
                    "\t\t</w:p>\n" +
                    "\t  </w:tc>\n" +
                    "\t  <w:tc>\n" +
                    "\t\t<w:tcPr>\n" +
                    "\t\t  <w:tcW w:w=\"1337\" w:type=\"dxa\"/>\n" +
                    "\t\t  <w:noWrap w:val=\"0\"/>\n" +
                    "\t\t  <w:vAlign w:val=\"top\"/>\n" +
                    "\t\t</w:tcPr>\n" +
                    "\t\t<w:p>\n" +
                    "\t\t  <w:pPr>\n" +
                    "\t\t\t<w:snapToGrid w:val=\"0\"/>\n" +
                    "\t\t\t<w:spacing w:line=\"360\" w:lineRule=\"exact\"/>\n" +
                    "\t\t\t<w:rPr>\n" +
                    "\t\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                    "\t\t\t  <w:color w:val=\"FF0000\"/>\n" +
                    "\t\t\t  <w:sz w:val=\"24\"/>\n" +
                    "\t\t\t  <w:lang w:eastAsia=\"zh-CN\"/>\n" +
                    "\t\t\t</w:rPr>\n" +
                    "\t\t  </w:pPr>\n" +
                    "\t\t  <w:r>\n" +
                    "\t\t\t<w:rPr>\n" +
                    "\t\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                    "\t\t\t  <w:sz w:val=\"24\"/>\n" +
                    "\t\t\t  <w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                    "\t\t\t</w:rPr>\n" +
                    "\t\t\t<w:t>" + counterparty.get("bankName") + "</w:t>\n" +
                    "\t\t  </w:r>\n" +
                    "\t\t</w:p>\n" +
                    "\t  </w:tc>\n" +
                    "\t  <w:tc>\n" +
                    "\t\t<w:tcPr>\n" +
                    "\t\t  <w:tcW w:w=\"1583\" w:type=\"dxa\"/>\n" +
                    "\t\t  <w:noWrap w:val=\"0\"/>\n" +
                    "\t\t  <w:vAlign w:val=\"top\"/>\n" +
                    "\t\t</w:tcPr>\n" +
                    "\t\t<w:p>\n" +
                    "\t\t  <w:pPr>\n" +
                    "\t\t\t<w:snapToGrid w:val=\"0\"/>\n" +
                    "\t\t\t<w:spacing w:line=\"360\" w:lineRule=\"exact\"/>\n" +
                    "\t\t\t<w:rPr>\n" +
                    "\t\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                    "\t\t\t  <w:color w:val=\"FF0000\"/>\n" +
                    "\t\t\t  <w:sz w:val=\"24\"/>\n" +
                    "\t\t\t  <w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                    "\t\t\t</w:rPr>\n" +
                    "\t\t  </w:pPr>\n" +
                    "\t\t  <w:r>\n" +
                    "\t\t\t<w:rPr>\n" +
                    "\t\t\t  <w:rFonts w:hint=\"default\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                    "\t\t\t  <w:sz w:val=\"24\"/>\n" +
                    "\t\t\t  <w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                    "\t\t\t</w:rPr>\n" +
                    "\t\t\t<w:t>¥</w:t>\n" +
                    "\t\t  </w:r>\n" +
                    "\t\t  <w:r>\n" +
                    "\t\t\t<w:rPr>\n" +
                    "\t\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                    "\t\t\t  <w:sz w:val=\"24\"/>\n" +
                    "\t\t\t  <w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                    "\t\t\t</w:rPr>\n" +
                    "\t\t\t<w:t>" + counterparty.get("money") + "</w:t>\n" +
                    "\t\t  </w:r>\n" +
                    "\t\t</w:p>\n" +
                    "\t  </w:tc>\n" +
                    "\t  <w:tc>\n" +
                    "\t\t<w:tcPr>\n" +
                    "\t\t  <w:tcW w:w=\"2664\" w:type=\"dxa\"/>\n" +
                    "\t\t  <w:noWrap w:val=\"0\"/>\n" +
                    "\t\t  <w:vAlign w:val=\"top\"/>\n" +
                    "\t\t</w:tcPr>\n" +
                    "\t\t<w:p>\n" +
                    "\t\t  <w:pPr>\n" +
                    "\t\t\t<w:keepNext w:val=\"0\"/>\n" +
                    "\t\t\t<w:keepLines w:val=\"0\"/>\n" +
                    "\t\t\t<w:pageBreakBefore w:val=\"0\"/>\n" +
                    "\t\t\t<w:widowControl w:val=\"0\"/>\n" +
                    "\t\t\t<w:kinsoku/>\n" +
                    "\t\t\t<w:wordWrap/>\n" +
                    "\t\t\t<w:overflowPunct/>\n" +
                    "\t\t\t<w:topLinePunct w:val=\"0\"/>\n" +
                    "\t\t\t<w:autoSpaceDE/>\n" +
                    "\t\t\t<w:autoSpaceDN/>\n" +
                    "\t\t\t<w:bidi w:val=\"0\"/>\n" +
                    "\t\t\t<w:adjustRightInd/>\n" +
                    "\t\t\t<w:snapToGrid w:val=\"0\"/>\n" +
                    "\t\t\t<w:spacing w:line=\"280\" w:lineRule=\"exact\"/>\n" +
                    "\t\t\t<w:textAlignment w:val=\"auto\"/>\n" +
                    "\t\t\t<w:outlineLvl w:val=\"9\"/>\n" +
                    "\t\t\t<w:rPr>\n" +
                    "\t\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                    "\t\t\t  <w:color w:val=\"FF0000\"/>\n" +
                    "\t\t\t  <w:sz w:val=\"24\"/>\n" +
                    "\t\t\t  <w:lang w:eastAsia=\"zh-CN\"/>\n" +
                    "\t\t\t</w:rPr>\n" +
                    "\t\t  </w:pPr>\n" +
                    "\t\t  <w:r>\n" +
                    "\t\t\t<w:rPr>\n" +
                    "\t\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                    "\t\t\t  <w:sz w:val=\"24\"/>\n" +
                    "\t\t\t  <w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                    "\t\t\t</w:rPr>\n" +
                    "\t\t\t<w:t xml:space=\"preserve\">" + counterparty.get("usage") + " </w:t>\n" +
                    "\t\t  </w:r>\n" +
                    "\t\t</w:p>\n" +
                    "\t  </w:tc>\n" +
                    "\t</w:tr>");
        }

        variables.put("counterpartyInformation", data.toString());
    }

    private void setRepaymentPlanList(List<Map<String, Object>> repaymentPlanList, Map<String, Object> variables) {
        StringBuilder data = new StringBuilder();
        for (Map<String, Object> repaymentPlan : repaymentPlanList) {
            data.append("<w:p>\n" +
                    "\t<w:pPr>\n" +
                    "\t  <w:snapToGrid w:val=\"0\"/>\n" +
                    "\t  <w:spacing w:line=\"360\" w:lineRule=\"exact\"/>\n" +
                    "\t  <w:ind w:firstLine=\"540\"/>\n" +
                    "\t  <w:outlineLvl w:val=\"0\"/>\n" +
                    "\t  <w:rPr>\n" +
                    "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                    "\t\t<w:sz w:val=\"24\"/>\n" +
                    "\t  </w:rPr>\n" +
                    "\t</w:pPr>\n" +
                    "\t<w:r>\n" +
                    "\t  <w:rPr>\n" +
                    "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                    "\t\t<w:sz w:val=\"24\"/>\n" +
                    "\t\t<w:u w:val=\"single\"/>\n" +
                    "\t  </w:rPr>\n" +
                    "\t  <w:t xml:space=\"preserve\"> </w:t>\n" +
                    "\t</w:r>\n" +
                    "\t<w:r>\n" +
                    "\t  <w:rPr>\n" +
                    "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                    "\t\t<w:sz w:val=\"24\"/>\n" +
                    "\t\t<w:u w:val=\"single\"/>\n" +
                    "\t\t<w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                    "\t  </w:rPr>\n" +
                    "\t  <w:t>" + repaymentPlan.get("year") + "</w:t>\n" +
                    "\t</w:r>\n" +
                    "\t<w:r>\n" +
                    "\t  <w:rPr>\n" +
                    "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                    "\t\t<w:sz w:val=\"24\"/>\n" +
                    "\t\t<w:u w:val=\"single\"/>\n" +
                    "\t  </w:rPr>\n" +
                    "\t  <w:t xml:space=\"preserve\"> </w:t>\n" +
                    "\t</w:r>\n" +
                    "\t<w:r>\n" +
                    "\t  <w:rPr>\n" +
                    "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                    "\t\t<w:sz w:val=\"24\"/>\n" +
                    "\t  </w:rPr>\n" +
                    "\t  <w:t>年</w:t>\n" +
                    "\t</w:r>\n" +
                    "\t<w:r>\n" +
                    "\t  <w:rPr>\n" +
                    "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                    "\t\t<w:sz w:val=\"24\"/>\n" +
                    "\t\t<w:u w:val=\"single\"/>\n" +
                    "\t  </w:rPr>\n" +
                    "\t  <w:t xml:space=\"preserve\"> </w:t>\n" +
                    "\t</w:r>\n" +
                    "\t<w:r>\n" +
                    "\t  <w:rPr>\n" +
                    "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                    "\t\t<w:sz w:val=\"24\"/>\n" +
                    "\t\t<w:u w:val=\"single\"/>\n" +
                    "\t\t<w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                    "\t  </w:rPr>\n" +
                    "\t  <w:t>" + repaymentPlan.get("month") + "</w:t>\n" +
                    "\t</w:r>\n" +
                    "\t<w:r>\n" +
                    "\t  <w:rPr>\n" +
                    "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                    "\t\t<w:sz w:val=\"24\"/>\n" +
                    "\t  </w:rPr>\n" +
                    "\t  <w:t>月</w:t>\n" +
                    "\t</w:r>\n" +
                    "\t<w:r>\n" +
                    "\t  <w:rPr>\n" +
                    "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                    "\t\t<w:sz w:val=\"24\"/>\n" +
                    "\t\t<w:u w:val=\"single\"/>\n" +
                    "\t  </w:rPr>\n" +
                    "\t  <w:t xml:space=\"preserve\"> </w:t>\n" +
                    "\t</w:r>\n" +
                    "\t<w:r>\n" +
                    "\t  <w:rPr>\n" +
                    "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                    "\t\t<w:sz w:val=\"24\"/>\n" +
                    "\t\t<w:u w:val=\"single\"/>\n" +
                    "\t\t<w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                    "\t  </w:rPr>\n" +
                    "\t  <w:t>" + repaymentPlan.get("day") + "</w:t>\n" +
                    "\t</w:r>\n" +
                    "\t<w:r>\n" +
                    "\t  <w:rPr>\n" +
                    "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                    "\t\t<w:sz w:val=\"24\"/>\n" +
                    "\t\t<w:u w:val=\"single\"/>\n" +
                    "\t  </w:rPr>\n" +
                    "\t  <w:t xml:space=\"preserve\">  </w:t>\n" +
                    "\t</w:r>\n" +
                    "\t<w:r>\n" +
                    "\t  <w:rPr>\n" +
                    "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                    "\t\t<w:sz w:val=\"24\"/>\n" +
                    "\t  </w:rPr>\n" +
                    "\t  <w:t>日，偿还贷款本金</w:t>\n" +
                    "\t</w:r>\n" +
                    "\t<w:r>\n" +
                    "\t  <w:rPr>\n" +
                    "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                    "\t\t<w:sz w:val=\"24\"/>\n" +
                    "\t\t<w:u w:val=\"single\"/>\n" +
                    "\t  </w:rPr>\n" +
                    "\t  <w:t xml:space=\"preserve\">   </w:t>\n" +
                    "\t</w:r>\n" +
                    "\t<w:r>\n" +
                    "\t  <w:rPr>\n" +
                    "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                    "\t\t<w:sz w:val=\"24\"/>\n" +
                    "\t\t<w:u w:val=\"single\"/>\n" +
                    "\t\t<w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                    "\t  </w:rPr>\n" +
                    "\t  <w:t xml:space=\"preserve\">" + repaymentPlan.get("moneyRMB") + "</w:t>\n" +
                    "\t</w:r>\n" +
                    "\t<w:r>\n" +
                    "\t  <w:rPr>\n" +
                    "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                    "\t\t<w:sz w:val=\"24\"/>\n" +
                    "\t\t<w:u w:val=\"single\"/>\n" +
                    "\t  </w:rPr>\n" +
                    "\t  <w:t xml:space=\"preserve\"> </w:t>\n" +
                    "\t</w:r>\n" +
                    "\t<w:r>\n" +
                    "\t  <w:rPr>\n" +
                    "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                    "\t\t<w:sz w:val=\"24\"/>\n" +
                    "\t  </w:rPr>\n" +
                    "\t  <w:t>元；</w:t>\n" +
                    "\t</w:r>\n" +
                    "  </w:p>");
        }

        variables.put("repaymentPlanList", data.toString());
    }

    private void setApplyFamilyPersonList(List<Map<String, Object>> applyFamilyPersonList, Map<String, Object> variables) {
        StringBuilder data = new StringBuilder();
        for (Map<String, Object> applyFamilyPerson : applyFamilyPersonList) {
            data.append("<w:p>\n" +
                    "\t<w:pPr>\n" +
                    "\t  <w:spacing w:line=\"400\" w:lineRule=\"exact\"/>\n" +
                    "\t  <w:ind w:firstLine=\"482\" w:firstLineChars=\"200\"/>\n" +
                    "\t  <w:rPr>\n" +
                    "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                    "\t\t<w:b/>\n" +
                    "\t\t<w:color w:val=\"auto\"/>\n" +
                    "\t\t<w:sz w:val=\"24\"/>\n" +
                    "\t  </w:rPr>\n" +
                    "\t</w:pPr>\n" +
                    "\t<w:bookmarkStart w:id=\"0\" w:name=\"_GoBack\"/>\n" +
                    "\t<w:bookmarkEnd w:id=\"0\"/>\n" +
                    "\t<w:r>\n" +
                    "\t  <w:rPr>\n" +
                    "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"黑体\" w:hAnsi=\"宋体\" w:eastAsia=\"黑体\" w:cs=\"黑体\"/>\n" +
                    "\t\t<w:b/>\n" +
                    "\t\t<w:bCs/>\n" +
                    "\t\t<w:color w:val=\"auto\"/>\n" +
                    "\t\t<w:sz w:val=\"24\"/>\n" +
                    "\t  </w:rPr>\n" +
                    "\t  <w:t>邮寄地址</w:t>\n" +
                    "\t</w:r>\n" +
                    "\t<w:r>\n" +
                    "\t  <w:rPr>\n" +
                    "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                    "\t\t<w:b/>\n" +
                    "\t\t<w:color w:val=\"auto\"/>\n" +
                    "\t\t<w:sz w:val=\"24\"/>\n" +
                    "\t\t<w:u w:val=\"single\"/>\n" +
                    "\t  </w:rPr>\n" +
                    "\t  <w:t xml:space=\"preserve\"> </w:t>\n" +
                    "\t</w:r>\n" +
                    "\t<w:r>\n" +
                    "\t  <w:rPr>\n" +
                    "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\" w:cs=\"宋体\"/>\n" +
                    "\t\t<w:bCs/>\n" +
                    "\t\t<w:color w:val=\"auto\"/>\n" +
                    "\t\t<w:sz w:val=\"24\"/>\n" +
                    "\t\t<w:szCs w:val=\"24\"/>\n" +
                    "\t\t<w:u w:val=\"single\"/>\n" +
                    "\t\t<w:lang w:eastAsia=\"zh-CN\"/>\n" +
                    "\t  </w:rPr>\n" +
                    "\t  <w:t>" + applyFamilyPerson.get("address") + "</w:t>\n" +
                    "\t</w:r>\n" +
                    "\t<w:r>\n" +
                    "\t  <w:rPr>\n" +
                    "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                    "\t\t<w:b/>\n" +
                    "\t\t<w:color w:val=\"auto\"/>\n" +
                    "\t\t<w:sz w:val=\"24\"/>\n" +
                    "\t  </w:rPr>\n" +
                    "\t  <w:t>，</w:t>\n" +
                    "\t</w:r>\n" +
                    "\t<w:r>\n" +
                    "\t  <w:rPr>\n" +
                    "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"黑体\" w:hAnsi=\"宋体\" w:eastAsia=\"黑体\" w:cs=\"黑体\"/>\n" +
                    "\t\t<w:b/>\n" +
                    "\t\t<w:bCs/>\n" +
                    "\t\t<w:color w:val=\"auto\"/>\n" +
                    "\t\t<w:sz w:val=\"24\"/>\n" +
                    "\t  </w:rPr>\n" +
                    "\t  <w:t>指定收件人：</w:t>\n" +
                    "\t</w:r>\n" +
                    "\t<w:r>\n" +
                    "\t  <w:rPr>\n" +
                    "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                    "\t\t<w:b/>\n" +
                    "\t\t<w:color w:val=\"auto\"/>\n" +
                    "\t\t<w:sz w:val=\"24\"/>\n" +
                    "\t\t<w:u w:val=\"single\"/>\n" +
                    "\t  </w:rPr>\n" +
                    "\t  <w:t xml:space=\"preserve\"> </w:t>\n" +
                    "\t</w:r>\n" +
                    "\t<w:r>\n" +
                    "\t  <w:rPr>\n" +
                    "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\" w:cs=\"宋体\"/>\n" +
                    "\t\t<w:bCs/>\n" +
                    "\t\t<w:color w:val=\"auto\"/>\n" +
                    "\t\t<w:sz w:val=\"24\"/>\n" +
                    "\t\t<w:u w:val=\"single\"/>\n" +
                    "\t\t<w:lang w:eastAsia=\"zh-CN\"/>\n" +
                    "\t  </w:rPr>\n" +
                    "\t  <w:t>" + applyFamilyPerson.get("name") + "</w:t>\n" +
                    "\t</w:r>\n" +
                    "\t<w:r>\n" +
                    "\t  <w:rPr>\n" +
                    "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                    "\t\t<w:b/>\n" +
                    "\t\t<w:color w:val=\"auto\"/>\n" +
                    "\t\t<w:sz w:val=\"24\"/>\n" +
                    "\t\t<w:u w:val=\"single\"/>\n" +
                    "\t  </w:rPr>\n" +
                    "\t  <w:t xml:space=\"preserve\"> </w:t>\n" +
                    "\t</w:r>\n" +
                    "\t<w:r>\n" +
                    "\t  <w:rPr>\n" +
                    "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"黑体\" w:hAnsi=\"宋体\" w:eastAsia=\"黑体\" w:cs=\"黑体\"/>\n" +
                    "\t\t<w:b/>\n" +
                    "\t\t<w:bCs/>\n" +
                    "\t\t<w:color w:val=\"auto\"/>\n" +
                    "\t\t<w:sz w:val=\"24\"/>\n" +
                    "\t  </w:rPr>\n" +
                    "\t  <w:t>电话号码：</w:t>\n" +
                    "\t</w:r>\n" +
                    "\t<w:r>\n" +
                    "\t  <w:rPr>\n" +
                    "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                    "\t\t<w:b/>\n" +
                    "\t\t<w:color w:val=\"auto\"/>\n" +
                    "\t\t<w:sz w:val=\"24\"/>\n" +
                    "\t\t<w:u w:val=\"single\"/>\n" +
                    "\t  </w:rPr>\n" +
                    "\t  <w:t xml:space=\"preserve\"> " + applyFamilyPerson.get("mobile") + "</w:t>\n" +
                    "\t</w:r>\n" +
                    "\t<w:r>\n" +
                    "\t  <w:rPr>\n" +
                    "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                    "\t\t<w:b/>\n" +
                    "\t\t<w:color w:val=\"auto\"/>\n" +
                    "\t\t<w:sz w:val=\"24\"/>\n" +
                    "\t  </w:rPr>\n" +
                    "\t  <w:t xml:space=\"preserve\"> </w:t>\n" +
                    "\t</w:r>\n" +
                    "\t<w:r>\n" +
                    "\t  <w:rPr>\n" +
                    "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"黑体\" w:hAnsi=\"宋体\" w:eastAsia=\"黑体\" w:cs=\"黑体\"/>\n" +
                    "\t\t<w:b/>\n" +
                    "\t\t<w:bCs/>\n" +
                    "\t\t<w:color w:val=\"auto\"/>\n" +
                    "\t\t<w:sz w:val=\"24\"/>\n" +
                    "\t  </w:rPr>\n" +
                    "\t  <w:t>电子邮箱：</w:t>\n" +
                    "\t</w:r>\n" +
                    "\t<w:r>\n" +
                    "\t  <w:rPr>\n" +
                    "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                    "\t\t<w:b/>\n" +
                    "\t\t<w:color w:val=\"auto\"/>\n" +
                    "\t\t<w:sz w:val=\"24\"/>\n" +
                    "\t\t<w:u w:val=\"single\"/>\n" +
                    "\t  </w:rPr>\n" +
                    "\t  <w:t xml:space=\"preserve\">      " + applyFamilyPerson.get("email") + "   </w:t>\n" +
                    "\t</w:r>\n" +
                    "\t<w:r>\n" +
                    "\t  <w:rPr>\n" +
                    "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                    "\t\t<w:b/>\n" +
                    "\t\t<w:color w:val=\"auto\"/>\n" +
                    "\t\t<w:sz w:val=\"24\"/>\n" +
                    "\t  </w:rPr>\n" +
                    "\t  <w:t xml:space=\"preserve\"> </w:t>\n" +
                    "\t</w:r>\n" +
                    "\t<w:r>\n" +
                    "\t  <w:rPr>\n" +
                    "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"黑体\" w:hAnsi=\"宋体\" w:eastAsia=\"黑体\" w:cs=\"黑体\"/>\n" +
                    "\t\t<w:b/>\n" +
                    "\t\t<w:bCs/>\n" +
                    "\t\t<w:color w:val=\"auto\"/>\n" +
                    "\t\t<w:sz w:val=\"24\"/>\n" +
                    "\t\t<w:lang w:eastAsia=\"zh-CN\"/>\n" +
                    "\t  </w:rPr>\n" +
                    "\t  <w:t>微信号：</w:t>\n" +
                    "\t</w:r>\n" +
                    "\t<w:r>\n" +
                    "\t  <w:rPr>\n" +
                    "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                    "\t\t<w:b/>\n" +
                    "\t\t<w:color w:val=\"auto\"/>\n" +
                    "\t\t<w:sz w:val=\"24\"/>\n" +
                    "\t\t<w:u w:val=\"single\"/>\n" +
                    "\t  </w:rPr>\n" +
                    "\t  <w:t xml:space=\"preserve\">     </w:t>\n" +
                    "\t</w:r>\n" +
                    "\t<w:r>\n" +
                    "\t  <w:rPr>\n" +
                    "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                    "\t\t<w:b/>\n" +
                    "\t\t<w:color w:val=\"auto\"/>\n" +
                    "\t\t<w:sz w:val=\"24\"/>\n" +
                    "\t\t<w:u w:val=\"single\"/>\n" +
                    "\t\t<w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                    "\t  </w:rPr>\n" +
                    "\t  <w:t>" + applyFamilyPerson.get("wechat") + "</w:t>\n" +
                    "\t</w:r>\n" +
                    "\t<w:r>\n" +
                    "\t  <w:rPr>\n" +
                    "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                    "\t\t<w:b/>\n" +
                    "\t\t<w:color w:val=\"auto\"/>\n" +
                    "\t\t<w:sz w:val=\"24\"/>\n" +
                    "\t\t<w:u w:val=\"single\"/>\n" +
                    "\t  </w:rPr>\n" +
                    "\t  <w:t xml:space=\"preserve\">      </w:t>\n" +
                    "\t</w:r>\n" +
                    "\t<w:r>\n" +
                    "\t  <w:rPr>\n" +
                    "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"黑体\" w:hAnsi=\"宋体\" w:eastAsia=\"黑体\" w:cs=\"黑体\"/>\n" +
                    "\t\t<w:b/>\n" +
                    "\t\t<w:bCs/>\n" +
                    "\t\t<w:color w:val=\"auto\"/>\n" +
                    "\t\t<w:sz w:val=\"24\"/>\n" +
                    "\t  </w:rPr>\n" +
                    "\t  <w:t xml:space=\"preserve\">  </w:t>\n" +
                    "\t</w:r>\n" +
                    "\t<w:r>\n" +
                    "\t  <w:rPr>\n" +
                    "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                    "\t\t<w:b/>\n" +
                    "\t\t<w:color w:val=\"auto\"/>\n" +
                    "\t\t<w:sz w:val=\"24\"/>\n" +
                    "\t  </w:rPr>\n" +
                    "\t  <w:t xml:space=\"preserve\">                 </w:t>\n" +
                    "\t</w:r>\n" +
                    "  </w:p>");
        }

        variables.put("applyFamilyPersonList", data.toString());
    }

    private void setGuaranteeMethod2C1CheckText(String guaranteeMethod2C1Check, Map<String, Object> variables) {
        String guaranteeMethod2C1CheckText;
        if (StringUtils.isBlank(guaranteeMethod2C1Check)) {
            guaranteeMethod2C1CheckText = "□信用/□担保";
        } else if (guaranteeMethod2C1Check.equals("上")) {
            guaranteeMethod2C1CheckText = "☑信用/□担保";
        } else {
            guaranteeMethod2C1CheckText = "□信用/☑担保";
        }

        variables.put("guaranteeMethod2C1Check", guaranteeMethod2C1CheckText);
    }

    private String setRepayment(String repaymentCheck) {
        String repaymentCheckText = "";
        if (StringUtils.isBlank(repaymentCheck)) {
            repaymentCheckText = "□月/□季/□半年/□年";
        } else if (repaymentCheck.equals("月")) {
            repaymentCheckText = "☑月/□季/□半年/□年";
        } else if (repaymentCheck.equals("季")) {
            repaymentCheckText = "□月/☑季/□半年/□年";
        } else if (repaymentCheck.equals("半年")) {
            repaymentCheckText = "□月/□季/☑半年/□年";
        } else if (repaymentCheck.equals("年")) {
            repaymentCheckText = "□月/□季/□半年/☑年";
        }

        return repaymentCheckText;
    }

    private String setRepaymentEnd(String repaymentEndCheck) {
        String repaymentCheckText = "";
        if (StringUtils.isBlank(repaymentEndCheck)) {
            repaymentCheckText = "□月/□季末月/□6月和12月/□年末月";
        } else if (repaymentEndCheck.equals("月")) {
            repaymentCheckText = "□月/□季末月/□6月和12月/□年末月";
        } else if (repaymentEndCheck.equals("季末月")) {
            repaymentCheckText = "□月/☑季末月/□6月和12月/□年末月";
        } else if (repaymentEndCheck.equals("6月和12月")) {
            repaymentCheckText = "□月/□季末月/☑6月和12月/□年末月";
        } else if (repaymentEndCheck.equals("年末月")) {
            repaymentCheckText = "□月/□季末月/□6月和12月/☑年末月";
        }

        return repaymentCheckText;
    }

    private void setGuaranteeMethod(String guaranteeMethod, Map<String, Object> variables) {
        if (StringUtils.isBlank(guaranteeMethod)) {
            variables.put("guaranteeMethodCheck", "□保证∕□抵押∕□质押");
            return;
        }

        String guaranteeMethodText = "";
        if (guaranteeMethod.contains("保证")) {
            guaranteeMethodText += "☑保证∕";
        } else {
            guaranteeMethodText += "□保证∕";
        }

        if (guaranteeMethod.contains("抵押")) {
            guaranteeMethodText += "☑抵押∕";
        } else {
            guaranteeMethodText += "□抵押∕";
        }

        if (guaranteeMethod.contains("质押")) {
            guaranteeMethodText += "☑质押";
        } else {
            guaranteeMethodText += "□质押";
        }

        variables.put("guaranteeMethodCheck", guaranteeMethodText);
    }

    private void setContractNoTypeCheck(String contractNoTypeCheck, Map<String, Object> variables) {
        if (StringUtils.isBlank(contractNoTypeCheck)) {
            variables.put("guaranteeMethodCheck", "□《保证担保合同》∕□《抵押担保合同》∕□《质押担保合同》");
            return;
        }

        String contractNoTypeCheckText = "";
        if (contractNoTypeCheck.contains("保证")) {
            contractNoTypeCheckText += "☑《保证担保合同》∕∕";
        } else {
            contractNoTypeCheckText += "□《保证担保合同》∕∕";
        }

        if (contractNoTypeCheck.contains("抵押")) {
            contractNoTypeCheckText += "☑《抵押担保合同》∕";
        } else {
            contractNoTypeCheckText += "□《抵押担保合同》∕";
        }

        if (contractNoTypeCheck.contains("质押")) {
            contractNoTypeCheckText += "☑《质押担保合同》";
        } else {
            contractNoTypeCheckText += "□《质押担保合同》";
        }

        variables.put("contractNoTypeCheck", contractNoTypeCheckText);
    }

    @Override
    protected void fillVariable(DocCommonModel docCommonModel) {
        Map<String, Object> variables = newRound();
        variables.put("bankBranchName", "城北支行");

        variables.put("personalLoanContractNo", "361102191586541");
        variables.put("applyPersonName", "罗永芳");
        variables.put("applyPersonIdentityNumber", "510102196901118483");
        variables.put("applyPersonCurrentHomeAddress", "广西桂林市象山区民主路12-1号");
        variables.put("applyPersonContactNumber", "15807737711");

        // 没有配偶就不需要
        setCoupleInfo(true, "唐建国", "45030519540601001X",
                "广西桂林市叠彩区铁佛路6号2栋2单元501室",
                "13707737775", variables);

        variables.put("applyMoneyRMB", "壹佰捌拾万元整");
        variables.put("applyMoney", "1800000.00");
        variables.put("moneyUsage", "用于归还借款人罗永芳在广西桂林漓江农村合作银行合同编号为361102150060192、展期协议编号为：361126180056081合同项下所欠债务。");
        variables.put("deadlineMonth", "36");

        // 1.16. contract_information合同信息表 borrowing_start_period
        variables.put("borrowingStartPeriodYears", "2019");
        variables.put("borrowingStartPeriodMonth", "7");
        variables.put("borrowingStartPeriodDay", "12");

        variables.put("borrowingEndPeriodYear", "2022");
        variables.put("borrowingEndPeriodMonth", "7");
        variables.put("borrowingEndPeriodDay", "12");

        //  1.11. loan_business_information贷款业务信息表 interest_rate 利率 1浮动利率 2固定利率
        // 1: 16.4.1  2:16.4.2
        variables.put("interestRateText", "16.4.1");

        // capplication_rate 申请利率%
        variables.put("applicationRate", "8.07500");
        variables.put("applicationRate2", "8.07500");

        // adjustment_method 利率调整方式 1立即生效 2次年一月一日起生效 3对月对日生效
        variables.put("adjustmentMethod", "1");

        // 1.1. loan_basis借口人基础信息表  guarantee_method  担保方式 逗号分隔 例如 保证,抵押,质押
        setGuaranteeMethod2C1CheckText("担保", variables);

        // 1.12. counterparty_information交易对手信息表
        List<Map<String, Object>> counterpartyInformations = new ArrayList<>();
        Map<String, Object> counterpartyInformation = new HashMap<>();
        counterpartyInformation.put("name", "罗永芳");
        counterpartyInformation.put("account", "6231330500000311451");
        counterpartyInformation.put("bankName", "广西桂林漓江农村合作银行");
        counterpartyInformation.put("money", "1800000.00");
        counterpartyInformation.put("usage", "用于归还借款人罗永芳在广西桂林漓江农村合作银行合同编号为361102150060192、展期协议编号为：361126180056081合同项下所欠债务。");
        counterpartyInformations.add(counterpartyInformation);
        // 可追加多个
        setCounterpartyInformation(counterpartyInformations, variables);


        //  1.11. loan_business_information贷款业务信息表 repayment 还款方式 1利随本清 2按月结息，到期一次性还本 3按月结息，分期还本 4按季结息，分期还本 5等额本金 6等额本息 7其他
        // 1->18.1.1  , 2->18.1.2, 3,4->18.1.3, 5->18.1.5, 6->18.1.4, 7->18.1.6

        // 18.1.1/ 18.1.4/18.1.5 则都为空
        // 18.1.2 则 setRepayment("月"), setRepaymentEnd("月")
        // 18.1.3 则 3->setRepayment("月"), setRepaymentEnd("月")， 4：>setRepayment("季"), setRepaymentEnd("季末月")
        // 18.1.6 则 otherValue
        variables.put("repaymentCatalog", "18.1.1");
        variables.put("repayment", "/");
        variables.put("repaymentCheck", setRepayment(""));
        variables.put("repaymentEndCheck", setRepaymentEnd(""));

        variables.put("repayment2", "/");
        variables.put("repaymentCheck2", setRepayment(""));
        variables.put("repaymentEndCheck2", setRepaymentEnd(""));

        // 仅有 3 才有还款计划
        // 1.13. repayment_plan还款计划信息表
        List<Map<String, Object>> repaymentPlanList = new ArrayList<>();
        Map<String, Object> tempMap = new HashMap<>();
        tempMap.put("year", "2020");
        tempMap.put("month", "7");
        tempMap.put("day", "12");
        tempMap.put("money", "伍万");
        repaymentPlanList.add(tempMap);

        tempMap = new HashMap<>();
        tempMap.put("year", "2021");
        tempMap.put("month", "7");
        tempMap.put("day", "12");
        tempMap.put("money", "壹拾万");
        repaymentPlanList.add(tempMap);

        tempMap = new HashMap<>();
        tempMap.put("year", "2022");
        tempMap.put("month", "7");
        tempMap.put("day", "12");
        tempMap.put("money", "壹佰陆拾伍万");
        repaymentPlanList.add(tempMap);

        setRepaymentPlanList(repaymentPlanList, variables);

        variables.put("otherValue", "/");

        // 1.11. loan_business_information贷款业务信息表
        variables.put("deductionAccountName", "罗永芳");
        variables.put("deductionAccount", "6231330500000311451");


        // 1.1. loan_basis借口人基础信息表 guarantee_method
        setGuaranteeMethod("抵押,保证", variables);
        setContractNoTypeCheck("抵押,保证", variables);

        // 1.16. contract_information合同信息表，如果多个则 、分割
        variables.put("contractNo", "361104190989043");


        List<Map<String, Object>> applyFamilyPersonList = new ArrayList<>();
        Map<String, Object> applyFamilyPerson = new HashMap<>();
        applyFamilyPerson.put("address", "广西桂林市象山区民主路12-1号");
        applyFamilyPerson.put("name", "罗永芳");
        applyFamilyPerson.put("mobile", "15807737711");
        applyFamilyPerson.put("email", "/");
        applyFamilyPerson.put("wechat", "/");
        applyFamilyPersonList.add(applyFamilyPerson);

        applyFamilyPerson = new HashMap<>();
        applyFamilyPerson.put("address", "广西桂林市叠彩区铁佛路6号2栋2单元501室");
        applyFamilyPerson.put("name", "唐建国");
        applyFamilyPerson.put("mobile", "13707737775");
        applyFamilyPerson.put("email", "/");
        applyFamilyPerson.put("wechat", "/");
        applyFamilyPersonList.add(applyFamilyPerson);

        setApplyFamilyPersonList(applyFamilyPersonList, variables);
    }

    @Override
    protected String modelFileName() {
        return "个人借款合同";
    }

    @Override
    protected int sort() {
        return 3_3_00;
    }

    @Override
    protected DocConstants.DocType docType() {
        return DocConstants.DocType.WORD;
    }
}
