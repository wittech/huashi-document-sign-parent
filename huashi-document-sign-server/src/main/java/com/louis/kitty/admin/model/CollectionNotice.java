package com.louis.kitty.admin.model;

/**
 * ---------------------------
 * 贷款到期（逾期）催收通知书信息表 (CollectionNotice)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-11 11:52:37
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public class CollectionNotice {

	/** 编号 */
	private Long id;
	/** 基础信息表id */
	private Long loanBasisId;
	/** 检查时间 */
	private java.util.Date checkTime;
	/** 借款人 */
	private String borrower;
	/** 个人借款合同编号 */
	private String personalLoanContractNumber;
	/** 借款期限 年 */
	private Integer borrowingPeriod;
	/** 贷款起止日期 */
	private String loanStartAndStopDate;
	/** 所欠本金元 */
	private Double owePrincipal;
	/** 所欠利息元 */
	private Double oweInterest;
	/** 填写日期 */
	private java.util.Date fillDate;
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

	public String getPersonalLoanContractNumber() {
		return personalLoanContractNumber;
	}

	public void setPersonalLoanContractNumber(String personalLoanContractNumber) {
		this.personalLoanContractNumber = personalLoanContractNumber;
	}

	public Integer getBorrowingPeriod() {
		return borrowingPeriod;
	}

	public void setBorrowingPeriod(Integer borrowingPeriod) {
		this.borrowingPeriod = borrowingPeriod;
	}

	public String getLoanStartAndStopDate() {
		return loanStartAndStopDate;
	}

	public void setLoanStartAndStopDate(String loanStartAndStopDate) {
		this.loanStartAndStopDate = loanStartAndStopDate;
	}

	public Double getOwePrincipal() {
		return owePrincipal;
	}

	public void setOwePrincipal(Double owePrincipal) {
		this.owePrincipal = owePrincipal;
	}

	public Double getOweInterest() {
		return oweInterest;
	}

	public void setOweInterest(Double oweInterest) {
		this.oweInterest = oweInterest;
	}

	public java.util.Date getFillDate() {
		return fillDate;
	}

	public void setFillDate(java.util.Date fillDate) {
		this.fillDate = fillDate;
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