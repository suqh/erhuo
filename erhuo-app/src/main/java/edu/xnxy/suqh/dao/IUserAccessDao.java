package edu.xnxy.suqh.dao;

import edu.xnxy.suqh.dao.BaseDao;
import edu.xnxy.suqh.entity.UserAccess;

import java.util.Date;
import java.util.List;

/**
 * Description: 用户访问记录接口
 *
 * Created by suqh on 17-5-5.
 */
public interface IUserAccessDao extends BaseDao<UserAccess> {

    /**
     * Description:统计前15的的用户访问量
     * @return
     */
    public List countUserAccess();

}
