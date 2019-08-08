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

import com.louis.kitty.admin.model.AssetTypeLand;
import com.louis.kitty.admin.sevice.AssetTypeLandService;

/**
 * ---------------------------
 * 资产类型土地信息表 (AssetTypeLandController)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-08 11:53:17
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@RestController
@RequestMapping("assetTypeLand")
public class AssetTypeLandController {

	@Autowired
	private AssetTypeLandService assetTypeLandService;

	/**
	 * 保存资产类型土地信息表
	 * @param record
	 * @return
	 */	
	@PostMapping(value="/save")
	public HttpResult save(@RequestBody AssetTypeLand record) {
		return HttpResult.ok(assetTypeLandService.save(record));
	}

    /**
     * 删除资产类型土地信息表
     * @param records
     * @return
     */
	@PostMapping(value="/delete")
	public HttpResult delete(@RequestBody List<AssetTypeLand> records) {
		return HttpResult.ok(assetTypeLandService.delete(records));
	}

    /**
     * 基础分页查询
     * @param pageRequest
     * @return
     */    
	@PostMapping(value="/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(assetTypeLandService.findPage(pageRequest));
	}
	
    /**
     * 根据主键查询
     * @param id
     * @return
     */ 	
	@GetMapping(value="/findById")
	public HttpResult findById(@RequestParam Long id) {
		return HttpResult.ok(assetTypeLandService.findById(id));
	}
}
