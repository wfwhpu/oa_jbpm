<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'javascript_01.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">

(function(){
	function hello(){ //这个定义，能够覆盖全局定义
		alert("ok");
	}
	hello(); //调用的是内部函数，因为在本命名空间中，它代表的就是内部函数定义
})(); //定义一个函数（通常是一个匿名函数），并立刻执行，可以将代码进行封装，避免代码中的定义污染全局命名空间

function hello(){ //全局函数
	alert("hh");
}
hello();


</script>
  </head>
  
  <body onload="dosomething()">
	<div id="d1">
	</div>
	<div id="d2">
	</div>
  </body>
</html>
