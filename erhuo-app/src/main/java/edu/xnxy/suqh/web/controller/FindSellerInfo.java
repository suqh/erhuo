package edu.xnxy.suqh.web.controller;

import edu.xnxy.suqh.entity.UserInfo;
import edu.xnxy.suqh.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * description:
 *
 * @author suqh
 *         Created by suqh on 2017/5/5.
 */
@Controller
@RequestMapping("/serllerInfo")
public class FindSellerInfo {

    @Resource
    private IUserService userService;

    //查看卖家信息
    @RequestMapping("/serllerInfo")
    public String querysSellerInfo(HttpServletRequest httpServletRequest,String goodsUserId) {
        UserInfo userInfo  = userService.queryUserInfoById(Integer.valueOf(goodsUserId));
        httpServletRequest.setAttribute("userInfo",userInfo);
        return "sellerInfo";
    }
}
