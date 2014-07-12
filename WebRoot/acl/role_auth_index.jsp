<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>    
<html>
<head>
<base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>OA办公自动化平台 - 角色授权主界面</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style>
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.custom.min.js"></script>
<script type="text/javascript" src="js/jquery.jstree.js"></script>
<script type="text/javascript">
$(function(){
	$("#roleTree").bind(
		"loaded.jstree", //当菜单树加载完毕，触发本事件被执行
		function(event,data){
			//默认打开所有的节点
			$("#roleTree").jstree("open_all",-1);
		}
	);
	$("#roleTree").jstree({ 
		"json_data" : {
			"ajax" : {
				"url" : "system/acl!roleAuthIndexTree.action",
				"data": function(node){
					return {id: node.attr ? node.attr("id"):0};
				}
			}
		},
		"themes" : {
			"theme" : "classic"
		},
		"plugins" : [ "themes", "json_data","ui"]
	});
	$("#roleTree").bind(
		"select_node.jstree",
		function(e,data){
			//得到<li>标签上面定义的principalId属性的值
			var principalId = data.rslt.obj.attr("principalId");
			var principalType = data.rslt.obj.attr("principalType");
			$("#rightFrame").attr("src","system/acl!allMenuResource.action?principalId="+principalId+"&principalType="+principalType);
		}
	);
});

function refresh(){
	//调用refresh方法，刷新整棵组织机构树
	$("#roleTree").jstree("refresh","#roleTree");
}

</script>
</head>

<body>
<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="147" id="leftMenu" valign="top">
    	<div id="roleTree">
    	</div>
    </td>
    <td width="5" bgcolor="#add2da">&nbsp;</td>
    <td valign="top"><iframe height="100%" width="100%" frameborder="0" frameborder="0" src="right.jsp" name="rightFrame" id="rightFrame" title="rightFrame"></iframe></td>

  </tr>
</table>
</body>
</html>

