package com.louis.kitty.admin.model;

/**
 * ---------------------------
 * 资产类型汽车信息表 (AssetTypeCar)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-08 11:53:17
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public class AssetTypeCar {

	/** 编号 */
	private Long id;
	/** 汽车品牌 */
	private String brand;
	/** 相关人员信息表id */
	private Long rpiId;
	/** 价值 */
	private String value;
	/** 车牌号 */
	private String numberPlate;
	/** 行驶证号 */
	private String drivingLicenseNumber;
	/** 备注 */
	private String remark;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
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

	public String getNumberPlate() {
		return numberPlate;
	}

	public void setNumberPlate(String numberPlate) {
		this.numberPlate = numberPlate;
	}

	public String getDrivingLicenseNumber() {
		return drivingLicenseNumber;
	}

	public void setDrivingLicenseNumber(String drivingLicenseNumber) {
		this.drivingLicenseNumber = drivingLicenseNumber;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}