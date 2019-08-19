package com.huashi.bank.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListMapTest {

    List<Map<String, Object>> list = new CopyOnWriteArrayList<>();

    private Map<String, Object> newRound() {
        Map<String, Object> variables = new HashMap<>();
        list.add(variables);
        return variables;
    }


    @Test
    public void test() {
        Map<String, Object> variables = newRound();
        variables.put("name", "张安");
        variables.put("age", "23");
        variables.put("id", "1");

        Map<String, Object> variables1 = newRound();
        variables1.put("name", "332");
        variables1.put("age", "231");
        variables1.put("id", "2");

        Map<String, Object> variables2 = newRound();
        variables2.put("name", "oip");
        variables2.put("age", "444");
        variables2.put("id", "3");


        for(Map<String, Object> var : list) {
            System.out.println(var.get("name") + "----------" + var.get("age") + "-----------" + var.get("id"));
        }

    }

}
