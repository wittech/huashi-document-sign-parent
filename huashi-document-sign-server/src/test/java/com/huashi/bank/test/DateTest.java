package com.huashi.bank.test;

import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

    private String dateStr;
    private Date date;

    @Before
    public void init() throws ParseException {
        dateStr = "2024-12-31 10:00:00";

        date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateStr);
    }

    @Test
    public void test() {
        // 转换年月日
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);

        System.out.println("yyyy---" + ca.get(Calendar.YEAR));
        System.out.println("MM---" + ca.get(Calendar.MONTH) + 1);
        System.out.println("dd---" + ca.get(Calendar.DAY_OF_MONTH));
    }

}
