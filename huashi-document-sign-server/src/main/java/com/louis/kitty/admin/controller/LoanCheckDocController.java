package com.louis.kitty.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.louis.kitty.admin.sevice.LoanCheckDocService;
import com.louis.kitty.core.http.HttpResult;

import io.swagger.annotations.ApiOperation;

/**
 * ---------------------------
 *  (LoanCheckDocController)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-14 10:54:33
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@RestController
@RequestMapping("loanCheckDoc")
public class LoanCheckDocController {

	@Autowired
	private LoanCheckDocService loanCheckDocService;

	@RequestMapping(value = "/download", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "下载借贷检查文件", httpMethod = "GET", produces = "application/json;charset=UTF-8")
	public Object download(@RequestParam String loanCheckDocIds) {
		return loanCheckDocService.download(loanCheckDocIds);
	}

	@RequestMapping(value = "/print")
	@ApiOperation(value = "打印借贷检查文件")
	public String print(@RequestParam String loanCheckDocIds, String watermark) {
		return loanCheckDocService.print(loanCheckDocIds, watermark);
	}

	/**
	 * 根据基础信息表id 查询所有 借贷文档信息
	 *
	 * @param loanCheckId 借贷检查ID
	 */
	@GetMapping(value = "/queryByLoanCheckId")
	public HttpResult findByLoanNoticeId(@RequestParam Long loanCheckId) {
		return HttpResult.ok(loanCheckDocService.queryByLoanCheckId(loanCheckId));
	}

	@GetMapping(value = "/born")
	public HttpResult born(@RequestParam Long loanCheckId) {
		try {
			return HttpResult.ok(loanCheckDocService.born(loanCheckId));
		} catch (Exception e) {
			return HttpResult.ok(0);
		}
	}

}
