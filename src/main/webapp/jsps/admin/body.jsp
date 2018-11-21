<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<style type="text/css">
	body{
		background-color:#fdedb5;
		background-size: cover;
	}
</style>
</head>
<body>
	<c:choose>
		<c:when test="${empty msg}"><h1>欢迎来到纸世界后台管理系统！</h1>
		</c:when>
		<c:otherwise>${msg}</c:otherwise>
	</c:choose>
</body>
</html>