package com.louis.kitty.admin.sevice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.louis.kitty.admin.dao.SysConfigurationMapper;
import com.louis.kitty.admin.model.SysConfiguration;
import com.louis.kitty.admin.sevice.SysConfigurationService;
import com.louis.kitty.core.page.MybatisPageHelper;
import com.louis.kitty.core.page.PageRequest;
import com.louis.kitty.core.page.PageResult;

/**
 * ---------------------------
 * 系统配置信息表 (SysConfigurationServiceImpl)         
 * ---------------------------
 * 作者： lz
 * 时间：  2019-07-17 21:19:18
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class SysConfigurationServiceImpl implements SysConfigurationService {

	@Autowired
	private SysConfigurationMapper sysConfigurationMapper;

	@Override
	public int save(SysConfiguration record) {
		if(record.getId() == null || record.getId() == 0) {
			return sysConfigurationMapper.add(record);
		}
		return sysConfigurationMapper.update(record);
	}

	@Override
	public int delete(SysConfiguration record) {
		return sysConfigurationMapper.delete(record.getId());
	}

	@Override
	public int delete(List<SysConfiguration> records) {
		for(SysConfiguration record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public SysConfiguration findById(Long id) {
		return sysConfigurationMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, sysConfigurationMapper);
	}
	
}
