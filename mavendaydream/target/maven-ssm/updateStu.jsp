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
            var num = 0;
            $("input[type='text']").each(function () {
                if ($(this).val() == "") {
                    num++;
                }
            });
            if(num > 0){
                alert("信息不完整!");
                return false;
            }else {
                return true;
            }
        }
    </script>
</head>

<body>
<!-- Popup -->
<div id="Popup">
    <form action="updateStu" method="post" onsubmit="return check1()">
        <%--<c:forEach items="${stuById}" var="stu">--%>
        <!-- SubPopup -->
        <div id="SubPopup">
            <div class="form_boxC">
                <h2>修改学员</h2>
                <<input type="hidden" name="studentId" value="${stu.studentId}">
                <table cellpadding="0" cellspacing="0">
                    <tr>
                        <th width="100">学员姓名 <span class="f_cB"></span></th>
                        <td><div class="txtbox floatL" style="width:150px;"><input name="studentName" type="text" size="12" value="${stu.studentName}"></div></td>
                    </tr>
                    <tr>
                        <th>所在班级 <span class="f_cB"></span></th>
                        <td><div class="txtbox floatL" style="width:150px;"><select name="classId" style="height: 29px">
                            <c:forEach items="${classlist}" var="temp">
                                <c:choose>
                                    <c:when test="${temp.class_id == stu.classId}">
                                        <option value="${temp.class_id}" selected>${temp.class_name}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${temp.class_id}">${temp.class_name}</option>
                                    </c:otherwise>
                                </c:choose>

                            </c:forEach>
                        </select>
                        </div>
                        </td>
                        <%--<td><div class="txtbox floatL" style="width:100px;"><input name="classId" type="text" size="15" value="11"></div></td>--%>
                    </tr>
                    <tr>
                        <th>性别 <span class="f_cB"></span></th>
                        <td><div class="txtbox floatL" style="width:150px;"><input name="studentSex" type="text" size="12" value="${stu.studentSex}"></div></td>
                    </tr>
                    <tr>
                        <th>毕业院校 <span class="f_cB"></span></th>
                        <td><div class="txtbox floatL" style="width:150px;"><input name="studentSchool" type="text" size="12" value="${stu.studentSchool}"></div></td>
                    </tr>
                    <tr>
                        <th>学历 <span class="f_cB"></span></th>
                        <td><div class="txtbox floatL" style="width:150px;"><input name="studentEducation" type="text" size="12" value="${stu.studentEducation}"></div></td>
                    </tr>
                    <tr>
                        <th>专业 <span class="f_cB"></span></th>
                        <td><div class="txtbox floatL" style="width:150px;"><input name="studentMajor" type="text" size="12" value="${stu.studentMajor}"></div></td>
                    </tr>
                    <tr>
                        <th>籍贯 <span class="f_cB"></span></th>
                        <td><div class="txtbox floatL" style="width:150px;"><input name="studentNative" type="text" size="12" value="${stu.studentNative}"></div></td>
                    </tr>
                    <tr>
                        <th>电话 <span class="f_cB"></span></th>
                        <td><div class="txtbox floatL" style="width:150px;"><input name="studentTel" type="text" size="12" value="${stu.studentTel}"></div></td>
                    </tr>
                    <tr>
                        <th>QQ <span class="f_cB"></span></th>
                        <td><div class="txtbox floatL" style="width:150px;"><input name="studentQq" type="text" size="12" value="${stu.studentQq}"></div></td>
                    </tr>
                </table>
            </div>
        </div>
        <!-- SubPopup -->

        <div id="BtmBtn">
            <div class="btn_boxB floatR mag_l20"><a href="student" ><input name="" type="button" value="取消" /></a></div>
            <div class="btn_box floatR"><input name="" type="submit" value="修改" /></div>
        </div>
        <%--</c:forEach>--%>
    </form>
</div>
<!-- /Popup -->
</body>
</html>
