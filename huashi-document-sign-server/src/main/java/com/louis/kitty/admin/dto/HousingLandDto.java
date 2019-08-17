/**
 * 
 */
package com.louis.kitty.admin.dto;

/**
 * @author 15858
 *
 */
public class HousingLandDto {
	// 资产归属
	private String name;
	// 不动产权证号
	private String propertyCertificateNumber;
	// 是否不动产权证
	private int whetherOwnershipCertificates;
	// 房产证号
	private String deed;
	// 土地证号
	private String landCertificate;
	// 房子名称
	private String namehouses;
	// 所属地
	private String affiliation;
	// 地址
	private String address;
	// 面积
	private String constructionArea;
	// 价值
	private String value;
	// 融资情况
	private String financingSituation;
	// 是否有共有人（0、否）（1、是）
	private String whetherCoowner;
	// 共有人
	private String coownerName;
	// 是否有租赁（0、否）（1、是）
	private String whetherLease;
	///////////////////////////////////// 土地
	//土地名称
	private String nameLand;
	// 所属地
	private String affiliationLand;
	// 地址
	private String addressLand;
	// 面积
	private String constructionAreaLand;
	// 价值
	private String valueLand;
	// 是否有租赁（0、否）（1、是）
	private String whetherLeaseLand;
	// 是否有共有人（0、否）（1、是）
	private String whetherCoownerLand;
	// 共有人
	private String coownerNameLand;
	//类型 房屋
	private String typeHous;
	//土地
	private String typeLand;
	//土地证号
	private String landTypeCertificate;
	//融资情况土地
	private String financingSituationLand;
	
	public String getName() {
		return name;
	}
	public String getPropertyCertificateNumber() {
		return propertyCertificateNumber;
	}
	public int getWhetherOwnershipCertificates() {
		return whetherOwnershipCertificates;
	}
	public String getDeed() {
		return deed;
	}
	public String getLandCertificate() {
		return landCertificate;
	}
	public String getNamehouses() {
		return namehouses;
	}
	public String getAffiliation() {
		return affiliation;
	}
	public String getAddress() {
		return address;
	}
	public String getConstructionArea() {
		return constructionArea;
	}
	public String getValue() {
		return value;
	}
	public String getCoownerName() {
		return coownerName;
	}
	public String getAffiliationLand() {
		return affiliationLand;
	}
	public String getAddressLand() {
		return addressLand;
	}
	public String getConstructionAreaLand() {
		return constructionAreaLand;
	}
	public String getValueLand() {
		return valueLand;
	}
	public String getCoownerNameLand() {
		return coownerNameLand;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPropertyCertificateNumber(String propertyCertificateNumber) {
		this.propertyCertificateNumber = propertyCertificateNumber;
	}
	public void setWhetherOwnershipCertificates(int whetherOwnershipCertificates) {
		this.whetherOwnershipCertificates = whetherOwnershipCertificates;
	}
	public void setDeed(String deed) {
		this.deed = deed;
	}
	public void setLandCertificate(String landCertificate) {
		this.landCertificate = landCertificate;
	}
	public void setNamehouses(String namehouses) {
		this.namehouses = namehouses;
	}
	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setConstructionArea(String constructionArea) {
		this.constructionArea = constructionArea;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public void setCoownerName(String coownerName) {
		this.coownerName = coownerName;
	}
	public void setAffiliationLand(String affiliationLand) {
		this.affiliationLand = affiliationLand;
	}
	public void setAddressLand(String addressLand) {
		this.addressLand = addressLand;
	}
	public void setConstructionAreaLand(String constructionAreaLand) {
		this.constructionAreaLand = constructionAreaLand;
	}
	public void setValueLand(String valueLand) {
		this.valueLand = valueLand;
	}
	public void setCoownerNameLand(String coownerNameLand) {
		this.coownerNameLand = coownerNameLand;
	}
	public String getTypeHous() {
		return typeHous;
	}
	public String getTypeLand() {
		return typeLand;
	}
	public void setTypeHous(String typeHous) {
		this.typeHous = typeHous;
	}
	public void setTypeLand(String typeLand) {
		this.typeLand = typeLand;
	}
	public String getNameLand() {
		return nameLand;
	}
	public void setNameLand(String nameLand) {
		this.nameLand = nameLand;
	}
	public String getLandTypeCertificate() {
		return landTypeCertificate;
	}
	public void setLandTypeCertificate(String landTypeCertificate) {
		this.landTypeCertificate = landTypeCertificate;
	}
	public String getWhetherCoowner() {
		return whetherCoowner;
	}
	public String getWhetherLeaseLand() {
		return whetherLeaseLand;
	}
	public String getWhetherCoownerLand() {
		return whetherCoownerLand;
	}
	public String getFinancingSituationLand() {
		return financingSituationLand;
	}
	public void setWhetherCoowner(String whetherCoowner) {
		this.whetherCoowner = whetherCoowner;
	}
	public void setWhetherLeaseLand(String whetherLeaseLand) {
		this.whetherLeaseLand = whetherLeaseLand;
	}
	public void setWhetherCoownerLand(String whetherCoownerLand) {
		this.whetherCoownerLand = whetherCoownerLand;
	}
	public void setFinancingSituationLand(String financingSituationLand) {
		this.financingSituationLand = financingSituationLand;
	}
	public String getWhetherLease() {
		return whetherLease;
	}
	public void setWhetherLease(String whetherLease) {
		this.whetherLease = whetherLease;
	}
	public String getFinancingSituation() {
		return financingSituation;
	}
	public void setFinancingSituation(String financingSituation) {
		this.financingSituation = financingSituation;
	}

}
