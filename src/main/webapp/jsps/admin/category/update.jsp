<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改分类</title>
<style type="text/css">
		body{
		background-color:#fdedb5;
		}
</style>
</head>
<body>
	<h1>修改分类</h1>
	<form action="<c:url value='/AdminCategoryController/updateCategory?cid=${category.cid }'/>" method="post">
		分类名称：<input type="text" name="nCategoryName" value="${category.categoryName }" />
		<input type="submit" value="修改分类" />
	</form>
</body>
</html>