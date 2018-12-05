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
        //     /*$(".select").each(function(){
        //         var s=$(this);
        //         var z=parseInt(s.css("z-index"));
        //         var dt=$(this).children("dt");
        //         var dd=$(this).children("dd");
        //         var _show=function(){dd.slideDown(200);dt.addClass("cur");s.css("z-index",z+1);};
        //         var _hide=function(){dd.slideUp(200);dt.removeClass("cur");s.css("z-index",z);};
        //         dt.click(function(){dd.is(":hidden")?_show():_hide();});
        //         dd.find("a").click(function(){dt.html($(this).html());_hide();});
        //         $("body").click(function(i){ !$(i.target).parents(".select").first().is(s) ? _hide():"";});})*/
        //     alert(1);
        //     $(".checkbox").change(function () {
        //         alert(2);
        //             alert($(this).parent().text());
        //         });

        })

        function check1() {
            var num = 0;
            if($("#sel").val() == 0){
                alert("请选择学生");
                return false;
            }else if($("#ta").val() == ""){
                alert("面谈不能为空");
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
        <h2>添加面谈</h2>

        <form action="addInte" method="post" onsubmit="return check1()">
                <table cellpadding="0" cellspacing="0">
                    <tr>
                        <th>序号</th>
                        <th>学生姓名</th>
                        <th>面谈老师</th>
                        <th>日期</th>
                        <th>面谈内容</th>
                    </tr>
                        <tr>
                            <td>-</td>
                            <td>
                                <select id="sel" name="studentId">
                                    <option value="0">选择学生</option>
                                <c:forEach items="${list}" var="temp">
                                    <option value="${temp.studentId}">${temp.studentName}</option>
                                </c:forEach>
                                </select>
                            </td>
                            <td>${teacher.teacher_name}</td>
                            <td>${interviewDate}</td>
                            <td><textarea id="ta" name="interviewContent" cols="15" rows="4"></textarea></td>
                            <input type="hidden" name="interviewDate" value="${interviewDate}" />
                            <input type="hidden" name="classId" value="${classId}" />
                        </tr>
                </table>

        <div id="BtmBtn">
            <div class="btn_boxB floatR mag_l20" style="margin-right: 130px;margin-top: 20px"><a href="interview" ><input name="" type="button" value="取消" /></a></div>
            <div class="btn_box floatR" style="margin-top: 20px"><input name="" type="submit" value="提交" /></div>
        </div>
    </form>
</div>
</div>
</body>
</html>
