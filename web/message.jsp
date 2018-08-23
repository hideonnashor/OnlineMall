<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/8/17
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored ="false" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,
                                 initial-scale=1.0,
                                 maximum-scale=1.0,
                                 user-scalable=no">
    <title>消息</title>
    <!-- Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- <link rel="stylesheet" type="text/css" href="http://localhost:8090/css/OnlineMallHome.css"> -->
    <style type="text/css">

    </style>
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container" role="main">
    <ol class="breadcrumb">
        <li class="active"><a href="#">Home</a></li>
        <!-- 用户已登陆 -->
        <li><a href="#">Member center</a></li>
        <li><a href="#">Sign out</a></li>
        <!-- 用户未登陆 -->
        <!-- <li><a href="#">Sign in</a></li>
        <li><a href="#">Sign up</a></li> -->

    </ol>
    <div>
        ${message}
    </div>
</div>
</body>
</html>
