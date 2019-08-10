package com.louis.kitty.admin.sevice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.louis.kitty.core.page.MybatisPageHelper;
import com.louis.kitty.core.page.PageRequest;
import com.louis.kitty.core.page.PageResult;

import com.louis.kitty.admin.model.LitigationInformation;
import com.louis.kitty.admin.dao.LitigationInformationMapper;
import com.louis.kitty.admin.sevice.LitigationInformationService;

/**
 * ---------------------------
 * 诉讼信息表 (LitigationInformationServiceImpl)         
 * ---------------------------
 * 作者： lz
 * 时间：  2019-08-10 10:03:25
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class LitigationInformationServiceImpl implements LitigationInformationService {

	@Autowired
	private LitigationInformationMapper litigationInformationMapper;

	@Override
	public int save(LitigationInformation record) {
		if(record.getId() == null || record.getId() == 0) {
			return litigationInformationMapper.add(record);
		}
		return litigationInformationMapper.update(record);
	}

	@Override
	public int delete(LitigationInformation record) {
		return litigationInformationMapper.delete(record.getId());
	}

	@Override
	public int delete(List<LitigationInformation> records) {
		for(LitigationInformation record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public LitigationInformation findById(Long id) {
		return litigationInformationMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, litigationInformationMapper);
	}
	
}
