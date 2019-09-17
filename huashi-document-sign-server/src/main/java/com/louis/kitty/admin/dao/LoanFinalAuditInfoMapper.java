package com.louis.kitty.admin.dao;

import com.louis.kitty.admin.model.LoanFinalAuditInfo;
import org.apache.ibatis.annotations.Param;

public interface LoanFinalAuditInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LoanFinalAuditInfo record);

    int insertSelective(LoanFinalAuditInfo record);

    LoanFinalAuditInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LoanFinalAuditInfo record);

    int updateByPrimaryKey(LoanFinalAuditInfo record);

    LoanFinalAuditInfo findByBasisId(@Param("loanBasisId") Long loanBasisId);
}