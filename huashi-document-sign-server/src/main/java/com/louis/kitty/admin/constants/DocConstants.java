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
        WORD(".doc"), EXCEL(".xls"), WORD_07(".docx"), EXCEL_07(".xlsx");

        DocType(String suffixName) {
            this.suffixName = suffixName;
        }

        private String suffixName;

        public String getSuffixName() {
            return suffixName;
        }
    }
}
