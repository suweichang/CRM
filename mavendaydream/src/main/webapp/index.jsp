
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>首页</title>
  <c:if test="${flush!=null}">
    <%session.removeAttribute("flush");%>
    <script>window.parent.parent.parent.location.href="/index"</script>

  </c:if>
  <c:if test="${sessionScope.user==null}">
    <%response.sendRedirect("login.jsp"); %>
  </c:if>
</head>
<frameset rows="100,*" cols="*" scrolling="No" framespacing="0"
          frameborder="no" border="0"> <frame src="head.jsp"
                                              name="headmenu" id="mainFrame" title="mainFrame" scrolling="No"><!-- 引用头部 -->
  <!-- 引用左边和主体部分 -->
  <frameset rows="100*" cols="220,*" scrolling="No" framespacing="0" frameborder="no" border="0">
    <frame src="left.jsp" name="leftmenu" id="mainFrame" title="mainFrame">
    <frame src="/inotice" name="main" scrolling="yes" noresize="noresize" id="rightFrame" title="rightFrame">
  </frameset>
</frameset>
</html>