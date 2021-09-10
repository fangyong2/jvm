package com.labcloud.tdddemo.labTdd.controller;

import com.labcloud.tdddemo.labTdd.service.IRechargeService;
import com.labcloud.tdddemo.utils.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author 方勇
 * @create 2018-12-31 13:33
 */
@RestController
public class RechargeController {

    @Autowired
    private IRechargeService rechargeService;

    @PostMapping("/addMoney")
    public Map<String, Object> addMoney(int id, int addMoney){
        RestResult restResult = RestResult.create();
        rechargeService.addMoney(restResult, id, addMoney);
        return restResult.outResult();
    }
}
