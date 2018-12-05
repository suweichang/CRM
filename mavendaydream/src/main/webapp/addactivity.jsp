<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/10
  Time: 11:36
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
<!-- Popup -->
<div id="Popup">
<form method="post" action="AddActivity">
    <!-- SubPopup -->
    <div id="SubPopup">
        <div class="form_boxC">
            <table cellpadding="0" cellspacing="0">
                <tr>
                    <th width="100">班级名称</th>
                    <td>
                        <select name="class_id" style="border: 0px;">
                            <option>请选择</option>
                            <c:forEach items="${classsList}" var="temp">
                                <option value="${temp.class_id}">${temp.class_name}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>活动名称</th>
                    <td><input type="text" name="activity_name"style="border: 0px;"/></td>
                </tr>
                <tr>
                    <th>活动地点</th>
                    <td><input type="text" name="activity_loc"style="border: 0px;"/></td>
                </tr>
                <tr>
                    <th>带队老师</th>
                    <td>
                        <select name="teacher_id"style="border: 0px;">
                            <option>请选择</option>
                            <c:forEach items="${teacherslist}" var="teacher">
                                <option value="${teacher.teacher_id}">${teacher.teacher_name}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
            </table>
        </div>
    </div>
    <!-- SubPopup -->

    <div id="BtmBtn">
        <a href="activity"><div class="btn_boxB floatR mag_l20"><input name="" type="button" value="返回" onmousemove="this.className='input_move'" onmouseout="this.className='input_out'"></div></a>
        <div class="btn_box floatR"><input type="submit" value="提交" onmousemove="this.className='input_move'" onmouseout="this.className='input_out'"></div>
    </div>
</form>
</div>
<!-- /Popup -->
</body>
</html>
