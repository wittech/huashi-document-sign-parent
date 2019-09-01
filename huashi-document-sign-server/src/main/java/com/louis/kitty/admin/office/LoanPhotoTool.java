package com.louis.kitty.admin.office;

import com.louis.kitty.admin.constants.DocConstants;
import com.louis.kitty.admin.dao.DocMetaMapper;
import com.louis.kitty.admin.model.DocCommonModel;
import com.louis.kitty.admin.model.DocMeta;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Component
public class LoanPhotoTool extends AbstractOfficeTool {

    @Resource
    private DocMetaMapper docMetaMapper;

    /**
     * 目前文档中预留 签字图片和合影图片各10张
     */
    private static final int TOTAL_IMAGE_SIZE = 10;

    /**
     * 签名图片变量前缀
     */
    private static final String SIGN_IMAGE_VARIABLE_PREFIX = "signImage";

    /**
     * 合影图片变量前缀
     */
    private static final String GROUP_IMAGE_VARIABLE_PREFIX = "groupImage";

    private void mock(Map<String, Object> variables, String variablePrefix, int hasSize) {
        for (int i = hasSize; i < TOTAL_IMAGE_SIZE; i++) {
            variables.put(variablePrefix + i, " ");
        }
    }

    @Override
    protected void fillVariable(DocCommonModel docCommonModel) {
        int groupImageSize = 0;
        int signImageSize = 0;

        Map<String, Object> variables = newRound();

        List<DocMeta> list = docMetaMapper.findByBasisId(docCommonModel.getLoanBasicId());
        if (CollectionUtils.isEmpty(list)) {
            mock(variables, GROUP_IMAGE_VARIABLE_PREFIX, groupImageSize);
            mock(variables, SIGN_IMAGE_VARIABLE_PREFIX, signImageSize);
            return;
        }

        for (DocMeta docMeta : list) {
            if (docMeta == null) {
                continue;
            }

            if (DocConstants.DocMetaType.GROUP_IMAGE.getType().equals(docMeta.getType())) {
                variables.put(GROUP_IMAGE_VARIABLE_PREFIX + groupImageSize, getWordImage(docMeta.getPath()));
                groupImageSize++;
            }else if (DocConstants.DocMetaType.SIGN_IMAGE.getType().equals(docMeta.getType())) {
                variables.put(SIGN_IMAGE_VARIABLE_PREFIX + signImageSize, getWordImage(docMeta.getPath()));
                signImageSize++;
            }
        }

        mock(variables, GROUP_IMAGE_VARIABLE_PREFIX, groupImageSize);
        mock(variables, SIGN_IMAGE_VARIABLE_PREFIX, signImageSize);
    }

    @Override
    protected String modelFileName() {
        return "贷款合影";
    }

    @Override
    protected int sort() {
        return 3_8_01;
    }

    @Override
    protected DocConstants.DocType docType() {
        return DocConstants.DocType.WORD_07;
    }

    @Override
    protected boolean isExportFile() {
        return true;
    }
}
