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
    <link href="css/haiersoft.css" rel ="stylesheet" type="text/css" media="screen,print" />
    <link href="css/print.css" rel="stylesheet" type="text/css"  media="print" />
    <script src="js/jquery-1.10.1.min.js"></script>
    <script src="js/side.js" type="text/javascript"></script>

    <!--[if lt IE 9]>
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    <script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
    <![endif]-->
    <script>
        $(function () {

            // $("#classid").change(function () {
            //     var classId = $("select option:selected").val();
            //     alert(classId);
            //   $.ajax({url:"/houtai/getStuByClass",
            //       type: "POST",
            //       data: "classId=" + classId
            //   });
            // });

        })
        function check() {
            if($("#classid").val() == 0){
                alert("请选择班级");
                return false;
            }
            else if($("#idate").val() == ""){
                alert("请选择日期");
                return false;
            }
            else {
                return true;
            }
        }
    </script>
</head>

<body>


<!-- MainForm -->
<div id="MainForm">
    <div class="form_boxA">
        <h2>回访信息 </h2>

        <div class="txtbox floatL mag_r20">
            <form action="getStuByClassB" method="post" onsubmit="return check()" >
            <span class="sttl">选择班级：<select id="classid" name="classId" style="height: 29px">
                <option value="0">请选择</option>
                    <c:forEach items="${classlist}" var="temp">
                        <option value="${temp.class_id}">${temp.class_name}</option>
                    </c:forEach>
                    </select></span>
                <span class="sttl">选择日期<input id="idate" name="callbackDate" type="date" value="" /></span>
                <span class="sttl"><div class="btn_box mag_l20"><input name="" type="submit" value="增加" onMouseMove="this.className='input_move'" onMouseOut="this.className='input_out'"></div></span>
            </form>
        </div>
        <table cellpadding="0" cellspacing="0">
            <tr>
                <th>序号</th>
                <th>回访时间</th>
                <th>回访内容</th>
                <th>回访人</th>
                <th>照片上传</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${list.list}" var="temp">
                <tr>
                    <td>${temp.callbackId}</td>
                    <td>${temp.callbackDate}</td>
                    <td>${temp.callbackContent}</td>
                    <td>${temp.studentName}</td>
                    <td><img src="/upload/${temp.photo}" height="100" width="100" /></td>
                    <td><a href="getCbById?id=${temp.callbackId}">修改</a></td>
                </tr>
            </c:forEach>

        </table>
    </div>
</div>
<!-- /MainForm -->

<!-- PageNum -->
<ul id="PageNum">
    <li><a href="callback?cPage=${list.firstPage}">首页</a></li>
    <li><a href="callback?cPage=${list.prePage}">上一页</a></li>
    <li><a href="callback?cPage=${list.nextPage}">下一页</a></li>
    <li><a href="callback?cPage=${list.lastPage}">尾页</a></li>
    <li>当前第${list.pageNum}页</li>
    <li>总数:${list.total}</li>
</ul>

</body>
</html>
