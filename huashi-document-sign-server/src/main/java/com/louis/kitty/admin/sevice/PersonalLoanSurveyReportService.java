package com.louis.kitty.admin.sevice;

import com.louis.kitty.admin.model.PersonalLoanSurveyReport;
import com.louis.kitty.core.service.CurdService;

/**
 * ---------------------------
 * 个人贷款调查报告信息表 (PersonalLoanSurveyReportService)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-08 11:53:18
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface PersonalLoanSurveyReportService extends CurdService<PersonalLoanSurveyReport> {
	/**
	 * 根据baseid获取对象信息
	 * @param loanBasicId
	 * @return
	 */
	PersonalLoanSurveyReport findByBasisId(Long loanBasicId);
}
