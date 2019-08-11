package com.louis.kitty.admin.sevice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.louis.kitty.core.page.MybatisPageHelper;
import com.louis.kitty.core.page.PageRequest;
import com.louis.kitty.core.page.PageResult;

import com.louis.kitty.admin.model.CounterpartyInformation;
import com.louis.kitty.admin.dao.CounterpartyInformationMapper;
import com.louis.kitty.admin.sevice.CounterpartyInformationService;

/**
 * ---------------------------
 * 交易对手信息表 (CounterpartyInformationServiceImpl)         
 * ---------------------------
 * 作者： lz
 * 时间：  2019-08-08 11:53:18
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class CounterpartyInformationServiceImpl implements CounterpartyInformationService {

	@Autowired
	private CounterpartyInformationMapper counterpartyInformationMapper;

	@Override
	public int save(CounterpartyInformation record) {
		if(record.getId() == null || record.getId() == 0) {
			return counterpartyInformationMapper.add(record);
		}
		return counterpartyInformationMapper.update(record);
	}

	@Override
	public int delete(CounterpartyInformation record) {
		return counterpartyInformationMapper.delete(record.getId());
	}

	@Override
	public int delete(List<CounterpartyInformation> records) {
		for(CounterpartyInformation record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public CounterpartyInformation findById(Long id) {
		return counterpartyInformationMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, counterpartyInformationMapper);
	}

	@Override
	public List<CounterpartyInformation> findByIoanBusinessInformationId(Long loanBusinessInformationId) {
		return counterpartyInformationMapper.findByIoanBusinessInformationId(loanBusinessInformationId);
	}
}
