package com.louis.kitty.admin.dao;

import java.util.List;

import com.louis.kitty.admin.model.DocMeta;

/**
 * ---------------------------
 *  (DocMetaMapper)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-06 09:28:57
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface DocMetaMapper {

	/**
	 * 添加
	 * @param record
	 * @return
	 */
    int add(DocMeta record);

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
    int update(DocMeta record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    DocMeta findById(Long id);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<DocMeta> findPage();
    
}