package com.louis.kitty.admin.sevice;

import com.louis.kitty.admin.model.DocProduct;
import com.louis.kitty.admin.model.LoanDoc;
import com.louis.kitty.core.service.CurdService;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LoanDocService extends CurdService<LoanDoc> {

    /**
     * 下载基础文件ID
     *
     * @param loanDocId 借贷文档ID
     * @return 下载内容
     */
    ResponseEntity<InputStreamResource> download(Long loanDocId);

    /**
     * 根据借贷基础ID批量下载文件
     *
     * @param loanBasisId 借贷基础ID
     * @return 批量文件
     */
    ResponseEntity<InputStreamResource> downloadAllDoc(Long loanBasisId);

    /**
     * 查询所有 借贷文档信息
     *
     * @param loanBasisId 借贷基础ID
     * @return 借贷文档集合信息
     */
    List<LoanDoc> queryByLoanBasisId(Long loanBasisId);

    /**
     * 下载次数+1
     * @param loanDocId 文档ID
     * @return 处理结果
     */
    boolean addOneIfDownload(Long loanDocId);

    /**
     * 打印次数+1
     * @param loanDocId 文档ID
     * @return 处理结果
     */
    boolean addOneIfPrint(Long loanDocId);

}
