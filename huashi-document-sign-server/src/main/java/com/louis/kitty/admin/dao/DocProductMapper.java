package com.louis.kitty.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.louis.kitty.admin.model.DocProduct;

/**
 * ---------------------------
 *  (DocProductMapper)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-07-17 21:29:30
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface DocProductMapper {

	/**
	 * 添加
	 * @param record
	 * @return
	 */
    int add(DocProduct record);

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
    int update(DocProduct record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    DocProduct findById(Long id);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<DocProduct> findPage();
    
    List<DocProduct> findPageByName(@Param(value = "name") String name);
    
}