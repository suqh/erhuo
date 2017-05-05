<%--
  Created by IntelliJ IDEA.
  User: QH
  Date: 2017/4/24
  Time: 12:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <c:if test="${sessionScope.userInfo.userId == goodsUserId}">
                <h1>上传商品列表</h1>
            </c:if>
            <c:if test="${sessionScope.userInfo.userId != goodsUserId}">
                <h1>他的全部宝贝</h1>
            </c:if>
            <c:forEach items="${requestScope.goodsInfoList}" var="goodsInfo">
                <div class="cart-header">
                    <c:if test="${sessionScope.userInfo.userId == goodsInfo.userId}">
                        <div class="close1" onclick="removeGoods(${goodsInfo.goodsId})"></div>
                    </c:if>
                    <div class="cart-sec simpleCart_shelfItem">
                        <input type="hidden" id="goodsId" value="${goodsInfo.goodsId}">
                        <div class="cart-item cyc">
                            <img src="/saleDetail/showImage?imgName=${goodsInfo.fileName}" class="img-responsive"
                                 style="width: 300px;height: 200px"/>
                        </div>
                        <div class="cart-item-info">
                            <h3>
                                <a href="/saleDetail/viewProductDetails?goodsId=${goodsInfo.goodsId}&userId=${sessionScope.userInfo.userId}">商品名称
                                    ：${goodsInfo.goodsName}</a>
                                <span>
                                类型 :
                                <c:if test="${goodsInfo.goodsType == 1}">校园代步</c:if>
                                <c:if test="${goodsInfo.goodsType == 2}">电子设备</c:if>
                                <c:if test="${goodsInfo.goodsType == 3}">电器</c:if>
                                <c:if test="${goodsInfo.goodsType == 4}">电脑</c:if>
                                <c:if test="${goodsInfo.goodsType == 5}">运动健身</c:if>
                                <c:if test="${goodsInfo.goodsType == 6}">衣物伞冒</c:if>
                                <c:if test="${goodsInfo.goodsType == 7}">图书教材</c:if>
                                <c:if test="${goodsInfo.goodsType == 8}">其他</c:if>
                            </span>
                            </h3>
                            <ul class="qty">
                                <li><p>数量 : ${goodsInfo.goodsNum}</p></li>
                            </ul>
                            商品描述 ：${goodsInfo.goodsDesc}
                            <div class="delivery">
                                <p>售价 : ${goodsInfo.goodsPrice}</p>
                                <span>交易地点：${goodsInfo.tradLocation}</span>
                                <div class="clearfix"></div>
                            </div>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </c:forEach>
            <input type="button" value="返回" class="btn btn-info" id="backBtn" onclick="back()">
        </div>
        <div class="clearfix"></div>
    </div>
</div>
<script type="text/javascript" src="/js/saleDetails.js"></script>
</body>
</html>