package com.louis.kitty.admin.constants;

public class LoanConstants {

    /**
     * 担保方式
     */
    public enum GuaranteeMethod {
        GUARANTEE("保证"), MORTGAGE("抵押"), PLEDGE("质押");

        GuaranteeMethod(String title) {
            this.title = title;
        }

        private String title;

        public String getTitle() {
            return title;
        }
    }

    /**
     * 借贷方式
     */
    public enum LoanType {
        NEW(0, "0新增"), RENEWAL(1, "续贷");

        LoanType(int code, String title) {
            this.code = code;
            this.title = title;
        }

        private int code;
        private String title;

        public int getCode() {
            return code;
        }

        public String getTitle() {
            return title;
        }
    }

    /**
     * 申请事项：0 个人经营性贷款 1信用贷款 2 房屋按揭贷款 3个人消费类贷款
     */
    public enum ApplicationMatters {
        PERSONAL_BUSINESS(0, "个人经营性贷款"), CREDIT(1, "信用贷款"), HOUSING_MORTGAGE(2, "个人消费类贷款"),
        PERSONAL_CONSUMPTION(3, "个人消费类贷款");

        ApplicationMatters(int code, String title) {
            this.code = code;
            this.title = title;
        }

        private int code;
        private String title;

        public int getCode() {
            return code;
        }

        public String getTitle() {
            return title;
        }
    }

    /**
     * 类型（1、结款人）（2、配偶）（3、抵押担保人）（3、抵押担保人） （4、保证担保人）（5、抵押担保人和保证担保人）
     */
    public enum PersonnelType {
        BORROWER(1, "借款人本人"), BORROWER_COUPLE(2, "借款人配偶"), MORTGAGE_GUARANTOR(3, "抵押担保人"),
        GUARANTOR(4, "保证担保人"), GUARANTOR_BOTH(5, "保证担保人、抵押担保人");

        PersonnelType(int code, String title) {
            this.code = code;
            this.title = title;
        }

        public static String getTitle(int code) {
            for(PersonnelType pt : PersonnelType.values()) {
                if(pt.getCode() == pt.getCode()) {
                    return pt.getTitle();
                }
            }

            return BORROWER.getTitle();
        }

        private int code;
        private String title;

        public int getCode() {
            return code;
        }

        public String getTitle() {
            return title;
        }
    }

}
