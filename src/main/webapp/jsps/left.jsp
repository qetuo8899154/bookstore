<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>left</title>
	<style type="text/css">
		div{
			margin: 0px; 
			text-align: center;
		}
		.first{
			background:#8ce7f0;
			color: #ffffff;
		}
		a {
   			text-decoration:none;
			text-indent:50px;
        	color: #ffffff;
    	} 
    	a:hover{
			text-decoration:underline;
		}
	</style>
</head>
<body>
 <div>
	<div class="first" align="center">
		<a href="<c:url value='/BookController/findAll'/>" target="body" >全部分类</a>
	</div>

<c:forEach items="${categoryList}" var="category">
	<div class="first">
		<a href="<c:url value='/BookController/findByCategory?cid=${category.cid }'/>" target="body">${category.categoryName}</a>
	</div>
</c:forEach>
	
 </div>
</body>
</html>