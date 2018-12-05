<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript">
    </script>
</head>

<body>
<div class="formbody">

    <div class="formtitle"><span>修改模块</span></div>
    <form action="/updateModel" method="post">
        <ul class="forminfo">
            <input type="hidden" name="model_id" value="${model.model_id}">
            <li><label>模块名称:&nbsp;&nbsp;</label><input name="model_name" type="text" class="dfinput" value="${model.model_name }" /></li>
            <li><label>模块url:&nbsp;&nbsp;</label><input name="url" type="text" class="dfinput" value="${model.url }" /></li>
            <label>&nbsp;</label>
            <input type="submit" value="确定" style="color:#fff;background:#46586A;width:100px;height:30px;margin-left:130px"/>
        </ul>
    </form>

</div>


</body>

</html>
