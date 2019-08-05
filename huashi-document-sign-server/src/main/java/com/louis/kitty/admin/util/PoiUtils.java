package com.louis.kitty.admin.util;

import cn.afterturn.easypoi.word.WordExportUtil;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

public class PoiUtils {

    private static final String DIR = "/Users/tenx/Documents/company/huashi/bank/doc/";

    private static void word(Map<String, Object> variables) throws Exception {
        XWPFDocument document = WordExportUtil.exportWord07(DIR + "test_doc.docx", variables);
        FileOutputStream fos = new FileOutputStream(DIR + "test_doc_target228.docx");
        document.write(fos);
        fos.close();

        document.close();
    }

    public static void main(String[] args) throws Exception {
        Map<String, Object> variables = new HashMap<>();
        variables.put("name", "张无忌");
        variables.put("moneyInPrice", "12340.00");
        variables.put("moneyInChiness", "壹万贰仟叁佰肆拾元");
        variables.put("address", "测试地址啊大大发的说法的发大水发的说法是打发斯蒂芬");
        variables.put("mobile", "333");


        word(variables);
    }

}
