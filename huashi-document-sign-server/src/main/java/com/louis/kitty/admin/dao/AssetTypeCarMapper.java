package com.louis.kitty.admin.dao;

import com.louis.kitty.admin.model.AssetTypeCar;

import java.util.List;

/**
 * ---------------------------
 * 资产类型汽车信息表 (AssetTypeCarMapper)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-08 11:53:17
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface AssetTypeCarMapper {

	/**
	 * 添加资产类型汽车信息表
	 * @param record
	 * @return
	 */
    int add(AssetTypeCar record);

    /**
     * 删除资产类型汽车信息表
     * @param id
     * @return
     */
    int delete(Long id);
    
    /**
     * 修改资产类型汽车信息表
     * @param record
     * @return
     */
    int update(AssetTypeCar record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    AssetTypeCar findById(Long id);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<AssetTypeCar> findPage();

    List<AssetTypeCar> findByRpiId(Long rpiId);
    
}