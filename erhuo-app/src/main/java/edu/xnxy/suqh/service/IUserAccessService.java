package edu.xnxy.suqh.service;

import edu.xnxy.suqh.entity.UserAccess;

import java.util.List;

/**
 * Description: 用户访量统计业务
 *
 * Created by suqh on 17-5-6.
 */
public interface IUserAccessService {

    /**
     * Description:新增一条用户访问记录
     *
     * @param userAccess
     */
    public void insert(UserAccess userAccess) throws Exception;

    /**
     * Description:统计前15天的用户访问量
     */
    public List countUserAccess() throws Exception;

}
