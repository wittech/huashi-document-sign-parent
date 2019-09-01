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

import com.louis.kitty.admin.model.GroupPhoto;
import com.louis.kitty.admin.sevice.GroupPhotoService;

/**
 * ---------------------------
 * 合影信息表 (GroupPhotoController)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-08 11:53:18
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@RestController
@RequestMapping("groupPhoto")
public class GroupPhotoController {

	@Autowired
	private GroupPhotoService groupPhotoService;

	/**
	 * 保存合影信息表
	 * @param record
	 * @return
	 */	
	@PostMapping(value="/save")
	public HttpResult save(@RequestBody List<GroupPhoto> record) {
		if(record !=null){
			for(GroupPhoto photo : record){
				groupPhotoService.save(photo);
			}
			return HttpResult.ok("成功");
		}
		 return HttpResult.error("失败");
	}

    /**
     * 删除合影信息表
     * @param records
     * @return
     */
	@PostMapping(value="/delete")
	public HttpResult delete(@RequestBody List<GroupPhoto> records) {
		return HttpResult.ok(groupPhotoService.delete(records));
	}

    /**
     * 基础分页查询
     * @param pageRequest
     * @return
     */    
	@PostMapping(value="/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(groupPhotoService.findPage(pageRequest));
	}
	
    /**
     * 根据主键查询
     * @param id
     * @return
     */ 	
	@GetMapping(value="/findById")
	public HttpResult findById(@RequestParam Long id) {
		return HttpResult.ok(groupPhotoService.findById(id));
	}
}
