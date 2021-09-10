package com.labcloud.tdddemo.labTdd.service.impl;

import com.labcloud.tdddemo.labTdd.dao.IRechargeDao;
import com.labcloud.tdddemo.labTdd.service.IRechargeService;
import com.labcloud.tdddemo.utils.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author 方勇
 * @create 2018-12-31 17:18
 */
@Service
public class RechargeService implements IRechargeService {

    @Autowired
    private IRechargeDao rechargeDao;

    @Override
    public int addMoney(RestResult opResult, int id, int addMoney) {
        return rechargeDao.addMoney(opResult, id, addMoney);
    }

}
