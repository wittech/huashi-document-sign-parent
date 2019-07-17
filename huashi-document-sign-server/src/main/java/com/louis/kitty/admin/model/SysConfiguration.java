package com.louis.kitty.admin.model;

/**
 * ---------------------------
 * 系统配置信息表 (SysConfiguration)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-07-17 21:19:18
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public class SysConfiguration {

	/**  */
	private Integer id;
	/** 类型 */
	private String type;
	/** 属性名称 */
	private String attrName;
	/** 属性key */
	private String attrKey;
	/** 属性值 */
	private String attrValue;
	/** 备注 */
	private String remark;
	/** 是否只读 */
	private Integer readFlag;
	/** 创建时间 */
	private java.util.Date createTime;
	/** 修改时间 */
	private java.util.Date lastUpdateTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAttrName() {
		return attrName;
	}

	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}

	public String getAttrKey() {
		return attrKey;
	}

	public void setAttrKey(String attrKey) {
		this.attrKey = attrKey;
	}

	public String getAttrValue() {
		return attrValue;
	}

	public void setAttrValue(String attrValue) {
		this.attrValue = attrValue;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getReadFlag() {
		return readFlag;
	}

	public void setReadFlag(Integer readFlag) {
		this.readFlag = readFlag;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	public java.util.Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(java.util.Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

}