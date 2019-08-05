package com.louis.kitty.admin.sevice;

import com.louis.kitty.admin.util.FileUploadUtil;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    FileUploadUtil.FileUploadResult upload(MultipartFile file);


}
