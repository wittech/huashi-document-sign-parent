package com.louis.kitty.admin.sevice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.louis.kitty.core.page.MybatisPageHelper;
import com.louis.kitty.core.page.PageRequest;
import com.louis.kitty.core.page.PageResult;

import com.louis.kitty.admin.model.ContractInformation;
import com.louis.kitty.admin.dao.ContractInformationMapper;
import com.louis.kitty.admin.sevice.ContractInformationService;

/**
 * ---------------------------
 * 合同信息表 (ContractInformationServiceImpl)         
 * ---------------------------
 * 作者： lz
 * 时间：  2019-08-08 11:53:18
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class ContractInformationServiceImpl implements ContractInformationService {

	@Autowired
	private ContractInformationMapper contractInformationMapper;

	@Override
	public int save(ContractInformation record) {
		if(record.getId() == null || record.getId() == 0) {
			return contractInformationMapper.add(record);
		}
		return contractInformationMapper.update(record);
	}

	@Override
	public int delete(ContractInformation record) {
		return contractInformationMapper.delete(record.getId());
	}

	@Override
	public int delete(List<ContractInformation> records) {
		for(ContractInformation record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public ContractInformation findById(Long id) {
		return contractInformationMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, contractInformationMapper);
	}

	@Override
	public ContractInformation findByLoanBasisId(Long loanBasisId) {
		return contractInformationMapper.findByLoanBasisId(loanBasisId);
	}
}
