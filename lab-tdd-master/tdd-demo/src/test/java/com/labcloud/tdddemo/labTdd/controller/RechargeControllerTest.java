package com.labcloud.tdddemo.labTdd.controller;

import com.labcloud.tdddemo.labTdd.base.ControllerTestBase;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

/**
 * @Author 方勇
 * @create 2018-12-31 14:07
 */
@Transactional
public class RechargeControllerTest extends ControllerTestBase {
    @Override
    public void beforeTest() {
        //测试前环境准备
        //初始化session等
    }

    @Override
    public void afterTest() {
        //测试后恢复现场
    }

    /**
     * 充值
     * @throws Exception
     */
    @Test
    public void addMoney() throws Exception {
        post("/addMoney",
                new HashMap<String, String>(){{put("id", "1"); put("addMoney", "1000");}},
                new HashMap<String, Object>(){{put("$.success", true);}}
        );
    }
}
