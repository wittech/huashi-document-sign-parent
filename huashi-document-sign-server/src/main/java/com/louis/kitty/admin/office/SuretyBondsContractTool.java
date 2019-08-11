package com.louis.kitty.admin.office;

import com.louis.kitty.admin.constants.BankConstants;
import com.louis.kitty.admin.constants.DocConstants;
import com.louis.kitty.admin.model.DocCommonModel;
import com.louis.kitty.admin.model.RelatedPersonnelInformation;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Map;

@Component
public class SuretyBondsContractTool extends AbstractOfficeTool {

    private void setGuaranteePersonList(RelatedPersonnelInformation relatedPersonnelInformation, Map<String, Object> variables) {
        StringBuilder data = new StringBuilder();

        data.append("<w:p>\n" +
                "\t<w:pPr>\n" +
                "\t  <w:spacing w:line=\"400\" w:lineRule=\"exact\"/>\n" +
                "\t  <w:ind w:right=\"-94\"/>\n" +
                "\t  <w:jc w:val=\"left\"/>\n" +
                "\t  <w:rPr>\n" +
                "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                "\t\t<w:bCs/>\n" +
                "\t\t<w:sz w:val=\"24\"/>\n" +
                "\t  </w:rPr>\n" +
                "\t</w:pPr>\n" +
                "\t<w:r>\n" +
                "\t  <w:rPr>\n" +
                "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋\" w:hAnsi=\"仿宋\" w:eastAsia=\"仿宋\" w:cs=\"仿宋_GB2312\"/>\n" +
                "\t\t<w:bCs/>\n" +
                "\t  </w:rPr>\n" +
                "\t  <w:t>保证人</w:t>\n" +
                "\t</w:r>\n" +
                "\t<w:r>\n" +
                "\t  <w:rPr>\n" +
                "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\" w:cs=\"宋体\"/>\n" +
                "\t\t<w:bCs/>\n" +
                "\t\t<w:sz w:val=\"24\"/>\n" +
                "\t  </w:rPr>\n" +
                "\t  <w:t>：</w:t>\n" +
                "\t</w:r>\n" +
                "\t<w:r>\n" +
                "\t  <w:rPr>\n" +
                "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\" w:cs=\"宋体\"/>\n" +
                "\t\t<w:bCs/>\n" +
                "\t\t<w:sz w:val=\"24\"/>\n" +
                "\t\t<w:u w:val=\"single\"/>\n" +
                "\t  </w:rPr>\n" +
                "\t  <w:t xml:space=\"preserve\">         </w:t>\n" +
                "\t</w:r>\n" +
                "\t<w:r>\n" +
                "\t  <w:rPr>\n" +
                "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\" w:cs=\"宋体\"/>\n" +
                "\t\t<w:bCs/>\n" +
                "\t\t<w:sz w:val=\"24\"/>\n" +
                "\t\t<w:u w:val=\"single\"/>\n" +
                "\t\t<w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                "\t  </w:rPr>\n" +
                "\t  <w:t xml:space=\"preserve\">" + relatedPersonnelInformation.getName() + "</w:t>\n" +
                "\t</w:r>\n" +
                "\t<w:r>\n" +
                "\t  <w:rPr>\n" +
                "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\" w:cs=\"宋体\"/>\n" +
                "\t\t<w:bCs/>\n" +
                "\t\t<w:sz w:val=\"24\"/>\n" +
                "\t\t<w:u w:val=\"single\"/>\n" +
                "\t  </w:rPr>\n" +
                "\t  <w:t xml:space=\"preserve\">                      </w:t>\n" +
                "\t</w:r>\n" +
                "  </w:p>\n" +
                "  <w:p>\n" +
                "\t<w:pPr>\n" +
                "\t  <w:pStyle w:val=\"19\"/>\n" +
                "\t  <w:spacing w:line=\"400\" w:lineRule=\"exact\"/>\n" +
                "\t  <w:rPr>\n" +
                "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                "\t\t<w:bCs/>\n" +
                "\t\t<w:kern w:val=\"2\"/>\n" +
                "\t\t<w:sz w:val=\"24\"/>\n" +
                "\t\t<w:szCs w:val=\"24\"/>\n" +
                "\t  </w:rPr>\n" +
                "\t</w:pPr>\n" +
                "\t<w:r>\n" +
                "\t  <w:rPr>\n" +
                "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\" w:cs=\"宋体\"/>\n" +
                "\t\t<w:bCs/>\n" +
                "\t\t<w:kern w:val=\"2\"/>\n" +
                "\t\t<w:sz w:val=\"24\"/>\n" +
                "\t\t<w:szCs w:val=\"24\"/>\n" +
                "\t  </w:rPr>\n" +
                "\t  <w:t>身份证件号码：</w:t>\n" +
                "\t</w:r>\n" +
                "\t<w:r>\n" +
                "\t  <w:rPr>\n" +
                "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\" w:cs=\"宋体\"/>\n" +
                "\t\t<w:bCs/>\n" +
                "\t\t<w:sz w:val=\"24\"/>\n" +
                "\t\t<w:szCs w:val=\"24\"/>\n" +
                "\t\t<w:u w:val=\"single\"/>\n" +
                "\t  </w:rPr>\n" +
                "\t  <w:t xml:space=\"preserve\">   </w:t>\n" +
                "\t</w:r>\n" +
                "\t<w:r>\n" +
                "\t  <w:rPr>\n" +
                "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\" w:cs=\"宋体\"/>\n" +
                "\t\t<w:bCs/>\n" +
                "\t\t<w:sz w:val=\"24\"/>\n" +
                "\t\t<w:szCs w:val=\"24\"/>\n" +
                "\t\t<w:u w:val=\"single\"/>\n" +
                "\t\t<w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                "\t  </w:rPr>\n" +
                "\t  <w:t xml:space=\"preserve\">" + relatedPersonnelInformation.getIdentityNumber() + "</w:t>\n" +
                "\t</w:r>\n" +
                "\t<w:r>\n" +
                "\t  <w:rPr>\n" +
                "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\" w:cs=\"宋体\"/>\n" +
                "\t\t<w:bCs/>\n" +
                "\t\t<w:sz w:val=\"24\"/>\n" +
                "\t\t<w:szCs w:val=\"24\"/>\n" +
                "\t\t<w:u w:val=\"single\"/>\n" +
                "\t  </w:rPr>\n" +
                "\t  <w:t xml:space=\"preserve\">          </w:t>\n" +
                "\t</w:r>\n" +
                "  </w:p>\n" +
                "  <w:p>\n" +
                "\t<w:pPr>\n" +
                "\t  <w:pStyle w:val=\"19\"/>\n" +
                "\t  <w:tabs>\n" +
                "\t\t<w:tab w:val=\"center\" w:pos=\"5940\"/>\n" +
                "\t  </w:tabs>\n" +
                "\t  <w:spacing w:line=\"400\" w:lineRule=\"exact\"/>\n" +
                "\t  <w:rPr>\n" +
                "\t\t<w:rFonts w:hint=\"default\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                "\t\t<w:bCs/>\n" +
                "\t\t<w:kern w:val=\"2\"/>\n" +
                "\t\t<w:sz w:val=\"24\"/>\n" +
                "\t\t<w:szCs w:val=\"24\"/>\n" +
                "\t\t<w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                "\t  </w:rPr>\n" +
                "\t</w:pPr>\n" +
                "\t<w:r>\n" +
                "\t  <w:rPr>\n" +
                "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\" w:cs=\"宋体\"/>\n" +
                "\t\t<w:bCs/>\n" +
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
                "\t\t<w:sz w:val=\"24\"/>\n" +
                "\t\t<w:szCs w:val=\"24\"/>\n" +
                "\t\t<w:u w:val=\"single\"/>\n" +
                "\t\t<w:lang w:eastAsia=\"zh-CN\"/>\n" +
                "\t  </w:rPr>\n" +
                "\t  <w:t>" + relatedPersonnelInformation.getCurrentHomeAddress() + "</w:t>\n" +
                "\t</w:r>\n" +
                "\t<w:r>\n" +
                "\t  <w:rPr>\n" +
                "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\" w:cs=\"宋体\"/>\n" +
                "\t\t<w:bCs/>\n" +
                "\t\t<w:sz w:val=\"24\"/>\n" +
                "\t\t<w:szCs w:val=\"24\"/>\n" +
                "\t\t<w:u w:val=\"single\"/>\n" +
                "\t  </w:rPr>\n" +
                "\t  <w:t xml:space=\"preserve\">   </w:t>\n" +
                "\t</w:r>\n" +
                "\t<w:r>\n" +
                "\t  <w:rPr>\n" +
                "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\" w:cs=\"宋体\"/>\n" +
                "\t\t<w:sz w:val=\"24\"/>\n" +
                "\t\t<w:szCs w:val=\"24\"/>\n" +
                "\t  </w:rPr>\n" +
                "\t  <w:t xml:space=\"preserve\">     </w:t>\n" +
                "\t</w:r>\n" +
                "\t<w:r>\n" +
                "\t  <w:rPr>\n" +
                "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\" w:cs=\"宋体\"/>\n" +
                "\t\t<w:bCs/>\n" +
                "\t\t<w:sz w:val=\"24\"/>\n" +
                "\t\t<w:szCs w:val=\"24\"/>\n" +
                "\t  </w:rPr>\n" +
                "\t  <w:t>邮编：</w:t>\n" +
                "\t</w:r>\n" +
                "\t<w:r>\n" +
                "\t  <w:rPr>\n" +
                "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\" w:cs=\"宋体\"/>\n" +
                "\t\t<w:bCs/>\n" +
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
                "\t\t<w:sz w:val=\"24\"/>\n" +
                "\t\t<w:szCs w:val=\"24\"/>\n" +
                "\t\t<w:u w:val=\"single\"/>\n" +
                "\t\t<w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                "\t  </w:rPr>\n" +
                "\t  <w:t xml:space=\"preserve\">  </w:t>\n" +
                "\t</w:r>\n" +
                "\t<w:r>\n" +
                "\t  <w:rPr>\n" +
                "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\" w:cs=\"宋体\"/>\n" +
                "\t\t<w:bCs/>\n" +
                "\t\t<w:sz w:val=\"24\"/>\n" +
                "\t\t<w:szCs w:val=\"24\"/>\n" +
                "\t\t<w:u w:val=\"single\"/>\n" +
                "\t  </w:rPr>\n" +
                "\t  <w:t xml:space=\"preserve\">   </w:t>\n" +
                "\t</w:r>\n" +
                "\t<w:r>\n" +
                "\t  <w:rPr>\n" +
                "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\" w:cs=\"宋体\"/>\n" +
                "\t\t<w:bCs/>\n" +
                "\t\t<w:sz w:val=\"24\"/>\n" +
                "\t\t<w:szCs w:val=\"24\"/>\n" +
                "\t\t<w:u w:val=\"single\"/>\n" +
                "\t\t<w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                "\t  </w:rPr>\n" +
                "\t  <w:t xml:space=\"preserve\">   </w:t>\n" +
                "\t</w:r>\n" +
                "  </w:p>\n" +
                "  <w:p>\n" +
                "\t<w:pPr>\n" +
                "\t  <w:pStyle w:val=\"19\"/>\n" +
                "\t  <w:spacing w:line=\"400\" w:lineRule=\"exact\"/>\n" +
                "\t  <w:rPr>\n" +
                "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\" w:cs=\"宋体\"/>\n" +
                "\t\t<w:bCs/>\n" +
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
                "\t\t<w:kern w:val=\"2\"/>\n" +
                "\t\t<w:sz w:val=\"24\"/>\n" +
                "\t\t<w:szCs w:val=\"24\"/>\n" +
                "\t\t<w:u w:val=\"single\"/>\n" +
                "\t  </w:rPr>\n" +
                "\t  <w:t xml:space=\"preserve\">           </w:t>\n" +
                "\t</w:r>\n" +
                "\t<w:r>\n" +
                "\t  <w:rPr>\n" +
                "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\" w:cs=\"宋体\"/>\n" +
                "\t\t<w:bCs/>\n" +
                "\t\t<w:kern w:val=\"2\"/>\n" +
                "\t\t<w:sz w:val=\"24\"/>\n" +
                "\t\t<w:szCs w:val=\"24\"/>\n" +
                "\t\t<w:u w:val=\"single\"/>\n" +
                "\t\t<w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                "\t  </w:rPr>\n" +
                "\t  <w:t xml:space=\"preserve\">" + relatedPersonnelInformation.getContactNumber() + "                   </w:t>\n" +
                "\t</w:r>\n" +
                "  </w:p>\n" +
                "  <w:p>\n" +
                "\t<w:pPr>\n" +
                "\t  <w:wordWrap w:val=\"0\"/>\n" +
                "\t  <w:spacing w:line=\"400\" w:lineRule=\"exact\"/>\n" +
                "\t  <w:ind w:right=\"-94\"/>\n" +
                "\t  <w:jc w:val=\"left\"/>\n" +
                "\t  <w:rPr>\n" +
                "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋\" w:hAnsi=\"仿宋\" w:eastAsia=\"仿宋\" w:cs=\"仿宋_GB2312\"/>\n" +
                "\t\t<w:bCs/>\n" +
                "\t  </w:rPr>\n" +
                "\t</w:pPr>\n" +
                "  </w:p>");

        variables.put("guaranteePersonList", data.toString());
    }

    private void setGuaranteePersonList1(RelatedPersonnelInformation relatedPersonnelInformation, Map<String, Object> variables) {
        StringBuilder data = new StringBuilder();

        data.append("<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"黑体\" w:hAnsi=\"宋体\" w:eastAsia=\"黑体\" w:cs=\"黑体\"/>\n" +
                "\t<w:b/>\n" +
                "\t<w:bCs/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t>邮寄地址</w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                "\t<w:b/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "\t<w:u w:val=\"single\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t xml:space=\"preserve\"> </w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                "\t<w:b w:val=\"0\"/>\n" +
                "\t<w:bCs/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "\t<w:u w:val=\"single\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t>" + relatedPersonnelInformation.getCurrentHomeAddress() + "</w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                "\t<w:b/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t>，</w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"黑体\" w:hAnsi=\"宋体\" w:eastAsia=\"黑体\" w:cs=\"黑体\"/>\n" +
                "\t<w:b/>\n" +
                "\t<w:bCs/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t>指定收件人：</w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                "\t<w:b/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "\t<w:u w:val=\"single\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t xml:space=\"preserve\"> </w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\" w:cs=\"宋体\"/>\n" +
                "\t<w:bCs/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "\t<w:u w:val=\"single\"/>\n" +
                "\t<w:lang w:eastAsia=\"zh-CN\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t>" + relatedPersonnelInformation.getName() + "</w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                "\t<w:b/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "\t<w:u w:val=\"single\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t xml:space=\"preserve\"> </w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"黑体\" w:hAnsi=\"宋体\" w:eastAsia=\"黑体\" w:cs=\"黑体\"/>\n" +
                "\t<w:b/>\n" +
                "\t<w:bCs/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t>电话号码：</w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                "\t<w:b/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "\t<w:u w:val=\"single\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t xml:space=\"preserve\"> " + relatedPersonnelInformation.getContactNumber() + " </w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                "\t<w:b/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "\t<w:u w:val=\"single\"/>\n" +
                "\t<w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t xml:space=\"preserve\"> </w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                "\t<w:b/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t xml:space=\"preserve\"> </w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"黑体\" w:hAnsi=\"宋体\" w:eastAsia=\"黑体\" w:cs=\"黑体\"/>\n" +
                "\t<w:b/>\n" +
                "\t<w:bCs/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t>电子邮箱：</w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                "\t<w:b/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "\t<w:u w:val=\"single\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t xml:space=\"preserve\"> " + relatedPersonnelInformation.getEmail() + " </w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                "\t<w:b/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t xml:space=\"preserve\">         </w:t>\n" +
                "</w:r>");

        variables.put("guaranteePersonList1", data.toString());
    }

    @Override
    protected void fillVariable(DocCommonModel docCommonModel) {
        if (CollectionUtils.isEmpty(docCommonModel.getGuarantorList())) {
            return;
        }
        for (RelatedPersonnelInformation relatedPersonnelInformation : docCommonModel.getGuarantorList()) {
            Map<String, Object> variables = newRound();
            variables.put("bankBranchName", BankConstants.BANK_BRANCH_NAME);
            variables.put("guaranteeGuaranteeContractNo", docCommonModel.getContractInformation().getGuaranteeGuaranteeContractNo());
            variables.put("applyPersonName", docCommonModel.getBorrower().getName());
            variables.put("personalLoanContractNo", docCommonModel.getContractInformation().getPersonalLoanContractNo());
            variables.put("applyMoneyRMB", docCommonModel.getApplyMoneyRMB());
            variables.put("applyMoney", docCommonModel.getLoanBusinessInformation().getApplicationAmount());
            variables.put("deadlineMonth", docCommonModel.getLoanBusinessInformation().getApplicationPeriod());

            // 转换年月日
            Calendar ca = Calendar.getInstance();
            ca.setTime(docCommonModel.getContractInformation().getBorrowingStartPeriod());

            Calendar ca1 = Calendar.getInstance();
            ca.setTime(docCommonModel.getContractInformation().getBorrowingEndPeriod());

            variables.put("borrowingStartPeriodYear", ca.get(Calendar.YEAR));
            variables.put("borrowingStartPeriodMonth", ca.get(Calendar.MONTH));
            variables.put("borrowingStartPeriodDay", ca.get(Calendar.DAY_OF_MONTH));
            variables.put("borrowingEndPeriodYear", ca1.get(Calendar.YEAR));
            variables.put("borrowingEndPeriodMonth", ca1.get(Calendar.MONTH));
            variables.put("borrowingEndPeriodDay", ca1.get(Calendar.DAY_OF_MONTH));

            // 这两个list实际为同一个
            setGuaranteePersonList(relatedPersonnelInformation, variables);

            setGuaranteePersonList1(relatedPersonnelInformation, variables);
        }

    }

    @Override
    protected String modelFileName() {
        return "保证担保合同";
    }

    @Override
    protected int sort() {
        return 3_2_00;
    }

    @Override
    protected DocConstants.DocType docType() {
        return DocConstants.DocType.WORD;
    }
}
