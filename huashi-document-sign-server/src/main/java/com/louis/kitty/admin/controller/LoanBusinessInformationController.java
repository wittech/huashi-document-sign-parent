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

import com.louis.kitty.admin.model.LoanBusinessInformation;
import com.louis.kitty.admin.sevice.LoanBusinessInformationService;

/**
 * ---------------------------
 * 贷款业务信息表 (LoanBusinessInformationController)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-08 11:53:18
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@RestController
@RequestMapping("loanBusinessInformation")
public class LoanBusinessInformationController {

	@Autowired
	private LoanBusinessInformationService loanBusinessInformationService;

	/**
	 * 保存贷款业务信息表
	 * @param record
	 * @return
	 */	
	@PostMapping(value="/save")
	public HttpResult save(@RequestBody LoanBusinessInformation record) {
		return HttpResult.ok(loanBusinessInformationService.save(record));
	}

    /**
     * 删除贷款业务信息表
     * @param records
     * @return
     */
	@PostMapping(value="/delete")
	public HttpResult delete(@RequestBody List<LoanBusinessInformation> records) {
		return HttpResult.ok(loanBusinessInformationService.delete(records));
	}

    /**
     * 基础分页查询
     * @param pageRequest
     * @return
     */    
	@PostMapping(value="/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(loanBusinessInformationService.findPage(pageRequest));
	}
	
    /**
     * 根据主键查询
     * @param id
     * @return
     */ 	
	@GetMapping(value="/findById")
	public HttpResult findById(@RequestParam Long id) {
		return HttpResult.ok(loanBusinessInformationService.findById(id));
	}
	
	 /**
     * 根据loanBasicId查询
     * @param loanBasicId
     * @return
     */ 	
	@GetMapping(value="/findByBasisId")
	public HttpResult findByBasisId(@RequestParam Long loanBasicId) {
		return HttpResult.ok(loanBusinessInformationService.findByBasisId(loanBasicId));
	}
}
