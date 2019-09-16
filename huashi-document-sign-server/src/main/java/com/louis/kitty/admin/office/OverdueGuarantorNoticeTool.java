package com.louis.kitty.admin.office;

import com.louis.kitty.admin.constants.DocConstants;
import com.louis.kitty.admin.dao.LoanNoticeDocMapper;
import com.louis.kitty.admin.model.*;
import com.louis.kitty.admin.util.RmbUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

@Component
public class OverdueGuarantorNoticeTool extends AbstractOfficeTool {

    @Resource
    private LoanNoticeDocMapper loanNoticeDocMapper;

    private void round(RelatedPersonnelInformation relatedPersonnelInformation, DocCommonModel docCommonModel) {
        Map<String, Object> variables = newRound();
        variables.put("name", relatedPersonnelInformation.getName());
        variables.put("applyPersonName", docCommonModel.getBorrower().getName());

        // 先留空
        variables.put("borrowingStartPeriod", "      年   月   日");
        variables.put("applyMoneyRMB", docCommonModel.getApplyMoneyRMB());
        variables.put("personalLoanContractNo", docCommonModel.getContractInformation().getPersonalLoanContractNo());
        variables.put("deadlineMonth", docCommonModel.getLoanBusinessInformation().getApplicationPeriod());

        SimpleDateFormat formater = new SimpleDateFormat("yyyy年MM月dd日");
        // 1.16. contract_information合同信息表  borrowing_end_period  借款截止期限
        variables.put("borrowingEndPeriod", formater.format(docCommonModel.getContractInformation().getBorrowingEndPeriod()));

        // 1.18. collection_notice贷款到期（逾期）催收通知书信息表  fill_date 填写日期
        CollectionNotice collectionNotice = docCommonModel.getCollectionNotice();
        if (collectionNotice == null) {
            variables.put("fillDate", "      年  月  日");
            // owe_principal
            variables.put("owePrincipalRMB", "        ");

            // owe_interest 利息
            variables.put("oweInterestRMB", "        ");

            variables.put("fillDateYear", "    ");
            variables.put("fillDateMonth", " ");
            variables.put("fillDateDay", "  ");
        } else {
            variables.put("fillDate", formater.format(collectionNotice.getFillDate()));
            // owe_principal
            variables.put("owePrincipalRMB",
                    RmbUtil.rmb(new BigDecimal(collectionNotice.getOwePrincipal())));

            // owe_interest 利息
            variables.put("oweInterestRMB",
                    RmbUtil.rmb(new BigDecimal(collectionNotice.getOweInterest())));

            Map<Integer, String> calendar = getCalendar(collectionNotice.getFillDate());

            variables.put("fillDateYear", calendar.get(Calendar.YEAR));
            variables.put("fillDateMonth", calendar.get(Calendar.MONTH));
            variables.put("fillDateDay", calendar.get(Calendar.DAY_OF_MONTH));
        }
    }

    @Override
    protected void fillVariable(DocCommonModel docCommonModel) {
        if (CollectionUtils.isNotEmpty(docCommonModel.getGuarantorList())) {
            for (RelatedPersonnelInformation relatedPersonnelInformation : docCommonModel.getGuarantorList()) {
                round(relatedPersonnelInformation, docCommonModel);
            }
        }

        if (CollectionUtils.isNotEmpty(docCommonModel.getMortgageGuarantorList())) {
            for (RelatedPersonnelInformation relatedPersonnelInformation : docCommonModel.getMortgageGuarantorList()) {
                round(relatedPersonnelInformation, docCommonModel);
            }
        }
    }

    @Override
    protected String modelFileName() {
        return "贷款到期（逾期）催收通知书（担保人）";
    }

    @Override
    protected int sort() {
        return 3_4_00;
    }

    @Override
    protected DocConstants.DocType docType() {
        return DocConstants.DocType.WORD;
    }

    @Override
    protected Long getObjectId(DocCommonModel docCommonModel) {
        return docCommonModel.getCollectionNotice().getId();
    }

    @Override
    protected boolean save(Long objectId, Long docSize, String targetDocFullName, String targetPdfFullName, int secondSort) {
        LoanNoticeDoc loanNoticeDoc = new LoanNoticeDoc();
        loanNoticeDoc.setLoanNoticeId(objectId);
        loanNoticeDoc.setDocName(modelFileName());
        loanNoticeDoc.setDocPath(targetDocFullName);
        loanNoticeDoc.setPdfPath(targetPdfFullName);
        loanNoticeDoc.setDocSize(docSize);
        loanNoticeDoc.setDownloadTimes(0);
        loanNoticeDoc.setPrintTimes(0);
        loanNoticeDoc.setSort(sort() + secondSort);
        loanNoticeDoc.setCreateTime(new Date());

        return loanNoticeDocMapper.add(loanNoticeDoc) > 0;
    }

    @Override
    protected DocConstants.DocCategory category() {
        return DocConstants.DocCategory.SIGNATURE_MARK;
    }
}
