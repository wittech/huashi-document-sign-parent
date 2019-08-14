package com.louis.kitty.admin.sevice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.louis.kitty.core.page.MybatisPageHelper;
import com.louis.kitty.core.page.PageRequest;
import com.louis.kitty.core.page.PageResult;

import com.louis.kitty.admin.model.LoanCheckDoc;
import com.louis.kitty.admin.dao.LoanCheckDocMapper;
import com.louis.kitty.admin.sevice.LoanCheckDocService;

/**
 * ---------------------------
 *  (LoanCheckDocServiceImpl)         
 * ---------------------------
 * 作者： lz
 * 时间：  2019-08-14 10:54:33
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class LoanCheckDocServiceImpl implements LoanCheckDocService {

	@Autowired
	private LoanCheckDocMapper loanCheckDocMapper;

	@Override
	public int save(LoanCheckDoc record) {
		if(record.getId() == null || record.getId() == 0) {
			return loanCheckDocMapper.add(record);
		}
		return loanCheckDocMapper.update(record);
	}

	@Override
	public int delete(LoanCheckDoc record) {
		return loanCheckDocMapper.delete(record.getId());
	}

	@Override
	public int delete(List<LoanCheckDoc> records) {
		for(LoanCheckDoc record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public LoanCheckDoc findById(Long id) {
		return loanCheckDocMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, loanCheckDocMapper);
	}
	
}
