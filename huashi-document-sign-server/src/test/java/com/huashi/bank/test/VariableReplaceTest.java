package com.huashi.bank.test;

import org.junit.Before;
import org.junit.Test;

public class VariableReplaceTest {

    private String content;

    @Before
    public void init() {
        content = "测试理解啊啊大姐姐{{是啥尅}}, {{33*}}时刻刻IE{{name}}三色{{pass}}写成";
    }

    @Test
    public void test() {
        // modify 变量内容 增加不可见字符
        content = content.replaceAll("\\{\\{[a-z]*[0-9]*[A-Z]*}}", "");
        // 去掉末尾可以增加空格等不可见字符，以免提供商模板不通过
        // return prefix+oriStr+"\\s*$";
        System.out.println(content);

    }
}
