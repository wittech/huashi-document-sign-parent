package com.louis.kitty.admin.model;

/**
 * ---------------------------
 * 借口人基础信息表 (LoanBasis)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-08 11:53:18
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public class LoanBasis{

	/** 编号 */
	private Long id;
	/** 担保方式 逗号分隔 例如 保证,抵押,质押 */
	private String guaranteeMethod;
	/** 贷款类型: 0新增 1续贷 */
	private Long loanType;
	/** 申请事项：0 个人经营性贷款 1信用贷款 2 房屋按揭贷款 3个人消费类贷款 */
	private Integer applicationMatters;
	/** 借款人 */
	private String borrower;
	/** 备注 */
	private String remark;
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
	//审核
	private int status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGuaranteeMethod() {
		return guaranteeMethod;
	}

	public void setGuaranteeMethod(String guaranteeMethod) {
		this.guaranteeMethod = guaranteeMethod;
	}

	public Long getLoanType() {
		return loanType;
	}

	public void setLoanType(Long loanType) {
		this.loanType = loanType;
	}

	public Integer getApplicationMatters() {
		return applicationMatters;
	}

	public void setApplicationMatters(Integer applicationMatters) {
		this.applicationMatters = applicationMatters;
	}

	public String getBorrower() {
		return borrower;
	}

	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}