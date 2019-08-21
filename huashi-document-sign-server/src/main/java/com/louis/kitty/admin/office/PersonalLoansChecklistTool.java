package com.louis.kitty.admin.office;

import com.alibaba.druid.util.StringUtils;
import com.louis.kitty.admin.constants.DocConstants;
import com.louis.kitty.admin.dao.LoanCheckDocMapper;
import com.louis.kitty.admin.dao.PostLoanNotImplementedMapper;
import com.louis.kitty.admin.model.DocCommonModel;
import com.louis.kitty.admin.model.LoanCheckDoc;
import com.louis.kitty.admin.model.PostLoanCheck;
import com.louis.kitty.admin.model.PostLoanNotImplemented;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
public class PersonalLoansChecklistTool extends AbstractOfficeTool {

    @Resource
    private LoanCheckDocMapper loanCheckDocMapper;
    @Resource
    private PostLoanNotImplementedMapper postLoanNotImplementedMapper;

    private String setExistsOption(Integer exists) {
        String existsDes;
        if (exists == null) {
            existsDes = "有□无□";
        } else if (exists == 1) {
            existsDes = "有☑无□";
        } else {
            existsDes = "有□无☑";
        }

        return existsDes;
    }

    private String setRightOption(Integer right) {
        String rightDes;
        if (right == null) {
            rightDes = "是□否□";
        } else if (right == 1) {
            rightDes = "是☑否□";
        } else {
            rightDes = "是□否☑";
        }

        return rightDes;
    }

    private void setNoImplementedList(List<PostLoanNotImplemented> postLoanNotImplementedList, Map<String, Object> variables) {
        if(CollectionUtils.isEmpty(postLoanNotImplementedList)) {
            variables.put("noImplementedList", "");
            return;
        }

        StringBuilder data = new StringBuilder();
        int index = 0;
        for (PostLoanNotImplemented noImplemented : postLoanNotImplementedList) {
            index++;
            data.append("<w:p>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\" w:cs=\"宋体\"/>\n" +
                    "\t  <w:kern w:val=\"0\"/>\n" +
                    "\t  <w:sz w:val=\"20\"/>\n" +
                    "\t  <w:szCs w:val=\"20\"/>\n" +
                    "\t  <w:lang w:bidi=\"ar\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t>" + (index) + ".未落实</w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\" w:cs=\"宋体\"/>\n" +
                    "\t  <w:kern w:val=\"0\"/>\n" +
                    "\t  <w:sz w:val=\"20\"/>\n" +
                    "\t  <w:szCs w:val=\"20\"/>\n" +
                    "\t  <w:u w:val=\"single\"/>\n" +
                    "\t  <w:lang w:bidi=\"ar\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t xml:space=\"preserve\">"+(StringUtils.isEmpty(noImplemented.getItem()) ? "": noImplemented.getItem())+"</w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\" w:cs=\"宋体\"/>\n" +
                    "\t  <w:kern w:val=\"0\"/>\n" +
                    "\t  <w:sz w:val=\"20\"/>\n" +
                    "\t  <w:szCs w:val=\"20\"/>\n" +
                    "\t  <w:lang w:bidi=\"ar\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t xml:space=\"preserve\"> ，原因：</w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\" w:cs=\"宋体\"/>\n" +
                    "\t  <w:kern w:val=\"0\"/>\n" +
                    "\t  <w:sz w:val=\"20\"/>\n" +
                    "\t  <w:szCs w:val=\"20\"/>\n" +
                    "\t  <w:u w:val=\"single\"/>\n" +
                    "\t  <w:lang w:bidi=\"ar\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t xml:space=\"preserve\">"+(StringUtils.isEmpty(noImplemented.getReason()) ? "": noImplemented.getReason())+"</w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\" w:cs=\"宋体\"/>\n" +
                    "\t  <w:kern w:val=\"0\"/>\n" +
                    "\t  <w:sz w:val=\"20\"/>\n" +
                    "\t  <w:szCs w:val=\"20\"/>\n" +
                    "\t  <w:lang w:bidi=\"ar\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t xml:space=\"preserve\"> ，拟采取措施</w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\" w:cs=\"宋体\"/>\n" +
                    "\t  <w:kern w:val=\"0\"/>\n" +
                    "\t  <w:sz w:val=\"20\"/>\n" +
                    "\t  <w:szCs w:val=\"20\"/>\n" +
                    "\t  <w:u w:val=\"single\"/>\n" +
                    "\t  <w:lang w:bidi=\"ar\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t xml:space=\"preserve\">"+(StringUtils.isEmpty(noImplemented.getMeasures()) ? "": noImplemented.getMeasures())+"</w:t>\n" +
                    "  </w:r>\n" +
                    "  <w:r>\n" +
                    "\t<w:rPr>\n" +
                    "\t  <w:rFonts w:hint=\"eastAsia\" w:ascii=\"仿宋_GB2312\" w:hAnsi=\"宋体\" w:eastAsia=\"仿宋_GB2312\" w:cs=\"宋体\"/>\n" +
                    "\t  <w:kern w:val=\"0\"/>\n" +
                    "\t  <w:sz w:val=\"20\"/>\n" +
                    "\t  <w:szCs w:val=\"20\"/>\n" +
                    "\t  <w:lang w:bidi=\"ar\"/>\n" +
                    "\t</w:rPr>\n" +
                    "\t<w:t>；</w:t>\n" +
                    "  </w:r>\n" +
                    "</w:p>");
        }

        variables.put("noImplementedList", data.toString());
    }

    @Override
    protected void fillVariable(DocCommonModel docCommonModel) {
        Map<String, Object> variables = newRound();

        variables.put("applyPersonName", docCommonModel.getBorrower().getName());

        Map<Integer, String> calendar = getCalendar(docCommonModel.getContractInformation().getBorrowingStartPeriod());

        Map<Integer, String> calendar1 = getCalendar(docCommonModel.getContractInformation().getBorrowingEndPeriod());

        variables.put("borrowingStartPeriodYear", calendar.get(Calendar.YEAR));
        variables.put("borrowingStartPeriodMonth", calendar.get(Calendar.MONTH));
        variables.put("borrowingStartPeriodDay", calendar.get(Calendar.DAY_OF_MONTH));
        variables.put("borrowingEndPeriodYear", calendar1.get(Calendar.YEAR));
        variables.put("borrowingEndPeriodMonth", calendar1.get(Calendar.MONTH));
        variables.put("borrowingEndPeriodDay", calendar1.get(Calendar.DAY_OF_MONTH));

        // 1.1. loan_basis借口人基础信息表   application_matters
        variables.put("applicationMatters", docCommonModel.getLoanBasis().getApplicationMatters());
        variables.put("moneyUsage", docCommonModel.getLoanBusinessInformation().getDescription());

        variables.put("applyMoneyRMB", docCommonModel.getApplyMoneyRMB());

        // 抵押/质押/保证/信用
        variables.put("guaranteeMethodMark1", "");
        variables.put("guaranteeMethodMark2", "");
        variables.put("guaranteeMethodMark3", "");
        variables.put("guaranteeMethodMark4", "");
        if(docCommonModel.getLoanBasis().getGuaranteeMethod().contains("抵押")) {
            variables.put("guaranteeMethodMark1", "√");
        }
        if(docCommonModel.getLoanBasis().getGuaranteeMethod().contains("保证")) {
            variables.put("guaranteeMethodMark3", "√");
        }

        // 1.17. post_loan_check贷后检查信息表
        // check_time
        PostLoanCheck postLoanCheck = docCommonModel.getPostLoanCheck();
        if(postLoanCheck == null) {
            return;
        }

        Map<Integer, String> checkTime = getCalendar(postLoanCheck.getCheckTime());

        variables.put("checkTimeYear", checkTime.get(Calendar.YEAR));
        variables.put("checkTimeMonth", checkTime.get(Calendar.MONTH));
        variables.put("checkTimeDay", checkTime.get(Calendar.DAY_OF_MONTH));

        // 1.17. post_loan_check贷后检查信息表 是否，有无
        variables.put("paymentMethodWithdrawalCheck", setExistsOption(postLoanCheck.getPaymentMethodWithdrawal()));
        variables.put("contractualAgreementCheck", setExistsOption(postLoanCheck.getContractualAgreement()));
        variables.put("intendedUseCheck", setExistsOption(postLoanCheck.getIntendedUse()));

        variables.put("isComplete", setRightOption(postLoanCheck.getIsComplete()));
        variables.put("completeCheck", setRightOption(postLoanCheck.getComplete()));
        variables.put("hasImplementedCheck", setRightOption(postLoanCheck.getHasImplemented()));

        // post_loan_not_implemented
        List<PostLoanNotImplemented> postLoanNotImplementedList = postLoanNotImplementedMapper.findByCheckId(postLoanCheck.getId());

        setNoImplementedList(postLoanNotImplementedList, variables);
    }

    @Override
    protected String modelFileName() {
        return "个人贷款贷后检查表";
    }

    @Override
    protected int sort() {
        return 3_6_00;
    }

    @Override
    protected DocConstants.DocType docType() {
        return DocConstants.DocType.WORD;
    }

    @Override
    protected Long getObjectId(DocCommonModel docCommonModel) {
        return docCommonModel.getPostLoanCheck().getId();
    }

    @Override
    protected boolean save(Long objectId, Long docSize, String targetDocFullName, String targetPdfFullName, int secondSort) {
        LoanCheckDoc loanCheckDoc = new LoanCheckDoc();
        loanCheckDoc.setLoanCheckId(objectId);
        loanCheckDoc.setDocName(modelFileName());
        loanCheckDoc.setDocPath(targetDocFullName);
        loanCheckDoc.setPdfPath(targetPdfFullName);
        loanCheckDoc.setDocSize(docSize);
        loanCheckDoc.setDownloadTimes(0);
        loanCheckDoc.setPrintTimes(0);
        loanCheckDoc.setSort(sort() + secondSort);
        loanCheckDoc.setCreateTime(new Date());

        return loanCheckDocMapper.add(loanCheckDoc) > 0;
    }
}
