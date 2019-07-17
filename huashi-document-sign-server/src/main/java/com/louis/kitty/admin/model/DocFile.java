package com.louis.kitty.admin.model;

/**
 * ---------------------------
 *  (DocFile)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-07-17 21:38:51
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public class DocFile {

	/**  */
	private Long id;
	/** 产品ID */
	private Long productId;
	/** 文件名称 */
	private String name;
	/** 文件类型， xls, doc */
	private String type;
	/** 文件大小，存储字节 */
	private Long size;
	/** 存储路径 */
	private String path;
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

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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