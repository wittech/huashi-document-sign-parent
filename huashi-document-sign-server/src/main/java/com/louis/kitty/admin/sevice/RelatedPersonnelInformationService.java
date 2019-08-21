package com.louis.kitty.admin.sevice;

import java.util.List;

import com.louis.kitty.admin.model.RelatedPersonnelInformation;
import com.louis.kitty.core.service.CurdService;

/**
 * ---------------------------
 * 相关人员信息表 (RelatedPersonnelInformationService)
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-08 11:53:18
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface RelatedPersonnelInformationService extends CurdService<RelatedPersonnelInformation> {

    /**
     * 根据基础id获取 相关人列表
     *
     * @param loanBasisId
     * @return
     */
    List<RelatedPersonnelInformation> findByBaseIdList(Long loanBasisId);
    
    
    RelatedPersonnelInformation findByBaseIdAndType(RelatedPersonnelInformation record);

}
