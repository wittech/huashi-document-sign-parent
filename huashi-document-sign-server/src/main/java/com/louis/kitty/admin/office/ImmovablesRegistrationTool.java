package com.louis.kitty.admin.office;

import com.louis.kitty.admin.constants.DocConstants;
import com.louis.kitty.admin.model.DocCommonModel;
import org.springframework.stereotype.Component;

@Component
public class ImmovablesRegistrationTool extends AbstractOfficeTool {

    @Override
    protected void fillVariable(DocCommonModel docCommonModel) {
    }

    @Override
    protected String modelFileName() {
        return "不动产登记申请表";
    }

    @Override
    protected int sort() {
        return 2_9_00;
    }

    @Override
    protected DocConstants.DocType docType() {
        return DocConstants.DocType.WORD;
    }

    @Override
    protected boolean isOnlyCloneFile() {
        return true;
    }

    @Override
    protected DocConstants.DocCategory category() {
        return DocConstants.DocCategory.FORM_APPROVE;
    }
}
