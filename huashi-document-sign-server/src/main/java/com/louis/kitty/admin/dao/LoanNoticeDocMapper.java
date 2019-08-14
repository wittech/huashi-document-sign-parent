package com.louis.kitty.admin.dao;

import com.louis.kitty.admin.model.LoanCheckDoc;
import com.louis.kitty.admin.model.LoanNoticeDoc;

import java.util.List;

/**
 * ---------------------------
 *  (LoanNoticeDocMapper)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-14 10:54:33
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface LoanNoticeDocMapper {

	/**
	 * 添加
	 * @param record
	 * @return
	 */
    int add(LoanNoticeDoc record);

    /**
     * 删除
     * @param id
     * @return
     */
    int delete(Long id);
    
    /**
     * 修改
     * @param record
     * @return
     */
    int update(LoanNoticeDoc record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    LoanNoticeDoc findById(Long id);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<LoanNoticeDoc> findPage();

    /**
     * 根据催缴通知ID查询所有的文档信息
     */
    List<LoanNoticeDoc> findByLoanNoticeId(Long loanNoticeId);

    /**
     * 根据IDS查询集合
     * @param ids ID集合
     */
    List<LoanNoticeDoc> findByIds(List<String> ids);

    /**
     * 下次次数+1
     */
    int addOneIfDownload(List<String> ids);

    /**
     * 打印次数+1
     */
    int addOneIfPrint(List<String> ids);

    /**
     * 根据基础借贷信息删除
     * @param loanNoticeId
     * @return
     */
    int deleteByLoanNoticeId(Long loanNoticeId);
    
}