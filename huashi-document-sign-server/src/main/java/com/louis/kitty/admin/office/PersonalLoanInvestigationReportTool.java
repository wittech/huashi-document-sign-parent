package com.louis.kitty.admin.office;

import com.louis.kitty.admin.constants.DocConstants;
import com.louis.kitty.admin.dao.*;
import com.louis.kitty.admin.model.*;
import com.louis.kitty.admin.util.RmbUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

@Component
public class PersonalLoanInvestigationReportTool extends AbstractOfficeTool {

    @Resource
    private PersonalLoanSurveyReportMapper personalLoanSurveyReportMapper;
    @Resource
    private AssetTypeHousesMapper assetTypeHousesMapper;
    @Resource
    private AssetTypeLandMapper assetTypeLandMapper;
    @Resource
    private AssetTypeCarMapper assetTypeCarMapper;
    @Resource
    private AssetTypeOtherMapper assetTypeOtherMapper;
    @Resource
    private AssetTypeSecuritiesMapper assetTypeSecuritiesMapper;
    @Resource
    private HouseholdIncomeMapper householdIncomeMapper;

    private String setMaritalStatusCheck(Integer exists) {
        String existsDes;
        if (exists == null) {
            existsDes = "□已婚  □未婚";
        } else if (exists == 1) {
            existsDes = "☑已婚  □未婚";
        } else {
            existsDes = "□已婚  ☑未婚";
        }

        return existsDes;
    }

    private String setHealthStatus(Integer status) {
        String statusDes;
        if (status == null) {
            statusDes = "□较差    □一般    □健康";
        } else if (status == 1) {
            statusDes = "☑较差    □一般    □健康";
        } else if (status == 2) {
            statusDes = "□较差    ☑一般    □健康";
        } else {
            statusDes = "□较差    □一般    ☑健康";
        }

        return statusDes;
    }


    private String setRightOption(Integer right) {
        String rightDes;
        if (right == null) {
            rightDes = "□是  □否";
        } else if (right == 1) {
            rightDes = "☑是  □否";
        } else {
            rightDes = "□是  ☑否";
        }

        return rightDes;
    }

    private String setBorrowerConductOption(Integer right) {
        String rightDes;
        if (right == null) {
            rightDes = "□优良  □较好   □一般   □较差";
        } else if (right == 1) {
            rightDes = "☑优良  □较好   □一般   □较差";
        } else if (right == 2) {
            rightDes = "□优良  ☑较好   □一般   □较差";
        } else if (right == 3) {
            rightDes = "□优良  □较好   ☑一般   □较差";
        } else {
            rightDes = "□优良  □较好   □一般   ☑较差";
        }

        return rightDes;
    }

    private String setCredit(Integer credit, String continuousOverdue, String cumulativeOverdue,
                             String currentOverdueAmount) {
        String creditDes = "□无借款  □有借款，能按期还款无不良记录： □有逾期不良情况，连续逾期:   /  期，累计逾期:    /  期；当前逾期金额:    /   万元 ";
        if (credit == null) {
            return creditDes;
        }

        if (credit == 0) {
            creditDes = "☑无借款  □有借款，能按期还款无不良记录： □有逾期不良情况，连续逾期:   /  期，累计逾期:    /  期；当前逾期金额:    /   万元 ";
        } else if (credit == 1) {
            creditDes = String.format("□无借款  ☑有借款，能按期还款无不良记录： □有逾期不良情况，连续逾期:   %s  期，累计逾期:    %s  期；当前逾期金额:    %s   万元 ",
                    continuousOverdue, cumulativeOverdue, currentOverdueAmount);
        } else if (credit == 2) {
            creditDes = "□无借款  □有借款，能按期还款无不良记录： ☑有逾期不良情况，连续逾期:   /  期，累计逾期:    /  期；当前逾期金额:    /   万元 ";
        }

        return creditDes;
    }

    private String setExistsOption(Integer exists) {
        String existsDes;
        if (exists == null) {
            existsDes = "□有  □无";
        } else if (exists == 1) {
            existsDes = "☑有  □无";
        } else {
            existsDes = "□有  ☑无";
        }

        return existsDes;
    }

    private void setApplyFamilyHousesAndLandList(List<PostLoanNotImplemented> postLoanNotImplementedList, Map<String, Object> variables) {

        variables.put("applyFamilyHousesAndLandList", "");
    }

    private String getCircleNumber(int index) {
        index = index + 1;
        if (index == 1) {
            return "①";
        } else if (index == 2) {
            return "②";
        } else if (index == 3) {
            return "③";
        } else if (index == 4) {
            return "④";
        } else if (index == 5) {
            return "⑤";
        } else if (index == 6) {
            return "⑥";
        } else if (index == 7) {
            return "⑦";
        } else if (index == 8) {
            return "⑧";
        } else if (index == 9) {
            return "⑨";
        } else if (index == 10) {
            return "⑩";
        }

        return "";
    }

    /**
     * 获取房屋/土地/汽车/证券.... 前缀标题信息
     *
     * @param isBorrower 是否是借款人， 否则 保证人
     * @param isNeedSeq  是否需要序号，一般只第一条记录的时候才需要，第二条则无
     * @return 标题序号
     */
    private String getTitleSeq(boolean isBorrower, boolean isNeedSeq) {
        if (!isNeedSeq) {
            return "";
        }

        if (isBorrower) {
            return "2、";
        }

        return "（1）";
    }

    private String setTotalHouseText(boolean isBorrower, boolean isNeedSeq, int totalCount,
                                     double totalArea, int totalMoney) {
        return "<w:p>\n" +
                "  <w:pPr>\n" +
                "\t<w:spacing w:line=\"360\" w:lineRule=\"auto\"/>\n" +
                "\t<w:ind w:firstLine=\"19\" w:firstLineChars=\"8\"/>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "  </w:pPr>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>" + getTitleSeq(isBorrower, isNeedSeq) + "家庭名下房产共计：</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t  <w:u w:val=\"single\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>{{" + totalCount + "}}</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t xml:space=\"preserve\"> 套，总计面积：</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t  <w:u w:val=\"single\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>" + totalArea + "</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>㎡，总价值</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>：</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t  <w:u w:val=\"single\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>" + totalMoney + "</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>元：</w:t>\n" +
                "  </w:r>\n" +
                "</w:p>\n" +
                "<w:p>\n" +
                "  <w:pPr>\n" +
                "\t<w:spacing w:line=\"360\" w:lineRule=\"auto\"/>\n" +
                "\t<w:ind w:firstLine=\"19\" w:firstLineChars=\"8\"/>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "  </w:pPr>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>其中：</w:t>\n" +
                "  </w:r>\n" +
                "</w:p>";
    }

    private String setTotalLandText(boolean isBorrower, boolean isNeedSeq, int totalCount, double totalArea, int totalMoney) {
        return "<w:p>\n" +
                "  <w:pPr>\n" +
                "\t<w:spacing w:line=\"360\" w:lineRule=\"auto\"/>\n" +
                "\t<w:ind w:firstLine=\"19\" w:firstLineChars=\"8\"/>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "  </w:pPr>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>" + getTitleSeq(isBorrower, isNeedSeq) + "家庭名下房产共计：</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t  <w:u w:val=\"single\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>{{" + totalCount + "}}</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t xml:space=\"preserve\"> 套，总计面积：</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t  <w:u w:val=\"single\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>" + totalArea + "</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>㎡，总价值</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>：</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t  <w:u w:val=\"single\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>" + totalMoney + "</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>元：</w:t>\n" +
                "  </w:r>\n" +
                "</w:p>\n" +
                "<w:p>\n" +
                "  <w:pPr>\n" +
                "\t<w:spacing w:line=\"360\" w:lineRule=\"auto\"/>\n" +
                "\t<w:ind w:firstLine=\"19\" w:firstLineChars=\"8\"/>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "  </w:pPr>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>其中：</w:t>\n" +
                "  </w:r>\n" +
                "</w:p>";
    }

    private String setTotalCarText(boolean isBorrower, boolean isNeedSeq, int totalCount, int totalMoney) {
        return "<w:p>\n" +
                "  <w:pPr>\n" +
                "\t<w:spacing w:line=\"360\" w:lineRule=\"auto\"/>\n" +
                "\t<w:ind w:firstLine=\"19\" w:firstLineChars=\"8\"/>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "  </w:pPr>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>" + getTitleSeq(isBorrower, isNeedSeq) + "家庭名下</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t  <w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>汽车</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>共计：</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t  <w:u w:val=\"single\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>" + totalCount + "</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t xml:space=\"preserve\"> </w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t  <w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>辆</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>，总价值</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>：</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t  <w:u w:val=\"single\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>" + totalMoney + "</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>元：</w:t>\n" +
                "  </w:r>\n" +
                "</w:p>\n" +
                "<w:p>\n" +
                "  <w:pPr>\n" +
                "\t<w:spacing w:line=\"360\" w:lineRule=\"auto\"/>\n" +
                "\t<w:ind w:firstLine=\"19\" w:firstLineChars=\"8\"/>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "  </w:pPr>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>其中：</w:t>\n" +
                "  </w:r>\n" +
                "</w:p>";
    }

    private String setTotalSecuritiesText(boolean isBorrower, boolean isNeedSeq, int totalCount, int totalMoney) {
        return "<w:p>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t  <w:lang w:eastAsia=\"zh-CN\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:br w:type=\"textWrapping\"/>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>" + getTitleSeq(isBorrower, isNeedSeq) + "家庭名下</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t  <w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>有价证券</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>共计：</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t  <w:u w:val=\"single\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>" + totalCount + "</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t xml:space=\"preserve\"> </w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t  <w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>个</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>，总价值</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>：</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t  <w:u w:val=\"single\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>" + totalMoney + "</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>元：</w:t>\n" +
                "  </w:r>\n" +
                "</w:p>\n" +
                "<w:p>\n" +
                "  <w:pPr>\n" +
                "\t<w:spacing w:line=\"360\" w:lineRule=\"auto\"/>\n" +
                "\t<w:ind w:firstLine=\"19\" w:firstLineChars=\"8\"/>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "  </w:pPr>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>其中：</w:t>\n" +
                "  </w:r>\n" +
                "</w:p>";
    }

    private String setTotalOtherText(boolean isBorrower, boolean isNeedSeq, int totalCount, int totalMoney) {
        return "<w:p>\n" +
                "  <w:pPr>\n" +
                "\t<w:spacing w:line=\"360\" w:lineRule=\"auto\"/>\n" +
                "\t<w:ind w:firstLine=\"19\" w:firstLineChars=\"8\"/>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "  </w:pPr>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>" + getTitleSeq(isBorrower, isNeedSeq) + "家庭名下</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t  <w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>其他资产</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>共计：</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t  <w:u w:val=\"single\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>" + totalCount + "</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t xml:space=\"preserve\"> </w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t  <w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>个</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>，总价值</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>：</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t  <w:u w:val=\"single\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>" + totalMoney + "</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>元：</w:t>\n" +
                "  </w:r>\n" +
                "</w:p>\n" +
                "<w:p>\n" +
                "  <w:pPr>\n" +
                "\t<w:spacing w:line=\"360\" w:lineRule=\"auto\"/>\n" +
                "\t<w:ind w:firstLine=\"19\" w:firstLineChars=\"8\"/>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "  </w:pPr>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>其中：</w:t>\n" +
                "  </w:r>\n" +
                "</w:p>";
    }

    private String hasText(Integer yes) {
        if (yes == null) {
            return "";
        } else if (yes == 1) {
            return "有";
        } else {
            return "无";
        }
    }

    private String getNumber(AssetTypeHouses assetTypeHouses) {
        if (assetTypeHouses == null) {
            return "";
        }

        String number = "";
        if (StringUtils.isNotEmpty(assetTypeHouses.getPropertyCertificateNumber())) {
            number += assetTypeHouses.getPropertyCertificateNumber() + "、";
        }

        if (StringUtils.isNotEmpty(assetTypeHouses.getDeed())) {
            number += assetTypeHouses.getDeed() + "、";
        }

        if (StringUtils.isNotEmpty(assetTypeHouses.getLandCertificate())) {
            number += assetTypeHouses.getLandCertificate() + "、";
        }

        if (StringUtils.isEmpty(number)) {
            return "";
        }

        return number.substring(0, number.length() - 1);

    }

//    private String sss(AssetTypeHouses assetTypeHouses) {
//         if (assetTypeHouses.getWhetherOwnershipCertificates() == 1) {
//            return "有";
//        } else {
//            return "无";
//        }
//    }

    private String setHouseText(int index, AssetTypeHouses assetTypeHouses) {
        if (assetTypeHouses == null) {
            return "";
        }

        return "<w:p>\n" +
                "  <w:pPr>\n" +
                "\t<w:spacing w:line=\"360\" w:lineRule=\"auto\"/>\n" +
                "\t<w:ind w:firstLine=\"19\" w:firstLineChars=\"8\"/>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "  </w:pPr>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>" + getCircleNumber(index) + "位于：</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t  <w:u w:val=\"single\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>" + assetTypeHouses.getAddress() + "</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>，面积:</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t  <w:u w:val=\"single\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t xml:space=\"preserve\">  " + assetTypeHouses.getConstructionArea() + "  </w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>㎡，价值:</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t  <w:u w:val=\"single\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t xml:space=\"preserve\"> " + assetTypeHouses.getValue() + " </w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>元，产权所有权人姓名：</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t  <w:u w:val=\"single\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t xml:space=\"preserve\"> </w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:bCs/>\n" +
                "\t  <w:color w:val=\"000000\"/>\n" +
                "\t  <w:kern w:val=\"0\"/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t  <w:szCs w:val=\"24\"/>\n" +
                "\t  <w:u w:val=\"single\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>" + assetTypeHouses.getCoOwnerName() + "</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t  <w:u w:val=\"single\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t xml:space=\"preserve\">  </w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t xml:space=\"preserve\"> 融资情况:</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t  <w:u w:val=\"single\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t xml:space=\"preserve\"> " + hasText(assetTypeHouses.getFinancingSituation()) + " </w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>，租赁使用情况:</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t  <w:u w:val=\"single\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t xml:space=\"preserve\"> " + hasText(assetTypeHouses.getWhetherLease()) + " </w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>；</w:t>\n" +
                "  </w:r>\n" +
                "</w:p>\n" +
                "<w:p>\n" +
                "  <w:pPr>\n" +
                "\t<w:spacing w:line=\"360\" w:lineRule=\"auto\"/>\n" +
                "\t<w:ind w:firstLine=\"19\" w:firstLineChars=\"8\"/>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "  </w:pPr>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>产权证号：</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t  <w:u w:val=\"single\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t xml:space=\"preserve\"> " + getNumber(assetTypeHouses) + "  </w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>。</w:t>\n" +
                "  </w:r>\n" +
                "</w:p>";
    }

    private String setLandText(int index, AssetTypeLand assetTypeLand) {
        if (assetTypeLand == null) {
            return "";
        }

        return "<w:p>\n" +
                "  <w:pPr>\n" +
                "\t<w:spacing w:line=\"360\" w:lineRule=\"auto\"/>\n" +
                "\t<w:ind w:firstLine=\"19\" w:firstLineChars=\"8\"/>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "  </w:pPr>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>" + getCircleNumber(index) + "位于：</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t  <w:u w:val=\"single\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>" + assetTypeLand.getAddress() + "</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>，面积:</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t  <w:u w:val=\"single\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t xml:space=\"preserve\">  " + assetTypeLand.getConstructionArea() + "  </w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>㎡，价值:</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t  <w:u w:val=\"single\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t xml:space=\"preserve\"> " + assetTypeLand.getValue() + " </w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>元，产权所有权人姓名：</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t  <w:u w:val=\"single\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t xml:space=\"preserve\"> </w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:cs=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:bCs/>\n" +
                "\t  <w:color w:val=\"000000\"/>\n" +
                "\t  <w:kern w:val=\"0\"/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t  <w:szCs w:val=\"24\"/>\n" +
                "\t  <w:u w:val=\"single\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>" + assetTypeLand.getCoOwnerName() + "</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t  <w:u w:val=\"single\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t xml:space=\"preserve\">  </w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t xml:space=\"preserve\"> 融资情况:</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t  <w:u w:val=\"single\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t xml:space=\"preserve\"> " + hasText(assetTypeLand.getFinancingSituation()) + " </w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>，租赁使用情况:</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t  <w:u w:val=\"single\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t xml:space=\"preserve\"> " + hasText(assetTypeLand.getWhetherLease()) + " </w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>；</w:t>\n" +
                "  </w:r>\n" +
                "</w:p>\n" +
                "<w:p>\n" +
                "  <w:pPr>\n" +
                "\t<w:spacing w:line=\"360\" w:lineRule=\"auto\"/>\n" +
                "\t<w:ind w:firstLine=\"19\" w:firstLineChars=\"8\"/>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "  </w:pPr>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>产权证号：</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t  <w:u w:val=\"single\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t xml:space=\"preserve\"> " + assetTypeLand.getLandCertificate() + "  </w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>。</w:t>\n" +
                "  </w:r>\n" +
                "</w:p>";
    }

    private String setCarText(int index, AssetTypeCar assetTypeCar) {
        if (assetTypeCar == null) {
            return "";
        }

        return "<w:p>\n" +
                "  <w:pPr>\n" +
                "\t<w:spacing w:line=\"360\" w:lineRule=\"auto\"/>\n" +
                "\t<w:ind w:firstLine=\"19\" w:firstLineChars=\"8\"/>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "  </w:pPr>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>" + getCircleNumber(index) + "</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t  <w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>汽车品牌</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>：</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t  <w:u w:val=\"single\"/>\n" +
                "\t  <w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>" + assetTypeCar.getBrand() + "</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>，</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t  <w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>车牌号</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>:</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t  <w:u w:val=\"single\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t xml:space=\"preserve\">  </w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t  <w:u w:val=\"single\"/>\n" +
                "\t  <w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>" + assetTypeCar.getNumberPlate() + "</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t  <w:u w:val=\"single\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t xml:space=\"preserve\">  </w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>，行驶证号:</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t  <w:u w:val=\"single\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t xml:space=\"preserve\">  " + assetTypeCar.getDrivingLicenseNumber() + "  </w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t  <w:lang w:eastAsia=\"zh-CN\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>，</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>价值:</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t  <w:u w:val=\"single\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t xml:space=\"preserve\"> " + assetTypeCar.getValue() + " </w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>元</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t  <w:lang w:eastAsia=\"zh-CN\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>；</w:t>\n" +
                "  </w:r>\n" +
                "</w:p>";
    }

    private String setSecuritiesText(int index, AssetTypeSecurities assetTypeSecurities) {
        if (assetTypeSecurities == null) {
            return "";
        }

        return "<w:p>\n" +
                "  <w:pPr>\n" +
                "\t<w:spacing w:line=\"360\" w:lineRule=\"auto\"/>\n" +
                "\t<w:ind w:firstLine=\"19\" w:firstLineChars=\"8\"/>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t  <w:lang w:eastAsia=\"zh-CN\"/>\n" +
                "\t</w:rPr>\n" +
                "  </w:pPr>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>" + getCircleNumber(index) + "</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t  <w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>证券类型</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>：</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t  <w:u w:val=\"single\"/>\n" +
                "\t  <w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t xml:space=\"preserve\"> " + assetTypeSecurities.getType() + " </w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>，价值:</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t  <w:u w:val=\"single\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t xml:space=\"preserve\"> " + assetTypeSecurities.getValue() + " </w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>元</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t  <w:lang w:eastAsia=\"zh-CN\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>；</w:t>\n" +
                "  </w:r>\n" +
                "</w:p>";
    }

    private String setOtherText(int index, AssetTypeOther assetTypeOther) {
        if (assetTypeOther == null) {
            return "";
        }

        return "<w:p>\n" +
                "  <w:pPr>\n" +
                "\t<w:spacing w:line=\"360\" w:lineRule=\"auto\"/>\n" +
                "\t<w:ind w:firstLine=\"19\" w:firstLineChars=\"8\"/>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t  <w:lang w:eastAsia=\"zh-CN\"/>\n" +
                "\t</w:rPr>\n" +
                "  </w:pPr>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>" + getCircleNumber(index) + "</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t  <w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>资产名称</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>：</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t  <w:u w:val=\"single\"/>\n" +
                "\t  <w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t xml:space=\"preserve\"> " + assetTypeOther.getAssetName() + " </w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>，价值:</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t  <w:u w:val=\"single\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t xml:space=\"preserve\"> " + assetTypeOther.getValue() + " </w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>元</w:t>\n" +
                "  </w:r>\n" +
                "  <w:r>\n" +
                "\t<w:rPr>\n" +
                "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                "\t  <w:b/>\n" +
                "\t  <w:sz w:val=\"24\"/>\n" +
                "\t  <w:lang w:eastAsia=\"zh-CN\"/>\n" +
                "\t</w:rPr>\n" +
                "\t<w:t>；</w:t>\n" +
                "  </w:r>\n" +
                "</w:p>";
    }

    private double getDoubleValue(String value) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return 0d;
        }
    }

    private PersonalLoanSurveyReport getPersonalLoanSurveyReport(DocCommonModel docCommonModel) {
        return personalLoanSurveyReportMapper.findByBasisId(docCommonModel.getLoanBasicId());
    }

    private String setAssetsHouse(boolean isBorrower, boolean isNeedSeq, List<RelatedPersonnelInformation> relatedPersonnelInformationList) {
        // 总个数
        int totalCount = 0;
        // 总面积
        double totalArea = 0;
        // 总金额（元）
        int totalMoney = 0;
        StringBuilder detailListText = new StringBuilder();
        int index = 0;
        for (RelatedPersonnelInformation relatedPersonnelInformation : relatedPersonnelInformationList) {
            List<AssetTypeHouses> assetTypeHousesList = assetTypeHousesMapper.findByRpiId(relatedPersonnelInformation.getId());
            for (AssetTypeHouses assetTypeHouses : assetTypeHousesList) {
                if (assetTypeHouses == null) {
                    continue;
                }

                totalCount += 1;
                totalArea += getDoubleValue(assetTypeHouses.getConstructionArea());
                totalMoney += getDoubleValue(assetTypeHouses.getValue());

                detailListText.append(setHouseText(index, assetTypeHouses));

                index++;

            }
        }

        if (totalCount == 0) {
            return "";
        }

        String totalText = setTotalHouseText(isBorrower, isNeedSeq, totalCount, totalArea, totalMoney);

        return totalText + detailListText;

    }

    private String setAssetsLand(boolean isBorrower, boolean isNeedSeq, List<RelatedPersonnelInformation> relatedPersonnelInformationList) {
        // 总个数
        int totalCount = 0;
        // 总面积
        double totalArea = 0;
        // 总金额（元）
        int totalMoney = 0;
        StringBuilder detailListText = new StringBuilder();
        int index = 0;
        for (RelatedPersonnelInformation relatedPersonnelInformation : relatedPersonnelInformationList) {
            List<AssetTypeLand> assetTypeLandList = assetTypeLandMapper.findByRpiId(relatedPersonnelInformation.getId());
            for (AssetTypeLand assetTypeLand : assetTypeLandList) {
                if (assetTypeLand == null) {
                    continue;
                }

                totalCount += 1;
                totalArea += getDoubleValue(assetTypeLand.getValue());
                totalMoney += getDoubleValue(assetTypeLand.getConstructionArea());

                detailListText.append(setLandText(index, assetTypeLand));

                index++;

            }
        }

        if (totalCount == 0) {
            return "";
        }

        String totalText = setTotalLandText(isBorrower, isNeedSeq, totalCount, totalArea, totalMoney);

        return totalText + detailListText;

    }

    private String setAssetsCar(boolean isBorrower, boolean isNeedSeq, List<RelatedPersonnelInformation> relatedPersonnelInformationList) {
        // 总个数
        int totalCount = 0;
        // 总金额（元）
        int totalMoney = 0;
        StringBuilder detailListText = new StringBuilder();
        int index = 0;
        for (RelatedPersonnelInformation relatedPersonnelInformation : relatedPersonnelInformationList) {
            List<AssetTypeCar> assetTypeCarList = assetTypeCarMapper.findByRpiId(relatedPersonnelInformation.getId());
            for (AssetTypeCar assetTypeCar : assetTypeCarList) {
                if (assetTypeCar == null) {
                    continue;
                }

                totalCount += 1;
                totalMoney += getDoubleValue(assetTypeCar.getValue());

                detailListText.append(setCarText(index, assetTypeCar));

                index++;

            }
        }

        if (totalCount == 0) {
            return "";
        }

        String totalText = setTotalCarText(isBorrower, isNeedSeq, totalCount, totalMoney);

        return totalText + detailListText;

    }

    private String setAssetsSecurities(boolean isBorrower, boolean isNeedSeq, List<RelatedPersonnelInformation> relatedPersonnelInformationList) {
        // 总个数
        int totalCount = 0;
        // 总金额（元）
        int totalMoney = 0;
        StringBuilder detailListText = new StringBuilder();
        int index = 0;
        for (RelatedPersonnelInformation relatedPersonnelInformation : relatedPersonnelInformationList) {
            List<AssetTypeSecurities> assetTypeSecuritiesList = assetTypeSecuritiesMapper.findByRpiId(relatedPersonnelInformation.getId());
            for (AssetTypeSecurities assetTypeSecurities : assetTypeSecuritiesList) {
                if (assetTypeSecurities == null) {
                    continue;
                }

                totalCount += 1;
                totalMoney += getDoubleValue(assetTypeSecurities.getValue());

                detailListText.append(setSecuritiesText(index, assetTypeSecurities));

                index++;

            }
        }

        if (totalCount == 0) {
            return "";
        }

        String totalText = setTotalSecuritiesText(isBorrower, isNeedSeq, totalCount, totalMoney);

        return totalText + detailListText;

    }

    private String setAssetsOther(boolean isBorrower, boolean isNeedSeq, List<RelatedPersonnelInformation> relatedPersonnelInformationList) {
        // 总个数
        int totalCount = 0;
        // 总金额（元）
        int totalMoney = 0;
        StringBuilder detailListText = new StringBuilder();
        int index = 0;
        for (RelatedPersonnelInformation relatedPersonnelInformation : relatedPersonnelInformationList) {
            List<AssetTypeOther> assetTypeOtherList = assetTypeOtherMapper.findByRpiId(relatedPersonnelInformation.getId());
            for (AssetTypeOther assetTypeOther : assetTypeOtherList) {
                if (assetTypeOther == null) {
                    continue;
                }

                totalCount += 1;
                totalMoney += getDoubleValue(assetTypeOther.getValue());

                detailListText.append(setOtherText(index, assetTypeOther));

                index++;

            }
        }

        if (totalCount == 0) {
            return "";
        }

        String totalText = setTotalCarText(isBorrower, isNeedSeq, totalCount, totalMoney);

        return totalText + detailListText;

    }

    /**
     * 设置 资产信息
     *
     * @param isBorrower                      是否为借款人， 否则为保全人
     * @param relatedPersonnelInformationList 相关人信息列表
     * @return 最终组成的数据
     */
    private String setAssetsInfo(boolean isBorrower, List<RelatedPersonnelInformation> relatedPersonnelInformationList) {
        boolean isNeedSeq = true;
        StringBuilder data = new StringBuilder();
        String assetsHouse = setAssetsHouse(isBorrower, isNeedSeq, relatedPersonnelInformationList);
        if (StringUtils.isNotEmpty(assetsHouse)) {
            isNeedSeq = false;
            data.append(assetsHouse);
        }

        String assetsLand = setAssetsLand(isBorrower, isNeedSeq, relatedPersonnelInformationList);
        if (StringUtils.isNotEmpty(assetsLand)) {
            isNeedSeq = false;
            data.append(assetsLand);
        }

        String assetsCar = setAssetsCar(isBorrower, isNeedSeq, relatedPersonnelInformationList);
        if (StringUtils.isNotEmpty(assetsCar)) {
            isNeedSeq = false;
            data.append(assetsCar);
        }

        String assetsSecurities = setAssetsSecurities(isBorrower, isNeedSeq, relatedPersonnelInformationList);
        if (StringUtils.isNotEmpty(assetsSecurities)) {
            isNeedSeq = false;
            data.append(assetsSecurities);
        }

        String assetsOther = setAssetsOther(isBorrower, isNeedSeq, relatedPersonnelInformationList);
        if (StringUtils.isNotEmpty(assetsOther)) {
            data.append(assetsOther);
        }

        return data.toString();

    }

    @Override
    protected void fillVariable(DocCommonModel docCommonModel) {
        Map<String, Object> variables = newRound();

        PersonalLoanSurveyReport personalLoanSurveyReport = getPersonalLoanSurveyReport(docCommonModel);
        if (personalLoanSurveyReport == null) {
            return;
        }

        variables.put("applyPersonName", docCommonModel.getBorrower().getName());
        if (docCommonModel.getBorrowerCouple() != null) {
            variables.put("coupleName", docCommonModel.getBorrowerCouple().getName());
        }

        // 是否本地户口
        variables.put("whetherLocalHouseholdRegistration", setRightOption(isLocalHousehold(docCommonModel.getBorrower().getDomicile())));
        variables.put("currentHomeAddress", docCommonModel.getBorrower().getCurrentHomeAddress());

        List<RelatedPersonnelInformation> borrowerList = new ArrayList<>();
        borrowerList.add(docCommonModel.getBorrower());
        borrowerList.add(docCommonModel.getBorrowerCouple());

        // 借款人家庭资产信息
        variables.put("applyFamilyAssetsInfo", setAssetsInfo(true, borrowerList));

        variables.put("applyPersonMaritalStatusCheck", setMaritalStatusCheck(personalLoanSurveyReport.getMaritalStatus()));

        // 设置借贷人家庭资产统计信息
        setApplyFamilyAssetReport(docCommonModel, variables);

        variables.put("borrowerHealthStatus", setHealthStatus(personalLoanSurveyReport.getBorrowerHealthStatus()));
        // 其他需调查反映的情况
        variables.put("otherSurveyHappening", personalLoanSurveyReport.getOtherSurveyHappening());
        variables.put("borrowerWhetherHaveCivilAction", setRightOption(personalLoanSurveyReport.getBorrowerWhetherHaveCivilAction()));


        variables.put("amountLoan", docCommonModel.getApplyMoneyRMB());
        // 自筹资金
        variables.put("selfFunding", RmbUtil.rmb(personalLoanSurveyReport.getFamilyAssets()));

        // 借款期限
        variables.put("borrowingPeriod", docCommonModel.getLoanBusinessInformation().getApplicationPeriod());

        variables.put("loanAmountWhetherReasonable", setRightOption(personalLoanSurveyReport.getLoanAmountWhetherReasonable()));
        variables.put("loanTermWhetherReasonable", setRightOption(personalLoanSurveyReport.getLoanTermWhetherReasonable()));
        variables.put("useLoan", docCommonModel.getLoanBusinessInformation().getDescription());
        variables.put("repaymentSourceWhetherSufficientCheck", setRightOption(personalLoanSurveyReport.getRepaymentSourceWhetherSufficient()));

        // 公式（描述信息，页面直接输入）
        variables.put("borrowerRepayAbilityEstimate", personalLoanSurveyReport.getBorrowerRepayAbilityEstimate());
        // 贷款偿还能力是否与申请贷款额度相符：□是    □否
        variables.put("whetherAmountMatchCheck", setRightOption(personalLoanSurveyReport.getWhetherAmountMatch()));
        // 有无债务诉讼
        variables.put("withoutDebtLitigation", setExistsOption(personalLoanSurveyReport.getWithoutDebtLitigation()));


        // 借款人品行：□优良  □较好   □一般   □较差
        variables.put("borrowerConduct", setBorrowerConductOption(personalLoanSurveyReport.getBorrowerConduct()));

        // 借款人资信
        variables.put("borrowerCredit", setCredit(personalLoanSurveyReport.getBorrowerCredit(),
                personalLoanSurveyReport.getContinuousOverdue(), personalLoanSurveyReport.getCumulativeOverdue(),
                personalLoanSurveyReport.getCurrentOverdueAmount()));

        // 金融机构借款余额
        variables.put("financialMechanismLoanBalance", personalLoanSurveyReport.getFinancialMechanismLoanBalance());

        // 信用卡授信总额
        variables.put("creditCardLumpSum", personalLoanSurveyReport.getCreditCardLumpSum());

        variables.put("usedQuota", personalLoanSurveyReport.getOtherSurveyHappening());
        // 对外担保余额
        variables.put("externalGuaranteeBalance", personalLoanSurveyReport.getExternalGuaranteeBalance());
        // 对外担保不良贷款余额
        variables.put("badLoanBalance", personalLoanSurveyReport.getBadLoanBalance());

        // 1、贷款方式为保证担保：
        // 贷款方式为保证担保
        variables.put("loanMethodGuaranteeCheck", docCommonModel.isContainsGuarantee() ? "☑" : "□");

        // 保证担保人资产信息
        variables.put("guaranteeAssetsInfo", setAssetsInfo(false, docCommonModel.getGuarantorList()));

        // 设置担保家庭总资产统计信息
        setGuaranteeAssetReport(docCommonModel, variables);


        // 2、贷款方式为抵（质）押担保：
        variables.put("loanMethodPledgeGuaranteeCheck", docCommonModel.isContainsMortgage() ? "☑" : "□");

        // 抵押物信息
        setPawnList(docCommonModel, variables);

        variables.put("applyMoneyRMB", docCommonModel.getApplyMoneyRMB());
        // 贷款期限
        variables.put("deadlineMonthNUM", docCommonModel.getLoanBusinessInformation().getApplicationPeriod());
        variables.put("applyRate", docCommonModel.getLoanBusinessInformation().getApplicationRate());
        variables.put("payBackMethod", getRepayment(docCommonModel.getLoanBusinessInformation().getRepayment(),
                docCommonModel.getLoanBusinessInformation().getValue()));
    }

    private String getRepayment(Integer repayment, String otherValue) {
        if (repayment == null) {
            return "";
        }

        if (repayment == 1) {
            return "利随本清";
        } else if (repayment == 2) {
            return "按月结息，到期一次性还本";
        } else if (repayment == 3) {
            return "按月结息，分期还本";
        } else if (repayment == 4) {
            return "按季结息，分期还本";
        } else if (repayment == 5) {
            return "等额本金";
        } else if (repayment == 6) {
            return "等额本息";
        } else if (repayment == 7) {
            return otherValue;
        }

        return "";
    }

    private void setPawnList(DocCommonModel model, Map<String, Object> variables) {
        if (CollectionUtils.isEmpty(model.getPawnList())) {
            return;
        }

        StringBuilder data = new StringBuilder();
        int index = 1;
        for (Pawn pawn : model.getPawnList()) {
            Map<Integer, String> startTime = getCalendar(pawn.getLeaseTermStartTime());
            Map<Integer, String> endTime = getCalendar(pawn.getLeaseTermEndTime());

            data.append("<w:p>\n" +
                    "  <w:pPr>\n" +
                    "\t<w:spacing w:line=\"360\" w:lineRule=\"auto\"/>\n" +
                    "\t<w:ind w:firstLine=\"241\" w:firstLineChars=\"100\"/>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"default\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t  <w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                    "\t</w:rPr>\n" +
                    "  </w:pPr>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t  <w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t>2</w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t  <w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t>." + index + "、</w:t>\n" +
                    "  </w:r>\n" +
                    "</w:p>\n" +
                    "<w:p>\n" +
                    "  <w:pPr>\n" +
                    "\t<w:spacing w:line=\"360\" w:lineRule=\"auto\"/>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t  <w:u w:val=\"single\"/>\n" +
                    "\t</w:rPr>\n" +
                    "  </w:pPr>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t>（1）抵（质）押物名称：</w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t  <w:u w:val=\"single\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t xml:space=\"preserve\"> " + pawn.getMortgageType() + " </w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t>，抵（质）押物权属人姓名：</w:t>\n" +
                    "  </w:r>\n" +
                    "  \n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t  <w:u w:val=\"single\"/>\n" +
                    "\t  <w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t xml:space=\"preserve\"> " + pawn.getOwners() + " </w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t>；</w:t>\n" +
                    "  </w:r>\n" +
                    "</w:p>\n" +
                    "<w:p>\n" +
                    "  <w:pPr>\n" +
                    "\t<w:spacing w:line=\"360\" w:lineRule=\"auto\"/>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t</w:rPr>\n" +
                    "  </w:pPr>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t>（2）抵（质）押物地理位置:</w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t  <w:u w:val=\"single\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t xml:space=\"preserve\"> </w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t  <w:u w:val=\"single\"/>\n" +
                    "\t  <w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t xml:space=\"preserve\">" + pawn.getCollateralDeposit() + "</w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t>；</w:t>\n" +
                    "  </w:r>\n" +
                    "</w:p>\n" +
                    "<w:p>\n" +
                    "  <w:pPr>\n" +
                    "\t<w:spacing w:line=\"360\" w:lineRule=\"auto\"/>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t  <w:u w:val=\"single\"/>\n" +
                    "\t</w:rPr>\n" +
                    "  </w:pPr>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t>（3）抵（质）押物证号：</w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t  <w:u w:val=\"single\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t xml:space=\"preserve\"> </w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t  <w:u w:val=\"single\"/>\n" +
                    "\t  <w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t xml:space=\"preserve\"> </w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t  <w:u w:val=\"single\"/>\n" +
                    "\t  <w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t xml:space=\"preserve\"> " + getPawnNumberInfo(pawn) + " </w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t  <w:u w:val=\"single\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t xml:space=\"preserve\"> </w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t>；</w:t>\n" +
                    "  </w:r>\n" +
                    "</w:p>\n" +
                    "<w:p>\n" +
                    "  <w:pPr>\n" +
                    "\t<w:spacing w:line=\"360\" w:lineRule=\"auto\"/>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t</w:rPr>\n" +
                    "  </w:pPr>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t>（4）</w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t>经</w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t  <w:u w:val=\"single\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t xml:space=\"preserve\"> </w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t  <w:u w:val=\"single\"/>\n" +
                    "\t  <w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t xml:space=\"preserve\"> </w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t  <w:u w:val=\"single\"/>\n" +
                    "\t  <w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t xml:space=\"preserve\"> " + pawn.getEvaluationCorporation() + " </w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t  <w:u w:val=\"single\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t xml:space=\"preserve\"> </w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t>评估，估价为:</w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t  <w:u w:val=\"single\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t xml:space=\"preserve\"> </w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t  <w:u w:val=\"single\"/>\n" +
                    "\t  <w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t xml:space=\"preserve\"> </w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t  <w:u w:val=\"single\"/>\n" +
                    "\t  <w:lang w:val=\"en-US\" w:eastAsia=\"zh-CN\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t xml:space=\"preserve\"> " + pawn.getValue() + " </w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t  <w:u w:val=\"single\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t xml:space=\"preserve\"> </w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t>元， 估价是否合理：</w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t>□</w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t>是 □否；</w:t>\n" +
                    "  </w:r>\n" +
                    "</w:p>\n" +
                    "<w:p>\n" +
                    "  <w:pPr>\n" +
                    "\t<w:spacing w:line=\"360\" w:lineRule=\"auto\"/>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t</w:rPr>\n" +
                    "  </w:pPr>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t>（5）</w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t>抵（质）押物</w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t>是否具有变现能力：</w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t>□</w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t>是 □否</w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t>；</w:t>\n" +
                    "  </w:r>\n" +
                    "</w:p>\n" +
                    "<w:p>\n" +
                    "  <w:pPr>\n" +
                    "\t<w:spacing w:line=\"360\" w:lineRule=\"auto\"/>\n" +
                    "\t<w:jc w:val=\"left\"/>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t</w:rPr>\n" +
                    "  </w:pPr>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t>（6）抵（质）押物</w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t>是否已设立</w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t>抵（质）</w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t>押：</w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t xml:space=\"preserve\">□是 </w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t>□</w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t>否</w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t>；</w:t>\n" +
                    "  </w:r>\n" +
                    "</w:p>\n" +
                    "<w:p>\n" +
                    "  <w:pPr>\n" +
                    "\t<w:spacing w:line=\"360\" w:lineRule=\"auto\"/>\n" +
                    "\t<w:ind w:left=\"44\" w:leftChars=\"21\" w:firstLine=\"2\"/>\n" +
                    "\t<w:jc w:val=\"left\"/>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t</w:rPr>\n" +
                    "  </w:pPr>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t>（7）抵（质）押物</w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t>是否已出租：</w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t xml:space=\"preserve\">" + setRightOption(pawn.getWhetherLease()) + "</w:t>\n" +
                    "  </w:r>\n" +
                    "  \n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t>，租赁起止日期：自</w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t  <w:u w:val=\"single\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t xml:space=\"preserve\"> " + startTime.get(Calendar.YEAR) + " </w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t>年</w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t  <w:u w:val=\"single\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t xml:space=\"preserve\"> " + startTime.get(Calendar.MONTH) + " </w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t>月</w:t>\n" +
                    "  </w:r>\n" +
                    "</w:p>\n" +
                    "<w:p>\n" +
                    "  <w:pPr>\n" +
                    "\t<w:spacing w:line=\"360\" w:lineRule=\"auto\"/>\n" +
                    "\t<w:ind w:left=\"44\" w:leftChars=\"21\" w:firstLine=\"2\"/>\n" +
                    "\t<w:jc w:val=\"left\"/>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t</w:rPr>\n" +
                    "  </w:pPr>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t  <w:u w:val=\"single\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t xml:space=\"preserve\"> " + startTime.get(Calendar.DAY_OF_MONTH) + " </w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t>日至</w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t  <w:u w:val=\"single\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t xml:space=\"preserve\"> " + endTime.get(Calendar.YEAR) + " </w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t>年</w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t  <w:u w:val=\"single\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t xml:space=\"preserve\"> " + endTime.get(Calendar.MONTH) + " </w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t>月</w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t  <w:u w:val=\"single\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t xml:space=\"preserve\"> " + endTime.get(Calendar.DAY_OF_MONTH) + " </w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t>日止，月租金</w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t  <w:u w:val=\"single\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t xml:space=\"preserve\"> " + pawn.getRent() + " </w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t>元，租金支付方式：按</w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t>" + getPayMethodText(pawn.getRentPaymentMethod()) + "</w:t>\n" +
                    "  </w:r>\n" +
                    "  \n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t>支付，</w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t>是否签订四方协议：</w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"宋体\" w:hAnsi=\"宋体\" w:eastAsia=\"宋体\"/>\n" +
                    "\t  <w:b/>\n" +
                    "\t  <w:sz w:val=\"24\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t>" + getQuartetAgreementText() + "。</w:t>\n" +
                    "  </w:r>\n" +
                    "</w:p>");
            index++;
        }

        variables.put("pawnList", data.toString());
    }

    private String getQuartetAgreementText() {
        return "□是 □否";
    }

    private String getPayMethodText(Integer payMethod) {
        if (payMethod == null) {
            return "□月/□季/□半年/□年";
        }

        if (payMethod == 1) {
            return "☑月/□季/□半年/□年";
        } else if (payMethod == 2) {
            return "□月/☑季/□半年/□年";
        } else if (payMethod == 2) {
            return "□月/□季/☑半年/□年";
        } else if (payMethod == 2) {
            return "□月/□季/□半年/☑年";
        }

        return "□月/□季/□半年/□年";
    }

    private void setApplyFamilyAssetReport(DocCommonModel model, Map<String, Object> variables) {
        HouseholdIncome householdIncome = householdIncomeMapper.findByRpiId(model.getBorrower().getId());
        if (householdIncome != null) {
            // 家庭总资产
            variables.put("familyAssets", householdIncome.getTotalAssets());
            // 家庭总负债
            variables.put("householdDebt", householdIncome.getTotalLiability());

            // 家庭总收入
            variables.put("annualHouseholdIncome", householdIncome.getTotalRevenue());
            // 家庭总支出
            variables.put("familyExpense", householdIncome.getTotalAnnualExpenditure());
        }
    }

    private double add(double total, Double current) {
        if (current == null) {
            return total;
        }

        return total + current;
    }

    private void setGuaranteeAssetReport(DocCommonModel model, Map<String, Object> variables) {
        if (CollectionUtils.isEmpty(model.getGuarantorList())) {
            return;
        }

        List<Long> rpiIds = new ArrayList<>();
        for (RelatedPersonnelInformation relatedPersonnelInformation : model.getGuarantorList()) {
            rpiIds.add(relatedPersonnelInformation.getId());
        }

        List<HouseholdIncome> list = householdIncomeMapper.findByRpiIds(rpiIds);
        if (CollectionUtils.isEmpty(list)) {
            return;
        }

        Double guaranteeAssets = 0d;
        Double guaranteeDebt = 0d;
        Double guaranteeAnnualHouseholdIncome = 0d;
        Double guaranteeExpense = 0d;
        Double guaranteeDebtTotalExpenditure = 0d;
        Double foreignGuaranteeLumpSum = 0d;
        for (HouseholdIncome householdIncome : list) {
            if (householdIncome == null) {
                continue;
            }

            guaranteeAssets = add(guaranteeAssets, householdIncome.getTotalAssets());
            guaranteeDebt = add(guaranteeDebt, householdIncome.getTotalLiability());
            guaranteeAnnualHouseholdIncome = add(guaranteeAnnualHouseholdIncome, householdIncome.getApplicantAnnualIncome());
            guaranteeExpense = add(guaranteeExpense, householdIncome.getTotalAnnualExpenditure());
            guaranteeDebtTotalExpenditure = add(guaranteeDebtTotalExpenditure, householdIncome.getDebtTotalExpenditure());
            foreignGuaranteeLumpSum = add(foreignGuaranteeLumpSum, householdIncome.getForeignGuaranteeLumpSum());
        }

        // 家庭总资产
        variables.put("guaranteeAssets", guaranteeAssets);
        // 家庭总负债
        variables.put("guaranteeDebt", guaranteeDebt);
        // 家庭总收入
        variables.put("guaranteeAnnualHouseholdIncome", guaranteeAnnualHouseholdIncome);
        // 家庭总支出
        variables.put("guaranteeExpense", guaranteeExpense);
        // 家庭年债务性支出
        variables.put("guaranteeDebtTotalExpenditure", guaranteeDebtTotalExpenditure);
        // 各类担保金额
        variables.put("foreignGuaranteeLumpSum", foreignGuaranteeLumpSum);


        // 自然人保证担保额度=3＊（年正常税后收入-年债务性支出-年生活保障支出）-已为他人提供的各类担保余额
        // result = 3*（allGuaranteeTotalRevenue - allGuaranteeTotalAnnualExpenditure  - allGuaranteeExpense）- allForeignGuaranteeLumpSum
        variables.put("allGuaranteeTotalRevenue", guaranteeAnnualHouseholdIncome);
        variables.put("allGuaranteeTotalAnnualExpenditure", guaranteeDebtTotalExpenditure);
        variables.put("allGuaranteeExpense", guaranteeExpense);
        variables.put("allForeignGuaranteeLumpSum", foreignGuaranteeLumpSum);

        double result = 3 * (guaranteeAnnualHouseholdIncome - guaranteeDebtTotalExpenditure - guaranteeExpense)
                - foreignGuaranteeLumpSum;
        variables.put("result", result);

        // 具有担保能力
//        variables.put("calculated", setRightOption(result > 0d ? 1 : 0));
        variables.put("calculated", setRightOption(null));
    }

    @Override
    protected String modelFileName() {
        return "个人贷款调查报告";
    }

    @Override
    protected int sort() {
        return 3_7_00;
    }

    @Override
    protected DocConstants.DocType docType() {
        return DocConstants.DocType.WORD;
    }
}
