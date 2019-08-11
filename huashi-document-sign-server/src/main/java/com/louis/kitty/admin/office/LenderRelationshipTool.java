package com.louis.kitty.admin.office;

import com.louis.kitty.admin.constants.DocConstants;
import com.louis.kitty.admin.model.DocCommonModel;
import com.louis.kitty.admin.model.Pawn;
import com.louis.kitty.admin.model.PawnPersonnelMapping;
import com.louis.kitty.admin.model.RelatedPersonnelInformation;
import com.louis.kitty.admin.sevice.PawnPersonnelMappingService;
import com.louis.kitty.admin.sevice.PawnService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class LenderRelationshipTool extends AbstractOfficeTool {

    @Autowired
    private PawnPersonnelMappingService pawnPersonnelMappingService;

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

    private Map<String, Object> relationship(String name, String relationship, String idcard, String mobile, String address,
                                             String remark) {
        Map<String, Object> tempMap = new HashMap<>();
        tempMap.put("name", name);

        // 需要转义： type 类型（1、借款人本人）（2、借款人配偶）（3、抵押担保人） （4、保证担保人）（5、抵押担保人、保证担保人）
        tempMap.put("relationship", relationship);
        tempMap.put("idcard", idcard);
        tempMap.put("mobile", mobile);
        tempMap.put("address", address);

        // 根据id查询 pawn_personnel_mapping 的抵押物信息，并联查1.9. pawn抵押物信息表 得到 抵押物地址(多个抵押物 ;分隔开)
        tempMap.put("remark", remark);

        return tempMap;
    }

    @Override
    protected void fillVariable(DocCommonModel docCommonModel) {
        Map<String, Object> variables = newRound();


        // 1.2. related_personnel_information相关人员信息表
        List<Map<String, Object>> relationshipList = new ArrayList<>();

        if(docCommonModel.getBorrower() != null) {
            relationshipList.add(relationship(docCommonModel.getBorrower().getName(),
                    "借款人本人", docCommonModel.getBorrower().getIdentityNumber(),
                    docCommonModel.getBorrower().getContactNumber(),
                    docCommonModel.getBorrower().getCurrentHomeAddress(),
                    getMortgageGoodsName(docCommonModel.getBorrower().getId())));
        }

        if(docCommonModel.getBorrowerCouple() != null) {
            relationshipList.add(relationship(docCommonModel.getBorrowerCouple().getName(),
                    "借款人配偶", docCommonModel.getBorrowerCouple().getIdentityNumber(),
                    docCommonModel.getBorrowerCouple().getContactNumber(),
                    docCommonModel.getBorrowerCouple().getCurrentHomeAddress(), ""));
        }

        if(CollectionUtils.isNotEmpty(docCommonModel.getGuarantorList())) {
            for(RelatedPersonnelInformation relatedPersonnelInformation : docCommonModel.getGuarantorList()) {

                relationshipList.add(relationship(relatedPersonnelInformation.getName(),
                        "保证担保人", relatedPersonnelInformation.getIdentityNumber(),
                        relatedPersonnelInformation.getContactNumber(),
                        relatedPersonnelInformation.getCurrentHomeAddress(), ""));
            }
        }

        if(CollectionUtils.isNotEmpty(docCommonModel.getMortgageGuarantorList())) {
            for(RelatedPersonnelInformation relatedPersonnelInformation : docCommonModel.getMortgageGuarantorList()) {

                relationshipList.add(relationship(relatedPersonnelInformation.getName(),
                        "抵押担保人", relatedPersonnelInformation.getIdentityNumber(),
                        relatedPersonnelInformation.getContactNumber(),
                        relatedPersonnelInformation.getCurrentHomeAddress(),
                        getMortgageGoodsName(relatedPersonnelInformation.getId())));
            }
        }

        setRelationshipList(relationshipList, variables);
    }

    private String getMortgageGoodsName(Long rpiId) {
        List<Pawn> list = pawnPersonnelMappingService.findByRpiId(rpiId);
        if(CollectionUtils.isEmpty(list)) {
            return "";
        }

        Set<String> mortgageGoodsName = new HashSet<>();
        for(Pawn pawn : list) {
            mortgageGoodsName.add(pawn.getCollateralDeposit());
        }

        return StringUtils.join(mortgageGoodsName, "、");
    }

    @Override
    protected String modelFileName() {
        return "借款人及关系人面签基本信息表";
    }

    @Override
    protected int sort() {
        return 1_6_00;
    }

    @Override
    protected DocConstants.DocType docType() {
        return DocConstants.DocType.EXCEL;
    }
}
