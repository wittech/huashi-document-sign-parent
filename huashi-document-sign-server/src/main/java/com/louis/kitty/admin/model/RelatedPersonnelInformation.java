package com.louis.kitty.admin.model;

import java.util.List;

/**
 * ---------------------------
 * 相关人员信息表 (RelatedPersonnelInformation)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-10 22:28:24
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public class RelatedPersonnelInformation {

	/** 编号 */
	private Long id;
	/** 姓名 */
	private String name;
	/** 基础信息表id */
	private Long loanBasisId;
	/** 类型（1、结款人）（2、抵押担保人）（3、抵押担保人） （4、保证担保人）（5、抵押担保人和保证担保人） */
	private Integer type;
	/** 年龄 */
	private Integer age;
	/** 性别 0男 1女 */
	private Integer sex;
	/** 身份证号码 */
	private String identityNumber;
	/** 户籍所在地 */
	private String domicile;
	/** 现居住地址 */
	private String currentHomeAddress;
	/** 常用通信地址 （0、现居住地址）（1、单位地址）（2、其他） */
	private Integer contactAddress;
	/** 本地居住时间 */
	private String localResidenceTime;
	/** 电子邮箱 */
	private String email;
	/** 联系电话 */
	private String contactNumber;
	/** qq */
	private String qq;
	/** 微信号 */
	private String wechat;
	/** 文化程度 （0、研究生及以上）（1、本科）（2、大专）（3、中专/高中）（4、初中）（5、其他） */
	private Integer educationalLevel;
	/** 文化程度（5、其他）内容 */
	private String educationalLevelValue;
	/** 现住房来源（0、自有住房）（1、贷款自有）（2、单位宿舍）（3、与父母同住）（4、租赁）（5、其他） */
	private Integer currentHousingSource;
	/** 现住房来源（5、其他）值 */
	private String currentHousingSourceValue;
	/** 工作单位 */
	private String employer;
	/** 职务 */
	private String position;
	/** 单位工作年限 */
	private Integer unitWorkingYears;
	/** 所投资或经营企业名称 */
	private String companyName;
	/** 持股比例 */
	private String shareholdingRatio;
	/** 本行业和相近行业经营年限 */
	private Integer yearsOperation;
	/** 资产情况（0、无）（1、有） */
	private Integer assetSituation;
	/** 资产类型（1、房屋）（2、土地）（3、汽车）（4、有价证券）（5、其他） */
	private Integer assetType;
	/** 婚姻状况（0、未婚）（1、已婚）（2、离异未婚）（3、丧偶未婚）（4、其他） */
	private Integer maritalStatus;
	/** 原配偶姓名 */
	private String originalSpouseName;
	/** 离婚方式 （1、协议离婚）（2、诉讼离婚） */
	private Integer divorceMethod;
	/** 时间 */
	private java.util.Date divorceTime;
	/** 备注 */
	private String remark;
	/** 配偶ID， 主加人 为0， 附加配偶 存储主加人ID */
	private Long coupleId;
	/** 创建人 */
	private String createBy;
	/** 创建时间 */
	private java.util.Date createTime;
	/** 更新人 */
	private String lastUpdateBy;
	/** 更新时间 */
	private java.util.Date lastUpdateTime;
	/** 是否删除  -1：已删除  0：正常 */
	private Integer delFlag;
	//房屋
	private List<AssetTypeHouses> assetTypeHouses;
	//土地
	private List<AssetTypeLand> assetTypeLand;
	//汽车
	private List<AssetTypeCar> assetTypeCar;
	//证券
	private List<AssetTypeSecurities> assetTypeSecurities;
	//其他
	private List<AssetTypeOther> assetTypeOther;
	//配偶信息
	private RelatedPersonnelInformation spouseInfo;
	/** 家庭收支情况 */
	private HouseholdIncome householdIncomeForm;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getLoanBasisId() {
		return loanBasisId;
	}

	public void setLoanBasisId(Long loanBasisId) {
		this.loanBasisId = loanBasisId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getIdentityNumber() {
		return identityNumber;
	}

	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}

	public String getDomicile() {
		return domicile;
	}

	public void setDomicile(String domicile) {
		this.domicile = domicile;
	}

	public String getCurrentHomeAddress() {
		return currentHomeAddress;
	}

	public void setCurrentHomeAddress(String currentHomeAddress) {
		this.currentHomeAddress = currentHomeAddress;
	}

	public Integer getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(Integer contactAddress) {
		this.contactAddress = contactAddress;
	}

	public String getLocalResidenceTime() {
		return localResidenceTime;
	}

	public void setLocalResidenceTime(String localResidenceTime) {
		this.localResidenceTime = localResidenceTime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public Integer getEducationalLevel() {
		return educationalLevel;
	}

	public void setEducationalLevel(Integer educationalLevel) {
		this.educationalLevel = educationalLevel;
	}

	public String getEducationalLevelValue() {
		return educationalLevelValue;
	}

	public void setEducationalLevelValue(String educationalLevelValue) {
		this.educationalLevelValue = educationalLevelValue;
	}

	public Integer getCurrentHousingSource() {
		return currentHousingSource;
	}

	public void setCurrentHousingSource(Integer currentHousingSource) {
		this.currentHousingSource = currentHousingSource;
	}

	public String getCurrentHousingSourceValue() {
		return currentHousingSourceValue;
	}

	public void setCurrentHousingSourceValue(String currentHousingSourceValue) {
		this.currentHousingSourceValue = currentHousingSourceValue;
	}

	public String getEmployer() {
		return employer;
	}

	public void setEmployer(String employer) {
		this.employer = employer;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Integer getUnitWorkingYears() {
		return unitWorkingYears;
	}

	public void setUnitWorkingYears(Integer unitWorkingYears) {
		this.unitWorkingYears = unitWorkingYears;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getShareholdingRatio() {
		return shareholdingRatio;
	}

	public void setShareholdingRatio(String shareholdingRatio) {
		this.shareholdingRatio = shareholdingRatio;
	}

	public Integer getYearsOperation() {
		return yearsOperation;
	}

	public void setYearsOperation(Integer yearsOperation) {
		this.yearsOperation = yearsOperation;
	}

	public Integer getAssetSituation() {
		return assetSituation;
	}

	public void setAssetSituation(Integer assetSituation) {
		this.assetSituation = assetSituation;
	}

	public Integer getAssetType() {
		return assetType;
	}

	public void setAssetType(Integer assetType) {
		this.assetType = assetType;
	}

	public Integer getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(Integer maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getOriginalSpouseName() {
		return originalSpouseName;
	}

	public void setOriginalSpouseName(String originalSpouseName) {
		this.originalSpouseName = originalSpouseName;
	}

	public Integer getDivorceMethod() {
		return divorceMethod;
	}

	public void setDivorceMethod(Integer divorceMethod) {
		this.divorceMethod = divorceMethod;
	}

	public java.util.Date getDivorceTime() {
		return divorceTime;
	}

	public void setDivorceTime(java.util.Date divorceTime) {
		this.divorceTime = divorceTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getCoupleId() {
		return coupleId;
	}

	public void setCoupleId(Long coupleId) {
		this.coupleId = coupleId;
	}

	public List<AssetTypeHouses> getAssetTypeHouses() {
		return assetTypeHouses;
	}

	public void setAssetTypeHouses(List<AssetTypeHouses> assetTypeHouses) {
		this.assetTypeHouses = assetTypeHouses;
	}

	public List<AssetTypeLand> getAssetTypeLand() {
		return assetTypeLand;
	}

	public void setAssetTypeLand(List<AssetTypeLand> assetTypeLand) {
		this.assetTypeLand = assetTypeLand;
	}

	public List<AssetTypeCar> getAssetTypeCar() {
		return assetTypeCar;
	}

	public void setAssetTypeCar(List<AssetTypeCar> assetTypeCar) {
		this.assetTypeCar = assetTypeCar;
	}

	public List<AssetTypeSecurities> getAssetTypeSecurities() {
		return assetTypeSecurities;
	}

	public void setAssetTypeSecurities(List<AssetTypeSecurities> assetTypeSecurities) {
		this.assetTypeSecurities = assetTypeSecurities;
	}

	public List<AssetTypeOther> getAssetTypeOther() {
		return assetTypeOther;
	}

	public void setAssetTypeOther(List<AssetTypeOther> assetTypeOther) {
		this.assetTypeOther = assetTypeOther;
	}

	public HouseholdIncome getHouseholdIncomeForm() {
		return householdIncomeForm;
	}

	public void setHouseholdIncomeForm(HouseholdIncome householdIncomeForm) {
		this.householdIncomeForm = householdIncomeForm;
	}

	public RelatedPersonnelInformation getSpouseInfo() {
		return spouseInfo;
	}

	public void setSpouseInfo(RelatedPersonnelInformation spouseInfo) {
		this.spouseInfo = spouseInfo;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	public String getLastUpdateBy() {
		return lastUpdateBy;
	}

	public void setLastUpdateBy(String lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}

	public java.util.Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(java.util.Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

}