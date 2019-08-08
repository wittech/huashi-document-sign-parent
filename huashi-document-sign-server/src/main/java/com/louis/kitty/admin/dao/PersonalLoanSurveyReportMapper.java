package com.louis.kitty.admin.dao;

import java.util.List;

import com.louis.kitty.admin.model.PersonalLoanSurveyReport;

/**
 * ---------------------------
 * 个人贷款调查报告信息表 (PersonalLoanSurveyReportMapper)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-08 11:53:18
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface PersonalLoanSurveyReportMapper {

	/**
	 * 添加个人贷款调查报告信息表
	 * @param record
	 * @return
	 */
    int add(PersonalLoanSurveyReport record);

    /**
     * 删除个人贷款调查报告信息表
     * @param id
     * @return
     */
    int delete(Long id);
    
    /**
     * 修改个人贷款调查报告信息表
     * @param record
     * @return
     */
    int update(PersonalLoanSurveyReport record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    PersonalLoanSurveyReport findById(Long id);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<PersonalLoanSurveyReport> findPage();
    
}