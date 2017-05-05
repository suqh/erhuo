package edu.xnxy.suqh.dao.impl;

import edu.xnxy.suqh.dao.IGoodsDao;
import edu.xnxy.suqh.entity.GoodsInfo;
import org.hibernate.*;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

/**
 * description:
 *
 * @author suqh
 *         Created by suqh on 2017/4/20.
 */
@Repository("goodsDao")
public class GoodsDaoImpl implements IGoodsDao {

    @Resource
    private SessionFactory sessionFactory;

    /**
     * 新增一条记录
     *
     * @param goodsInfo
     * @return
     */
    @Override
    public void save(GoodsInfo goodsInfo) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        session.save(goodsInfo);
    }

    /**
     * 删除一条记录
     *
     * @param goodsInfo
     * @return
     */
    @Override
    public void delete(GoodsInfo goodsInfo) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        session.delete(queryGoodsInfoByGoodsId(goodsInfo.getGoodsId()));
    }

    /**
     * 修改一条记录
     *
     * @param goodsInfo
     * @return
     */
    @Override
    public void update(GoodsInfo goodsInfo) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(goodsInfo);
    }

    /**
     * 查询商品记录
     *
     * @param goodsInfo
     * @return
     */
    @Override
    public GoodsInfo get(GoodsInfo goodsInfo) {
        GoodsInfo goodsInfo1 = null;
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(GoodsInfo.class);
        //根据商品的名称、价格、类型查询
        if (goodsInfo.getGoodsName() != null && goodsInfo.getGoodsName() != "") {
            criteria.add(Restrictions.eq("goodsName", goodsInfo.getGoodsName()));
        }
        if (goodsInfo.getGoodsPrice() != null) {
            criteria.add(Restrictions.eq("goodsPrice", goodsInfo.getGoodsPrice()));
        }
        if (goodsInfo.getGoodsType() != null) {
            criteria.add(Restrictions.eq("goodsType", goodsInfo.getGoodsType()));
        }
        goodsInfo1 = (GoodsInfo) criteria.uniqueResult();
        return goodsInfo1;
    }

    /**
     * 根据userId查询商品信息
     *
     * @param userId
     * @return
     */
    public List<GoodsInfo> queryGoodsInfoByUserId(Integer userId) {
        List<GoodsInfo> goodsInfoList = null;
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(GoodsInfo.class);
        if (userId != null) {
            criteria.add(Restrictions.eq("userId", userId));
        }
        criteria.addOrder(Order.desc("goodsDate"));
        goodsInfoList = criteria.list();
        return goodsInfoList;
    }

    /**
     * 根据goodsId查询商品信息
     *
     * @param goodsId
     * @return
     */
    public GoodsInfo queryGoodsInfoByGoodsId(Integer goodsId) {
        GoodsInfo goodsInfo = null;
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(GoodsInfo.class);
        if (goodsId != null) {
            criteria.add(Restrictions.eq("goodsId", goodsId));
        }
        goodsInfo = (GoodsInfo) criteria.uniqueResult();
        return goodsInfo;
    }

    /**
     * 获取指定数量的推荐商品，但是不查询用户自己发布的和当前查看的商品
     *
     * @param goodsType 查询商品类型
     * @param goodsId   不查询的商品编号
     * @param userId    不查询的用户编号（当前登录用户）
     * @param count     查询数量
     * @return
     */
    public List<GoodsInfo> queryRecommendGoodsInfo(String goodsType, Integer goodsId, Integer userId, Integer count) {
        Session session = sessionFactory.getCurrentSession();
        List<GoodsInfo> goodsInfoList = null;
        String hql = "from GoodsInfo where goodsType = ? and goodsId != ? and userId != ?";
        Query query = session.createQuery(hql);
        query.setString(0, goodsType);
        query.setInteger(1, goodsId);
        query.setInteger(2, userId);
        query.setMaxResults(count);
        goodsInfoList = query.list();
        return goodsInfoList;
    }

    /**
     * 查询多条商品信息
     *
     * @return
     */
    public List<GoodsInfo> query(GoodsInfo goodsInfo) {
        List<GoodsInfo> goodsInfoList = null;
        Session session = sessionFactory.getCurrentSession();
        String hql = "from GoodsInfo where userId <> " + goodsInfo.getUserId() + " order by goodsDate desc";
        Query query = session.createQuery(hql);
        goodsInfoList = query.list();
        return goodsInfoList;
    }

    /**
     * 根据输入的商品名称、选择的商品类型、商品的价格查询商品
     *
     * @param goodsName
     * @param goodsType
     * @param minGoodsPrice
     * @param maxGoodsPrice
     * @return
     */
    @Override
    public List<GoodsInfo> queryGoodsInfoByCondition(String goodsName, String goodsType, Integer minGoodsPrice, Integer maxGoodsPrice, Integer userId) {

        List<GoodsInfo> goodsInfoList = null;
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(GoodsInfo.class);
        if (goodsName != null && goodsName != "") {
            criteria.add(Restrictions.like("goodsName", "%" + goodsName + "%"));
        }
        if (goodsType != null && goodsType != "") {
            criteria.add(Restrictions.eq("goodsType", goodsType));
        }
        if (minGoodsPrice != null) {
            criteria.add(Restrictions.ge("goodsPrice", minGoodsPrice));
        }
        if (maxGoodsPrice != null) {
            criteria.add(Restrictions.lt("goodsPrice", maxGoodsPrice));
        }
        if (userId != null) {
            criteria.add(Restrictions.ne("userId", userId));
        }
        criteria.addOrder(Order.desc("goodsDate"));
        goodsInfoList = criteria.list();
        return goodsInfoList;
    }
}
