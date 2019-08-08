package com.louis.kitty.admin.sevice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.louis.kitty.core.page.MybatisPageHelper;
import com.louis.kitty.core.page.PageRequest;
import com.louis.kitty.core.page.PageResult;

import com.louis.kitty.admin.model.AssetTypeSecurities;
import com.louis.kitty.admin.dao.AssetTypeSecuritiesMapper;
import com.louis.kitty.admin.sevice.AssetTypeSecuritiesService;

/**
 * ---------------------------
 * 资产类型证券信息表 (AssetTypeSecuritiesServiceImpl)         
 * ---------------------------
 * 作者： lz
 * 时间：  2019-08-08 11:53:18
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class AssetTypeSecuritiesServiceImpl implements AssetTypeSecuritiesService {

	@Autowired
	private AssetTypeSecuritiesMapper assetTypeSecuritiesMapper;

	@Override
	public int save(AssetTypeSecurities record) {
		if(record.getId() == null || record.getId() == 0) {
			return assetTypeSecuritiesMapper.add(record);
		}
		return assetTypeSecuritiesMapper.update(record);
	}

	@Override
	public int delete(AssetTypeSecurities record) {
		return assetTypeSecuritiesMapper.delete(record.getId());
	}

	@Override
	public int delete(List<AssetTypeSecurities> records) {
		for(AssetTypeSecurities record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public AssetTypeSecurities findById(Long id) {
		return assetTypeSecuritiesMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, assetTypeSecuritiesMapper);
	}
	
}
