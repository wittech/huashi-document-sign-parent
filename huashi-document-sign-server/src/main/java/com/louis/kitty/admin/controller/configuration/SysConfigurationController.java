package com.louis.kitty.admin.controller.configuration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.louis.kitty.admin.model.SysConfiguration;
import com.louis.kitty.admin.sevice.SysConfigurationService;
import com.louis.kitty.core.http.HttpResult;
import com.louis.kitty.core.page.PageRequest;

/**
 * ---------------------------
 * 系统配置信息表 (SysConfigurationController)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-07-17 21:19:18
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@RestController
@RequestMapping("configuration")
public class SysConfigurationController {

	@Autowired
	private SysConfigurationService sysConfigurationService;

	/**
	 * 保存系统配置信息表
	 * @param record
	 * @return
	 */	
	@PreAuthorize("hasAuthority('configuration:add') AND hasAuthority('configuration:edit')")
	@PostMapping(value="/save")
	public HttpResult save(@RequestBody SysConfiguration record) {
		return HttpResult.ok(sysConfigurationService.save(record));
	}

    /**
     * 删除系统配置信息表
     * @param records
     * @return
     */
	@PreAuthorize("hasAuthority('configuration:add')")
	@PostMapping(value="/delete")
	public HttpResult delete(@RequestBody List<SysConfiguration> records) {
		return HttpResult.ok(sysConfigurationService.delete(records));
	}

    /**
     * 基础分页查询
     * @param pageRequest
     * @return
     */    
	@PreAuthorize("hasAuthority('configuration:view')")
	@PostMapping(value="/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(sysConfigurationService.findPage(pageRequest));
	}
	
    /**
     * 根据主键查询
     * @param id
     * @return
     */ 	
	@PreAuthorize("hasAuthority('configuration:add')")
	@GetMapping(value="/findById")
	public HttpResult findById(@RequestParam Long id) {
		return HttpResult.ok(sysConfigurationService.findById(id));
	}
}
