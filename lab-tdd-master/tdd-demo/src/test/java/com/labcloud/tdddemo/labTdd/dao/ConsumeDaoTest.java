package com.labcloud.tdddemo.labTdd.dao;

import com.labcloud.tdddemo.labTdd.dao.impl.ConsumeDao;
import com.labcloud.tdddemo.labTdd.entity.LabBuyGood;
import com.labcloud.tdddemo.utils.ReflectionTddUtils;
import com.labcloud.tdddemo.utils.RestResult;
import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @Author 方勇
 * @create 2018-12-31 22:49
 */
public class ConsumeDaoTest {

    private static SqlSessionTemplate sqlSessionTemplate;
    private static IConsumeDao consumeDao;
    private static IUserDao userDao;
    private static RestResult restResult = RestResult.create();

    @BeforeClass
    public static void beforeClass() throws NoSuchFieldException, IllegalAccessException {
        sqlSessionTemplate = mock(SqlSessionTemplate.class);
        userDao = mock(IUserDao.class);
        consumeDao = new ConsumeDao();
        ReflectionTddUtils.setFieldValue(consumeDao, "sqlSessionTemplate", sqlSessionTemplate);
        ReflectionTddUtils.setFieldValue(consumeDao, "userDao", userDao);
    }

    @Test
    public void space(){
        assertThat(consumeDao.space(), Matchers.equalTo("ConsumeDao"));
    }

    @Test
    public void buyGood(){
        LabBuyGood labBuyGood = new LabBuyGood();
        labBuyGood.setUserId(1);
        labBuyGood.setUseMoney(1000);
        when(sqlSessionTemplate.insert(consumeDao.space() + ".insertBuyGood", labBuyGood)).thenReturn(1);
        when(userDao.userMoneyUpdate(restResult, 1, -1000)).thenReturn(1);
        int update = consumeDao.buyGood(restResult, 1, 1000, "apple");
        assertThat(update, equalTo(1));
    }

}
