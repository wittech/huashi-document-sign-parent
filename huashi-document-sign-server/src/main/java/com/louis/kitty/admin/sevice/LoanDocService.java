package com.louis.kitty.admin.sevice;

import com.louis.kitty.admin.model.LoanDoc;
import com.louis.kitty.core.service.CurdService;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LoanDocService extends CurdService<LoanDoc> {

    /**
     * 生成文件（落地）
     *
     * @param loanBasisId 借贷基础ID
     * @return 返回生成文件数
     */
    int born(Long loanBasisId) throws Exception;

    /**
     * 下载基础文件ID
     *
     * @param loanDocIds 借贷文档IDS
     * @return 下载内容
     */
    ResponseEntity<InputStreamResource> download(String loanDocIds);

    /**
     * 打印
     *
     * @param loanDocIds 借贷文档IDS
     * @param watermark  水印文本信息
     * @return 打印PDF的URL信息
     */
    String print(String loanDocIds, String watermark);

    /**
     * 查询所有 借贷文档信息
     *
     * @param loanBasisId 借贷基础ID
     * @param category    类型集合
     * @return 借贷文档集合信息
     */
    List<LoanDoc> queryByLoanBasisId(Long loanBasisId, String category);

}
