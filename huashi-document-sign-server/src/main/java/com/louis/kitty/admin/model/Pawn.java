package com.louis.kitty.admin.model;

/**
 * ---------------------------
 * 抵押物信息表 (Pawn)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-08 11:53:18
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public class Pawn {

	/** 编号 */
	private Long id;
	/** 基础信息表id */
	private Long loanBasisId;
	/** 抵押物类型 0房屋 1土地 */
	private Integer mortgageType;
	/** 0房屋：是否不动产权证 0不动产权证 1非不动产权证 */
	private Integer whetherOwnershipCertificates;
	/** 0房屋：不动产权证号 */
	private String propertyCertificateNumber;
	/** 0房屋：房屋建筑面积㎡ */
	private String buildingArea;
	/** 1土地：土地证号 */
	private String landCertificateNumber;
	/** 1土地：土地占用面积㎡ */
	private String landOccupationArea;
	/** 土地性质 1出让 2划拨 */
	private Integer landNature;
	/** 抵押物名称 */
	private String collateralName;
	/** 抵押物所属地 */
	private String affiliation;
	/** 抵押物存放地 */
	private String collateralDeposit;
	/** 评估公司 */
	private String evaluationCorporation;
	/** 价值 */
	private String value;
	/** 是否有共有人 0否 1是 */
	private Integer whetherCoowner;
	/** 共有人姓名 */
	private String coownerName;
	/** 是否有租赁 0否 1是 */
	private Integer whetherLease;
	/** 租赁合同名称 */
	private String leaseContractName;
	/** 承租方姓名 */
	private String lesseeName;
	/** 承租期限开始时间 */
	private java.util.Date leaseTermStartTime;
	/** 承租期限截止时间 */
	private java.util.Date leaseTermEndTime;
	/** 租金支付方式 1按月 2按季 3按半年 4按年 */
	private Integer rentPaymentMethod;
	/** 合同签署时间 */
	private java.util.Date contractSigningTime;
	/** 所属名下id */
	private Long nameAssetsId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getLoanBasisId() {
		return loanBasisId;
	}

	public void setLoanBasisId(Long loanBasisId) {
		this.loanBasisId = loanBasisId;
	}

	public Integer getMortgageType() {
		return mortgageType;
	}

	public void setMortgageType(Integer mortgageType) {
		this.mortgageType = mortgageType;
	}

	public Integer getWhetherOwnershipCertificates() {
		return whetherOwnershipCertificates;
	}

	public void setWhetherOwnershipCertificates(Integer whetherOwnershipCertificates) {
		this.whetherOwnershipCertificates = whetherOwnershipCertificates;
	}

	public String getPropertyCertificateNumber() {
		return propertyCertificateNumber;
	}

	public void setPropertyCertificateNumber(String propertyCertificateNumber) {
		this.propertyCertificateNumber = propertyCertificateNumber;
	}

	public String getBuildingArea() {
		return buildingArea;
	}

	public void setBuildingArea(String buildingArea) {
		this.buildingArea = buildingArea;
	}

	public String getLandCertificateNumber() {
		return landCertificateNumber;
	}

	public void setLandCertificateNumber(String landCertificateNumber) {
		this.landCertificateNumber = landCertificateNumber;
	}

	public String getLandOccupationArea() {
		return landOccupationArea;
	}

	public void setLandOccupationArea(String landOccupationArea) {
		this.landOccupationArea = landOccupationArea;
	}

	public Integer getLandNature() {
		return landNature;
	}

	public void setLandNature(Integer landNature) {
		this.landNature = landNature;
	}

	public String getCollateralName() {
		return collateralName;
	}

	public void setCollateralName(String collateralName) {
		this.collateralName = collateralName;
	}

	public String getAffiliation() {
		return affiliation;
	}

	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}

	public String getCollateralDeposit() {
		return collateralDeposit;
	}

	public void setCollateralDeposit(String collateralDeposit) {
		this.collateralDeposit = collateralDeposit;
	}

	public String getEvaluationCorporation() {
		return evaluationCorporation;
	}

	public void setEvaluationCorporation(String evaluationCorporation) {
		this.evaluationCorporation = evaluationCorporation;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getWhetherCoowner() {
		return whetherCoowner;
	}

	public void setWhetherCoowner(Integer whetherCoowner) {
		this.whetherCoowner = whetherCoowner;
	}

	public String getCoownerName() {
		return coownerName;
	}

	public void setCoownerName(String coownerName) {
		this.coownerName = coownerName;
	}

	public Integer getWhetherLease() {
		return whetherLease;
	}

	public void setWhetherLease(Integer whetherLease) {
		this.whetherLease = whetherLease;
	}

	public String getLeaseContractName() {
		return leaseContractName;
	}

	public void setLeaseContractName(String leaseContractName) {
		this.leaseContractName = leaseContractName;
	}

	public String getLesseeName() {
		return lesseeName;
	}

	public void setLesseeName(String lesseeName) {
		this.lesseeName = lesseeName;
	}

	public java.util.Date getLeaseTermStartTime() {
		return leaseTermStartTime;
	}

	public void setLeaseTermStartTime(java.util.Date leaseTermStartTime) {
		this.leaseTermStartTime = leaseTermStartTime;
	}

	public java.util.Date getLeaseTermEndTime() {
		return leaseTermEndTime;
	}

	public void setLeaseTermEndTime(java.util.Date leaseTermEndTime) {
		this.leaseTermEndTime = leaseTermEndTime;
	}

	public Integer getRentPaymentMethod() {
		return rentPaymentMethod;
	}

	public void setRentPaymentMethod(Integer rentPaymentMethod) {
		this.rentPaymentMethod = rentPaymentMethod;
	}

	public java.util.Date getContractSigningTime() {
		return contractSigningTime;
	}

	public void setContractSigningTime(java.util.Date contractSigningTime) {
		this.contractSigningTime = contractSigningTime;
	}

	public Long getNameAssetsId() {
		return nameAssetsId;
	}

	public void setNameAssetsId(Long nameAssetsId) {
		this.nameAssetsId = nameAssetsId;
	}

}