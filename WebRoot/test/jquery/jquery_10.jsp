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
	function(){
		alert( $(".test").is(":hidden") ); //是否是不可见的
		alert( $("#sh").is(":visible") ); //是否是可见的
		alert( $("#sn").is(".test") ); //是否包含class为test
		alert( $("#sh").is(".test") ); //是否包含class为test
	}
);
</script>
</head>
<body>
<input type="text" value="sina" class="test" id="sn" style="display:none">
<input type="text" value="sohu" id="sh">
</body>

</html>
