package com.louis.kitty.admin.office;

import com.alibaba.druid.util.StringUtils;
import com.louis.kitty.admin.constants.BankConstants;
import com.louis.kitty.admin.constants.DocConstants;
import com.louis.kitty.admin.model.DocCommonModel;
import com.louis.kitty.admin.model.Pawn;
import com.louis.kitty.admin.util.RmbUtil;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Map;

@Component
public class MortgageQuartetAgreementTool extends AbstractOfficeTool {

    /**
     * @param applyFamilyPersonName 甲方（借款方）
     * @param bankBranchName        乙方（贷款方）
     * @param tripartiteName        丙方（抵押方）
     * @param quartetName           丁方（承租方）
     * @param applyMoneyRMB         申请借款人民币(大写)
     * @param goodsAddress          丙方地址
     * @param goodsArea             丙方地址面积
     * @param startYear             借款期限开始年份
     * @param startMonth            借款期限开始月份
     * @param startDay              借款期限开始天
     * @param endYear               借款期限截止年份
     * @param endMonth              借款期限截止月份
     * @param endDay                借款期限截止天
     * @param secondStartYear       乙方同意丙方与丁方期限开始年份
     * @param secondStartMonth      乙方同意丙方与丁方期限开始月份
     * @param secondStartDay        乙方同意丙方与丁方期限开始天
     * @param secondEndYear         乙方同意丙方与丁方期限截止年份
     * @param secondEndMonth        乙方同意丙方与丁方期限截止月份
     * @param secondEndDay          乙方同意丙方与丁方期限截止天
     * @param secondMoneyRMB        乙方可直接收取丙方抵押给乙方房屋每月人民币（大写）
     * @param secondMoney           乙方可直接收取丙方抵押给乙方房屋每月人民币（小写）
     * @param variables             变量
     */
    private void setLeaseInfo(String applyFamilyPersonName, String bankBranchName, String tripartiteName, String quartetName,
                              String applyMoneyRMB, String goodsAddress, String goodsArea,
                              String startYear, String startMonth, String startDay, String endYear,
                              String endMonth, String endDay, String secondStartYear, String secondStartMonth,
                              String secondStartDay, String secondEndYear, String secondEndMonth, String secondEndDay,
                              String secondMoneyRMB, String secondMoney,
                              Map<String, Object> variables) {
        StringBuilder data = new StringBuilder();
        data.append("<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t<w:kern w:val=\"0\"/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t>丙方（抵押方）：</w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t<w:kern w:val=\"0\"/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "\t<w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t>" + tripartiteName + "</w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t<w:kern w:val=\"0\"/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t xml:space=\"preserve\">    </w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t<w:kern w:val=\"0\"/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "\t<w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t xml:space=\"preserve\"> </w:t>\n" +
                "</w:r>\n" +
                "</w:p>\n" +
                "<w:p>\n" +
                "<w:pPr>\n" +
                "  <w:widowControl/>\n" +
                "  <w:snapToGrid w:val=\"0\"/>\n" +
                "  <w:spacing w:line=\"500\" w:lineRule=\"exact\"/>\n" +
                "  <w:jc w:val=\"left\"/>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t<w:kern w:val=\"0\"/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "  </w:rPr>\n" +
                "</w:pPr>\n" +
                "<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t<w:kern w:val=\"0\"/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t>丁方（承租方）：" + quartetName + "</w:t>\n" +
                "</w:r>\n" +
                "</w:p>\n" +
                "<w:p>\n" +
                "<w:pPr>\n" +
                "  <w:widowControl/>\n" +
                "  <w:snapToGrid w:val=\"0\"/>\n" +
                "  <w:spacing w:line=\"500\" w:lineRule=\"exact\"/>\n" +
                "  <w:jc w:val=\"left\"/>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t<w:kern w:val=\"0\"/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "  </w:rPr>\n" +
                "</w:pPr>\n" +
                "</w:p>\n" +
                "<w:p>\n" +
                "<w:pPr>\n" +
                "  <w:widowControl/>\n" +
                "  <w:snapToGrid w:val=\"0\"/>\n" +
                "  <w:spacing w:line=\"600\" w:lineRule=\"exact\"/>\n" +
                "  <w:ind w:firstLine=\"480\" w:firstLineChars=\"200\"/>\n" +
                "  <w:jc w:val=\"left\"/>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t<w:kern w:val=\"0\"/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "  </w:rPr>\n" +
                "</w:pPr>\n" +
                "<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t<w:kern w:val=\"0\"/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t>因借款方</w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t<w:kern w:val=\"0\"/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "\t<w:u w:val=\"single\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t>　" + applyFamilyPersonName + "　</w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t<w:kern w:val=\"0\"/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t>（以下简称甲方）向贷款方</w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t<w:kern w:val=\"0\"/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "\t<w:u w:val=\"single\"/>\n" +
                "\t<w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t xml:space=\"preserve\"> 广</w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t<w:kern w:val=\"0\"/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "\t<w:u w:val=\"single\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t>西桂林漓江农村合作银行" + bankBranchName + "</w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t<w:kern w:val=\"0\"/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "\t<w:u w:val=\"single\"/>\n" +
                "\t<w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t xml:space=\"preserve\"> </w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t<w:kern w:val=\"0\"/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t>（以下简称乙方）申请借款人民币</w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t<w:kern w:val=\"0\"/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "\t<w:u w:val=\"single\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t>" + applyMoneyRMB + "元</w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t<w:kern w:val=\"0\"/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t>，期限从</w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t<w:kern w:val=\"0\"/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "\t<w:u w:val=\"single\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t> " + startYear + " </w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t<w:kern w:val=\"0\"/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t>年</w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t<w:kern w:val=\"0\"/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "\t<w:u w:val=\"single\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t xml:space=\"preserve\"> " + startMonth + " </w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t<w:kern w:val=\"0\"/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t>月</w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t<w:kern w:val=\"0\"/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "\t<w:u w:val=\"single\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t xml:space=\"preserve\"> " + startDay + " </w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t<w:kern w:val=\"0\"/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t>日到</w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t<w:kern w:val=\"0\"/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "\t<w:u w:val=\"single\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t> " + endYear + " </w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t<w:kern w:val=\"0\"/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t>年</w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t<w:kern w:val=\"0\"/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "\t<w:u w:val=\"single\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t xml:space=\"preserve\"> " + endMonth + " </w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t<w:kern w:val=\"0\"/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t>月</w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t<w:kern w:val=\"0\"/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "\t<w:u w:val=\"single\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t xml:space=\"preserve\"> " + endDay + " </w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t<w:kern w:val=\"0\"/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t>日，并用丙方位于</w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t<w:sz w:val=\"22\"/>\n" +
                "\t<w:szCs w:val=\"22\"/>\n" +
                "\t<w:u w:val=\"single\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t>" + goodsAddress + "，</w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t<w:kern w:val=\"0\"/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t>建筑面积约</w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t<w:kern w:val=\"0\"/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "\t<w:u w:val=\"single\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t>" + goodsArea + "</w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t<w:kern w:val=\"0\"/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t>平方米商铺作为抵押担保，经甲、乙、丙、丁四方共同协商一致，达成协议条款如下：</w:t>\n" +
                "</w:r>\n" +
                "</w:p>\n" +
                "<w:p>\n" +
                "<w:pPr>\n" +
                "  <w:widowControl/>\n" +
                "  <w:snapToGrid w:val=\"0\"/>\n" +
                "  <w:spacing w:line=\"600\" w:lineRule=\"exact\"/>\n" +
                "  <w:ind w:firstLine=\"480\" w:firstLineChars=\"200\"/>\n" +
                "  <w:jc w:val=\"left\"/>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t<w:kern w:val=\"0\"/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "  </w:rPr>\n" +
                "</w:pPr>\n" +
                "<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t<w:kern w:val=\"0\"/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t>一、乙方同意丙方与丁方于</w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t<w:kern w:val=\"0\"/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "\t<w:u w:val=\"single\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t xml:space=\"preserve\"> " + secondStartYear + " </w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t<w:kern w:val=\"0\"/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t>年</w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t<w:kern w:val=\"0\"/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "\t<w:u w:val=\"single\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t xml:space=\"preserve\"> " + secondStartMonth + " </w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t<w:kern w:val=\"0\"/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t>月</w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t<w:kern w:val=\"0\"/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "\t<w:u w:val=\"single\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t xml:space=\"preserve\"> " + secondStartDay + " </w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t<w:kern w:val=\"0\"/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t>日签订的《房屋租赁合同》继续履行，直至</w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t<w:kern w:val=\"0\"/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "\t<w:u w:val=\"single\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t xml:space=\"preserve\"> " + secondEndYear + " </w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t<w:kern w:val=\"0\"/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t>年</w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t<w:kern w:val=\"0\"/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "\t<w:u w:val=\"single\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t xml:space=\"preserve\"> " + secondEndMonth + " </w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t<w:kern w:val=\"0\"/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t>月</w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t<w:kern w:val=\"0\"/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "\t<w:u w:val=\"single\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t xml:space=\"preserve\"> " + secondEndDay + " </w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t<w:kern w:val=\"0\"/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t>日该合同期满。</w:t>\n" +
                "</w:r>\n" +
                "<w:bookmarkStart w:id=\"0\" w:name=\"_GoBack\"/>\n" +
                "<w:bookmarkEnd w:id=\"0\"/>\n" +
                "</w:p>\n" +
                "<w:p>\n" +
                "<w:pPr>\n" +
                "  <w:widowControl/>\n" +
                "  <w:snapToGrid w:val=\"0\"/>\n" +
                "  <w:spacing w:line=\"600\" w:lineRule=\"exact\"/>\n" +
                "  <w:ind w:firstLine=\"480\" w:firstLineChars=\"200\"/>\n" +
                "  <w:jc w:val=\"left\"/>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t<w:kern w:val=\"0\"/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "  </w:rPr>\n" +
                "</w:pPr>\n" +
                "<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t<w:kern w:val=\"0\"/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t>二、甲方与乙方签订的借款合同（含延期还款协议）产生违约情形后，乙方可直接收取丙方抵押给乙方房屋每月</w:t>\n" +
                "</w:r>\n" +
                "<w:r>\n" +
                "  <w:rPr>\n" +
                "\t<w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t<w:kern w:val=\"0\"/>\n" +
                "\t<w:sz w:val=\"24\"/>\n" +
                "\t<w:u w:val=\"single\"/>\n" +
                "  </w:rPr>\n" +
                "  <w:t>" + secondMoneyRMB + "（¥" + secondMoney + "）</w:t>\n" +
                "</w:r>");

        variables.put("leaseInfo", data.toString());
    }

    @Override
    protected void fillVariable(DocCommonModel docCommonModel) {
        for (Pawn pawn : docCommonModel.getPawnList()) {
            // 判断是否已租赁，如果为空或者 状态为 未出租，则 不需要本次的 租赁四方协议
            if (pawn.getWhetherLease() == null || pawn.getWhetherLease() == 0) {
                continue;
            }

            Map<String, Object> variables = newRound();
            variables.put("bankBranchName", BankConstants.BANK_BRANCH_NAME);
            variables.put("applyFamilyPersonName", docCommonModel.getApplyFamilyName());

            Map<Integer, String> calendar = getCalendar(docCommonModel.getContractInformation().getBorrowingStartPeriod());

            Map<Integer, String> calendar1 = getCalendar(docCommonModel.getContractInformation().getBorrowingEndPeriod());

            Map<Integer, String> calendar2 = getCalendar(pawn.getLeaseTermStartTime());

            Map<Integer, String> calendar3 = getCalendar(pawn.getLeaseTermEndTime());

            setLeaseInfo(docCommonModel.getApplyFamilyName(), BankConstants.BANK_BRANCH_NAME,
                    pawn.getOwners(), pawn.getLesseeName(),
                    docCommonModel.getApplyMoneyRMB(), pawn.getCollateralDeposit(),
                    (pawn.getMortgageType() == 0 ? pawn.getBuildingArea() : pawn.getLandOccupationArea()),
                    calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH),
                    calendar1.get(Calendar.YEAR), calendar1.get(Calendar.MONTH), calendar1.get(Calendar.DAY_OF_MONTH),
                    calendar2.get(Calendar.YEAR), calendar2.get(Calendar.MONTH), calendar2.get(Calendar.DAY_OF_MONTH),
                    calendar3.get(Calendar.YEAR), calendar3.get(Calendar.MONTH), calendar3.get(Calendar.DAY_OF_MONTH),
                    StringUtils.isEmpty(pawn.getRent()) ? "   " : RmbUtil.rmb(new BigDecimal(pawn.getRent())),
                    pawn.getRent(), variables);
        }

    }

    @Override
    protected String modelFileName() {
        return "抵押房屋租赁四方协议书";
    }

    @Override
    protected int sort() {
        return 2_0_00;
    }

    @Override
    protected DocConstants.DocType docType() {
        return DocConstants.DocType.WORD;
    }

    @Override
    protected DocConstants.DocCategory category() {
        return DocConstants.DocCategory.SIGNATURE_MARK;
    }
}
