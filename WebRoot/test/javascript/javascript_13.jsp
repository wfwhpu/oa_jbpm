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

alert(H1); //将得到函数的定义

//alert(H2); //将出错，H2被定义到H1的内部，所以在H1的外部看不到这个变量

H1(); //可以执行，因为在这里能够看到H1

function H1(){

	alert(H2); //将得到函数的定义
	//alert(H3); //将出错，H3被定义到H2的内部，所以在H2的外部看不到这个变量
	
	H2(); //可以执行，因为在这里可以看到H2
	function H2(){
		alert(H3); //将得到函数的定义
		function H3(){
		}
	}
}

</script>
  </head>
  
  <body onload="dosomething()">
	<div id="d1">
	</div>
	<div id="d2">
	</div>
  </body>
</html>
