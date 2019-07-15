/**
 * 
 */
package com.louis.kitty.admin.dao;

import java.util.List;

import com.louis.kitty.admin.model.SysConfigurationModel;

/**
 * 系统配置Mapper
 * @author lz
 *
 */
public interface SysConfigurationMapper {
	int deleteByPrimaryKey(Long id);

	int insert(SysConfigurationModel record);

	int insertSelective(SysConfigurationModel record);

	SysConfigurationModel selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(SysConfigurationModel record);

	int updateByPrimaryKey(SysConfigurationModel record);

	List<SysConfigurationModel> findPage();
}
