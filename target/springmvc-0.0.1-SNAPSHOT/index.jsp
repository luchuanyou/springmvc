<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>首页</title>
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
  	<jsp:include page="user_title.jsp"></jsp:include>
  	<hr/>
  	<div style="width: 300; margin: auto;" >
  		<table>
  			<tr>
  				<td>
  					<a href="" >我是首页</a>
  				</td>
  			</tr>
  			<tr>
  				<td>
  					<a href="login.jsp" >登录页面（自动登录）</a>
  				</td>
  			</tr>
  			<tr>
  				<td>
  					<a href="member/getMemberInfo.do" ><span style="color: red; font-size: 18">需要登录才可以访问</span></a>
  				</td>
  			</tr>
  			<tr>
  				<td>
  					<a href="member/loginOut.do" >退出登录</a>
  				</td>
  			</tr>
  		</table>
    </div>
  </body>
</html>
