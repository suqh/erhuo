package edu.xnxy.suqh.dao.impl;

import edu.xnxy.suqh.dao.IOrderInfoDao;
import edu.xnxy.suqh.entity.OrderInfo;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

/**
 * description:
 *
 * @author suqh
 *         Created by suqh on 2017/4/30.
 */
@Repository("orderInfoDao")
public class OrderInfoDaoImpl implements IOrderInfoDao{

    @Resource
    private SessionFactory sessionFactory;

    /**
     * 新增一条记录
     *
     * @param orderInfo
     * @return
     */
    @Override
    public void save(OrderInfo orderInfo) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        session.save(orderInfo);
    }

    /**
     * 删除一条记录
     *
     * @param orderInfo
     * @return
     */
    @Override
    public void delete(OrderInfo orderInfo) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        session.delete(orderInfo);
    }

    /**
     * 修改一条记录
     *
     * @param orderInfo
     * @return
     */
    @Override
    public void update(OrderInfo orderInfo) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(orderInfo);
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
        Session session = sessionFactory.getCurrentSession();
        List<OrderInfo> orderInfoList = null;
        String hql = "from OrderInfo where userId = ?";
        Query query = session.createQuery(hql);
        query.setInteger(0,userId);
        orderInfoList = query.list();
        return orderInfoList;
    }
}
