package edu.xnxy.suqh.service.impl;

import edu.xnxy.suqh.dao.IUserDao;
import edu.xnxy.suqh.entity.UserInfo;
import edu.xnxy.suqh.service.IUserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * description:
 *
 * @author suqh
 *         Created by suqh on 2017/4/12.
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    private static final Logger log = Logger.getLogger(UserServiceImpl.class);

    @Resource
    private IUserDao userDao;

    /**
     * 添加一个用户
     *
     * @param userInfo
     */
    public Map<String, Object> register(UserInfo userInfo) throws Exception {
        UserInfo userInfo1 = null;
        Map<String, Object> resultMap = null;
        try {
            resultMap = new HashMap<String, Object>();
            userInfo1 = userDao.get(userInfo);
            if (userInfo1 == null) {
                userDao.save(userInfo);
                resultMap.put("msg","success");
            }else {
                resultMap.put("msg","error");
                log.warn("该用户名已被注册");
            }
        } catch (Exception e) {
            log.error("注册用户失败");
            throw new RuntimeException("注册用户失败",e);
        }
        return resultMap;
    }

    /**
     * 删除一个用户
     *
     * @param userInfo
     */
    public void delete(UserInfo userInfo) throws Exception {
        try {
            userDao.delete(userInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 修改用户信息
     *
     * @param userInfo
     */
    public void update(UserInfo userInfo) throws Exception {
        try {
            userDao.update(userInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询用户信息
     *
     * @param userInfo
     */
    public UserInfo login(UserInfo userInfo) throws Exception {
        UserInfo userInfo1 = null;
        try {
            userInfo1 = userDao.get(userInfo);
            if (userInfo1 != null) {
                if (userInfo.getUserPassword().equals(userInfo1.getUserPassword())) {
                    log.info("登录成功");
                }else {
                    log.error("密码错误，请重新输入");
                    throw new Exception("密码错误，请重新输入");
                }
            }else {
                log.error("用户不存在");
                throw new Exception("用户不存在");
            }
        } catch (Exception e) {
            log.error("登录失败",e);
            return null;
        }
        return userInfo1;
    }

    //根据用户姓名查找
    public UserInfo queryUserByName(UserInfo userInfo) {
        try {
            userInfo = userDao.get(userInfo);
        } catch (Exception e) {
            log.error("查找用户失败");
        }
        return userInfo;
    }
}
