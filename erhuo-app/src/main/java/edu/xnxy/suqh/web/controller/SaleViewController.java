package edu.xnxy.suqh.web.controller;

import edu.xnxy.suqh.entity.GoodsInfo;
import edu.xnxy.suqh.entity.StaticData;
import edu.xnxy.suqh.entity.UserInfo;
import edu.xnxy.suqh.service.IGoodsService;
import edu.xnxy.suqh.service.IStaticService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * description:
 *
 * @author suqh
 * Created by suqh on 2017/4/26.
 */
@Controller
@RequestMapping("/saleList")
public class SaleViewController {

    private static final Logger log = Logger.getLogger(SaleViewController.class);

    @Resource
    private IGoodsService goodsService;

    @Resource
    private IStaticService staticService;

    //加载首页时显示商品
    @RequestMapping("/showSaleList")
    public String showSaleList(HttpServletRequest httpServletRequest,GoodsInfo goodsInfo) {
        List<GoodsInfo> goodsInfoList = new ArrayList<GoodsInfo>();
        HttpSession session = httpServletRequest.getSession();
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        try {
            if (userInfo == null) {
                goodsInfoList = (List<GoodsInfo>) goodsService.queryGoodes(goodsInfo);
            }else {
                goodsInfoList = goodsService.queryGoodsInfoByCondition(null,null,null,null,userInfo.getUserId());
            }
            List<StaticData> goodsTypeList = new ArrayList<StaticData>();
            goodsTypeList = staticService.staticDataList(2,null);
            httpServletRequest.setAttribute("goodsInfoList",goodsInfoList);
            httpServletRequest.setAttribute("goodsTypeList",goodsTypeList);
        } catch (Exception e) {
            log.error("首页加载数据失败",e);
        }
        return "showSaleList";
    }

    //按姓名、类型、价格查询时显示商品
    @RequestMapping("/indexQueryGoods")
    public String queryGoodsInfoByCondition(HttpServletRequest httpServletRequest,String goodsName,String goodsType,Integer minGoodsPrice,Integer maxGoodsPrice,Integer userId) {
        HttpSession session = httpServletRequest.getSession();
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        List<GoodsInfo> goodsInfoList = new ArrayList<GoodsInfo>();
        List<StaticData> goodsTypeList = new ArrayList<StaticData>();
        GoodsInfo goodsInfo = new GoodsInfo();
        try {
                if(goodsType.equals("0")) {
                    if (userInfo == null) {
                        goodsInfoList = goodsService.queryGoodsInfoByCondition(goodsName,null,minGoodsPrice,maxGoodsPrice,null);
                    }else {
                        goodsInfoList = goodsService.queryGoodsInfoByCondition(goodsName, null, minGoodsPrice, maxGoodsPrice, userId);
                    }
                }else {
                    if (userInfo == null) {
                        goodsInfoList = goodsService.queryGoodsInfoByCondition(goodsName, goodsType, minGoodsPrice, maxGoodsPrice, null);
                    }else {
                        goodsInfoList = goodsService.queryGoodsInfoByCondition(goodsName, goodsType, minGoodsPrice, maxGoodsPrice, userId);
                    }
                }
            goodsTypeList = staticService.staticDataList(2,null);
            httpServletRequest.setAttribute("goodsInfoList",goodsInfoList);
            httpServletRequest.setAttribute("goodsTypeList",goodsTypeList);
            httpServletRequest.setAttribute("goodsType",goodsType);
            httpServletRequest.setAttribute("goodsName",goodsName);
            httpServletRequest.setAttribute("minGoodsPrice",minGoodsPrice);
            httpServletRequest.setAttribute("maxGoodsPrice",maxGoodsPrice);
        } catch (Exception e) {
            log.error("查询失败",e);
        }
        return "showSaleList";
    }
}
