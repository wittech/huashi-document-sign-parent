package com.louis.kitty.admin.office;

import com.louis.kitty.admin.constants.DocConstants;
import org.springframework.stereotype.Component;

@Component
public class HonestyNotificationTool extends AbstractOfficeTool {

    @Override
    protected void fillVariable(Long basisLoanId) {
    }

    @Override
    protected String modelFileName() {
        return "廉洁办贷告知书";
    }

    @Override
    protected int sort() {
        return 1_3_0;
    }

    @Override
    protected DocConstants.DocType docType() {
        return DocConstants.DocType.WORD_07;
    }

    @Override
    protected boolean isOnlyCloneFile() {
        return true;
    }
}
