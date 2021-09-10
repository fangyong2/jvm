package com.labcloud.tdddemo.labTdd.dao.impl;

import com.labcloud.tdddemo.labTdd.dao.IConsumeDao;
import com.labcloud.tdddemo.labTdd.dao.IUserDao;
import com.labcloud.tdddemo.labTdd.entity.LabBuyGood;
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
public class ConsumeDao implements IConsumeDao {
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;
    public String space(){
        return StringUtilsEx.rightStr(this.getClass().getName(), ".");
    }

    @Autowired
    private IUserDao userDao;

    @Override
    public int buyGood(RestResult opResult, int id, int useMoney, String goodName) {
        LabBuyGood labBuyGood = new LabBuyGood();
        labBuyGood.setUserId(id);
        labBuyGood.setGoodName(goodName);
        labBuyGood.setUseMoney(useMoney);
        int update = sqlSessionTemplate.insert(space() + ".insertBuyGood", labBuyGood);
        update += userDao.userMoneyUpdate(opResult, id, -useMoney);
        return update;
    }
}
