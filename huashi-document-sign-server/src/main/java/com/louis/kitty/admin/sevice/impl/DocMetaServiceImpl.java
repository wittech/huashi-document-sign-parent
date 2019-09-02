package com.louis.kitty.admin.sevice.impl;

import com.louis.kitty.admin.dao.DocMetaMapper;
import com.louis.kitty.admin.model.DocMeta;
import com.louis.kitty.admin.sevice.DocMetaService;
import com.louis.kitty.admin.util.FileUploadUtil;
import com.louis.kitty.core.http.HttpResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class DocMetaServiceImpl implements DocMetaService {

    @Resource
    private DocMetaMapper docMetaMapper;

//    @Value("${storage.resource.path}")
    private String storageResourcePath="F:\\bankWeb\\";
    @Value("${storage.resource.domain}")
    private String storageResourceDomain;

    @Override
    public HttpResult save(MultipartFile multipartFile, String type) {
        if (multipartFile == null) {
            return HttpResult.error("上传文件数据为空");
        }

        if (StringUtils.isEmpty(type)) {
            return HttpResult.error("未知文件类型");
        }

        try {
            FileUploadUtil.FileUploadResult fileUploadResult = FileUploadUtil.upload(multipartFile.getBytes(),
                    multipartFile.getOriginalFilename(), storageResourcePath);

            if (!fileUploadResult.isResult()) {
                return HttpResult.error(fileUploadResult.getMsg());
            }

            Long docId = save(type, multipartFile.getOriginalFilename(), fileUploadResult);

            return HttpResult.ok(docId);
        } catch (Exception e) {
            log.error("multipartFile[{}]. type[{}] upload failed", multipartFile.getOriginalFilename(), type, e);
            return HttpResult.error("文件上传失败");
        }

    }

    private Long save(String type, String originName, FileUploadUtil.FileUploadResult fileUploadResult) {
        DocMeta docMeta = DocMeta.builder().type(type).originName(originName).newName(fileUploadResult.getFilename())
                .size(fileUploadResult.getFileSize()).path(fileUploadResult
                        .getFileFullName()).url(fileUploadResult.getUrlPathName())
                .createTime(new Date()).build();

        int result = docMetaMapper.add(docMeta);
        if (result <= 0) {
            throw new RuntimeException("file[" + fileUploadResult.getFileFullName() + "] insert failed");
        }

        return docMeta.getId();
    }

	@Override
	public List<DocMeta> findByBasisId(Long loanBasicId) {
		return docMetaMapper.findByBasisId(loanBasicId);
	}

	@Override
	public int delete(Long id) {
		return docMetaMapper.delete(id);
	}
}
