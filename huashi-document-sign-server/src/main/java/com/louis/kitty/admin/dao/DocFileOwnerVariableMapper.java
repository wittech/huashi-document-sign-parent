/**
 * 
 */
package com.louis.kitty.admin.dao;

import java.util.List;

import com.louis.kitty.admin.model.DocFileOwnerVariableModel;

/**
 * 文档文件答案变量Mapper
 * 
 * @author lz
 *
 */
public interface DocFileOwnerVariableMapper {
	int deleteByPrimaryKey(Long id);

	int insert(DocFileOwnerVariableModel record);

	int insertSelective(DocFileOwnerVariableModel record);

	DocFileOwnerVariableModel selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(DocFileOwnerVariableModel record);

	int updateByPrimaryKey(DocFileOwnerVariableModel record);

	List<DocFileOwnerVariableModel> findPage();
}
