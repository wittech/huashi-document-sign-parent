package com.louis.kitty.admin.sevice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.louis.kitty.core.page.MybatisPageHelper;
import com.louis.kitty.core.page.PageRequest;
import com.louis.kitty.core.page.PageResult;

import com.louis.kitty.admin.model.AssetTypeCar;
import com.louis.kitty.admin.dao.AssetTypeCarMapper;
import com.louis.kitty.admin.sevice.AssetTypeCarService;

/**
 * ---------------------------
 * 资产类型汽车信息表 (AssetTypeCarServiceImpl)         
 * ---------------------------
 * 作者： lz
 * 时间：  2019-08-08 11:53:17
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class AssetTypeCarServiceImpl implements AssetTypeCarService {

	@Autowired
	private AssetTypeCarMapper assetTypeCarMapper;

	@Override
	public int save(AssetTypeCar record) {
		if(record.getId() == null || record.getId() == 0) {
			return assetTypeCarMapper.add(record);
		}
		return assetTypeCarMapper.update(record);
	}

	@Override
	public int delete(AssetTypeCar record) {
		return assetTypeCarMapper.delete(record.getId());
	}

	@Override
	public int delete(List<AssetTypeCar> records) {
		for(AssetTypeCar record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public AssetTypeCar findById(Long id) {
		return assetTypeCarMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, assetTypeCarMapper);
	}
	
}
