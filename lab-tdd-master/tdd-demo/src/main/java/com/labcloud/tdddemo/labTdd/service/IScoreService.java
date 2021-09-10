package com.labcloud.tdddemo.labTdd.service;

import com.labcloud.tdddemo.utils.RestResult;

/**
 * @Author 方勇
 * @create 2018-12-31 22:07
 */
public interface IScoreService {
    /**
     * 更新用户积分
     * @param restResult
     * @param id
     * @param score
     * @return
     */
    public int updateUserScore(RestResult restResult, int id, int score);

    /**
     * 计算积分
     * @param totalUseMoney
     * @return
     */
    public int calcScore(int totalUseMoney);
}
