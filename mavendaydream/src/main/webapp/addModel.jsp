<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
        <html xmlns="http://www.w3.org/1999/xhtml">
        <head>
            <style type="text/css">
                ul{
                    list-style: none;
                }
            </style>
            <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
            <title>无标题文档</title>
            <script src="js/jquery-1.10.1.min.js"></script>
        </head>

<body>


<div class="formbody">

    <div class="formtitle"><span>添加模块</span></div>
    <form action="/addModel" method="post">
        <ul class="forminfo">
            <li><label>模块名称:&nbsp;&nbsp;</label><input name="model_name" type="text" class="dfinput" /></li>
            <li><label>是否为子模块:&nbsp;&nbsp;</label><cite>
                <input name="model_type" id="isSon" type="radio" value="2" checked="checked"  onchange="ifSon(1)" />是&nbsp;&nbsp;&nbsp;&nbsp;<input onchange="ifSon(2)" name="model_type" type="radio" value="1" />否</cite></li>
            <li id="url"><label>url:&nbsp;&nbsp;</label><input type="text" name="url"  class="dfinput"></input></li>
            <li id="parentmodule"><label>父模块:&nbsp;&nbsp;</label><cite>
                <select name="fid"  class="dfinput" >
                    <option value="0">请选择:&nbsp;&nbsp;</option>
                    <c:forEach items="${parentModel }" var="temp">
                        <option value="${temp.model_id }">${temp.model_name }</option>
                    </c:forEach>
                </select></cite>
            </li>
            <li>
                <label>&nbsp;</label>
                <input name="" type="submit" value="保存" style="color:#fff;background:#46586A" />
        </ul>
    </form>

</div>


</body>
<script type="text/javascript">
    function ifSon(son){
        if(son==1){
            $("#url").show();
            $("#parentmodule").show();
        }
        else if(son==2){
            $("#url").hide();
            $("#parentmodule").hide();
        }
    }
</script>
</html>
</title>
</head>
<body>

</body>
</html>
