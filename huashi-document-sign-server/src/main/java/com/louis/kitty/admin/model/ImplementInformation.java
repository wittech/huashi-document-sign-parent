package com.louis.kitty.admin.model;

/**
 * ---------------------------
 * 落实信息表 (ImplementInformation)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-11 11:52:37
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public class ImplementInformation {

	/** 编号 */
	private Long id;
	/** 贷后检查信息表id */
	private Long postLoanCheckId;
	/** 检查时间 */
	private java.util.Date checkTime;
	/** 未落实 */
	private String unimplemented;
	/** 原因 */
	private String reason;
	/** 拟采取措施 */
	private String proposedMeasures;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPostLoanCheckId() {
		return postLoanCheckId;
	}

	public void setPostLoanCheckId(Long postLoanCheckId) {
		this.postLoanCheckId = postLoanCheckId;
	}

	public java.util.Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(java.util.Date checkTime) {
		this.checkTime = checkTime;
	}

	public String getUnimplemented() {
		return unimplemented;
	}

	public void setUnimplemented(String unimplemented) {
		this.unimplemented = unimplemented;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getProposedMeasures() {
		return proposedMeasures;
	}

	public void setProposedMeasures(String proposedMeasures) {
		this.proposedMeasures = proposedMeasures;
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

}