<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
          <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示单本书的详细信息</title>
	<style type="text/css">
	 .icon{
		width:270px;
		text-align: left;
		margin:25px;
		}
	 .sub{
	 	background-color:#ffb120;
	 	display:inline-block;
	 	height:35px;
	 	weight:130px;
	 	border-radius: 10px;
	 	text-align: center;
	 	color: white;
	 	font-weight: bold;
	 }
	 .sub:hover{
	 	background-color:#f9a200;
	 	display:inline-block;
	 	height:35px;
		border-radius: 10px;
	 	weight:130px;
		text-align: center;
	 	color: white;
		font-weight: bold;
	 }
	 li{
	 	margin: 10px;
	 }
	 .form{
	 	text-indent:40px;
	 }
	
	</style>
</head>
<body>
 <div>	
	<div class="icon">
	<img src="<c:url value='${book.image }'/>" height="200" width="200"  border="0"/>
	</div>
	
	<ul>
		<li>书名：${book.bookName }</li>
		<li>作者：${book.author }</li>
		<li>单价：${book.price }元</li>
	</ul>

	<form id="form" action="<c:url value='/CartController/add?'/>" method="post" class="form">
		<input type="text" name="num" value="1" style="width:60px"/>
		<input type="hidden" name="bid" value="${book.bid }"/>
		<input type="submit" value="加入购物车" class="sub"/>
	</form>
 </div>
</body>
</html>