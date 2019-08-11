package com.louis.kitty.admin.sevice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.louis.kitty.core.page.MybatisPageHelper;
import com.louis.kitty.core.page.PageRequest;
import com.louis.kitty.core.page.PageResult;

import com.louis.kitty.admin.model.PawnPersonnelMapping;
import com.louis.kitty.admin.dao.PawnPersonnelMappingMapper;
import com.louis.kitty.admin.sevice.PawnPersonnelMappingService;

/**
 * ---------------------------
 * 所属名下资产信息表 (PawnPersonnelMappingServiceImpl)         
 * ---------------------------
 * 作者： lz
 * 时间：  2019-08-11 14:54:27
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class PawnPersonnelMappingServiceImpl implements PawnPersonnelMappingService {

	@Autowired
	private PawnPersonnelMappingMapper pawnPersonnelMappingMapper;

	@Override
	public int save(PawnPersonnelMapping record) {
		if(record.getId() == null || record.getId() == 0) {
			return pawnPersonnelMappingMapper.add(record);
		}
		return pawnPersonnelMappingMapper.update(record);
	}

	@Override
	public int delete(PawnPersonnelMapping record) {
		return pawnPersonnelMappingMapper.delete(record.getId());
	}

	@Override
	public int delete(List<PawnPersonnelMapping> records) {
		for(PawnPersonnelMapping record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public PawnPersonnelMapping findById(Long id) {
		return pawnPersonnelMappingMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, pawnPersonnelMappingMapper);
	}
	
}
