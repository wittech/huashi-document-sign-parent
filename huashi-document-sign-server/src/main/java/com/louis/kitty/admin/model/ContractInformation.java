package com.louis.kitty.admin.model;

/**
 * ---------------------------
 * 合同信息表 (ContractInformation)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-11 11:52:37
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public class ContractInformation {

	/** 编号 */
	private Long id;
	/** 基础信息表id */
	private Long loanBasisId;
	/** 个人借款合同编号 */
	private String personalLoanContractNo;
	/** 抵押担保 合同编号 */
	private String mortgageGuaranteeContractNo;
	/** 抵押物清单合同编号 */
	private String pawnContractNo;
	/** 保证担保合同编号 */
	private String guaranteeGuaranteeContractNo;
	/** 合同签订日 */
	private java.util.Date contractSigningDate;
	/** 借款开始期限 */
	private java.util.Date borrowingStartPeriod;
	/** 借款截止期限 */
	private java.util.Date borrowingEndPeriod;
	/** 放款日期 */
	private java.util.Date loanDate;
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

	public String getPersonalLoanContractNo() {
		return personalLoanContractNo;
	}

	public void setPersonalLoanContractNo(String personalLoanContractNo) {
		this.personalLoanContractNo = personalLoanContractNo;
	}

	public String getMortgageGuaranteeContractNo() {
		return mortgageGuaranteeContractNo;
	}

	public void setMortgageGuaranteeContractNo(String mortgageGuaranteeContractNo) {
		this.mortgageGuaranteeContractNo = mortgageGuaranteeContractNo;
	}

	public String getPawnContractNo() {
		return pawnContractNo;
	}

	public void setPawnContractNo(String pawnContractNo) {
		this.pawnContractNo = pawnContractNo;
	}

	public String getGuaranteeGuaranteeContractNo() {
		return guaranteeGuaranteeContractNo;
	}

	public void setGuaranteeGuaranteeContractNo(String guaranteeGuaranteeContractNo) {
		this.guaranteeGuaranteeContractNo = guaranteeGuaranteeContractNo;
	}

	public java.util.Date getContractSigningDate() {
		return contractSigningDate;
	}

	public void setContractSigningDate(java.util.Date contractSigningDate) {
		this.contractSigningDate = contractSigningDate;
	}

	public java.util.Date getBorrowingStartPeriod() {
		return borrowingStartPeriod;
	}

	public void setBorrowingStartPeriod(java.util.Date borrowingStartPeriod) {
		this.borrowingStartPeriod = borrowingStartPeriod;
	}

	public java.util.Date getBorrowingEndPeriod() {
		return borrowingEndPeriod;
	}

	public void setBorrowingEndPeriod(java.util.Date borrowingEndPeriod) {
		this.borrowingEndPeriod = borrowingEndPeriod;
	}

	public java.util.Date getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(java.util.Date loanDate) {
		this.loanDate = loanDate;
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