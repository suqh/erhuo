package edu.xnxy.suqh.dao.impl;

import edu.xnxy.suqh.dao.IOrderInfoDao;
import edu.xnxy.suqh.entity.OrderInfo;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * description:
 *
 * @author suqh
 *         Created by suqh on 2017/4/30.
 */
@Repository("orderInfoDao")
public class OrderInfoDaoImpl implements IOrderInfoDao {

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
        String hql = "from OrderInfo where orderUserId = ?";
        Query query = session.createQuery(hql);
        query.setInteger(0, userId);
        orderInfoList = query.list();
        return orderInfoList;
    }

    /**
     * 根据用户编号，和订单号删除订单
     *
     * @param userId
     * @param orderId
     */
    @Override
    public void deleteOrderInfo(Integer userId, Integer orderId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "delete from OrderInfo where orderUserId = ? and orderId = ?";
        Query query = session.createQuery(hql);
        query.setInteger(0, userId);
        query.setInteger(1, orderId);
        query.executeUpdate();
    }

    /**
     * Description:获取15天前每种类型商品的销售数量
     *
     * @return
     */
    @Override
    public List countOrderType() {
        Session session = sessionFactory.getCurrentSession();
        //获取15天前的时间
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -15);
        Date startDate = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String start = "'" + dateFormat.format(startDate) + "'";
        //查询15天内各种商品类型的销售情况
        String hql = "SELECT  c.codeName, COUNT(b.orderGoodsId) " +
                " FROM GoodsInfo a, OrderInfo b, StaticData c " +
                " WHERE a.goodsId = b.orderGoodsId" +
                " AND c.codeType = 2" +
                " AND a.goodsType = c.codeId" +
                " AND DATE_FORMAT(b.orderDate,'%Y-%m-%d')  >=" + start +
                " GROUP BY c.codeName";
        List list = session.createQuery(hql).list();
        return list;
    }
}
