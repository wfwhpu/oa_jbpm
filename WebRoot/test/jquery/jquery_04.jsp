<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'jquery_01.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript">
$(function(){
	alert($("input").length); //3
	alert($("input").size()); //3
	
	//对所有的input元素，增加disabled属性，取值为disabled
	//$("input").attr("disabled","disabled");
	
	//选取包含有属性"name"，其取值为"address"的元素"input"
	$("input[name='address']").attr("disabled","disabled");
});

</script>
  </head>
  
  <body>
	<input type="text" name="name">
	<input type="text" name="age">
	<input type="text" name="address">

  </body>
</html>
