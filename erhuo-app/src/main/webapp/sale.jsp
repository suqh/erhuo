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
    <title>商品发布界面</title>
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
<form class="form-horizontal" role="form" enctype="multipart/form-data" id="tf" action="/page/sale.do" method="post">
    <input type="hidden" class="form-control" id="userId" name="userId" value="${sessionScope.userInfo.userId}"/>
    <h3 class="form-title col-sm-offset-2">发布商品</h3>
    <div class="form-group">
        <label class="col-sm-2 control-label">上传图片</label>
        <div class="col-sm-4">
            <input type="file" class="form-control" id="fileInput" name="file">
        </div>
    </div>
    <%--
     <label for="firstname" class="col-sm-2 control-label" style="margin-top: 70px">上传图片</label>
            <img type="file" src="/images/shangchuantupian.png" style="width: 150px;height: 150px;margin-left: 150px;margin-top: 40px"  class="img-circle" id="upload">
    --%>
    <div class="form-group">
        <label class="col-sm-2 control-label">商品名称</label>
        <div class="col-sm-4">
            <input type="text" class="form-control" id="goodsName" name="goodsName">
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">商品详情</label>
        <div class="col-sm-4">
            <textarea class="form-control" rows="3" id="goodsDesc" name="goodsDesc"></textarea>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">交易地点</label>
        <div class="col-sm-4">
            <input class="form-control" name="tradLocation" id="tradLocation"/>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">商品数量</label>
        <div class="col-sm-2">
            <input type="number" class="form-control" id="goodsNum" name="goodsNum" min="1" value="1">
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">价格</label>
        <div class="col-sm-2">
            <input class="form-control" placeholder="￥" name="goodsPrice" id="goodsPrice"/>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">分类</label>
        <div class="col-sm-2">
            <select class="form-control" name="goodsType"  id="goodsType">
                <option value="1">校园代步</option>
                <option value="2">电子设备</option>
                <option value="3">电器</option>
                <option value="4">电脑</option>
                <option value="5">运动健身</option>
                <option value="6">衣物伞冒</option>
                <option value="7">图书教材</option>
                <option value="8">其他</option>
            </select>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">联系方式</label>
        <div class="col-sm-2">
            <input class="form-control" placeholder="手机号码" name="phoneNum" id="phoneNum"/>
        </div>
    </div>
    <div class="form-group  inline">
        <div class="col-sm-offset-2 col-sm-2">
            <input type="button" class="btn btn-success" value="马上发布 " id="publishBtn"/>
        </div>
        <div class="col-sm-2">
            <input type="button" class="btn btn-info" value="取消发布 " id="cancelBtn"/>
        </div>
    </div>
</form>
<script type="text/javascript" src="/js/sale.js"></script>
</body>
</html>