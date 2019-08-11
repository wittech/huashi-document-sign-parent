package com.louis.kitty.admin.sevice;

import com.louis.kitty.admin.model.HouseholdIncome;
import com.louis.kitty.core.service.CurdService;

/**
 * ---------------------------
 * 家庭收入信息表 (HouseholdIncomeService)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-08 11:53:18
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface HouseholdIncomeService extends CurdService<HouseholdIncome> {

    HouseholdIncome findByRpiId(Long rpiId);
}
