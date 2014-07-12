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

var p = {
	name:"张三",
	sex:"女",
	org:{
		name:"北京领航致远",
		city:"北京",
		address:{
			street : "马家堡",
			otherproperty:["A","B",14,true]
		}
	}
};

alert(p.name);
alert(p.org.name);
alert(p.org.address.street);
alert(p.org.address.otherproperty[2]);

</script>
  </head>
  
  <body>
    This is my JSP page. <br>
  </body>
</html>
