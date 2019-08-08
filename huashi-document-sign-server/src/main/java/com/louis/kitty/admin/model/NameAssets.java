package com.louis.kitty.admin.model;

/**
 * ---------------------------
 * 所属名下资产信息表 (NameAssets)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-08 11:53:18
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public class NameAssets {

	/** 编号 */
	private Long id;
	/** 质押物信息表id */
	private Long pawnId;
	/** 名下资产id */
	private Integer assetsId;

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

	public Integer getAssetsId() {
		return assetsId;
	}

	public void setAssetsId(Integer assetsId) {
		this.assetsId = assetsId;
	}

}