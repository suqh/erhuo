package edu.xnxy.suqh.dao.impl;

import edu.xnxy.suqh.dao.IUserAccessDao;
import edu.xnxy.suqh.entity.UserAccess;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Description:用户访问记录Dao层实现类
 * <p>
 * Created by caojx on 17-5-5.
 */
@Repository("userAccessDao")
public class UserAccessDaoImpl implements IUserAccessDao {

    @Resource
    private SessionFactory sessionFactory;

    /**
     * 新增一条记录
     *
     * @param userAccess
     * @return
     */
    @Override
    public void save(UserAccess userAccess) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        session.save(userAccess);
    }

    /**
     * 删除一条记录
     *
     * @param userAccess
     * @return
     */
    @Override
    public void delete(UserAccess userAccess) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        session.delete(userAccess);
    }

    /**
     * 修改一条记录
     *
     * @param userAccess
     * @return
     */
    @Override
    public void update(UserAccess userAccess) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        session.update(userAccess);
    }

    /**
     * 查询一条记录
     *
     * @param userAccess
     * @return
     */
    @Override
    public UserAccess get(UserAccess userAccess) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(UserAccess.class);
        if (userAccess.getAccessDate() != null) {
            criteria.add(Restrictions.eq("accessDate(", userAccess.getAccessDate()));
        }
        return (UserAccess) criteria.uniqueResult();
    }

    /**
     * Description:统计前15天的用户访问量
     *
     * @return
     */
    @Override
    public List countUserAccess() {
        Session session = sessionFactory.getCurrentSession();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -15);
        Date startDate = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String start = "'" + dateFormat.format(startDate) + "'";
        String hql = "SELECT  DATE_FORMAT(accessDate, '%m/%e'), COUNT(ID) FROM UserAccess  WHERE DATE_FORMAT(accessDate,'%Y-%m-%d') >= " + start + "  GROUP BY  accessDate ORDER  BY accessDate ASC";
        List list = session.createQuery(hql).list();
        return list;
    }
}
