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

		<title>������</title>

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
						<a href="#">������</a>
					</li>
					<li>
						|
					</li>
					<li>
						<a href="#">�����</a>
					</li>
					<li>
						|
					</li>
					<li>
						<a href="��ְ��Ƹ"></a>
					</li>
					<li>
						|
					</li>
					<li>
						��������
					</li>
				</ul>
			</div>
			<div id="head_search">
				<input type="text" />
			</div>
			<div id="head_user">
				<input type="text" readonly value="�ⷽΰ" />
			</div>
			<div id="head_email">
				<img src="" alt="�ʼ�" />
			</div>
			<div id="head_set">
				<img src="" onmouseover="" onmouseout="">
				<ul>
					<li>
						<a href="#">�û�����</a>
					</li>
					<li>
						<a href="#">�ҵ�����</a>
					</li>
					<li>
						<a href="#">���׹���</a>
					</li>
					<li>
						<a href="#">��������</a>
					</li>
					<li>
						<a href="#">�˳�</a>
					</li>
				</ul>
			</div>
		</div>
	</body>
</html>
