package com.labcloud.tdddemo.labTdd.controller;

import com.labcloud.tdddemo.labTdd.entity.LabUser;
import com.labcloud.tdddemo.labTdd.service.IUserService;
import com.labcloud.tdddemo.utils.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Author 方勇
 * @create 2018-12-30 19:07
 */
@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/user")
    public Map<String, Object> addUser(LabUser labUser){
        RestResult restResult = RestResult.create();
        userService.addUser(restResult, labUser);
        return restResult.outResult();
    }

    @GetMapping("/getUser")
    public Map<String, Object> getUser(int id){
        RestResult restResult = RestResult.create();
        LabUser labUser = userService.getUser(restResult, id);
        restResult.setSuccess();
        restResult.addData("labUser", labUser);
        return restResult.outResult();
    }

    @GetMapping("/queryLabUsers")
    public Map<String, Object> queryLabUsers(String condition){
        RestResult restResult = RestResult.create();
        List<LabUser> rows = userService.queryLabUsers(restResult, condition);
        restResult.setSuccess();
        restResult.addData("rows", rows);
        return restResult.outResult();
    }
}
