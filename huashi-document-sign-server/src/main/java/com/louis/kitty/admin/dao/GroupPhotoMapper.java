package com.louis.kitty.admin.dao;

import java.util.List;

import com.louis.kitty.admin.model.GroupPhoto;

/**
 * ---------------------------
 * 合影信息表 (GroupPhotoMapper)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-08 11:53:18
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface GroupPhotoMapper {

	/**
	 * 添加合影信息表
	 * @param record
	 * @return
	 */
    int add(GroupPhoto record);

    /**
     * 删除合影信息表
     * @param id
     * @return
     */
    int delete(Long id);
    
    /**
     * 修改合影信息表
     * @param record
     * @return
     */
    int update(GroupPhoto record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    GroupPhoto findById(Long id);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<GroupPhoto> findPage();
    
}