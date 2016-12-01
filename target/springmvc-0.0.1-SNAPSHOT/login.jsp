<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户登录</title>
    
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
  	<div>
  		<form action="login.do" method="post">
  			<div id="error_msg" style="color: red">
  				<c:if test="${errorCode ne '0000' }">
  					${errorMsg }
  				</c:if>
  			</div>
  			用户名：<input name="registerName" type="text" value="${registerName }"/>
  			密码：<input name="password" type="password"/>
  			<input type="submit" value="登录"/>
  			<select name="saveCookieTime">
  				<option value="1">一天</option>
  				<option value="30">一月</option>
  				<option value="180">半年</option>
  			</select>
  		</form>
  	</div>
  </body>
</html>
