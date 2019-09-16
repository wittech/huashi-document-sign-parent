package com.louis.kitty.admin.dao;

import java.util.List;

import com.louis.kitty.admin.model.LoanDoc;
import org.apache.ibatis.annotations.Param;

/**
 * ---------------------------
 * (LoanDocMapper)
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-06 09:28:57
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface LoanDocMapper {

    /**
     * 添加
     *
     * @param record
     * @return
     */
    int add(LoanDoc record);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 修改
     *
     * @param record
     * @return
     */
    int update(LoanDoc record);

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    LoanDoc findById(Long id);

    /**
     * 基础分页查询
     *
     * @return
     */
    List<LoanDoc> findPage();

    /**
     * 根据基础ID和文档归属类型查询所有的文档信息
     */
    List<LoanDoc> findByLoanBasisId(@Param("loanBasisId") Long loanBasisId, @Param("list") List<String> list);

    /**
     * 根据IDS查询集合
     *
     * @param ids ID集合
     */
    List<LoanDoc> findByIds(List<String> ids);

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
     *
     * @param loanBasisId
     * @return
     */
    int deleteByLoanBasisId(Long loanBasisId);


}