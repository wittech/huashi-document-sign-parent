package com.louis.kitty.admin.office;

import com.louis.kitty.admin.constants.BankConstants;
import com.louis.kitty.admin.constants.DocConstants;
import com.louis.kitty.admin.model.DocCommonModel;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;

@Component
public class BusinessCooperationAgreementTool extends AbstractOfficeTool {

    @Override
    protected void fillVariable(DocCommonModel docCommonModel) {
        Map<String, Object> variables = newRound();
        variables.put("bankBranchName", BankConstants.BANK_BRANCH_NAME);
        variables.put("applyFamilyPersonName", docCommonModel.getApplyFamilyName());
        variables.put("moneyUsage", docCommonModel.getLoanBusinessInformation().getDescription());
        variables.put("applyMoneyRMB", docCommonModel.getApplyMoneyRMB());

        Map<Integer, String> calendar;
        try {
            calendar = getCalendar(new SimpleDateFormat("yyyy-MM-dd").parse(docCommonModel.getLoanBusinessInformation().getDepositAccount()));
        } catch (ParseException e) {
            calendar = getCalendar(null);
        }

        if (docCommonModel.getLoanBusinessInformation().getWhetherExclusiveCreditClient() == 0) {
            // 1.11. loan_business_information贷款业务信息表  deposit_account  前在我行开立一般存款账户
            variables.put("depositAccountYear1", calendar.get(Calendar.YEAR));
            variables.put("depositAccountMonth1", calendar.get(Calendar.MONTH));
            variables.put("depositAccountDay1", calendar.get(Calendar.DAY_OF_MONTH));

            // whether_exclusive_credit_client  借款人是否为我行独家信贷客户 0否 1是, 是 则为基本， 否 为一般
            variables.put("whetherExclusiveCreditClient1", "'基本");
            variables.put("depositAccountYear2", "");
            variables.put("depositAccountMonth2", "");
            variables.put("depositAccountDay2", "'");
            variables.put("whetherExclusiveCreditClient2", "");
        } else {
            // 1.11. loan_business_information贷款业务信息表  deposit_account  前在我行开立一般存款账户
            variables.put("depositAccountYear1", "");
            variables.put("depositAccountMonth1", "");
            variables.put("depositAccountDay1", "");

            // whether_exclusive_credit_client  借款人是否为我行独家信贷客户 0否 1是, 是 则为基本， 否 为一般
            variables.put("whetherExclusiveCreditClient1", "");
            variables.put("depositAccountYear2", calendar.get(Calendar.YEAR));
            variables.put("depositAccountMonth2", calendar.get(Calendar.MONTH));
            variables.put("depositAccountDay2", calendar.get(Calendar.DAY_OF_MONTH));
            variables.put("whetherExclusiveCreditClient2", "一般");
        }
    }

    @Override
    protected String modelFileName() {
        return "业务合作协议书";
    }

    @Override
    protected int sort() {
        return 2_5_00;
    }

    @Override
    protected DocConstants.DocType docType() {
        return DocConstants.DocType.WORD;
    }
}
