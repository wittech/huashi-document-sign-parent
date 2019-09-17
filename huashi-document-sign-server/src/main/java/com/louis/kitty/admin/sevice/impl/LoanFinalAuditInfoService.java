package com.louis.kitty.admin.sevice.impl;

import com.louis.kitty.admin.dao.LoanFinalAuditInfoMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.louis.kitty.admin.model.LoanFinalAuditInfo;

@Service
public class LoanFinalAuditInfoService{

    @Resource
    private LoanFinalAuditInfoMapper loanFinalAuditInfoMapper;

    public int deleteByPrimaryKey(Long id){
        return loanFinalAuditInfoMapper.deleteByPrimaryKey(id);
    }

    public int save(LoanFinalAuditInfo record){
        if(record.getId() != null) {
            return loanFinalAuditInfoMapper.updateByPrimaryKey(record);
        } else {
            return loanFinalAuditInfoMapper.insert(record);
        }
    }

    public int insertSelective(LoanFinalAuditInfo record){
        return loanFinalAuditInfoMapper.insertSelective(record);
    }

    public LoanFinalAuditInfo selectByPrimaryKey(Long id){
        return loanFinalAuditInfoMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(LoanFinalAuditInfo record){
        return loanFinalAuditInfoMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(LoanFinalAuditInfo record){
        return loanFinalAuditInfoMapper.updateByPrimaryKey(record);
    }

    public LoanFinalAuditInfo findByBasisId(Long loanBasisId) {
        return loanFinalAuditInfoMapper.findByBasisId(loanBasisId);
    }


}
