/**
 * 
 */
package com.louis.kitty.admin.dto;

/**
 * @author 15858
 *
 */
public class CollectionNoticeDto {
	private int id;
	private int loanBasisId;
	private String borrower;
	//贷款类型: 0新增 1续贷
	private int loanType;
	//申请事项：0 个人经营性贷款 1信用贷款 2 房屋按揭贷款 3个人消费类贷款
	private int applicationMatters;
	//贷款起止日期
	private String loanStartAndStopDate;
	//申请金额
	private String applicationAmount;
	//状态
	private int status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLoanBasisId() {
		return loanBasisId;
	}
	public void setLoanBasisId(int loanBasisId) {
		this.loanBasisId = loanBasisId;
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

	public String getLoanStartAndStopDate() {
		return loanStartAndStopDate;
	}
	public void setLoanStartAndStopDate(String loanStartAndStopDate) {
		this.loanStartAndStopDate = loanStartAndStopDate;
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
	
	
	
}
