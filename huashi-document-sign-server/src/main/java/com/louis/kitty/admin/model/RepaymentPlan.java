package com.louis.kitty.admin.model;

/**
 * ---------------------------
 * 还款计划信息表 (RepaymentPlan)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-11 11:52:37
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public class RepaymentPlan {

	/** 编号 */
	private Long id;
	/** 贷款业务信息表id */
	private Long loanBusinessInformationId;
	/** 还款时间 */
	private java.util.Date repaymentTime;
	/** 金额 */
	private Double amount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getLoanBusinessInformationId() {
		return loanBusinessInformationId;
	}

	public void setLoanBusinessInformationId(Long loanBusinessInformationId) {
		this.loanBusinessInformationId = loanBusinessInformationId;
	}

	public java.util.Date getRepaymentTime() {
		return repaymentTime;
	}

	public void setRepaymentTime(java.util.Date repaymentTime) {
		this.repaymentTime = repaymentTime;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

}