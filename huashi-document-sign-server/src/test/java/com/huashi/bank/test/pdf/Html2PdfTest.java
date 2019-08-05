package com.huashi.bank.test.pdf;

import org.bouncycastle.util.encoders.Base64;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Html2PdfTest {

    private static final String DIR = "/Users/tenx/Documents/test/model";

    String sourceDoc;
    String targetDoc;

    private final Map<String, Object> variables = new HashMap<>();

    @Before
    public void init() {
        sourceDoc = "/test_pic.docx";
        targetDoc = "/test_pic_1.docx";
    }

    private String getImage(String name) throws Exception{
        return Base64.toBase64String(Files.readAllBytes(Paths.get(DIR + "/pic" + name )));
    }

    private void setVariables() throws Exception {
        variables.put("name", "陆毅");
        variables.put("date", "2019-07-15");
        variables.put("phone", "0571-88787761");

        List<String> list1 = new ArrayList<>();
        list1.add(getImage("101.png"));
        list1.add(getImage("102.png"));

        variables.put("list1", list1);

        List<String> list2 = new ArrayList<>();
        list2.add(getImage("103.png"));
        list2.add(getImage("104.png"));
        list2.add(getImage("105.png"));

        variables.put("list2", list2);
    }

    @Test
    public void test() throws  Exception{
        byte[] pdf = PdfGeneratorUtil.moduleToPdf(variables, DIR + sourceDoc);



        Assert.assertTrue("数据为空", pdf != null && pdf.length > 0);

        Files.write(Paths.get(DIR + targetDoc), pdf);
    }


}
