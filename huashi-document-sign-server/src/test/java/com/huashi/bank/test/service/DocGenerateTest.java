package com.huashi.bank.test.service;

import com.louis.kitty.admin.KittyAdminApplication;
import com.louis.kitty.admin.sevice.LoanDocService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {KittyAdminApplication.class})
public class DocGenerateTest {

    @Autowired
    private LoanDocService loanDocService;

    @Test
    public void test() throws Exception{
        loanDocService.born(104L);
    }

}
