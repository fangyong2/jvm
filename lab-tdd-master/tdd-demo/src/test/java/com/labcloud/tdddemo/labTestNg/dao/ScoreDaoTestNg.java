package com.labcloud.tdddemo.labTestNg.dao;

import com.labcloud.tdddemo.labTdd.dao.IScoreDao;
import com.labcloud.tdddemo.labTdd.dao.impl.ScoreDao;
import com.labcloud.tdddemo.utils.ReflectionTddUtils;
import com.labcloud.tdddemo.utils.RestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @Author fy
 * @create 2018-12-31 22:57
 */
public class ScoreDaoTestNg {
    private static SqlSessionTemplate sqlSessionTemplate;
    private static IScoreDao scoreDao;
    private static RestResult restResult = RestResult.create();

    @BeforeClass
    public static void beforeClass() throws NoSuchFieldException, IllegalAccessException {
        sqlSessionTemplate = mock(SqlSessionTemplate.class);
        scoreDao = new ScoreDao();
        ReflectionTddUtils.setFieldValue(scoreDao, "sqlSessionTemplate", sqlSessionTemplate);
    }
    @Test
    public void space(){
        assertThat(scoreDao.space(), equalTo("ScoreDao"));
    }

    @Test
    public void updateUserScore(){
        Map<String, Object> params = new HashMap<>();
        params.put("userId", 1);
        params.put("score", 1000);
        when(sqlSessionTemplate.update(scoreDao.space() + ".updateUserScore", params)).thenReturn(1);
        int update = scoreDao.updateUserScore(restResult, 1, 1000);
        assertThat(update, equalTo(1));
    }
}
