<%--
  Created by IntelliJ IDEA.
  User: QH
  Date: 2017/4/15
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册界面</title>
    <!--用百度的静态资源库的cdn安装bootstrap环境-->
    <!-- Bootstrap 核心 CSS 文件 -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <!--font-awesome 核心我CSS 文件-->
    <link href="http://cdn.bootcss.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
    <!-- 在bootstrap.min.js 之前引入 -->
    <script src="/js/common/jquery.min.js"></script>
    <!-- Bootstrap 核心 JavaScript 文件 -->
    <script src="/js/common/bootstrap.min.js"></script>

    <style type="text/css">
        .form{background: rgba(255,255,255,0.2);width:400px;margin:100px auto}
        .fa{display: inline-block;top: 27px;left: 6px;position: relative;color: #ccc;}
        input[type="text"],input[type="password"]{padding-left:26px;}
        .checkbox{padding-left:21px;}
    </style>
</head>
<body>
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
        <form class="form-horizontal col-sm-offset-3 col-md-offset-3">
            <h3 class="form-title">用户注册</h3>
            <div class="col-sm-9 col-md-9">
                <div class="form-group">
                    <i class="fa fa-user fa-lg"></i>
                    <input class="form-control required" type="text" placeholder="请输入姓名" id="userName" name="userName" autofocus="autofocus"/>
                </div>
                <div class="form-group">
                    <i class="fa fa-lock fa-lg"></i>
                    <input class="form-control required" type="password" placeholder="请输入密码" id="userPassword" name="userPassword"/>
                </div>
                <div class="form-group">
                    <i class="fa fa-lock fa-lg"></i>
                    <input class="form-control required" type="password" placeholder="确认密码" id="confirmPassword" name="confirmPassword"/>
                </div>
                <div class="form-group">
                    <div class="checkbox" id="userGender" style="margin-left: auto">
                        <label for="userGender" class="">性别 :</label>
                        <label><input type="radio" name="gender" value="0">男 </label>
                        <label><input type="radio" name="gender" value="1">女 </label>
                    </div>
                </div>
                <div class="form-group">
                    <i class="fa fa-check fa-lg"></i>
                    <input class="form-control required" type="text" placeholder="请输入年龄" id="userAge" name="userAge"/>
                </div>
                <div class="form-group">
                    <i class="fa fa-envelope fa-lg"></i>
                    <input class="form-control eamil" type="text" placeholder="请输入邮箱" id="userEmail" name="userEmail"/>
                </div>
                <div class="form-group">
                    <i class="fa fa-envelope fa-lg"></i>
                    <input class="form-control required" type="text" placeholder="请输入地址" id="userAddress" name="userAdderss"/>
                </div>
                <div class="form-group">
                    <i class="fa fa-envelope fa-lg"></i>
                    <input class="form-control required" type="text" placeholder="请输入手机号码" id="userPhone" name="userPhone"/>
                </div>
                <div class="form-group">
                    <input type="button" class="btn btn-success pull-right" id="saveBtn" value="注册 "/>
                    <input type="button" class="btn btn-info pull-left" id="backBtn" value="返回"/>
                </div>
            </div>
        </form>
    </div>
</div>
<script type="text/javascript" src="/js/register.js" ></script>
</body>
</body>
</html>
