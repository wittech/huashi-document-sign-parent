/**
 * 
 */
package com.louis.kitty.admin.dao;

import java.util.List;

import com.louis.kitty.admin.model.DocFileModel;

/**
 * 文档文件Mapper
 * @author lz
 *
 */
public interface DocFileMapper {
	int deleteByPrimaryKey(Long id);

	int insert(DocFileModel record);

	int insertSelective(DocFileModel record);

	DocFileModel selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(DocFileModel record);

	int updateByPrimaryKey(DocFileModel record);

	List<DocFileModel> findPage();
}
