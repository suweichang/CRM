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
    <h2>公告列表</h2>
    <div id="BtmMain">
        <form action="notice" method="post">
        <!-- txtbox -->
        <div class="txtbox floatL mag_r20">
            <span class="sttl">标题：</span>
            <input name="notice_title" type="text" size="8" value="${notice_title}">
        </div>
        <!-- /txtbox -->

        <!-- txtbox -->
        <div class="txtbox floatL mag_r20">
            <span class="sttl">内容：</span>
            <input name="notice_content" type="text" size="8" value="${notice_content}">
        </div>
        <!-- /txtbox -->

        <!-- btn_box -->
            <a href="notice?op=clear"><div class="btn_box floatR mag_l20"><input name="" type="button" value="清除" onMouseMove="this.className='input_move'" onMouseOut="this.className='input_out'"></div></a>
        <!-- /btn_box -->
            <a href="addnotice.jsp"><div class="btn_box floatR mag_l20"><input name="" type="button" value="添加" onMouseMove="this.className='input_move'" onMouseOut="this.className='input_out'"></div></a>
        <!-- btn_box -->
            <div class="btn_box floatR mag_l20"><input type="submit" value="查找" onMouseMove="this.className='input_move'" onMouseOut="this.className='input_out'"></div>
        <!-- /btn_box -->
        </form>
    </div>
    <div class="form_boxA">
        <table cellpadding="0" cellspacing="0">
            <tr>
                <th>编号</th>
                <th>标题</th>
                <th>用户ID</th>
                <th>发布时间</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${noticepageInfo.list}" var="notice">
                <tr>
                    <td>${notice.notice_id}</td>
                    <td>${notice.notice_title}</td>
                    <td>${notice.user_id}</td>
                    <td>${notice.notice_time}</td>
                    <td>
                        <a href="detailnotice?op=looknotice&notice_id=${notice.notice_id}">查看</a>&nbsp;&nbsp;
                        <a href="detailnotice?op=update&notice&notice_id=${notice.notice_id}">修改</a>&nbsp;&nbsp;
                        <a href="deltelnotice?notice_id=${notice.notice_id}">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
       <p class="msg">共找到${noticepageInfo.total}条记录，当前显示${noticepageInfo.pageNum}/${noticepageInfo.pages}页</p>

        <ul id="PageNum" style="padding-top: 0px;">
            <li><a href="notice?pageIndex=1&notice_title=${notice_title}&notice_content=${notice_content}">首页</a></li>
            <c:choose>
                <c:when test="${noticepageInfo.pageNum<=1}">
                    <li>上一页</li>
                </c:when>
                <c:otherwise>
                    <li><a href="notice?pageIndex=${noticepageInfo.pageNum-1}&notice_title=${notice_title}&notice_content=${notice_content}">上一页</a></li>
                </c:otherwise>
            </c:choose>
            <c:choose>
                <c:when test="${noticepageInfo.pageNum>=noticepageInfo.pages}">
                    <li>下一页</li>
                </c:when>
                <c:otherwise>
                    <li><a href="notice?pageIndex=${noticepageInfo.pageNum+1}&notice_title=${notice_title}&notice_content=${notice_content}">下一页</a></li>
                </c:otherwise>
            </c:choose>
            <li><a href="notice?pageIndex=${noticepageInfo.pages}&notice_title=${notice_title}&notice_content=${notice_content}">尾页</a></li>
        </ul>
    </div>
</div>
<!-- /MainForm -->

</body>
</html>