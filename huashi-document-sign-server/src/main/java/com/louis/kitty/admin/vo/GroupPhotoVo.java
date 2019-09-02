/**
 * 
 */
package com.louis.kitty.admin.vo;

import java.io.Serializable;
import java.util.List;

import com.louis.kitty.admin.model.GroupPhoto;

/**
 * 合影
 * @author 15858
 *
 */
public class GroupPhotoVo implements Serializable{

	private static final long serialVersionUID = -8413269455479144649L;
	private List<GroupPhoto> filePhotoList;
	private Long loanBasisId;
	public List<GroupPhoto> getFilePhotoList() {
		return filePhotoList;
	}
	public Long getLoanBasisId() {
		return loanBasisId;
	}
	public void setFilePhotoList(List<GroupPhoto> filePhotoList) {
		this.filePhotoList = filePhotoList;
	}
	public void setLoanBasisId(Long loanBasisId) {
		this.loanBasisId = loanBasisId;
	}
	
	

}
