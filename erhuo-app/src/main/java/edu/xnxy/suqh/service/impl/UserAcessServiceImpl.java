package edu.xnxy.suqh.service.impl;

import edu.xnxy.suqh.dao.IUserAccessDao;
import edu.xnxy.suqh.entity.UserAccess;
import edu.xnxy.suqh.service.IUserAccessService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description: 用户访问统计业务
 *
 * Created by caojx on 17-5-6.
 */
@Service("userAccessService")
public class UserAcessServiceImpl implements IUserAccessService {

    private static final Logger log = Logger.getLogger(UserAcessServiceImpl.class);

    @Resource
    private IUserAccessDao userAccessDao;

    /**
     * Description:新增一条用户访问记录
     *
     * @param userAccess
     */
    @Override
    public void insert(UserAccess userAccess)  throws Exception{
        try{
            userAccessDao.save(userAccess);
        }catch (Exception e){
            log.error("保存用户访问记录出错",e);
            throw new Exception("保存用户访问记录出错",e);
        }
    }

    /**
     * Description:统计前15天的用户访问量
     */
    @Override
    public List countUserAccess()  throws Exception {
        List list = null;
        try{
            list =  userAccessDao.countUserAccess();
        }catch (Exception e){
            log.error("按月获取用户访问信息",e);
            throw new Exception("按月获取用户访问信息",e);
        }
        return list;
    }
}
