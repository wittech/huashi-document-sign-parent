package com.huashi.bank.test.doc;

import cn.afterturn.easypoi.entity.ImageEntity;
import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelXorHtmlUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.afterturn.easypoi.word.WordExportUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.Before;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class WordImageTest {

    private static final String DIR = "/Users/tenx/Documents/test/model";

    String sourceDoc;
    String targetDoc;

    private final Map<String, Object> variables = new HashMap<>();

    @Before
    public void init() {
        sourceDoc = "/test_pic_model.docx";
        targetDoc = "/test_pic_model_5.docx";
    }


    private void export() throws Exception {
        XWPFDocument document = WordExportUtil.exportWord07(DIR + sourceDoc, variables);
        FileOutputStream fos = new FileOutputStream(DIR + targetDoc);
        document.write(fos);
        fos.close();

        document.close();
    }

    private ImageEntity getImage(String name) throws Exception {
        ImageEntity image = new ImageEntity();
//        image.setHeight(300);
//        image.setWidth(300);
        image.setUrl(DIR + "/pic/" + name);
        image.setType(ImageEntity.URL);
        return image;
    }

    private void setVariables() throws Exception {
        variables.put("name", "陆毅");
        variables.put("date", "2019-07-15");
        variables.put("phone", "0571-88787761");

        variables.put("image_a", getImage("101.png"));
        variables.put("image_b", getImage("102.png"));
        variables.put("image_c", getImage("103.png"));
        variables.put("image_d", getImage("104.png"));
        variables.put("image_23", getImage("105.png"));

    }

    @Test
    public void transform() throws Exception {
        setVariables();

        export();
    }


}
