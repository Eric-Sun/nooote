<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="js/nooote.js"></script>
  </head>
  
  <body>

	<div class="login_body">
		<div class="login_content">
			<div class="login_title">登录入口</div>
			<div class="login_input">
				<span>&nbsp;邮箱地址：</span><samp><input id ="userMail" name="userMail" type="text"/></samp>
			</div>
			<div class="login_input">
				<span>&nbsp;密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</span><samp><input id ="userPwd" name="userPwd" type="password"/></samp>
			</div>
			<div class="login_btn"><a href="javascript:login()">登&nbsp;&nbsp;录</a></div>
		</div>
		<div class="login_bg">
			<div class="login_bgText">Welcome to here!</div>
		</div>
	</div>

</body>
</html>
