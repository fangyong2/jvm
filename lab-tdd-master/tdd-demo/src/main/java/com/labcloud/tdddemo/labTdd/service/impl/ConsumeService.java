package com.labcloud.tdddemo.labTdd.service.impl;

import com.labcloud.tdddemo.labTdd.dao.IConsumeDao;
import com.labcloud.tdddemo.labTdd.dao.IUserDao;
import com.labcloud.tdddemo.labTdd.service.IConsumeService;
import com.labcloud.tdddemo.labTdd.service.IScoreService;
import com.labcloud.tdddemo.labTdd.entity.LabUser;
import com.labcloud.tdddemo.utils.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author 方勇
 * @create 2018-12-31 17:19
 */
@Service
public class ConsumeService implements IConsumeService {

    @Autowired
    private IConsumeDao consumeDao;
    @Autowired
    private IUserDao userDao;
    @Autowired
    private IScoreService scoreService;

    @Override
    public int buyGood(RestResult opResult, int id, int useMoney, String goodName) {
        int update = consumeDao.buyGood(opResult, id, useMoney, goodName);
        LabUser labUser = userDao.getUser(opResult, id);
        if (labUser == null){
            opResult.addError("未取得这个用户资料：id=" + id);
            return 0;
        }
        int score = scoreService.calcScore(labUser.getTotalUseMoney());
        scoreService.updateUserScore(opResult, id, score);
        return update;
    }
}
