package com.louis.kitty.admin.sevice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.louis.kitty.core.page.MybatisPageHelper;
import com.louis.kitty.core.page.PageRequest;
import com.louis.kitty.core.page.PageResult;

import com.louis.kitty.admin.model.AssetTypeLand;
import com.louis.kitty.admin.dao.AssetTypeLandMapper;
import com.louis.kitty.admin.sevice.AssetTypeLandService;

/**
 * ---------------------------
 * 资产类型土地信息表 (AssetTypeLandServiceImpl)         
 * ---------------------------
 * 作者： lz
 * 时间：  2019-08-08 11:53:17
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class AssetTypeLandServiceImpl implements AssetTypeLandService {

	@Autowired
	private AssetTypeLandMapper assetTypeLandMapper;

	@Override
	public int save(AssetTypeLand record) {
		if(record.getId() == null || record.getId() == 0) {
			return assetTypeLandMapper.add(record);
		}
		return assetTypeLandMapper.update(record);
	}

	@Override
	public int delete(AssetTypeLand record) {
		return assetTypeLandMapper.delete(record.getId());
	}

	@Override
	public int delete(List<AssetTypeLand> records) {
		for(AssetTypeLand record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public AssetTypeLand findById(Long id) {
		return assetTypeLandMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, assetTypeLandMapper);
	}
	
}
