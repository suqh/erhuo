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

    /**
     * 根据用户编号，和订单号删除订单
     * @param userId
     * @param orderId
     */
    public void deleteOrderInfo(Integer userId,Integer orderId);

    /**
     * 获取15天前每种类型商品的销售数量
     * @return
     */
    public List countOrderType();
}
