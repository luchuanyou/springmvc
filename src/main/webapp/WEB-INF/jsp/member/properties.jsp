<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>init</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  	<div style="width: 300; margin: auto;" >
  		<form action="test/getProperties.do" method="post">
  		<table>
  			<tr>
  				<td>
  					key：<input name="key" type="text"/>
  				</td>
  				<td>值：${val }</td>
  			</tr>
  			<tr>
  				<td>
  					<input name="查询" type="submit"/>
  				</td>
  			</tr>
  		</table>
  		</form>
    </div>
  </body>
</html>
