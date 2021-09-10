package com.labcloud.tdddemo.labTestNg.service;

import com.labcloud.tdddemo.labTdd.dao.IUserDao;
import com.labcloud.tdddemo.labTdd.entity.LabUser;
import com.labcloud.tdddemo.labTdd.service.impl.UserService;
import com.labcloud.tdddemo.utils.ReflectionTddUtils;
import com.labcloud.tdddemo.utils.RestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @Author fy
 * @create 2018-12-31 14:16
 */
public class UserServiceTestNg {

    private static UserService userService;
    private static RestResult opResult = RestResult.create();
    private static IUserDao userDao;

    @BeforeClass
    public static void beforeTest() throws NoSuchFieldException, IllegalAccessException {
        userDao = mock(IUserDao.class);
        userService = new UserService();
        ReflectionTddUtils.setFieldValue(userService, "userDao", userDao);
    }

    /**
     * 创建用户测试
     */
    @Test
    public void addUser(){
        LabUser labUser = new LabUser();
        labUser.setUsername("张三");
        labUser.setAge(12);
        when(userDao.addUser(opResult, labUser)).thenReturn(1);
        int update = userService.addUser(opResult, labUser);
        assertThat(update, equalTo(1));
    }

    /**
     * 查询用户测试
     */
    @Test
    public void getUser(){
        LabUser labUserReturn = new LabUser();
        labUserReturn.setId(1);
        when(userDao.getUser(opResult, 1)).thenReturn(labUserReturn);
        LabUser labUser = userService.getUser(opResult, 1);
        assertThat(labUser.getId(), equalTo(1));
    }
}
