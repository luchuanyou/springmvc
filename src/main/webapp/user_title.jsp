<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户信息</title>
    <style type="text/css">
    	a{
    		text-decoration: none;
    	}
    </style>
  </head>
  
  <body>
  	<%
  		Object registerName = session.getAttribute("registerName");
  		if(null == registerName){
  	 %>
  	 <div style="margin-left: 10px;">
  	 	<table>
  	 		<tr>
  	 			<td>
  	 				<a href="login.jsp" ><span style="color: red; font-size: 12">亲，登录</span></a>
  	 			</td>
  	 			<td width="10px"></td>
  	 			<td>
  	 				<a href="login.jsp"><span style= "font-size: 12">免费注册</span></a>
  	 			</td>
  	 		</tr>
  	 	</table>
  	 </div>
  	 <%}else{ %>
  	 	<table>
  	 		<tr>
  	 			<td>
  	 				<a href="login.jsp" ><span style="color: red; font-size: 12">欢迎您：${registerName }</span></a>
  	 			</td>
  	 			<td width="10px"></td>
  	 			<td>
  	 				<a href="member/loginOut.do"><span style= "font-size: 12">退出</span></a>
  	 			</td>
  	 		</tr>
  	 	</table>
  	  <%}%>
  </body>
</html>
