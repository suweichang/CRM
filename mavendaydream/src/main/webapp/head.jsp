<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/8
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>头部</title>
    <link rel="stylesheet" type="text/css" href="css/public.css" />
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/public.js"></script>
</head>

<body>
<!-- 头部 -->
<div class="head">
    <div class="headL">
        <img class="headLogo" src="img/sc-3.png" style="margin-top: -25px;margin-left: 24px;"/>
    </div>
    <div class="headR">
        <span style="color:#FFF">欢迎：${sessionScope.user.user_name}</span> <a href="logoff" rel="external" target="_parent">【退出】</a>
    </div>
</div>
</body>
</html>
