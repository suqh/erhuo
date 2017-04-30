package edu.xnxy.suqh.dao.impl;

import edu.xnxy.suqh.dao.IUserDao;
import edu.xnxy.suqh.entity.UserInfo;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.SQLException;

/**
 * description:Dao层用户信息实现类
 *
 * @author suqh
 *         Created by suqh on 2017/4/11.
 */
@Repository("userDao")
public class UserDaoImpl implements IUserDao {

    @Resource
    private SessionFactory sessionFactory;

    /**
     * 新增一条记录
     *
     * @param userInfo
     * @return
     */
    public void save(UserInfo userInfo) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        session.save(userInfo);
    }

    /**
     * 删除一条记录
     *
     * @param userInfo
     * @return
     */
    public void delete(UserInfo userInfo) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        session.delete(userInfo);
    }

    /**
     * 修改一条记录
     *
     * @param userInfo
     * @return
     */
    public void update(UserInfo userInfo) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(userInfo);
    }

    /**
     * 查询一条记录
     *
     * @param userInfo
     * @return
     */
    public UserInfo get(UserInfo userInfo) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(UserInfo.class);
        //判断用户的姓名、ID、邮箱、手机号是否为空，不为空则根据这些条件查询用户信息
        if (userInfo.getUserName() != null && userInfo.getUserName() != "") {
            criteria.add(Restrictions.eq("userName", userInfo.getUserName()));
        }
        if (userInfo.getUserId() != null) {
            criteria.add(Restrictions.eq("userId", userInfo.getUserId()));
        }
        if (userInfo.getUserEmail() != null && userInfo.getUserEmail() != "") {
            criteria.add(Restrictions.eq("userEmail", userInfo.getUserEmail()));
        }
        if (userInfo.getUserPhone() != null) {
            criteria.add(Restrictions.eq("userPhone", userInfo.getUserPhone()));
        }
        userInfo = (UserInfo) criteria.uniqueResult();
        return userInfo;
    }

    /**
     * 根据用户id查询用户信息
     *
     * @param userId
     */
    @Override
    public UserInfo queryUserInfoById(Integer userId) {
        Session session = sessionFactory.getCurrentSession();
        UserInfo userInfo = null;
        String hql = "from UserInfo where userId = ?";
        Query query = session.createQuery(hql);
        query.setInteger(0,userId);
        userInfo = (UserInfo) query.uniqueResult();
        return userInfo;
    }
}
