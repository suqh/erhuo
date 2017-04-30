package edu.xnxy.suqh.dao;

import java.sql.SQLException;

/**
 * description:Dao层基础接口
 *
 * @author suqh
 * Created by suqh on 2017/4/11.
 */
public interface BaseDao<T> {

    /**
     * 新增一条记录
     *
     * @param t
     * @return
     */
    public void save(T t) throws SQLException;

    /**
     * 删除一条记录
     *
     * @param t
     * @return
     */
    public void delete(T t) throws SQLException;

    /**
     * 修改一条记录
     *
     * @param t
     * @return
     */
    public void update(T t) throws SQLException;

    /**
     * 查询一条记录
     *
     * @param t
     * @return
     */
    public T get(T t);
}
