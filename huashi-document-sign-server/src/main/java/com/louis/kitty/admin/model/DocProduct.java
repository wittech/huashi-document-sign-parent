package com.louis.kitty.admin.model;

/**
 * ---------------------------
 *  (DocProduct)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-07-17 21:29:30
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public class DocProduct extends BaseModel {

	/** 归档标签（一般用于文件夹目录生成） */
	private String label;
	/** 产品名称 */
	private String name;
	/** 审批状态 0：待审核，1：审批通过， 2：审批失败 */
	private Integer status;
	/**  */
	private String remark;
	/** 审批账号 */
	private String approveBy;
	/** 审批时间 */
	private java.util.Date approveTime;
	/** 审批备注 */
	private String approveDes;
	/** 文件个数 */
	private Integer fileCount;
	/** 是否停用 0:未删除，1：已删除 */
	private Integer isDeleted;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getApproveBy() {
		return approveBy;
	}

	public void setApproveBy(String approveBy) {
		this.approveBy = approveBy;
	}

	public java.util.Date getApproveTime() {
		return approveTime;
	}

	public void setApproveTime(java.util.Date approveTime) {
		this.approveTime = approveTime;
	}

	public String getApproveDes() {
		return approveDes;
	}

	public void setApproveDes(String approveDes) {
		this.approveDes = approveDes;
	}

	public Integer getFileCount() {
		return fileCount;
	}

	public void setFileCount(Integer fileCount) {
		this.fileCount = fileCount;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

}