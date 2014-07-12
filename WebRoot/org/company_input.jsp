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
	<title>添加或更新公司信息</title>
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.custom.min.js"></script>
<script type="text/javascript" src="js/jquery.jstree.js"></script>
<style type="text/css">
<!--
body {
	font-family: Arial, Helvetica, sans-serif;
	font-size:12px;
	color:#666666;
	background:#fff;
	text-align:center;

}

* {
	margin:0;
	padding:0;
}

a {
	color:#1E7ACE;
	text-decoration:none;	
}

a:hover {
	color:#000;
	text-decoration:underline;
}
h3 {
	font-size:14px;
	font-weight:bold;
}

pre,p {
	color:#1E7ACE;
	margin:4px;
}
input, select,textarea {
	padding:1px;
	margin:2px;
	font-size:12px;
}
.buttom{
	padding:1px 10px;
	font-size:12px;
	border:1px #1E7ACE solid;
	background:#D0F0FF;
}
#formwrapper {
	width:95%;
	margin:15px auto;
	padding:20px;
	text-align:left;
}

fieldset {
	padding:10px;
	margin-top:5px;
	border:1px solid #1E7ACE;
	background:#fff;
}

fieldset legend {
	color:#1E7ACE;
	font-weight:bold;
	background:#fff;
}

fieldset label {
	float:left;
	width:60px;
	text-align:right;
	padding:4px;
	margin:1px;
}

fieldset div {
	clear:left;
	margin-bottom:2px;
}

.enter{ text-align:center;}
.clear {
	clear:both;
}

-->
</style>
</head>
<body>

<div id="formwrapper">
	<h3>请设置公司的基本信息</h3>
	<form action="system/company.action" method="post">
	<input type="hidden" name="method:save" value="">
	<input type="hidden" name="id" value="<s:property value="id"/>">
	<fieldset>
		<legend>公司基本信息设置（在进行组织机构设置之前，请先设置公司的基本信息）
		</legend>
		<div>
			<label for="name">名称</label>
			<input type="text" name="name" id="name" value="${name }" size="60"  /> 
			<br />	
		</div>
		<div>
			<label for="tel">电话</label>
			<input type="text" name="tel" id="tel" value="${tel }" size="30"  /> 
			<br />	
		</div>
		<div>
			<label for="fax">传真</label>
			<input type="text" name="fax" id="fax" value="${fax }" size="30"  /> 
			<br />	
		</div>
		<div>
			<label for="address">地址</label>
			<input type="text" name="address" id="address" value="${address }" size="60"  /> 
			<br />	
		</div>
		<div>
			<label for="postcode">邮编</label>
			<input type="text" name="postcode" id="postcode" value="${postcode }" size="20"  /> 
			<br />	
		</div>
		<div>
			<label for="site">网站</label>
			<input type="text" name="site" id="site" value="${site }" size="30"  /> 
			<br />	
		</div>
		<div>
			<label for="email">电子邮件</label>
			<input type="text" name="email" id="email" value="${email }" size="30"  /> 
			<br />	
		</div>
		<div>
			<label for="industry">所属行业</label>
			<input type="text" name="industry" id="industry" value="${industry }" size="30"  /> 
			<br />	
		</div>
		<div>
			<label for="description">描述</label>
			<input type="text" name="description" id="description" value="${description }" size="60" /> 
			<br />	
		</div>
		<div class="enter">
		<s:if test="permit('company','saveCompany')">
		    <input name="submit" type="submit" class="buttom" value="保存公司基本信息" />
		</s:if>
		    <input name="reset" type="reset" class="buttom" value="重置" />
		</div>		
	</fieldset>
	</form>
</div>

</body>
</html>

