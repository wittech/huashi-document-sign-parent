package com.louis.kitty.admin.sevice;

import com.louis.kitty.admin.model.DocMeta;
import com.louis.kitty.core.http.HttpResult;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface DocMetaService {

	/**
	 * 保存文件
	 * 
	 * @param multipartFile
	 *            上传文件体
	 * @param type
	 *            业务类型（如 1：合影照片）
	 * @return 文件处理结构体
	 */
	HttpResult save(MultipartFile multipartFile, String type);

	/**
	 * 根据基础信息id查询合影列表
	 * 
	 * @param loanBasicId
	 * @return
	 */
	List<DocMeta> findByBasisId(Long loanBasicId);
	
	int delete(Long id);
}
