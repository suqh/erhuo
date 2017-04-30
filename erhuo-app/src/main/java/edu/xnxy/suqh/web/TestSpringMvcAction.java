package edu.xnxy.suqh.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * description:
 *
 * @author suqh
 *         Created by suqh on 2017/4/12.
 */
@Controller
@RequestMapping("/test")
public class TestSpringMvcAction {

    @RequestMapping("/SpringMvc")
    public String test() {
        return "/testSpringMVC";
    }
}
