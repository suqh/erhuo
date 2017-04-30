package edu.xnxy.suqh.dao;

import edu.xnxy.suqh.entity.OrderInfo;

import java.util.List;

/**
 * description:
 *
 * @author suqh
 *         Created by suqh on 2017/4/30.
 */
public interface IOrderInfoDao extends BaseDao<OrderInfo>{

    /**
     * 根据用户id查询订购历史
     *
     * @param userId
     * @return
     */
    public List<OrderInfo> queryOrderInfoById(Integer userId);
}
