package com.louis.kitty.admin.sevice.impl;

import com.louis.kitty.admin.dao.PawnMapper;
import com.louis.kitty.admin.dao.PawnPersonnelMappingMapper;
import com.louis.kitty.admin.dao.RelatedPersonnelInformationMapper;
import com.louis.kitty.admin.model.Pawn;
import com.louis.kitty.admin.model.PawnPersonnelMapping;
import com.louis.kitty.admin.model.RelatedPersonnelInformation;
import com.louis.kitty.admin.sevice.PawnPersonnelMappingService;
import com.louis.kitty.admin.sevice.PawnService;
import com.louis.kitty.admin.sevice.RelatedPersonnelInformationService;
import com.louis.kitty.core.page.MybatisPageHelper;
import com.louis.kitty.core.page.PageRequest;
import com.louis.kitty.core.page.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * ---------------------------
 * 所属名下资产信息表 (PawnPersonnelMappingServiceImpl)         
 * ---------------------------
 * 作者： lz
 * 时间：  2019-08-11 14:54:27
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Slf4j
@Service
public class PawnPersonnelMappingServiceImpl implements PawnPersonnelMappingService {

	@Resource
	private PawnPersonnelMappingMapper pawnPersonnelMappingMapper;
	@Resource
	private RelatedPersonnelInformationMapper relatedPersonnelInformationMapper;
	@Resource
	private PawnMapper pawnMapper;

	@Override
	public int save(PawnPersonnelMapping record) {
		if(record.getId() == null || record.getId() == 0) {
			return pawnPersonnelMappingMapper.add(record);
		}
		return pawnPersonnelMappingMapper.update(record);
	}

	@Override
	public int delete(PawnPersonnelMapping record) {
		return pawnPersonnelMappingMapper.delete(record.getId());
	}

	@Override
	public int delete(List<PawnPersonnelMapping> records) {
		for(PawnPersonnelMapping record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public PawnPersonnelMapping findById(Long id) {
		return pawnPersonnelMappingMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, pawnPersonnelMappingMapper);
	}

	@Override
	public List<RelatedPersonnelInformation> findByPawnId(Long pawnId) {
		try {
			List<PawnPersonnelMapping> mappings = pawnPersonnelMappingMapper.findByPawnList(pawnId);
			if(CollectionUtils.isEmpty(mappings)) {
				return null;
			}

			List<RelatedPersonnelInformation> list = new ArrayList<>();
			for(PawnPersonnelMapping mapping : mappings) {
				RelatedPersonnelInformation relatedPersonnelInformation = relatedPersonnelInformationMapper.findById(mapping.getRpiId());
				if(relatedPersonnelInformation == null) {
					continue;
				}

				list.add(relatedPersonnelInformation);
			}

			return list;
		} catch (Exception e) {
			log.error("findByRpiId by pawnId[{}] failed", pawnId, e);
			return null;
		}
	}

	@Override
	public List<Pawn> findByRpiId(Long rpiId) {
		try {
			List<PawnPersonnelMapping> mappings = pawnPersonnelMappingMapper.findByRpiId(rpiId);
			if(CollectionUtils.isEmpty(mappings)) {
				return null;
			}

			List<Pawn> list = new ArrayList<>();
			for(PawnPersonnelMapping mapping : mappings) {
				Pawn pawn = pawnMapper.findById(mapping.getPawnId());
				if(pawn == null) {
					continue;
				}

				list.add(pawn);
			}

			return list;
		} catch (Exception e) {
			log.error("findByRpiId by rpiId[{}] failed", rpiId, e);
			return null;
		}
	}
}
