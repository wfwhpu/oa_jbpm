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
//理解javascript中的this
var obj1 = {
	prop1:"obj1:世界，你好",
	hello:function(){
		alert("obj1 alert:"+this.prop1);
	}
};

var obj2 = {
	prop1:"obj2:世界，你好",
	hello:function(){
		alert("obj2 alert:"+this.prop1);
	}
};

obj1.hello();
obj2.hello();

//通过call方法，可以改变函数内部的this的值
obj1.hello.call(obj2);

</script>
  </head>
  
  <body onload="dosomething()">
	<div id="d1">
	</div>
	<div id="d2">
	</div>
  </body>
</html>
