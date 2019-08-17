package com.louis.kitty.admin.dao;

import com.louis.kitty.admin.model.AssetTypeLand;

import java.util.List;

/**
 * ---------------------------
 * 资产类型土地信息表 (AssetTypeLandMapper)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-08 11:53:17
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface AssetTypeLandMapper {

	/**
	 * 添加资产类型土地信息表
	 * @param record
	 * @return
	 */
    int add(AssetTypeLand record);

    /**
     * 删除资产类型土地信息表
     * @param id
     * @return
     */
    int delete(Long id);
    
    /**
     * 修改资产类型土地信息表
     * @param record
     * @return
     */
    int update(AssetTypeLand record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    AssetTypeLand findById(Long id);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<AssetTypeLand> findPage();

    List<AssetTypeLand> findByRpiId(Long rpiId);
}