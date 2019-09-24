package com.louis.kitty.admin.office;

import com.louis.kitty.admin.constants.BankConstants;
import com.louis.kitty.admin.constants.DocConstants;
import com.louis.kitty.admin.dao.RelatedPersonnelInformationMapper;
import com.louis.kitty.admin.model.DocCommonModel;
import com.louis.kitty.admin.model.Pawn;
import com.louis.kitty.admin.model.RelatedPersonnelInformation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class MortgageListTool extends AbstractOfficeTool {

    @Resource
    private RelatedPersonnelInformationMapper relatedPersonnelInformationMapper;

    private void setPawnList(List<Map<String, Object>> pawnList, Map<String, Object> variables) {
        StringBuilder data = new StringBuilder();
        data.append("<w:tr>\n" +
                "  <w:tblPrEx>\n" +
                "\t<w:tblLayout w:type=\"fixed\"/>\n" +
                "\t<w:tblCellMar>\n" +
                "\t  <w:top w:w=\"0\" w:type=\"dxa\"/>\n" +
                "\t  <w:left w:w=\"0\" w:type=\"dxa\"/>\n" +
                "\t  <w:bottom w:w=\"0\" w:type=\"dxa\"/>\n" +
                "\t  <w:right w:w=\"0\" w:type=\"dxa\"/>\n" +
                "\t</w:tblCellMar>\n" +
                "  </w:tblPrEx>\n" +
                "  <w:trPr>\n" +
                "\t<w:trHeight w:val=\"770\" w:hRule=\"atLeast\"/>\n" +
                "\t<w:jc w:val=\"center\"/>\n" +
                "  </w:trPr>\n" +
                "  <w:tc>\n" +
                "\t<w:tcPr>\n" +
                "\t  <w:tcW w:w=\"1330\" w:type=\"dxa\"/>\n" +
                "\t  <w:tcBorders>\n" +
                "\t\t<w:top w:val=\"single\" w:color=\"000000\" w:sz=\"8\" w:space=\"0\"/>\n" +
                "\t\t<w:left w:val=\"single\" w:color=\"000000\" w:sz=\"8\" w:space=\"0\"/>\n" +
                "\t\t<w:bottom w:val=\"single\" w:color=\"000000\" w:sz=\"8\" w:space=\"0\"/>\n" +
                "\t\t<w:right w:val=\"single\" w:color=\"000000\" w:sz=\"8\" w:space=\"0\"/>\n" +
                "\t  </w:tcBorders>\n" +
                "\t  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"FFFFFF\"/>\n" +
                "\t  <w:vAlign w:val=\"center\"/>\n" +
                "\t</w:tcPr>\n" +
                "\t<w:p>\n" +
                "\t  <w:pPr>\n" +
                "\t\t<w:jc w:val=\"center\"/>\n" +
                "\t\t<w:rPr>\n" +
                "\t\t  <w:rFonts w:ascii=\"宋体\" w:hAnsi=\"Times New Roman\" w:eastAsia=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t\t  <w:sz w:val=\"22\"/>\n" +
                "\t\t  <w:szCs w:val=\"22\"/>\n" +
                "\t\t</w:rPr>\n" +
                "\t  </w:pPr>\n" +
                "\t  <w:r>\n" +
                "\t\t<w:rPr>\n" +
                "\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"Times New Roman\" w:eastAsia=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t\t  <w:sz w:val=\"22\"/>\n" +
                "\t\t  <w:szCs w:val=\"22\"/>\n" +
                "\t\t  <w:lang w:eastAsia=\"zh-CN\"/>\n" +
                "\t\t</w:rPr>\n" +
                "\t\t<w:t>" + getValue(pawnList, 0, "pawnType") + "</w:t>\n" +
                "\t  </w:r>\n" +
                "\t</w:p>\n" +
                "  </w:tc>\n" +
                "  <w:tc>\n" +
                "\t<w:tcPr>\n" +
                "\t  <w:tcW w:w=\"998\" w:type=\"dxa\"/>\n" +
                "\t  <w:tcBorders>\n" +
                "\t\t<w:top w:val=\"single\" w:color=\"000000\" w:sz=\"8\" w:space=\"0\"/>\n" +
                "\t\t<w:left w:val=\"single\" w:color=\"000000\" w:sz=\"8\" w:space=\"0\"/>\n" +
                "\t\t<w:bottom w:val=\"single\" w:color=\"000000\" w:sz=\"8\" w:space=\"0\"/>\n" +
                "\t\t<w:right w:val=\"single\" w:color=\"000000\" w:sz=\"8\" w:space=\"0\"/>\n" +
                "\t  </w:tcBorders>\n" +
                "\t  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"FFFFFF\"/>\n" +
                "\t  <w:vAlign w:val=\"center\"/>\n" +
                "\t</w:tcPr>\n" +
                "\t<w:p>\n" +
                "\t  <w:pPr>\n" +
                "\t\t<w:jc w:val=\"center\"/>\n" +
                "\t\t<w:rPr>\n" +
                "\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"Times New Roman\" w:eastAsia=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t\t  <w:sz w:val=\"22\"/>\n" +
                "\t\t  <w:szCs w:val=\"22\"/>\n" +
                "\t\t  <w:u w:val=\"none\"/>\n" +
                "\t\t  <w:lang w:eastAsia=\"zh-CN\"/>\n" +
                "\t\t</w:rPr>\n" +
                "\t  </w:pPr>\n" +
                "\t  <w:r>\n" +
                "\t\t<w:rPr>\n" +
                "\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\" w:cs=\"宋体\"/>\n" +
                "\t\t  <w:bCs/>\n" +
                "\t\t  <w:sz w:val=\"24\"/>\n" +
                "\t\t  <w:u w:val=\"none\"/>\n" +
                "\t\t  <w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                "\t\t</w:rPr>\n" +
                "\t\t<w:t>" + getValue(pawnList, 0, "pawnOwner") + "</w:t>\n" +
                "\t  </w:r>\n" +
                "\t  <w:r>\n" +
                "\t\t<w:rPr>\n" +
                "\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"Times New Roman\" w:eastAsia=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t\t  <w:u w:val=\"none\"/>\n" +
                "\t\t  <w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                "\t\t</w:rPr>\n" +
                "\t\t<w:t xml:space=\"preserve\"> </w:t>\n" +
                "\t  </w:r>\n" +
                "\t  <w:r>\n" +
                "\t\t<w:rPr>\n" +
                "\t\t  <w:rFonts w:ascii=\"宋体\" w:hAnsi=\"Times New Roman\" w:eastAsia=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t\t  <w:sz w:val=\"22\"/>\n" +
                "\t\t  <w:szCs w:val=\"22\"/>\n" +
                "\t\t  <w:u w:val=\"none\"/>\n" +
                "\t\t</w:rPr>\n" +
                "\t\t<w:t xml:space=\"preserve\"> </w:t>\n" +
                "\t  </w:r>\n" +
                "\t</w:p>\n" +
                "  </w:tc>\n" +
                "  <w:tc>\n" +
                "\t<w:tcPr>\n" +
                "\t  <w:tcW w:w=\"2886\" w:type=\"dxa\"/>\n" +
                "\t  <w:gridSpan w:val=\"3\"/>\n" +
                "\t  <w:tcBorders>\n" +
                "\t\t<w:top w:val=\"single\" w:color=\"000000\" w:sz=\"8\" w:space=\"0\"/>\n" +
                "\t\t<w:left w:val=\"single\" w:color=\"000000\" w:sz=\"8\" w:space=\"0\"/>\n" +
                "\t\t<w:bottom w:val=\"single\" w:color=\"000000\" w:sz=\"8\" w:space=\"0\"/>\n" +
                "\t\t<w:right w:val=\"single\" w:color=\"000000\" w:sz=\"8\" w:space=\"0\"/>\n" +
                "\t  </w:tcBorders>\n" +
                "\t  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"FFFFFF\"/>\n" +
                "\t  <w:vAlign w:val=\"center\"/>\n" +
                "\t</w:tcPr>\n" +
                "\t<w:p>\n" +
                "\t  <w:pPr>\n" +
                "\t\t<w:jc w:val=\"center\"/>\n" +
                "\t\t<w:rPr>\n" +
                "\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"Times New Roman\" w:eastAsia=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t\t  <w:sz w:val=\"22\"/>\n" +
                "\t\t  <w:szCs w:val=\"22\"/>\n" +
                "\t\t  <w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                "\t\t</w:rPr>\n" +
                "\t  </w:pPr>\n" +
                "\t  <w:r>\n" +
                "\t\t<w:rPr>\n" +
                "\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"Times New Roman\" w:eastAsia=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t\t  <w:sz w:val=\"22\"/>\n" +
                "\t\t  <w:szCs w:val=\"22\"/>\n" +
                "\t\t  <w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                "\t\t</w:rPr>\n" +
                "\t\t<w:t>" + getValue(pawnList, 0, "storageAddress") + "</w:t>\n" +
                "\t  </w:r>\n" +
                "\t</w:p>\n" +
                "  </w:tc>\n" +
                "  <w:tc>\n" +
                "\t<w:tcPr>\n" +
                "\t  <w:tcW w:w=\"1428\" w:type=\"dxa\"/>\n" +
                "\t  <w:tcBorders>\n" +
                "\t\t<w:top w:val=\"single\" w:color=\"000000\" w:sz=\"8\" w:space=\"0\"/>\n" +
                "\t\t<w:left w:val=\"single\" w:color=\"000000\" w:sz=\"8\" w:space=\"0\"/>\n" +
                "\t\t<w:bottom w:val=\"single\" w:color=\"000000\" w:sz=\"8\" w:space=\"0\"/>\n" +
                "\t\t<w:right w:val=\"single\" w:color=\"000000\" w:sz=\"6\" w:space=\"0\"/>\n" +
                "\t  </w:tcBorders>\n" +
                "\t  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"FFFFFF\"/>\n" +
                "\t  <w:vAlign w:val=\"center\"/>\n" +
                "\t</w:tcPr>\n" +
                "\t<w:p>\n" +
                "\t  <w:pPr>\n" +
                "\t\t<w:jc w:val=\"center\"/>\n" +
                "\t\t<w:rPr>\n" +
                "\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"Times New Roman\" w:eastAsia=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t\t  <w:sz w:val=\"22\"/>\n" +
                "\t\t  <w:szCs w:val=\"22\"/>\n" +
                "\t\t  <w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                "\t\t</w:rPr>\n" +
                "\t  </w:pPr>\n" +
                "\t  <w:r>\n" +
                "\t\t<w:rPr>\n" +
                "\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"Times New Roman\" w:eastAsia=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t\t  <w:sz w:val=\"22\"/>\n" +
                "\t\t  <w:szCs w:val=\"22\"/>\n" +
                "\t\t  <w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                "\t\t</w:rPr>\n" +
                "\t\t<w:t>" + getValue(pawnList, 0, "amountWithUnit") + "</w:t>\n" +
                "\t  </w:r>\n" +
                "\t</w:p>\n" +
                "  </w:tc>\n" +
                "  <w:tc>\n" +
                "\t<w:tcPr>\n" +
                "\t  <w:tcW w:w=\"1684\" w:type=\"dxa\"/>\n" +
                "\t  <w:gridSpan w:val=\"2\"/>\n" +
                "\t  <w:vMerge w:val=\"restart\"/>\n" +
                "\t  <w:tcBorders>\n" +
                "\t\t<w:top w:val=\"single\" w:color=\"000000\" w:sz=\"6\" w:space=\"0\"/>\n" +
                "\t\t<w:left w:val=\"single\" w:color=\"000000\" w:sz=\"6\" w:space=\"0\"/>\n" +
                "\t\t<w:right w:val=\"single\" w:color=\"000000\" w:sz=\"8\" w:space=\"0\"/>\n" +
                "\t  </w:tcBorders>\n" +
                "\t  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"FFFFFF\"/>\n" +
                "\t  <w:vAlign w:val=\"center\"/>\n" +
                "\t</w:tcPr>\n" +
                "\t<w:p>\n" +
                "\t  <w:pPr>\n" +
                "\t\t<w:jc w:val=\"center\"/>\n" +
                "\t\t<w:rPr>\n" +
                "\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"Times New Roman\" w:eastAsia=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t\t  <w:sz w:val=\"22\"/>\n" +
                "\t\t  <w:szCs w:val=\"22\"/>\n" +
                "\t\t  <w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                "\t\t</w:rPr>\n" +
                "\t  </w:pPr>\n" +
                "\t  <w:r>\n" +
                "\t\t<w:rPr>\n" +
                "\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"Times New Roman\" w:eastAsia=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t\t  <w:sz w:val=\"22\"/>\n" +
                "\t\t  <w:szCs w:val=\"22\"/>\n" +
                "\t\t  <w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                "\t\t</w:rPr>\n" +
                "\t\t<w:t>" + getValue(pawnList, 0, "evaluation") + "</w:t>\n" +
                "\t  </w:r>\n" +
                "\t</w:p>\n" +
                "  </w:tc>\n" +
                "  <w:tc>\n" +
                "\t<w:tcPr>\n" +
                "\t  <w:tcW w:w=\"1487\" w:type=\"dxa\"/>\n" +
                "\t  <w:tcBorders>\n" +
                "\t\t<w:top w:val=\"single\" w:color=\"000000\" w:sz=\"6\" w:space=\"0\"/>\n" +
                "\t\t<w:left w:val=\"single\" w:color=\"000000\" w:sz=\"8\" w:space=\"0\"/>\n" +
                "\t\t<w:bottom w:val=\"single\" w:color=\"000000\" w:sz=\"8\" w:space=\"0\"/>\n" +
                "\t\t<w:right w:val=\"single\" w:color=\"000000\" w:sz=\"6\" w:space=\"0\"/>\n" +
                "\t  </w:tcBorders>\n" +
                "\t  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"FFFFFF\"/>\n" +
                "\t  <w:vAlign w:val=\"center\"/>\n" +
                "\t</w:tcPr>\n" +
                "\t<w:p>\n" +
                "\t  <w:pPr>\n" +
                "\t\t<w:jc w:val=\"center\"/>\n" +
                "\t\t<w:rPr>\n" +
                "\t\t  <w:rFonts w:ascii=\"宋体\" w:hAnsi=\"Times New Roman\" w:eastAsia=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t\t  <w:sz w:val=\"22\"/>\n" +
                "\t\t  <w:szCs w:val=\"22\"/>\n" +
                "\t\t</w:rPr>\n" +
                "\t  </w:pPr>\n" +
                "\t  <w:r>\n" +
                "\t\t<w:rPr>\n" +
                "\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"Times New Roman\" w:eastAsia=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t\t  <w:sz w:val=\"22\"/>\n" +
                "\t\t  <w:szCs w:val=\"22\"/>\n" +
                "\t\t  <w:lang w:eastAsia=\"zh-CN\"/>\n" +
                "\t\t</w:rPr>\n" +
                "\t\t<w:t>" + getValue(pawnList, 0, "pawnType") + "</w:t>\n" +
                "\t  </w:r>\n" +
                "\t</w:p>\n" +
                "  </w:tc>\n" +
                "  <w:tc>\n" +
                "\t<w:tcPr>\n" +
                "\t  <w:tcW w:w=\"2538\" w:type=\"dxa\"/>\n" +
                "\t  <w:gridSpan w:val=\"2\"/>\n" +
                "\t  <w:tcBorders>\n" +
                "\t\t<w:top w:val=\"single\" w:color=\"000000\" w:sz=\"6\" w:space=\"0\"/>\n" +
                "\t\t<w:left w:val=\"single\" w:color=\"000000\" w:sz=\"6\" w:space=\"0\"/>\n" +
                "\t\t<w:bottom w:val=\"single\" w:color=\"000000\" w:sz=\"6\" w:space=\"0\"/>\n" +
                "\t\t<w:right w:val=\"single\" w:color=\"000000\" w:sz=\"6\" w:space=\"0\"/>\n" +
                "\t  </w:tcBorders>\n" +
                "\t  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"FFFFFF\"/>\n" +
                "\t  <w:vAlign w:val=\"center\"/>\n" +
                "\t</w:tcPr>\n" +
                "\t<w:p>\n" +
                "\t  <w:pPr>\n" +
                "\t\t<w:jc w:val=\"center\"/>\n" +
                "\t\t<w:rPr>\n" +
                "\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"Times New Roman\" w:eastAsia=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t\t  <w:sz w:val=\"22\"/>\n" +
                "\t\t  <w:szCs w:val=\"22\"/>\n" +
                "\t\t  <w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                "\t\t</w:rPr>\n" +
                "\t  </w:pPr>\n" +
                "\t  <w:r>\n" +
                "\t\t<w:rPr>\n" +
                "\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"Times New Roman\" w:eastAsia=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t\t  <w:sz w:val=\"22\"/>\n" +
                "\t\t  <w:szCs w:val=\"22\"/>\n" +
                "\t\t  <w:highlight w:val=\"none\"/>\n" +
                "\t\t  <w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                "\t\t</w:rPr>\n" +
                "\t\t<w:t>" + getValue(pawnList, 0, "pawnNo") + "</w:t>\n" +
                "\t  </w:r>\n" +
                "\t</w:p>\n" +
                "  </w:tc>\n" +
                "  <w:tc>\n" +
                "\t<w:tcPr>\n" +
                "\t  <w:tcW w:w=\"1467\" w:type=\"dxa\"/>\n" +
                "\t  <w:tcBorders>\n" +
                "\t\t<w:top w:val=\"single\" w:color=\"000000\" w:sz=\"8\" w:space=\"0\"/>\n" +
                "\t\t<w:left w:val=\"single\" w:color=\"000000\" w:sz=\"6\" w:space=\"0\"/>\n" +
                "\t\t<w:bottom w:val=\"single\" w:color=\"000000\" w:sz=\"6\" w:space=\"0\"/>\n" +
                "\t\t<w:right w:val=\"single\" w:color=\"000000\" w:sz=\"8\" w:space=\"0\"/>\n" +
                "\t  </w:tcBorders>\n" +
                "\t  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"FFFFFF\"/>\n" +
                "\t  <w:vAlign w:val=\"center\"/>\n" +
                "\t</w:tcPr>\n" +
                "\t<w:p>\n" +
                "\t  <w:pPr>\n" +
                "\t\t<w:jc w:val=\"center\"/>\n" +
                "\t\t<w:rPr>\n" +
                "\t\t  <w:rFonts w:ascii=\"宋体\" w:hAnsi=\"Times New Roman\" w:eastAsia=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t\t  <w:sz w:val=\"22\"/>\n" +
                "\t\t  <w:szCs w:val=\"22\"/>\n" +
                "\t\t</w:rPr>\n" +
                "\t  </w:pPr>\n" +
                "\t  <w:r>\n" +
                "\t\t<w:rPr>\n" +
                "\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"Times New Roman\" w:eastAsia=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t\t  <w:sz w:val=\"22\"/>\n" +
                "\t\t  <w:szCs w:val=\"22\"/>\n" +
                "\t\t  <w:highlight w:val=\"none\"/>\n" +
                "\t\t  <w:lang w:eastAsia=\"zh-CN\"/>\n" +
                "\t\t</w:rPr>\n" +
                "\t\t<w:t>" + getValue(pawnList, 0, "issueOrg") + "</w:t>\n" +
                "\t  </w:r>\n" +
                "\t</w:p>\n" +
                "  </w:tc>\n" +
                "  <w:tc>\n" +
                "\t<w:tcPr>\n" +
                "\t  <w:tcW w:w=\"1428\" w:type=\"dxa\"/>\n" +
                "\t  <w:tcBorders>\n" +
                "\t\t<w:top w:val=\"single\" w:color=\"000000\" w:sz=\"8\" w:space=\"0\"/>\n" +
                "\t\t<w:left w:val=\"single\" w:color=\"000000\" w:sz=\"8\" w:space=\"0\"/>\n" +
                "\t\t<w:bottom w:val=\"single\" w:color=\"000000\" w:sz=\"6\" w:space=\"0\"/>\n" +
                "\t\t<w:right w:val=\"single\" w:color=\"000000\" w:sz=\"8\" w:space=\"0\"/>\n" +
                "\t  </w:tcBorders>\n" +
                "\t  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"FFFFFF\"/>\n" +
                "\t  <w:vAlign w:val=\"center\"/>\n" +
                "\t</w:tcPr>\n" +
                "\t<w:p>\n" +
                "\t  <w:pPr>\n" +
                "\t\t<w:jc w:val=\"center\"/>\n" +
                "\t\t<w:rPr>\n" +
                "\t\t  <w:rFonts w:ascii=\"宋体\" w:hAnsi=\"Times New Roman\" w:eastAsia=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t\t  <w:sz w:val=\"22\"/>\n" +
                "\t\t  <w:szCs w:val=\"22\"/>\n" +
                "\t\t</w:rPr>\n" +
                "\t  </w:pPr>\n" +
                "\t</w:p>\n" +
                "  </w:tc>\n" +
                "</w:tr>");

        for (int i = 1; i < pawnList.size(); i++) {
            data.append("<w:tr>\n" +
                    "  <w:tblPrEx>\n" +
                    "\t<w:tblLayout w:type=\"fixed\"/>\n" +
                    "\t<w:tblCellMar>\n" +
                    "\t  <w:top w:w=\"0\" w:type=\"dxa\"/>\n" +
                    "\t  <w:left w:w=\"0\" w:type=\"dxa\"/>\n" +
                    "\t  <w:bottom w:w=\"0\" w:type=\"dxa\"/>\n" +
                    "\t  <w:right w:w=\"0\" w:type=\"dxa\"/>\n" +
                    "\t</w:tblCellMar>\n" +
                    "  </w:tblPrEx>\n" +
                    "  <w:trPr>\n" +
                    "\t<w:trHeight w:val=\"770\" w:hRule=\"atLeast\"/>\n" +
                    "\t<w:jc w:val=\"center\"/>\n" +
                    "  </w:trPr>\n" +
                    "  <w:tc>\n" +
                    "\t<w:tcPr>\n" +
                    "\t  <w:tcW w:w=\"1330\" w:type=\"dxa\"/>\n" +
                    "\t  <w:tcBorders>\n" +
                    "\t\t<w:top w:val=\"single\" w:color=\"000000\" w:sz=\"8\" w:space=\"0\"/>\n" +
                    "\t\t<w:left w:val=\"single\" w:color=\"000000\" w:sz=\"8\" w:space=\"0\"/>\n" +
                    "\t\t<w:bottom w:val=\"single\" w:color=\"000000\" w:sz=\"8\" w:space=\"0\"/>\n" +
                    "\t\t<w:right w:val=\"single\" w:color=\"000000\" w:sz=\"8\" w:space=\"0\"/>\n" +
                    "\t  </w:tcBorders>\n" +
                    "\t  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"FFFFFF\"/>\n" +
                    "\t  <w:vAlign w:val=\"center\"/>\n" +
                    "\t</w:tcPr>\n" +
                    "\t<w:p>\n" +
                    "\t  <w:pPr>\n" +
                    "\t\t<w:jc w:val=\"center\"/>\n" +
                    "\t\t<w:rPr>\n" +
                    "\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"Times New Roman\" w:eastAsia=\"宋体\" w:cs=\"宋体\"/>\n" +
                    "\t\t  <w:sz w:val=\"22\"/>\n" +
                    "\t\t  <w:szCs w:val=\"22\"/>\n" +
                    "\t\t  <w:lang w:eastAsia=\"zh-CN\"/>\n" +
                    "\t\t</w:rPr>\n" +
                    "\t  </w:pPr>\n" +
                    "\t  <w:r>\n" +
                    "\t\t<w:rPr>\n" +
                    "\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"Times New Roman\" w:eastAsia=\"宋体\" w:cs=\"宋体\"/>\n" +
                    "\t\t  <w:sz w:val=\"22\"/>\n" +
                    "\t\t  <w:szCs w:val=\"22\"/>\n" +
                    "\t\t  <w:lang w:eastAsia=\"zh-CN\"/>\n" +
                    "\t\t</w:rPr>\n" +
                    "\t\t<w:t>" + getValue(pawnList, i, "pawnType") + "</w:t>\n" +
                    "\t  </w:r>\n" +
                    "\t</w:p>\n" +
                    "  </w:tc>\n" +
                    "  <w:tc>\n" +
                    "\t<w:tcPr>\n" +
                    "\t  <w:tcW w:w=\"998\" w:type=\"dxa\"/>\n" +
                    "\t  <w:tcBorders>\n" +
                    "\t\t<w:top w:val=\"single\" w:color=\"000000\" w:sz=\"8\" w:space=\"0\"/>\n" +
                    "\t\t<w:left w:val=\"single\" w:color=\"000000\" w:sz=\"8\" w:space=\"0\"/>\n" +
                    "\t\t<w:bottom w:val=\"single\" w:color=\"000000\" w:sz=\"8\" w:space=\"0\"/>\n" +
                    "\t\t<w:right w:val=\"single\" w:color=\"000000\" w:sz=\"8\" w:space=\"0\"/>\n" +
                    "\t  </w:tcBorders>\n" +
                    "\t  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"FFFFFF\"/>\n" +
                    "\t  <w:vAlign w:val=\"center\"/>\n" +
                    "\t</w:tcPr>\n" +
                    "\t<w:p>\n" +
                    "\t  <w:pPr>\n" +
                    "\t\t<w:jc w:val=\"center\"/>\n" +
                    "\t\t<w:rPr>\n" +
                    "\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"Times New Roman\" w:eastAsia=\"宋体\" w:cs=\"宋体\"/>\n" +
                    "\t\t  <w:sz w:val=\"22\"/>\n" +
                    "\t\t  <w:szCs w:val=\"22\"/>\n" +
                    "\t\t  <w:u w:val=\"none\"/>\n" +
                    "\t\t  <w:lang w:eastAsia=\"zh-CN\"/>\n" +
                    "\t\t</w:rPr>\n" +
                    "\t  </w:pPr>\n" +
                    "\t  <w:r>\n" +
                    "\t\t<w:rPr>\n" +
                    "\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\" w:cs=\"宋体\"/>\n" +
                    "\t\t  <w:bCs/>\n" +
                    "\t\t  <w:sz w:val=\"24\"/>\n" +
                    "\t\t  <w:u w:val=\"none\"/>\n" +
                    "\t\t  <w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                    "\t\t</w:rPr>\n" +
                    "\t\t<w:t>" + getValue(pawnList, i, "pawnOwner") + "</w:t>\n" +
                    "\t  </w:r>\n" +
                    "\t  <w:r>\n" +
                    "\t\t<w:rPr>\n" +
                    "\t\t  <w:rFonts w:ascii=\"宋体\" w:hAnsi=\"Times New Roman\" w:eastAsia=\"宋体\" w:cs=\"宋体\"/>\n" +
                    "\t\t  <w:sz w:val=\"22\"/>\n" +
                    "\t\t  <w:szCs w:val=\"22\"/>\n" +
                    "\t\t  <w:u w:val=\"none\"/>\n" +
                    "\t\t</w:rPr>\n" +
                    "\t\t<w:t xml:space=\"preserve\"> </w:t>\n" +
                    "\t  </w:r>\n" +
                    "\t</w:p>\n" +
                    "  </w:tc>\n" +
                    "  <w:tc>\n" +
                    "\t<w:tcPr>\n" +
                    "\t  <w:tcW w:w=\"2886\" w:type=\"dxa\"/>\n" +
                    "\t  <w:gridSpan w:val=\"3\"/>\n" +
                    "\t  <w:tcBorders>\n" +
                    "\t\t<w:top w:val=\"single\" w:color=\"000000\" w:sz=\"8\" w:space=\"0\"/>\n" +
                    "\t\t<w:left w:val=\"single\" w:color=\"000000\" w:sz=\"8\" w:space=\"0\"/>\n" +
                    "\t\t<w:bottom w:val=\"single\" w:color=\"000000\" w:sz=\"8\" w:space=\"0\"/>\n" +
                    "\t\t<w:right w:val=\"single\" w:color=\"000000\" w:sz=\"8\" w:space=\"0\"/>\n" +
                    "\t  </w:tcBorders>\n" +
                    "\t  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"FFFFFF\"/>\n" +
                    "\t  <w:vAlign w:val=\"center\"/>\n" +
                    "\t</w:tcPr>\n" +
                    "\t<w:p>\n" +
                    "\t  <w:pPr>\n" +
                    "\t\t<w:jc w:val=\"center\"/>\n" +
                    "\t\t<w:rPr>\n" +
                    "\t\t  <w:rFonts w:ascii=\"宋体\" w:hAnsi=\"Times New Roman\" w:eastAsia=\"宋体\" w:cs=\"宋体\"/>\n" +
                    "\t\t  <w:sz w:val=\"22\"/>\n" +
                    "\t\t  <w:szCs w:val=\"22\"/>\n" +
                    "\t\t</w:rPr>\n" +
                    "\t  </w:pPr>\n" +
                    "\t  <w:r>\n" +
                    "\t\t<w:rPr>\n" +
                    "\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"Times New Roman\" w:eastAsia=\"宋体\" w:cs=\"宋体\"/>\n" +
                    "\t\t  <w:sz w:val=\"22\"/>\n" +
                    "\t\t  <w:szCs w:val=\"22\"/>\n" +
                    "\t\t</w:rPr>\n" +
                    "\t\t<w:t>" + getValue(pawnList, i, "storageAddress") + "</w:t>\n" +
                    "\t  </w:r>\n" +
                    "\t</w:p>\n" +
                    "  </w:tc>\n" +
                    "  <w:tc>\n" +
                    "\t<w:tcPr>\n" +
                    "\t  <w:tcW w:w=\"1428\" w:type=\"dxa\"/>\n" +
                    "\t  <w:tcBorders>\n" +
                    "\t\t<w:top w:val=\"single\" w:color=\"000000\" w:sz=\"8\" w:space=\"0\"/>\n" +
                    "\t\t<w:left w:val=\"single\" w:color=\"000000\" w:sz=\"8\" w:space=\"0\"/>\n" +
                    "\t\t<w:bottom w:val=\"single\" w:color=\"000000\" w:sz=\"8\" w:space=\"0\"/>\n" +
                    "\t\t<w:right w:val=\"single\" w:color=\"000000\" w:sz=\"6\" w:space=\"0\"/>\n" +
                    "\t  </w:tcBorders>\n" +
                    "\t  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"FFFFFF\"/>\n" +
                    "\t  <w:vAlign w:val=\"center\"/>\n" +
                    "\t</w:tcPr>\n" +
                    "\t<w:p>\n" +
                    "\t  <w:pPr>\n" +
                    "\t\t<w:jc w:val=\"center\"/>\n" +
                    "\t\t<w:rPr>\n" +
                    "\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"Times New Roman\" w:eastAsia=\"宋体\" w:cs=\"宋体\"/>\n" +
                    "\t\t  <w:sz w:val=\"22\"/>\n" +
                    "\t\t  <w:szCs w:val=\"22\"/>\n" +
                    "\t\t  <w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                    "\t\t</w:rPr>\n" +
                    "\t  </w:pPr>\n" +
                    "\t  <w:r>\n" +
                    "\t\t<w:rPr>\n" +
                    "\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"Times New Roman\" w:eastAsia=\"宋体\" w:cs=\"宋体\"/>\n" +
                    "\t\t  <w:sz w:val=\"22\"/>\n" +
                    "\t\t  <w:szCs w:val=\"22\"/>\n" +
                    "\t\t  <w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                    "\t\t</w:rPr>\n" +
                    "\t\t<w:t>" + getValue(pawnList, i, "amountWithUnit") + "</w:t>\n" +
                    "\t  </w:r>\n" +
                    "\t</w:p>\n" +
                    "  </w:tc>\n" +
                    "  <w:tc>\n" +
                    "\t<w:tcPr>\n" +
                    "\t  <w:tcW w:w=\"1684\" w:type=\"dxa\"/>\n" +
                    "\t  <w:gridSpan w:val=\"2\"/>\n" +
                    "\t  <w:vMerge w:val=\"continue\"/>\n" +
                    "\t  <w:tcBorders>\n" +
                    "\t\t<w:left w:val=\"single\" w:color=\"000000\" w:sz=\"6\" w:space=\"0\"/>\n" +
                    "\t\t<w:right w:val=\"single\" w:color=\"000000\" w:sz=\"8\" w:space=\"0\"/>\n" +
                    "\t  </w:tcBorders>\n" +
                    "\t  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"FFFFFF\"/>\n" +
                    "\t  <w:vAlign w:val=\"center\"/>\n" +
                    "\t</w:tcPr>\n" +
                    "\t<w:p>\n" +
                    "\t  <w:pPr>\n" +
                    "\t\t<w:jc w:val=\"center\"/>\n" +
                    "\t\t<w:rPr>\n" +
                    "\t\t  <w:rFonts w:ascii=\"宋体\" w:hAnsi=\"Times New Roman\" w:eastAsia=\"宋体\" w:cs=\"宋体\"/>\n" +
                    "\t\t  <w:sz w:val=\"22\"/>\n" +
                    "\t\t  <w:szCs w:val=\"22\"/>\n" +
                    "\t\t</w:rPr>\n" +
                    "\t  </w:pPr>\n" +
                    "\t</w:p>\n" +
                    "  </w:tc>\n" +
                    "  <w:tc>\n" +
                    "\t<w:tcPr>\n" +
                    "\t  <w:tcW w:w=\"1487\" w:type=\"dxa\"/>\n" +
                    "\t  <w:tcBorders>\n" +
                    "\t\t<w:top w:val=\"single\" w:color=\"000000\" w:sz=\"6\" w:space=\"0\"/>\n" +
                    "\t\t<w:left w:val=\"single\" w:color=\"000000\" w:sz=\"8\" w:space=\"0\"/>\n" +
                    "\t\t<w:bottom w:val=\"single\" w:color=\"000000\" w:sz=\"8\" w:space=\"0\"/>\n" +
                    "\t\t<w:right w:val=\"single\" w:color=\"000000\" w:sz=\"6\" w:space=\"0\"/>\n" +
                    "\t  </w:tcBorders>\n" +
                    "\t  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"FFFFFF\"/>\n" +
                    "\t  <w:vAlign w:val=\"center\"/>\n" +
                    "\t</w:tcPr>\n" +
                    "\t<w:p>\n" +
                    "\t  <w:pPr>\n" +
                    "\t\t<w:jc w:val=\"center\"/>\n" +
                    "\t\t<w:rPr>\n" +
                    "\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"Times New Roman\" w:eastAsia=\"宋体\" w:cs=\"宋体\"/>\n" +
                    "\t\t  <w:sz w:val=\"22\"/>\n" +
                    "\t\t  <w:szCs w:val=\"22\"/>\n" +
                    "\t\t  <w:lang w:eastAsia=\"zh-CN\"/>\n" +
                    "\t\t</w:rPr>\n" +
                    "\t  </w:pPr>\n" +
                    "\t  <w:r>\n" +
                    "\t\t<w:rPr>\n" +
                    "\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"Times New Roman\" w:eastAsia=\"宋体\" w:cs=\"宋体\"/>\n" +
                    "\t\t  <w:sz w:val=\"22\"/>\n" +
                    "\t\t  <w:szCs w:val=\"22\"/>\n" +
                    "\t\t  <w:lang w:eastAsia=\"zh-CN\"/>\n" +
                    "\t\t</w:rPr>\n" +
                    "\t\t<w:t>" + getValue(pawnList, i, "pawnType") + "</w:t>\n" +
                    "\t  </w:r>\n" +
                    "\t</w:p>\n" +
                    "  </w:tc>\n" +
                    "  <w:tc>\n" +
                    "\t<w:tcPr>\n" +
                    "\t  <w:tcW w:w=\"2538\" w:type=\"dxa\"/>\n" +
                    "\t  <w:gridSpan w:val=\"2\"/>\n" +
                    "\t  <w:tcBorders>\n" +
                    "\t\t<w:top w:val=\"single\" w:color=\"000000\" w:sz=\"6\" w:space=\"0\"/>\n" +
                    "\t\t<w:left w:val=\"single\" w:color=\"000000\" w:sz=\"6\" w:space=\"0\"/>\n" +
                    "\t\t<w:bottom w:val=\"single\" w:color=\"000000\" w:sz=\"6\" w:space=\"0\"/>\n" +
                    "\t\t<w:right w:val=\"single\" w:color=\"000000\" w:sz=\"6\" w:space=\"0\"/>\n" +
                    "\t  </w:tcBorders>\n" +
                    "\t  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"FFFFFF\"/>\n" +
                    "\t  <w:vAlign w:val=\"center\"/>\n" +
                    "\t</w:tcPr>\n" +
                    "\t<w:p>\n" +
                    "\t  <w:pPr>\n" +
                    "\t\t<w:jc w:val=\"center\"/>\n" +
                    "\t\t<w:rPr>\n" +
                    "\t\t  <w:rFonts w:ascii=\"宋体\" w:hAnsi=\"Times New Roman\" w:eastAsia=\"宋体\" w:cs=\"宋体\"/>\n" +
                    "\t\t  <w:sz w:val=\"22\"/>\n" +
                    "\t\t  <w:szCs w:val=\"22\"/>\n" +
                    "\t\t  <w:lang w:val=\"en-US\"/>\n" +
                    "\t\t</w:rPr>\n" +
                    "\t  </w:pPr>\n" +
                    "\t  <w:r>\n" +
                    "\t\t<w:rPr>\n" +
                    "\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"Times New Roman\" w:eastAsia=\"宋体\" w:cs=\"宋体\"/>\n" +
                    "\t\t  <w:sz w:val=\"22\"/>\n" +
                    "\t\t  <w:szCs w:val=\"22\"/>\n" +
                    "\t\t  <w:highlight w:val=\"none\"/>\n" +
                    "\t\t  <w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                    "\t\t</w:rPr>\n" +
                    "\t\t<w:t>" + getValue(pawnList, i, "pawnNo") + "</w:t>\n" +
                    "\t  </w:r>\n" +
                    "\t</w:p>\n" +
                    "  </w:tc>\n" +
                    "  <w:tc>\n" +
                    "\t<w:tcPr>\n" +
                    "\t  <w:tcW w:w=\"1467\" w:type=\"dxa\"/>\n" +
                    "\t  <w:tcBorders>\n" +
                    "\t\t<w:top w:val=\"single\" w:color=\"000000\" w:sz=\"8\" w:space=\"0\"/>\n" +
                    "\t\t<w:left w:val=\"single\" w:color=\"000000\" w:sz=\"6\" w:space=\"0\"/>\n" +
                    "\t\t<w:bottom w:val=\"single\" w:color=\"000000\" w:sz=\"6\" w:space=\"0\"/>\n" +
                    "\t\t<w:right w:val=\"single\" w:color=\"000000\" w:sz=\"8\" w:space=\"0\"/>\n" +
                    "\t  </w:tcBorders>\n" +
                    "\t  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"FFFFFF\"/>\n" +
                    "\t  <w:vAlign w:val=\"center\"/>\n" +
                    "\t</w:tcPr>\n" +
                    "\t<w:p>\n" +
                    "\t  <w:pPr>\n" +
                    "\t\t<w:jc w:val=\"center\"/>\n" +
                    "\t\t<w:rPr>\n" +
                    "\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"Times New Roman\" w:eastAsia=\"宋体\" w:cs=\"宋体\"/>\n" +
                    "\t\t  <w:sz w:val=\"22\"/>\n" +
                    "\t\t  <w:szCs w:val=\"22\"/>\n" +
                    "\t\t  <w:lang w:eastAsia=\"zh-CN\"/>\n" +
                    "\t\t</w:rPr>\n" +
                    "\t  </w:pPr>\n" +
                    "\t  <w:r>\n" +
                    "\t\t<w:rPr>\n" +
                    "\t\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"Times New Roman\" w:eastAsia=\"宋体\" w:cs=\"宋体\"/>\n" +
                    "\t\t  <w:sz w:val=\"22\"/>\n" +
                    "\t\t  <w:szCs w:val=\"22\"/>\n" +
                    "\t\t  <w:lang w:eastAsia=\"zh-CN\"/>\n" +
                    "\t\t</w:rPr>\n" +
                    "\t\t<w:t>" + getValue(pawnList, i, "issueOrg") + "</w:t>\n" +
                    "\t  </w:r>\n" +
                    "\t</w:p>\n" +
                    "  </w:tc>\n" +
                    "  <w:tc>\n" +
                    "\t<w:tcPr>\n" +
                    "\t  <w:tcW w:w=\"1428\" w:type=\"dxa\"/>\n" +
                    "\t  <w:tcBorders>\n" +
                    "\t\t<w:top w:val=\"single\" w:color=\"000000\" w:sz=\"8\" w:space=\"0\"/>\n" +
                    "\t\t<w:left w:val=\"single\" w:color=\"000000\" w:sz=\"8\" w:space=\"0\"/>\n" +
                    "\t\t<w:bottom w:val=\"single\" w:color=\"000000\" w:sz=\"6\" w:space=\"0\"/>\n" +
                    "\t\t<w:right w:val=\"single\" w:color=\"000000\" w:sz=\"8\" w:space=\"0\"/>\n" +
                    "\t  </w:tcBorders>\n" +
                    "\t  <w:shd w:val=\"clear\" w:color=\"auto\" w:fill=\"FFFFFF\"/>\n" +
                    "\t  <w:vAlign w:val=\"center\"/>\n" +
                    "\t</w:tcPr>\n" +
                    "\t<w:p>\n" +
                    "\t  <w:pPr>\n" +
                    "\t\t<w:jc w:val=\"center\"/>\n" +
                    "\t\t<w:rPr>\n" +
                    "\t\t  <w:rFonts w:ascii=\"宋体\" w:hAnsi=\"Times New Roman\" w:eastAsia=\"宋体\" w:cs=\"宋体\"/>\n" +
                    "\t\t  <w:sz w:val=\"22\"/>\n" +
                    "\t\t  <w:szCs w:val=\"22\"/>\n" +
                    "\t\t</w:rPr>\n" +
                    "\t  </w:pPr>\n" +
                    "\t</w:p>\n" +
                    "  </w:tc>\n" +
                    "</w:tr>");
        }


        variables.put("pawnList", data.toString());
    }

    private double addOneByOne(double current, String value) {
        if (StringUtils.isBlank(value)) {
            return current;
        }

        try {
            return current + Double.parseDouble(value);
        } catch (NumberFormatException e) {
            log.warn("value[{}] parse double failed", value);
            return current;
        }

    }

    private String getMortgageCoownerName(String rpiIdsVal) {
        List<String> names = new ArrayList<>();
        try {
            String[] rpiIds = rpiIdsVal.split(",");
            for (String rpiId : rpiIds) {
                if (StringUtils.isBlank(rpiId)) {
                    continue;
                }

                RelatedPersonnelInformation relatedPersonnelInformation = relatedPersonnelInformationMapper.findById(Long.valueOf(rpiId));
                if (relatedPersonnelInformation == null) {
                    continue;
                }

                if (names.contains(relatedPersonnelInformation.getName())) {
                    continue;
                }

                names.add(relatedPersonnelInformation.getName());
            }
        } catch (Exception e) {
            log.error("getMortgageCoownerName failed by rpiIdsVal[{}]", rpiIdsVal, e);
        }

        if (CollectionUtils.isEmpty(names)) {
            return "";
        }

        return StringUtils.join(names, "、");
    }

    @Override
    protected void fillVariable(DocCommonModel docCommonModel) {
        Map<String, List<Pawn>> pawnInOwners = calculateCount(docCommonModel);
        for (Map.Entry<String, List<Pawn>> entry : pawnInOwners.entrySet()) {
            Map<String, Object> variables = newRound();
            variables.put("bankBranchName", BankConstants.BANK_BRANCH_NAME);

            String name = getMortgageCoownerName(entry.getKey());
            // 抵押物 所有抵押人信息
            variables.put("mortgageCoownerName", name);

            double evaluation = 0d;
            List<Map<String, Object>> pawnList = new ArrayList<>();
            for (Pawn pawn : entry.getValue()) {
                if (pawn.getMortgageType() == 0) {
                    if (pawn.getWhetherOwnershipCertificates() == 0) {
                        Map<String, Object> tempMap = new HashMap<>();
                        tempMap.put("pawnOwner", name);
                        tempMap.put("storageAddress", pawn.getCollateralDeposit());
                        tempMap.put("pawnType", "不动产权证");
                        tempMap.put("amountWithUnit", pawn.getBuildingArea() + "㎡");
                        tempMap.put("pawnNo", pawn.getPropertyCertificateNumber());
                        tempMap.put("issueOrg", "                ");
                        pawnList.add(tempMap);

                    } else {
                        Map<String, Object> tempMap = new HashMap<>();
                        tempMap.put("pawnOwner", name);
                        tempMap.put("storageAddress", pawn.getCollateralDeposit());
                        tempMap.put("pawnType", "房产证");
                        tempMap.put("amountWithUnit", pawn.getBuildingArea() + "㎡");
                        tempMap.put("pawnNo", pawn.getPropertyCertificateNumber());
                        tempMap.put("issueOrg", "                ");
                        pawnList.add(tempMap);

                        tempMap = new HashMap<>();
                        tempMap.put("pawnOwner", name);
                        tempMap.put("storageAddress", pawn.getCollateralDeposit());
                        tempMap.put("pawnType", "土地证");
                        tempMap.put("amountWithUnit", pawn.getBuildingArea() + "㎡");
                        tempMap.put("pawnNo", pawn.getLandCertificateNumber());
                        tempMap.put("issueOrg", "                ");
                        pawnList.add(tempMap);
                    }
                } else {
                    Map<String, Object> tempMap = new HashMap<>();
                    tempMap.put("pawnOwner", name);
                    tempMap.put("storageAddress", pawn.getCollateralDeposit());
                    tempMap.put("pawnType", "土地证");
                    tempMap.put("amountWithUnit", pawn.getLandOccupationArea() + "㎡");
                    tempMap.put("pawnNo", pawn.getLandCertificateNumber());
                    tempMap.put("issueOrg", "                ");
                    pawnList.add(tempMap);
                }

                evaluation = addOneByOne(evaluation, pawn.getValue());
            }

            // 设置第一条记录 总价值（累加）
            if (CollectionUtils.isNotEmpty(pawnList)) {
                pawnList.get(0).put("evaluation", evaluation);
            }

            setPawnList(pawnList, variables);
        }
    }

    private Map<String, List<Pawn>> calculateCount(DocCommonModel docCommonModel) {
        Map<String, List<Pawn>> pawnInOwners = new HashMap<>();
        for (Pawn pawn : docCommonModel.getPawnList()) {
            if (pawnInOwners.containsKey(pawn.getOwnerIds())) {
                pawnInOwners.get(pawn.getOwnerIds()).add(pawn);
            } else {
                List<Pawn> list = new ArrayList<>();
                list.add(pawn);
                pawnInOwners.put(pawn.getOwnerIds(), list);
            }
        }

        return pawnInOwners;
    }

    @Override
    protected String modelFileName() {
        return "抵押物清单";
    }

    @Override
    protected int sort() {
        return 3_1_00;
    }

    @Override
    protected DocConstants.DocType docType() {
        return DocConstants.DocType.WORD;
    }

    @Override
    protected DocConstants.DocCategory category() {
        return DocConstants.DocCategory.FORM_APPROVE;
    }
}
