package com.louis.kitty.admin.model;

import java.math.BigDecimal;
import java.util.Date;

public class LoanFinalAuditInfo {
    /**
	* 主键编号
	*/
    private Long id;

    /**
	* 借款人编号
	*/
    private Long loanBasisId;

    /**
	* 借款金额
	*/
    private BigDecimal loanAmount;

    /**
	* 借款期限
	*/
    private String loanLimit;

    /**
	* 利率标准
	*/
    private String interestRateType;

    /**
	* 利率
	*/
    private BigDecimal interestRate;

    /**
	* 浮动方式
	*/
    private String floatedType;

    /**
	* 浮动利率
	*/
    private BigDecimal floatedRate;

    /**
	* 年利率
	*/
    private BigDecimal yearInterestRate;

    /**
	* 结息方式 按月/按月/按年
	*/
    private String interestType;

    /**
	* 还款方式 利随本清 到期一次性还本 分期还本 等额本金 等额本息  其他
	*/
    private String repaymentType;

    /**
	* 其他还款方式
	*/
    private String otherRepayment;

    /**
	* 创建时间
	*/
    private Date createTime;

    /**
     * 创建人
     */
    private String createBy;

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

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
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

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public String getFloatedType() {
        return floatedType;
    }

    public void setFloatedType(String floatedType) {
        this.floatedType = floatedType;
    }

    public BigDecimal getFloatedRate() {
        return floatedRate;
    }

    public void setFloatedRate(BigDecimal floatedRate) {
        this.floatedRate = floatedRate;
    }

    public BigDecimal getYearInterestRate() {
        return yearInterestRate;
    }

    public void setYearInterestRate(BigDecimal yearInterestRate) {
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

    public String getOtherRepayment() {
        return otherRepayment;
    }

    public void setOtherRepayment(String otherRepayment) {
        this.otherRepayment = otherRepayment;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
}