package com.louis.kitty.admin.sevice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.louis.kitty.core.page.MybatisPageHelper;
import com.louis.kitty.core.page.PageRequest;
import com.louis.kitty.core.page.PageResult;

import com.louis.kitty.admin.model.LoanBusinessInformation;
import com.louis.kitty.admin.dao.LoanBusinessInformationMapper;
import com.louis.kitty.admin.sevice.LoanBusinessInformationService;

/**
 * ---------------------------
 * 贷款业务信息表 (LoanBusinessInformationServiceImpl)         
 * ---------------------------
 * 作者： lz
 * 时间：  2019-08-08 11:53:18
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class LoanBusinessInformationServiceImpl implements LoanBusinessInformationService {

	@Autowired
	private LoanBusinessInformationMapper loanBusinessInformationMapper;

	@Override
	public int save(LoanBusinessInformation record) {
		if(record.getId() == null || record.getId() == 0) {
			return loanBusinessInformationMapper.add(record);
		}
		return loanBusinessInformationMapper.update(record);
	}

	@Override
	public int delete(LoanBusinessInformation record) {
		return loanBusinessInformationMapper.delete(record.getId());
	}

	@Override
	public int delete(List<LoanBusinessInformation> records) {
		for(LoanBusinessInformation record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public LoanBusinessInformation findById(Long id) {
		return loanBusinessInformationMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, loanBusinessInformationMapper);
	}
	
}
