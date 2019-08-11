package com.louis.kitty.admin.dao;

import java.util.List;

import com.louis.kitty.admin.model.Pawn;

/**
 * ---------------------------
 * 抵押物信息表 (PawnMapper)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-10 22:28:24
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface PawnMapper {

	/**
	 * 添加抵押物信息表
	 * @param record
	 * @return
	 */
    int add(Pawn record);

    /**
     * 删除抵押物信息表
     * @param id
     * @return
     */
    int delete(Long id);
    
    /**
     * 修改抵押物信息表
     * @param record
     * @return
     */
    int update(Pawn record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    Pawn findById(Long id);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<Pawn> findPage();

    List<Pawn> findByLoanBasisId(Long loanBasisId);
    
}