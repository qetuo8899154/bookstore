<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加分类</title>
<style type="text/css">
	body{
		background-color:#fdedb5;
		}
</style>
</head>
<body>
	<h1>添加分类</h1>
	<form action="<c:url value='/AdminCategoryController/addCategory'/>" method="post">
		分类名称：<input type="text" name="categoryName" />
		<input type="submit" value="添加分类"/>
	</form>
</body>
</html>