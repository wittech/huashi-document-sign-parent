package com.louis.kitty.admin.dao;

import java.util.List;

import com.louis.kitty.admin.model.AssetTypeHouses;

/**
 * ---------------------------
 * 资产类型房屋信息表 (AssetTypeHousesMapper)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-08 11:53:17
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface AssetTypeHousesMapper {

	/**
	 * 添加资产类型房屋信息表
	 * @param record
	 * @return
	 */
    int add(AssetTypeHouses record);

    /**
     * 删除资产类型房屋信息表
     * @param id
     * @return
     */
    int delete(Long id);
    
    /**
     * 修改资产类型房屋信息表
     * @param record
     * @return
     */
    int update(AssetTypeHouses record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    AssetTypeHouses findById(Long id);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<AssetTypeHouses> findPage();

    List<AssetTypeHouses> findByRpiId(Long rpiId);
    
}