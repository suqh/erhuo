package edu.xnxy.suqh.web.controller;

import edu.xnxy.suqh.service.IOrderInfoService;
import edu.xnxy.suqh.service.IUserAccessService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.*;

/**
 * Description:销售情况分析
 *
 * Created by suqh on 17-5-6.
 */
@Controller
@RequestMapping("/salesAnalysis")
public class SalesAnalysisController {

    private static Logger log = Logger.getLogger(SalesAnalysisController.class);

    @Resource
    private IUserAccessService userAccessService;

    @Resource
    private IOrderInfoService orderInfoService;

    /**
     * Description:返回到分析页面
     * @return
     */
    @RequestMapping("/salesAnalysisPage")
    public String showSalesAnalysisPage(){
        return "salesAnalysis";
    }

    /**
     * Description:获取前15天的用户访问量
     * @return
     */
    @RequestMapping("/getAccessData")
    @ResponseBody
    public Map<String,Object> getAccessData(){
        Map<String,Object> resultMap = null;
        try {
            resultMap = new HashMap<>();
            //获取用户访问量
            List accessDataList= userAccessService.countUserAccess();
            resultMap.put("accessDataList",accessDataList);
            resultMap.put("status",1);
        }catch (Exception e){
            log.error("获取前15天的用户访问量",e);
            resultMap.put("status",0);
            resultMap.put("error","获取前15天的用户访问量");
        }
        return resultMap;
    }

    /**
     * Description:获取前15天的销售情况
     * @return
     */
    @RequestMapping("/getSalesData")
    @ResponseBody
    public Map<String,Object> getSalesData(){
        Map<String,Object> resultMap = null;
        try {
            resultMap = new HashMap<>();
            //获取销售情况
            List salesDataList= orderInfoService.countOrderType();
            resultMap.put("salesDataList",salesDataList);
            resultMap.put("status",1);
        }catch (Exception e){
            log.error("获取前15天的销售情况",e);
            resultMap.put("status",0);
            resultMap.put("error","获取前15天的销售情况");
        }
        return resultMap;
    }

}
