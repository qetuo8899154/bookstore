<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>booklist</title>
<style type="text/css">
	body{
		background-color:#fdedb5;
		}
	.icon{
		width:250px;
		float:left;
		text-align: center;
		margin:25px;
		border-style: outset;
	}
	a {
  		text-decoration:none;
       	color:black;
       	font-size: 15px;
       	font-weight: bold;
    } 
	a:hover{
		text-decoration:underline;
	}
</style>
</head>
<body>
	<h2>${msg }</h2>
	<c:forEach items="${bookList }" var="book">
		<div class="icon">
			<a href="<c:url value='/AdminBookController/detail?bid=${book.bid }' />" target="a_body"><img src="<c:url value='${book.image }' />" width="200" height="200"></a>
			<br/>
			<a href="<c:url value='/AdminBookController/detail?bid=${book.bid }' />" target="a_body" >${book.bookName }</a>
		</div>
	</c:forEach>
</body>
</html>