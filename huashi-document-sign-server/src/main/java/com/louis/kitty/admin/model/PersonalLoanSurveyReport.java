package com.louis.kitty.admin.model;

/**
 * ---------------------------
 * 个人贷款调查报告信息表 (PersonalLoanSurveyReport)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-08 11:53:18
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public class PersonalLoanSurveyReport {

	/** 编号 */
	private Long id;
	/** 基础信息表id */
	private Long loanBasisId;
	/** 借款人姓名 */
	private String borrowerName;
	/** 婚姻状况 1已婚 0未婚 */
	private Integer maritalStatus;
	/** 配偶姓名 */
	private String spouseName;
	/** 是否本地户籍 1是 0否 */
	private Integer whetherLocalHouseholdRegistration;
	/** 家庭名下房产共计 */
	private String totalProperty;
	/** 总计面积 ㎡ */
	private String totalArea;
	/** 总价值 万元 */
	private String totalValue;
	/** 描述 */
	private String totalPropertyRemark;
	/** 家庭资产 万元 */
	private String familyAssets;
	/** 家庭负债 万元 */
	private String householdDebt;
	/** 年家庭收入 万元 */
	private String annualHouseholdIncome;
	/** 家庭支出 元 */
	private String familyExpense;
	/** 借款人健康状况 1较差 2一般 3健康 */
	private Integer borrowerHealthStatus;
	/** 其他需调查反映的情况 */
	private String otherSurveyHappening;
	/** 借款人是否具有完全民事行为能力 1是 0否 */
	private Integer borrowerWhetherHaveCivilAction;
	/** 申贷金额 万元 */
	private String amountLoan;
	/** 自筹资金 万元 */
	private String selfFunding;
	/** 借款期限 年 */
	private String borrowingPeriod;
	/** 申贷金额是否合理 1是 0否 */
	private Integer loanAmountWhetherReasonable;
	/** 申贷期限是否合理 1是 0否 */
	private Integer loanTermWhetherReasonable;
	/** 借款用途 */
	private String useLoan;
	/** 第一还款来源是否充足 1是 0否 */
	private Integer repaymentSourceWhetherSufficient;
	/** 借款人偿还能力测算（公式） */
	private String borrowerRepayAbilityEstimate;
	/** 贷款偿还能力是否与申请贷款额度相符 1是 0否 */
	private Integer whetherAmountMatch;
	/** 有无债务诉讼 1有 0无 */
	private Integer withoutDebtLitigation;
	/** 借款人品行 1优良 2较好 3一般 4较差 */
	private Integer borrowerConduct;
	/** 借款人资信（含信用卡）情况 0无借款 1有借款，能按期还款无不良记录 2有逾期不良情况 */
	private Integer borrowerCredit;
	/** 连续逾期 单位 期 */
	private String continuousOverdue;
	/** 累计逾期 单位 期 */
	private String cumulativeOverdue;
	/** 当前逾期金额 单位 万元 */
	private String currentOverdueAmount;
	/** 金融机构借款余额 单位 万元 */
	private String financialMechanismLoanBalance;
	/** 信用卡授信总额 单位 万元 */
	private String creditCardLumpSum;
	/** 已用额度 单位 万元 */
	private String usedQuota;
	/** 对外担保余额 单位 万元 */
	private String externalGuaranteeBalance;
	/** 其中对外担保不良贷款余额 单位 万元 */
	private String badLoanBalance;
	/** 贷款方式为保证担保 */
	private Integer loanMethodGuarantee;
	/** 贷款方式为保证担保描述 */
	private String loanMethodGuaranteeRemark;
	/** 经测算，该保证人是否具有担保能力 1是 0否 */
	private Integer calculated;
	/** 贷款方式为抵（质）押担保 */
	private Integer loanMethodPledgeGuarantee;
	/** 贷款方式为抵（质）押担保描述 */
	private String loanMethodPledgeGuaranteeRemark;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getLoanBasisId() {
		return loanBasisId;
	}

	public void setLoanBasisId(Long loanBasisId) {
		this.loanBasisId = loanBasisId;
	}

	public String getBorrowerName() {
		return borrowerName;
	}

	public void setBorrowerName(String borrowerName) {
		this.borrowerName = borrowerName;
	}

	public Integer getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(Integer maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getSpouseName() {
		return spouseName;
	}

	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}

	public Integer getWhetherLocalHouseholdRegistration() {
		return whetherLocalHouseholdRegistration;
	}

	public void setWhetherLocalHouseholdRegistration(Integer whetherLocalHouseholdRegistration) {
		this.whetherLocalHouseholdRegistration = whetherLocalHouseholdRegistration;
	}

	public String getTotalProperty() {
		return totalProperty;
	}

	public void setTotalProperty(String totalProperty) {
		this.totalProperty = totalProperty;
	}

	public String getTotalArea() {
		return totalArea;
	}

	public void setTotalArea(String totalArea) {
		this.totalArea = totalArea;
	}

	public String getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(String totalValue) {
		this.totalValue = totalValue;
	}

	public String getTotalPropertyRemark() {
		return totalPropertyRemark;
	}

	public void setTotalPropertyRemark(String totalPropertyRemark) {
		this.totalPropertyRemark = totalPropertyRemark;
	}

	public String getFamilyAssets() {
		return familyAssets;
	}

	public void setFamilyAssets(String familyAssets) {
		this.familyAssets = familyAssets;
	}

	public String getHouseholdDebt() {
		return householdDebt;
	}

	public void setHouseholdDebt(String householdDebt) {
		this.householdDebt = householdDebt;
	}

	public String getAnnualHouseholdIncome() {
		return annualHouseholdIncome;
	}

	public void setAnnualHouseholdIncome(String annualHouseholdIncome) {
		this.annualHouseholdIncome = annualHouseholdIncome;
	}

	public String getFamilyExpense() {
		return familyExpense;
	}

	public void setFamilyExpense(String familyExpense) {
		this.familyExpense = familyExpense;
	}

	public Integer getBorrowerHealthStatus() {
		return borrowerHealthStatus;
	}

	public void setBorrowerHealthStatus(Integer borrowerHealthStatus) {
		this.borrowerHealthStatus = borrowerHealthStatus;
	}

	public String getOtherSurveyHappening() {
		return otherSurveyHappening;
	}

	public void setOtherSurveyHappening(String otherSurveyHappening) {
		this.otherSurveyHappening = otherSurveyHappening;
	}

	public Integer getBorrowerWhetherHaveCivilAction() {
		return borrowerWhetherHaveCivilAction;
	}

	public void setBorrowerWhetherHaveCivilAction(Integer borrowerWhetherHaveCivilAction) {
		this.borrowerWhetherHaveCivilAction = borrowerWhetherHaveCivilAction;
	}

	public String getAmountLoan() {
		return amountLoan;
	}

	public void setAmountLoan(String amountLoan) {
		this.amountLoan = amountLoan;
	}

	public String getSelfFunding() {
		return selfFunding;
	}

	public void setSelfFunding(String selfFunding) {
		this.selfFunding = selfFunding;
	}

	public String getBorrowingPeriod() {
		return borrowingPeriod;
	}

	public void setBorrowingPeriod(String borrowingPeriod) {
		this.borrowingPeriod = borrowingPeriod;
	}

	public Integer getLoanAmountWhetherReasonable() {
		return loanAmountWhetherReasonable;
	}

	public void setLoanAmountWhetherReasonable(Integer loanAmountWhetherReasonable) {
		this.loanAmountWhetherReasonable = loanAmountWhetherReasonable;
	}

	public Integer getLoanTermWhetherReasonable() {
		return loanTermWhetherReasonable;
	}

	public void setLoanTermWhetherReasonable(Integer loanTermWhetherReasonable) {
		this.loanTermWhetherReasonable = loanTermWhetherReasonable;
	}

	public String getUseLoan() {
		return useLoan;
	}

	public void setUseLoan(String useLoan) {
		this.useLoan = useLoan;
	}

	public Integer getRepaymentSourceWhetherSufficient() {
		return repaymentSourceWhetherSufficient;
	}

	public void setRepaymentSourceWhetherSufficient(Integer repaymentSourceWhetherSufficient) {
		this.repaymentSourceWhetherSufficient = repaymentSourceWhetherSufficient;
	}

	public String getBorrowerRepayAbilityEstimate() {
		return borrowerRepayAbilityEstimate;
	}

	public void setBorrowerRepayAbilityEstimate(String borrowerRepayAbilityEstimate) {
		this.borrowerRepayAbilityEstimate = borrowerRepayAbilityEstimate;
	}

	public Integer getWhetherAmountMatch() {
		return whetherAmountMatch;
	}

	public void setWhetherAmountMatch(Integer whetherAmountMatch) {
		this.whetherAmountMatch = whetherAmountMatch;
	}

	public Integer getWithoutDebtLitigation() {
		return withoutDebtLitigation;
	}

	public void setWithoutDebtLitigation(Integer withoutDebtLitigation) {
		this.withoutDebtLitigation = withoutDebtLitigation;
	}

	public Integer getBorrowerConduct() {
		return borrowerConduct;
	}

	public void setBorrowerConduct(Integer borrowerConduct) {
		this.borrowerConduct = borrowerConduct;
	}

	public Integer getBorrowerCredit() {
		return borrowerCredit;
	}

	public void setBorrowerCredit(Integer borrowerCredit) {
		this.borrowerCredit = borrowerCredit;
	}

	public String getContinuousOverdue() {
		return continuousOverdue;
	}

	public void setContinuousOverdue(String continuousOverdue) {
		this.continuousOverdue = continuousOverdue;
	}

	public String getCumulativeOverdue() {
		return cumulativeOverdue;
	}

	public void setCumulativeOverdue(String cumulativeOverdue) {
		this.cumulativeOverdue = cumulativeOverdue;
	}

	public String getCurrentOverdueAmount() {
		return currentOverdueAmount;
	}

	public void setCurrentOverdueAmount(String currentOverdueAmount) {
		this.currentOverdueAmount = currentOverdueAmount;
	}

	public String getFinancialMechanismLoanBalance() {
		return financialMechanismLoanBalance;
	}

	public void setFinancialMechanismLoanBalance(String financialMechanismLoanBalance) {
		this.financialMechanismLoanBalance = financialMechanismLoanBalance;
	}

	public String getCreditCardLumpSum() {
		return creditCardLumpSum;
	}

	public void setCreditCardLumpSum(String creditCardLumpSum) {
		this.creditCardLumpSum = creditCardLumpSum;
	}

	public String getUsedQuota() {
		return usedQuota;
	}

	public void setUsedQuota(String usedQuota) {
		this.usedQuota = usedQuota;
	}

	public String getExternalGuaranteeBalance() {
		return externalGuaranteeBalance;
	}

	public void setExternalGuaranteeBalance(String externalGuaranteeBalance) {
		this.externalGuaranteeBalance = externalGuaranteeBalance;
	}

	public String getBadLoanBalance() {
		return badLoanBalance;
	}

	public void setBadLoanBalance(String badLoanBalance) {
		this.badLoanBalance = badLoanBalance;
	}

	public Integer getLoanMethodGuarantee() {
		return loanMethodGuarantee;
	}

	public void setLoanMethodGuarantee(Integer loanMethodGuarantee) {
		this.loanMethodGuarantee = loanMethodGuarantee;
	}

	public String getLoanMethodGuaranteeRemark() {
		return loanMethodGuaranteeRemark;
	}

	public void setLoanMethodGuaranteeRemark(String loanMethodGuaranteeRemark) {
		this.loanMethodGuaranteeRemark = loanMethodGuaranteeRemark;
	}

	public Integer getCalculated() {
		return calculated;
	}

	public void setCalculated(Integer calculated) {
		this.calculated = calculated;
	}

	public Integer getLoanMethodPledgeGuarantee() {
		return loanMethodPledgeGuarantee;
	}

	public void setLoanMethodPledgeGuarantee(Integer loanMethodPledgeGuarantee) {
		this.loanMethodPledgeGuarantee = loanMethodPledgeGuarantee;
	}

	public String getLoanMethodPledgeGuaranteeRemark() {
		return loanMethodPledgeGuaranteeRemark;
	}

	public void setLoanMethodPledgeGuaranteeRemark(String loanMethodPledgeGuaranteeRemark) {
		this.loanMethodPledgeGuaranteeRemark = loanMethodPledgeGuaranteeRemark;
	}

}