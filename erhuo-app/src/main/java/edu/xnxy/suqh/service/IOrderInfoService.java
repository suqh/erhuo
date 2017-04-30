package edu.xnxy.suqh.service;

import edu.xnxy.suqh.entity.OrderInfo;

import java.sql.SQLException;
import java.util.List;

/**
 * description:
 *
 * @author suqh
 *         Created by suqh on 2017/4/30.
 */
public interface IOrderInfoService {

    /**
     * 新增一条记录
     *
     * @param orderInfo
     * @return
     */
    public void addOrderInfo(OrderInfo orderInfo) throws SQLException;

    /**
     * 删除一条记录
     *
     * @param userId 用户编号
     * @param orderId 订单编号
     * @return
     */
    public void deleteOrderInfo(Integer userId, Integer orderId) throws SQLException;


    /**
     * 修改一条记录
     *
     * @param orderInfo
     * @return
     */
    public void updateOrderInfo(OrderInfo orderInfo) throws SQLException;

    /**
     * 查询一条记录
     *
     * @param orderInfo
     * @return
     */
    public OrderInfo get(OrderInfo orderInfo);

    /**
     * 根据用户id查询订购历史
     *
     * @param userId
     * @return
     */
    public List<OrderInfo> queryOrderInfoById(Integer userId);
}
