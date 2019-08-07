package com.louis.kitty.admin.sevice.impl;

import com.louis.kitty.admin.dao.LoanDocMapper;
import com.louis.kitty.admin.model.LoanDoc;
import com.louis.kitty.admin.sevice.LoanDocService;
import com.louis.kitty.admin.util.FileDownloadUtil;
import com.louis.kitty.core.page.ColumnFilter;
import com.louis.kitty.core.page.MybatisPageHelper;
import com.louis.kitty.core.page.PageRequest;
import com.louis.kitty.core.page.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class LoanDocServiceImpl implements LoanDocService {

    @Resource
    private LoanDocMapper loanDocMapper;

    @Override
    public ResponseEntity<InputStreamResource> download(Long loanDocId) {
        LoanDoc loanDoc = findById(loanDocId);
        if (loanDoc == null) {
            log.error("loanDocId[{}] can not find any data", loanDocId);
            return null;
        }

        ResponseEntity<InputStreamResource> response = FileDownloadUtil.download(loanDoc.getDocPath(), loanDoc.getDocName());
        if (response == null) {
            log.warn("loanDocId[{}] download resource is null");
        } else {
            addOneIfDownload(loanDocId);
        }

        return response;
    }

    @Override
    public ResponseEntity<InputStreamResource> downloadAllDoc(Long loaBasisId) {
        return null;
    }

    @Override
    public List<LoanDoc> queryByLoanBasisId(Long loanBasisId) {
        return loanDocMapper.findByLoanBasisId(loanBasisId);
    }

    @Override
    public boolean addOneIfDownload(Long loanDocId) {
        return loanDocMapper.addOneIfDownload(loanDocId) > 0;
    }

    @Override
    public boolean addOneIfPrint(Long loanDocId) {
        return loanDocMapper.addOneIfPrint(loanDocId) > 0;
    }

    @Override
    public int save(LoanDoc record) {
        if (record.getId() == null || record.getId() == 0) {
            return loanDocMapper.add(record);
        }

        return loanDocMapper.update(record);
    }

    @Override
    public int delete(LoanDoc record) {
        return loanDocMapper.delete(record.getId());
    }

    @Override
    public int delete(List<LoanDoc> records) {
        for (LoanDoc record : records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public LoanDoc findById(Long id) {
        return loanDocMapper.findById(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        ColumnFilter columnFilter = pageRequest.getColumnFilter("name");
        if (columnFilter != null) {
            return MybatisPageHelper.findPage(pageRequest, loanDocMapper, "findPageByName", columnFilter.getValue());
        }
        return MybatisPageHelper.findPage(pageRequest, loanDocMapper);
    }
}
