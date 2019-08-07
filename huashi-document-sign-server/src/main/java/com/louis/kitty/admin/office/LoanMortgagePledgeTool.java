package com.louis.kitty.admin.office;

import com.louis.kitty.admin.constants.DocConstants;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class LoanMortgagePledgeTool extends AbstractOfficeTool {

    private void setMortgageGoodsInfo(String applyFamilyPersonName, String applyMoneyRMB, String goodsOwner,
                                      String goodsType, Map<String, Object> variables) {
        StringBuilder data = new StringBuilder();
        data.append("<w:r>\n" +
                "<w:rPr>\n" +
                "  <w:rFonts w:hint=\"eastAsia\"/>\n" +
                "  <w:b/>\n" +
                "</w:rPr>\n" +
                "<w:t>兹因</w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "<w:rPr>\n" +
                "  <w:rFonts w:hint=\"eastAsia\"/>\n" +
                "  <w:b/>\n" +
                "  <w:u w:val=\"single\"/>\n" +
                "</w:rPr>\n" +
                "<w:t xml:space=\"preserve\"> </w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "<w:rPr>\n" +
                "  <w:rFonts w:hint=\"eastAsia\"/>\n" +
                "  <w:b/>\n" +
                "  <w:u w:val=\"single\"/>\n" +
                "  <w:lang w:eastAsia=\"zh-CN\"/>\n" +
                "</w:rPr>\n" +
                "<w:t>" + applyFamilyPersonName + "</w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "<w:rPr>\n" +
                "  <w:rFonts w:hint=\"eastAsia\"/>\n" +
                "  <w:b/>\n" +
                "</w:rPr>\n" +
                "<w:t>（借款人）向贵行申请抵（质）押贷款</w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "<w:rPr>\n" +
                "  <w:rFonts w:hint=\"eastAsia\"/>\n" +
                "  <w:b/>\n" +
                "  <w:u w:val=\"single\"/>\n" +
                "</w:rPr>\n" +
                "<w:t xml:space=\"preserve\"> </w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "<w:rPr>\n" +
                "  <w:rFonts w:hint=\"eastAsia\"/>\n" +
                "  <w:b/>\n" +
                "  <w:u w:val=\"single\"/>\n" +
                "  <w:lang w:eastAsia=\"zh-CN\"/>\n" +
                "</w:rPr>\n" +
                "<w:t>" + applyMoneyRMB + "</w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "<w:rPr>\n" +
                "  <w:rFonts w:hint=\"eastAsia\"/>\n" +
                "  <w:b/>\n" +
                "</w:rPr>\n" +
                "<w:t>元（人民币），以</w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "<w:rPr>\n" +
                "  <w:rFonts w:hint=\"eastAsia\"/>\n" +
                "  <w:b/>\n" +
                "  <w:u w:val=\"single\"/>\n" +
                "</w:rPr>\n" +
                "<w:t xml:space=\"preserve\"> </w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "<w:rPr>\n" +
                "  <w:rFonts w:hint=\"eastAsia\"/>\n" +
                "  <w:b/>\n" +
                "  <w:u w:val=\"single\"/>\n" +
                "  <w:lang w:eastAsia=\"zh-CN\"/>\n" +
                "</w:rPr>\n" +
                "<w:t>" + goodsOwner + "</w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "<w:rPr>\n" +
                "  <w:rFonts w:hint=\"eastAsia\"/>\n" +
                "  <w:b/>\n" +
                "</w:rPr>\n" +
                "<w:t>（抵质押人）名下位于</w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "<w:rPr>\n" +
                "  <w:rFonts w:hint=\"eastAsia\"/>\n" +
                "  <w:b/>\n" +
                "  <w:szCs w:val=\"22\"/>\n" +
                "  <w:u w:val=\"single\"/>\n" +
                "  <w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                "</w:rPr>\n" +
                "<w:t>" + variables.get("goodsAddress") + "</w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "<w:rPr>\n" +
                "  <w:rFonts w:hint=\"eastAsia\"/>\n" +
                "  <w:b/>\n" +
                "  <w:u w:val=\"single\"/>\n" +
                "</w:rPr>\n" +
                "<w:t xml:space=\"preserve\"> </w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "<w:rPr>\n" +
                "  <w:rFonts w:hint=\"eastAsia\"/>\n" +
                "  <w:b/>\n" +
                "</w:rPr>\n" +
                "<w:t>（抵（质）押物名称：</w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "<w:rPr>\n" +
                "  <w:rFonts w:hint=\"eastAsia\"/>\n" +
                "  <w:b/>\n" +
                "  <w:u w:val=\"single\"/>\n" +
                "</w:rPr>\n" +
                "<w:t xml:space=\"preserve\"> </w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "<w:rPr>\n" +
                "  <w:rFonts w:hint=\"eastAsia\"/>\n" +
                "  <w:b/>\n" +
                "  <w:u w:val=\"single\"/>\n" +
                "  <w:lang w:eastAsia=\"zh-CN\"/>\n" +
                "</w:rPr>\n" +
                "<w:t>" + goodsType + "</w:t>\n" +
                "</w:r>");

        variables.put("mortgageGoodsInfo", data.toString());
    }

    @Override
    protected void fillVariable(Long basisLoanId) {
        Map<String, Object> variables = newRound();
        variables.put("bankBranchName", "城北支行");
        variables.put("goodsAddress", "秀峰区中山中路38号智能办公大厦五层503、504号办公用房");
        variables.put("goodsValuationRMB", "叁佰零玖万叁仟叁佰元整");


        setMortgageGoodsInfo("罗永芳、唐建国", "贰佰万元",
                "罗永芳、唐建国", "房产、商铺", variables);
    }

    @Override
    protected String modelFileName() {
        return "借款抵（质）押承诺书";
    }

    @Override
    protected int sort() {
        return 2_1_0;
    }

    @Override
    protected DocConstants.DocType docType() {
        return DocConstants.DocType.WORD;
    }
}
