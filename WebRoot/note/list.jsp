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
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="js/nooote.js"></script>
  </head>
  
  <body onload="loadNoteList()">
  	
  	<div class="header">
		<li><a href="#">退出</a>&nbsp;</li>
		<li>|</li>
		<li class="userName">&nbsp;hi,einpon !</li>
	</div>

	<div class="list_body">
		<div class="listTitle">我的文档列表</div>
		<div class="btn"><a href="note/post.jsp">添加文档</a></div>
		<div class="list_content">
			<table id="noteList" cellpadding="0" cellspacing="0" border="0">
			</table>
		</div>
	</div>
  	
  </body>
</html>
