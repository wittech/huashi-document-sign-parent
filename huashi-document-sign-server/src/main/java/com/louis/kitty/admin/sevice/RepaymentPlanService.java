package com.louis.kitty.admin.sevice;

import com.louis.kitty.admin.model.RepaymentPlan;
import com.louis.kitty.core.service.CurdService;

import java.util.List;

/**
 * ---------------------------
 * 还款计划信息表 (RepaymentPlanService)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-08 11:53:18
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface RepaymentPlanService extends CurdService<RepaymentPlan> {

    List<RepaymentPlan> findByIoanBusinessInformationId(Long loanBusinessInformationId);
}
