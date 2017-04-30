package edu.xnxy.suqh.web.controller;

import edu.xnxy.suqh.entity.OrderInfo;
import edu.xnxy.suqh.entity.ShoppingCartInfo;
import edu.xnxy.suqh.entity.UserInfo;
import edu.xnxy.suqh.service.IOrderInfoService;
import edu.xnxy.suqh.service.IShoppingCartService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * description:订单处理Controller
 *
 * @author suqh
 *         Created by suqh on 2017/4/30.
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    private static final Logger log = Logger.getLogger(OrderController.class);

    @Resource
    private IOrderInfoService orderInfoService;

    @Resource
    private IShoppingCartService shoppingCartService;

    /**
     * 通过用户编号获取订单列表，并将结果返回到我的订单记录页面
     *
     * @param userId
     * @return
     */
    @RequestMapping("/orderListPage")
    public String showOrderListPage(Integer userId) {
        return "";
    }

    /**
     * 确认下单
     *
     * @param orderUserId         用户编号
     * @param orderReceiveName    收件人
     * @param orderReceiveAddress 收货地址
     * @param orderReceivePhone   收件人联系方式
     * @return
     */
    @RequestMapping("/confirmOrder")
    @ResponseBody
    public Map<String, Object> confirmOrder(Integer orderUserId, String orderReceiveName, String orderReceiveAddress, String orderReceivePhone) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            //通过用户编号查询购物车信息
            List<ShoppingCartInfo> shoppingCartInfoList = shoppingCartService.queryShoppingCartByUserId(orderUserId);
            Date currentDate = new Date();
            OrderInfo orderInfo = new OrderInfo();
            for (ShoppingCartInfo shoppingCartInfo : shoppingCartInfoList) {
                //设置购买记录信息
                orderInfo.setOrderUserId(orderUserId);
                orderInfo.setOrderReceiveName(orderReceiveName);
                orderInfo.setOrderReceiveAddress(orderReceiveAddress);
                orderInfo.setOrderReceivePhone(orderReceivePhone);
                orderInfo.setOrderDate(currentDate);
                orderInfo.setOrderGoodsId(shoppingCartInfo.getGoodsId());
                orderInfo.setOrderGoodsNum(shoppingCartInfo.getShoppingCartNum());
                orderInfo.setOrderGoodsName(shoppingCartInfo.getShoppingCartName());
                orderInfo.setOrderTotalPrice(shoppingCartInfo.getGoodsPrice());
                orderInfo.setImageName(shoppingCartInfo.getFileName());
                orderInfoService.addOrderInfo(orderInfo);
            }
            //清空购物车
            shoppingCartService.deleteShoppingCartByUserId(orderUserId);
            resultMap.put("status", 1);
            resultMap.put("message", "购买成功");
        } catch (Exception e) {
            log.error("购买失败", e);
            resultMap.put("status", 0);
            resultMap.put("error", "购买失败");
        }
        return resultMap;
    }

    /**
     * 显示订单记录
     *
     * @param userId 用户编号
     * @return
     */
    @RequestMapping("/orderList")
    public ModelAndView orderList(Integer userId, HttpSession session) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        List<OrderInfo> orderInfoList = null;
        String view = "login";
        try {
            //获取session对象
            UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
            //用户没有登录时跳转到登录页面，登录了直接跳转到我的购物车页面
            if (userInfo != null) {
                orderInfoList = orderInfoService.queryOrderInfoById(userId);
                view = "orderList";
                resultMap.put("status", 0);
                resultMap.put("orderInfoList", orderInfoList);
            }
        } catch (Exception e) {
            log.error("获取订单历史异常", e);
            resultMap.put("status", 0);
            resultMap.put("error", "获取订单历史失败");
        }
        return new ModelAndView(view, resultMap);
    }

    /**
     * 删除一条订单历史记录
     *
     * @param userId  用户编号
     * @param orderId 订单编号
     * @return
     */
    @RequestMapping("/deleteOrderInfo")
    @ResponseBody
    public Map<String, Object> deleteOrderInfo(Integer userId, Integer orderId) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            orderInfoService.deleteOrderInfo(userId, orderId);
            resultMap.put("status", 1);
            resultMap.put("message", "删除成功订单" + orderId + "成功");
        } catch (Exception e) {
            log.error("删除成功订单" + orderId + "失败", e);
            resultMap.put("status", 0);
            resultMap.put("error", "删除成功订单" + orderId + "失败");
        }
        return resultMap;
    }

}
