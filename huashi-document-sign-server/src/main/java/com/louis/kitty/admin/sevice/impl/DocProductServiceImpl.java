package com.louis.kitty.admin.sevice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.louis.kitty.admin.dao.DocProductMapper;
import com.louis.kitty.admin.model.DocProduct;
import com.louis.kitty.admin.sevice.DocProductService;
import com.louis.kitty.core.page.MybatisPageHelper;
import com.louis.kitty.core.page.PageRequest;
import com.louis.kitty.core.page.PageResult;

/**
 * ---------------------------
 *  (DocProductServiceImpl)         
 * ---------------------------
 * 作者： lz
 * 时间：  2019-07-17 21:29:30
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class DocProductServiceImpl implements DocProductService {

	@Autowired
	private DocProductMapper docProductMapper;

	@Override
	public int save(DocProduct record) {
		if(record.getId() == null || record.getId() == 0) {
			return docProductMapper.add(record);
		}
		return docProductMapper.update(record);
	}

	@Override
	public int delete(DocProduct record) {
		return docProductMapper.delete(record.getId());
	}

	@Override
	public int delete(List<DocProduct> records) {
		for(DocProduct record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public DocProduct findById(Long id) {
		return docProductMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, docProductMapper);
	}
	
}
