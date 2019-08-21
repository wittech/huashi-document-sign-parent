package com.louis.kitty.admin.sevice.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.louis.kitty.core.page.MybatisPageHelper;
import com.louis.kitty.core.page.PageRequest;
import com.louis.kitty.core.page.PageResult;

import com.louis.kitty.admin.model.PersonalLoanSurveyReport;
import com.louis.kitty.admin.dao.PersonalLoanSurveyReportMapper;
import com.louis.kitty.admin.sevice.PersonalLoanSurveyReportService;

/**
 * ---------------------------
 * 个人贷款调查报告信息表 (PersonalLoanSurveyReportServiceImpl)         
 * ---------------------------
 * 作者： lz
 * 时间：  2019-08-08 11:53:18
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class PersonalLoanSurveyReportServiceImpl implements PersonalLoanSurveyReportService {

	@Autowired
	private PersonalLoanSurveyReportMapper personalLoanSurveyReportMapper;

	@Override
	public int save(PersonalLoanSurveyReport record) {
		if(record.getId() == null || record.getId() == 0) {
			record.setCreateTime(new Date());
			return personalLoanSurveyReportMapper.add(record);
		}
		record.setLastUpdateTime(new Date());
		return personalLoanSurveyReportMapper.update(record);
	}

	@Override
	public int delete(PersonalLoanSurveyReport record) {
		return personalLoanSurveyReportMapper.delete(record.getId());
	}

	@Override
	public int delete(List<PersonalLoanSurveyReport> records) {
		for(PersonalLoanSurveyReport record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public PersonalLoanSurveyReport findById(Long id) {
		return personalLoanSurveyReportMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, personalLoanSurveyReportMapper);
	}

	@Override
	public PersonalLoanSurveyReport findByBasisId(Long loanBasicId) {
		return personalLoanSurveyReportMapper.findByBasisId(loanBasicId);
	}
	
}
