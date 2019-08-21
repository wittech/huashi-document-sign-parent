package com.louis.kitty.admin.office;

import com.louis.kitty.admin.constants.DocConstants;
import com.louis.kitty.admin.constants.LoanConstants;
import com.louis.kitty.admin.model.DocCommonModel;
import com.louis.kitty.admin.model.Pawn;
import com.louis.kitty.admin.model.RelatedPersonnelInformation;
import com.louis.kitty.admin.sevice.PawnPersonnelMappingService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Slf4j
@Component
public class LenderRelationshipTool extends AbstractOfficeTool {

    @Autowired
    private PawnPersonnelMappingService pawnPersonnelMappingService;

    private void setRelationshipList(List<Map<String, Object>> relationshipList, Map<String, Object> variables) {
        StringBuilder data = new StringBuilder();

        for (int i = 0; i < relationshipList.size(); i++) {
            Map<String, Object> relationship = relationshipList.get(i);
            data.append("<Row ss:AutoFitHeight=\"0\" ss:Height=\"102\">\n" +
                    "    <Cell ss:StyleID=\"s65\"><Data ss:Type=\"Number\">" + (i + 1) + "</Data></Cell>\n" +
                    "    <Cell ss:StyleID=\"s65\"><Data ss:Type=\"String\">" + relationship.get("name") + "</Data></Cell>\n" +
                    "    <Cell ss:StyleID=\"s65\"><Data ss:Type=\"String\">" + relationship.get("relationship") + "</Data></Cell>\n" +
                    "    <Cell ss:StyleID=\"s70\"><Data ss:Type=\"String\" x:Ticked=\"1\">" + relationship.get("idcard") + "</Data></Cell>\n" +
                    "    <Cell ss:StyleID=\"s71\"><Data ss:Type=\"String\">" + relationship.get("address") + "</Data></Cell>\n" +
                    "    <Cell ss:StyleID=\"s65\"><Data ss:Type=\"Number\">" + relationship.get("mobile") + "</Data></Cell>\n" +
                    "    <Cell ss:StyleID=\"s66\"/>\n" +
                    "    <Cell ss:StyleID=\"s66\"/>\n" +
                    "    <Cell ss:StyleID=\"s66\"/>\n" +
                    "    <Cell ss:StyleID=\"s71\"><Data ss:Type=\"String\">" + relationship.get("remark") + "</Data></Cell>\n" +
                    "   </Row>");

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

        if (docCommonModel.getBorrower() != null) {
            relationshipList.add(relationship(docCommonModel.getBorrower().getName(),
                    "借款人本人", docCommonModel.getBorrower().getIdentityNumber(),
                    docCommonModel.getBorrower().getContactNumber(),
                    docCommonModel.getBorrower().getCurrentHomeAddress(),
                    getMortgageGoodsName(docCommonModel.getBorrower().getId())));
        }

        if (docCommonModel.getBorrowerCouple() != null) {
            relationshipList.add(relationship(docCommonModel.getBorrowerCouple().getName(),
                    "借款人配偶", docCommonModel.getBorrowerCouple().getIdentityNumber(),
                    docCommonModel.getBorrowerCouple().getContactNumber(),
                    docCommonModel.getBorrowerCouple().getCurrentHomeAddress(), ""));
        }

        Set<Long> existsIds = new HashSet<>();
        if (CollectionUtils.isNotEmpty(docCommonModel.getGuarantorList())) {
            for (RelatedPersonnelInformation relatedPersonnelInformation : docCommonModel.getGuarantorList()) {

                relationshipList.add(relationship(relatedPersonnelInformation.getName(),
                        LoanConstants.PersonnelType.getTitle(relatedPersonnelInformation.getType()),
                        relatedPersonnelInformation.getIdentityNumber(),
                        relatedPersonnelInformation.getContactNumber(),
                        relatedPersonnelInformation.getCurrentHomeAddress(), ""));

                existsIds.add(relatedPersonnelInformation.getId());
            }
        }

        if (CollectionUtils.isNotEmpty(docCommonModel.getMortgageGuarantorList())) {
            for (RelatedPersonnelInformation relatedPersonnelInformation : docCommonModel.getMortgageGuarantorList()) {
                if(existsIds.contains(relatedPersonnelInformation.getId())) {
                    log.info("relatedPersonnelInformation id [{}] has joined queue", relatedPersonnelInformation.getId());
                    continue;
                }

                relationshipList.add(relationship(relatedPersonnelInformation.getName(),
                        LoanConstants.PersonnelType.getTitle(relatedPersonnelInformation.getType()),
                        relatedPersonnelInformation.getIdentityNumber(),
                        relatedPersonnelInformation.getContactNumber(),
                        relatedPersonnelInformation.getCurrentHomeAddress(),
                        getMortgageGoodsName(relatedPersonnelInformation.getId())));
            }
        }

        setRelationshipList(relationshipList, variables);
    }

    private String getMortgageGoodsName(Long rpiId) {
        List<Pawn> list = pawnPersonnelMappingService.findByRpiId(rpiId);
        if (CollectionUtils.isEmpty(list)) {
            return "";
        }

        Set<String> mortgageGoodsName = new HashSet<>();
        for (Pawn pawn : list) {
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
