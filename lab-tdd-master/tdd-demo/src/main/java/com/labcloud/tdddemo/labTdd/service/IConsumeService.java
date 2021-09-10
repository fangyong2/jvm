package com.labcloud.tdddemo.labTdd.service;

import com.labcloud.tdddemo.utils.RestResult;

/**
 * @Author 方勇
 * @create 2018-12-31 16:24
 */
public interface IConsumeService {

    /**
     * 购买商品
     * @param opResult
     * @param id
     * @param useMoney
     * @param goodName
     * @return
     */
    public int buyGood(RestResult opResult, int id, int useMoney, String goodName);
}
