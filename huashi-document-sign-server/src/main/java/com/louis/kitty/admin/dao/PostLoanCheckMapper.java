package com.louis.kitty.admin.dao;

import java.util.List;

import com.louis.kitty.admin.dto.PostLoanCheckDto;
import com.louis.kitty.admin.model.PostLoanCheck;

/**
 * ---------------------------
 * 贷后检查信息表 (PostLoanCheckMapper)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-10 10:03:25
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface PostLoanCheckMapper {

	/**
	 * 添加贷后检查信息表
	 * @param record
	 * @return
	 */
    int add(PostLoanCheck record);

    /**
     * 删除贷后检查信息表
     * @param id
     * @return
     */
    int delete(Long id);
    
    /**
     * 修改贷后检查信息表
     * @param record
     * @return
     */
    int update(PostLoanCheck record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    PostLoanCheck findById(Long id);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<PostLoanCheck> findPage();
    
    /**
     * 根据借款人 状态查询 分页
     * @param record
     * @return
     */
     List<PostLoanCheckDto> findPageByBorrowerAndStatus(PostLoanCheck record);

    List<PostLoanCheckDto> findLasest();
    
}