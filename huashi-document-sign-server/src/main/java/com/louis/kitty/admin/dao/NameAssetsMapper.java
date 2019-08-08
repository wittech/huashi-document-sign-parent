package com.louis.kitty.admin.dao;

import java.util.List;

import com.louis.kitty.admin.model.NameAssets;

/**
 * ---------------------------
 * 所属名下资产信息表 (NameAssetsMapper)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-08 11:53:18
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface NameAssetsMapper {

	/**
	 * 添加所属名下资产信息表
	 * @param record
	 * @return
	 */
    int add(NameAssets record);

    /**
     * 删除所属名下资产信息表
     * @param id
     * @return
     */
    int delete(Long id);
    
    /**
     * 修改所属名下资产信息表
     * @param record
     * @return
     */
    int update(NameAssets record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    NameAssets findById(Long id);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<NameAssets> findPage();
    
}