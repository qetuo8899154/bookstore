<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
            <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台list</title>
	<style type="text/css">
	body{
		background-color:#fdedb5;
		}
	tr{
		text-align: center;
		height: 40px;
	}
	td{
		border: 1px solid black;
	}
	.th{
		background-color:#787878;
		font-weight: bold;
		font-style: black;
	}
	</style>
</head>
<body>
	<h2 style="text-align: center;">分类列表</h2>
	<table border="1" align="center" cellspacing="0" width="600px">
		<tr class="th" bordercolor="#787878">
			<td>分类名称</td>
			<td>操作</td>
		</tr>
	<c:forEach items="${categoryList}" var="category">
		<tr>
			<td>${category.categoryName }</td>
			<td><a href="<c:url value='/AdminCategoryController/loadCategory?cid=${category.cid}'/>" >修改</a>&nbsp;&nbsp;
				<a onclick="return confirm('确认删除该分类？')" href="<c:url value='/AdminCategoryController/deleteCategory?cid=${category.cid}'/>" >删除</a>			
			</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>