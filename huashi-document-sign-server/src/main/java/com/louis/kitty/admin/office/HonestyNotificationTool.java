package com.louis.kitty.admin.office;

import com.louis.kitty.admin.constants.DocConstants;
import com.louis.kitty.admin.model.DocCommonModel;
import org.springframework.stereotype.Component;

@Component
public class HonestyNotificationTool extends AbstractOfficeTool {

    @Override
    protected void fillVariable(DocCommonModel docCommonModel) {
    }

    @Override
    protected String modelFileName() {
        return "廉洁办贷告知书";
    }

    @Override
    protected int sort() {
        return 1_4_00;
    }

    @Override
    protected DocConstants.DocType docType() {
        return DocConstants.DocType.WORD_07;
    }

    @Override
    protected boolean isOnlyCloneFile() {
        return true;
    }

    @Override
    protected DocConstants.DocCategory category() {
        return DocConstants.DocCategory.SIGNATURE_MARK;
    }
}
