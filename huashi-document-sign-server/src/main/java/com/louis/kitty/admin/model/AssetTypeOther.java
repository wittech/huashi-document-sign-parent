package com.louis.kitty.admin.model;

/**
 * ---------------------------
 * 资产类型其他信息表 (AssetTypeOther)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-08 11:53:17
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public class AssetTypeOther {

	/** 编号 */
	private Long id;
	/** 资产名称 */
	private String assetName;
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

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
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