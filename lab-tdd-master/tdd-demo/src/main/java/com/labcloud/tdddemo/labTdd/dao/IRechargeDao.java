package com.labcloud.tdddemo.labTdd.dao;

import com.labcloud.tdddemo.utils.RestResult;

/**
 * @Author 方勇
 * @create 2018-12-31 17:12
 */
public interface IRechargeDao {
    public int addMoney(RestResult opResult, int id, int addMoney);
    public String space();
}
