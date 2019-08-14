package com.louis.kitty.admin.model;

/**
 * ---------------------------
 *  (LoanCheckDoc)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-14 10:54:33
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public class LoanCheckDoc {

	/**  */
	private Long id;
	/** 贷后检查ID */
	private Long loanCheckId;
	/** 模板名称 */
	private String docName;
	/** 文件大小 */
	private Long docSize;
	/** WORD/EXCEL绝对路径 */
	private String docPath;
	/** 生成的PDF路径 */
	private String pdfPath;
	/** 网络URL */
	private String docUrl;
	/** 下载次数(下载后更新) */
	private Integer downloadTimes;
	/** 打印次数 */
	private Integer printTimes;
	/** 显示顺序 */
	private Integer sort;
	/** 备注 */
	private String remark;
	/**  */
	private java.util.Date createTime;
	/**  */
	private java.util.Date lastUpdateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getLoanCheckId() {
		return loanCheckId;
	}

	public void setLoanCheckId(Long loanCheckId) {
		this.loanCheckId = loanCheckId;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public Long getDocSize() {
		return docSize;
	}

	public void setDocSize(Long docSize) {
		this.docSize = docSize;
	}

	public String getDocPath() {
		return docPath;
	}

	public void setDocPath(String docPath) {
		this.docPath = docPath;
	}

	public String getPdfPath() {
		return pdfPath;
	}

	public void setPdfPath(String pdfPath) {
		this.pdfPath = pdfPath;
	}

	public String getDocUrl() {
		return docUrl;
	}

	public void setDocUrl(String docUrl) {
		this.docUrl = docUrl;
	}

	public Integer getDownloadTimes() {
		return downloadTimes;
	}

	public void setDownloadTimes(Integer downloadTimes) {
		this.downloadTimes = downloadTimes;
	}

	public Integer getPrintTimes() {
		return printTimes;
	}

	public void setPrintTimes(Integer printTimes) {
		this.printTimes = printTimes;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	public java.util.Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(java.util.Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

}