package com.louis.kitty.admin.sevice;

import com.louis.kitty.admin.model.Pawn;
import com.louis.kitty.admin.model.PawnPersonnelMapping;
import com.louis.kitty.admin.model.RelatedPersonnelInformation;
import com.louis.kitty.core.service.CurdService;

import java.util.List;

/**
 * ---------------------------
 * 所属名下资产信息表 (PawnPersonnelMappingService)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-11 14:54:27
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface PawnPersonnelMappingService extends CurdService<PawnPersonnelMapping> {

    /**
     * 根据抵押物信息获取 所属人
     * @param pawnId 抵押物ID
     * @return 所属人集合信息
     */
    List<RelatedPersonnelInformation> findByPawnId(Long pawnId);

    List<Pawn> findByRpiId(Long rpiId);
}
