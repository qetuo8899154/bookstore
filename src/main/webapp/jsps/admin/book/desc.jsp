<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
          <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示单本书的详细信息</title>
	<style type="text/css">
	body{
		background-color:#fdedb5;
		}
	
	 .icon{
		width:270px;
		text-align: left;
		margin:25px;
		}
	
	 
	 li{
	 	margin: 10px;
	 }
	#form{
		margin:20px;
	}
	
	</style>
</head>
<body>
	<div class="icon">
	<img src="<c:url value='${book.image }'/>" border="0" height="200" width="200" />
	</div>

	<form id="form" action="<c:url value='/AdminBookController/edit?bid=${book.bid }'/>" method="post" >
		<input type="hidden"  name="image" value="${book.image }" />
		书名：<input type="text" name="bookName" value="${book.bookName }" /><br/>
		作者：<input type="text" name="author" value="${book.author }" /><br/>
		单价：<input type="text" name="price" value="${book.price }" />元<br/>
		图书分类：<select name="cid">
				<c:forEach items="${categoryList }" var="category">
					<option value="${category.cid }" <c:if test="${category.cid eq book.category.cid }">selected="selected"</c:if> 
					>${category.categoryName }</option>
				</c:forEach>
				</select><br/><br/>
		<input type="submit" value="修改" />
		<a onclick="return confirm('确认删除该图书？')" href="<c:url value='/AdminBookController/delete?bid=${book.bid}'/>" >删除</a>			
	</form>
</body>
</html>