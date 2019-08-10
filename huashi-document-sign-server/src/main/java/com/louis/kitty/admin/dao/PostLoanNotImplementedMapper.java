package com.louis.kitty.admin.dao;

import java.util.List;

import com.louis.kitty.admin.model.PostLoanNotImplemented;

/**
 * ---------------------------
 *  (PostLoanNotImplementedMapper)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-10 22:28:24
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface PostLoanNotImplementedMapper {

	/**
	 * 添加
	 * @param record
	 * @return
	 */
    int add(PostLoanNotImplemented record);

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
    int update(PostLoanNotImplemented record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    PostLoanNotImplemented findById(Long id);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<PostLoanNotImplemented> findPage();
    
}