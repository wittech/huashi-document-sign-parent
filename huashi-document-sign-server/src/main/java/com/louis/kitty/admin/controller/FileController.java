package com.louis.kitty.admin.controller;

import com.louis.kitty.admin.sevice.DocMetaService;
import com.louis.kitty.admin.sevice.LoanDocService;
import com.louis.kitty.core.http.HttpResult;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("file")
@AllArgsConstructor
public class FileController {

    private DocMetaService docMetaService;
    private LoanDocService loanDocService;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ApiOperation(value = "上传图片文件", httpMethod = "POST")
    public HttpResult upload(@RequestParam("file") MultipartFile file, String type) {
        return docMetaService.save(file, type);
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ApiOperation(value = "下载借贷文件", httpMethod = "GET", produces = "application/json;charset=UTF-8")
    public Object download(Long loanDocId) {
        return loanDocService.download(loanDocId);
    }

}
