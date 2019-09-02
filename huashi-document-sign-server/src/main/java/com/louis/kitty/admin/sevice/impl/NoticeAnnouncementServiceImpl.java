package com.louis.kitty.admin.sevice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.louis.kitty.admin.dao.NoticeAnnouncementMapper;
import com.louis.kitty.admin.model.NoticeAnnouncementModel;
import com.louis.kitty.admin.sevice.NoticeAnnouncementService;
import com.louis.kitty.core.page.ColumnFilter;
import com.louis.kitty.core.page.MybatisPageHelper;
import com.louis.kitty.core.page.PageRequest;
import com.louis.kitty.core.page.PageResult;

import javax.annotation.Resource;

@Service
public class NoticeAnnouncementServiceImpl implements NoticeAnnouncementService {

	@Resource
	private NoticeAnnouncementMapper noticeAnnouncementMapper;
	
	@Override
	public int save(NoticeAnnouncementModel record) {
		if(record.getId() == null || record.getId() == 0) {
			return noticeAnnouncementMapper.insertSelective(record);
		}
		return noticeAnnouncementMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int delete(NoticeAnnouncementModel record) {
		return noticeAnnouncementMapper.deleteByPrimaryKey(record.getId());
	}

	@Override
	public int delete(List<NoticeAnnouncementModel> records) {
		for(NoticeAnnouncementModel record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public NoticeAnnouncementModel findById(Long id) {
		return noticeAnnouncementMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		ColumnFilter columnFilter = pageRequest.getColumnFilter("title");
		if(columnFilter != null) {
			return MybatisPageHelper.findPage(pageRequest, noticeAnnouncementMapper, "findPageByTitle", columnFilter.getValue());
		}
		return MybatisPageHelper.findPage(pageRequest, noticeAnnouncementMapper);
	}

	@Override
	public List<NoticeAnnouncementModel> findByTitle(String title) {
		return noticeAnnouncementMapper.findByTitle(title);
	}

	@Override
	public NoticeAnnouncementModel getLastest() {
		return noticeAnnouncementMapper.selectLastestOne();
	}
}
