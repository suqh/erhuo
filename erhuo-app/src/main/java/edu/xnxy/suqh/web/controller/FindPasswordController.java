package edu.xnxy.suqh.web.controller;

import edu.xnxy.suqh.entity.UserInfo;
import edu.xnxy.suqh.service.IUserService;
import edu.xnxy.suqh.util.MD5;
import edu.xnxy.suqh.util.MailUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * description:
 *
 * @author suqh
 *         Created by suqh on 2017/4/30.
 */
@Controller
@RequestMapping("/forgetPassword")
public class FindPasswordController {

    private static final Logger log = Logger.getLogger(FindPasswordController.class);

    @Resource
    private IUserService userService;

    @RequestMapping("/viewEmailPage")
    public ModelAndView viewEmailPage(UserInfo userInfo) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            userInfo = userService.queryUserByName(userInfo);
            resultMap.put("status", 1);
            resultMap.put("userInfo", userInfo);
        } catch (Exception e) {
            resultMap.put("status", 0);
            resultMap.put("error", "用户不存在或邮箱信息缺失");
            log.error("用户不存在或邮箱信息缺失");
        }
        return new ModelAndView("viewEmail", resultMap);
    }

    /**
     * Description: 发送邮件
     *
     * @param userInfo
     * @param request
     * @return
     */
    @RequestMapping("/sendMail")
    @ResponseBody
    public Map<String, Object> sendMail(UserInfo userInfo, HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            //生成密钥
            String secretKey = UUID.randomUUID().toString();
            //设置过期时间
            Date outDate = new Date(System.currentTimeMillis() + 30 * 60 * 1000);// 30分钟后过期
            long date = outDate.getTime() / 1000 * 1000;// 忽略毫秒数  mySql 取出时间是忽略毫秒数的

            //更新用户的表中的过期时间、密钥信息
            try {
                UserInfo userInfo1 = userService.queryUserInfoById(userInfo.getUserId());
                userInfo1.setOutDate(date);
                userInfo1.setValidataCode(secretKey);
                userService.update(userInfo1);
            } catch (Exception e) {
                log.error("更新用户信息失败", e);
                throw new Exception("更新用户信息失败", e);
            }

            //将用编号、过期时间、密钥生成链接密钥
            String key = userInfo.getUserId() + "$" + date + "$" + secretKey;

            String digitalSignature = MD5.getMD5Str(key);// 数字签名

            String path = request.getContextPath();

            String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;

            String resetPassHref = basePath + "/forgetPassword/findPassword?sid=" + digitalSignature + "&userId=" + userInfo.getUserId();

            String emailContent = "请勿回复本邮件.点击下面的链接,重设密码,本邮件超过30分钟,链接将会失效，需要重新申请找回密码." + resetPassHref;

            //发送邮件
            MailUtil.sendMail(emailContent, userInfo.getUserEmail());
            resultMap.put("status", 1);
            resultMap.put("message", "邮件已发送致邮箱:" + userInfo.getUserEmail() + "请登录邮箱找回密码");
        } catch (Exception e) {
            resultMap.put("status", 0);
            resultMap.put("message", "服务出错了");
            log.error("邮件发送失败", e);
        }
        return resultMap;
    }

    /**
     * 验证链接是否有效
     */
    @RequestMapping("findPassword")
    public ModelAndView findPassword(String sid, String userId) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            //判断链接是否正确
            if (sid == null || userId == null) {
                log.warn("修改密码链接无效");
                resultMap.put("status", 0);
                resultMap.put("message", "修改密码链接无效");
            }

            UserInfo userInfo = userService.queryUserInfoById(Integer.valueOf(userId));
            if (userInfo != null) {
                //判断链接是否已经超时失效
                if (userInfo.getOutDate() < System.currentTimeMillis()) {
                    log.warn("链接已失效");
                    resultMap.put("status", 0);
                    resultMap.put("message", "链接已失效");
                }
                //获取用户的数字签名
                String key = userInfo.getUserId() + "$" + userInfo.getOutDate() + "$" + userInfo.getValidataCode();
                String digitalSignature = MD5.getMD5Str(key); //生成数字签名
                if (!digitalSignature.equals(sid)) {
                    log.warn("数字签名不正确");
                    resultMap.put("status", 0);
                    resultMap.put("message", "数字签名不正确");
                } else {  //跳转到修改密码页面
                    resultMap.put("userInfo", userInfo);
                    return new ModelAndView("findPassword", resultMap);
                }
            }
        } catch (NumberFormatException e) {
            log.error("链接不能识别");
            resultMap.put("status", 0);
            resultMap.put("message", "非法链接");
        }
        return new ModelAndView("login", resultMap);
    }

    @RequestMapping("/editPassword")
    @ResponseBody
    public Map<String, Object> editPassword(Integer userId, String newPassword) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            UserInfo userInfo = userService.queryUserInfoById(userId);
            if (userInfo != null) {
                userInfo.setUserPassword(newPassword);
                //更新密钥
                String secretKey = UUID.randomUUID().toString();
                userInfo.setValidataCode(secretKey);
                userService.update(userInfo);
                resultMap.put("status",1);
                resultMap.put("message","密码修改成功");
            }
        } catch (Exception e) {
            log.error("密码修改失败",e);
            resultMap.put("status",0);
            resultMap.put("error","密码修改失败");
        }
        return resultMap;
    }
}
