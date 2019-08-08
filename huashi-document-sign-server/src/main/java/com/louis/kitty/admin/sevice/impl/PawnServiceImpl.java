package com.louis.kitty.admin.sevice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.louis.kitty.core.page.MybatisPageHelper;
import com.louis.kitty.core.page.PageRequest;
import com.louis.kitty.core.page.PageResult;

import com.louis.kitty.admin.model.Pawn;
import com.louis.kitty.admin.dao.PawnMapper;
import com.louis.kitty.admin.sevice.PawnService;

/**
 * ---------------------------
 * 抵押物信息表 (PawnServiceImpl)         
 * ---------------------------
 * 作者： lz
 * 时间：  2019-08-08 11:53:18
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class PawnServiceImpl implements PawnService {

	@Autowired
	private PawnMapper pawnMapper;

	@Override
	public int save(Pawn record) {
		if(record.getId() == null || record.getId() == 0) {
			return pawnMapper.add(record);
		}
		return pawnMapper.update(record);
	}

	@Override
	public int delete(Pawn record) {
		return pawnMapper.delete(record.getId());
	}

	@Override
	public int delete(List<Pawn> records) {
		for(Pawn record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public Pawn findById(Long id) {
		return pawnMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, pawnMapper);
	}
	
}
