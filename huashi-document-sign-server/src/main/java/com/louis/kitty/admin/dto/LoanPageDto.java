/**
 * 
 */
package com.louis.kitty.admin.dto;

import java.util.Date;

/**
 * 贷款列表
 * 
 * @author 15858
 *
 */
public class LoanPageDto {
	private int id;
	private String borrower;
	private int loanType;
	private int applicationMatters;
	private Date loanDate;
	private String applicationAmount;
	private int status;
	private Date createTime;
	private String applicationPeriod;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBorrower() {
		return borrower;
	}

	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}

	public int getLoanType() {
		return loanType;
	}

	public void setLoanType(int loanType) {
		this.loanType = loanType;
	}

	public int getApplicationMatters() {
		return applicationMatters;
	}

	public void setApplicationMatters(int applicationMatters) {
		this.applicationMatters = applicationMatters;
	}

	public Date getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(Date loanDate) {
		this.loanDate = loanDate;
	}

	public String getApplicationAmount() {
		return applicationAmount;
	}

	public void setApplicationAmount(String applicationAmount) {
		this.applicationAmount = applicationAmount;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getApplicationPeriod() {
		return applicationPeriod;
	}

	public void setApplicationPeriod(String applicationPeriod) {
		this.applicationPeriod = applicationPeriod;
	}

}
