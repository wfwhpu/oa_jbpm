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
	//对HTML DOM对象进行包装之后，只能使用jQuery相关的方法来操纵这些对象
	//下面是获取地址的值！
	alert($("#address").attr("value")); //北京
	
	//以下写法是错误的：
	alert($("#address").value); //undefine
	
	//以下写法是正确的
	//因为用document.getElementById()得到的是普通的HTML DOM对象
	alert(document.getElementById("address").value); //北京
	
	//以下写法是将一个普通的HTML DOM对象转换为jQuery包装的对象
	var v = $(document.getElementById("address")).attr("value");
	alert(v); //北京
	
	//以下写法是将一个jQuery包装的HTML DOM对象转换为HTML DOM对象
	//jQuery实际上相当于一个HTML DOM对象的数组，所以，直接将其中的HTML DOM对象取出即可
	//以下写法是正确的
	alert( $("#address")[0].value ); //北京
});


</script>
  </head>
  
  <body>
	<input type="text" name="name">
	<input type="text" name="age">
	<input type="text" id="address" name="address" value="北京">

  </body>
</html>
