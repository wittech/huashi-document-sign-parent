package com.louis.kitty.admin.sevice.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.louis.kitty.admin.dao.LoanBusinessInformationMapper;
import com.louis.kitty.admin.dao.PawnMapper;
import com.louis.kitty.admin.dao.PawnPersonnelMappingMapper;
import com.louis.kitty.admin.model.LoanBusinessInformation;
import com.louis.kitty.admin.model.Pawn;
import com.louis.kitty.admin.model.PawnPersonnelMapping;
import com.louis.kitty.admin.sevice.PawnService;
import com.louis.kitty.core.page.MybatisPageHelper;
import com.louis.kitty.core.page.PageRequest;
import com.louis.kitty.core.page.PageResult;

/**
 * ---------------------------
 * 抵押物信息表 (PawnServiceImpl)         
 * ---------------------------
 * 作者： lz
 * 时间：  2019-08-08 11:53:18
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class PawnServiceImpl implements PawnService {

	@Autowired
	private PawnMapper pawnMapper;
	@Autowired
	private PawnPersonnelMappingMapper pawnPersonnelMappingMapper;
	@Autowired
	private LoanBusinessInformationMapper loanBusinessInformationMapper;

	@Override
	public int save(Pawn record) {
		boolean flag =false;
		//1、先删除在保存
		List<Pawn> pawnList = pawnMapper.findByLoanBasisId(record.getLoanBasisId());
		if(pawnList !=null){
			flag=true;
			for(Pawn p : pawnList){
				p.setLastUpdateBy(record.getLastUpdateBy());
				p.setLastUpdateTime(new Date());
				p.setDelFlag(-1);
				pawnMapper.update(p);
				List<PawnPersonnelMapping> mappingList = pawnPersonnelMappingMapper.findByPawnList(p.getId());
				if(mappingList.size()>0){
					for(PawnPersonnelMapping m : mappingList){
						pawnPersonnelMappingMapper.delete(m.getId());
					}
				}
			}
		}
		//2、保存
		List<Pawn> list =  record.getPawn();
		if(list !=null){
			for(Pawn md : list){
				if(flag){
					md.setId(null);
					md.setLastUpdateTime(new Date());
				}
				md.setCreateTime(new Date());
				pawnMapper.add(md);
				Long id = md.getId();
				if(id>0){
					if(md.getPawnPersonnelMapping() !=null){
						for(PawnPersonnelMapping m : md.getPawnPersonnelMapping()){
							m.setPawnId(id);
							pawnPersonnelMappingMapper.add(m);
						}
					}
				}
			}
		}
		return 1;
	}

	@Override
	public int delete(Pawn record) {
		return pawnMapper.delete(record.getId());
	}

	@Override
	public int delete(List<Pawn> records) {
		for(Pawn record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public Pawn findById(Long id) {
		return pawnMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, pawnMapper);
	}

	@Override
	public List<Pawn> findByLoanBasisId(Long loanBasisId) {
		return pawnMapper.findByLoanBasisId(loanBasisId);
	}

	@Override
	public LoanBusinessInformation findByBasisId(Long loanBasicId) {
		return loanBusinessInformationMapper.findByLoanBasisId(loanBasicId);
	}
	
}
