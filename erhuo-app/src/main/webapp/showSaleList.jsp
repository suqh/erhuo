<%--
  Created by IntelliJ IDEA.
  User: QH
  Date: 2017/4/20
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>闲置物品交易首页</title>
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
<!--header-->
<script src="/js/common/responsiveslides.min.js"></script>
<script>
    $(function () {
        $("#slider").responsiveSlides({
            auto: true,
            nav: true,
            speed: 500,
            namespace: "callbacks",
            pager: false,
        });
    });
</script>

<div class="header-top">
    <div class="header-bottom">
        <div class="logo">
            <h1><a href="index.html">二货</a></h1>
        </div>
        <div class="top-nav">
            <ul class="memenu skyblue">
                <li class="active"><a href="/saleList/showSaleList">首页</a></li>
                <li class="grid"><a href="/page/salePage">我要出售</a></li>
                <li class="grid"><a href="/saleDetail/saleDetailList.do?goodsUserId=${sessionScope.userInfo.userId}">发布的商品</a></li>
                <li class="grid"><a href="/shoppingCart/shoppingCartPage?userId=${sessionScope.userInfo.userId}">购物车</a>
                </li>
                <li class="grid"><a href="/order/orderList?userId=${sessionScope.userInfo.userId}">购买记录</a></li>
                <li class="grid"><a href="/question/testPage?userId=${sessionScope.userInfo.userId}">销售情况</a></li>
                <li class="grid"><a href="/question/questionPage">常见问题</a></li>
            </ul>
        </div>
        <div class="cart box_1">
            <p>
                <c:if test="${sessionScope.userInfo.userName != null}">
                    <a href="/registerAndLogin/editPage?userId=${sessionScope.userInfo.userId}"
                       class="simpleCart_empty">您好，${sessionScope.userInfo.userName}</a>&nbsp;&nbsp;
                    <a href="/loginOut/loginOut">退出</a>
                </c:if>
                <c:if test="${sessionScope.userInfo.userName == null}">
                    <a href="/login.jsp" class="simpleCart_empty">您好，请先登录</a>
                </c:if>

            </p>
            <div class="clearfix"></div>
            <div class="clearfix"></div>
        </div>
        <div class="clearfix"></div>
        <div class="clearfix"></div>
    </div>
    <br/><br/>
    <div>
        <form class="form-inline" role="form" id="tf" action="/saleList/indexQueryGoods" method="post">
            <input type="hidden" name="userId" value="${sessionScope.userInfo.userId}"/>
            <div class="form-group" style="margin-top: 18px;margin-left: 300px">
                <div class="col-sm-2 ">
                    <input type="text" class="form-control" placeholder="请输入商品名称" name="goodsName"
                           value="${requestScope.goodsName}"/>
                </div>
                <div class="col-sm-2  col-sm-offset-6">
                    <input type="button" class="btn btn-info" value="搜索" id="searchBtn"/>
                </div>
            </div>
            <div class="form-group">
                <label class="">类型 :</label>
                <select class="form-control" name="goodsType">
                    <c:forEach items="${goodsTypeList}" var="item">
                        <c:choose>
                            <c:when test="${item.codeId == requestScope.goodsType}">
                                <option value="${item.codeId}" selected="selected">${item.codeName}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${item.codeId}">${item.codeName}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label class="">价格 :</label>
                <input type="text" class="form-control"
                       placeholder="￥" name="minGoodsPrice" value="${requestScope.minGoodsPrice}">
                —
                <input type="text" class=" form-control"
                       placeholder="￥" name="maxGoodsPrice" value="${requestScope.maxGoodsPrice}">
            </div>
        </form>
    </div>
    <script src="/js/common/bootstrap.js"></script>
    <div class="items">
        <div class="container">
            <div class="items-sec">
                <c:forEach items="${requestScope.goodsInfoList}" var="goodsInfo">
                    <input type="hidden" id="goodsName" value="${goodsInfo.goodsName}">
                    <input type="hidden" id="goodsType" value="${goodsInfo.goodsType}">
                    <input type="hidden" id="goodsPrice" value="${goodsInfo.goodsPrice}">

                    <div class="col-md-3 feature-grid">
                        <a href="/saleDetail/viewProductDetails?goodsId=${goodsInfo.goodsId}&goodsType=${goodsInfo.goodsType}"><img
                                src="/saleDetail/showImage?imgName=${goodsInfo.fileName}" alt=""
                                style="width: 245px;height: 200px"/>
                            <div class="arrival-info">
                                <h4>${goodsInfo.goodsName}</h4>
                                <div><span>￥ ${goodsInfo.goodsPrice}</span>
                                    <c:if test="${goodsInfo.goodsNum ==0}">
                                      <span style="margin-left: 95px;color: red;font-family: '微软雅黑'">无货</span>
                                    </c:if>
                                </div>
                            </div>
                            <div class="viw">
                                <a href="/saleDetail/viewProductDetails?goodsId=${goodsInfo.goodsId}&goodsType=${goodsInfo.goodsType}"><span
                                        class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>View</a>
                            </div>
                        </a>
                    </div>
                </c:forEach>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="/js/showSaleList.js"></script>
</body>
</html>
