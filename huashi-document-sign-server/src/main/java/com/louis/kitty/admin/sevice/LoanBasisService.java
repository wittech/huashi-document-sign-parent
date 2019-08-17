package com.louis.kitty.admin.sevice;

import java.util.List;

import com.louis.kitty.admin.dto.HousingLandDto;
import com.louis.kitty.admin.model.LoanBasis;
import com.louis.kitty.core.service.CurdService;

/**
 * ---------------------------
 * 借口人基础信息表 (LoanBasisService)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-08 11:53:18
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface LoanBasisService extends CurdService<LoanBasis> {
	
	/**
	 * 根据基础id获取 引用房产 和土地信息
	 * 
	 * @param loanBasisId
	 * @return
	 */
	List<HousingLandDto> findByLoanBasisIdList(Long loanBasisId);
}
