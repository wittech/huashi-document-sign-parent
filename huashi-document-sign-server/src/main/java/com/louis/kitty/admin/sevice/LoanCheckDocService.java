package com.louis.kitty.admin.sevice;

import com.louis.kitty.admin.model.LoanCheckDoc;
import com.louis.kitty.core.service.CurdService;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * ---------------------------
 * (LoanCheckDocService)
 * ---------------------------
 * 作者：  lz
 * 时间：  2019-08-14 10:54:33
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface LoanCheckDocService extends CurdService<LoanCheckDoc> {

    /**
     * 生成文件（落地）
     *
     * @param loanCheckIds 借贷检查Ids
     * @return 返回生成文件数
     */
    int born(Long loanCheckIds) throws Exception;

    /**
     * 下载文件ID
     *
     * @param loanCheckIds 借贷检查Ids
     * @return 下载内容
     */
    ResponseEntity<InputStreamResource> download(String loanCheckIds);

    /**
     * 打印
     *
     * @param loanDocIds 借贷检查Ids
     * @return 打印PDF的URL信息
     */
    String print(String loanDocIds);

    /**
     * 查询所有 借贷文档信息
     *
     * @param loanCheckIds 借贷检查Ids
     * @return 借贷文档集合信息
     */
    List<LoanCheckDoc> queryByLoanCheckId(Long loanCheckIds);
}
