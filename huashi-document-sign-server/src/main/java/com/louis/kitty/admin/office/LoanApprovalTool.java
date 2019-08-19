package com.louis.kitty.admin.office;

import com.alibaba.druid.util.StringUtils;
import com.louis.kitty.admin.constants.BankConstants;
import com.louis.kitty.admin.constants.DocConstants;
import com.louis.kitty.admin.model.DocCommonModel;
import com.louis.kitty.admin.model.Pawn;
import com.louis.kitty.admin.model.RelatedPersonnelInformation;
import com.louis.kitty.admin.util.RmbUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 广西农村合作金融机构信贷业务呈批表
 */

@Component
public class LoanApprovalTool extends AbstractOfficeTool {

    @Override
    protected void fillVariable(DocCommonModel docCommonModel) {
        Map<String, Object> variables = newRound();
        variables.put("contractNo", "");
        variables.put("bankBranchName", BankConstants.BANK_BRANCH_NAME);
        variables.put("bankPhone", BankConstants.BANK_PHONE);

        // related_personnel_information
        variables.put("applyPersonName", docCommonModel.getBorrower().getName());

        // .11. loan_business_information贷款业务信息表  client_number客户号
        variables.put("applyPersonNo", docCommonModel.getLoanBusinessInformation().getClientNumber());

        // application_amount
        variables.put("applyMoney", docCommonModel.getLoanBusinessInformation().getApplicationAmount());

        // description
        variables.put("moneyUsage", docCommonModel.getLoanBusinessInformation().getDescription());

        variables.put("deadlineMonth", docCommonModel.getLoanBusinessInformation().getApplicationPeriod());
        variables.put("applyRate", docCommonModel.getLoanBusinessInformation().getApplicationRate() + "%");
        variables.put("marginRate", docCommonModel.getLoanBusinessInformation().getMarginRatio() + "%");
        variables.put("originBalance", docCommonModel.getLoanBusinessInformation().getOriginalCreditBalance());
        variables.put("applyMoneyRMB",
                RmbUtil.rmb(new BigDecimal(variables.get("applyMoney").toString())));
        variables.put("floatingRate", docCommonModel.getLoanBusinessInformation().getInterestRateRise());
        // repayment 转义中文显示，如果为7 则 取 value字段值
        variables.put("payBackMethod", getRepayment(docCommonModel.getLoanBusinessInformation().getRepayment()));

        // 1.1. loan_basis借口人基础信息表  application_matters
        // 申请事项：0 个人经营性贷款 1信用贷款 2 房屋按揭贷款 3个人消费类贷款
        variables.put("applySubject", getApplicationMatters(docCommonModel.getLoanBasis().getApplicationMatters()));

        // guarantee_method
        variables.put("guarantee", docCommonModel.getLoanBasis().getGuaranteeMethod());
        // loan_type  贷款类型: 0新增 1续贷
        variables.put("isNewer", docCommonModel.getLoanBasis().getLoanType() == 0 ? "是" : "否");
        variables.put("isNewerDes", docCommonModel.getLoanBasis().getLoanType() == 0 ? "新增贷款" : "续贷");

        // 抵押物信息
        setPawnList(docCommonModel, variables);

        // 担保人信息（抵押和保证都有）
        setGuarantorList(docCommonModel, variables);


    }


    private void setGuarantorList(DocCommonModel model, Map<String, Object> variables) {
        // related_personnel_information  type 3和4,5
        List<String> guarantorList = new ArrayList<>();
        if (CollectionUtils.isEmpty(model.getMortgageGuarantorList()) &&
                CollectionUtils.isEmpty(model.getGuarantorList())) {
            guarantorList.add("");
        } else {
            for (RelatedPersonnelInformation relatedPersonnelInformation : model.getMortgageGuarantorList()) {
                if(!guarantorList.contains(relatedPersonnelInformation.getName())) {
                    guarantorList.add(relatedPersonnelInformation.getName());
                }
            }

            for (RelatedPersonnelInformation relatedPersonnelInformation : model.getGuarantorList()) {
                if(!guarantorList.contains(relatedPersonnelInformation.getName())) {
                    guarantorList.add(relatedPersonnelInformation.getName());
                }
            }
        }

        setGuarantorListText(guarantorList, variables);
    }

    private Map<String, Object> mortgage(String address, String name, String collateralArea,
                                         String collateralFee) {
        Map<String, Object> tempMap1 = new HashMap<>();
        tempMap1.put("address", address);
        tempMap1.put("personName", name);
        tempMap1.put("unit", collateralArea + "㎡");
        tempMap1.put("money", collateralFee);
        return tempMap1;
    }

    private void setPawnList(DocCommonModel docCommonModel, Map<String, Object> variables) {
        List<Map<String, Object>> pawnList = new ArrayList<>();
        if (!docCommonModel.isContainsMortgage() || CollectionUtils.isEmpty(docCommonModel.getPawnList())) {
            // 如果没有数据，需要初始化空数据进去，为了客户可以自己填充数据，保障表格样式统一
            pawnList.add(mortgage("", "", "", ""));

        } else {
            for (Pawn pawn : docCommonModel.getPawnList()) {
                String name = "";

                for (RelatedPersonnelInformation relatedPersonnelInformation : pawn.getRelatedPersonnelInformationList()) {
                    name += StringUtils.isEmpty(name) ? relatedPersonnelInformation.getName() :
                            "、" + relatedPersonnelInformation.getName();
                }

                // 抵押物类型 0房屋 1土地
                String collateralAmount;
                if (pawn.getMortgageType() == 1) {
                    collateralAmount = pawn.getLandOccupationArea();
                } else {
                    collateralAmount = pawn.getBuildingArea();
                }

                pawnList.add(mortgage(pawn.getCollateralDeposit(), name, collateralAmount, pawn.getValue()));
            }
        }

        setCollateralListText(pawnList, variables);

        variables.put("applyPersonMerge", pawnList.size() + 5);
        variables.put("collateralMerge", pawnList.size() );
    }

    /**
     * 还款方式 1利随本清 2按月结息，到期一次性还本 3按月结息，分期还本 4按季结息，分期还本 5等额本金 6等额本息 7其他
     */
    private String getRepayment(int repayment) {
        String repaymentText = "";
        if (repayment == 1) {
            repaymentText = "利随本清";
        } else if (repayment == 2) {
            repaymentText = "按月结息，到期一次性还本";
        } else if (repayment == 3) {
            repaymentText = "按月结息，分期还本";
        } else if (repayment == 4) {
            repaymentText = "按季结息，分期还本";
        } else if (repayment == 5) {
            repaymentText = "等额本金";
        } else if (repayment == 6) {
            repaymentText = "等额本息";
        } else if (repayment == 7) {
            repaymentText = "其他";
        }

        return repaymentText;
    }

    /**
     * 0 个人经营性贷款 1信用贷款 2 房屋按揭贷款 3个人消费类贷款
     */
    private String getApplicationMatters(int applicationMatters) {
        String applicationMattersText = "";
        if (applicationMatters == 0) {
            applicationMattersText = "个人经营性贷款";
        } else if (applicationMatters == 1) {
            applicationMattersText = "信用贷款";
        } else if (applicationMatters == 2) {
            applicationMattersText = "房屋按揭贷款";
        } else if (applicationMatters == 3) {
            applicationMattersText = "个人消费类贷款";
        }

        return applicationMattersText;
    }


    private void setCollateralListText(List<Map<String, Object>> collateralList, Map<String, Object> variables) {
        if (CollectionUtils.isEmpty(collateralList)) {
            variables.put("collateralList", "");
            return;
        }

        int index = 0;
        StringBuilder data = new StringBuilder();
        for (Map<String, Object> map : collateralList) {
            index++;
            data.append("<Row ss:AutoFitHeight=\"0\" ss:Height=\"44.0625\">\n" +
                    "    <Cell ss:Index=\"3\" ss:StyleID=\"s96\"><Data ss:Type=\"Number\">" + index + "</Data><NamedCell\n" +
                    "      ss:Name=\"Print_Area\"/></Cell>\n" +
                    "    <Cell ss:MergeAcross=\"2\" ss:StyleID=\"s128\"><Data ss:Type=\"String\">" + map.get("address") + "</Data><NamedCell\n" +
                    "      ss:Name=\"Print_Area\"/></Cell>\n" +
                    "    <Cell ss:MergeAcross=\"3\" ss:StyleID=\"s129\"><Data ss:Type=\"String\">" + map.get("personName") + "</Data><NamedCell\n" +
                    "      ss:Name=\"Print_Area\"/></Cell>\n" +
                    "    <Cell ss:MergeAcross=\"1\" ss:StyleID=\"s129\"><ss:Data ss:Type=\"String\"\n" +
                    "      xmlns=\"http://www.w3.org/TR/REC-html40\">" + map.get("unit") + "<Font html:Face=\"SimSun\"\n" +
                    "       x:CharSet=\"134\"></Font></ss:Data><NamedCell ss:Name=\"Print_Area\"/></Cell>\n" +
                    "    <Cell ss:MergeAcross=\"4\" ss:StyleID=\"s130\"><Data ss:Type=\"Number\">" + map.get("money") + "</Data><NamedCell\n" +
                    "      ss:Name=\"Print_Area\"/></Cell>\n" +
                    "   </Row>");
        }
        variables.put("collateralList", data.toString());
    }

    private void setGuarantorListText(List<String> guarantorList, Map<String, Object> variables) {
        if (CollectionUtils.isEmpty(guarantorList)) {
            variables.put("guarantorList", "");
            return;
        }

        StringBuilder data = new StringBuilder();
        int index = 0;
        for (String name : guarantorList) {
            index++;

            data.append("<Row ss:AutoFitHeight=\"0\" ss:Height=\"15.9375\">\n" +
                    "    <Cell ss:StyleID=\"s65\"><NamedCell ss:Name=\"Print_Area\"/></Cell>\n" +
                    "    <Cell ss:StyleID=\"s69\"><NamedCell ss:Name=\"Print_Area\"/></Cell>\n" +
                    "    <Cell ss:StyleID=\"s96\"><Data ss:Type=\"Number\">" + index + "</Data><NamedCell\n" +
                    "      ss:Name=\"Print_Area\"/></Cell>\n" +
                    "    <Cell ss:MergeAcross=\"6\" ss:StyleID=\"s126\"><Data ss:Type=\"String\">" + name + "</Data><NamedCell\n" +
                    "      ss:Name=\"Print_Area\"/></Cell>\n" +
                    "    <Cell ss:MergeAcross=\"6\" ss:StyleID=\"s127\"><Data ss:Type=\"String\"></Data><NamedCell\n" +
                    "      ss:Name=\"Print_Area\"/></Cell>\n" +
                    "   </Row>");

        }
        variables.put("guarantorList", data.toString());
    }

    @Override
    protected String modelFileName() {
        return "信贷业务呈批表";
    }

    @Override
    protected DocConstants.DocType docType() {
        return DocConstants.DocType.EXCEL;
    }

    @Override
    protected int sort() {
        return 1_2_00;
    }
}
