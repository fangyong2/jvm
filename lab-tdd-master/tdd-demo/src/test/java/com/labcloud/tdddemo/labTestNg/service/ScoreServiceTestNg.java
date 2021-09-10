package com.labcloud.tdddemo.labTestNg.service;

import com.labcloud.tdddemo.labTdd.dao.IScoreDao;
import com.labcloud.tdddemo.labTdd.service.IScoreService;
import com.labcloud.tdddemo.labTdd.service.impl.ScoreService;
import com.labcloud.tdddemo.utils.ReflectionTddUtils;
import com.labcloud.tdddemo.utils.RestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @Author fy
 * @create 2018-12-31 22:30
 */
public class ScoreServiceTestNg {

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

    /*
    @Test
    public void calcScore() {
        //这种方法是不是很土，详见TestNg的参数化用法
        assertThat("积分计算错误", scoreService.calcScore(80), equalTo(80));
        assertThat("积分计算错误", scoreService.calcScore(980), equalTo(100 + (980 - 100) * 2));
        assertThat("积分计算错误", scoreService.calcScore(1980), equalTo(100 + 900 * 2 + 980 * 3));
    }
    */

    /**
     * TestNg的参数数据提供
     * @return
     */
    @DataProvider(name = "calcScoreParams")
    public Object[][] testParams(){
        return new Object[][]{
                {80, 80},
                {980, 100 + (980 - 100) * 2},
                {1980, 100 + 900 * 2 + 980 * 3}
        };
    }

    @Test(dataProvider = "calcScoreParams")
    public void calcScore(int totalUserMoney, int scoreResult) {
        System.out.println(String.format("测试用例：消费：%s >> 积分: %s", totalUserMoney, scoreResult));
        ScoreService scoreService = new ScoreService();
        assertThat("积分计算错误", scoreService.calcScore(totalUserMoney), equalTo(scoreResult));
    }
}
