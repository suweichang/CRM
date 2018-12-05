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

    <div class="formtitle"><span>修改角色权限</span></div>
    <form action="/updateRole" method="post">
        <ul class="forminfo">
            <input type="hidden" name="role_id" value="${role.role_id}">
            <li><label>角色名称:&nbsp;&nbsp;</label><input name="role_name" type="text" class="dfinput" value="${role.role_name}" /></li>
            <li><label>修改权限:&nbsp;&nbsp;</label></li>
            <li>
                <c:forEach items="${parentModel}" var="temp" varStatus="status">
                    <c:choose>
                        <c:when test="${fn:contains(power,temp.model_id )}">
                            <input type="checkbox" checked name="power" value="${temp.model_id}" />${temp.model_name}
                        </c:when>
                        <c:otherwise>
                            <input type="checkbox" name="power" value="${temp.model_id}" />${temp.model_name}

                        </c:otherwise>
                    </c:choose>

                </c:forEach>
            </li>
            <label>&nbsp;</label>
            <input type="submit" value="确定" style="color:#fff;background:#46586A;width:100px;height:30px;margin-left:130px"/>
        </ul>
    </form>

</div>


</body>

</html>
