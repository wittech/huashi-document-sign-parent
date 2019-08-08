package com.louis.kitty.admin.model;

/**
 * ---------------------------
 * 资产类型证券信息表 (AssetTypeSecurities)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-08 11:53:18
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public class AssetTypeSecurities {

	/** 编号 */
	private Long id;
	/** 证券类型 （1、定期存单）（2、股权）（3、股金） */
	private Integer type;
	/** 相关人员信息表id */
	private Long rpiId;
	/** 价值 */
	private String value;
	/** 备注 */
	private String remark;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Long getRpiId() {
		return rpiId;
	}

	public void setRpiId(Long rpiId) {
		this.rpiId = rpiId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}