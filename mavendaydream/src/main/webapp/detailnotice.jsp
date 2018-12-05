<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/10
  Time: 20:19
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
    <form action="UpDAteNotice" method="post">
        <!-- SubPopup -->
        <div id="SubPopup">
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
            <div class="form_boxC">
                <table cellpadding="0" cellspacing="0">
                    <tr>
                        <th width="100">序号<span class="f_cB"></span></th>
                        <td><div class="txtbox floatL" style="width:450px;">
                            <input type="text" size="5" style="width:430px;" disabled="disabled" value="${detailnotice.notice_id}">
                            <input name="notice_id" type="hidden" value="${detailnotice.notice_id}">
                        </div></td>
                    </tr>
                    <tr>
                        <th width="100">作者<span class="f_cB"></span></th>
                        <td><div class="txtbox floatL" style="width:450px;"><input name="notice_title" type="text" size="5" style="width:430px;" disabled="disabled" value="${detailnotice.user_id}"></div></td>
                    </tr>
                    <tr>
                        <th width="100">时间<span class="f_cB"></span></th>
                        <td><div class="txtbox floatL" style="width:450px;"><input name="notice_time" type="text" size="5" style="width:430px;" disabled="disabled" value="${detailnotice.notice_time}"></div></td>
                    </tr>
                    <tr>
                        <th width="100">标题</th>
                        <td><div class="txtbox floatL" style="width:450px;">
                            <c:if test="${look!=null}">
                                <input name="notice_title" type="text" size="5" style="width:430px;" disabled="disabled" value="${detailnotice.notice_title}">
                            </c:if>
                            <c:if test="${update!=null}">
                                <input name="notice_title" type="text" size="5" style="width:430px;" value="${detailnotice.notice_title}">
                            </c:if>
                        </div></td>
                    </tr>
                    <tr>
                        <th>内容</th>
                        <td><div class="txtbox" style="width:450px;">
                            <c:if test="${look!=null}">
                                <textarea name="notice_content" cols="51" rows="5" style="resize: none;" disabled="disabled">${detailnotice.notice_content}</textarea>
                            </c:if>
                            <c:if test="${update!=null}">
                                <textarea name="notice_content" cols="51" rows="5" style="resize: none;">${detailnotice.notice_content}</textarea>
                            </c:if>
                        </div><p class="f_cB pdg_t5"></p></td>
                    </tr>
                </table>
            </div>
        </div>

        <%-- 无法验证登入 user_id 暂用固定值
         <input type="hidden" name="user_id" value="${user_id}">--%>
        <input type="hidden" name="user_id" value="1">
        <!-- SubPopup -->
        <div id="BtmBtn">
            <a href="notice"><div class="btn_box floatR mag_l20"><input name="" type="button" value="返回" onMouseMove="this.className='input_move'" onMouseOut="this.className='input_out'"></div></a>
            <c:if test="${update!=null}">
                <div class="btn_box floatR"><input type="submit" value="提交" onmousemove="this.className='input_move'" onmouseout="this.className='input_out'"></div>
            </c:if>
       </div>
    </form>
</div>
<!-- /Popup -->
</body>
</html>