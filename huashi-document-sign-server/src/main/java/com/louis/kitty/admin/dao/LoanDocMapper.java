package com.louis.kitty.admin.dao;

import java.util.List;

import com.louis.kitty.admin.model.LoanDoc;

/**
 * ---------------------------
 *  (LoanDocMapper)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-06 09:28:57
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface LoanDocMapper {

	/**
	 * 添加
	 * @param record
	 * @return
	 */
    int add(LoanDoc record);

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
    int update(LoanDoc record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    LoanDoc findById(Long id);

    /**
     * 基础分页查询
     * @return
     */    
    List<LoanDoc> findPage();

    /**
     * 根据基础ID查询所有的文档信息
     */
    List<LoanDoc> findByLoanBasisId(Long loanBasisId);

    /**
     * 下次次数+1
     */
    int addOneIfDownload(Long id);

    /**
     * 打印次数+1
     */
    int addOneIfPrint(Long id);
    
}