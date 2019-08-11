package com.louis.kitty.admin.model;

import java.util.List;

/**
 * ---------------------------
 * 贷款业务信息表 (LoanBusinessInformation)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-11 11:52:37
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public class LoanBusinessInformation {

	/** 编号 */
	private Long id;
	/** 基础信息表id */
	private Long loanBasisId;
	/** 借款人账号 */
	private String borrowerAccount;
	/** 客户号 */
	private String clientNumber;
	/** 申请金额 */
	private Double applicationAmount;
	/** 申请期限 单位 年 */
	private String applicationPeriod;
	/** 是否申请循环额度 0否 1是 */
	private Integer cycleQuota;
	/** 利率 1浮动利率 2固定利率 */
	private Integer interestRate;
	/** 利率调整方式 1立即生效 2次年一月一日起生效 3对月对日生效 */
	private Integer adjustmentMethod;
	/** 利率上浮幅度% */
	private String interestRateRise;
	/** 申请利率% */
	private String applicationRate;
	/** 保证金比例% */
	private String marginRatio;
	/** 原信贷业务余额 元 */
	private String originalCreditBalance;
	/** 用途 1经营 2自建房 3购房 4购车 5住房装修 6购买大额耐用消费品 7旅游消费 8留学 9子女教育 10其他 */
	private Integer useInfo;
	/** 用途具体说明 */
	private String description;
	/** 还款方式 1利随本清 2按月结息，到期一次性还本 3按月结息，分期还本 4按季结息，分期还本 5等额本金 6等额本息 7其他 */
	private Integer repayment;
	/** 其他 值 */
	private String value;
	/** 还款期数 */
	private Integer repaymentPeriod;
	/** 是否申请个人购房贷款 0否 1是 */
	private Integer whetherPersonalHomeLoan;
	/** 是否公积金组合贷款 0否 1是 */
	private Integer whetherProvidentFundCombinationLoan;
	/** 公积金贷款金额 */
	private Double providentFundLoanAmount;
	/** 借款人是否为我行独家信贷客户 0否 1是 */
	private Integer whetherExclusiveCreditClient;
	/** 前在我行开立一般存款账户 */
	private String depositAccount;
	/** 创建人 */
	private String createBy;
	/** 创建时间 */
	private java.util.Date createTime;
	/** 更新人 */
	private String lastUpdateBy;
	/** 更新时间 */
	private java.util.Date lastUpdateTime;
	/** 是否删除  -1：已删除  0：正常 */
	private Integer delFlag;
	private List<CounterpartyInformation> counterpartyInformation;
	private List<RepaymentPlan> repaymentPlan;

	public List<CounterpartyInformation> getCounterpartyInformation() {
		return counterpartyInformation;
	}

	public void setCounterpartyInformation(List<CounterpartyInformation> counterpartyInformation) {
		this.counterpartyInformation = counterpartyInformation;
	}

	public List<RepaymentPlan> getRepaymentPlan() {
		return repaymentPlan;
	}

	public void setRepaymentPlan(List<RepaymentPlan> repaymentPlan) {
		this.repaymentPlan = repaymentPlan;
	}

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

	public String getBorrowerAccount() {
		return borrowerAccount;
	}

	public void setBorrowerAccount(String borrowerAccount) {
		this.borrowerAccount = borrowerAccount;
	}

	public String getClientNumber() {
		return clientNumber;
	}

	public void setClientNumber(String clientNumber) {
		this.clientNumber = clientNumber;
	}

	public Double getApplicationAmount() {
		return applicationAmount;
	}

	public void setApplicationAmount(Double applicationAmount) {
		this.applicationAmount = applicationAmount;
	}

	public String getApplicationPeriod() {
		return applicationPeriod;
	}

	public void setApplicationPeriod(String applicationPeriod) {
		this.applicationPeriod = applicationPeriod;
	}

	public Integer getCycleQuota() {
		return cycleQuota;
	}

	public void setCycleQuota(Integer cycleQuota) {
		this.cycleQuota = cycleQuota;
	}

	public Integer getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Integer interestRate) {
		this.interestRate = interestRate;
	}

	public Integer getAdjustmentMethod() {
		return adjustmentMethod;
	}

	public void setAdjustmentMethod(Integer adjustmentMethod) {
		this.adjustmentMethod = adjustmentMethod;
	}

	public String getInterestRateRise() {
		return interestRateRise;
	}

	public void setInterestRateRise(String interestRateRise) {
		this.interestRateRise = interestRateRise;
	}

	public String getApplicationRate() {
		return applicationRate;
	}

	public void setApplicationRate(String applicationRate) {
		this.applicationRate = applicationRate;
	}

	public String getMarginRatio() {
		return marginRatio;
	}

	public void setMarginRatio(String marginRatio) {
		this.marginRatio = marginRatio;
	}

	public String getOriginalCreditBalance() {
		return originalCreditBalance;
	}

	public void setOriginalCreditBalance(String originalCreditBalance) {
		this.originalCreditBalance = originalCreditBalance;
	}

	public Integer getUseInfo() {
		return useInfo;
	}

	public void setUseInfo(Integer useInfo) {
		this.useInfo = useInfo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getRepayment() {
		return repayment;
	}

	public void setRepayment(Integer repayment) {
		this.repayment = repayment;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getRepaymentPeriod() {
		return repaymentPeriod;
	}

	public void setRepaymentPeriod(Integer repaymentPeriod) {
		this.repaymentPeriod = repaymentPeriod;
	}

	public Integer getWhetherPersonalHomeLoan() {
		return whetherPersonalHomeLoan;
	}

	public void setWhetherPersonalHomeLoan(Integer whetherPersonalHomeLoan) {
		this.whetherPersonalHomeLoan = whetherPersonalHomeLoan;
	}

	public Integer getWhetherProvidentFundCombinationLoan() {
		return whetherProvidentFundCombinationLoan;
	}

	public void setWhetherProvidentFundCombinationLoan(Integer whetherProvidentFundCombinationLoan) {
		this.whetherProvidentFundCombinationLoan = whetherProvidentFundCombinationLoan;
	}

	public Double getProvidentFundLoanAmount() {
		return providentFundLoanAmount;
	}

	public void setProvidentFundLoanAmount(Double providentFundLoanAmount) {
		this.providentFundLoanAmount = providentFundLoanAmount;
	}

	public Integer getWhetherExclusiveCreditClient() {
		return whetherExclusiveCreditClient;
	}

	public void setWhetherExclusiveCreditClient(Integer whetherExclusiveCreditClient) {
		this.whetherExclusiveCreditClient = whetherExclusiveCreditClient;
	}

	public String getDepositAccount() {
		return depositAccount;
	}

	public void setDepositAccount(String depositAccount) {
		this.depositAccount = depositAccount;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	public String getLastUpdateBy() {
		return lastUpdateBy;
	}

	public void setLastUpdateBy(String lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}

	public java.util.Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(java.util.Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

}