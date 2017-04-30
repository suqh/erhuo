package edu.xnxy.suqh.dao;

import edu.xnxy.suqh.entity.UserInfo;

/**
 * description:Dao层用户信息接口
 *
 * @author suqh
 * Created by suqh on 2017/4/10.
 */
public interface IUserDao extends BaseDao<UserInfo> {

    /**
     * 根据用户id查询用户信息
     */
    public UserInfo queryUserInfoById(Integer userId);

}
