/**
 * 
 */
package com.louis.kitty.admin.controller.doc_product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.louis.kitty.admin.model.DocProduct;
import com.louis.kitty.admin.sevice.DocProductService;
import com.louis.kitty.core.http.HttpResult;
import com.louis.kitty.core.page.PageRequest;

/**
 * 文档模板管理
 * @author lz
 *
 */
@RestController
@RequestMapping("docProduct")
public class DocProductController {
	
	@Autowired
	private DocProductService docProductService;

	@PreAuthorize("hasAuthority('docProduct:add') AND hasAuthority('docProduct:edit')")
	@PostMapping(value = "/save")
	public HttpResult save(@RequestBody DocProduct record) {
		return HttpResult.ok(docProductService.save(record));
	}

	@PreAuthorize("hasAuthority('docProduct:delete')")
	@PostMapping(value = "/delete")
	public HttpResult delete(@RequestBody List<DocProduct> records) {
		return HttpResult.ok(docProductService.delete(records));
	}

	@PreAuthorize("hasAuthority('docProduct:view')")
	@PostMapping(value = "/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(docProductService.findPage(pageRequest));
	}

}
