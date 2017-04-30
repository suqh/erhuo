<%--
  Created by IntelliJ IDEA.
  User: QH
  Date: 2017/4/15
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
    <!-- 在bootstrap.min.js 之前引入 -->
    <script type="text/javascript" src="/js/common/jquery.min.js"></script>
    <!-- Bootstrap 核心 JavaScript 文件 -->
    <script type="text/javascript" src="/js/common/bootstrap.min.js"></script>
    <!-- Bootstrap 核心 CSS 文件 -->
    <link type="text/css" rel="stylesheet" href="/css/bootstrap.min.css"/>
    <!--font-awesome 核心我CSS 文件-->
    <link href="http://cdn.bootcss.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
    <style type="text/css">
        .form{background: rgba(255,255,255,0.2);width:400px;margin:100px auto;}
        .fa{display: inline-block;top: 27px;left: 6px;position: relative;color: #ccc;}
        input[type="text"],input[type="password"]{padding-left:26px;}
       /* .checkbox{padding-left:21px;}*/
    </style>
</head>
<body>
<div class="container">
    <div class="form row">
        <form class="form-horizontal col-sm-offset-3 col-md-offset-3">
            <h3 class="form-title">用户登录</h3>
            <div class="col-sm-9 col-md-9">
                <div class="form-group">
                    <i class="fa fa-user fa-lg"></i>
                    <input class="form-control required" type="text" placeholder="姓名" id="userName" name="userName" autofocus="autofocus" maxlength="20"/>
                </div>
                <div class="form-group">
                    <i class="fa fa-lock fa-lg"></i>
                    <input class="form-control required" type="password" placeholder="密码" name="userPassword" id="userPassword"/>
                </div>
                <div class="form-group">
                    <input type="button" class="btn btn-primary btn-block" value="登录 " id="loginBtn"/>
                </div>
                <div class="form-group">
                    <a href="/registerAndLogin/registerPage" id="register_btn" class="">还没有账号，马上去注册一个吧...</a>
                </div>
            </div>
        </form>
    </div>
</div>
<script type="text/javascript" src="/js/login.js" ></script>
</body>
</html>
