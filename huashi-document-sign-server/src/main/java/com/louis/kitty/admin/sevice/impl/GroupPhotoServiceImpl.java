package com.louis.kitty.admin.sevice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.louis.kitty.core.page.MybatisPageHelper;
import com.louis.kitty.core.page.PageRequest;
import com.louis.kitty.core.page.PageResult;

import com.louis.kitty.admin.model.GroupPhoto;
import com.louis.kitty.admin.dao.GroupPhotoMapper;
import com.louis.kitty.admin.sevice.GroupPhotoService;

/**
 * ---------------------------
 * 合影信息表 (GroupPhotoServiceImpl)         
 * ---------------------------
 * 作者： lz
 * 时间：  2019-08-08 11:53:18
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class GroupPhotoServiceImpl implements GroupPhotoService {

	@Autowired
	private GroupPhotoMapper groupPhotoMapper;

	@Override
	public int save(GroupPhoto record) {
		if(record.getId() == null || record.getId() == 0) {
			return groupPhotoMapper.add(record);
		}
		return groupPhotoMapper.update(record);
	}

	@Override
	public int delete(GroupPhoto record) {
		return groupPhotoMapper.delete(record.getId());
	}

	@Override
	public int delete(List<GroupPhoto> records) {
		for(GroupPhoto record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public GroupPhoto findById(Long id) {
		return groupPhotoMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, groupPhotoMapper);
	}

	@Override
	public int deleteByLoanBasicId(Long loanBasicId) {
		return groupPhotoMapper.deleteByLoanBasicId(loanBasicId);
	}
	
}
