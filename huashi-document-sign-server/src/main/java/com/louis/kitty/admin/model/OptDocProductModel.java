/**
 * 
 */
package com.louis.kitty.admin.model;

import java.util.Date;

/**
 * 操作文档产品
 * @author lz
 *
 */
public class OptDocProductModel extends BaseModel {
	private String label;
	private String name;
	private int status;
	private String remark;
	private String approveBy;
	private Date approveTime;
	private String approveDes;
	private int fileCount;
	private int isDeleted;

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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
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

	public Date getApproveTime() {
		return approveTime;
	}

	public void setApproveTime(Date approveTime) {
		this.approveTime = approveTime;
	}

	public String getApproveDes() {
		return approveDes;
	}

	public void setApproveDes(String approveDes) {
		this.approveDes = approveDes;
	}

	public int getFileCount() {
		return fileCount;
	}

	public void setFileCount(int fileCount) {
		this.fileCount = fileCount;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}
	
}
