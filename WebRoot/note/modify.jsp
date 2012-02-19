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
	<script type="text/javascript" src="js/ckeditor/ckeditor.js"></script>
  </head>

  
  <body onload="loadEditor();loadNote()">
  	<div class="header">
		<li><a href="#">退出</a>&nbsp;</li>
		<li>|</li>
		<li class="userName">&nbsp;hi,einpon !</li>
	</div>

	<div class="add_body">
		<div class="listTitle">添加文档</div>
		<div class="add_content">
			<div class="titleInput">
				<span>&nbsp;文档标题：</span><samp><input id="noteTitle" type="text" /></samp>
			</div>
			<div class="codeInput">
				<span>&nbsp;文档内容：</span>
				<samp><div id="editor"></samp>
			</div>
			<div class="btn"><a href="javascript:postNote()">添&nbsp;&nbsp;加</a></div>
		</div>
	</div>
  </body>
</html>
