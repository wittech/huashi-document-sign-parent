package com.louis.kitty.admin.controller.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.louis.kitty.admin.model.DocFile;
import com.louis.kitty.admin.sevice.DocFileService;
import com.louis.kitty.core.http.HttpResult;
import com.louis.kitty.core.page.PageRequest;

/**
 * ---------------------------
 *  (DocFileController)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-07-17 21:38:51
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@RestController
@RequestMapping("customer")
public class DocFileController {

	@Autowired
	private DocFileService docFileService;

	/**
	 * 保存
	 * @param record
	 * @return
	 */	
	@PostMapping(value="/save")
	public HttpResult save(@RequestBody DocFile record) {
		return HttpResult.ok(docFileService.save(record));
	}

    /**
     * 删除
     * @param records
     * @return
     */
	@PostMapping(value="/delete")
	public HttpResult delete(@RequestBody List<DocFile> records) {
		return HttpResult.ok(docFileService.delete(records));
	}

    /**
     * 基础分页查询
     * @param pageRequest
     * @return
     */    
	@PostMapping(value="/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(docFileService.findPage(pageRequest));
	}
	
    /**
     * 根据主键查询
     * @param id
     * @return
     */ 	
	@GetMapping(value="/findById")
	public HttpResult findById(@RequestParam Long id) {
		return HttpResult.ok(docFileService.findById(id));
	}
}
