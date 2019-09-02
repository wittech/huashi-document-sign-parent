package com.louis.kitty.admin.sevice;

import com.louis.kitty.admin.model.GroupPhoto;
import com.louis.kitty.core.service.CurdService;

/**
 * ---------------------------
 * 合影信息表 (GroupPhotoService)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-08 11:53:18
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface GroupPhotoService extends CurdService<GroupPhoto> {
	
	/**
	 * 
	 * @param loanBasicId
	 * @return
	 */
	int deleteByLoanBasicId(Long loanBasicId);
}
