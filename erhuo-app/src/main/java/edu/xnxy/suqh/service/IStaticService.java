package edu.xnxy.suqh.service;

import edu.xnxy.suqh.entity.StaticData;

import java.util.List;

/**
 * description:
 *
 * @author suqh
 *         Created by suqh on 2017/4/24.
 */
public interface IStaticService {

    public List<StaticData> staticDataList(Integer codeType,Integer codeId) throws Exception;
}
