package com.louis.kitty.admin.dao;

import java.util.List;

import com.louis.kitty.admin.model.SysConfiguration;

/**
 * ---------------------------
 * 系统配置信息表 (SysConfigurationMapper)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-07-17 21:19:18
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface SysConfigurationMapper {

	/**
	 * 添加系统配置信息表
	 * @param record
	 * @return
	 */
    int add(SysConfiguration record);

    /**
     * 删除系统配置信息表
     * @param id
     * @return
     */
    int delete(Integer id);
    
    /**
     * 修改系统配置信息表
     * @param record
     * @return
     */
    int update(SysConfiguration record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    SysConfiguration findById(Long id);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<SysConfiguration> findPage();
    
}