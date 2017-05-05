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
    <link href="/css/test.css" rel="stylesheet" type="text/css" media="all"/>
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
        <div class="box-left">
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
                      <%--              <c:if test="${requestScope.goodsInfo.goodsNum == 0}">
                                        <input type="number" value="0" min="0" max="${requestScope.goodsInfo.goodsNum}" id="goodsNum" name="goodsNum">
                                    </c:if>
                                    <input type="number" value="1" min="1" max="${requestScope.goodsInfo.goodsNum}" id="goodsNum" name="goodsNum">--%>
                                    <c:choose>
                                        <c:when test="${requestScope.goodsInfo.goodsNum == 0}">
                                            <input type="number" value="0" min="0"
                                                   max="${requestScope.goodsInfo.goodsNum}" id="goodsNum"
                                                   name="goodsNum">
                                        </c:when>
                                        <c:otherwise>
                                            <input type="number" value="1" min="1"
                                                   max="${requestScope.goodsInfo.goodsNum}" id="goodsNum"
                                                   name="goodsNum">
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
                                <%--<a href="/saleList/showSaleList" class="add-cart item_add">继续浏览</a>--%>
                                <input type="button" class="btn btn-info" value="继续浏览" id="continueBtn">&nbsp;
                                <input type="button" class="btn btn-info" value="加入购物车" id="addCartBtn"/>&nbsp;
                                <input type="button" class="btn btn-info" value="删除该商品" id="deleteBtn"/>
                            </c:when>
                            <c:otherwise>
                                <%--<a href="/saleList/showSaleList" class="add-cart item_add">继续浏览</a>--%>
                                <input type="button" class="btn btn-info" value="继续浏览" id="continueBtn">&nbsp;&nbsp;
                                <input type="button" class="btn btn-info" value="加入购物车" id="addCartBtn"/>
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
                        <input type="hidden" name="goodsPrice" value="${requestScope.goodsInfo.goodsPrice}"
                               id="goodsPrice"/>
                    </div>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
        <div class="box-right">
            <div class="personal">
                <div class="personal_jieshao">
                    <ul class="personal_biaoqian clearfix">
                    </ul>
                    <div class="personal_touxiang" data-adjust="adjust">
                        <img src="/saleDetail/showImage?imgName=imageUploadgz2.jpg" alt=""
                             style="width: 166px;height: 194px"/>
                    </div>
                    <p class="personal_name">技术实力</p>
                    <p class="personal_chengjiu">她加入转转332天，常居长沙雨花</p>
                    <div class="zhima">
                        <span>查看卖家芝麻信用</span>
                    </div>
                </div>
                <div class="transaction">
                    <h3 class="person_title">她的交易</h3>
                    <span class="moredeal deal">查看详细信息<span class="deal-right"><i class="right-arrow1"></i><i
                            class="right-arrow2"></i></span></span>
                    <ul class="contentdeal deal">
                        <li>
                            <span class="numdeal">4</span>
                            <span>成交宝贝</span>
                        </li>
                        <li>
                            <span class="numdeal">2</span>
                            <span>交易评价</span>
                        </li>
                    </ul>
                </div>
                <div class="personal_salebaby">
                    <h3 class="person_title">她的宝贝(9)</h3>
                    <ul class="salebaby_list">
                        <li>
                            <a href="http://zhuanzhuan.58.com/detail/857125443561734153z.shtml" target="_blank">
                                <div data-adjust="adjust" class="plist_img">
                                    <img src="/saleDetail/showImage?imgName=imageUploadgz2.jpg" alt=""
                                         style="width: 166px;height: 194px"/>
                                </div>
                                <span class="plist_price"><i>100</i>元</span>
                            </a>
                        </li>
                        <li>
                            <a href="http://zhuanzhuan.58.com/detail/854910100067991558z.shtml" target="_blank">
                                <div data-adjust="adjust" class="plist_img">
                                    <img src="/saleDetail/showImage?imgName=imageUploadgz2.jpg" alt=""
                                         style="width: 166px;height: 194px"/>
                                </div>
                                <span class="plist_price"><i>38</i>元</span>
                            </a>
                        </li>
                    </ul>
                    <div class="salebaby_more">点击查看他的全部宝贝</div>
                </div>
            </div>
        </div>
        <div class="bottom-prdt">
            <ul class="d-main-tab">
               <li style="list-style-type: none"><span style="font-family: 微软雅黑;font-size: 20px;color: #808080;">相似商品推荐</span></li>
            </ul>
            <div class="btm-grid-sec">
                <c:forEach items="${requestScope.goodsInfoList}" var="item">
                    <div class="col-md-2 btm-grid">
                        <a href="/saleDetail/viewProductDetails?goodsId=${item.goodsId}&goodsType=${item.goodsType}">
                            <img src="/saleDetail/showImage?imgName=${item.fileName}" alt=""
                                 style="width: 166px;height: 194px"/>
                            <h4>${item.goodsName}</h4>
                            <span>￥${item.goodsPrice}</span></a>
                    </div>
                </c:forEach>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="/js/single.js"></script>
</body>
</html>