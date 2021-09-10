package com.labcloud.tdddemo.labTestNg.service;

import com.labcloud.tdddemo.labTdd.dao.IRechargeDao;
import com.labcloud.tdddemo.labTdd.service.IRechargeService;
import com.labcloud.tdddemo.labTdd.service.impl.RechargeService;
import com.labcloud.tdddemo.utils.ReflectionTddUtils;
import com.labcloud.tdddemo.utils.RestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @Author fy
 * @create 2018-12-31 20:56
 */
public class RechargeServiceTestNg {

    private static IRechargeService rechargeService;
    private static IRechargeDao rechargeDao;
    private static RestResult opResult = RestResult.create();

    @BeforeClass
    public static void beforeTest() throws NoSuchFieldException, IllegalAccessException {
        rechargeDao = mock(IRechargeDao.class);
        rechargeService = new RechargeService();
        ReflectionTddUtils.setFieldValue(rechargeService, "rechargeDao", rechargeDao);
    }

    @Test
    public void addMoney(){
        when(rechargeDao.addMoney(opResult, 1, 1000)).thenReturn(1);
        int update = rechargeService.addMoney(opResult, 1, 1000);
        assertThat(update, equalTo(1));
    }

}
