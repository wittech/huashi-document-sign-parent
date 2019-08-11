package com.louis.kitty.admin.dao;

import java.util.List;

import com.louis.kitty.admin.model.Pawn;
import com.louis.kitty.admin.model.PawnPersonnelMapping;

/**
 * ---------------------------
 * 所属名下资产信息表 (PawnPersonnelMappingMapper)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-10 22:28:24
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface PawnPersonnelMappingMapper {

	/**
	 * 添加所属名下资产信息表
	 * @param record
	 * @return
	 */
    int add(PawnPersonnelMapping record);

    /**
     * 删除所属名下资产信息表
     * @param id
     * @return
     */
    int delete(Long id);
    
    /**
     * 修改所属名下资产信息表
     * @param record
     * @return
     */
    int update(PawnPersonnelMapping record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    PawnPersonnelMapping findById(Long id);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<PawnPersonnelMapping> findPage();

    List<PawnPersonnelMapping> findByPawnList(Long pawnId);

    List<PawnPersonnelMapping> findByRpiId(Long rpiId);
    
}