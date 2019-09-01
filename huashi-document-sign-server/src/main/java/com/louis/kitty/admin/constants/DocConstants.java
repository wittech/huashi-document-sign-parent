package com.louis.kitty.admin.constants;

public class DocConstants {

    /**
     * 模板文件扩展名
     */
    public static final String MODEL_SUFFIX_NAME = ".xml";

    /**
     * 最终生成的文件扩展名
     */
    public enum DocType {
        WORD(".doc"), EXCEL(".xls"), WORD_07(".docx"), EXCEL_07(".xlsx"),
        PDF(".pdf"), ZIP(".zip");

        DocType(String suffixName) {
            this.suffixName = suffixName;
        }

        private String suffixName;

        public String getSuffixName() {
            return suffixName;
        }
    }

    /**
     * 图片文件资源类型
     */
    public enum DocMetaType {
        GROUP_IMAGE("1"), SIGN_IMAGE("2");

        DocMetaType(String type) {
            this.type = type;
        }

        private String type;

        public String getType() {
            return type;
        }
    }
}
