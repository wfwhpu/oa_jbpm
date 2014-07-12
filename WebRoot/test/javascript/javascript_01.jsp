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
var a = 12;
var b = "12";
var c = true;
var d = new Number(12);
var e = new String("333");
var f = new Boolean("true");
var g = {};
var h = function(){};
function fn(){//每一个函数都是构造函数
	alert("something");
}
var k = new fn(); //new关键字，能够触发执行构造函数中的代码

alert(typeof a); //number
alert(typeof b); //string
alert(typeof c); //boolean
alert(typeof d); //object
alert(typeof e); //object
alert(typeof f); //object
alert(typeof g); //object
alert(typeof h); //function
alert(typeof fn); //function
alert(typeof k); //object
alert(typeof i); //undefined

</script>
  </head>
  
  <body>
    This is my JSP page. <br>
  </body>
</html>
