<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>海丁网</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<style type="text/css">
		#head{background-color:blue;}
</style>
	</head>

	<body>
		<div id="head">
			<div id="head_activity">
				<ul>
					<li>
						<a href="#">海丁网</a>
					</li>
					<li>
						|
					</li>
					<li>
						<a href="#">社区活动</a>
					</li>
					<li>
						|
					</li>
					<li>
						<a href="求职招聘"></a>
					</li>
					<li>
						|
					</li>
					<li>
						主题社区
					</li>
				</ul>
			</div>
			<div id="head_search">
				<input type="text" />
			</div>
			<div id="head_user">
				<input type="text" readonly value="吴方伟" />
			</div>
			<div id="head_email">
				<img src="" alt="邮件" />
			</div>
			<div id="head_set">
				<img src="" onmouseover="" onmouseout="">
				<ul>
					<li>
						<a href="#">用户中心</a>
					</li>
					<li>
						<a href="#">我的人脉</a>
					</li>
					<li>
						<a href="#">交易管理</a>
					</li>
					<li>
						<a href="#">数据中心</a>
					</li>
					<li>
						<a href="#">退出</a>
					</li>
				</ul>
			</div>
		</div>
	</body>
</html>
