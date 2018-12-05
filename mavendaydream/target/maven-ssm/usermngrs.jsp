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
    <script type="text/javascript">
        function check(){
            var fp = $("#fpwd").val();
            var rp = $("#rpwd").val();
            if(fp == rp){
                $("#uform").submit();
                return true;
            }else{
                alert("前后输入的密码不一致");
                $("#rpwd").focus();
                return false;
            }
        }
        function umessage(){
            alert("你不是此管理员用户，不能修改用户信息");
        }
    </script>
</head>

<body>


<!-- MainForm -->
<div id="MainForm">
    <div class="form_boxA">

        <c:choose>
            <c:when test="${ opr eq 'info' }">
            <h2>系统用户信息</h2>
            <table cellpadding="0" cellspacing="0">
                <tr>
                    <th>用户ID</th>
                    <th>用户名</th>
                    <th>所属角色</th>
                    <th>用户状态</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${useresList}" var="user">
                    <tr>
                        <td>${user.user_id}</td>
                        <td>${user.user_name}</td>
                        <td>${user.rolees.role_name}</td>
                        <c:choose>
                            <c:when test="${user.user_status eq '0'}">
                                <td>冻结</td>
                                <td>
                                    <a href="/usermngru?user_id=${user.user_id}&user_status=${user.user_status}">启用</a>&nbsp;&nbsp;
                                    <a href="/usermngr?uid=${user.user_id}">修改</a>
                                </td>
                            </c:when>
                            <c:when test="${user.user_status eq '1'}">
                                <td>在用</td>
                                <td>
                                    <a href="/usermngru?user_id=${user.user_id}&user_status=${user.user_status}">冻结</a>&nbsp;&nbsp;
                                    <a href="/usermngr?uid=${user.user_id}">修改</a>
                                </td>
                            </c:when>
                            <c:otherwise>
                                <td>&nbsp;&nbsp;</td>
                            </c:otherwise>
                        </c:choose>
                    </tr>
                </c:forEach>
            </table>
            </c:when>
            <c:when test="${ opr eq 'update' }">
                <h2>用户信息修改</h2>
                <form action="/usermngrup" method="post" id="uform">
                    <table>
                    <c:forEach items="${useresList}" var="users">
                        <input type="hidden" name="user_id" value="${users.user_id}">
                        <tr>
                            <td>用户名:</td>
                            <td style="text-align:left;"><input type="text" name="user_name" value="${users.user_name}"></td>
                        </tr>
                        <tr>
                            <td>用户角色:</td>
                            <td style="text-align:left;">
                                <select name="role_id" id="">
                                    <c:forEach items="${roleList}" var="temp" varStatus="status">
                                        <c:choose>
                                            <c:when test="${users.role_id==temp.role_id}">
                                                <option value="${temp.role_id}" selected>${temp.role_name}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${temp.role_id}">${temp.role_name}</option>
                                            </c:otherwise>
                                        </c:choose>

                                    </c:forEach>
                                </select>
                            </td>
                        </tr>

                        <tr>
                            <td>修改密码:</td>
                            <td style="text-align:left;"><input type="password" id="fpwd" name="user_pwd" value=""></td>
                        </tr>
                        <tr>
                            <td>确认密码:</td>
                            <td style="text-align:left;"><input type="password" id="rpwd" name="ruser_pwd" value=""></td>
                        </tr>
                    </c:forEach>
                    </table>
                    <div id="BtmBtn">
                        <div class="btn_box floatR">
                            <a href="/usermngr">
                                <input type="button" value="返回" onmousemove="this.className='input_move'" onmouseout="this.className='input_out'">
                            </a>
                        </div>
                        <div class="btn_boxB floatR" style="margin-right:10px;">
                            <input type="reset" value="重写" onmousemove="this.className='input_move'" onmouseout="this.className='input_out'">
                        </div>
                        <div class="btn_box floatR" style="margin-right:10px;">
                            <input type="button" value="确认修改" onclick="check()" onmousemove="this.className='input_move'" onmouseout="this.className='input_out'">
                        </div>
                    </div>
                </form>
            </c:when>
            <c:otherwise>

            </c:otherwise>
        </c:choose>
    </div>
</div>
<!-- /MainForm -->

</body>
</html>