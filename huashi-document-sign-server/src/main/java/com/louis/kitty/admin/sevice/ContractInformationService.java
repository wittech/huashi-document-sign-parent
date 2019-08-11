package com.louis.kitty.admin.sevice;

import com.louis.kitty.admin.model.ContractInformation;
import com.louis.kitty.core.service.CurdService;

/**
 * ---------------------------
 * 合同信息表 (ContractInformationService)
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-08 11:53:18
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface ContractInformationService extends CurdService<ContractInformation> {

    ContractInformation findByLoanBasisId(Long loanBasisId);
}
