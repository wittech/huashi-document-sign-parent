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

import com.louis.kitty.admin.model.AssetTypeOther;
import com.louis.kitty.admin.sevice.AssetTypeOtherService;

/**
 * ---------------------------
 * 资产类型其他信息表 (AssetTypeOtherController)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-08 11:53:18
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@RestController
@RequestMapping("assetTypeOther")
public class AssetTypeOtherController {

	@Autowired
	private AssetTypeOtherService assetTypeOtherService;

	/**
	 * 保存资产类型其他信息表
	 * @param record
	 * @return
	 */	
	@PostMapping(value="/save")
	public HttpResult save(@RequestBody AssetTypeOther record) {
		return HttpResult.ok(assetTypeOtherService.save(record));
	}

    /**
     * 删除资产类型其他信息表
     * @param records
     * @return
     */
	@PostMapping(value="/delete")
	public HttpResult delete(@RequestBody List<AssetTypeOther> records) {
		return HttpResult.ok(assetTypeOtherService.delete(records));
	}

    /**
     * 基础分页查询
     * @param pageRequest
     * @return
     */    
	@PostMapping(value="/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(assetTypeOtherService.findPage(pageRequest));
	}
	
    /**
     * 根据主键查询
     * @param id
     * @return
     */ 	
	@GetMapping(value="/findById")
	public HttpResult findById(@RequestParam Long id) {
		return HttpResult.ok(assetTypeOtherService.findById(id));
	}
}
