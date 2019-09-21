package com.louis.kitty.admin.dao;

import java.util.List;

import com.louis.kitty.admin.dto.HousingLandDto;
import com.louis.kitty.admin.dto.LoanPageDto;
import com.louis.kitty.admin.model.LoanBasis;

/**
 * --------------------------- 借口人基础信息表 (LoanBasisMapper)
 * --------------------------- 作者： lz 时间： 2019-08-08 11:53:18 说明： 我是由代码生成器生生成的
 * ---------------------------
 */
public interface LoanBasisMapper {

	/**
	 * 添加借口人基础信息表
	 * 
	 * @param record
	 * @return
	 */
	int insert(LoanBasis record);

	/**
	 * 删除借口人基础信息表
	 * 
	 * @param id
	 * @return
	 */
	int delete(Long id);

	/**
	 * 修改借口人基础信息表
	 * 
	 * @param record
	 * @return
	 */
	int update(LoanBasis record);

	/**
	 * 根据主键查询
	 * 
	 * @param id
	 * @return
	 */
	LoanBasis findById(Long id);

	/**
	 * 基础分页查询
	 * 
	 * @param record
	 * @return
	 */
	List<LoanBasis> findPage();

	/**
	 * 根据借款人 状态查询 分页
	 * 
	 * @param record
	 * @return
	 */
	List<LoanPageDto> findPageByBorrowerAndStatus(LoanBasis record);

	/**
	 * 根据基础id获取 引用房产 和土地信息
	 * 
	 * @param loanBasisId
	 * @return
	 */
	List<HousingLandDto> findByLoanBasisIdList(Long loanBasisId);

}