package com.louis.kitty.admin.controller;

import java.util.ArrayList;
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
import com.louis.kitty.admin.model.DocMeta;
import com.louis.kitty.admin.model.GroupPhoto;
import com.louis.kitty.admin.sevice.DocMetaService;
import com.louis.kitty.admin.sevice.GroupPhotoService;
import com.louis.kitty.admin.vo.GroupPhotoVo;

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
	@Autowired
	private DocMetaService docMetaService;

	/**
	 * 保存合影信息表
	 * @param record
	 * @return
	 */	
	@PostMapping(value="/save")
	public HttpResult save(@RequestBody List<GroupPhoto> filePhotoList) {
		if(filePhotoList !=null){
			for(GroupPhoto photo : filePhotoList){
				groupPhotoService.save(photo);
			}
			return HttpResult.ok("成功");
		}
		 return HttpResult.error("失败");
	}
	
	/**
	 * 保存合影信息表
	 * @param record
	 * @return
	 */	
	@PostMapping(value="/update")
	public HttpResult update(@RequestBody GroupPhotoVo vo) {
		if(vo !=null){
			List<GroupPhoto> filePhotoList = vo.getFilePhotoList();
			Long loanBasisId = vo.getLoanBasisId();
			if(filePhotoList !=null){
				//1、先根据基础信息id删除合影数据 在保存
				List<DocMeta> list = docMetaService.findByBasisId(loanBasisId);
				if(list !=null){
					if(list.size()>0){
						/*for(DocMeta d :list){
							docMetaService.delete(d.getId());
						}*/
						groupPhotoService.deleteByLoanBasicId(loanBasisId);
					}
				}
				for(GroupPhoto photo : filePhotoList){
					groupPhotoService.save(photo);
				}
				//2、在根据基础信息id查询合影数据  判断是否存在 不存在则删除
				List<DocMeta> docList = docMetaService.findByBasisId(loanBasisId);
				if(docList !=null){
					if(docList.size()>0){
						List<DocMeta> docListNew = new ArrayList<DocMeta>();
						for(DocMeta d :list){
							boolean flag = true;
							for(GroupPhoto photo : filePhotoList){
								//如果不相等 加标记 代表需要删除
								if(photo.getDocMetaId() !=d.getId()){
									flag=false;
								}
							}
							if(flag){
								docListNew.add(d);
							}
						}
						//删除图片信息
						for(DocMeta d :docListNew){
							docMetaService.delete(d.getId());
						}
					}
				}
				return HttpResult.ok("成功");
			}
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
	
	/**
	 * 根据基础id获取合影信息
	 * @param loanBasisId
	 * @return
	 */
	@GetMapping(value="/findByBasisIdList")
	public HttpResult findByBasisId(@RequestParam Long loanBasisId) {
		return HttpResult.ok(docMetaService.findByBasisId(loanBasisId));
	}
}
