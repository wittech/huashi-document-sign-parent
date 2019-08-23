package com.louis.kitty.admin.sevice.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.louis.kitty.core.page.MybatisPageHelper;
import com.louis.kitty.core.page.PageRequest;
import com.louis.kitty.core.page.PageResult;
import com.louis.kitty.admin.model.CounterpartyInformation;
import com.louis.kitty.admin.model.LoanBusinessInformation;
import com.louis.kitty.admin.model.RepaymentPlan;
import com.louis.kitty.admin.dao.CounterpartyInformationMapper;
import com.louis.kitty.admin.dao.LoanBusinessInformationMapper;
import com.louis.kitty.admin.dao.RepaymentPlanMapper;
import com.louis.kitty.admin.sevice.LoanBusinessInformationService;

/**
 * ---------------------------
 * 贷款业务信息表 (LoanBusinessInformationServiceImpl)         
 * ---------------------------
 * 作者： lz
 * 时间：  2019-08-08 11:53:18
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class LoanBusinessInformationServiceImpl implements LoanBusinessInformationService {

	@Autowired
	private LoanBusinessInformationMapper loanBusinessInformationMapper;
	@Autowired
	private CounterpartyInformationMapper counterpartyInformationMapper;
	@Autowired
	private RepaymentPlanMapper repaymentPlanMapper;

	@Override
	public int save(LoanBusinessInformation record) {
		if(record.getId() == null || record.getId() == 0) {
			record.setCreateTime(new Date());
			int i = loanBusinessInformationMapper.add(record);
			Long id = record.getId();
			if(id >0){
				if(record.getCounterpartyInformation() !=null){
					for(CounterpartyInformation c : record.getCounterpartyInformation()){
						c.setCreateTime(new Date());
						c.setCreateBy(record.getCreateBy());
						c.setLoanBusinessInformationId(id);
						counterpartyInformationMapper.add(c);
					}
				}
				if(record.getRepaymentPlan() !=null){
					for(RepaymentPlan r : record.getRepaymentPlan()){
						r.setLoanBusinessInformationId(id);
						repaymentPlanMapper.add(r);
					}
				}
			}
			return i;
		}
		record.setLastUpdateTime(new Date());
		Long id = record.getId();
		if(id>0){
			//根据id删除交易对手表信息 在保存
			List<CounterpartyInformation> list = counterpartyInformationMapper.findByIoanBusinessInformationId(record.getId());
			if(list !=null){
				for(CounterpartyInformation c :list){
					c.setDelFlag(-1);
					counterpartyInformationMapper.update(c);
				}
			}
			//保存
			if(record.getCounterpartyInformation() !=null){
				for(CounterpartyInformation c : record.getCounterpartyInformation()){
					c.setId(null);
					c.setCreateBy(record.getLastUpdateBy());
					c.setLastUpdateBy(record.getLastUpdateBy());
					c.setCreateTime(new Date());
					c.setLastUpdateTime(new Date());
					c.setLoanBusinessInformationId(id);
					counterpartyInformationMapper.add(c);
				}
			}
		}
		return loanBusinessInformationMapper.update(record);
	}

	@Override
	public int delete(LoanBusinessInformation record) {
		return loanBusinessInformationMapper.delete(record.getId());
	}

	@Override
	public int delete(List<LoanBusinessInformation> records) {
		for(LoanBusinessInformation record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public LoanBusinessInformation findById(Long id) {
		return loanBusinessInformationMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, loanBusinessInformationMapper);
	}

	@Override
	public LoanBusinessInformation findByBasisId(Long loanBasicId) {
		return loanBusinessInformationMapper.findByLoanBasisId(loanBasicId);
	}
}
