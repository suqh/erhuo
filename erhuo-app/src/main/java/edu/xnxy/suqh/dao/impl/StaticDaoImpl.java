package edu.xnxy.suqh.dao.impl;

import edu.xnxy.suqh.dao.IStaticDao;
import edu.xnxy.suqh.entity.StaticData;
import edu.xnxy.suqh.entity.UserInfo;
import org.hibernate.Criteria;
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
 *         Created by suqh on 2017/4/24.
 */
@Repository("staticDao")
public class StaticDaoImpl implements IStaticDao {

    @Resource
    private SessionFactory sessionFactory;
    /**
     * 新增一条记录
     *
     * @param staticData
     * @return
     */
    @Override
    public void save(StaticData staticData) throws SQLException {

    }

    /**
     * 删除一条记录
     *
     * @param staticData
     * @return
     */
    @Override
    public void delete(StaticData staticData) throws SQLException {

    }

    /**
     * 修改一条记录
     *
     * @param staticData
     * @return
     */
    @Override
    public void update(StaticData staticData) throws SQLException {

    }

    /**
     * 查询一条记录
     *
     * @param staticData
     * @return
     */
    @Override
    public StaticData get(StaticData staticData) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(StaticData.class);
        if (staticData.getCodeId() != null) {
            criteria.add(Restrictions.eq("codeId", staticData.getCodeId()));
        }
        if (staticData.getCodeName() != null && staticData.getCodeName() != "") {
            criteria.add(Restrictions.eq("codeName", staticData.getCodeName()));
        }
        if (staticData.getCodeType() != null) {
            criteria.add(Restrictions.eq("codeType", staticData.getCodeType()));
        }
        staticData = (StaticData) criteria.uniqueResult();
        return staticData;
    }

    @Override
    public List<StaticData> staticDateList(Integer codeType, Integer codeId) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(StaticData.class);
        if (codeId != null) {
            criteria.add(Restrictions.eq("codeId",codeId));
        }
        if (codeType != null) {
            criteria.add(Restrictions.eq("codeType", codeType));
        }
        List<StaticData> staticDataList = criteria.list();
        return staticDataList;
    }
}
