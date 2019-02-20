<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>message</title>
<style type="text/css">
	body{
		background-image: url(../img/背景2.jpg);
		background-size: cover;
	}
</style>
</head>
<body>
	<h1>${msg}</h1>
	<ul>
		<li><a href="<c:url value='/OrderController/myOrders'/>">返回</a></li>
		<li><a href="<c:url value='/jsps/body.jsp'/>">首页</a></li>
	</ul>
</body>
</html>