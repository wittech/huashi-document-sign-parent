package com.louis.kitty.admin.sevice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.louis.kitty.core.page.MybatisPageHelper;
import com.louis.kitty.core.page.PageRequest;
import com.louis.kitty.core.page.PageResult;

import com.louis.kitty.admin.model.RelatedPersonnelInformation;
import com.louis.kitty.admin.dao.RelatedPersonnelInformationMapper;
import com.louis.kitty.admin.sevice.RelatedPersonnelInformationService;

/**
 * ---------------------------
 * 相关人员信息表 (RelatedPersonnelInformationServiceImpl)         
 * ---------------------------
 * 作者： lz
 * 时间：  2019-08-08 11:53:18
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class RelatedPersonnelInformationServiceImpl implements RelatedPersonnelInformationService {

	@Autowired
	private RelatedPersonnelInformationMapper relatedPersonnelInformationMapper;

	@Override
	public int save(RelatedPersonnelInformation record) {
		if(record.getId() == null || record.getId() == 0) {
			return relatedPersonnelInformationMapper.add(record);
		}
		return relatedPersonnelInformationMapper.update(record);
	}

	@Override
	public int delete(RelatedPersonnelInformation record) {
		return relatedPersonnelInformationMapper.delete(record.getId());
	}

	@Override
	public int delete(List<RelatedPersonnelInformation> records) {
		for(RelatedPersonnelInformation record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public RelatedPersonnelInformation findById(Long id) {
		return relatedPersonnelInformationMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, relatedPersonnelInformationMapper);
	}
	
}
