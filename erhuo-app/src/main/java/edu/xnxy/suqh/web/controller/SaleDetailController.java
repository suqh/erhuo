package edu.xnxy.suqh.web.controller;

import edu.xnxy.suqh.entity.GoodsInfo;
import edu.xnxy.suqh.entity.StaticData;
import edu.xnxy.suqh.entity.UserInfo;
import edu.xnxy.suqh.service.IGoodsService;
import edu.xnxy.suqh.service.IStaticService;
import edu.xnxy.suqh.service.IUserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * description:
 *
 * @author suqh
 *         Created by suqh on 2017/4/24.
 */
@Controller
@RequestMapping("/saleDetail")
public class SaleDetailController {

    @Resource
    private IGoodsService goodsService;

    @Resource
    private IStaticService staticService;

    @Resource
    private IUserService userService;

    private static final Logger log = Logger.getLogger(RegisterAndLoginController.class);

    /**
     * 商品列表
     */
    @RequestMapping("/saleDetailList")
    public String saleDetail() {
        return "saleDetails";
    }

    /**
     * 刷新商品列表
     */
    @RequestMapping("/saleDetailList.do")
    public String saleDetailList(HttpServletRequest httpServletRequest, String goodsUserId) {
        List<GoodsInfo> goodsInfoList = null;
        HttpSession session = httpServletRequest.getSession();
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        Integer userId = userInfo.getUserId();
        try {
            if (userId == Integer.valueOf(goodsUserId)) {
                //刷新商品列表
                goodsInfoList = goodsService.queryGoodsInfoByUserId(userId);
            } else {
                //查找该店家的所有宝贝
                goodsInfoList = goodsService.queryGoodsInfoByUserId(Integer.valueOf(goodsUserId));
            }
            httpServletRequest.setAttribute("goodsInfoList", goodsInfoList);
            httpServletRequest.setAttribute("goodsUserId", goodsUserId);
        } catch (Exception e) {
            log.error("刷新商品列表失败", e);
        }
        return "saleDetails";
    }


    /**
     * 显示图片
     *
     * @param response
     * @param imgName
     */
    @RequestMapping("/showImage")
    public void showImage(HttpServletResponse response, String imgName) {
        InputStream inputStream = null;
        OutputStream writer = null;
        List<StaticData> staticDataList = null;
        try {
            //获取文件路径
            staticDataList = staticService.staticDataList(1, 1);
            String imaPath = staticDataList.get(0).getCodeName();
            inputStream = new FileInputStream(new File(imaPath + imgName));
            writer = response.getOutputStream();
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(buf)) != -1) {
                writer.write(buf, 0, len); //写
            }
            inputStream.close();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            }
        }
    }

    /*
     * 删除商品
     * */
    @RequestMapping("/deleteGoods")
    @ResponseBody
    public Map<String, Object> deleteGoodsInfo(HttpServletRequest httpServletRequest, GoodsInfo goodsInfo) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            goodsService.deleteGoods(goodsInfo);
            resultMap.put("status", 1);
            resultMap.put("message", "删除商品成功");
        } catch (Exception e) {
            resultMap.put("status", 0);
            resultMap.put("error", "删除商品失败");
            log.error("删除商品失败", e);
        }
        return resultMap;
    }

    /**
     * 查看商品详情
     */
    @RequestMapping("/viewProductDetails")
    public ModelAndView viewProductDetails(HttpServletRequest httpServletRequest, GoodsInfo goodsInfo) {
        List<GoodsInfo> goodsInfoList = null;
        List<GoodsInfo> otherGoodsInfoList = null;
        //获取session对象
        HttpSession session = httpServletRequest.getSession();
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        //用户没有登录时跳转到登录页面，登录了直接跳转到发布商品界面
        if (userInfo == null) {
            return new ModelAndView("login");
        }
        //查询需要购买的商品详情
        goodsInfo = goodsService.queryGoodsInfoByGoodsId(Integer.valueOf(goodsInfo.getGoodsId()));
        //查询相同类型的商品
        goodsInfoList = goodsService.queryRecommendGoodsInfo(goodsInfo.getGoodsType(), goodsInfo.getGoodsId(), userInfo.getUserId(), 5);
        //查看该卖家的其他宝贝
        otherGoodsInfoList = goodsService.queryRecommendGoodsInfo(goodsInfo.getGoodsId(), goodsInfo.getUserId(), 4);
        //查看该商品的卖家的信息
        UserInfo userInfo1 = userService.queryUserInfoById(goodsInfo.getUserId());
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("goodsInfo", goodsInfo);
        modelMap.put("userInfo1", userInfo1);
        modelMap.put("goodsInfoList", goodsInfoList);
        modelMap.put("otherGoodsInfoList", otherGoodsInfoList);
        return new ModelAndView("single", modelMap);
    }

}
