package com.huashi.bank.test.service;

import com.louis.kitty.admin.KittyAdminApplication;
import com.louis.kitty.admin.sevice.PawnPersonnelMappingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {KittyAdminApplication.class})
public class MybatisNullTest {

    @Autowired
    private PawnPersonnelMappingService pawnPersonnelMappingService;

    @Test
    public void test() throws Exception{
        pawnPersonnelMappingService.findByRpiId(322L);
    }
}
