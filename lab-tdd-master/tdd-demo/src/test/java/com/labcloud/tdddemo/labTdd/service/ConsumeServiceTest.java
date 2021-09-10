package com.labcloud.tdddemo.labTdd.service;

import com.labcloud.tdddemo.labTdd.dao.IConsumeDao;
import com.labcloud.tdddemo.labTdd.dao.IUserDao;
import com.labcloud.tdddemo.labTdd.entity.LabUser;
import com.labcloud.tdddemo.labTdd.service.impl.ConsumeService;
import com.labcloud.tdddemo.utils.ReflectionTddUtils;
import com.labcloud.tdddemo.utils.RestResult;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @Author 方勇
 * @create 2018-12-31 21:03
 */
public class ConsumeServiceTest {

    private static IConsumeService consumeService;
    private static IConsumeDao consumeDao;
    private static IUserDao userDao;
    private static IScoreService scoreService;
    private static RestResult restResult = RestResult.create();

    @BeforeClass
    public static void beforeClass() throws NoSuchFieldException, IllegalAccessException {
        consumeService = new ConsumeService();
        consumeDao = mock(IConsumeDao.class);
        userDao = mock(IUserDao.class);
        scoreService = mock(IScoreService.class);
        ReflectionTddUtils.setFieldValue(consumeService, "consumeDao", consumeDao);
        ReflectionTddUtils.setFieldValue(consumeService, "userDao", userDao);
        ReflectionTddUtils.setFieldValue(consumeService, "scoreService", scoreService);
    }

    @Test
    public void test(){
        LabUser labUser = new LabUser();
        labUser.setId(1);
        labUser.setTotalUseMoney(3000);
        when(userDao.getUser(restResult, 1)).thenReturn(labUser);
        when(scoreService.calcScore(3000)).thenReturn(1);
        when(scoreService.updateUserScore(restResult, 1, scoreService.calcScore(3000))).thenReturn(1);
        when(consumeDao.buyGood(restResult, 1, 3000, "apple")).thenReturn(1);
        int update = consumeService.buyGood(restResult, 1, 3000, "apple");
        assertThat(update, equalTo(1));
    }


}
