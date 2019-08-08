package com.louis.kitty.admin.model;

/**
 * ---------------------------
 * 合影信息表 (GroupPhoto)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-08 11:53:18
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public class GroupPhoto {

	/** 编号 */
	private Long id;
	/** 基础信息表id */
	private Long loanBasisId;
	/** 文件表id */
	private Long docMetaId;

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

	public Long getDocMetaId() {
		return docMetaId;
	}

	public void setDocMetaId(Long docMetaId) {
		this.docMetaId = docMetaId;
	}

}