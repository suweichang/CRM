<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/11
  Time: 14:55
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
    <form method="post" action="AddGrade">

    <div class="form_boxA">
        <h2>学生列表
            <a href="review"><div class="btn_box floatR mag_l20"><input name="" type="button" value="返回" onMouseMove="this.className='input_move'" onMouseOut="this.className='input_out'"></div></a>
            <c:if test="${Grades==null}">
                <div class="btn_box floatR mag_l20"><input type="submit" value="提交" onMouseMove="this.className='input_move'" onMouseOut="this.className='input_out'"></div>
            </c:if>
        </h2>
        <table cellpadding="0" cellspacing="0">
            <tr>
                <th>学号</th>
                <th>姓名</th>
                <th>时间</th>
                <th>所属班级</th>
                <th>评审老师老师</th>
                <th><strong>成绩</strong></th>
            </tr>
            <c:forEach items="${studentList}" var="stu">
                <tr>
                    <td>${stu.studentId}</td>
                    <td>${stu.studentName}</td>
                    <td>${review.ctime}</td>
                    <td>${review.classs.class_name}</td>
                    <td>${review.teacher.teacher_name}</td>
                    <td>
                        <input name="review_id" type="hidden" value="${review.review_id}">
                        <input name="student_id" type="hidden" value="${stu.studentId}">
                        <c:choose>
                            <c:when test="${Grades==null}">
                                <input name="grade_score" type="text" style="border: 1px solid #D0D0D0;width: 30px;">
                            </c:when>
                            <c:otherwise>
                                <c:forEach items="${Grades}" var="grade">
                                    <c:if test="${grade.student_id==stu.studentId}">
                                        <input name="grade_score" type="text" style="border: 1px solid #D0D0D0;width: 30px;text-align: center;" disabled="disabled" value="${grade.grade_score}">
                                    </c:if>
                                </c:forEach>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    </form>
</div>
<!-- /MainForm -->
</body>
</html>