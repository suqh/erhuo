package edu.xnxy.suqh.web.controller;

import edu.xnxy.suqh.entity.GoodsInfo;
import edu.xnxy.suqh.entity.ShoppingCartInfo;
import edu.xnxy.suqh.entity.UserInfo;
import edu.xnxy.suqh.service.IGoodsService;
import edu.xnxy.suqh.service.IReceiverAddressService;
import edu.xnxy.suqh.service.IShoppingCartService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * description:
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

    @Resource
    private IReceiverAddressService receiverAddressService;

    @RequestMapping("/shoppingCartPage")
    public String showShoppingCar(HttpServletRequest request, String userId) {
        //获取session对象
        HttpSession session = request.getSession();
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        //用户没有登录时跳转到登录页面，登录了直接跳转到我的购物车页面
        if (userInfo == null) {
            return "login";
        }
        List<ShoppingCartInfo> shoppingCartInfoList = shoppingCartService.queryShoppingCartByUserId(Integer.valueOf(userId));
        //计算商品总价
        float totalPrice = 0;
        for (ShoppingCartInfo shoppingCartInfo1 : shoppingCartInfoList) {
            totalPrice += shoppingCartInfo1.getGoodsPrice();
        }
        request.setAttribute("totalPrice", totalPrice);
        request.setAttribute("shoppingCartInfoList", shoppingCartInfoList);
        return "shoppingCart";
    }

    /**
     * 商品加入购物车
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
                shoppingCartInfo1.setMaxGoodsNum(goodsInfo.getGoodsNum() - num1);
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
     * 删除购物车中的一条记录
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


    /**
     * 编辑购物车中某条商品的数量，返回该条商品总价，和条数
     *
     * @param userId  用户编号
     * @param goodsId 商品编号
     * @param number  商品数量
     * @return
     */
    @RequestMapping("/editShoppingCart")
    public String editShoppingCart(Integer userId, Integer goodsId, Integer number, HttpServletRequest request) {
        try {
            //根据goodsIs获取商品单价
            GoodsInfo goodsInfo = goodsService.queryGoodsInfoByGoodsId(goodsId);
            //获取购物车中的商品信息
            ShoppingCartInfo shoppingCartInfo = shoppingCartService.queryShoppingCartInfoByGoodsIdAndUserId(goodsId, userId);
            //更新该条记录总价
            shoppingCartInfo.setGoodsPrice(goodsInfo.getGoodsPrice() * number);
            shoppingCartInfo.setShoppingCartNum(number);
            shoppingCartInfo.setMaxGoodsNum(goodsInfo.getGoodsNum());
            shoppingCartService.updateShoppingCartInfo(shoppingCartInfo);
            //重新获取购物车信息
            List<ShoppingCartInfo> shoppingCartInfoList = shoppingCartService.queryShoppingCartByUserId(userId);
            //计算商品总价
            float totalPrice = 0;
            for (ShoppingCartInfo shoppingCartInfo1 : shoppingCartInfoList) {
                totalPrice += shoppingCartInfo1.getGoodsPrice();
            }
            request.setAttribute("totalPrice", totalPrice);
            request.setAttribute("shoppingCartInfoList", shoppingCartInfoList);
        } catch (Exception e) {
            log.error("更新购物车失败", e);
        }
        return "shoppingCart";
    }

    /**
     * 确认下单页面
     *
     * @param userId 用户编号
     * @return
     */
    @RequestMapping("/confirmOrderPage")
    public String showConfirmOrderPage(Integer userId,HttpServletRequest request) {
        List<ShoppingCartInfo> shoppingCartInfoList = null;
        //获取用户购物车信息
        try {
            shoppingCartInfoList = shoppingCartService.queryShoppingCartByUserId(userId);
        } catch (Exception e) {
            log.error("获取用户购物车信息失败", e);
        }
        //计算商品总价
        float totalPrice = 0;
        for (ShoppingCartInfo shoppingCartInfo1 : shoppingCartInfoList) {
            totalPrice += shoppingCartInfo1.getGoodsPrice();
        }
        request.setAttribute("totalPrice", totalPrice);
        request.setAttribute("shoppingCartInfoList", shoppingCartInfoList);
        return "confirmOrder";
    }
}
