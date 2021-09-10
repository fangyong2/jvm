package com.labcloud.tdddemo.labTdd.dao.impl;

import com.labcloud.tdddemo.labTdd.dao.IScoreDao;
import com.labcloud.tdddemo.utils.RestResult;
import com.labcloud.tdddemo.utils.StringUtilsEx;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 方勇
 * @create 2018-12-31 22:04
 */
@Repository
public class ScoreDao implements IScoreDao {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;
    @Override
    public String space(){
        return StringUtilsEx.rightStr(this.getClass().getName(), ".");
    }

    @Override
    public int updateUserScore(RestResult restResult, int userId, int score) {
        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        params.put("score", score);
        return sqlSessionTemplate.update(space() + ".updateUserScore", params);
    }
}
