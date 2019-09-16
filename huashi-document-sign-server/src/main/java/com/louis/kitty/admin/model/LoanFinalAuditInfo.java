package com.louis.kitty.admin.model;



public class LoanFinalAuditInfo {


    private Integer id;

    private Integer loanBasisId;

    private Double loanAmount;

    private String loanLimit;

    private String interestRateType;

    private Double interestRate;

    private String floatedType;

    private Double floatedRate;

    private Double yearInterestRate;

    private String interestType;

    private String repaymentType;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLoanBasisId() {
        return loanBasisId;
    }

    public void setLoanBasisId(Integer loanBasisId) {
        this.loanBasisId = loanBasisId;
    }

    public Double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getLoanLimit() {
        return loanLimit;
    }

    public void setLoanLimit(String loanLimit) {
        this.loanLimit = loanLimit;
    }

    public String getInterestRateType() {
        return interestRateType;
    }

    public void setInterestRateType(String interestRateType) {
        this.interestRateType = interestRateType;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public String getFloatedType() {
        return floatedType;
    }

    public void setFloatedType(String floatedType) {
        this.floatedType = floatedType;
    }

    public Double getFloatedRate() {
        return floatedRate;
    }

    public void setFloatedRate(Double floatedRate) {
        this.floatedRate = floatedRate;
    }

    public Double getYearInterestRate() {
        return yearInterestRate;
    }

    public void setYearInterestRate(Double yearInterestRate) {
        this.yearInterestRate = yearInterestRate;
    }

    public String getInterestType() {
        return interestType;
    }

    public void setInterestType(String interestType) {
        this.interestType = interestType;
    }

    public String getRepaymentType() {
        return repaymentType;
    }

    public void setRepaymentType(String repaymentType) {
        this.repaymentType = repaymentType;
    }
}
