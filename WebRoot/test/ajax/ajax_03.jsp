<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ajax_01.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">

function testAjax(){
	//创建此对象
	var xmlHttpReq = init(); 
	
	//打开此对象，准备发送，同步请求
	xmlHttpReq.open("GET","system/party!ajax.action",false);
	
	function process(){
		var txt = xmlHttpReq.responseText;
		alert("txt = "+txt);
	}
	
	//发送
	xmlHttpReq.send(null);

	if(xmlHttpReq.readyState == 4 && xmlHttpReq.status == 200){
		process();
	}

	alert("随便！！！");

	function init(){
　　		if (window.XMLHttpRequest) {
　　　		return new XMLHttpRequest();
　　		} 
　		else if (window.ActiveXObject) {
　　			return new ActiveXObject("Microsoft.XMLHTTP");
　		}
	}
}

</script>
  </head>
  
  <body onload="testAjax();">
    This is my JSP page. <br>
  </body>
</html>
