package com.labcloud.tdddemo.labTdd.service.impl;

import com.labcloud.tdddemo.labTdd.dao.IUserDao;
import com.labcloud.tdddemo.labTdd.entity.LabUser;
import com.labcloud.tdddemo.labTdd.service.IUserService;
import com.labcloud.tdddemo.utils.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 方勇
 * @create 2018-12-31 13:58
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public int addUser(RestResult opResult, LabUser labUser) {
        int update = userDao.addUser(opResult, labUser);
        if (update == 0){
            opResult.addError("新增用户失败!");
        }
        return update;
    }

    @Override
    public LabUser getUser(RestResult opResult, int id) {
        LabUser labUser = userDao.getUser(opResult, id);
        if (labUser == null){
            opResult.addError("未取得这个用户资料：id=" + id);
        }
        return labUser;
    }

    @Override
    public List<LabUser> queryLabUsers(RestResult restResult, String condition){
        return userDao.queryLabUsers(restResult, condition);
    }
}
