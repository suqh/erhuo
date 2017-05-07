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
    <%-- <script type="application/x-javascript"> addEventListener("load", function () {
         setTimeout(hideURLbar, 0);
     }, false);
     function hideURLbar() {
         window.scrollTo(0, 1);
     } </script>--%>
    <script src="/js/common/simpleCart.min.js"></script>
    <%--<link href="/css/memenu.css" rel="stylesheet" type="text/css" media="all"/>
    <script type="text/javascript" src="/js/common/memenu.js"></script>
    <script>$(document).ready(function () {
        $(".memenu").memenu();
    });</script>
    <!-- /start menu -->--%>
</head>
<body>
<div class="container">
    <div class="check-sec">
        <div class="col-md-3 cart-total">
            <a class="continue" href="/saleList/showSaleList">继续添加购物车</a>
            <%--            <div class="price-details">
                            <h3>价格详情</h3>
                            <span>总共</span>
                            <span class="total1">6200.00</span>

                            <span>Discount</span>
                             <span class="total1">10%(Festival Offer)</span>
                             <span>Delivery Charges</span>
                             <span class="total1">150.00</span>
                            <div class="clearfix"></div>
                        </div>--%>
            <ul class="total_price">
                <li class="last_price"><h4>总价￥</h4></li>
                <li class="last_price"><span id="totalPrice">${requestScope.totalPrice}</span></li>
            </ul>
            <div class="clearfix"></div>
            <div class="clearfix"></div>
            <c:if test="${shoppingCartInfoList.size() != 0}">
                <a class="order" href="/shoppingCart/confirmOrderPage?userId=${sessionScope.userInfo.userId}">马上下单</a>
            </c:if>
        </div>
        <div class="col-md-9 cart-items">
            <h1>我的购物车</h1>
            <%--<script>$(document).ready(function (c) {
                $('.close1').on('click', function (c) {
                    $('.cart-header').fadeOut('slow', function (c) {
                        $('.cart-header').remove();
                    });
                });
            });
            </script>--%>
                <c:forEach items="${shoppingCartInfoList}" var="shoppingCartInfo">
                        <div class="cart-header">
                            <div class="close1"
                                 onclick="removeShoppingCart(${shoppingCartInfo.goodsId},${sessionScope.userInfo.userId})"></div>
                            <input type="hidden" value="${shoppingCartInfo.goodsId}">
                            <div class="cart-sec simpleCart_shelfItem">
                                <div class="cart-item cyc">
                                    <img src="/saleDetail/showImage?imgName=${shoppingCartInfo.fileName}"
                                         class="img-responsive"
                                         style="height: 200px;width: 200px"/>
                                </div>
                                <div class="cart-item-info">
                                    <h3>
                                        <a href="/saleDetail/viewProductDetails?goodsId=${shoppingCartInfo.goodsId}">${shoppingCartInfo.shoppingCartName}</a>
                                    </h3><br><br>
                                    <ul class="qty">
                                        <li>
                                            <form action="/shoppingCart/editShoppingCart" id="orderOneForm">
                                                          <input type="hidden" id="goodsId"  name="goodsId" value="${shoppingCartInfo.goodsId}">
                                                          <input type="hidden" id="userId" name="userId" value="${sessionScope.userInfo.userId}">
                                                数量 : <input type="number" id="number" name="number" value="${shoppingCartInfo.shoppingCartNum}" min="1"  max="${shoppingCartInfo.maxGoodsNum}" onchange="editShoppingCart()">
                                            </form>
                                        </li>
                                    </ul>
                                    <div class="delivery">
                                        <p>价格 : ${shoppingCartInfo.goodsPrice}</p>
                                           <%-- <span>Delivered in 2-3 bussiness days</span>--%>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>
                                <div class="clearfix"></div>
                            </div>
                        </div>

                </c:forEach>
                <%--<input type="button" class="btn btn-info" value="结算" id="orderBtn" onclick="accounts()">--%>
            </form>
        </div>
        <div class="clearfix"></div>
    </div>
</div>
<script type="text/javascript" src="/js/shoppingCart.js"></script>
</body>
</html>
