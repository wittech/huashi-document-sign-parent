package com.louis.kitty.admin.dao;

import com.louis.kitty.admin.model.LoanFinalAuditInfo;

public interface LoanFinalAuditInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LoanFinalAuditInfo record);

    int insertSelective(LoanFinalAuditInfo record);

    LoanFinalAuditInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LoanFinalAuditInfo record);

    int updateByPrimaryKey(LoanFinalAuditInfo record);
}