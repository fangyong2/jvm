package com.labcloud.tdddemo.labTdd.controller;


import com.labcloud.tdddemo.labTdd.base.ControllerTestBase;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

/**
 * @Author 方勇
 * @create 2018-12-30 18:03
 */
@Transactional
public class UserControllerTest extends ControllerTestBase {

    @Override
    public void beforeTest() {
        //测试前环境准备
        //初始化session等
    }

    @Override
    public void afterTest() {
        //测试后恢复现场
    }

    @Test
    public void addUser() throws Exception {
        post("/user",
                new HashMap<String, String>(){{put("username", "张三"); put("password", "123");}},
                new HashMap<String, Object>(){{put("$.success", true);}}
        );
    }

    @Test
    public void getUser() throws Exception {
        get("/getUser",
                new HashMap<String, String>(){{put("id", "1");}},
                new HashMap<String, Object>(){{put("$.success", true);}}
        );
    }
}
