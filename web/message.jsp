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
    <script type="text/javascript" src="./js/ajax_userinfo.js"></script>
</head>
<body>
<img src="" alt="">
<div class="container" role="main">
    <div>
        ${message}
    </div>
</div>
</body>
<script type="text/javascript">
    try {
        $("#username").text(getLoginState());
    } catch(e) {
        // statements
        console.log(e);
    }
</script>
</html>
