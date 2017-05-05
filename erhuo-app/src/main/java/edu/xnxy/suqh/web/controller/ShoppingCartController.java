package edu.xnxy.suqh.web.controller;

import edu.xnxy.suqh.entity.GoodsInfo;
import edu.xnxy.suqh.entity.ShoppingCartInfo;
import edu.xnxy.suqh.entity.UserInfo;
import edu.xnxy.suqh.service.IGoodsService;
import edu.xnxy.suqh.service.IShoppingCartService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: 购物车控制器
 *
 * @author suqh
 *         Created by suqh on 2017/4/28.
 */
@Controller
@RequestMapping("/shoppingCart")
public class ShoppingCartController {

    private static final Logger log = Logger.getLogger(ShoppingCartController.class);

    @Resource
    private IShoppingCartService shoppingCartService;

    @Resource
    private IGoodsService goodsService;

    /**
     * Description:显示购物车页面
     *
     * @param httpServletRequest
     * @param userId             用户编号
     * @return
     */
    @RequestMapping("/shoppingCartPage")
    public String showShoppingCar(HttpServletRequest httpServletRequest, String userId) {
        //获取session对象
        HttpSession session = httpServletRequest.getSession();
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        //用户没有登录时跳转到登录页面，登录了直接跳转到我的购物车页面
        if (userInfo == null) {
            return "login";
        }
        List<ShoppingCartInfo> shoppingCartInfoList = shoppingCartService.queryShoppingCartByUserId(Integer.valueOf(userId));
        httpServletRequest.setAttribute("shoppingCartInfoList", shoppingCartInfoList);
        return "shoppingCart";
    }

    /**
     * Description:添加商品到购物车
     *
     * @param shoppingCartInfo
     * @return
     */
    @RequestMapping("/addShoppingCart")
    @ResponseBody
    public Map<String, Object> addShoppingCart(ShoppingCartInfo shoppingCartInfo) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        ShoppingCartInfo shoppingCartInfo1 = null;
        GoodsInfo goodsInfo = null;
        try {
            //判断商品是否在购物车中存在，如果存在就更新，不存在直接添加购物车
            shoppingCartInfo1 = (ShoppingCartInfo) shoppingCartService.queryShoppingCartInfoByGoodsIdAndUserId(shoppingCartInfo.getGoodsId(), shoppingCartInfo.getUserId());
            goodsInfo = goodsService.queryGoodsInfoByGoodsId(shoppingCartInfo.getGoodsId());
            if (shoppingCartInfo1 == null) {
                shoppingCartService.addShoppingCart(shoppingCartInfo);
                Integer goodsNum = goodsInfo.getGoodsNum() - shoppingCartInfo.getShoppingCartNum();
                goodsInfo.setGoodsNum(goodsNum);
                goodsService.updateGoods(goodsInfo);
            } else {
                Integer total = 0;
                //购物车中商品的数量
                Integer num = shoppingCartInfo1.getShoppingCartNum();
                //新增商品的数量
                Integer num1 = shoppingCartInfo.getShoppingCartNum();
                //总共
                total = num + num1;

                //同一商品总共的价格
                Integer totalPrice = (shoppingCartInfo.getGoodsPrice()) * (total);

                //更新购物车
                shoppingCartInfo1.setShoppingCartNum(total);
                shoppingCartInfo1.setGoodsPrice(totalPrice);
                shoppingCartService.updateShoppingCartInfo(shoppingCartInfo1);

                //更新卖家商品数量
                Integer goodsNum = goodsInfo.getGoodsNum() - num1;
                goodsInfo.setGoodsNum(goodsNum);
                goodsService.updateGoods(goodsInfo);
            }
            resultMap.put("status", 1);
            resultMap.put("message", "添加购物车成功");
        } catch (Exception e) {
            resultMap.put("status", 0);
            resultMap.put("error", "添加购物车失败");
            log.error("添加购物车失败", e);
        }
        return resultMap;
    }

    /**
     * Description:删除购物车中的商品
     *
     * @param shoppingCartInfo
     * @return
     */
    @RequestMapping("/deleteShoppingCart")
    @ResponseBody
    public Map<String, Object> deleteShoppingCart(ShoppingCartInfo shoppingCartInfo/*,String userId*/) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            shoppingCartService.deleteShoppingCart(shoppingCartInfo);
            resultMap.put("status", 1);
            /*resultMap.put("userId",userId);*/
            resultMap.put("userId", shoppingCartInfo.getUserId());
            resultMap.put("message", "移除购物车成功");
        } catch (SQLException e) {
            resultMap.put("status", 0);
            resultMap.put("message", "移除购物车失败");
            log.error("移除购物车失败");
        }
        return resultMap;
    }
}
