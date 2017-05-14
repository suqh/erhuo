<%--
  Created by IntelliJ IDEA.
  User: QH
  Date: 2017/4/24
  Time: 12:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>商品列表</title>
    <link href="/css/bootstrap.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="/css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <script src="/js/common/jquery.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content="Wedding Store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template,
    Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design"/>
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);
    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
    <script src="/js/common/simpleCart.min.js"></script>
    <link href="/css/memenu.css" rel="stylesheet" type="text/css" media="all"/>
    <script type="text/javascript" src="/js/common/memenu.js"></script>
    <script>$(document).ready(function () {
        $(".memenu").memenu();
    });</script>
</head>
<body>
<!-- check out -->
<div class="container">
    <div class="check-sec">
        <div class="col-md-9 cart-items">
            <h1>购买记录</h1>
            <c:forEach items="${requestScope.orderInfoList}" var="orderInfo">
                <div class="cart-header">
                    <div class="close1" onclick="removeGoods(${orderInfo.orderUserId},${orderInfo.orderId})"></div>
                    <div class="cart-sec simpleCart_shelfItem">
                        <input type="hidden" id="goodsId" value="${orderInfo.orderGoodsId}">
                        <div class="cart-item cyc">
                            <img src="/saleDetail/showImage?imgName=${orderInfo.imageName}" class="img-responsive"
                                 style="width: 300px;height: 200px"/>
                        </div>
                        <div class="cart-item-info">
                            <h3>
                                <a href="/saleDetail/viewProductDetails?goodsId=${orderInfo.orderGoodsId}&userId=${sessionScope.userInfo.userId}">商品名称
                                    ：${orderInfo.orderGoodsName}</a>
                            </h3>
                            <br>
                            <ul class="qty">
                                <li>
                                    <p>订单号 : ${orderInfo.orderId}</p>
                                    <p>数量 : ${orderInfo.orderGoodsNum}</p>
                                    <p>收件人 : ${orderInfo.orderReceiveName}</p>
                                    <p>收件人联系方式 : ${orderInfo.orderReceivePhone}</p>
                                    <p> 收件地址: ${orderInfo.orderReceiveAddress}</p>
                                </li>
                            </ul>
                                <%--     商品描述 ：${orderInfo.goodsDesc}--%>
                            <div class="delivery">
                                <p>小计 : ${orderInfo.orderTotalPrice}</p>
                                <span>时间：<fmt:formatDate value="${orderInfo.orderDate}" pattern="yyyy-MM-dd"></fmt:formatDate></span>
                                <div class="clearfix"></div>
                            </div>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </c:forEach>
            <input type="button" value="返回首页" class="btn btn-info" id="backBtn" onclick="back()">
        </div>
        <div class="clearfix"></div>
    </div>
</div>
<script type="text/javascript" src="/js/orderList.js"></script>
</body>
</html>