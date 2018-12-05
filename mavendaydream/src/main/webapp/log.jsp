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

                <table cellpadding="0" cellspacing="0">
                    <tr>
                        <th>序号</th>
                        <th>用户</th>
                        <th>事件</th>
                        <th>时间</th>
                        <th>ip</th>
                    </tr>
                    <c:forEach items="${pageInfo.list}" var="temp" varStatus="status">
                        <tr>
                            <td>${status.index+1}</td>
                            <td>${temp.useres.user_name}</td>
                            <td>${temp.operation}</td>
                            <td>${temp.operation_time}</td>
                            <td>${temp.ip_address}</td>
                        </tr>
                    </c:forEach>

                </table>
                <p class="msg">共找到${pageInfo.total}条记录，当前显示从第${(pageInfo.pageNum-1)*(pageInfo.pageSize)+1 }条至第${(pageInfo.pageNum)*(pageInfo.pageSize) }条</p>
            </div>
        </div>
        <!-- /MainForm -->


        <!-- BtmMain -->


        <!-- /BtmMain -->

        <!-- PageNum -->
        <ul id="PageNum">
            <li><a href="log?curPage=1">首页</a></li>
            <li>
                <c:choose>
                <c:when test="${pageInfo.pageNum<=1 }">
                <a href="javascript:void(0)">上一页</a></li>
            </c:when>
            <c:otherwise>
                <a href="log?curPage=${pageInfo.pageNum-1 }">上一页</a>
            </c:otherwise>
            </c:choose>
            </li>
            <li>当前第${pageInfo.pageNum } 页/共${pageInfo.pages }页</li>
            <li>
                <form action="log" method="post">
                    跳转到第 <input type="text" name="curPage"  style="width: 40px;" >页
                    <input type="submit" value="GO" id="go"
                           onmouseover="this.style.backgroundColor='#D05054';"
                           onmouseout="this.style.backgroundColor='#46586A';"
                           style="border-radius: 6px;width: 61px; height: 29px;
			 	background: #46586A; color: white;" />
                </form>
            </li>
            <li>
                <c:choose>
                    <c:when test="${pageInfo.pageNum>=pageInfo.pages }">
                        <a href="javascript:void(0)">下一页</a></li>
                    </c:when>
                    <c:otherwise>
                        <a href="log?curPage=${pageInfo.pageNum+1 }">下一页</a>
                    </c:otherwise>
                </c:choose>
            </li>
            <li><a href="log?curPage=${pageInfo.pages }">尾页</a></li>
        </ul>
        <!-- /PageNum -->
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
