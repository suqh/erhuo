package edu.xnxy.suqh.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * description:
 *
 * @author suqh
 *         Created by suqh on 2017/4/30.
 */
@Controller
@RequestMapping("/loginOut")
public class LoginOutController {

    //退出操作
    @RequestMapping("/loginOut")
    public String loginOut(HttpSession session) {
        session.removeAttribute("userInfo");
        return "login";
    }
}
