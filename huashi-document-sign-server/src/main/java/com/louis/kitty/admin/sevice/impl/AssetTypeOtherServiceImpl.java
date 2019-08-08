package com.louis.kitty.admin.sevice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.louis.kitty.core.page.MybatisPageHelper;
import com.louis.kitty.core.page.PageRequest;
import com.louis.kitty.core.page.PageResult;

import com.louis.kitty.admin.model.AssetTypeOther;
import com.louis.kitty.admin.dao.AssetTypeOtherMapper;
import com.louis.kitty.admin.sevice.AssetTypeOtherService;

/**
 * ---------------------------
 * 资产类型其他信息表 (AssetTypeOtherServiceImpl)         
 * ---------------------------
 * 作者： lz
 * 时间：  2019-08-08 11:53:18
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class AssetTypeOtherServiceImpl implements AssetTypeOtherService {

	@Autowired
	private AssetTypeOtherMapper assetTypeOtherMapper;

	@Override
	public int save(AssetTypeOther record) {
		if(record.getId() == null || record.getId() == 0) {
			return assetTypeOtherMapper.add(record);
		}
		return assetTypeOtherMapper.update(record);
	}

	@Override
	public int delete(AssetTypeOther record) {
		return assetTypeOtherMapper.delete(record.getId());
	}

	@Override
	public int delete(List<AssetTypeOther> records) {
		for(AssetTypeOther record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public AssetTypeOther findById(Long id) {
		return assetTypeOtherMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, assetTypeOtherMapper);
	}
	
}
