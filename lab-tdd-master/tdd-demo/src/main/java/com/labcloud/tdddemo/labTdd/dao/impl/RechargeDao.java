package com.labcloud.tdddemo.labTdd.dao.impl;

import com.labcloud.tdddemo.labTdd.dao.IRechargeDao;
import com.labcloud.tdddemo.labTdd.dao.IUserDao;
import com.labcloud.tdddemo.labTdd.entity.LabAddMoney;
import com.labcloud.tdddemo.utils.RestResult;
import com.labcloud.tdddemo.utils.StringUtilsEx;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Author 方勇
 * @create 2018-12-31 17:20
 */
@Repository
public class RechargeDao implements IRechargeDao {
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;
    public String space(){
        return StringUtilsEx.rightStr(this.getClass().getName(), ".");
    }

    @Autowired
    private IUserDao userDao;

    @Override
    public int addMoney(RestResult opResult, int id, int addMoney) {
        LabAddMoney labAddMoney = new LabAddMoney();
        labAddMoney.setUserId(id);
        labAddMoney.setAddMoney(addMoney);
        int update = sqlSessionTemplate.insert(space() + ".insertAddMoney", labAddMoney);
        update += userDao.userMoneyUpdate(opResult, id, addMoney);
        return update;
    }


}
