package com.louis.kitty.admin.sevice;

import com.louis.kitty.admin.model.LoanCheckDoc;
import com.louis.kitty.admin.model.LoanDoc;
import com.louis.kitty.admin.model.LoanNoticeDoc;
import com.louis.kitty.core.service.CurdService;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * ---------------------------
 *  (LoanNoticeDocService)         
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-14 10:54:33
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface LoanNoticeDocService extends CurdService<LoanNoticeDoc> {

    /**
     * 生成文件（落地）
     *
     * @param loanNoticeIds 催缴通知ID
     * @return 返回生成文件数
     */
    int born(Long loanNoticeIds) throws Exception;

    /**
     * 下载文件ID
     *
     * @param loanNoticeIds 催缴通知ID
     * @return 下载内容
     */
    ResponseEntity<InputStreamResource> download(String loanNoticeIds);

    /**
     * 打印
     *
     * @param loanDocIds 催缴通知ID
     * @return 打印PDF的URL信息
     */
    String print(String loanDocIds);

    /**
     * 查询所有 借贷文档信息
     *
     * @param loanNoticeIds 催缴通知ID
     * @return 借贷文档集合信息
     */
    List<LoanNoticeDoc> queryByLoanNoticeId(Long loanNoticeIds);
}
