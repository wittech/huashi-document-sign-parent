package com.louis.kitty.admin.sevice.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.louis.kitty.admin.dao.CollectionNoticeMapper;
import com.louis.kitty.admin.model.CollectionNotice;
import com.louis.kitty.admin.sevice.CollectionNoticeService;
import com.louis.kitty.core.page.ColumnFilter;
import com.louis.kitty.core.page.MybatisPageHelper;
import com.louis.kitty.core.page.PageRequest;
import com.louis.kitty.core.page.PageResult;

/**
 * ---------------------------
 * 贷款到期（逾期）催收通知书信息表 (CollectionNoticeServiceImpl)         
 * ---------------------------
 * 作者： lz
 * 时间：  2019-08-10 10:03:25
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class CollectionNoticeServiceImpl implements CollectionNoticeService {

	@Autowired
	private CollectionNoticeMapper collectionNoticeMapper;

	@Override
	public int save(CollectionNotice record) {
		if(record.getId() == null || record.getId() == 0) {
			return collectionNoticeMapper.add(record);
		}
		return collectionNoticeMapper.update(record);
	}

	@Override
	public int delete(CollectionNotice record) {
		return collectionNoticeMapper.delete(record.getId());
	}

	@Override
	public int delete(List<CollectionNotice> records) {
		for(CollectionNotice record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public CollectionNotice findById(Long id) {
		return collectionNoticeMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		String borrower = getColumnFilterValue(pageRequest, "borrower");
		System.out.println("borrower==="+borrower);
		String status = getColumnFilterValue(pageRequest, "status");
		System.out.println("status==="+status);
		CollectionNotice record = new CollectionNotice();
		record.setBorrower(borrower);
		if(StringUtils.isNotEmpty(status)){
			record.setStatus(Integer.parseInt(status));
		}
		return MybatisPageHelper.findPage(pageRequest, collectionNoticeMapper, "findPageByBorrowerAndStatus", record);
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
	
    @Override
    public CollectionNotice findByLoanBasisId(Long loanBasisId) {
		return collectionNoticeMapper.findByLoanBasisId(loanBasisId);
    }


}
