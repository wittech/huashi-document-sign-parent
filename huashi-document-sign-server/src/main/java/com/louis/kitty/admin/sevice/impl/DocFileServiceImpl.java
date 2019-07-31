package com.louis.kitty.admin.sevice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.louis.kitty.admin.dao.DocFileMapper;
import com.louis.kitty.admin.model.DocFile;
import com.louis.kitty.admin.sevice.DocFileService;
import com.louis.kitty.core.page.ColumnFilter;
import com.louis.kitty.core.page.MybatisPageHelper;
import com.louis.kitty.core.page.PageRequest;
import com.louis.kitty.core.page.PageResult;

/**
 * ---------------------------s
 *  (DocFileServiceImpl)         
 * ---------------------------
 * 作者： lz
 * 时间：  2019-07-17 21:38:51
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class DocFileServiceImpl implements DocFileService {

	@Autowired
	private DocFileMapper docFileMapper;

	@Override
	public int save(DocFile record) {
		if(record.getId() == null || record.getId() == 0) {
			return docFileMapper.add(record);
		}
		return docFileMapper.update(record);
	}

	@Override
	public int delete(DocFile record) {
		return docFileMapper.delete(record.getId());
	}

	@Override
	public int delete(List<DocFile> records) {
		for(DocFile record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public DocFile findById(Long id) {
		return docFileMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		ColumnFilter columnFilter = pageRequest.getColumnFilter("name");
		if(columnFilter != null) {
			return MybatisPageHelper.findPage(pageRequest, docFileMapper, "findPageByFileTemp", columnFilter.getValue());
		}
		return MybatisPageHelper.findPage(pageRequest, docFileMapper);
	}
	
}
