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
var x = "I'm a global variable!";
function method() {
    alert(x);
    alert(this.x);
}
function class1() {
    // private field
    var x = "I'm a private variable!";
    // private method
    function method1() { //内部函数
        alert(x);
        alert(this.x);
    }
    var method2 = method;
    // public field
    this.x = "I'm a object variable!";
    // public method
    this.method1 = function() {
        alert(x);
        alert(this.x);
    }
    this.method2 = method;
    // constructor
    {
        this.method1();     // I'm a private variable!
                            // I'm a object variable!
        this.method2();     // I'm a global variable!
                            // I'm a object variable!
        method1();          // I'm a private variable!
                            // I'm a global variable!
        method2();          // I'm a global variable!
                            // I'm a global variable!
        method1.call(this); // I'm a private variable!
                            // I'm a object variable!
        method2.call(this); // I'm a global variable!
                            // I'm a object variable!
    }
}
 
var o = new class1();
method();       // I'm a global variable!
                // I'm a global variable!
o.method1();    // I'm a private variable!
                // I'm a object variable!
o.method2();    // I'm a global variable!
                // I'm a object variable!

</script>
  </head>
  
  <body onload="dosomething()">
	<div id="d1">
	</div>
	<div id="d2">
	</div>
  </body>
</html>
