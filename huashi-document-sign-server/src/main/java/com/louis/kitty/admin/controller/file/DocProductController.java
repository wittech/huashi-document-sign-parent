/**
 * 
 */
package com.louis.kitty.admin.controller.file;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.louis.kitty.admin.model.NoticeAnnouncementModel;
import com.louis.kitty.admin.sevice.NoticeAnnouncementService;
import com.louis.kitty.core.http.HttpResult;
import com.louis.kitty.core.page.PageRequest;

/**
 * 文档模板管理
 * @author lz
 *
 */
@RestController
@RequestMapping("doc_product")
public class DocProductController {
	
	@Autowired
	private NoticeAnnouncementService noticeAnnouncementService;

	@PreAuthorize("hasAuthority('doc_product:add') AND hasAuthority('doc_product:edit')")
	@PostMapping(value = "/save")
	public HttpResult save(@RequestBody NoticeAnnouncementModel record) {
		return HttpResult.ok(noticeAnnouncementService.save(record));
	}

	@PreAuthorize("hasAuthority('doc_product:delete')")
	@PostMapping(value = "/delete")
	public HttpResult delete(@RequestBody List<NoticeAnnouncementModel> records) {
		return HttpResult.ok(noticeAnnouncementService.delete(records));
	}

	@PreAuthorize("hasAuthority('doc_product:view')")
	@PostMapping(value = "/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(noticeAnnouncementService.findPage(pageRequest));
	}

	@PreAuthorize("hasAuthority('doc_product:view')")
	@GetMapping(value = "/findByTitle")
	public HttpResult findByLable(@RequestParam String title) {
		return HttpResult.ok(noticeAnnouncementService.findByTitle(title));
	}

}
