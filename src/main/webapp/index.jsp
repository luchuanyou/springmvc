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
  			<tr>
  				<td><a href="test/getProperties.do" >查询初始化properties值</a></td>
  			</tr>
  		</table>
    </div>
    <div>
    	<form action="https://openapi.baidu.com/rest/2.0/vis-ocr/v1/ocr/general" method="post">
    		<input type="submit" name="tijiao"/>
    		<input name="access_token" type="text" value="11.78f0eeccf8e4c0c0532a75d94149d9a8.1477552093112.0-8798677"/>
    		<input name="image" type="text" value="imageString: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
vmCbvz0AAAAASUVORK5CYII="/>
    	</form>
    </div>
  </body>
</html>
