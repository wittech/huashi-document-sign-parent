package com.louis.kitty.admin.dao;

import java.util.List;

import com.louis.kitty.admin.model.DocFile;

/**
 * ---------------------------
 *  (DocFileMapper)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-07-17 21:38:51
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface DocFileMapper {

	/**
	 * 添加
	 * @param record
	 * @return
	 */
    int add(DocFile record);

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
    int update(DocFile record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    DocFile findById(Long id);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<DocFile> findPage();
    
}