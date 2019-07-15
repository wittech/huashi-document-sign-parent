/**
 * 
 */
package com.louis.kitty.admin.dao;

import java.util.List;

import com.louis.kitty.admin.model.OptDocProductModel;

/**
 * 操作文档产品
 * @author lz
 *
 */
public interface OptDocProductMapper {
	int deleteByPrimaryKey(Long id);

	int insert(OptDocProductModel record);

	int insertSelective(OptDocProductModel record);

	OptDocProductModel selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(OptDocProductModel record);

	int updateByPrimaryKey(OptDocProductModel record);

	List<OptDocProductModel> findPage();
}
