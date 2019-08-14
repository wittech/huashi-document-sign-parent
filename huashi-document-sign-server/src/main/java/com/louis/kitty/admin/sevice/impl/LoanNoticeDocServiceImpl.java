package com.louis.kitty.admin.sevice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.louis.kitty.core.page.MybatisPageHelper;
import com.louis.kitty.core.page.PageRequest;
import com.louis.kitty.core.page.PageResult;

import com.louis.kitty.admin.model.LoanNoticeDoc;
import com.louis.kitty.admin.dao.LoanNoticeDocMapper;
import com.louis.kitty.admin.sevice.LoanNoticeDocService;

/**
 * ---------------------------
 *  (LoanNoticeDocServiceImpl)         
 * ---------------------------
 * 作者： lz
 * 时间：  2019-08-14 10:54:33
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class LoanNoticeDocServiceImpl implements LoanNoticeDocService {

	@Autowired
	private LoanNoticeDocMapper loanNoticeDocMapper;

	@Override
	public int save(LoanNoticeDoc record) {
		if(record.getId() == null || record.getId() == 0) {
			return loanNoticeDocMapper.add(record);
		}
		return loanNoticeDocMapper.update(record);
	}

	@Override
	public int delete(LoanNoticeDoc record) {
		return loanNoticeDocMapper.delete(record.getId());
	}

	@Override
	public int delete(List<LoanNoticeDoc> records) {
		for(LoanNoticeDoc record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public LoanNoticeDoc findById(Long id) {
		return loanNoticeDocMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, loanNoticeDocMapper);
	}
	
}
