package com.louis.kitty.admin.dao;

import java.util.List;

import com.louis.kitty.admin.model.ContractInformation;

/**
 * ---------------------------
 * 合同信息表 (ContractInformationMapper)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-08 11:53:18
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface ContractInformationMapper {

	/**
	 * 添加合同信息表
	 * @param record
	 * @return
	 */
    int add(ContractInformation record);

    /**
     * 删除合同信息表
     * @param id
     * @return
     */
    int delete(Long id);
    
    /**
     * 修改合同信息表
     * @param record
     * @return
     */
    int update(ContractInformation record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    ContractInformation findById(Long id);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<ContractInformation> findPage();

    ContractInformation findByLoanBasisId(Long loanBasisId);
    
}