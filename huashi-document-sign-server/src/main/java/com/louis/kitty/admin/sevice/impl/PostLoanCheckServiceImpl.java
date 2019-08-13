package com.louis.kitty.admin.sevice.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.louis.kitty.admin.dao.PostLoanCheckMapper;
import com.louis.kitty.admin.model.PostLoanCheck;
import com.louis.kitty.admin.sevice.PostLoanCheckService;
import com.louis.kitty.core.page.ColumnFilter;
import com.louis.kitty.core.page.MybatisPageHelper;
import com.louis.kitty.core.page.PageRequest;
import com.louis.kitty.core.page.PageResult;

/**
 * ---------------------------
 * 贷后检查信息表 (PostLoanCheckServiceImpl)         
 * ---------------------------
 * 作者： lz
 * 时间：  2019-08-10 10:03:26
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class PostLoanCheckServiceImpl implements PostLoanCheckService {

	@Autowired
	private PostLoanCheckMapper postLoanCheckMapper;

	@Override
	public int save(PostLoanCheck record) {
		if(record.getId() == null || record.getId() == 0) {
			return postLoanCheckMapper.add(record);
		}
		return postLoanCheckMapper.update(record);
	}

	@Override
	public int delete(PostLoanCheck record) {
		return postLoanCheckMapper.delete(record.getId());
	}

	@Override
	public int delete(List<PostLoanCheck> records) {
		for(PostLoanCheck record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public PostLoanCheck findById(Long id) {
		return postLoanCheckMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		String borrower = getColumnFilterValue(pageRequest, "borrower");
		System.out.println("borrower==="+borrower);
		String status = getColumnFilterValue(pageRequest, "status");
		System.out.println("status==="+status);
		PostLoanCheck record = new PostLoanCheck();
		record.setBorrower(borrower);
		if(StringUtils.isNotEmpty(status)){
			record.setStatus(Integer.parseInt(status));
		}
		return MybatisPageHelper.findPage(pageRequest, postLoanCheckMapper, "findPageByBorrowerAndStatus", record);
	}
	
	/**
	 * 获取过滤字段的值
	 * @param filterName
	 * @return
	 */
	public String getColumnFilterValue(PageRequest pageRequest, String filterName) {
		String value = null;
		ColumnFilter columnFilter = pageRequest.getColumnFilter(filterName);
		if(columnFilter != null) {
			value = columnFilter.getValue();
		}
		return value;
	}
}
