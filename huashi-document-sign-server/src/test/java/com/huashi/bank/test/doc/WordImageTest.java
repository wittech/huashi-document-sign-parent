package com.huashi.bank.test.doc;

import cn.afterturn.easypoi.entity.ImageEntity;
import cn.afterturn.easypoi.word.WordExportUtil;
import com.alibaba.fastjson.JSON;
import com.louis.kitty.admin.util.ImageUtil;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.Before;
import org.junit.Test;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordImageTest {

    private static final String DIR = "/Users/tenx/git/huashi-document-sign-parent/model";
    private static final String TARGET_DIR = "/Users/tenx/Downloads";
    String sourceDoc;
    String targetDoc;

    private final List<Map<String, Object>> variablesList = new ArrayList<>();
    private final Map<String, Object> variables = new HashMap<>();

    @Before
    public void init() {
        sourceDoc = "/贷款合影.docx";
        targetDoc = "/贷款合影_20.docx";
    }


    private void export() throws Exception {
        XWPFDocument document = WordExportUtil.exportWord07(DIR + sourceDoc, variablesList);
        FileOutputStream fos = new FileOutputStream(TARGET_DIR + targetDoc);
        document.write(fos);
        fos.close();

        document.close();
    }

    private ImageEntity getImage(String name) throws Exception {
        ImageEntity image = new ImageEntity();

        ImageUtil.ImageSize imageSize = ImageUtil.getImageSize("/Users/tenx/Documents/zy/home/" + name);
        image.setHeight(imageSize.getHeight());
        image.setWidth(imageSize.getWidth());
        image.setUrl("/Users/tenx/Documents/zy/home/" + name);
        image.setType(ImageEntity.URL);
        return image;
    }

    private void setVariables() throws Exception {

        variables.put("signImage0", getImage("171525iip4jgmmw5qwylv5.png"));
        variables.put("signImage1", getImage("175240k7bfd3eqt331k773.jpg"));
        variables.put("signImage2", getImage("180037vdtq2zk11d39g1r3.jpg"));

        for(int i=0;i< 7;i++) {
            variables.put("signImage" +(i+3), " ");
        }

        variables.put("groupImage0", getImage("180038gw2yjyeygs5wwd2z.jpg"));
        variables.put("groupImage1", getImage("165444k0gtuvugm0awulwi.jpg"));
        variables.put("groupImage2", getImage("164541hecnmmlbwul8nmtz.jpg"));
        variables.put("groupImage3", getImage("164252haall7s1bax7zylg.jpg"));

        for(int i=0;i< 6;i++) {
            variables.put("groupImage" +(i+4), " ");
        }

        variablesList.add(variables);

        System.out.println(JSON.toJSONString(variablesList));
    }

    @Test
    public void transform() throws Exception {
        setVariables();

        export();
    }


}
