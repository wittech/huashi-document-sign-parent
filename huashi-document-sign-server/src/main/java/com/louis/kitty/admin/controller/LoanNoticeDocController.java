package com.louis.kitty.admin.controller;

import com.louis.kitty.admin.sevice.LoanNoticeDocService;
import com.louis.kitty.core.http.HttpResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ---------------------------
 * (LoanNoticeDocController)
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-14 10:54:33
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@RestController
@RequestMapping("loanNoticeDoc")
public class LoanNoticeDocController {

    @Autowired
    private LoanNoticeDocService loanNoticeDocService;

    @RequestMapping(value = "/download", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ApiOperation(value = "下载催缴通知文件", httpMethod = "GET", produces = "application/json;charset=UTF-8")
    public Object download(@RequestParam String loanNoticeDocIds) {
        return loanNoticeDocService.download(loanNoticeDocIds);
    }

    @RequestMapping(value = "/print")
    @ApiOperation(value = "打印催缴通知文件")
    public String print(@RequestParam String loanNoticeDocIds, String watermark) {
        return loanNoticeDocService.print(loanNoticeDocIds, watermark);
    }

    /**
     * 根据基础信息表id 查询所有 借贷文档信息
     *
     * @param loanNoticeId 催缴通知ID
     */
    @GetMapping(value = "/findByLoanNoticeId")
    public HttpResult findByLoanNoticeId(@RequestParam Long loanNoticeId) {
        return HttpResult.ok(loanNoticeDocService.queryByLoanNoticeId(loanNoticeId));
    }

    @GetMapping(value = "/born")
    public HttpResult born(@RequestParam Long loanNoticeId) {
        try {
            return HttpResult.ok(loanNoticeDocService.born(loanNoticeId));
        } catch (Exception e) {
            return HttpResult.ok(0);
        }
    }

}
