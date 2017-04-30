package edu.xnxy.suqh.service.impl;

import edu.xnxy.suqh.dao.IOrderInfoDao;
import edu.xnxy.suqh.entity.OrderInfo;
import edu.xnxy.suqh.service.IOrderInfoService;
import edu.xnxy.suqh.web.controller.FindPasswordController;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

/**
 * description:
 *
 * @author suqh
 *         Created by suqh on 2017/4/30.
 */
@Service("orderInfoService")
public class OrderInfoServiceImpl implements IOrderInfoService{

    private static final Logger log = Logger.getLogger(OrderInfoServiceImpl.class);

    @Resource
    private IOrderInfoDao orderInfoDao;

    /**
     * 新增一条记录
     *
     * @param orderInfo
     * @return
     */
    @Override
    public void addOrderInfo(OrderInfo orderInfo) throws SQLException {
        try {
            orderInfoDao.save(orderInfo);
        } catch (SQLException e) {
            log.error("添加订购记录失败",e);
        }
    }

    /**
     * 删除一条记录
     *
     * @param userId  用户编号
     * @param orderId 订单编号
     * @return
     */
    @Override
    public void deleteOrderInfo(Integer userId, Integer orderId) throws SQLException {
        try {
            orderInfoDao.deleteOrderInfo(userId,orderId);
        } catch (Exception e) {
            log.error("更新订够记录",e);
        }
    }


    /**
     * 修改一条记录
     *
     * @param orderInfo
     * @return
     */
    @Override
    public void updateOrderInfo(OrderInfo orderInfo) throws SQLException {
        try {
            orderInfoDao.update(orderInfo);
        } catch (SQLException e) {
            log.error("更新订够记录",e);
        }
    }

    /**
     * 查询一条记录
     *
     * @param orderInfo
     * @return
     */
    @Override
    public OrderInfo get(OrderInfo orderInfo) {
        return null;
    }

    /**
     * 根据用户id查询订购历史
     *
     * @param userId
     * @return
     */
    @Override
    public List<OrderInfo> queryOrderInfoById(Integer userId) {
        List<OrderInfo> orderInfoList = null;
        try {
            orderInfoList = orderInfoDao.queryOrderInfoById(userId);
        } catch (Exception e) {
            log.error("查询订购历史失败",e);
        }
        return orderInfoList;
    }
}
