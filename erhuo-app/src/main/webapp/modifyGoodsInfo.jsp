<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: QH
  Date: 2017/4/19
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>修改商品信息界面</title>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="//cdn.bootcss.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="/js/common/jquery.min.js"></script>
    <script src="/js/common/bootstrap.min.js"></script>
    <style type="text/css">
        .form {
            background: rgba(255, 255, 255, 0.2);
            width: 400px;
            margin: 100px auto
        }
    </style>
</head>
<body>
<div class="form-horizontal" role="form" enctype="multipart/form-data" id="tf" action="/page/sale.do" method="post">
    <input type="hidden" class="form-control" id="fileName" name="fileName" value="${requestScope.goodsInfo.fileName}"/>
    <input type="hidden" class="form-control" id="filePath" name="filePath" value="${requestScope.goodsInfo.filePath}"/>
    <input type="hidden" class="form-control" id="goodsId" name="goodsId" value="${requestScope.goodsInfo.goodsId}">
    <input type="hidden" class="form-control" id="userId" name="userId" value="${sessionScope.userInfo.userId}">
    <h3 class="form-title col-sm-offset-1">修改商品信息</h3>
    <img src="/saleDetail/showImage?imgName=${requestScope.goodsInfo.fileName}"
         style="width: 150px;height: 150px;margin-left: 350px" id="upload">
    <div class="form-group" style="margin-top: 10px">
        <label class="col-sm-2 control-label">商品名称</label>
        <div class="col-sm-4">
            <input type="text" class="form-control" id="goodsName" name="goodsName"
                   value="${requestScope.goodsInfo.goodsName}">
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">商品详情</label>
        <div class="col-sm-4">
            <textarea class="form-control" rows="3" id="goodsDesc" name="goodsDesc"
            >${requestScope.goodsInfo.goodsDesc}</textarea>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">交易地点</label>
        <div class="col-sm-4">
            <input class="form-control" name="tradLocation" id="tradLocation"
                   value="${requestScope.goodsInfo.tradLocation}"/>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">商品数量</label>
        <div class="col-sm-2">
            <input type="number" class="form-control" id="goodsNum" name="goodsNum"
                   value="${requestScope.goodsInfo.goodsNum}" min="1">
            <%--<input type="number" class="form-control" id="goodsNum" name="goodsNum" min="1" value="1">--%>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">价格</label>
        <div class="col-sm-2">
            <input class="form-control" placeholder="￥" name="goodsPrice" id="goodsPrice"
                   value="${requestScope.goodsInfo.goodsPrice}"/>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">分类</label>
        <div class="col-sm-2">
            <select class="form-control" name="goodsType" id="goodsType">
                <c:forEach items="${applicationScope.goodsTypeList}"  var="item">
                    <c:choose>
                        <c:when test="${requestScope.goodsInfo.goodsType == item.codeId}">
                            <option value="${item.codeId}" selected="selected">${item.codeName}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${item.codeId}">${item.codeName}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">联系方式</label>
        <div class="col-sm-2">
            <input class="form-control" placeholder="手机号码" name="phoneNum" id="phoneNum"
                   value="${requestScope.goodsInfo.phoneNum}"/>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <input type="button" class="btn btn-primary btn-lg col-md-3" value="修改完成 " id="modifyBtn"/>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="/js/modifyGoodsInfo.js"></script>
</html>