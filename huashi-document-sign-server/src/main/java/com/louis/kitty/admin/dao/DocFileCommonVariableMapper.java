/**
 * 
 */
package com.louis.kitty.admin.dao;

import java.util.List;

import com.louis.kitty.admin.model.DocFileCommonVariableModel;

/**
 * 文档文件变量mapper
 * @author lz
 *
 */
public interface DocFileCommonVariableMapper {
	int deleteByPrimaryKey(Long id);

	int insert(DocFileCommonVariableModel record);

	int insertSelective(DocFileCommonVariableModel record);

	DocFileCommonVariableModel selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(DocFileCommonVariableModel record);

	int updateByPrimaryKey(DocFileCommonVariableModel record);

	List<DocFileCommonVariableModel> findPage();
}
