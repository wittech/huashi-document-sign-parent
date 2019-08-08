package com.louis.kitty.admin.sevice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.louis.kitty.core.page.MybatisPageHelper;
import com.louis.kitty.core.page.PageRequest;
import com.louis.kitty.core.page.PageResult;

import com.louis.kitty.admin.model.AssetTypeHouses;
import com.louis.kitty.admin.dao.AssetTypeHousesMapper;
import com.louis.kitty.admin.sevice.AssetTypeHousesService;

/**
 * ---------------------------
 * 资产类型房屋信息表 (AssetTypeHousesServiceImpl)         
 * ---------------------------
 * 作者： lz
 * 时间：  2019-08-08 11:53:17
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class AssetTypeHousesServiceImpl implements AssetTypeHousesService {

	@Autowired
	private AssetTypeHousesMapper assetTypeHousesMapper;

	@Override
	public int save(AssetTypeHouses record) {
		if(record.getId() == null || record.getId() == 0) {
			return assetTypeHousesMapper.add(record);
		}
		return assetTypeHousesMapper.update(record);
	}

	@Override
	public int delete(AssetTypeHouses record) {
		return assetTypeHousesMapper.delete(record.getId());
	}

	@Override
	public int delete(List<AssetTypeHouses> records) {
		for(AssetTypeHouses record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public AssetTypeHouses findById(Long id) {
		return assetTypeHousesMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, assetTypeHousesMapper);
	}
	
}
