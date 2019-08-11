package com.louis.kitty.admin.dao;

import java.util.List;

import com.louis.kitty.admin.model.CounterpartyInformation;

/**
 * ---------------------------
 * 交易对手信息表 (CounterpartyInformationMapper)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-08 11:53:18
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface CounterpartyInformationMapper {

	/**
	 * 添加交易对手信息表
	 * @param record
	 * @return
	 */
    int add(CounterpartyInformation record);

    /**
     * 删除交易对手信息表
     * @param id
     * @return
     */
    int delete(Long id);
    
    /**
     * 修改交易对手信息表
     * @param record
     * @return
     */
    int update(CounterpartyInformation record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    CounterpartyInformation findById(Long id);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<CounterpartyInformation> findPage();

    List<CounterpartyInformation> findByIoanBusinessInformationId(Long loanBusinessInformationId);
}