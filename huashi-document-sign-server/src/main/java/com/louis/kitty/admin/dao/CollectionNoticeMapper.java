package com.louis.kitty.admin.dao;

import java.util.List;

import com.louis.kitty.admin.model.CollectionNotice;

/**
 * ---------------------------
 * 贷款到期（逾期）催收通知书信息表 (CollectionNoticeMapper)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-10 10:03:25
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface CollectionNoticeMapper {

	/**
	 * 添加贷款到期（逾期）催收通知书信息表
	 * @param record
	 * @return
	 */
    int add(CollectionNotice record);

    /**
     * 删除贷款到期（逾期）催收通知书信息表
     * @param id
     * @return
     */
    int delete(Long id);
    
    /**
     * 修改贷款到期（逾期）催收通知书信息表
     * @param record
     * @return
     */
    int update(CollectionNotice record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    CollectionNotice findById(Long id);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<CollectionNotice> findPage();
    
}