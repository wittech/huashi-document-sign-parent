package com.louis.kitty.admin.office;

import com.louis.kitty.admin.constants.DocConstants;
import com.louis.kitty.admin.model.DocCommonModel;
import org.springframework.stereotype.Component;

@Component
public class WithdrawalCertificateTool extends AbstractOfficeTool {

    @Override
    protected void fillVariable(DocCommonModel docCommonModel) {
    }

    @Override
    protected String modelFileName() {
        return "撤押证明";
    }

    @Override
    protected int sort() {
        return 2_8_00;
    }

    @Override
    protected DocConstants.DocType docType() {
        return DocConstants.DocType.WORD;
    }

    @Override
    protected boolean isOnlyCloneFile() {
        return true;
    }
}
