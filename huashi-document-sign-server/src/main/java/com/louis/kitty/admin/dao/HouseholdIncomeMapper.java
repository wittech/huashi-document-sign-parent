package com.louis.kitty.admin.dao;

import java.util.List;

import com.louis.kitty.admin.model.HouseholdIncome;

/**
 * ---------------------------
 * 家庭收入信息表 (HouseholdIncomeMapper)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-08 11:53:18
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface HouseholdIncomeMapper {

	/**
	 * 添加家庭收入信息表
	 * @param record
	 * @return
	 */
    int add(HouseholdIncome record);

    /**
     * 删除家庭收入信息表
     * @param id
     * @return
     */
    int delete(Long id);
    
    /**
     * 修改家庭收入信息表
     * @param record
     * @return
     */
    int update(HouseholdIncome record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    HouseholdIncome findById(Long id);

    /**
     * 基础分页查询
     * @return
     */    
    List<HouseholdIncome> findPage();

    HouseholdIncome findByRpiId(Long rpiId);

    List<HouseholdIncome> findByRpiIds(List<Long> ids);
    

    HouseholdIncome findByLoanBasisId(Long loanBasisId);
    
}