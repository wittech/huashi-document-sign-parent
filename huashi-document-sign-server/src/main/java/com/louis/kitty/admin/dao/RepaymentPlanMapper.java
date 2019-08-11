package com.louis.kitty.admin.dao;

import java.util.List;

import com.louis.kitty.admin.model.RepaymentPlan;

/**
 * ---------------------------
 * 还款计划信息表 (RepaymentPlanMapper)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-08 11:53:18
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface RepaymentPlanMapper {

	/**
	 * 添加还款计划信息表
	 * @param record
	 * @return
	 */
    int add(RepaymentPlan record);

    /**
     * 删除还款计划信息表
     * @param id
     * @return
     */
    int delete(Long id);
    
    /**
     * 修改还款计划信息表
     * @param record
     * @return
     */
    int update(RepaymentPlan record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    RepaymentPlan findById(Long id);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<RepaymentPlan> findPage();

    List<RepaymentPlan> findByloanBusinessInformationId(Long loanBusinessInformationId);
}