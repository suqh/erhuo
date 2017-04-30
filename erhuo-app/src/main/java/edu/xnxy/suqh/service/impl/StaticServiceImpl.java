package edu.xnxy.suqh.service.impl;

import edu.xnxy.suqh.dao.IStaticDao;
import edu.xnxy.suqh.entity.StaticData;
import edu.xnxy.suqh.service.IStaticService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * description:
 *
 * @author suqh
 *         Created by suqh on 2017/4/24.
 */
@Service("staticService")
public class StaticServiceImpl implements IStaticService{

    @Resource
    private IStaticDao staticDao;

    @Override
    public List<StaticData> staticDataList(Integer codeType, Integer codeId) throws Exception {
        List<StaticData> staticDataList = null;
        try {
            staticDataList = staticDao.staticDateList(codeType,codeId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return staticDataList;
    }
}
