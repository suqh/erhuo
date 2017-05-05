package edu.xnxy.suqh.web.controller;

import edu.xnxy.suqh.entity.GoodsInfo;
import edu.xnxy.suqh.entity.StaticData;
import edu.xnxy.suqh.entity.UserInfo;
import edu.xnxy.suqh.service.IGoodsService;
import edu.xnxy.suqh.service.IStaticService;
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
 * description:商品处理控制器
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

    private static final Logger log = Logger.getLogger(RegisterAndLoginController.class);

    /**
     * Description:显示商品列表页面
     *
     * @return
     */
    @RequestMapping("/saleDetailList")
    public String saleDetail() {
        return "saleDetails";
    }

    /**
     * Description:显示商品列表
     *
     * @param httpServletRequest
     * @return
     */
    @RequestMapping("/saleDetailList.do")
    public String saleDetailList(HttpServletRequest httpServletRequest) {
        List<GoodsInfo> goodsInfoList = null;
        HttpSession session = httpServletRequest.getSession();
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        Integer userId = userInfo.getUserId();
        try {
            goodsInfoList = goodsService.queryGoodsInfoByUserId(userId);
            httpServletRequest.setAttribute("goodsInfoList", goodsInfoList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "saleDetails";
    }


    /**
     * Description:显示图片
     *
     * @param response
     * @param imgName  图片名称
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

    /**
     * Description:删除商品信息
     *
     * @param httpServletRequest
     * @param goodsInfo
     * @return
     */
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
     * Description:显示商品详情
     *
     * @param httpServletRequest
     * @param goodsInfo
     * @return
     */
    @RequestMapping("/viewProductDetails")
    public ModelAndView viewProductDetails(HttpServletRequest httpServletRequest, GoodsInfo goodsInfo) {

        //获取session对象
        HttpSession session = httpServletRequest.getSession();
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        //用户没有登录时跳转到登录页面，登录了直接跳转到发布商品界面
        if (userInfo == null) {
            return new ModelAndView("login");
        }

        goodsInfo = goodsService.queryGoodsInfoByGoodsId(Integer.valueOf(goodsInfo.getGoodsId()));
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("goodsInfo", goodsInfo);
        return new ModelAndView("single", modelMap);
    }

}
