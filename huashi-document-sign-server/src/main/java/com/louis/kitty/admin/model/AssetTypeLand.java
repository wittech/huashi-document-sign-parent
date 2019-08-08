package com.louis.kitty.admin.model;

/**
 * ---------------------------
 * 资产类型土地信息表 (AssetTypeLand)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-08 11:53:17
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public class AssetTypeLand {

	/** 编号 */
	private Long id;
	/** 土地证号 */
	private String landCertificate;
	/** 相关人员信息表id */
	private Long rpiId;
	/** 所属地 */
	private String affiliation;
	/** 地址 */
	private String address;
	/** 房屋建筑面积 单位㎡ */
	private String constructionArea;
	/** 价值 */
	private String value;
	/** 融资情况 （0、无抵押）（1、有抵押） */
	private Integer financingSituation;
	/** 是否有共有人（0、否）（1、是） */
	private Integer whetherCoOwner;
	/** 共有人姓名 */
	private String coOwnerName;
	/** 是否有租赁（0、否）（1、是） */
	private Integer whetherLease;
	/** 备注 */
	private String remark;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLandCertificate() {
		return landCertificate;
	}

	public void setLandCertificate(String landCertificate) {
		this.landCertificate = landCertificate;
	}

	public Long getRpiId() {
		return rpiId;
	}

	public void setRpiId(Long rpiId) {
		this.rpiId = rpiId;
	}

	public String getAffiliation() {
		return affiliation;
	}

	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getConstructionArea() {
		return constructionArea;
	}

	public void setConstructionArea(String constructionArea) {
		this.constructionArea = constructionArea;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getFinancingSituation() {
		return financingSituation;
	}

	public void setFinancingSituation(Integer financingSituation) {
		this.financingSituation = financingSituation;
	}

	public Integer getWhetherCoOwner() {
		return whetherCoOwner;
	}

	public void setWhetherCoOwner(Integer whetherCoOwner) {
		this.whetherCoOwner = whetherCoOwner;
	}

	public String getCoOwnerName() {
		return coOwnerName;
	}

	public void setCoOwnerName(String coOwnerName) {
		this.coOwnerName = coOwnerName;
	}

	public Integer getWhetherLease() {
		return whetherLease;
	}

	public void setWhetherLease(Integer whetherLease) {
		this.whetherLease = whetherLease;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}