package com.louis.kitty.admin.sevice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.louis.kitty.core.page.MybatisPageHelper;
import com.louis.kitty.core.page.PageRequest;
import com.louis.kitty.core.page.PageResult;

import com.louis.kitty.admin.model.LoanBasis;
import com.louis.kitty.admin.dao.LoanBasisMapper;
import com.louis.kitty.admin.sevice.LoanBasisService;

/**
 * ---------------------------
 * 借口人基础信息表 (LoanBasisServiceImpl)         
 * ---------------------------
 * 作者： lz
 * 时间：  2019-08-08 11:53:18
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class LoanBasisServiceImpl implements LoanBasisService {

	@Autowired
	private LoanBasisMapper loanBasisMapper;

	@Override
	public int save(LoanBasis record) {
		if(record.getId() == null || record.getId() == 0) {
			return loanBasisMapper.add(record);
		}
		return loanBasisMapper.update(record);
	}

	@Override
	public int delete(LoanBasis record) {
		return loanBasisMapper.delete(record.getId());
	}

	@Override
	public int delete(List<LoanBasis> records) {
		for(LoanBasis record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public LoanBasis findById(Long id) {
		return loanBasisMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, loanBasisMapper);
	}
	
}
