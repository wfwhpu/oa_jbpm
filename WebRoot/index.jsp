<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>       
<html>
<head>
<base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>领航致远办公自动化(OA)系统</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-image: url(images/login_01.gif);
	overflow:hidden;
}
.STYLE3 {font-size: 12px; color: #FFFFFF; }
.STYLE4 {
	color: #FFFFFF;
	font-family: "方正大黑简体";
	font-size: 50px;
}
-->
</style>
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript">
$(function(){
	$(window).keydown(function(e){
		if(e.keyCode == 13){
			if(document.forms[0].username.value == ""){
				alert("请输入用户名");
				return false;
			}
			if(document.forms[0].password.value == ""){
				alert("请输入密码");
				return false;
			}
			document.forms[0].submit();
		}
	});
});
</script>
</head>
<body>
<form action="system/login.action" method="post">
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td background="images/login_03.gif">&nbsp;</td>
        <td width="876"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="299" valign="top" background="images/login_oa.gif">&nbsp;</td>
          </tr>
          <tr>
            <td height="54"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="394" height="69" background="images/login_02.jpg">&nbsp;</td>
                <td width="199" background="images/login_03.jpg"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="22%" height="22"><div align="center"><span class="STYLE3">用户名</span></div></td>
                    <td width="51%" height="22"><input name="username" type="text" size="12" style="height:20px;background-color:#032e49; color:#88b5d1; border:solid 1px #88b5d1;" /></td>
                    <td width="27%" height="22">&nbsp;</td>
                  </tr>
                  <tr>
                    <td width="22%" height="22" valign="middle"><div align="center"><span class="STYLE3">密&nbsp; 码</span></div></td>
                    <td width="51%" height="22" valign="bottom"><input name="password" type="password" size="12" style="height:20px;background-color:#032e49; color:#88b5d1; border:solid 1px #88b5d1;" /></td>
                    <td width="27%" height="22" valign="bottom">&nbsp;</td>
                  </tr>
                  <tr>
                    <td height="22" valign="middle" class="STYLE3"><div align="center">验证码</div></td>
                    <td height="22" valign="middle"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="36%" height="22"><input name="textfield22" type="text" size="5" style="height:20px;background-color:#032e49; color:#88b5d1; border:solid 1px #88b5d1;" /></td>
                        <td width="64%" valign="bottom">&nbsp;<img src="images/yzm.gif" width="45" height="16"></td>
                      </tr>
                    </table></td>
                    <td height="22" valign="bottom">&nbsp;<img src="images/dl.gif" width="39" height="17" onclick="document.forms[0].submit();"/></td>
                  </tr>
                </table></td>
                <td width="283" background="images/login_04.jpg">&nbsp;</td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td height="225" background="images/login_05.jpg">&nbsp;</td>
          </tr>
        </table></td>
        <td background="images/login_03.gif">&nbsp;</td>
      </tr>
    </table></td> 
  </tr>
</table>
</form>
</body>
</html>