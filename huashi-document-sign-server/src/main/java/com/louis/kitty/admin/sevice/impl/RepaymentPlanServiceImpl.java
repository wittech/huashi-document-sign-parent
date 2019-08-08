package com.louis.kitty.admin.sevice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.louis.kitty.core.page.MybatisPageHelper;
import com.louis.kitty.core.page.PageRequest;
import com.louis.kitty.core.page.PageResult;

import com.louis.kitty.admin.model.RepaymentPlan;
import com.louis.kitty.admin.dao.RepaymentPlanMapper;
import com.louis.kitty.admin.sevice.RepaymentPlanService;

/**
 * ---------------------------
 * 还款计划信息表 (RepaymentPlanServiceImpl)         
 * ---------------------------
 * 作者： lz
 * 时间：  2019-08-08 11:53:18
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class RepaymentPlanServiceImpl implements RepaymentPlanService {

	@Autowired
	private RepaymentPlanMapper repaymentPlanMapper;

	@Override
	public int save(RepaymentPlan record) {
		if(record.getId() == null || record.getId() == 0) {
			return repaymentPlanMapper.add(record);
		}
		return repaymentPlanMapper.update(record);
	}

	@Override
	public int delete(RepaymentPlan record) {
		return repaymentPlanMapper.delete(record.getId());
	}

	@Override
	public int delete(List<RepaymentPlan> records) {
		for(RepaymentPlan record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public RepaymentPlan findById(Long id) {
		return repaymentPlanMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, repaymentPlanMapper);
	}
	
}
