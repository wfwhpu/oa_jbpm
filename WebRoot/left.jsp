<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>CMS 后台管理工作平台</title>
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.custom.min.js"></script>
<script type="text/javascript" src="js/jquery.jstree.js"></script>
<script language="javascript">
	$(function(){
		//将menuContainer变成一棵树！
		$("#menuContainer").jstree({ 
			"json_data" : {
				"ajax" : {
					"url" : "system/index!menu.action"
				}
			},
			"themes" : {
				"theme" : "apple"
			},
			"plugins" : [ "themes", "json_data","ui"]
		});
		$("#menuContainer").bind(
			"select_node.jstree",
			function(e,data){
				//得到<li>标签下面的<a>标签定义的href属性的值
				var href = $(data.args[0]).attr("href");
				if(href != "" && href != "#"){
				 	$(window.parent.document).find("#rightFrame").attr("src",href);
				}
			}
		);
	});
</script>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	font-size:12px;
}

-->
</style>
</head>
<body>
<div id="menuContainer"  style="height:100%;">
</div>
</body>
</html>

