<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>首页左侧导航</title>
    <link rel="stylesheet" type="text/css" href="css/public.css" />
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/public.js"></script>
    <head></head>

<body id="bg">
<!-- 左边节点 -->
<div class="container">

    <div class="leftsidebar_box">
        <a href="/inotice" target="main"><div class="line">
            <img src="img/coin01.png" />&nbsp;&nbsp;首页
        </div></a>
        <c:forEach items="${sessionScope.modelsMap}" var="temp" varStatus="status">
            <dl class="system_log">
                <dt>
                    <img class="icon1" src="img/coin03.png" />
                    <img class="icon2" src="img/coin04.png" /> ${temp.key.model_name}
                    <img class="icon3" src="img/coin19.png" />
                    <img class="icon4" src="img/coin20.png" />
                </dt>
                <c:forEach items="${temp.value}" varStatus="status1" var="temp2">
                    <dd>
                        <img class="coin11" src="img/coin111.png" />
                        <img class="coin22" src="img/coin222.png" />
                        <a class="cks" href="${temp2.url}" target="main">${temp2.model_name}</a>
                        <img class="icon5" src="img/coin21.png" />
                    </dd>
                </c:forEach>

            </dl>
        </c:forEach>
    </div>

</div>
</body>
</html>
