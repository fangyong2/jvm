package com.labcloud.tdddemo.labTdd.controller;

import com.labcloud.tdddemo.labTdd.base.ControllerTestBase;
import com.labcloud.tdddemo.labTdd.entity.LabUser;
import com.labcloud.tdddemo.labTdd.service.IUserService;
import com.labcloud.tdddemo.utils.ConvertUtils;
import com.labcloud.tdddemo.utils.RestResult;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * @Author 方勇
 * @create 2018-12-31 14:07
 */
@Transactional
public class ConsumeControllerTest extends ControllerTestBase {

    @Autowired
    private IUserService userService;

    private String userId;

    @Override
    public void beforeTest() {
        //测试前环境准备
        userService.addUser(RestResult.create(), new LabUser(0, "张三"));
        List<LabUser> labUsers = userService.queryLabUsers(RestResult.create(), "");
        userId = ConvertUtils.cStr(labUsers.get(0).getId());
    }

    @Override
    public void afterTest() {
        //测试后恢复现场
    }

    /**
     * 消费测试
     * @throws Exception
     */
    @Test
    public void buyGood() throws Exception {
        post("/buyGood",
                new HashMap<String, String>(){{put("id", userId); put("useMoney", "1000"); put("goodName", "apple");}},
                new HashMap<String, Object>(){{put("$.success", true);}}
        );
    }
}
