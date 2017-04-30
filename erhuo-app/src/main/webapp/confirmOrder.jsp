<%--
  Created by IntelliJ IDEA.
  User: QH
  Date: 2017/4/28
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>购物车页面</title>
    <link href="/css/bootstrap.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="/css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <script src="/js/common/jquery.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content="Wedding Store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design"/>
    <script src="/js/common/simpleCart.min.js"></script>
</head>
<body>
<div class="container">
    <%--收获地址显示--%>
    <div class="address-box" style="margin-top: 10px">
        <h4 style="padding-left: 20px">收件人信息:</h4>
        <hr/>
        <div style="padding-left: 50px">
            <span>收货地址:</span>
            <input type="text" name="orderReceiveAddress" value="${sessionScope.userInfo.userAddress}" style="width: 300px" placeholder="收货地址">
            <span>收件人:</span>
            <input type="text" name="orderReceiveName" value="${sessionScope.userInfo.userName}" placeholder="收件人姓名">
            <span>联系方式:</span>
            <input type="text" name="orderReceivePhone" value="${sessionScope.userInfo.userPhone}" placeholder="联系方式">
            <%--购买者编号--%>
            <input type="hidden" name="orderUserId" value="${sessionScope.userInfo.userId}">
        </div>
    </div>
    <hr>
    <%--显示商品商品信息列表--%>
    <div class="check-sec">
        <div class="col-md-9 cart-items">
            <h1>确认订单</h1>
            <c:forEach items="${shoppingCartInfoList}" var="shoppingCartInfo">
                <div class="cart-header">
                    <div class="cart-sec simpleCart_shelfItem">
                        <div class="cart-item cyc">
                            <img src="/saleDetail/showImage?imgName=${shoppingCartInfo.fileName}"
                                 class="img-responsive"
                                 style="height: 80px;width: 80px"/>
                        </div>
                        <div class="cart-item-info">
                            <h3>
                                    ${shoppingCartInfo.shoppingCartName}
                            </h3>
                            <ul class="qty">
                                <li>
                                    数量 : ${shoppingCartInfo.shoppingCartNum}
                                </li>
                            </ul>
                            <div>
                                <p>小计 : ${shoppingCartInfo.goodsPrice}</p>
                                <div class="clearfix"></div>
                            </div>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </c:forEach>
            </form>
        </div>
        <div class="clearfix"></div>
        <div class="col-md-3 col-md-offset-6 cart-total">
            <a class="continue" href="/shoppingCart/shoppingCartPage?userId=${sessionScope.userInfo.userId}">返回购物车</a>
            <ul class="total_price">
                <li class="last_price"><h4>总价￥</h4></li>
                <li class="last_price"><span id="totalPrice">${requestScope.totalPrice}</span></li>
            </ul>
            <div class="clearfix"></div>
            <a class="order" id="confirm">确认付款</a>
        </div>
    </div>
</div>
<script type="text/javascript" src="/js/shoppingCart.js"></script>
</body>
</html>
