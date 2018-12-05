<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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

    <div class="formtitle"><span>增加角色</span></div>
    <form action="/addRoles" method="post">
        <ul class="forminfo">
            <li><label>角色名称:&nbsp;&nbsp;</label><input name="role_name" type="text" class="dfinput" /></li>
            <li><label>选择权限:&nbsp;&nbsp;</label></li>
            <li>
                <c:forEach items="${parentModel}" var="temp" varStatus="status">
                    <input type="checkbox" name="power" value="${temp.model_id}" />${temp.model_name}

                </c:forEach>
            </li>
            <label>&nbsp;</label>
            <input type="submit" value="确定" style="color:#fff;background:#46586A;width:100px;height:30px;margin-left:130px"/>
        </ul>
    </form>

</div>


</body>

</html>
