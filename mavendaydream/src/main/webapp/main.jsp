<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title></title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <meta name="generator" content="" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;">
    <link href="${pageContext.request.contextPath}/css/haiersoft.css" rel="stylesheet" type="text/css" media="screen,print" />
    <link href="${pageContext.request.contextPath}/css/print.css" rel="stylesheet" type="text/css"  media="print" />
    <script src="${pageContext.request.contextPath}/js/jquery-1.10.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/side.js" type="text/javascript"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jsapi.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/format+zh_CN,default,corechart.I.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.gvChart-1.0.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.ba-resize.min.js"></script>
    <!--[if lt IE 9]>
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    <script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
    <![endif]-->
    <script type="text/javascript">
        gvChartInit();
        jQuery(document).ready(function(){

            jQuery('#myTable5').gvChart({
                chartType: 'PieChart',
                gvSettings: {
                    vAxis: {title: 'No of players'},
                    hAxis: {title: 'Month'},
                    width: 650,
                    height: 220
                }
            });
        });
    </script>
    <script type="text/javascript">
        function lpage(lnum) {
            var nums = $("#lpnum").html();
            if(lnum == 0){
                nums = 1;
            }else if(lnum == 1){
                nums--;
            }else if(lnum == 2 ){
                nums++;
            }else {
                nums = $("#lpages").html();
            }
            $.ajax({
                type: 'POST',
                url: "/inotice/lsend",
                dataType: "json",
                data: {"cpage":nums},
                success: function(data){

                   if(data.length != 0){
                       $("#ltbody > tr").html("");
                       var datas = eval(data);
                       for(var i in datas){
                           var str = "<tr>";
                               str += "<td style='border-bottom:#e3e3e3 solid 1px;border-right:#e3e3e3 solid 1px;text-align:center; font-size:14px;padding:2px 0px;'>" + datas[i].customer_name;
                               str += "</td><td style='border-bottom:#e3e3e3 solid 1px;border-right:#e3e3e3 solid 1px;text-align:center; font-size:14px;'>" + datas[i].customer_phone;
                               str += "</td><td style='border-bottom:#e3e3e3 solid 1px;border-right:#e3e3e3 solid 1px;text-align:center; font-size:14px;'>" + datas[i].customer_school;
                               str += "</td><td style='border-bottom:#e3e3e3 solid 1px;border-right:#e3e3e3 solid 1px;text-align:center; font-size:14px;'>" + datas[i].customer_status;
                               str += "</td><td style=\"border-bottom:#e3e3e3 solid 1px;border-right:#e3e3e3 solid 1px;text-align:center; font-size:14px;\"><a href=\"javascript:\">操作</a></td>";
                               str += "</tr>";
                           $("#ltbody").append(str);
                       }
                       $("#lpnum").html(nums);
                   }
                },
            });
        }

    </script>
    <script>
        function rpage(rnum) {
            var nums = $("#rpnum").html();
            if(rnum == 0){
                nums = 1;
            }else if(rnum == 1){
                nums--;
            }else if(rnum == 2 ){
                nums++;
            }else {
                nums = $("#rpages").html();
            }
            $.ajax({
                type: 'POST',
                url: "/inotice/rsend",
                dataType: "json",
                data: {"rcpage":nums},
                success: function(data){

                    if(data.length != 0){
                        $("#rtbody > tr").html("");
                        var datas = eval(data);
                        for(var i in datas){
                            var str = "<tr>";
                            str += "<td style='border-bottom:#e3e3e3 solid 1px;border-right:#e3e3e3 solid 1px;text-align:center; font-size:14px;padding:2px 0px;'>" + datas[i].customer_name;
                            str += "</td><td style='border-bottom:#e3e3e3 solid 1px;border-right:#e3e3e3 solid 1px;text-align:center; font-size:14px;'>" + datas[i].customer_phone;
                            str += "</td><td style='border-bottom:#e3e3e3 solid 1px;border-right:#e3e3e3 solid 1px;text-align:center; font-size:14px;'>" + datas[i].customer_school;
                            str += "</td><td style='border-bottom:#e3e3e3 solid 1px;border-right:#e3e3e3 solid 1px;text-align:center; font-size:14px;'>" + datas[i].customer_major;
                            str += "</td><td style=\"border-bottom:#e3e3e3 solid 1px;border-right:#e3e3e3 solid 1px;text-align:center; font-size:14px;\">已报名</td>";
                            str += "</tr>";
                            $("#rtbody").append(str);
                        }
                        $("#rpnum").html(nums);
                    }
                },
            });
        }
    </script>
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
                <div class="indextop" style="height:260px;width:1076px;outline:1px solid #fff;">

                    <!--招生数据统计模块-->
                    <div class="numbers" style="border:1px solid #e3e3e3;width:762px;height:260px;float:left;font-size:16px;">
                        <div style="height:35px;border-bottom:1px solid #e3e3e3;line-height:35px;">
                            <b style="margin-left:5px;">招生数据统计</b>
                    </div>
                        <div>
                            <table id='myTable5'>
                                <caption>近12个月招生比例</caption>
                                <thead>
                                    <tr>
                                        <th></th>
                                        <th>Jan</th>
                                        <th>Feb</th>
                                        <th>Mar</th>
                                        <th>Apr</th>
                                        <th>May</th>
                                        <th>Jun</th>
                                        <th>Jul</th>
                                        <th>Aug</th>
                                        <th>Sep</th>
                                        <th>Oct</th>
                                        <th>Nov</th>
                                        <th>Dec</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <c:forEach items="${monthList}" var="month">
                                            <td>${month.cmonth}</td>
                                        </c:forEach>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>

                    <!--公告展示模块-->
                    <div class="notice" style="border:1px solid #e3e3e3;width:300px;height:260px;float:left;margin-left:10px;font-size:16px;">
                        <div style="height:35px;border-bottom:1px solid #e3e3e3;line-height:35px;">
                            <b style="margin-left:5px;">公告</b><span><a style="float: right;margin-right:5px;" href="notice">更多</a></span>
                        </div>

                        <ul>
                            <c:forEach items="${noticeList}" var="notice">
                                <li style="margin-top:5px;margin-left:3px;">
                                    <a href="detailnotice?op=looknotice&notice_id=${notice.notice_id}" style="text-decoration:none;margin-top:3px;font-size:14px;display:block;float:left;width:160px;overflow:hidden;text-overflow:ellipsis;white-space:nowrap;" id="anotice">${notice.notice_title}</a>
                                    <span style="float:right;margin-right:5px;font-size: 14px;display:block;">
                                                <fmt:formatDate value="${ notice.notice_time }" type="date"/>
                                    </span>
                                </li>
                            </c:forEach>
                        </ul>

                    </div>
                </div>
            </div>

            <div class="indexbuttom" style="height:230px;width:1076px;outline:1px solid #fff;margin-top:10px;font-size:16px;">
                <!--代办事项模块-->
                <div class="ready" style="border:1px solid #e3e3e3;width:380px;height:230px;float:left;">
                    <div class="form_boxB" style="height:35px;border-bottom:1px solid #e3e3e3;line-height:35px;">
                        <b style="margin-left:5px;">代办事项</b><span><a style="float: right;margin-right:5px;">更多</a></span>
                    </div>
                    <table cellpadding="0" cellspacing="0" width="100%">
                        <tr>
                            <th style="border-bottom:#e3e3e3 solid 2px; text-align:center; font-size:14px;padding:3px 0px;">姓名</th>
                            <th style="border-bottom:#e3e3e3 solid 2px; text-align:center; font-size:14px;">联系电话</th>
                            <th style="border-bottom:#e3e3e3 solid 2px; text-align:center; font-size:14px;">毕业院校</th>
                            <th style="border-bottom:#e3e3e3 solid 2px; text-align:center; font-size:14px;">客户状态</th>
                            <th style="border-bottom:#e3e3e3 solid 2px; text-align:center; font-size:14px;">操作</th>
                        </tr>

                        <tbody id="ltbody">
                        <c:forEach items="${lpageInfo.list}" var="cus">
                            <tr>
                                <td style="border-bottom:#e3e3e3 solid 1px;border-right:#e3e3e3 solid 1px;text-align:center; font-size:14px;padding:2px 0px;">${cus.customer_name}</td>
                                <td style="border-bottom:#e3e3e3 solid 1px;border-right:#e3e3e3 solid 1px;text-align:center; font-size:14px;">${cus.customer_phone}</td>
                                <td style="border-bottom:#e3e3e3 solid 1px;border-right:#e3e3e3 solid 1px;text-align:center; font-size:14px;">${cus.customer_school}</td>
                                <c:choose>
                                    <c:when test="${ cus.customer_status eq '1' }">
                                        <td style="border-bottom:#e3e3e3 solid 1px;border-right:#e3e3e3 solid 1px;text-align:center; font-size:14px;">未上门</td>
                                    </c:when>
                                    <c:when test="${ cus.customer_status eq '2' }">
                                        <td style="border-bottom:#e3e3e3 solid 1px;border-right:#e3e3e3 solid 1px;text-align:center; font-size:14px;">已上门</td>
                                    </c:when>
                                </c:choose>
                                <td style="border-bottom:#e3e3e3 solid 1px;border-right:#e3e3e3 solid 1px;text-align:center; font-size:14px;"><a href="javascript:">操作</a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <ul id="PageNum" style="padding-top:8px;">
                        <li><a href="javascript:void(0)" onclick="lpage(0)">首页</a></li>
                        <li><a href="javascript:void(0)" onclick="lpage(1)">上一页</a></li>
                        <li><a href="javascript:void(0)" onclick="lpage(2)">下一页</a></li>
                        <li><a href="javascript:void(0)" onclick="lpage(3)">尾页</a></li>
                    </ul>
                    <span id="lpnum" style="display:none;">${lpageInfo.pageNum}</span>
                    <span id="lpages" style="display:none;">${lpageInfo.pages}</span>
                </div>

                <!--已办事项模块-->
                <div class="done" style="border:1px solid #e3e3e3;width:380px;height:230px;float:left;">
                    <div class="form_boxB" style="height:35px;border-bottom:1px solid #e3e3e3;line-height:35px;">
                        <b style="margin-left:5px;">已办事项</b><span><a style="float: right;margin-right:5px;">更多</a></span>
                    </div>
                    <table cellpadding="0" cellspacing="0" width="100%">
                        <tr>
                            <th style="border-bottom:#e3e3e3 solid 2px; text-align:center; font-size:14px;padding:3px 0px;">姓名</th>
                            <th style="border-bottom:#e3e3e3 solid 2px; text-align:center; font-size:14px;">联系电话</th>
                            <th style="border-bottom:#e3e3e3 solid 2px; text-align:center; font-size:14px;">毕业院校</th>
                            <th style="border-bottom:#e3e3e3 solid 2px; text-align:center; font-size:14px;">专业</th>
                            <th style="border-bottom:#e3e3e3 solid 2px; text-align:center; font-size:14px;">客户状态</th>
                        </tr>

                        <tbody id="rtbody">
                        <c:forEach items="${rpageInfo.list}" var="rcus">
                            <tr>
                                <td style="border-bottom:#e3e3e3 solid 1px;border-right:#e3e3e3 solid 1px;text-align:center; font-size:14px;padding:2px 0px;">${rcus.customer_name}</td>
                                <td style="border-bottom:#e3e3e3 solid 1px;border-right:#e3e3e3 solid 1px;text-align:center; font-size:14px;">${rcus.customer_phone}</td>
                                <td style="border-bottom:#e3e3e3 solid 1px;border-right:#e3e3e3 solid 1px;text-align:center; font-size:14px;">${rcus.customer_school}</td>
                                <td style="border-bottom:#e3e3e3 solid 1px;border-right:#e3e3e3 solid 1px;text-align:center; font-size:14px;">${rcus.customer_major}</td>
                                <c:if test="${ rcus.customer_status eq '0' }">
                                    <td style="border-bottom:#e3e3e3 solid 1px;border-right:#e3e3e3 solid 1px;text-align:center; font-size:14px;">已报名</td>
                                </c:if>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <ul id="PageNum" style="padding-top:8px;">
                        <li><a href="javascript:void(0)" onclick="rpage(0)">首页</a></li>
                        <li><a href="javascript:void(0)" onclick="rpage(1)">上一页</a></li>
                        <li><a href="javascript:void(0)" onclick="rpage(2)">下一页</a></li>
                        <li><a href="javascript:void(0)" onclick="rpage(3)">尾页</a></li>
                    </ul>
                    <span id="rpnum" style="display:none;">${rpageInfo.pageNum}</span>
                    <span id="rpages" style="display:none;">${rpageInfo.pages}</span>
                </div>

                <!--信息展示模块-->
                <div class="total" style="border:1px solid #e3e3e3;width:300px;height:230px;float:left;margin-left:10px;">
                    <div class="form_boxB" style="height:35px;border-bottom:1px solid #e3e3e3;line-height:35px;">
                        <b style="margin-left:5px;">信息</b><span><a style="float: right;margin-right:5px;">更多</a></span>
                    </div>
                    <table style="margin-left:10px;">
                        <c:forEach items="${monthInfos}" var="minfo">
                            <tr style="font-size: 14px;text-align:right;">
                                <td>今日待跟进:</td>
                                <td style="width: 50px;">${minfo.nodones}人</td>
                            </tr>
                            <tr style="font-size:14px;text-align:right;">
                                <td>本月未上门量:</td>
                                <td>${minfo.nodoor}人</td>
                            </tr>
                            <tr style="font-size:14px;text-align:right;">
                                <td>本月已上门量:</td>
                                <td>${minfo.hasdoor}人</td>
                            </tr>
                            <tr style="font-size: 14px;text-align:right;">
                                <td>本月上门率:</td>
                                <td>${mdoor}</td>
                            </tr>
                            <tr style="font-size:14px;text-align:right;">
                                <td>本月未报名量:</td>
                                <td>${minfo.mnodone}人</td>
                            </tr>
                            <tr style="font-size:14px;text-align:right;">
                                <td>本月已报名量:</td>
                                <td>${minfo.mhasdone}人</td>
                            </tr>
                            <tr style="font-size:14px;text-align:right;">
                                <td>本月报名率:</td>
                                <td>${enlist}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
    </div>
    <!-- /Contents -->
</div>
<!-- /wrap_right -->
</body>
</html>
