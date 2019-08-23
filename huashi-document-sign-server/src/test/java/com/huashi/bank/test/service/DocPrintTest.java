package com.huashi.bank.test.service;

import com.louis.kitty.admin.KittyAdminApplication;
import com.louis.kitty.admin.sevice.LoanDocService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {KittyAdminApplication.class})
public class DocPrintTest {

    @Autowired
    private LoanDocService loanDocService;

    private String loadDocIds;

    @Before
    public void init() {
        loadDocIds = "193,196";
    }

    @Test
    public void test() throws Exception{
        loanDocService.print(loadDocIds, "");
    }

}
