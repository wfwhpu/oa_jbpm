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

a = 10;
var b = 20;

function ABC(){
	alert("good!");
}

alert(a); //10
alert(b); //20
alert(ABC);//函数代码
alert(window.a);//10
alert(window.b);//20
alert(window.ABC);//函数代码
ABC();//good!
window.ABC();//good!

function H1(){
	alert(b); //在这个函数内部也可以访问，因为b变量是全局的
}
H1();//20

function H2(){
	test = "hello"; //这里，没有用var关键字，定义的是一个全局变量
}
H2();
alert(test); // hello

</script>
  </head>
  
  <body onload="dosomething()">
	<div id="d1">
	</div>
	<div id="d2">
	</div>
  </body>
</html>
