package com.louis.kitty.admin.office;

import com.louis.kitty.admin.constants.DocConstants;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class LenderRelationshipTool extends AbstractOfficeTool {

    private void setRelationshipList(List<Map<String, Object>> relationshipList, Map<String, Object> variables) {
        StringBuilder data = new StringBuilder();

        for (int i = 0; i < relationshipList.size(); i++) {
            Map<String, Object> relationship = relationshipList.get(i);
            data.append("<Row ss:Height=\"102\">\n")
                    .append("<Cell ss:StyleID=\"s52\">\n")
                    .append("<Data ss:Type=\"Number\">").append(i + 1).append("</Data>\n")
                    .append("</Cell>\n")
                    .append("<Cell ss:StyleID=\"s52\">\n")
                    .append("<Data ss:Type=\"String\">").append(relationship.get("name")).append("</Data>\n")
                    .append("</Cell>\n")
                    .append("<Cell ss:StyleID=\"s60\">\n")
                    .append("<Data ss:Type=\"String\">").append(relationship.get("relationship")).append("</Data>\n")
                    .append("</Cell>\n")
                    .append("<Cell ss:StyleID=\"s61\">\n")
                    .append("<Data ss:Type=\"String\" x:Ticked=\"1\">").append(relationship.get("idcard")).append("</Data>\n")
                    .append("</Cell>\n")
                    .append("<Cell ss:StyleID=\"s62\">\n")
                    .append("<Data ss:Type=\"String\">").append(relationship.get("address")).append("</Data>\n")
                    .append("</Cell>\n")
                    .append("<Cell ss:StyleID=\"s60\">\n")
                    .append("<Data ss:Type=\"Number\">").append(relationship.get("mobile")).append("</Data>\n")
                    .append("</Cell>\n")
                    .append("<Cell ss:StyleID=\"s53\"/>\n")
                    .append("<Cell ss:StyleID=\"s53\"/>\n")
                    .append("<Cell ss:StyleID=\"s53\"/>\n")
                    .append("<Cell ss:StyleID=\"s62\">\n")
                    .append("<Data ss:Type=\"String\">").append(relationship.get("remark")).append("</Data>\n")
                    .append("</Cell>\n")
                    .append("</Row>");
        }

        variables.put("relationshipList", data.toString());
    }

    @Override
    protected void fillVariable(Long basisLoanId) {
        Map<String, Object> variables = newRound();

        List<Map<String, Object>> relationshipList = new ArrayList<>();
        Map<String, Object> tempMap = new HashMap<>();
        tempMap.put("name", "罗永芳");
        tempMap.put("relationship", "借款人本人");
        tempMap.put("idcard", "'510102196901118483");
        tempMap.put("mobile", "'15807737711");
        tempMap.put("address", "广西桂林市象山区民主路12-1号");
        tempMap.put("remark", "地址1");
        relationshipList.add(tempMap);

        tempMap = new HashMap<>();
        tempMap.put("name", "唐建国");
        tempMap.put("relationship", "借款人配偶");
        tempMap.put("idcard", "'45030519540601001X");
        tempMap.put("mobile", "'13707737775");
        tempMap.put("address", "广西桂林市叠彩区铁佛路6号2栋2单元501室");
        tempMap.put("remark", "地址2");

        setRelationshipList(relationshipList, variables);

    }

    @Override
    protected String modelFileName() {
        return "借款人及关系人面签基本信息表";
    }

    @Override
    protected int sort() {
        return 1_6_0;
    }

    @Override
    protected DocConstants.DocType docType() {
        return DocConstants.DocType.EXCEL;
    }
}
