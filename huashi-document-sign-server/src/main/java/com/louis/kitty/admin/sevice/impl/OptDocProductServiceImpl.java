package com.louis.kitty.admin.sevice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.louis.kitty.admin.dao.OptDocProductMapper;
import com.louis.kitty.admin.model.OptDocProduct;
import com.louis.kitty.admin.sevice.OptDocProductService;
import com.louis.kitty.core.page.MybatisPageHelper;
import com.louis.kitty.core.page.PageRequest;
import com.louis.kitty.core.page.PageResult;

/**
 * ---------------------------
 *  (OptDocProductServiceImpl)         
 * ---------------------------
 * 作者： lz
 * 时间：  2019-07-17 21:19:18
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class OptDocProductServiceImpl implements OptDocProductService {

	@Autowired
	private OptDocProductMapper optDocProductMapper;

	@Override
	public int save(OptDocProduct record) {
		if(record.getId() == null || record.getId() == 0) {
			return optDocProductMapper.add(record);
		}
		return optDocProductMapper.update(record);
	}

	@Override
	public int delete(OptDocProduct record) {
		return optDocProductMapper.delete(record.getId());
	}

	@Override
	public int delete(List<OptDocProduct> records) {
		for(OptDocProduct record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public OptDocProduct findById(Long id) {
		return optDocProductMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, optDocProductMapper);
	}
	
}
