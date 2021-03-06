package com.labcloud.tdddemo.labTdd.service;

import com.labcloud.tdddemo.labTdd.dao.IScoreDao;
import com.labcloud.tdddemo.labTdd.service.impl.ScoreService;
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
 * @create 2018-12-31 22:30
 */
public class ScoreServiceTest {

    private static IScoreService scoreService;
    private static IScoreDao scoreDao;
    private static RestResult restResult = RestResult.create();

    @BeforeClass
    public static void beforeClass() throws NoSuchFieldException, IllegalAccessException {
        scoreService = new ScoreService();
        scoreDao = mock(IScoreDao.class);
        ReflectionTddUtils.setFieldValue(scoreService, "scoreDao", scoreDao);
    }

    @Test
    public void updateUserScore() {
        when(scoreDao.updateUserScore(restResult, 1, 3000)).thenReturn(1);
        int update = scoreService.updateUserScore(restResult, 1, 3000);
        assertThat(update, equalTo(1));
    }

    @Test
    public void calcScore() {
        assertThat("积分计算错误", scoreService.calcScore(80), equalTo(80));
        assertThat("积分计算错误", scoreService.calcScore(980), equalTo(100 + (980 - 100) * 2));
        assertThat("积分计算错误", scoreService.calcScore(1980), equalTo(100 + 900 * 2 + 980 * 3));
    }
}
