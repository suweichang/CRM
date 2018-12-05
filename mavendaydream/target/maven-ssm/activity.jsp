<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/8
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title></title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <meta name="generator" content="" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;">
    <link href="css/haiersoft.css" rel="stylesheet" type="text/css" media="screen,print" />
    <link href="css/print.css" rel="stylesheet" type="text/css"  media="print" />
    <script src="js/jquery-1.10.1.min.js"></script>
    <script src="js/side.js" type="text/javascript"></script>

    <!--[if lt IE 9]>
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    <script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
    <![endif]-->
</head>

<body>


<!-- MainForm -->
<div id="MainForm">
    <div class="form_boxA">
        <h2>活动列表
            <a href="classandteacher?op=activity"><div class="btn_box floatR mag_l20"><input name="" type="button" value="添加" onMouseMove="this.className='input_move'" onMouseOut="this.className='input_out'"></div></a>
        </h2>
        <table cellpadding="0" cellspacing="0">
            <tr>
                <th>编号</th>
                <th>班级</th>
                <th>活动名称</th>
                <th>地点</th>
                <th>时间</th>
                <th>带队老师</th>
            </tr>
            <c:forEach items="${pageUtil.list}" var="activity" varStatus="activitystatus">
                <tr>
                    <td>${activity.activity_id}</td>
                    <td>${activity.classs.class_name}</td>
                    <td>${activity.activity_name}</td>
                    <td>${activity.activity_loc}</td>
                    <td>${activity.activity_time}</td>
                    <td>${activity.teacher.teacher_name}</td>
                </tr>
            </c:forEach>
        </table>
        <p class="msg">共找到${pageUtil.pageNumber}条记录，当前显示${pageUtil.pageIndex}/${pageUtil.pageCount}页</p>

        <ul id="PageNum" style="padding-top: 0px;">
            <li><a href="activity?pageIndex=1">首页</a></li>
            <c:choose>
                <c:when test="${pageUtil.pageIndex<=1}">
                    <li>上一页</li>
                </c:when>
                <c:otherwise>
                    <li><a href="activity?pageIndex=${pageUtil.pageIndex-1}">上一页</a></li>
                </c:otherwise>
            </c:choose>
            <c:choose>
                <c:when test="${pageUtil.pageIndex>=pageUtil.pageCount}">
                    <li>下一页</li>
                </c:when>
                <c:otherwise>
                    <li><a href="activity?pageIndex=${pageUtil.pageIndex+1}">下一页</a></li>
                </c:otherwise>
            </c:choose>
            <li><a href="activity?pageIndex=${pageUtil.pageCount}">尾页</a></li>
        </ul>
    </div>
</div>
<!-- /MainForm -->

</body>
</html>