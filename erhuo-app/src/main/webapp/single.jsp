<%--
  Created by IntelliJ IDEA.
  User: QH
  Date: 2017/4/25
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>single</title>
    <link href="/css/bootstrap.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="/css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <script src="/js/common/jquery.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="/css/form.css" rel="stylesheet" type="text/css" media="all"/>
    <link rel="stylesheet" href="/css/flexslider.css" type="text/css" media="screen"/>
    <script src="/js/common/imagezoom.js"></script>
    <script defer src="/js/common/jquery.flexslider.js"></script>
    <%--<script>
        // Can also be used with $(document).ready()
        $(window).load(function () {
            $('.flexslider').flexslider({
                animation: "slide",
                controlNav: "thumbnails"
            });
        });
    </script>--%>
</head>
<body>
<div class="product">
    <div class="container">
        <div class="product-price1">
            <div class="top-sing">
                <div class="col-md-7 single-top">
                    <div class="flexslider">
                        <div class="thumb-image"><img
                                src="/saleDetail/showImage?imgName=${requestScope.goodsInfo.fileName}"
                                style="width: 400px;height: 400px" data-imagezoom="true" class="img-responsive" alt=""/>
                        </div>
                    </div>
                </div>
                <div class="col-md-5 single-top-in simpleCart_shelfItem" style="margin-top: 15px">
                    <div class="single-para">
                        <h4>${requestScope.goodsInfo.goodsName}</h4>
                        <h5 class="item_price">￥ ${requestScope.goodsInfo.goodsPrice}</h5>
                        <p class="para">商品描述 : ${requestScope.goodsInfo.goodsDesc}</p>
                        <div class="prdt-info-grid">
                            <ul>
                                <li>交易地点 : ${requestScope.goodsInfo.tradLocation}</li>
                                <li>商品类型 :
                                    <c:if test="${requestScope.goodsInfo.goodsType == 1}">校园代步</c:if>
                                    <c:if test="${requestScope.goodsInfo.goodsType == 2}">电子设备</c:if>
                                    <c:if test="${requestScope.goodsInfo.goodsType == 3}">电器</c:if>
                                    <c:if test="${requestScope.goodsInfo.goodsType == 4}">电脑</c:if>
                                    <c:if test="${requestScope.goodsInfo.goodsType == 5}">运动健身</c:if>
                                    <c:if test="${requestScope.goodsInfo.goodsType == 6}">衣物伞冒</c:if>
                                    <c:if test="${requestScope.goodsInfo.goodsType == 7}">图书教材</c:if>
                                    <c:if test="${requestScope.goodsInfo.goodsType == 8}">其他</c:if>
                                </li>
                                <li>联系方式 : ${requestScope.goodsInfo.phoneNum}</li>
                                <li>
                                    商品数量 :
                                    <%--<c:if test="${requestScope.goodsInfo.goodsNum == 0}">
                                        <input type="number" value="0" min="0" max="${requestScope.goodsInfo.goodsNum}" id="goodsNum" name="goodsNum">
                                    </c:if>
                                    <input type="number" value="1" min="1" max="${requestScope.goodsInfo.goodsNum}" id="goodsNum" name="goodsNum">--%>
                                    <c:choose>
                                        <c:when test="${requestScope.goodsInfo.goodsNum == 0}">
                                            <input type="number" value="0" min="0" max="${requestScope.goodsInfo.goodsNum}" id="goodsNum" name="goodsNum">
                                        </c:when>
                                        <c:otherwise>
                                            <input type="number" value="1" min="1" max="${requestScope.goodsInfo.goodsNum}" id="goodsNum" name="goodsNum">
                                        </c:otherwise>
                                    </c:choose>
                                </li>
                            </ul>
                        </div>
                        <c:choose>
                            <c:when test="${sessionScope.userInfo.userId == requestScope.goodsInfo.userId}">
                                <a href="/saleDetail/saleDetailList.do" class="add-cart item_add">返回商品列表</a>
                                <a href="/modify/modifyGoodsInfo?goodsId=${requestScope.goodsInfo.goodsId}"
                                   class="add-cart item_add">修改商品信息</a>
                            </c:when>
                            <c:when test="${sessionScope.userInfo.isManager == 1}">
                                <a href="/saleList/showSaleList" class="add-cart item_add">继续浏览</a>
                                <input type="button" class="btn btn-info" value="加入购物车" id="addCartBtn"/>
                                <input type="button" class="btn btn-info" value="删除该商品" id="deleteBtn"/>
                            </c:when>
                            <c:otherwise>
                                <a href="/saleList/showSaleList" class="add-cart item_add">继续浏览</a>
                                <input type="button" class="btn btn-primary" value="加入购物车" id="addCartBtn"/>
                            </c:otherwise>
                        </c:choose>
                        <input type="hidden" name="shoppingCartName" value="${requestScope.goodsInfo.goodsName}"
                               id="shoppingCartName"/>
                        <input type="hidden" name="fileName" value="${requestScope.goodsInfo.fileName}"
                               id="fileName"/>
                        <input type="hidden" name="filePath" value="${requestScope.goodsInfo.filePath}"
                               id="filePath"/>
                        <input type="hidden" name="maxGoodsNum" value="${requestScope.goodsInfo.goodsNum}"
                               id="maxGoodsNum"/>
                        <input type="hidden" name="goodsId" value="${requestScope.goodsInfo.goodsId}"
                               id="goodsId"/>
                        <input type="hidden" name="userId" value="${sessionScope.userInfo.userId}" id="userId"/>
                        <input type="hidden" name="goodsPrice" value="${requestScope.goodsInfo.goodsPrice}" id="goodsPrice"/>
                    </div>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="/js/single.js"></script>
</body>
</html>
