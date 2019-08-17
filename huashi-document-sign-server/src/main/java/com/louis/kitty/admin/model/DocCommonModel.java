package com.louis.kitty.admin.model;

import com.louis.kitty.admin.constants.LoanConstants;
import com.louis.kitty.admin.util.RmbUtil;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class DocCommonModel {

    /**
     * 贷款基础信息
     */
    private LoanBasis loanBasis;

    /**
     * 贷款业务信息（贷款额度，贷款期限）
     */
    private LoanBusinessInformation loanBusinessInformation;

    /**
     * 合同信息表
     */
    private ContractInformation contractInformation;

    /**
     * 借款人信息
     */
    private RelatedPersonnelInformation borrower;

    /**
     * 借款人配偶信息
     */
    private RelatedPersonnelInformation borrowerCouple;


    /**
     * 抵押担保人
     */
    private List<RelatedPersonnelInformation> mortgageGuarantorList = new ArrayList<>();

    /**
     * 保证担保人
     */
    private List<RelatedPersonnelInformation> guarantorList = new ArrayList<>();

    /**
     * 其他类型关系人（指关系类型 为空数据）
     */
    private List<RelatedPersonnelInformation> otherPartyList = new ArrayList<>();

    /**
     * 抵押物信息表
     */
    private List<Pawn> pawnList = new ArrayList<>();

    /**
     * 还款计划
     */
    private List<RepaymentPlan> repaymentPlanList = new ArrayList<>();

    /**
     * 银行交易对手信息
     */
    private List<CounterpartyInformation> counterpartyInformationList = new ArrayList<>();

    /**
     * 贷后检查表
     */
    private PostLoanCheck postLoanCheck;

    /**
     * 贷款到期（逾期）催收通知书信息表
     */
    private CollectionNotice collectionNotice;

    /**
     * 获取家庭姓名信息(一般为借款人、借款人配偶姓名)
     */
    public String getApplyFamilyName() {
        if (borrower == null) {
            return "";
        }

        String familyName = StringUtils.isEmpty(borrower.getName()) ? "" : borrower.getName();

        if (borrowerCouple == null) {
            return familyName;
        }

        return familyName + "、" + (StringUtils.isEmpty(borrowerCouple.getName()) ? "" : borrowerCouple.getName());
    }

    /**
     * 是否包含为【抵押】方式贷款，贷款方式可以同时同种，判断是否存在【抵押】
     */
    public boolean isContainsMortgage() {
        if (loanBasis == null) {
            return false;
        }

        return StringUtils.isNoneBlank(loanBasis.getGuaranteeMethod()) &&
                loanBasis.getGuaranteeMethod().contains(LoanConstants.GuaranteeMethod.MORTGAGE.getTitle());
    }

    /**
     * 是否包含为【保证】方式贷款，贷款方式可以同时同种，判断是否存在【保证】
     */
    public boolean isContainsGuarantee() {
        if (loanBasis == null) {
            return false;
        }

        return StringUtils.isNoneBlank(loanBasis.getGuaranteeMethod()) &&
                loanBasis.getGuaranteeMethod().contains(LoanConstants.GuaranteeMethod.GUARANTEE.getTitle());
    }

    public Long getLoanBasicId() {
        if (loanBasis == null) {
            return null;
        }

        return loanBasis.getId();
    }

    public Long getLoanBusinessInformationId() {
        if (loanBusinessInformation == null) {
            return null;
        }

        return loanBusinessInformation.getId();
    }

    public String getApplyMoneyRMB() {
        return RmbUtil.rmb(new BigDecimal(loanBusinessInformation.getApplicationAmount()));

    }
}
