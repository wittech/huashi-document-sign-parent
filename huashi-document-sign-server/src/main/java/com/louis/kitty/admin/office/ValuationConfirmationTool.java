package com.louis.kitty.admin.office;

import com.louis.kitty.admin.constants.DocConstants;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ValuationConfirmationTool extends AbstractOfficeTool {

    /**
     * @param collateralType    抵押物类型（房产/土地）
     * @param evaluationEnterprise   评估机构名称
     * @param goodsOwner 抵（质）押人
     * @param collateralAddress 抵押物地址
     * @param outsideMoneyRMB      外部评估价值（大写）
     * @param outsieMoney      评估价值
     * @param innerMoneyRMB      外部评估价值（大写）
     * @param innerConfirmDate    内部确认日期
     * @param variables         变量信息
     */
    private void setNoLeaseInfo(String collateralType, String evaluationEnterprise, String goodsOwner, String collateralAddress,
                                String outsideMoneyRMB, String outsieMoney, String innerMoneyRMB, String innerConfirmDate,
                                Map<String, Object> variables) {
        StringBuilder data = new StringBuilder();
        data.append("<w:tr>\n" +
                "  <w:tblPrEx>\n" +
                "\t<w:tblBorders>\n" +
                "\t  <w:top w:val=\"single\" w:color=\"auto\" w:sz=\"4\" w:space=\"0\"/>\n" +
                "\t  <w:left w:val=\"single\" w:color=\"auto\" w:sz=\"4\" w:space=\"0\"/>\n" +
                "\t  <w:bottom w:val=\"single\" w:color=\"auto\" w:sz=\"4\" w:space=\"0\"/>\n" +
                "\t  <w:right w:val=\"single\" w:color=\"auto\" w:sz=\"4\" w:space=\"0\"/>\n" +
                "\t  <w:insideH w:val=\"single\" w:color=\"auto\" w:sz=\"4\" w:space=\"0\"/>\n" +
                "\t  <w:insideV w:val=\"single\" w:color=\"auto\" w:sz=\"4\" w:space=\"0\"/>\n" +
                "\t</w:tblBorders>\n" +
                "\t<w:tblLayout w:type=\"fixed\"/>\n" +
                "\t<w:tblCellMar>\n" +
                "\t  <w:top w:w=\"0\" w:type=\"dxa\"/>\n" +
                "\t  <w:left w:w=\"108\" w:type=\"dxa\"/>\n" +
                "\t  <w:bottom w:w=\"0\" w:type=\"dxa\"/>\n" +
                "\t  <w:right w:w=\"108\" w:type=\"dxa\"/>\n" +
                "\t</w:tblCellMar>\n" +
                "  </w:tblPrEx>\n" +
                "  <w:trPr>\n" +
                "\t<w:trHeight w:val=\"465\" w:hRule=\"atLeast\"/>\n" +
                "  </w:trPr>\n" +
                "  <w:tc>\n" +
                "\t<w:tcPr>\n" +
                "\t  <w:tcW w:w=\"2467\" w:type=\"dxa\"/>\n" +
                "\t  <w:noWrap w:val=\"0\"/>\n" +
                "\t  <w:vAlign w:val=\"center\"/>\n" +
                "\t</w:tcPr>\n" +
                "\t<w:p>\n" +
                "\t  <w:pPr>\n" +
                "\t\t<w:rPr>\n" +
                "\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                "\t\t  <w:b/>\n" +
                "\t\t  <w:sz w:val=\"24\"/>\n" +
                "\t\t</w:rPr>\n" +
                "\t  </w:pPr>\n" +
                "\t  <w:r>\n" +
                "\t\t<w:rPr>\n" +
                "\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                "\t\t  <w:b/>\n" +
                "\t\t  <w:sz w:val=\"24\"/>\n" +
                "\t\t</w:rPr>\n" +
                "\t\t<w:t>押品名称</w:t>\n" +
                "\t  </w:r>\n" +
                "\t</w:p>\n" +
                "  </w:tc>\n" +
                "  <w:tc>\n" +
                "\t<w:tcPr>\n" +
                "\t  <w:tcW w:w=\"2578\" w:type=\"dxa\"/>\n" +
                "\t  <w:noWrap w:val=\"0\"/>\n" +
                "\t  <w:vAlign w:val=\"center\"/>\n" +
                "\t</w:tcPr>\n" +
                "\t<w:p>\n" +
                "\t  <w:pPr>\n" +
                "\t\t<w:rPr>\n" +
                "\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                "\t\t  <w:sz w:val=\"24\"/>\n" +
                "\t\t  <w:lang w:eastAsia=\"zh-CN\"/>\n" +
                "\t\t</w:rPr>\n" +
                "\t  </w:pPr>\n" +
                "\t  <w:r>\n" +
                "\t\t<w:rPr>\n" +
                "\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                "\t\t  <w:sz w:val=\"24\"/>\n" +
                "\t\t  <w:lang w:eastAsia=\"zh-CN\"/>\n" +
                "\t\t</w:rPr>\n" +
                "\t\t<w:t>"+collateralType+"</w:t>\n" +
                "\t  </w:r>\n" +
                "\t</w:p>\n" +
                "  </w:tc>\n" +
                "  <w:tc>\n" +
                "\t<w:tcPr>\n" +
                "\t  <w:tcW w:w=\"1435\" w:type=\"dxa\"/>\n" +
                "\t  <w:noWrap w:val=\"0\"/>\n" +
                "\t  <w:vAlign w:val=\"center\"/>\n" +
                "\t</w:tcPr>\n" +
                "\t<w:p>\n" +
                "\t  <w:pPr>\n" +
                "\t\t<w:rPr>\n" +
                "\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                "\t\t  <w:b/>\n" +
                "\t\t  <w:sz w:val=\"24\"/>\n" +
                "\t\t</w:rPr>\n" +
                "\t  </w:pPr>\n" +
                "\t  <w:r>\n" +
                "\t\t<w:rPr>\n" +
                "\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                "\t\t  <w:b/>\n" +
                "\t\t  <w:sz w:val=\"24\"/>\n" +
                "\t\t</w:rPr>\n" +
                "\t\t<w:t>评估机构名称</w:t>\n" +
                "\t  </w:r>\n" +
                "\t</w:p>\n" +
                "  </w:tc>\n" +
                "  <w:tc>\n" +
                "\t<w:tcPr>\n" +
                "\t  <w:tcW w:w=\"3419\" w:type=\"dxa\"/>\n" +
                "\t  <w:noWrap w:val=\"0\"/>\n" +
                "\t  <w:vAlign w:val=\"center\"/>\n" +
                "\t</w:tcPr>\n" +
                "\t<w:p>\n" +
                "\t  <w:pPr>\n" +
                "\t\t<w:rPr>\n" +
                "\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t\t  <w:szCs w:val=\"21\"/>\n" +
                "\t\t  <w:lang w:eastAsia=\"zh-CN\"/>\n" +
                "\t\t</w:rPr>\n" +
                "\t  </w:pPr>\n" +
                "\t  <w:r>\n" +
                "\t\t<w:rPr>\n" +
                "\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\"/>\n" +
                "\t\t  <w:szCs w:val=\"21\"/>\n" +
                "\t\t  <w:lang w:eastAsia=\"zh-CN\"/>\n" +
                "\t\t</w:rPr>\n" +
                "\t\t<w:t>"+evaluationEnterprise+"</w:t>\n" +
                "\t  </w:r>\n" +
                "\t</w:p>\n" +
                "  </w:tc>\n" +
                "</w:tr>\n" +
                "<w:tr>\n" +
                "  <w:tblPrEx>\n" +
                "\t<w:tblBorders>\n" +
                "\t  <w:top w:val=\"single\" w:color=\"auto\" w:sz=\"4\" w:space=\"0\"/>\n" +
                "\t  <w:left w:val=\"single\" w:color=\"auto\" w:sz=\"4\" w:space=\"0\"/>\n" +
                "\t  <w:bottom w:val=\"single\" w:color=\"auto\" w:sz=\"4\" w:space=\"0\"/>\n" +
                "\t  <w:right w:val=\"single\" w:color=\"auto\" w:sz=\"4\" w:space=\"0\"/>\n" +
                "\t  <w:insideH w:val=\"single\" w:color=\"auto\" w:sz=\"4\" w:space=\"0\"/>\n" +
                "\t  <w:insideV w:val=\"single\" w:color=\"auto\" w:sz=\"4\" w:space=\"0\"/>\n" +
                "\t</w:tblBorders>\n" +
                "\t<w:tblLayout w:type=\"fixed\"/>\n" +
                "\t<w:tblCellMar>\n" +
                "\t  <w:top w:w=\"0\" w:type=\"dxa\"/>\n" +
                "\t  <w:left w:w=\"108\" w:type=\"dxa\"/>\n" +
                "\t  <w:bottom w:w=\"0\" w:type=\"dxa\"/>\n" +
                "\t  <w:right w:w=\"108\" w:type=\"dxa\"/>\n" +
                "\t</w:tblCellMar>\n" +
                "  </w:tblPrEx>\n" +
                "  <w:trPr>\n" +
                "\t<w:trHeight w:val=\"458\" w:hRule=\"atLeast\"/>\n" +
                "  </w:trPr>\n" +
                "  <w:tc>\n" +
                "\t<w:tcPr>\n" +
                "\t  <w:tcW w:w=\"2467\" w:type=\"dxa\"/>\n" +
                "\t  <w:noWrap w:val=\"0\"/>\n" +
                "\t  <w:vAlign w:val=\"center\"/>\n" +
                "\t</w:tcPr>\n" +
                "\t<w:p>\n" +
                "\t  <w:pPr>\n" +
                "\t\t<w:rPr>\n" +
                "\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                "\t\t  <w:b/>\n" +
                "\t\t  <w:sz w:val=\"24\"/>\n" +
                "\t\t</w:rPr>\n" +
                "\t  </w:pPr>\n" +
                "\t  <w:r>\n" +
                "\t\t<w:rPr>\n" +
                "\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                "\t\t  <w:b/>\n" +
                "\t\t  <w:sz w:val=\"24\"/>\n" +
                "\t\t</w:rPr>\n" +
                "\t\t<w:t>抵（质）押人</w:t>\n" +
                "\t  </w:r>\n" +
                "\t</w:p>\n" +
                "  </w:tc>\n" +
                "  <w:tc>\n" +
                "\t<w:tcPr>\n" +
                "\t  <w:tcW w:w=\"2578\" w:type=\"dxa\"/>\n" +
                "\t  <w:noWrap w:val=\"0\"/>\n" +
                "\t  <w:vAlign w:val=\"center\"/>\n" +
                "\t</w:tcPr>\n" +
                "\t<w:p>\n" +
                "\t  <w:pPr>\n" +
                "\t\t<w:rPr>\n" +
                "\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                "\t\t  <w:sz w:val=\"24\"/>\n" +
                "\t\t  <w:lang w:eastAsia=\"zh-CN\"/>\n" +
                "\t\t</w:rPr>\n" +
                "\t  </w:pPr>\n" +
                "\t  <w:r>\n" +
                "\t\t<w:rPr>\n" +
                "\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                "\t\t  <w:sz w:val=\"24\"/>\n" +
                "\t\t</w:rPr>\n" +
                "\t\t<w:t>"+goodsOwner+"</w:t>\n" +
                "\t  </w:r>\n" +
                "\t</w:p>\n" +
                "  </w:tc>\n" +
                "  <w:tc>\n" +
                "\t<w:tcPr>\n" +
                "\t  <w:tcW w:w=\"1435\" w:type=\"dxa\"/>\n" +
                "\t  <w:noWrap w:val=\"0\"/>\n" +
                "\t  <w:vAlign w:val=\"center\"/>\n" +
                "\t</w:tcPr>\n" +
                "\t<w:p>\n" +
                "\t  <w:pPr>\n" +
                "\t\t<w:rPr>\n" +
                "\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                "\t\t  <w:b/>\n" +
                "\t\t  <w:sz w:val=\"24\"/>\n" +
                "\t\t</w:rPr>\n" +
                "\t  </w:pPr>\n" +
                "\t  <w:r>\n" +
                "\t\t<w:rPr>\n" +
                "\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                "\t\t  <w:b/>\n" +
                "\t\t  <w:sz w:val=\"24\"/>\n" +
                "\t\t</w:rPr>\n" +
                "\t\t<w:t>地址</w:t>\n" +
                "\t  </w:r>\n" +
                "\t</w:p>\n" +
                "  </w:tc>\n" +
                "  <w:tc>\n" +
                "\t<w:tcPr>\n" +
                "\t  <w:tcW w:w=\"3419\" w:type=\"dxa\"/>\n" +
                "\t  <w:noWrap w:val=\"0\"/>\n" +
                "\t  <w:vAlign w:val=\"center\"/>\n" +
                "\t</w:tcPr>\n" +
                "\t<w:p>\n" +
                "\t  <w:pPr>\n" +
                "\t\t<w:rPr>\n" +
                "\t\t  <w:rFonts w:hint=\"eastAsia\"/>\n" +
                "\t\t  <w:szCs w:val=\"21\"/>\n" +
                "\t\t</w:rPr>\n" +
                "\t  </w:pPr>\n" +
                "\t  <w:r>\n" +
                "\t\t<w:rPr>\n" +
                "\t\t  <w:rFonts w:hint=\"eastAsia\"/>\n" +
                "\t\t  <w:szCs w:val=\"21\"/>\n" +
                "\t\t</w:rPr>\n" +
                "\t\t<w:t>"+collateralAddress+"</w:t>\n" +
                "\t  </w:r>\n" +
                "\t</w:p>\n" +
                "  </w:tc>\n" +
                "</w:tr>\n" +
                "<w:tr>\n" +
                "  <w:tblPrEx>\n" +
                "\t<w:tblBorders>\n" +
                "\t  <w:top w:val=\"single\" w:color=\"auto\" w:sz=\"4\" w:space=\"0\"/>\n" +
                "\t  <w:left w:val=\"single\" w:color=\"auto\" w:sz=\"4\" w:space=\"0\"/>\n" +
                "\t  <w:bottom w:val=\"single\" w:color=\"auto\" w:sz=\"4\" w:space=\"0\"/>\n" +
                "\t  <w:right w:val=\"single\" w:color=\"auto\" w:sz=\"4\" w:space=\"0\"/>\n" +
                "\t  <w:insideH w:val=\"single\" w:color=\"auto\" w:sz=\"4\" w:space=\"0\"/>\n" +
                "\t  <w:insideV w:val=\"single\" w:color=\"auto\" w:sz=\"4\" w:space=\"0\"/>\n" +
                "\t</w:tblBorders>\n" +
                "\t<w:tblLayout w:type=\"fixed\"/>\n" +
                "\t<w:tblCellMar>\n" +
                "\t  <w:top w:w=\"0\" w:type=\"dxa\"/>\n" +
                "\t  <w:left w:w=\"108\" w:type=\"dxa\"/>\n" +
                "\t  <w:bottom w:w=\"0\" w:type=\"dxa\"/>\n" +
                "\t  <w:right w:w=\"108\" w:type=\"dxa\"/>\n" +
                "\t</w:tblCellMar>\n" +
                "  </w:tblPrEx>\n" +
                "  <w:trPr>\n" +
                "\t<w:trHeight w:val=\"597\" w:hRule=\"atLeast\"/>\n" +
                "  </w:trPr>\n" +
                "  <w:tc>\n" +
                "\t<w:tcPr>\n" +
                "\t  <w:tcW w:w=\"5045\" w:type=\"dxa\"/>\n" +
                "\t  <w:gridSpan w:val=\"2\"/>\n" +
                "\t  <w:noWrap w:val=\"0\"/>\n" +
                "\t  <w:vAlign w:val=\"center\"/>\n" +
                "\t</w:tcPr>\n" +
                "\t<w:p>\n" +
                "\t  <w:pPr>\n" +
                "\t\t<w:rPr>\n" +
                "\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                "\t\t  <w:b/>\n" +
                "\t\t  <w:sz w:val=\"24\"/>\n" +
                "\t\t  <w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                "\t\t</w:rPr>\n" +
                "\t  </w:pPr>\n" +
                "\t  <w:r>\n" +
                "\t\t<w:rPr>\n" +
                "\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                "\t\t  <w:b/>\n" +
                "\t\t  <w:sz w:val=\"24\"/>\n" +
                "\t\t</w:rPr>\n" +
                "\t\t<w:t>外部评估价值（大写）</w:t>\n" +
                "\t  </w:r>\n" +
                "\t  <w:r>\n" +
                "\t\t<w:rPr>\n" +
                "\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                "\t\t  <w:b/>\n" +
                "\t\t  <w:sz w:val=\"24\"/>\n" +
                "\t\t  <w:u w:val=\"single\"/>\n" +
                "\t\t  <w:lang w:eastAsia=\"zh-CN\"/>\n" +
                "\t\t</w:rPr>\n" +
                "\t\t<w:t>"+outsideMoneyRMB+"</w:t>\n" +
                "\t  </w:r>\n" +
                "\t</w:p>\n" +
                "  </w:tc>\n" +
                "  <w:tc>\n" +
                "\t<w:tcPr>\n" +
                "\t  <w:tcW w:w=\"1435\" w:type=\"dxa\"/>\n" +
                "\t  <w:noWrap w:val=\"0\"/>\n" +
                "\t  <w:vAlign w:val=\"center\"/>\n" +
                "\t</w:tcPr>\n" +
                "\t<w:p>\n" +
                "\t  <w:pPr>\n" +
                "\t\t<w:rPr>\n" +
                "\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                "\t\t  <w:b/>\n" +
                "\t\t  <w:sz w:val=\"24\"/>\n" +
                "\t\t</w:rPr>\n" +
                "\t  </w:pPr>\n" +
                "\t  <w:r>\n" +
                "\t\t<w:rPr>\n" +
                "\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                "\t\t  <w:b/>\n" +
                "\t\t  <w:sz w:val=\"24\"/>\n" +
                "\t\t</w:rPr>\n" +
                "\t\t<w:t>评估价值</w:t>\n" +
                "\t  </w:r>\n" +
                "\t</w:p>\n" +
                "  </w:tc>\n" +
                "  <w:tc>\n" +
                "\t<w:tcPr>\n" +
                "\t  <w:tcW w:w=\"3419\" w:type=\"dxa\"/>\n" +
                "\t  <w:noWrap w:val=\"0\"/>\n" +
                "\t  <w:vAlign w:val=\"center\"/>\n" +
                "\t</w:tcPr>\n" +
                "\t<w:p>\n" +
                "\t  <w:pPr>\n" +
                "\t\t<w:rPr>\n" +
                "\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                "\t\t  <w:b/>\n" +
                "\t\t  <w:sz w:val=\"24\"/>\n" +
                "\t\t  <w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                "\t\t</w:rPr>\n" +
                "\t  </w:pPr>\n" +
                "\t  <w:r>\n" +
                "\t\t<w:rPr>\n" +
                "\t\t  <w:rFonts w:hint=\"default\" w:ascii=\"Arial\" w:hAnsi=\"Arial\" w:eastAsia=\"仿宋_GB2312\" w:cs=\"Arial\"/>\n" +
                "\t\t  <w:b/>\n" +
                "\t\t  <w:sz w:val=\"24\"/>\n" +
                "\t\t</w:rPr>\n" +
                "\t\t<w:t>¥"+outsieMoney+"</w:t>\n" +
                "\t  </w:r>\n" +
                "\t</w:p>\n" +
                "  </w:tc>\n" +
                "</w:tr>\n" +
                "<w:tr>\n" +
                "  <w:tblPrEx>\n" +
                "\t<w:tblBorders>\n" +
                "\t  <w:top w:val=\"single\" w:color=\"auto\" w:sz=\"4\" w:space=\"0\"/>\n" +
                "\t  <w:left w:val=\"single\" w:color=\"auto\" w:sz=\"4\" w:space=\"0\"/>\n" +
                "\t  <w:bottom w:val=\"single\" w:color=\"auto\" w:sz=\"4\" w:space=\"0\"/>\n" +
                "\t  <w:right w:val=\"single\" w:color=\"auto\" w:sz=\"4\" w:space=\"0\"/>\n" +
                "\t  <w:insideH w:val=\"single\" w:color=\"auto\" w:sz=\"4\" w:space=\"0\"/>\n" +
                "\t  <w:insideV w:val=\"single\" w:color=\"auto\" w:sz=\"4\" w:space=\"0\"/>\n" +
                "\t</w:tblBorders>\n" +
                "\t<w:tblLayout w:type=\"fixed\"/>\n" +
                "\t<w:tblCellMar>\n" +
                "\t  <w:top w:w=\"0\" w:type=\"dxa\"/>\n" +
                "\t  <w:left w:w=\"108\" w:type=\"dxa\"/>\n" +
                "\t  <w:bottom w:w=\"0\" w:type=\"dxa\"/>\n" +
                "\t  <w:right w:w=\"108\" w:type=\"dxa\"/>\n" +
                "\t</w:tblCellMar>\n" +
                "  </w:tblPrEx>\n" +
                "  <w:trPr>\n" +
                "\t<w:trHeight w:val=\"619\" w:hRule=\"atLeast\"/>\n" +
                "  </w:trPr>\n" +
                "  <w:tc>\n" +
                "\t<w:tcPr>\n" +
                "\t  <w:tcW w:w=\"5045\" w:type=\"dxa\"/>\n" +
                "\t  <w:gridSpan w:val=\"2\"/>\n" +
                "\t  <w:noWrap w:val=\"0\"/>\n" +
                "\t  <w:vAlign w:val=\"center\"/>\n" +
                "\t</w:tcPr>\n" +
                "\t<w:p>\n" +
                "\t  <w:pPr>\n" +
                "\t\t<w:rPr>\n" +
                "\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                "\t\t  <w:b/>\n" +
                "\t\t  <w:sz w:val=\"24\"/>\n" +
                "\t\t</w:rPr>\n" +
                "\t  </w:pPr>\n" +
                "\t  <w:r>\n" +
                "\t\t<w:rPr>\n" +
                "\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                "\t\t  <w:b/>\n" +
                "\t\t  <w:sz w:val=\"24\"/>\n" +
                "\t\t</w:rPr>\n" +
                "\t\t<w:t>内部确认价值（大写）</w:t>\n" +
                "\t  </w:r>\n" +
                "\t  <w:r>\n" +
                "\t\t<w:rPr>\n" +
                "\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                "\t\t  <w:b/>\n" +
                "\t\t  <w:sz w:val=\"24\"/>\n" +
                "\t\t  <w:u w:val=\"single\"/>\n" +
                "\t\t  <w:lang w:eastAsia=\"zh-CN\"/>\n" +
                "\t\t</w:rPr>\n" +
                "\t\t<w:t>"+innerMoneyRMB+"</w:t>\n" +
                "\t  </w:r>\n" +
                "\t</w:p>\n" +
                "  </w:tc>\n" +
                "  <w:tc>\n" +
                "\t<w:tcPr>\n" +
                "\t  <w:tcW w:w=\"1435\" w:type=\"dxa\"/>\n" +
                "\t  <w:noWrap w:val=\"0\"/>\n" +
                "\t  <w:vAlign w:val=\"center\"/>\n" +
                "\t</w:tcPr>\n" +
                "\t<w:p>\n" +
                "\t  <w:pPr>\n" +
                "\t\t<w:rPr>\n" +
                "\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                "\t\t  <w:b/>\n" +
                "\t\t  <w:sz w:val=\"24\"/>\n" +
                "\t\t</w:rPr>\n" +
                "\t  </w:pPr>\n" +
                "\t  <w:r>\n" +
                "\t\t<w:rPr>\n" +
                "\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                "\t\t  <w:b/>\n" +
                "\t\t  <w:sz w:val=\"24\"/>\n" +
                "\t\t</w:rPr>\n" +
                "\t\t<w:t>内部确认日期</w:t>\n" +
                "\t  </w:r>\n" +
                "\t</w:p>\n" +
                "  </w:tc>\n" +
                "  <w:tc>\n" +
                "\t<w:tcPr>\n" +
                "\t  <w:tcW w:w=\"3419\" w:type=\"dxa\"/>\n" +
                "\t  <w:noWrap w:val=\"0\"/>\n" +
                "\t  <w:vAlign w:val=\"center\"/>\n" +
                "\t</w:tcPr>\n" +
                "\t<w:p>\n" +
                "\t  <w:pPr>\n" +
                "\t\t<w:jc w:val=\"both\"/>\n" +
                "\t\t<w:rPr>\n" +
                "\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                "\t\t  <w:b/>\n" +
                "\t\t  <w:sz w:val=\"24\"/>\n" +
                "\t\t</w:rPr>\n" +
                "\t  </w:pPr>\n" +
                "\t  <w:bookmarkStart w:id=\"0\" w:name=\"_GoBack\"/>\n" +
                "\t  <w:bookmarkEnd w:id=\"0\"/>\n" +
                "\t  <w:r>\n" +
                "\t\t<w:rPr>\n" +
                "\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:eastAsia=\"仿宋_GB2312\"/>\n" +
                "\t\t  <w:b/>\n" +
                "\t\t  <w:sz w:val=\"24\"/>\n" +
                "\t\t  <w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                "\t\t</w:rPr>\n" +
                "\t\t<w:t>"+innerConfirmDate+"</w:t>\n" +
                "\t  </w:r>\n" +
                "\t</w:p>\n" +
                "  </w:tc>\n" +
                "</w:tr>");

        variables.put("noLeaseInfo", data.toString());
    }

    @Override
    protected void fillVariable(Long basisLoanId) {
        Map<String, Object> variables = newRound();
        variables.put("bankBranchName", "城北支行");

        setNoLeaseInfo("房产", "广西国泰房地产土地评估有限公司", "罗永芳、唐建国",
                "秀峰区中山中路38号智能办公大厦五层503、504号办公用房 ", "叁佰零玖万叁仟叁佰元整", "3093300.00",
                "叁佰零玖万叁仟叁佰元整", "2019 年 6 月 14 日", variables);


        // 多份，只要有相关信息就生成几份
//        Map<String, Object> variables1 = newRound();
//        variables1.put("applyFamilyPersonName", "罗永芳、唐建国");
//        variables1.put("applyMoney", "2000000.00");
//        variables1.put("applyMoneyRMB", RmbUtil.number2CNMontrayUnit(new BigDecimal(variables.get("applyMoney").toString())));
//
//
//        setNoLeaseInfo("罗永芳", "510102196901118483", "唐建国",
//                "45030519540601001X ", "秀峰区中山中路38号智能办公大厦五层503号办公用房", "房产",
//                "房产证号为：桂林市房权证秀峰区字第30417489号、土地证号为：桂国用（2014）第301694号", variables1);
    }

    @Override
    protected String modelFileName() {
        return "评估价值确认书";
    }

    @Override
    protected int sort() {
        return 1_8_0;
    }

    @Override
    protected DocConstants.DocType docType() {
        return DocConstants.DocType.WORD;
    }
}