package com.louis.kitty.admin.util;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelXorHtmlUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class WordUtils {


    private static final String DIR = "/Users/tenx/Documents/company/huashi/bank/doc/";

    public static void main(String[] args) throws IOException {
        // 加载模板
        TemplateExportParams params = new TemplateExportParams(DIR + "test_excel.xlsx");
        Map<String, Object> map = new HashMap<>();
        map.put("title", "希尔顿（五湖店）-201907工资统计");
        map.put("date", "2019-07-15");
        map.put("operator", "王富贵");
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> tempMap;
        for (int i = 0; i < 50; i++) {
            tempMap = new HashMap<>();
            tempMap.put("no", i + 1);
            tempMap.put("name", "张" + i);
            tempMap.put("gender", new Random().nextInt(2) == 0 ? "男" : "女");
            tempMap.put("age", new Random().nextInt(90) + 11);
            tempMap.put("moneyInPrice", new Random().nextInt(10000));
            tempMap.put("mobile", "1587898312" + new Random().nextInt(10));
            tempMap.put("address", "河北省秦皇岛市经济开发区阳光水岸8幢332拉来来你的大范围IM接xxwe嗷嗷的");
            list.add(tempMap);
        }
        map.put("list", list);


        // 生成workbook 并导出
        Workbook workbook = ExcelExportUtil.exportExcel(params, map);

        String html = ExcelXorHtmlUtil.toAllHtml(workbook);



        FileOutputStream fos = new FileOutputStream(DIR + "test_excel_target5.xlsx");
        workbook.write(fos);
        fos.close();
    }

}
