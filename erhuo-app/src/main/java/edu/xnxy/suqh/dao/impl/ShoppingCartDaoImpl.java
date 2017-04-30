package edu.xnxy.suqh.dao.impl;

import edu.xnxy.suqh.dao.IShoppingCartDao;
import edu.xnxy.suqh.entity.GoodsInfo;
import edu.xnxy.suqh.entity.ShoppingCartInfo;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

/**
 * description:
 *
 * @author suqh
 *         Created by suqh on 2017/4/28.
 */
@Repository("shoppingCartDao")
public class ShoppingCartDaoImpl implements IShoppingCartDao {

    @Resource
    private SessionFactory sessionFactory;

    /**
     * 新增一条记录
     *
     * @param shoppingCartInfo
     * @return
     */
    @Override
    public void save(ShoppingCartInfo shoppingCartInfo) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        session.save(shoppingCartInfo);
    }

    /**
     * 删除一条记录
     *
     * @param shoppingCartInfo
     * @return
     */
    @Override
    public void delete(ShoppingCartInfo shoppingCartInfo) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        session.delete(queryShoppingCartInfoByGoodsIdAndUserId(shoppingCartInfo.getGoodsId(),shoppingCartInfo.getUserId()));
    }

    /**
     * 修改一条记录
     *
     * @param shoppingCartInfo
     * @return
     */
    @Override
    public void update(ShoppingCartInfo shoppingCartInfo) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        session.update(shoppingCartInfo);
    }

    /**
     * 查询一条记录
     *
     * @param shoppingCartInfo
     * @return
     */
    @Override
    public ShoppingCartInfo get(ShoppingCartInfo shoppingCartInfo) {
        return null;
    }

    /**
     * 查询多条记录
     *
     * @param userId
     * @return
     */
    @Override
    public List<ShoppingCartInfo> queryShoppingCartByUserId(Integer userId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from ShoppingCartInfo";
        Query query = session.createQuery(hql);
        List<ShoppingCartInfo> shoppingCartInfoList = query.list();
        return shoppingCartInfoList;
    }

    /**
     * 根据goodsId查询购物车商品信息
     *
     * @param goodsId
     * @return
     */
    @Override
    public ShoppingCartInfo queryShoppingCartInfoByGoodsIdAndUserId(Integer goodsId,Integer userId) {
        ShoppingCartInfo shoppingCartInfo = null;
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(ShoppingCartInfo.class);
        if (goodsId != null) {
            criteria.add(Restrictions.eq("goodsId", goodsId));
        }
        if (userId != null) {
            criteria.add(Restrictions.eq("userId",userId));
        }
        shoppingCartInfo = (ShoppingCartInfo) criteria.uniqueResult();
        return shoppingCartInfo;
    }

    /**
     * 根据用户编号清空购物车
     *
     * @param userId 用户编号
     */
    @Override
    public void deleteShoppingCartByUserId(Integer userId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "delete from ShoppingCartInfo where userId=?";
        Query query = session.createQuery(hql);
        query.setInteger(0,userId);
        query.executeUpdate();
    }
}
