package edu.xnxy.suqh.dao;

import edu.xnxy.suqh.entity.StaticData;

import java.util.List;

/**
 * description:静态数据接口
 *
 * @author suqh
 * Created by suqh on 2017/4/11.
 */
public interface IStaticDao extends BaseDao<StaticData> {

    public List<StaticData> staticDateList(Integer codeType,Integer codeId);

}
