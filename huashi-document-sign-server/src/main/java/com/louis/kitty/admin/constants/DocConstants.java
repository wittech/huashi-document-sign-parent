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

    /**
     * 文档归属类型
     */
    public enum DocCategory {
        SIGNATURE_MARK(1, "客户签字材料"), FORM_APPROVE(2, "内部审批材料"), CONTRACT(3, "合同");

        DocCategory(int value, String title) {
            this.value = value;
            this.title = title;
        }

        private int value;
        private String title;

        public int getValue() {
            return value;
        }

        public String getTitle() {
            return title;
        }
    }
}
