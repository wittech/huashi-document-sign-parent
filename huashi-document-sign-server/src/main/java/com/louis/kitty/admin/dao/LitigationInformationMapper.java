package com.louis.kitty.admin.dao;

import java.util.List;

import com.louis.kitty.admin.model.LitigationInformation;

/**
 * ---------------------------
 * 诉讼信息表 (LitigationInformationMapper)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-10 10:03:25
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface LitigationInformationMapper {

	/**
	 * 添加诉讼信息表
	 * @param record
	 * @return
	 */
    int add(LitigationInformation record);

    /**
     * 删除诉讼信息表
     * @param id
     * @return
     */
    int delete(Long id);
    
    /**
     * 修改诉讼信息表
     * @param record
     * @return
     */
    int update(LitigationInformation record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    LitigationInformation findById(Long id);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<LitigationInformation> findPage();
    
}