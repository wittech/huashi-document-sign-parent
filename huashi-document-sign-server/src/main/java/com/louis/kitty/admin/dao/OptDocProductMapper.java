package com.louis.kitty.admin.dao;

import java.util.List;

import com.louis.kitty.admin.model.OptDocProduct;

/**
 * ---------------------------
 *  (OptDocProductMapper)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-07-17 21:19:18
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface OptDocProductMapper {

	/**
	 * 添加
	 * @param record
	 * @return
	 */
    int add(OptDocProduct record);

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
    int update(OptDocProduct record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    OptDocProduct findById(Long id);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<OptDocProduct> findPage();
    
}