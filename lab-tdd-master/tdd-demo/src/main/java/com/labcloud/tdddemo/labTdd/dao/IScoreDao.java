package com.labcloud.tdddemo.labTdd.dao;

import com.labcloud.tdddemo.utils.RestResult;

/**
 * @Author 方勇
 * @create 2018-12-31 22:04
 */
public interface IScoreDao {
    /**
     * 更新用户积分
     * @param restResult
     * @param userId
     * @param score
     * @return
     */
    public int updateUserScore(RestResult restResult, int userId, int score);
    public String space();
}
