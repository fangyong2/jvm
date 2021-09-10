package com.labcloud.tdddemo.labTestNg.controller;

import com.labcloud.tdddemo.labTestNg.base.ControllerTestNgBase;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * @Author fy
 * @create 2018-12-31 14:07
 */
@Transactional
public class RechargeControllerTestNg extends ControllerTestNgBase {
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
