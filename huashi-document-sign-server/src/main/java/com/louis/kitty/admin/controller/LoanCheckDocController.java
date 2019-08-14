package com.louis.kitty.admin.controller;

import java.util.List;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.louis.kitty.core.http.HttpResult;
import com.louis.kitty.core.page.PageRequest;

import com.louis.kitty.admin.model.LoanCheckDoc;
import com.louis.kitty.admin.sevice.LoanCheckDocService;

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
	public Object download(@RequestParam String loanCheckIds) {
		return loanCheckDocService.download(loanCheckIds);
	}

	@RequestMapping(value = "/print")
	@ApiOperation(value = "打印借贷检查文件")
	public String print(@RequestParam String loanCheckIds) {
		return loanCheckDocService.print(loanCheckIds);
	}
}
