package com.louis.kitty.admin.model;

/**
 * ---------------------------
 * 贷后检查信息表 (PostLoanCheck)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-11 11:52:37
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public class PostLoanCheck {

	/** 编号 */
	private Long id;
	/** 基础信息表id */
	private Long loanBasisId;
	/** 检查时间 */
	private java.util.Date checkTime;
	/** 借款人 */
	private String borrower;
	/** 贷款起止日期 */
	private String loanStartAndStopDate;
	/** 贷款品种 */
	private String loanVariety;
	/** 借款用途 */
	private String loanUse;
	/** 贷款金额 万元 */
	private Double loanAmount;
	/** 贷款余额 万元 */
	private Double loanBalance;
	/** 担保方式 */
	private String guaranteeMethod;
	/** 是否按约定的采取委托支付或自主支付方式提款 0否 1是 */
	private Integer paymentMethodWithdrawal;
	/** 资金支付交易对手是否符合合同约定 0否 1是 */
	private Integer contractualAgreement;
	/**  资金使用是否符合约定用途 0否 1是 */
	private Integer intendedUse;
	/** 贷款资料是否完整 0否 1是 */
	private Integer isComplete;
	/** 抵（质押）登记或担保手续是否完备 0否 1是 */
	private Integer complete;
	/** 对照风险评价报告及审批意见书，审批（咨询）部门提出的限制性条款以及贷后管理要求是否已落实  0否 1是 */
	private Integer hasImplemented;
	/** 创建时间 */
	private java.util.Date createTime;
	/** 创建人 */
	private String createBy;
	/** 修改时间 */
	private java.util.Date lastUpdateTime;
	/** 修改人 */
	private String lastUpdateBy;
	/** 是否删除  -1：已删除  0：正常 */
	private Integer delFlag;
	private Integer status;
	

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

	public java.util.Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(java.util.Date checkTime) {
		this.checkTime = checkTime;
	}

	public String getBorrower() {
		return borrower;
	}

	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}

	public String getLoanStartAndStopDate() {
		return loanStartAndStopDate;
	}

	public void setLoanStartAndStopDate(String loanStartAndStopDate) {
		this.loanStartAndStopDate = loanStartAndStopDate;
	}

	public String getLoanVariety() {
		return loanVariety;
	}

	public void setLoanVariety(String loanVariety) {
		this.loanVariety = loanVariety;
	}

	public String getLoanUse() {
		return loanUse;
	}

	public void setLoanUse(String loanUse) {
		this.loanUse = loanUse;
	}

	public Double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public Double getLoanBalance() {
		return loanBalance;
	}

	public void setLoanBalance(Double loanBalance) {
		this.loanBalance = loanBalance;
	}

	public String getGuaranteeMethod() {
		return guaranteeMethod;
	}

	public void setGuaranteeMethod(String guaranteeMethod) {
		this.guaranteeMethod = guaranteeMethod;
	}

	public Integer getPaymentMethodWithdrawal() {
		return paymentMethodWithdrawal;
	}

	public void setPaymentMethodWithdrawal(Integer paymentMethodWithdrawal) {
		this.paymentMethodWithdrawal = paymentMethodWithdrawal;
	}

	public Integer getContractualAgreement() {
		return contractualAgreement;
	}

	public void setContractualAgreement(Integer contractualAgreement) {
		this.contractualAgreement = contractualAgreement;
	}

	public Integer getIntendedUse() {
		return intendedUse;
	}

	public void setIntendedUse(Integer intendedUse) {
		this.intendedUse = intendedUse;
	}

	public Integer getIsComplete() {
		return isComplete;
	}

	public void setIsComplete(Integer isComplete) {
		this.isComplete = isComplete;
	}

	public Integer getComplete() {
		return complete;
	}

	public void setComplete(Integer complete) {
		this.complete = complete;
	}

	public Integer getHasImplemented() {
		return hasImplemented;
	}

	public void setHasImplemented(Integer hasImplemented) {
		this.hasImplemented = hasImplemented;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public java.util.Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(java.util.Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public String getLastUpdateBy() {
		return lastUpdateBy;
	}

	public void setLastUpdateBy(String lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}