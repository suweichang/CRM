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
    <form action="addStu" method="post" onsubmit="return check1()">
        <!-- SubPopup -->
        <div id="SubPopup">
            <div class="form_boxC">
                <h2>添加学员</h2>
                <table cellpadding="0" cellspacing="0">
                    <tr>
                        <th width="100">学员姓名 <span class="f_cB"></span></th>
                        <td><div class="txtbox floatL" style="width:150px;"><input name="studentName" type="text" size="15" value="张三"></div></td>
                    </tr>
                    <tr>
                        <th>所在班级 <span class="f_cB"></span></th>
                        <td><div class="txtbox floatL" style="width:150px;"><select name="classId" style="height: 29px">
                            <c:forEach items="${list}" var="temp">
                                <option value="${temp.class_id}">${temp.class_name}</option>
                            </c:forEach>
                        </select>
                        </div>
                        </td>
                        <%--<td><div class="txtbox floatL" style="width:100px;"><input name="classId" type="text" size="15" value="11"></div></td>--%>
                    </tr>
                    <tr>
                        <th>性别 <span class="f_cB"></span></th>
                        <td><div class="txtbox floatL" style="width:150px;"><input name="studentSex" type="text" size="15" value="男"></div></td>
                    </tr>
                    <tr>
                        <th>毕业院校 <span class="f_cB"></span></th>
                        <td><div class="txtbox floatL" style="width:150px;"><input name="studentSchool" type="text" size="15" value="南昌大学"></div></td>
                    </tr>
                    <tr>
                        <th>学历 <span class="f_cB"></span></th>
                        <td><div class="txtbox floatL" style="width:150px;"><input name="studentEducation" type="text" size="15" value="本科"></div></td>
                    </tr>
                    <tr>
                        <th>专业 <span class="f_cB"></span></th>
                        <td><div class="txtbox floatL" style="width:150px;"><input name="studentMajor" type="text" size="15" value="软件工程"></div></td>
                    </tr>
                    <tr>
                        <th>籍贯 <span class="f_cB"></span></th>
                        <td><div class="txtbox floatL" style="width:150px;"><input name="studentNative" type="text" size="15" value="江西"></div></td>
                    </tr>
                    <tr>
                        <th>电话 <span class="f_cB"></span></th>
                        <td><div class="txtbox floatL" style="width:150px;"><input name="studentTel" type="text" size="15" value="170727189"></div></td>
                    </tr>
                    <tr>
                        <th>QQ <span class="f_cB"></span></th>
                        <td><div class="txtbox floatL" style="width:150px;"><input name="studentQq" type="text" size="15" value="122288999"></div></td>
                    </tr>
                </table>
            </div>
        </div>
        <!-- SubPopup -->

        <div id="BtmBtn">
            <div class="btn_boxB floatR mag_l20"><a href="student" ><input name="" type="button" value="取消" /></a></div>
            <div class="btn_box floatR"><input name="" type="submit" value="提交" /></div>
        </div>
    </form>
</div>
<!-- /Popup -->
</body>
</html>
