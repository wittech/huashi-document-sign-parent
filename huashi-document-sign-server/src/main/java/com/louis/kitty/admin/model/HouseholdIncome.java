package com.louis.kitty.admin.model;

/**
 * ---------------------------
 * 家庭收入信息表 (HouseholdIncome)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-08 11:53:18
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public class HouseholdIncome {

	/** 编号 */
	private Long id;
	/** 姓名 */
	private String name;
	/** 基础信息表id */
	private Long loanBasisId;
	/** 总资产 */
	private Double totalAssets;
	/** 总收入 */
	private Double totalRevenue;
	/** 申请人年薪金收入 */
	private Double applicantAnnualIncome;
	/** 申请人年经营性收入 */
	private Double applicantOperatingIncome;
	/** 申请人其他收入 */
	private Double applicantOtherIncome;
	/** 申请人配偶年薪金收入 */
	private Double spouseAnnualIncome;
	/** 申请人配偶年经营性收入 */
	private Double spouseOperatingIncome;
	/** 申请人配偶其他收入 */
	private Double spouseOtherIncome;
	/** 家庭年总支出 */
	private Double totalAnnualExpenditure;
	/** 年日常生活总支出 */
	private Double lifeTotalExpenditure;
	/** 年日常基本生活支出 */
	private Double basicLifeTotalExpenditure;
	/** 年子女教育支出 */
	private Double educationExpenditure;
	/** 年其他临时性支出 */
	private Double temporaryExpenditure;
	/** 年债务性总支出 */
	private Double debtTotalExpenditure;
	/** 申请人年还贷支出 */
	private Double annualLoanExpenditure;
	/** 申请人配偶年还贷支出 */
	private Double spouseTemporaryExpenditure;
	/** 家庭供养人口 */
	private Integer supportPopulation;
	/** 家庭对外担保总额 */
	private Double foreignGuaranteeLumpSum;
	/** 家庭对外担保总额 */
	private Double totalLiability;
	/** 备注 */
	private String remark;

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

	public Double getTotalAssets() {
		return totalAssets;
	}

	public void setTotalAssets(Double totalAssets) {
		this.totalAssets = totalAssets;
	}

	public Double getTotalRevenue() {
		return totalRevenue;
	}

	public void setTotalRevenue(Double totalRevenue) {
		this.totalRevenue = totalRevenue;
	}

	public Double getApplicantAnnualIncome() {
		return applicantAnnualIncome;
	}

	public void setApplicantAnnualIncome(Double applicantAnnualIncome) {
		this.applicantAnnualIncome = applicantAnnualIncome;
	}

	public Double getApplicantOperatingIncome() {
		return applicantOperatingIncome;
	}

	public void setApplicantOperatingIncome(Double applicantOperatingIncome) {
		this.applicantOperatingIncome = applicantOperatingIncome;
	}

	public Double getApplicantOtherIncome() {
		return applicantOtherIncome;
	}

	public void setApplicantOtherIncome(Double applicantOtherIncome) {
		this.applicantOtherIncome = applicantOtherIncome;
	}

	public Double getSpouseAnnualIncome() {
		return spouseAnnualIncome;
	}

	public void setSpouseAnnualIncome(Double spouseAnnualIncome) {
		this.spouseAnnualIncome = spouseAnnualIncome;
	}

	public Double getSpouseOperatingIncome() {
		return spouseOperatingIncome;
	}

	public void setSpouseOperatingIncome(Double spouseOperatingIncome) {
		this.spouseOperatingIncome = spouseOperatingIncome;
	}

	public Double getSpouseOtherIncome() {
		return spouseOtherIncome;
	}

	public void setSpouseOtherIncome(Double spouseOtherIncome) {
		this.spouseOtherIncome = spouseOtherIncome;
	}

	public Double getTotalAnnualExpenditure() {
		return totalAnnualExpenditure;
	}

	public void setTotalAnnualExpenditure(Double totalAnnualExpenditure) {
		this.totalAnnualExpenditure = totalAnnualExpenditure;
	}

	public Double getLifeTotalExpenditure() {
		return lifeTotalExpenditure;
	}

	public void setLifeTotalExpenditure(Double lifeTotalExpenditure) {
		this.lifeTotalExpenditure = lifeTotalExpenditure;
	}

	public Double getBasicLifeTotalExpenditure() {
		return basicLifeTotalExpenditure;
	}

	public void setBasicLifeTotalExpenditure(Double basicLifeTotalExpenditure) {
		this.basicLifeTotalExpenditure = basicLifeTotalExpenditure;
	}

	public Double getEducationExpenditure() {
		return educationExpenditure;
	}

	public void setEducationExpenditure(Double educationExpenditure) {
		this.educationExpenditure = educationExpenditure;
	}

	public Double getTemporaryExpenditure() {
		return temporaryExpenditure;
	}

	public void setTemporaryExpenditure(Double temporaryExpenditure) {
		this.temporaryExpenditure = temporaryExpenditure;
	}

	public Double getDebtTotalExpenditure() {
		return debtTotalExpenditure;
	}

	public void setDebtTotalExpenditure(Double debtTotalExpenditure) {
		this.debtTotalExpenditure = debtTotalExpenditure;
	}

	public Double getAnnualLoanExpenditure() {
		return annualLoanExpenditure;
	}

	public void setAnnualLoanExpenditure(Double annualLoanExpenditure) {
		this.annualLoanExpenditure = annualLoanExpenditure;
	}

	public Double getSpouseTemporaryExpenditure() {
		return spouseTemporaryExpenditure;
	}

	public void setSpouseTemporaryExpenditure(Double spouseTemporaryExpenditure) {
		this.spouseTemporaryExpenditure = spouseTemporaryExpenditure;
	}

	public Integer getSupportPopulation() {
		return supportPopulation;
	}

	public void setSupportPopulation(Integer supportPopulation) {
		this.supportPopulation = supportPopulation;
	}

	public Double getForeignGuaranteeLumpSum() {
		return foreignGuaranteeLumpSum;
	}

	public void setForeignGuaranteeLumpSum(Double foreignGuaranteeLumpSum) {
		this.foreignGuaranteeLumpSum = foreignGuaranteeLumpSum;
	}

	public Double getTotalLiability() {
		return totalLiability;
	}

	public void setTotalLiability(Double totalLiability) {
		this.totalLiability = totalLiability;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}