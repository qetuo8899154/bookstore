<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车列表</title>
<style type="text/css">
	a {
  		text-decoration:none;
		text-indent:50px;
       	color: black;
      } 
    a:hover{
		text-decoration:underline;
	}
	tr{
		text-align: center;
	}
</style>
</head>
<body>
 <h1 align="center">购物车</h1>
 <table border="1" width="100%" cellspacing="0" background="black" >
 	<tr>
 		<td colspan="7" align="right" style="font-size: 15pt;font-weight: bold">
 			<a href="<c:url value='/CartController/clear'/>">清空购物车</a>
 		</td>
 	</tr>
 	<tr>
 		<th>图片</th>
 		<th>书名</th>
 		<th>作者</th>
 		<th>单价</th>
 		<th>数量</th>
 		<th>小计</th>
 		<th>操作</th>
 	</tr>
 <c:forEach items="${sessionScope.cart.cartItems }" var="cartItem">
 	<tr>
 		<td><div><img src="<c:url value='${cartItem.book.image }'/>" height="200" width="200" /></div></td>
		<td>${cartItem.book.bookName}</td>
		<td>${cartItem.book.author}</td>
 		<td>${cartItem.book.price}</td>
 		<td>${cartItem.num }</td>
 	 	<td>${cartItem.itemPrice }元</td>
 	 	<td><a href="<c:url value='/CartController/delete?bid=${cartItem.book.bid }'/>">删除</a></td>
 	</tr>
 </c:forEach>
 	<tr>
 		<td colspan="7" align="right" style="font-size: 15pt;font-weight: bold">
 			合计：${sessionScope.cart.totalPrice}元
 		</td>
 	</tr>
 	<tr>
 		<td colspan="7" align="right" style="font-size: 20pt;">
 		<a href="<c:url value='/OrderController/addOrder'/>">付款</a>
 		</td>
 	</tr>
 </table>
</body>
</html>