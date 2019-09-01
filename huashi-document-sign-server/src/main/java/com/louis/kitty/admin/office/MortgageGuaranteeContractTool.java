package com.louis.kitty.admin.office;

import com.louis.kitty.admin.constants.BankConstants;
import com.louis.kitty.admin.constants.DocConstants;
import com.louis.kitty.admin.dao.RelatedPersonnelInformationMapper;
import com.louis.kitty.admin.model.DocCommonModel;
import com.louis.kitty.admin.model.Pawn;
import com.louis.kitty.admin.model.RelatedPersonnelInformation;
import com.louis.kitty.admin.sevice.RelatedPersonnelInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;

@Component
public class MortgageGuaranteeContractTool extends AbstractOfficeTool {

    @Resource
    private RelatedPersonnelInformationMapper relatedPersonnelInformationMapper;

    private void setMortgageCoownerList(List<Map<String, Object>> mortgageCoownerList, Map<String, Object> variables) {
        StringBuilder data = new StringBuilder();

        for (Map<String, Object> mortgageCoowner : mortgageCoownerList) {
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
                    "\t  </w:rPr>\n" +
                    "\t  <w:t>抵押人</w:t>\n" +
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
                    "\t  <w:t xml:space=\"preserve\">       </w:t>\n" +
                    "\t</w:r>\n" +
                    "\t<w:r>\n" +
                    "\t  <w:rPr>\n" +
                    "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\" w:cs=\"宋体\"/>\n" +
                    "\t\t<w:bCs/>\n" +
                    "\t\t<w:color w:val=\"auto\"/>\n" +
                    "\t\t<w:sz w:val=\"24\"/>\n" +
                    "\t\t<w:u w:val=\"single\"/>\n" +
                    "\t\t<w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                    "\t  </w:rPr>\n" +
                    "\t  <w:t xml:space=\"preserve\">      </w:t>\n" +
                    "\t</w:r>\n" +
                    "\t<w:r>\n" +
                    "\t  <w:rPr>\n" +
                    "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\" w:cs=\"宋体\"/>\n" +
                    "\t\t<w:bCs/>\n" +
                    "\t\t<w:color w:val=\"auto\"/>\n" +
                    "\t\t<w:sz w:val=\"24\"/>\n" +
                    "\t\t<w:u w:val=\"single\"/>\n" +
                    "\t  </w:rPr>\n" +
                    "\t  <w:t xml:space=\"preserve\">" + mortgageCoowner.get("name") + "                  </w:t>\n" +
                    "\t</w:r>\n" +
                    "  </w:p>\n" +
                    "  <w:p>\n" +
                    "\t<w:pPr>\n" +
                    "\t  <w:pStyle w:val=\"19\"/>\n" +
                    "\t  <w:spacing w:line=\"400\" w:lineRule=\"exact\"/>\n" +
                    "\t  <w:rPr>\n" +
                    "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                    "\t\t<w:bCs/>\n" +
                    "\t\t<w:color w:val=\"auto\"/>\n" +
                    "\t\t<w:kern w:val=\"2\"/>\n" +
                    "\t\t<w:sz w:val=\"24\"/>\n" +
                    "\t\t<w:szCs w:val=\"24\"/>\n" +
                    "\t\t<w:lang w:val=\"en-US\"/>\n" +
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
                    "\t  <w:t>身份证件号码：</w:t>\n" +
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
                    "\t\t<w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                    "\t  </w:rPr>\n" +
                    "\t  <w:t xml:space=\"preserve\">       </w:t>\n" +
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
                    "\t  <w:t>" + mortgageCoowner.get("idcard") + "</w:t>\n" +
                    "\t</w:r>\n" +
                    "\t<w:r>\n" +
                    "\t  <w:rPr>\n" +
                    "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\" w:cs=\"宋体\"/>\n" +
                    "\t\t<w:bCs/>\n" +
                    "\t\t<w:color w:val=\"auto\"/>\n" +
                    "\t\t<w:sz w:val=\"21\"/>\n" +
                    "\t\t<w:szCs w:val=\"21\"/>\n" +
                    "\t\t<w:u w:val=\"single\"/>\n" +
                    "\t\t<w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
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
                    "\t\t<w:lang w:eastAsia=\"zh-CN\"/>\n" +
                    "\t  </w:rPr>\n" +
                    "\t  <w:t>" + mortgageCoowner.get("address") + "</w:t>\n" +
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
                    "\t  <w:t xml:space=\"preserve\">              </w:t>\n" +
                    "\t</w:r>\n" +
                    "\t<w:r>\n" +
                    "\t  <w:rPr>\n" +
                    "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\" w:cs=\"宋体\"/>\n" +
                    "\t\t<w:color w:val=\"auto\"/>\n" +
                    "\t\t<w:sz w:val=\"24\"/>\n" +
                    "\t\t<w:szCs w:val=\"24\"/>\n" +
                    "\t  </w:rPr>\n" +
                    "\t  <w:t xml:space=\"preserve\"> </w:t>\n" +
                    "\t</w:r>\n" +
                    "\t<w:r>\n" +
                    "\t  <w:rPr>\n" +
                    "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\" w:cs=\"宋体\"/>\n" +
                    "\t\t<w:color w:val=\"auto\"/>\n" +
                    "\t\t<w:sz w:val=\"24\"/>\n" +
                    "\t\t<w:szCs w:val=\"24\"/>\n" +
                    "\t\t<w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                    "\t  </w:rPr>\n" +
                    "\t  <w:t xml:space=\"preserve\">    </w:t>\n" +
                    "\t</w:r>\n" +
                    "\t<w:r>\n" +
                    "\t  <w:rPr>\n" +
                    "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\" w:cs=\"宋体\"/>\n" +
                    "\t\t<w:color w:val=\"auto\"/>\n" +
                    "\t\t<w:sz w:val=\"24\"/>\n" +
                    "\t\t<w:szCs w:val=\"24\"/>\n" +
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
                    "\t  <w:t xml:space=\"preserve\">" + mortgageCoowner.get("postalCode") + "  </w:t>\n" +
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
                    "\t  <w:t xml:space=\"preserve\">      </w:t>\n" +
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
                    "\t  <w:t xml:space=\"preserve\">   </w:t>\n" +
                    "\t</w:r>\n" +
                    "  </w:p>\n" +
                    "  <w:p>\n" +
                    "\t<w:pPr>\n" +
                    "\t  <w:pStyle w:val=\"19\"/>\n" +
                    "\t  <w:spacing w:line=\"400\" w:lineRule=\"exact\"/>\n" +
                    "\t  <w:rPr>\n" +
                    "\t\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                    "\t\t<w:bCs/>\n" +
                    "\t\t<w:color w:val=\"auto\"/>\n" +
                    "\t\t<w:sz w:val=\"24\"/>\n" +
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
                    "\t  <w:t xml:space=\"preserve\">          " + mortgageCoowner.get("mobile") + "</w:t>\n" +
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
                    "\t\t<w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                    "\t  </w:rPr>\n" +
                    "\t  <w:t xml:space=\"preserve\">                    </w:t>\n" +
                    "\t</w:r>\n" +
                    "  </w:p>\n" +
                    "  <w:p>\n" +
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
                    "  </w:p>");
        }


        variables.put("mortgageCoownerList", data.toString());
    }

    private void setPersonInfoList(List<Map<String, Object>> personInfoList, Map<String, Object> variables) {
        StringBuilder data = new StringBuilder();

        for (Map<String, Object> personInfo : personInfoList) {
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
                    "  <w:t>" + personInfo.get("address") + "</w:t>\n" +
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
                    "  <w:t>" + personInfo.get("name") + "</w:t>\n" +
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
                    "  <w:t xml:space=\"preserve\"> " + personInfo.get("mobile") + " </w:t>\n" +
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
                    "  <w:t xml:space=\"preserve\"> " + personInfo.get("email") + " </w:t>\n" +
                    "</w:r>\n" +
                    "<w:r>\n" +
                    "  <w:rPr>\n" +
                    "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                    "\t<w:b/>\n" +
                    "\t<w:sz w:val=\"24\"/>\n" +
                    "  </w:rPr>\n" +
                    "  <w:t xml:space=\"preserve\">         </w:t>\n" +
                    "</w:r>");
        }

        variables.put("personInfoList", data.toString());
    }

    private Set<String> calculateCount(DocCommonModel docCommonModel) {
        Set<String> distinctOwners = new HashSet<>();
        for (Pawn pawn : docCommonModel.getPawnList()) {
            distinctOwners.add(pawn.getOwnerIds());
        }

        return distinctOwners;
    }

    @Override
    protected void fillVariable(DocCommonModel docCommonModel) {
        Set<String> owners = calculateCount(docCommonModel);
        for (String owner : owners) {
            Map<String, Object> variables = newRound();
            variables.put("bankBranchName", BankConstants.BANK_BRANCH_NAME);

            // 1.16. contract_information合同信息表  mortgage_guarantee_contract_no
            variables.put("mortgageGuaranteeContractNo", docCommonModel.getContractInformation().getMortgageGuaranteeContractNo());
            variables.put("applyFamilyPersonName", docCommonModel.getApplyFamilyName());

            // 1.16. contract_information合同信息表  personal_loan_contract_no
            variables.put("personalLoanContractNo", docCommonModel.getLoanBusinessInformation().getClientNumber());

            // 1.11. loan_business_information贷款业务信息表
            variables.put("applyMoneyRMB", docCommonModel.getApplyMoneyRMB());
            variables.put("applyMoney", docCommonModel.getLoanBusinessInformation().getApplicationAmount());
            variables.put("deadlineMonth", docCommonModel.getLoanBusinessInformation().getApplicationPeriod());

            Map<Integer, String> calendar = getCalendar(docCommonModel.getContractInformation().getBorrowingStartPeriod());

            Map<Integer, String> calendar1 = getCalendar(docCommonModel.getContractInformation().getBorrowingEndPeriod());

            variables.put("borrowingStartPeriodYear", calendar.get(Calendar.YEAR));
            variables.put("borrowingStartPeriodMonth", calendar.get(Calendar.MONTH));
            variables.put("borrowingStartPeriodDay", calendar.get(Calendar.DAY_OF_MONTH));
            variables.put("borrowingEndPeriodYear", calendar1.get(Calendar.YEAR));
            variables.put("borrowingEndPeriodMonth", calendar1.get(Calendar.MONTH));
            variables.put("borrowingEndPeriodDay", calendar1.get(Calendar.DAY_OF_MONTH));


            List<Map<String, Object>> mortgageCoownerList = new ArrayList<>();
            String[] ownerIds = owner.split(",");
            for (String ownerId : ownerIds) {
                RelatedPersonnelInformation relatedPersonnelInformation = relatedPersonnelInformationMapper.findById(Long.valueOf(ownerId));
                if (relatedPersonnelInformation == null) {
                    continue;
                }

                mortgageCoownerList.add(mortgageCoowner(relatedPersonnelInformation.getName(),
                        relatedPersonnelInformation.getIdentityNumber(), relatedPersonnelInformation.getContactNumber(),
                        relatedPersonnelInformation.getCurrentHomeAddress(), relatedPersonnelInformation.getEmail(),
                        ""));
            }


            // 这两个list实际为同一个
            setMortgageCoownerList(mortgageCoownerList, variables);

            setPersonInfoList(mortgageCoownerList, variables);
        }
    }

    private Map<String, Object> mortgageCoowner(String name, String idcard, String mobile, String address,
                                                String email, String postalCode) {
        Map<String, Object> tempMap = new HashMap<>();
        tempMap.put("name", name);
        tempMap.put("idcard", idcard);
        tempMap.put("mobile", mobile);
        tempMap.put("address", address);
        tempMap.put("email", email);
        tempMap.put("postalCode", postalCode);
        return tempMap;
    }

    @Override
    protected String modelFileName() {
        return "抵押担保合同";
    }

    @Override
    protected int sort() {
        return 2_2_00;
    }

    @Override
    protected DocConstants.DocType docType() {
        return DocConstants.DocType.WORD;
    }
}
