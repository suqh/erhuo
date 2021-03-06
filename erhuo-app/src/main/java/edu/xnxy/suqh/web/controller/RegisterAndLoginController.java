package edu.xnxy.suqh.web.controller;

import edu.xnxy.suqh.entity.UserInfo;
import edu.xnxy.suqh.service.IUserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: 注册登录控制器
 *
 * @author suqh
 *         Created by suqh on 2017/4/15.
 */
@Controller
@RequestMapping("/registerAndLogin")
public class RegisterAndLoginController {

    private static final Logger log = Logger.getLogger(RegisterAndLoginController.class);

    @Resource
    private IUserService userService;

    /**
     * Description:跳转到注册页面
     *
     * @return
     */
    @RequestMapping("/registerPage")
    public String registerPage() {
        return "register";
    }

    /**
     * Description:跳转到登录页面
     *
     * @return
     */
    @RequestMapping("/loginPage")
    public String loginPage() {
        return "login";
    }

    /**
     * Description:跳转到首页
     *
     * @return
     */
    @RequestMapping("/indexPage")
    public String indexPage() {
        return "index";
    }


    /**
     * Description:跳转到用户信息编辑页面
     *
     * @param httpServletRequest
     * @param userInfo
     * @return
     */
    @RequestMapping("editPage")
    public String editUserInfoPage(HttpServletRequest httpServletRequest, UserInfo userInfo) {
        try {
            userInfo = userService.queryUserByName(userInfo);
            HttpSession session = httpServletRequest.getSession();
            session.setAttribute("userInfo", userInfo);
        } catch (Exception e) {
            log.error("查询用户失败");
        }
        return "editUserInfo";
    }

    /**
     * Description:用户注册
     *
     * @param userInfo 用户信息
     * @return
     */
    @RequestMapping("/register.do")
    @ResponseBody
    public Map<String, Object> register(UserInfo userInfo) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            userService.register(userInfo);
            resultMap.put("status", 1);
            resultMap.put("message", "注册成功");
        } catch (Exception e) {
            resultMap.put("status", 0);
            resultMap.put("error", "注册失败");
            log.error("注册失败", e);
        }
        return resultMap;
    }

    /**
     * Description:用户登录
     *
     * @param httpServletRequest
     * @param userInfo
     * @return
     */
    @RequestMapping("/login.do")
    @ResponseBody
    public Map<String, Object> login(HttpServletRequest httpServletRequest, UserInfo userInfo) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            userInfo = userService.login(userInfo);
            if (userInfo != null) {
                //获取session对象
                HttpSession session = httpServletRequest.getSession();
                session.setAttribute("userInfo", userInfo);
                resultMap.put("status", 1);
                resultMap.put("userId", userInfo.getUserId());
            } else {
                resultMap.put("status", 0);
                resultMap.put("error", "用户名或密码错误");
            }
        } catch (Exception e) {
            resultMap.put("status", 0);
            resultMap.put("error", "登录失败");
            log.error("登录失败", e);
        }
        return resultMap;
    }

    /**
     * Description:编辑修改用户信息
     *
     * @param httpServletRequest
     * @param userInfo
     * @return
     */
    @RequestMapping("editUserInfo.do")
    @ResponseBody
    public Map<String, Object> editUserInfo(HttpServletRequest httpServletRequest, UserInfo userInfo) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            //获取session对象
            HttpSession session = httpServletRequest.getSession();
            UserInfo userInfo1 = (UserInfo) session.getAttribute("userInfo");
            userInfo.setUserId(userInfo1.getUserId());
            userInfo.setUserPassword(userInfo1.getUserPassword());
            userService.update(userInfo);
            resultMap.put("status", 1);
            resultMap.put("userId", userInfo1.getUserId());
            resultMap.put("message", "修改用户信息成功");
        } catch (Exception e) {
            resultMap.put("status", 0);
            resultMap.put("error", "修改用户信息失败");
            log.error("修改用户信息失败", e);
        }
        return resultMap;
    }
}
