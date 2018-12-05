<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
<!-- wrap_left -->

<!-- /wrap_left -->

<!-- picBox -->
<div class="picBox" onClick="switchSysBar()" id="switchPoint"></div>
<!-- /picBox -->



<!-- wrap_right -->
<div class="wrap_right">
    <header>
        <!-- Header -->

        <!-- /Header -->
    </header>


    <!-- Contents -->
    <div id="Contents">
        <script type="text/javascript">
            $(function(){
                $(".select").each(function(){
                    var s=$(this);
                    var z=parseInt(s.css("z-index"));
                    var dt=$(this).children("dt");
                    var dd=$(this).children("dd");
                    var _show=function(){dd.slideDown(200);dt.addClass("cur");s.css("z-index",z+1);};
                    var _hide=function(){dd.slideUp(200);dt.removeClass("cur");s.css("z-index",z);};
                    dt.click(function(){dd.is(":hidden")?_show():_hide();});
                    dd.find("a").click(function(){dt.html($(this).html());_hide();});
                    $("body").click(function(i){ !$(i.target).parents(".select").first().is(s) ? _hide():"";});})})
        </script>

        <!-- MainForm -->
        <div id="MainForm">
            <div class="form_boxB">
                <h2>CRM角色管理</h2>
                <div class="btn_box floatR mag_l20">
                    <a href="addRole">
                        <input name="" type="button" value="增加角色" onMouseMove="this.className='input_move'" onMouseOut="this.className='input_out'">
                    </a>
                </div>
                <table cellpadding="0" cellspacing="0">

                    <tr>
                        <th>序号</th>
                        <th>角色名</th>
                        <th>角色状态</th>
                        <th>修改权限</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${roleInfo}" var="temp" varStatus="status">
                        <tr>
                            <td>${status.index+1 }</td>
                            <td>${temp.role_name}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${temp.role_status=='1'}">
                                        已启用
                                    </c:when>
                                    <c:otherwise>
                                        已禁用
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td><a href="updateRole/${temp.role_id}">修改权限</a></td>
                            <td>
                                <c:choose>
                                    <c:when test="${temp.role_status=='1'}">
                                        <a href="updateRoleStatus/${temp.role_id}/0">禁用</a></td>
                                    </c:when>
                                    <c:otherwise>
                                        <a href="updateRoleStatus/${temp.role_id}/1">启用</a></td>
                                    </c:otherwise>
                                </c:choose>
                        </tr>
                    </c:forEach>


                </table>
            </div>
        </div>
        <!-- /MainForm -->


        <!-- BtmMain -->
    </div>
    <!-- btn_box -->
    <!-- /btn_box -->
    <!-- /Contents -->

    <!-- /footer -->
    <footer>
        <address>2007 Corporation,All Rights</address>
    </footer>
    <!-- /footer -->

</div>
<!-- /wrap_right -->
</body>
</html>
