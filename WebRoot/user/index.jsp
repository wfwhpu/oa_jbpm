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
	<title>列出所有的人员信息，并可以分配登录帐号</title>
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.custom.min.js"></script>
<script type="text/javascript" src="js/jquery.jstree.js"></script>
<script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
<style type="text/css" title="currentStyle"> 
	@import "js/datatable/css/demo_page.css";
	@import "js/datatable/css/demo_table.css";
</style>
<link href="org/js/party.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
var oTable;

$(function(){
	//创建AJAX表格
	oTable = $('#personList').dataTable( {
		"bProcessing": true,
		"bServerSide": true,
		"sAjaxSource": "system/user!list.action",
		"sPaginationType": "full_numbers",
		"oLanguage":{
			"sProcessing": "正在处理...",
			"sLengthMenu": "每页 _MENU_ 行<input type='button' value='添加用户' onclick='addUser()'><input type='button' value='删除用户' onclick='deleteUser()'><input type='button' value='更新用户' onclick='updateUser()'>", 
			"sZeroRecords": "没有找到记录",
			"sEmptyTable": "没有找到记录",
			"sInfo": "当前显示从 _START_ 到 _END_ ,总记录数： _TOTAL_",
			"sInfoEmpty": "",
			"sSearch": "搜索:",
			"oPaginate": {
				"sFirst":    "首页",
				"sPrevious": "前页",
				"sNext":     "下页",
				"sLast":     "尾页"
			}
		}
	} );
	
		//点击的时候，显示被点击的记录处于选中状态
	$("#personList tbody").click(function(event) {
		$(oTable.fnSettings().aoData).each(function (){
			$(this.nTr).removeClass('row_selected');
		});
		$(event.target.parentNode).addClass('row_selected');
	});
});

function addUser(){

	var anSelected = fnGetSelected( oTable );
	
	if(anSelected.length == 0){
		alert("请选中您要添加登录帐号的人员！");
		return;
	}
	//获得被选中记录的ID
	var personId = anSelected[0].children[0].innerHTML;

	window.location = "system/user!addInput.action?person.id="+personId;
}

function updateUser(){
	var anSelected = fnGetSelected( oTable );
	
	if(anSelected.length == 0){
		alert("请选中您要更新帐号的人员！");
		return;
	}
	//获得被选中记录的ID
	var personId = anSelected[0].children[0].innerHTML;
	
	window.location = "system/user!updateInput.action?id="+personId;
}

function deleteUser(){

	var anSelected = fnGetSelected( oTable );
	
	if(anSelected.length == 0){
		alert("请选中您要删除其帐号的人员！");
		return;
	}
	
	if(!confirm("请确认是否要删除选中人员的登录帐号，删除之后，此人员将无法登录系统！")){
		return;
	}
	
	//获得被选中记录的ID
	var personId = anSelected[0].children[0].innerHTML;
	$.get("system/user!del.action?id="+personId,function(){
		oTable.fnDeleteRow( anSelected[0] );
	});
}

function fnGetSelected( oTableLocal )
{
	var aReturn = new Array();
	var aTrs = oTableLocal.fnGetNodes();
	
	for ( var i=0 ; i<aTrs.length ; i++ )
	{
		if ( $(aTrs[i]).hasClass('row_selected') )
		{
			aReturn.push( aTrs[i] );
		}
	}
	return aReturn;
}
</script>
</head>
<body>

<div>
<table id="personList" class="display" width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
	<thead>
      <tr>
        <th width="10" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">ID</span></div></th>
        <th width="60" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">姓名</span></div></th>
        <th width="25" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">部门/岗位</span></div></th>
        <th width="50" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">登录帐号</span></div></th>
      </tr>
    </thead>
    <tbody>
    	<tr>
    		<td colspan="4">这里是数据</td>
    	</tr>
    </tbody>
</table>
</div>
</body>
</html>

