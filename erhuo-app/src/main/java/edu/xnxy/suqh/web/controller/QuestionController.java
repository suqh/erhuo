package edu.xnxy.suqh.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * description:
 *
 * @author suqh
 *         Created by suqh on 2017/5/3.
 */
@Controller
@RequestMapping("/question")
public class QuestionController {

    @RequestMapping("/questionPage")
    public String questionPage() {
        return "question";
    }

    @RequestMapping("/testPage")
    public String testPage() {

        return "single";
    }
}
