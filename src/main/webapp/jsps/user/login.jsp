<%@ page contentType="text/html;charset=utf-8" language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
 <head><title>用户登录页面</title>
 </head>

 <body>
	<h1 align="left">用户登录页面</h1>
	<p style="color: red; font-weight: 900">${msg }</p>
	<form action="<c:url value='/UserController/login'/>" method="post">
		<table align="left" >
			<tr>
				<td><label for="username">用户名：</label></td> 
			</tr>
			<tr>
				<td><input type="text" name="username" value="${form.username }" id="username" placeholder="请输入用户名" /></td> 
			</tr>
			<tr>
				<td><label for="password">密码：</label></td>
			</tr>
			<tr>
				<td><input type="password" name="password" value="${form.password }" id="password" placeholder="请输入密码" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="登录"><a href="regist.jsp">注册</a></td>
			</tr>
		</table>
	</form>
	
 </body>
</html>