package com.louis.kitty.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.louis.kitty.admin.model.NoticeAnnouncementModel;

/**
 * 公告管理
 * 
 * @author lz
 *
 */
public interface NoticeAnnouncementMapper {
	int deleteByPrimaryKey(Long id);

	int insert(NoticeAnnouncementModel record);

	int insertSelective(NoticeAnnouncementModel record);

	NoticeAnnouncementModel selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(NoticeAnnouncementModel record);

	int updateByPrimaryKey(NoticeAnnouncementModel record);

	List<NoticeAnnouncementModel> findPage();

	List<NoticeAnnouncementModel> findPageByTitle(@Param(value = "title") String title);

	List<NoticeAnnouncementModel> findByTitle(@Param(value = "title") String title);

	NoticeAnnouncementModel selectLastestOne();
}
