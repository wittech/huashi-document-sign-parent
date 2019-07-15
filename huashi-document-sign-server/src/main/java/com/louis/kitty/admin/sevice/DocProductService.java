/**
 * 
 */
package com.louis.kitty.admin.sevice;

import java.util.List;

import com.louis.kitty.admin.model.NoticeAnnouncementModel;

/**
 * 文档模板管理
 * 
 * @author lz
 *
 */
public interface DocProductService {
	/**
	 * 根据产品名称 状态 查询列表数据
	 * 
	 * @param title
	 * @param status
	 * @return
	 */
	List<NoticeAnnouncementModel> findByNameAndStatus(String title, int status);
}
