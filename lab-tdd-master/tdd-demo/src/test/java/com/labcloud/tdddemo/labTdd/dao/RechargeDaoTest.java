package com.labcloud.tdddemo.labTdd.dao;

import com.labcloud.tdddemo.labTdd.dao.impl.RechargeDao;
import com.labcloud.tdddemo.labTdd.entity.LabAddMoney;
import com.labcloud.tdddemo.utils.ReflectionTddUtils;
import com.labcloud.tdddemo.utils.RestResult;
import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @Author 方勇
 * @create 2018-12-31 22:54
 */
public class RechargeDaoTest {

    private static IRechargeDao rechargeDao;
    private static SqlSessionTemplate sqlSessionTemplate;
    private static IUserDao userDao;
    private static RestResult restResult = RestResult.create();

    @BeforeClass
    public static void beforeClass() throws NoSuchFieldException, IllegalAccessException {
        sqlSessionTemplate = mock(SqlSessionTemplate.class);
        rechargeDao = new RechargeDao();
        userDao = mock(IUserDao.class);
        ReflectionTddUtils.setFieldValue(rechargeDao, "sqlSessionTemplate", sqlSessionTemplate);
        ReflectionTddUtils.setFieldValue(rechargeDao, "userDao", userDao);
    }

    @Test
    public void space(){
        assertThat(rechargeDao.space(), Matchers.equalTo("RechargeDao"));
    }

    @Test
    public void addMoney(){
        LabAddMoney labAddMoney = new LabAddMoney();
        labAddMoney.setUserId(1);
        labAddMoney.setAddMoney(1000);
        when(sqlSessionTemplate.insert(rechargeDao.space() + ".insertAddMoney", labAddMoney)).thenReturn(1);
        when(userDao.userMoneyUpdate(restResult, 1, 1000)).thenReturn(1);
        int update = rechargeDao.addMoney(restResult, 1, 1000);
        assertThat(update, equalTo(1));
    }


}
