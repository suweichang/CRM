<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <script type="text/javascript">
        $(function(){


        })
        function check1() {
            if($("#sel").val() == 0){
                alert("请选择考勤结果!");
                return false;
            }else {
                return true;
            }
        }
    </script>
</head>

<body>
<div id="MainForm">
    <div class="form_boxA">
        <h2>修改考勤</h2>

        <form action="updateAtt" method="post" onsubmit="return check1()">
            <table cellpadding="0" cellspacing="0">
                <tr>
                    <th>序号</th>
                    <th>学生姓名</th>
                    <th>学员班级</th>
                    <th>日期</th>
                    <th>考勤结果</th>
                </tr>
                    <tr>
                        <td>${temp.attendanceId}</td>
                        <td>${temp.studentName}</td>
                        <td>${temp.className}</td>
                        <td>${temp.attendanceDate}</td>
                        <td><select id="sel" name="status">
                            <option value="0">请选择考勤</option>
                            <option>已到</option>
                            <option>迟到</option>
                            <option>旷课</option>
                            <option>早退</option>
                            <option>请假</option>
                        </select></td>
                        <input type="hidden" name="attendanceId" value="${temp.attendanceId}" />
                        <%--<input type="hidden" name="classId" value="${temp.classId}" />--%>
                        <%--<input type="hidden" name="studentId" value="${temp.studentId}" />--%>
                    </tr>
            </table>

            <div id="BtmBtn">
                <div class="btn_boxB floatR mag_l20" style="margin-right: 130px;margin-top: 20px"><a href="attendance" ><input name="" type="button" value="取消" /></a></div>
                <div class="btn_box floatR" style="margin-top: 20px"><input name="" type="submit" value="修改" /></div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
