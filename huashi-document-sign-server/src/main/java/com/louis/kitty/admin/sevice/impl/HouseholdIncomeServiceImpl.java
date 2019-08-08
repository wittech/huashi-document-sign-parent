package com.louis.kitty.admin.sevice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.louis.kitty.core.page.MybatisPageHelper;
import com.louis.kitty.core.page.PageRequest;
import com.louis.kitty.core.page.PageResult;

import com.louis.kitty.admin.model.HouseholdIncome;
import com.louis.kitty.admin.dao.HouseholdIncomeMapper;
import com.louis.kitty.admin.sevice.HouseholdIncomeService;

/**
 * ---------------------------
 * 家庭收入信息表 (HouseholdIncomeServiceImpl)         
 * ---------------------------
 * 作者： lz
 * 时间：  2019-08-08 11:53:18
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class HouseholdIncomeServiceImpl implements HouseholdIncomeService {

	@Autowired
	private HouseholdIncomeMapper householdIncomeMapper;

	@Override
	public int save(HouseholdIncome record) {
		if(record.getId() == null || record.getId() == 0) {
			return householdIncomeMapper.add(record);
		}
		return householdIncomeMapper.update(record);
	}

	@Override
	public int delete(HouseholdIncome record) {
		return householdIncomeMapper.delete(record.getId());
	}

	@Override
	public int delete(List<HouseholdIncome> records) {
		for(HouseholdIncome record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public HouseholdIncome findById(Long id) {
		return householdIncomeMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, householdIncomeMapper);
	}
	
}
