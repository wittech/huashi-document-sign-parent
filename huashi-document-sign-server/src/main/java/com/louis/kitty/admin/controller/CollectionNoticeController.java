package com.louis.kitty.admin.controller;

import com.louis.kitty.admin.model.CollectionNotice;
import com.louis.kitty.admin.sevice.CollectionNoticeService;
import com.louis.kitty.core.http.HttpResult;
import com.louis.kitty.core.page.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ---------------------------
 * 贷款到期（逾期）催收通知书信息表 (CollectionNoticeController)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-10 10:03:25
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@RestController
@RequestMapping("collectionNotice")
public class CollectionNoticeController {

	@Autowired
	private CollectionNoticeService collectionNoticeService;

	/**
	 * 保存贷款到期（逾期）催收通知书信息表
	 * @param record
	 * @return
	 */	
	@PostMapping(value="/save")
	public HttpResult save(@RequestBody CollectionNotice record) {
		return HttpResult.ok(collectionNoticeService.save(record));
	}

    /**
     * 删除贷款到期（逾期）催收通知书信息表
     * @param records
     * @return
     */
	@PostMapping(value="/delete")
	public HttpResult delete(@RequestBody List<CollectionNotice> records) {
		return HttpResult.ok(collectionNoticeService.delete(records));
	}

    /**
     * 基础分页查询
     * @param pageRequest
     * @return
     */    
	@PostMapping(value="/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(collectionNoticeService.findPage(pageRequest));
	}
	
    /**
     * 根据主键查询
     * @param id
     * @return
     */ 	
	@GetMapping(value="/findById")
	public HttpResult findById(@RequestParam Long id) {
		return HttpResult.ok(collectionNoticeService.findById(id));
	}

	@GetMapping(value="/findLastest")
	public HttpResult findLastest() {
		return HttpResult.ok(collectionNoticeService.findLastest());
	}
}
