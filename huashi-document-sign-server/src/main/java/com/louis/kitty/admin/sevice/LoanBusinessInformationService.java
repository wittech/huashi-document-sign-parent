package com.louis.kitty.admin.sevice;

import com.louis.kitty.admin.model.LoanBusinessInformation;
import com.louis.kitty.core.service.CurdService;

/**
 * ---------------------------
 * 贷款业务信息表 (LoanBusinessInformationService)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-08 11:53:18
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface LoanBusinessInformationService extends CurdService<LoanBusinessInformation> {

    LoanBusinessInformation findByBasisId(Long loanBasicId);
}
