package edu.xnxy.suqh.entity;

import java.util.Date;

/**
 * description:订购历史实体类
 *
 * @author suqh
 *         Created by suqh on 2017/4/30.
 */
public class OrderInfo {

    /**
     * 订购历史id
     */
    private Integer orderId;

    /**
     * 订购商品id
     */
    private Integer orderGoodsId;

    /**
     * 订购人id
     */
    private Integer orderUserId;

    /**
     * 订购商品名
     */
    private String orderGoodsName;

    /**
     * 订购商品数量
     */
    private Integer orderGoodsNum;

    /**
     * 订单总价
     */
    private Integer orderTotalPrice;

    /**
     * 收货人姓名
     */
    private String orderReceiveName;

    /**
     * 收货地址
     */
    private String orderReceiveAddress;

    /**
     * 收货人联系方式
     */
    private String orderReceivePhone;

    /**
     * 订购时间
     */
    private Date orderDate;

    /**
     * 图片名称
     */
    private String imageName;

    /*
    * 扩展字段ext1
    * */
    private Integer ext1;

    /*
    * 扩展字段ext2
    * */
    private String ext2;

    /*
    * 扩展字段ext3
    * */
    private String ext3;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderGoodsId() {
        return orderGoodsId;
    }

    public void setOrderGoodsId(Integer orderGoodsId) {
        this.orderGoodsId = orderGoodsId;
    }

    public Integer getOrderUserId() {
        return orderUserId;
    }

    public void setOrderUserId(Integer orderUserId) {
        this.orderUserId = orderUserId;
    }

    public String getOrderGoodsName() {
        return orderGoodsName;
    }

    public void setOrderGoodsName(String orderGoodsName) {
        this.orderGoodsName = orderGoodsName;
    }

    public Integer getOrderGoodsNum() {
        return orderGoodsNum;
    }

    public void setOrderGoodsNum(Integer orderGoodsNum) {
        this.orderGoodsNum = orderGoodsNum;
    }

    public Integer getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(Integer orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }

    public String getOrderReceiveName() {
        return orderReceiveName;
    }

    public void setOrderReceiveName(String orderReceiveName) {
        this.orderReceiveName = orderReceiveName;
    }

    public String getOrderReceiveAddress() {
        return orderReceiveAddress;
    }

    public void setOrderReceiveAddress(String orderReceiveAddress) {
        this.orderReceiveAddress = orderReceiveAddress;
    }

    public String getOrderReceivePhone() {
        return orderReceivePhone;
    }

    public void setOrderReceivePhone(String orderReceivePhone) {
        this.orderReceivePhone = orderReceivePhone;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Integer getExt1() {
        return ext1;
    }

    public void setExt1(Integer ext1) {
        this.ext1 = ext1;
    }

    public String getExt2() {
        return ext2;
    }

    public void setExt2(String ext2) {
        this.ext2 = ext2;
    }

    public String getExt3() {
        return ext3;
    }

    public void setExt3(String ext3) {
        this.ext3 = ext3;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "orderId=" + orderId +
                ", orderGoodsId=" + orderGoodsId +
                ", orderUserId=" + orderUserId +
                ", orderGoodsName='" + orderGoodsName + '\'' +
                ", orderGoodsNum=" + orderGoodsNum +
                ", orderTotalPrice=" + orderTotalPrice +
                ", orderReceiveName='" + orderReceiveName + '\'' +
                ", orderReceiveAddress='" + orderReceiveAddress + '\'' +
                ", orderReceivePhone='" + orderReceivePhone + '\'' +
                ", orderDate=" + orderDate +
                ", imageName='" + imageName + '\'' +
                ", ext1=" + ext1 +
                ", ext2='" + ext2 + '\'' +
                ", ext3='" + ext3 + '\'' +
                '}';
    }
}
