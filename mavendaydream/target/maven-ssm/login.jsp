<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>登录</title>
	<link rel="stylesheet" type="text/css" href="css/public.css" />
	<link rel="stylesheet" type="text/css" href="css/page.css" />
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/public.js"></script>
</head>
<body>

<!-- 登录body -->

<div class="logDiv">
	<img class="logBanner" src="img/logBanner.png" />
	<div class="logGet">
		<!-- 头部提示信息 -->
		<div class="logD logDtip">
			<p class="p1">登录</p>
		</div>
		<!-- 输入框 -->
		<form action="login" method="post">
			<div class="lgD">
				<img class="img1" src="img/logName.png" /><input type="text" name="username"
																 placeholder="输入用户名" value="admin" />
			</div>
			<div class="lgD">
				<img class="img1" src="img/logPwd.png" /><input type="password" name="password"
																placeholder="输入用户密码" value="123456" />
			</div>
			<div class="logC">
				<button>登 录</button>
			</div>
		</form>
	</div>
</div>

<!-- 登录body  end -->

<!-- 登录页面底部 -->
<div class="logFoot">
	<p class="p1">版权所有：SC180501三阶段项目DAYDREAM</p>
</div>
<!-- 登录页面底部end -->

</body>
</html>