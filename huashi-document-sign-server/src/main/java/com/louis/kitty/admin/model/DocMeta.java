package com.louis.kitty.admin.model;

import lombok.Builder;

/**
 * ---------------------------
 *  (DocMeta)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-06 09:28:57
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Builder
public class DocMeta {

	/**  */
	private Long id;
	/** 文件原名称 */
	private String originName;
	/** 文件新名称 */
	private String newName;
	/** 文件类型， xls, doc,image */
	private String type;
	/** 文件大小，存储字节 */
	private Long size;
	/** 存储路径(物理路径) */
	private String path;
	/** 网络全路径 */
	private String url;
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

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public String getNewName() {
		return newName;
	}

	public void setNewName(String newName) {
		this.newName = newName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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