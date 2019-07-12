package com.louis.kitty.admin.sevice;

import java.util.List;

import com.louis.kitty.admin.model.NoticeAnnouncementModel;
import com.louis.kitty.core.service.CurdService;

/**
 * 公告服务
 * 
 * @author 15858
 *
 */
public interface NoticeAnnouncementService extends CurdService<NoticeAnnouncementModel> {
	/**
	 * 根据名称查询
	 * 
	 * @param lable
	 * @return
	 */
	List<NoticeAnnouncementModel> findByTitle(String title);
}
