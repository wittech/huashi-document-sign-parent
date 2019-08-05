package com.huashi.bank.test.excel;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelXorHtmlUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import com.louis.kitty.admin.util.RmbUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;


public class ExcelForMapTest {


    private static final String DIR = "/Users/tenx/Documents/test/model/excel";

    String sourceDoc;
    String targetDoc;

    private final Map<String, Object> variables = new HashMap<>();

    @Before
    public void init() {
        sourceDoc = "/test_excel.xlsx";
        targetDoc = "/test_excel_2.xlsx";
    }

    @Test
    public void testF() throws Exception {
        // 加载模板
        TemplateExportParams params = new TemplateExportParams(DIR + sourceDoc);


        Map<String, Object> map = new HashMap<>();
        map.put("contractNo", System.currentTimeMillis() + "");
        map.put("applyTime", "2019年6月14日");
        map.put("bankBranchName", "广西桂林漓江农村合作银行城北支行");
        map.put("bankPhone", "0773-2624239");
        map.put("applyPersonName", "罗永芳");
        map.put("applyPersonNo", "10226292846");
        map.put("applySubject", "个人经营性贷款");
        map.put("applyMoney", "2000000");
        map.put("moneyUsage", "流动资金");
        map.put("deadlineMonth", "36");
        map.put("deadlineYear", "叁年");
        map.put("applyRate", "7.6%");
        map.put("marginRate", "0%");
        map.put("guarantee", "抵押");
        map.put("isNewer", "是");
        map.put("originBalance", "0");
//        map.put("applyMoneyRMB", RmbUtil.rmbChange(map.get("applyMoney").toString()));


        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> tempMap;
        for (int i = 0; i < 3; i++) {
            tempMap = new HashMap<>();
            tempMap.put("no", i + 1);
            tempMap.put("name", "秀峰区中山中路38号智能办公大厦五层503号、504号办公用房" + i);
            tempMap.put("personName", "王" + i);
            tempMap.put("unit", "320.55㎡");
            tempMap.put("money", "3093300");
            list.add(tempMap);
        }
        map.put("personList", list);

        // 生成workbook 并导出
        Workbook workbook = ExcelExportUtil.exportExcel(params, map);

        FileOutputStream fos = new FileOutputStream(DIR + targetDoc);
        workbook.write(fos);
        fos.close();
    }


    /**
     * Map 测试
     */
    @Test
    public void test() {
        try {
            List<ExcelExportEntity> entity = new ArrayList<>();
            ExcelExportEntity excelentity = new ExcelExportEntity("姓名", "name");
            excelentity.setNeedMerge(true);
            entity.add(excelentity);
            entity.add(new ExcelExportEntity("性别", "sex"));
            excelentity = new ExcelExportEntity(null, "students");
            List<ExcelExportEntity> temp = new ArrayList<>();
            temp.add(new ExcelExportEntity("姓名", "name"));
            temp.add(new ExcelExportEntity("性别", "sex"));
            excelentity.setList(temp);
            entity.add(excelentity);

            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
            Map<String, Object> map;
            for (int i = 0; i < 10; i++) {
                map = new HashMap<>();
                map.put("name", "1" + i);
                map.put("sex", "2" + i);

                List<Map<String, Object>> tempList = new ArrayList<>();
                tempList.add(map);
                tempList.add(map);
                map.put("students", tempList);

                list.add(map);
            }

            Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("测试", "测试"), entity,
                list);
            FileOutputStream fos = new FileOutputStream("D:/excel/ExcelExportForMap.tt.xls");
            workbook.write(fos);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 合并同类项
     */
    @Test
    public void testMerge() {
        try {
            List<ExcelExportEntity> entity = new ArrayList<ExcelExportEntity>();
            ExcelExportEntity excelentity = new ExcelExportEntity("部门", "depart");
            excelentity.setMergeVertical(true);
            entity.add(excelentity);
            excelentity = new ExcelExportEntity("姓名", "name");
            excelentity.setMergeVertical(true);
            excelentity.setMergeRely(new int[]{0});
            entity.add(excelentity);
            excelentity = new ExcelExportEntity("电话", "phone");
            excelentity.setMergeVertical(true);
            excelentity.setMergeRely(new int[] { 1 });
            entity.add(excelentity);

            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
            Map<String, Object> map;
            for (int i = 0; i < 10; i++) {
                map = new HashMap<String, Object>();
                map.put("depart", "设计部");
                map.put("name", "小明" + i / 3);
                map.put("phone", "1311234567" + i / 2);
                list.add(map);
            }
            for (int i = 0; i < 10; i++) {
                map = new HashMap<String, Object>();
                map.put("depart", "开发部");
                map.put("name", "小蓝" + i / 3);
                map.put("phone", "1871234567" + i / 2);
                list.add(map);
            }

            Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("员工通讯录", "通讯录"),
                entity, list);
            FileOutputStream fos = new FileOutputStream("/Users/tenx/Documents/test/model/excel/testMerge.xls");
            workbook.write(fos);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testMany() {
        try {
            List<ExcelExportEntity> entity = new ArrayList<ExcelExportEntity>();
            for (int i = 0; i < 500; i++) {
                entity.add(new ExcelExportEntity("姓名" + i, "name" + i));
            }

            List<Map<String, String>> list = new ArrayList<Map<String, String>>();
            Map<String, String> map;
            for (int i = 0; i < 10; i++) {
                map = new HashMap<String, String>();
                for (int j = 0; j < 500; j++) {
                    map.put("name" + j, j + "_" + i);
                }
                list.add(map);
            }
            ExportParams params = new ExportParams("测试", "测试", ExcelType.XSSF);
            params.setFreezeCol(5);
            Workbook workbook = ExcelExportUtil.exportExcel(params, entity, list);
            FileOutputStream fos = new FileOutputStream("D:/excel/testMany.xlsx");
            workbook.write(fos);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
