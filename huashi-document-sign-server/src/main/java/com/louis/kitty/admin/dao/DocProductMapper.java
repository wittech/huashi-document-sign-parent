/**
 * 
 */
package com.louis.kitty.admin.dao;

import java.util.List;

import com.louis.kitty.admin.model.DocProductModel;

/**
 * 文档产品Mapper
 * 
 * @author lz
 *
 */
public interface DocProductMapper {
	int deleteByPrimaryKey(Long id);

	int insert(DocProductModel record);

	int insertSelective(DocProductModel record);

	DocProductModel selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(DocProductModel record);

	int updateByPrimaryKey(DocProductModel record);

	List<DocProductModel> findPage();
}
