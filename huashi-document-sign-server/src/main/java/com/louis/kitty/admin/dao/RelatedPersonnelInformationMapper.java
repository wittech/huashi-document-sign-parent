package com.louis.kitty.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.louis.kitty.admin.model.RelatedPersonnelInformation;

/**
 * ---------------------------
 * 相关人员信息表 (RelatedPersonnelInformationMapper)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-10 22:28:24
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface RelatedPersonnelInformationMapper {

	/**
	 * 添加相关人员信息表
	 * @param record
	 * @return
	 */
    int add(RelatedPersonnelInformation record);

    /**
     * 删除相关人员信息表
     * @param id
     * @return
     */
    int delete(Long id);
    
    /**
     * 修改相关人员信息表
     * @param record
     * @return
     */
    int update(RelatedPersonnelInformation record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    RelatedPersonnelInformation findById(Long id);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<RelatedPersonnelInformation> findPage();
    
    /**
     * 根据基础id获取相关人信息
     * @param loanBasisId
     * @return
     */
    List<RelatedPersonnelInformation> findByBaseIdList(@Param(value = "loanBasisId") Long loanBasisId);

}