package com.labcloud.tdddemo.labTdd.service.impl;

import com.labcloud.tdddemo.labTdd.dao.IScoreDao;
import com.labcloud.tdddemo.labTdd.service.IScoreService;
import com.labcloud.tdddemo.utils.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author 方勇
 * @create 2018-12-31 22:07
 */
@Service
public class ScoreService implements IScoreService {

    @Autowired
    private IScoreDao scoreDao;

    @Override
    public int updateUserScore(RestResult restResult, int id, int score) {
        return scoreDao.updateUserScore(restResult, id, score);
    }

    @Override
    public int calcScore(int totalUseMoney) {
        if (totalUseMoney <= 100){
            return totalUseMoney;
        }
        if (totalUseMoney <= 1000){
            return calcScore(100) + (totalUseMoney - 100) * 2;
        }
        return calcScore(1000) + (totalUseMoney - 1000) * 3;
    }
}
