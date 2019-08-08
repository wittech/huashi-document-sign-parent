package com.louis.kitty.admin.dao;

import java.util.List;

import com.louis.kitty.admin.model.AssetTypeSecurities;

/**
 * ---------------------------
 * 资产类型证券信息表 (AssetTypeSecuritiesMapper)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-08 11:53:18
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface AssetTypeSecuritiesMapper {

	/**
	 * 添加资产类型证券信息表
	 * @param record
	 * @return
	 */
    int add(AssetTypeSecurities record);

    /**
     * 删除资产类型证券信息表
     * @param id
     * @return
     */
    int delete(Long id);
    
    /**
     * 修改资产类型证券信息表
     * @param record
     * @return
     */
    int update(AssetTypeSecurities record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    AssetTypeSecurities findById(Long id);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<AssetTypeSecurities> findPage();
    
}