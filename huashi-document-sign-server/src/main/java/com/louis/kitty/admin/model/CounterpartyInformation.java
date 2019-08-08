package com.louis.kitty.admin.model;

/**
 * ---------------------------
 * 交易对手信息表 (CounterpartyInformation)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-08 11:53:18
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public class CounterpartyInformation {

	/** 编号 */
	private Long id;
	/** 贷款业务信息表id */
	private Long loanBusinessInformationId;
	/** 名称 */
	private String name;
	/** 账号 */
	private String accountNumber;
	/** 开户行 */
	private String bank;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

}