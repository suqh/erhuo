package edu.xnxy.suqh.service;


import edu.xnxy.suqh.entity.UserInfo;

import java.util.Map;

/**
 * description:Service层用户信息接口
 *
 * @author suqh
 * Created by suqh on 2017/4/12.
 */
public interface IUserService {

    /**
     * 添加一个用户
     */
    public Map<String, Object> register(UserInfo userInfo) throws Exception;

    /**
     * 删除一个用户
     */
    public void delete(UserInfo userInfo) throws Exception;

    /**
     * 修改用户信息
     */
    public void update(UserInfo userInfo) throws Exception;

    /**
     * 查询用户信息
     */
    public UserInfo login(UserInfo userInfo) throws Exception;

    /*
    * 根据姓名查询用户
    * */
    public UserInfo queryUserByName(UserInfo userInfo) throws Exception;
}
