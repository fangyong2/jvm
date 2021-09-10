package com.labcloud.tdddemo.labTdd.service;

import com.labcloud.tdddemo.utils.RestResult;

/**
 * @Author 方勇
 * @create 2018-12-31 16:24
 */
public interface IRechargeService {

    /**
     * 充值
     * @param opResult
     * @param id
     * @param addMoney
     * @return
     */
    public int addMoney(RestResult opResult, int id, int addMoney);
}
