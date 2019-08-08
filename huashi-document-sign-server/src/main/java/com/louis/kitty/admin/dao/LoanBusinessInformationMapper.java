package com.louis.kitty.admin.dao;

import java.util.List;

import com.louis.kitty.admin.model.LoanBusinessInformation;

/**
 * ---------------------------
 * 贷款业务信息表 (LoanBusinessInformationMapper)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-08 11:53:18
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface LoanBusinessInformationMapper {

	/**
	 * 添加贷款业务信息表
	 * @param record
	 * @return
	 */
    int add(LoanBusinessInformation record);

    /**
     * 删除贷款业务信息表
     * @param id
     * @return
     */
    int delete(Long id);
    
    /**
     * 修改贷款业务信息表
     * @param record
     * @return
     */
    int update(LoanBusinessInformation record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    LoanBusinessInformation findById(Long id);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<LoanBusinessInformation> findPage();
    
}