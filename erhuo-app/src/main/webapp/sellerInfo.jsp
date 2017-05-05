<%--
  Created by IntelliJ IDEA.
  User: QH
  Date: 2017/4/15
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>卖家信息界面</title>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/test.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="//cdn.bootcss.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="/js/common/jquery.min.js"></script>
    <script src="/js/common/bootstrap.min.js"></script>
    <style type="text/css">
        .form {
            background: rgba(255, 255, 255, 0.2);
            width: 400px;
            margin: 100px auto
        }

        .fa {
            display: inline-block;
            top: 27px;
            left: 6px;
            position: relative;
            color: #ccc;
        }

        input[type="text"], input[type="password"] {
            padding-left: 26px;
        }

        .checkbox {
            padding-left: 21px;
        }
    </style>
</head>
<body>
<!--
    基础知识：
    网格系统:通过行和列布局
    行必须放在container内
    手机用col-xs-*
    平板用col-sm-*
    笔记本或普通台式电脑用col-md-*
    大型设备台式电脑用col-lg-*
    为了兼容多个设备，可以用多个col-*-*来控制；
-->
<div>
    <div class="form row">
        <form class="form-horizontal col-sm-offset-3 col-md-offset-3" id="register_form">
            <h3 class="form-title" style="margin-left: 38px">卖家详细信息</h3>
            <div class="col-sm-9 col-md-9">
                <input type="hidden" name="userId" value="${requestScope.userInfo.userId}" id="userId"/>
                <div class="form-group">
                    <div class="personal_touxiang" data-adjust="adjust">
                        <img src="/images/乔巴.png">
                    </div>
                </div>
                <div class="form-group">
                    <i class="fa fa-user fa-lg"></i>
                    <input class="form-control required" type="text" name="userName" placeholder="请输入姓名" autofocus="autofocus"
                           value="${requestScope.userInfo.userName}" disabled="disabled" id="userName" disabled="disabled"/>
                </div>
                <div class="form-group" >
                    <div class="checkbox" id="userGender">
                        <label for="userGender" class="">性别 :</label>
                        <c:if test="${requestScope.userInfo.userGender  == 0}">
                            <label><input type="radio" name="userGender" value="0" checked="checked">男 </label>
                            <label><input type="radio" name="userGender" value="1">女 </label>
                        </c:if>
                        <c:if test="${requestScope.userInfo.userGender  == 1}">
                            <label><input type="radio" name="userGender" value="0">男 </label>
                            <label><input type="radio" name="userGender" value="1" checked="checked">女 </label>
                        </c:if>
                    </div>
                </div>
                <c:if test="${requestScope.userInfo.isManager  == 1}">
                <div class="form-group" >
                    <div class="checkbox" id="isManager">
                        <label for="isManager" class="">管理员 :</label>
                            <label><input type="radio" name="isManager" value="0" disabled="disabled">否 </label>
                            <label><input type="radio" name="isManager" value="1" checked="checked" disabled="disabled">是</label>
                    </div>
                </div>
                </c:if>
                <div class="form-group">
                    <i class="fa fa-check fa-lg"></i>
                    <input class="form-control required" type="text" placeholder="请输入年龄" name="userAge"
                           value="${requestScope.userInfo.userAge}" id="userAge" disabled="disabled"/>
                </div>
                <div class="form-group">
                    <i class="fa fa-envelope fa-lg"></i>
                    <input class="form-control eamil" type="text" placeholder="请输入邮箱" name="userEmail"
                           value="${requestScope.userInfo.userEmail}" id="userEmail" disabled="disabled"/>
                </div>
                <div class="form-group">
                    <i class="fa fa-envelope fa-lg"></i>
                    <input class="form-control required" type="text" placeholder="请输入地址" name="userAddress"
                           value="${requestScope.userInfo.userAddress}" id="userAddress" disabled="disabled"/>
                </div>
                <div class="form-group">
                    <i class="fa fa-envelope fa-lg"></i>
                    <input class="form-control required" type="text" placeholder="请输入手机号码" name="userPhone"
                           value="${requestScope.userInfo.userPhone}" id="userPhone" disabled="disabled"/>
                </div>
                <div class="form-group">
                    <%--<input type="button" class="btn btn-success pull-right" value="提交 " id="editBtn"/>--%>
                    <input type="button" class="btn btn-info pull-left" id="backBtn" value="返回"/>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
<%--<script type="text/javascript" src="/js/editUserInfo.js"></script>--%>
<script type="text/javascript">
    $("#backBtn").click(function () {
        history.go(-1);
    });
</script>
</html>
