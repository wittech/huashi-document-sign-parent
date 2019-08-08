package com.louis.kitty.admin.sevice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.louis.kitty.core.page.MybatisPageHelper;
import com.louis.kitty.core.page.PageRequest;
import com.louis.kitty.core.page.PageResult;

import com.louis.kitty.admin.model.NameAssets;
import com.louis.kitty.admin.dao.NameAssetsMapper;
import com.louis.kitty.admin.sevice.NameAssetsService;

/**
 * ---------------------------
 * 所属名下资产信息表 (NameAssetsServiceImpl)         
 * ---------------------------
 * 作者： lz
 * 时间：  2019-08-08 11:53:18
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class NameAssetsServiceImpl implements NameAssetsService {

	@Autowired
	private NameAssetsMapper nameAssetsMapper;

	@Override
	public int save(NameAssets record) {
		if(record.getId() == null || record.getId() == 0) {
			return nameAssetsMapper.add(record);
		}
		return nameAssetsMapper.update(record);
	}

	@Override
	public int delete(NameAssets record) {
		return nameAssetsMapper.delete(record.getId());
	}

	@Override
	public int delete(List<NameAssets> records) {
		for(NameAssets record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public NameAssets findById(Long id) {
		return nameAssetsMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, nameAssetsMapper);
	}
	
}
