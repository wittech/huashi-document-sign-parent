package com.louis.kitty.admin.dao;

import java.util.List;

import com.louis.kitty.admin.model.LoanCheckDoc;

/**
 * ---------------------------
 *  (LoanCheckDocMapper)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-14 10:54:33
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface LoanCheckDocMapper {

	/**
	 * 添加
	 * @param record
	 * @return
	 */
    int add(LoanCheckDoc record);

    /**
     * 删除
     * @param id
     * @return
     */
    int delete(Long id);
    
    /**
     * 修改
     * @param record
     * @return
     */
    int update(LoanCheckDoc record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    LoanCheckDoc findById(Long id);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<LoanCheckDoc> findPage();
    
}