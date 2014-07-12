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
$(document).ready(
	//页面加载完成，会调用本方法
	function(){
		//给a元素添加onclick事件处理函数
		$("a").click(
			function(event){
				alert("您访问的网址是："+event.target.href);
				//阻止缺省行为，a元素的缺省行为是打开其href地址
				event.preventDefault();
			}
		);
	}
);
</script>
</head>
<body>
<a href="http://www.sina.com.cn">sina</a>
<a href="http://www.sohu.com.cn">sohu</a>
  </body>
</html>
