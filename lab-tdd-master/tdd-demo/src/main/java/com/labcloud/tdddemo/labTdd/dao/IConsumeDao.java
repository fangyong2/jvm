package com.labcloud.tdddemo.labTdd.dao;

import com.labcloud.tdddemo.utils.RestResult;

/**
 * @Author 方勇
 * @create 2018-12-31 17:12
 */
public interface IConsumeDao {
    public int buyGood(RestResult opResult, int id, int useMoney, String goodName);
    public String space();
}
