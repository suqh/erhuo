package edu.xnxy.suqh.web.controller;

import edu.xnxy.suqh.entity.GoodsInfo;
import edu.xnxy.suqh.service.IGoodsService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: 商品信息控制器
 *
 * @author suqh
 *         Created by suqh on 2017/4/25.
 */
@Controller
@RequestMapping("/modify")
public class ModifyGoodsController {

    private static final Logger log = Logger.getLogger(ModifyGoodsController.class);

    @Resource
    private IGoodsService goodsService;

    /**
     * Description:跳转到修改山品页面
     *
     * @param httpServletRequest
     * @param goodsId            商品编号
     * @return
     */
    @RequestMapping("/modifyGoodsInfo")
    public String modifyGoods(HttpServletRequest httpServletRequest, String goodsId) {
        GoodsInfo goodsInfo = goodsService.queryGoodsInfoByGoodsId(Integer.valueOf(goodsId));
        httpServletRequest.setAttribute("goodsInfo", goodsInfo);
        return "modifyGoodsInfo";
    }

    /**
     * Description:修改商品信息
     *
     * @param httpServletRequest
     * @param goodsInfo
     * @return
     */
    @RequestMapping("/modifyGoodsInfo.do")
    @ResponseBody
    public Map<String, Object> modifyGoodsInfo(HttpServletRequest httpServletRequest, GoodsInfo goodsInfo) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            goodsService.updateGoods(goodsInfo);
            resultMap.put("status", 1);
            resultMap.put("goodsId", goodsInfo.getGoodsId());
            resultMap.put("message", "修改商品信息成功");
        } catch (Exception e) {
            resultMap.put("status", 0);
            resultMap.put("message", "修改商品信息失败");
            log.error("修改商品信息失败", e);
        }
        return resultMap;
    }
}
