package com.louis.kitty.admin.office;

import com.louis.kitty.admin.constants.DocConstants;
import com.louis.kitty.admin.model.DocCommonModel;
import com.louis.kitty.admin.model.Pawn;
import com.louis.kitty.admin.model.RelatedPersonnelInformation;
import com.louis.kitty.admin.util.RmbUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Component
public class CollateralNotRentGuaranteeTool extends AbstractOfficeTool {

    private void setNoLeaseInfo(List<RelatedPersonnelInformation> relatedPersonnelInformationList,
                                String collateralAddress, String collateralType, String collateralNo,
                                Map<String, Object> variables) {
        StringBuilder data = new StringBuilder();
        data.append("<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\"/>\n" +
                "\t<w:b/>\n" +
                "\t<w:bCs/>\n" +
                "\t<w:sz w:val=\"30\"/>\n" +
                "\t<w:szCs w:val=\"30\"/>\n" +
                "\t<w:u w:val=\"single\"/>\n" +
                "\t<w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t xml:space=\"preserve\"> ");

        if (CollectionUtils.isEmpty(relatedPersonnelInformationList)) {
            data.append("       （身份证号码：                      ）");
        }

        for (RelatedPersonnelInformation relatedPersonnelInformation : relatedPersonnelInformationList) {
            data.append(relatedPersonnelInformation.getName() + "（身份证号码：" + relatedPersonnelInformation.getIdentityNumber() + "）");
        }

        data.append("</w:t>\n"
                +
                "</w:r>\n" +
                "<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\"/>\n" +
                "\t<w:sz w:val=\"30\"/>\n" +
                "\t<w:szCs w:val=\"30\"/>\n" +
                "\t<w:u w:val=\"none\"/>\n" +
                "\t<w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t>" + collateralType + "名下位于：" + collateralAddress + "作抵押（" + collateralNo + "）</w:t>\n" +
                "</w:r>");

        variables.put("noLeaseInfo", data.toString());
    }

    @Override
    protected void fillVariable(DocCommonModel docCommonModel) {
        for (Pawn pawn : docCommonModel.getPawnList()) {
            if (pawn.getWhetherLease() != 0) {
                continue;
            }

            Map<String, Object> variables = newRound();

            // 1.2. related_personnel_information相关人员信息表 type, 1和2拼接
            variables.put("applyFamilyPersonName", docCommonModel.getApplyFamilyName());

            // 1.11. loan_business_information贷款业务信息表
            variables.put("applyMoney", docCommonModel.getLoanBusinessInformation().getApplicationAmount());
            variables.put("applyMoneyRMB", RmbUtil.rmb(new BigDecimal(variables.get("applyMoney").toString())));

            setNoLeaseInfo(pawn.getRelatedPersonnelInformationList(), pawn.getCollateralDeposit(),
                    pawn.getMortgageType() == 0 ? "房屋" : "土地",
                    pawn.getCertificateNumberDes(), variables);

        }
    }

    @Override
    protected String modelFileName() {
        return "抵押物未出租承诺书";
    }

    @Override
    protected int sort() {
        return 1_7_00;
    }

    @Override
    protected DocConstants.DocType docType() {
        return DocConstants.DocType.WORD;
    }
}
