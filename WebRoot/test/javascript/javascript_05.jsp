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

function FF(){}

alert(FF.prototype);

var f = new FF();
alert(f.prototype);

//给对象添加属性
FF.a = "FF.a";
alert(FF.a); //FF.a

f.a = "f.a";
alert(f.a); //f.a

FF.prototype.a = "FF.prototype.a";
alert(FF.prototype.a); // FF.prototype.a

FF.prototype.b = "FF.prototype.b";
alert(f.b); //FF.prototype.b
alert(FF.b); //undefined


</script>
  </head>
  
  <body>
    This is my JSP page. <br>
  </body>
</html>
