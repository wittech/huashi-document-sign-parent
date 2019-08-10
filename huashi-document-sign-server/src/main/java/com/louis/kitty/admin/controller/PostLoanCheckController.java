package com.louis.kitty.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.louis.kitty.core.http.HttpResult;
import com.louis.kitty.core.page.PageRequest;

import com.louis.kitty.admin.model.PostLoanCheck;
import com.louis.kitty.admin.sevice.PostLoanCheckService;

/**
 * ---------------------------
 * 贷后检查信息表 (PostLoanCheckController)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-10 10:03:26
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@RestController
@RequestMapping("postLoanCheck")
public class PostLoanCheckController {

	@Autowired
	private PostLoanCheckService postLoanCheckService;

	/**
	 * 保存贷后检查信息表
	 * @param record
	 * @return
	 */	
	@PostMapping(value="/save")
	public HttpResult save(@RequestBody PostLoanCheck record) {
		return HttpResult.ok(postLoanCheckService.save(record));
	}

    /**
     * 删除贷后检查信息表
     * @param records
     * @return
     */
	@PostMapping(value="/delete")
	public HttpResult delete(@RequestBody List<PostLoanCheck> records) {
		return HttpResult.ok(postLoanCheckService.delete(records));
	}

    /**
     * 基础分页查询
     * @param pageRequest
     * @return
     */    
	@PostMapping(value="/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(postLoanCheckService.findPage(pageRequest));
	}
	
    /**
     * 根据主键查询
     * @param id
     * @return
     */ 	
	@GetMapping(value="/findById")
	public HttpResult findById(@RequestParam Long id) {
		return HttpResult.ok(postLoanCheckService.findById(id));
	}
}
