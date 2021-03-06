package com.labcloud.tdddemo.labTdd.dao.impl;

import com.labcloud.tdddemo.labTdd.dao.IUserDao;
import com.labcloud.tdddemo.labTdd.entity.LabUser;
import com.labcloud.tdddemo.utils.RestResult;
import com.labcloud.tdddemo.utils.StringUtilsEx;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author 方勇
 * @create 2018-12-31 17:19
 */
@Repository
public class UserDao implements IUserDao {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;
    @Override
    public String space(){
        return StringUtilsEx.rightStr(this.getClass().getName(), ".");
    }

    /**
     * 新增用户
     * @param opResult
     * @param labUser
     * @return
     */
    @Override
    public int addUser(RestResult opResult, LabUser labUser) {
        return sqlSessionTemplate.insert(space() + ".insertUser", labUser);
    }

    /**
     * 查询用户
     * @param opResult
     * @param id
     * @return
     */
    @Override
    public LabUser getUser(RestResult opResult, int id) {
        List<LabUser> rows = queryLabUsers(opResult, String.format(" and id = %s", id));
        return rows.size() > 0 ? rows.get(0) : null;
    }

    /**
     * 根据条件查询多个用户信息
     * @param condition
     * @return
     */
    public List<LabUser> queryLabUsers(RestResult restResult, String condition){
        Map<Object, Object> params = new HashMap<>();
        params.put("condition", condition);
        List<LabUser> rows = sqlSessionTemplate.selectList(space() + ".queryLabUsers", params);
        return rows;
    }

    /**
     * 用户余额变更
     * @param restResult
     * @param userId
     * @param money
     */
    public int userMoneyUpdate(RestResult restResult, int userId, int money){
        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        params.put("money", money);
        params.put("totalAddMoney", money > 0 ? money : 0);
        params.put("totalUseMoney", money < 0 ? money : 0);
        int update = sqlSessionTemplate.update(space() + ".updateUserMoney", params);
        if (update == 0){
            LabUser labUser = new LabUser();
            labUser.setId(userId);
            labUser.setTotalAddMoney(money > 0 ? money : 0);
            labUser.setTotalUseMoney(money < 0 ? money : 0);
            labUser.setScore(0);
            labUser.setRemainMoney(money);
            update = addUser(restResult, labUser);
        }
        return update;
    }
}
