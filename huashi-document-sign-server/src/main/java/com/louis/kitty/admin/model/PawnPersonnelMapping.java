package com.louis.kitty.admin.model;

/**
 * ---------------------------
 * 所属名下资产信息表 (PawnPersonnelMapping)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-11 11:52:37
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public class PawnPersonnelMapping {

	/** 编号 */
	private Long id;
	/** 抵押物信息表id */
	private Long pawnId;
	/** 相关人ID */
	private Long rpiId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPawnId() {
		return pawnId;
	}

	public void setPawnId(Long pawnId) {
		this.pawnId = pawnId;
	}

	public Long getRpiId() {
		return rpiId;
	}

	public void setRpiId(Long rpiId) {
		this.rpiId = rpiId;
	}

}