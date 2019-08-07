package com.louis.kitty.admin.office;

import com.alibaba.druid.util.StringUtils;
import com.louis.kitty.admin.constants.DocConstants;
import com.louis.kitty.admin.util.RmbUtil;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Map;

@Component
public class CollateralNotRentGuaranteeTool extends AbstractOfficeTool {

    /**
     * @param applyPersonName   申请人姓名
     * @param applyPersonIdcard 申请人身份证号码
     * @param coupleName        配偶姓名
     * @param coupleIdcard      配偶身份证号码
     * @param collateralAddress 抵押物地址
     * @param collateralType    抵押物类型（房产/土地）
     * @param collateralNo      土地或房屋证号码
     * @param variables         变量信息
     */
    private void setNoLeaseInfo(String applyPersonName, String applyPersonIdcard,
                                String coupleName, String coupleIdcard, String collateralAddress,
                                String collateralType, String collateralNo,
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
                "  <w:t xml:space=\"preserve\"> " + applyPersonName + "（身份证号码：" + applyPersonIdcard + "）"
                + coupleName + "（身份证号码：" + coupleIdcard + "）名下位于：" + collateralAddress + "</w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\"/>\n" +
                "\t<w:sz w:val=\"30\"/>\n" +
                "\t<w:szCs w:val=\"30\"/>\n" +
                "\t<w:u w:val=\"none\"/>\n" +
                "\t<w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t>" + collateralType + "作抵押（" + collateralNo + "）</w:t>\n" +
                "</w:r>");

        variables.put("noLeaseInfo", data.toString());
    }

    @Override
    protected void fillVariable(Long basisLoanId) {
        Map<String, Object> variables = newRound();
        variables.put("applyFamilyPersonName", "罗永芳、唐建国");
        variables.put("applyMoney", "2000000.00");
        variables.put("applyMoneyRMB", RmbUtil.number2CNMontrayUnit(new BigDecimal(variables.get("applyMoney").toString())));


        setNoLeaseInfo("罗永芳", "510102196901118483", "唐建国",
                "45030519540601001X ", "秀峰区中山中路38号智能办公大厦五层503号办公用房", "房产",
                "房产证号为：桂林市房权证秀峰区字第30417489号、土地证号为：桂国用（2014）第301694号", variables);


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
        return "抵押物未出租承诺书";
    }

    @Override
    protected int sort() {
        return 1_7_0;
    }

    @Override
    protected DocConstants.DocType docType() {
        return DocConstants.DocType.WORD;
    }
}
