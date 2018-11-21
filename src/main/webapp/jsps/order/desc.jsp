<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单详情</title>
<style type="text/css">
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
</style>
</head>
<body>
	<h1>当前订单</h1>
	<table border="1" width="100%" cellspacing="0" background="black">
		<tr bgcolor="gray" bordercolor="gray" align="center">
			<td colspan="6">
			订单编号：${order.oid}&nbsp;&nbsp; &nbsp; 成交时间：<fmt:formatDate pattern="yyyy-mm-dd hh:mm:ss" value="${order.ordertime }"/>&nbsp;&nbsp; &nbsp;
			总金额：<font color="red"><b>${order.totalPrice }元</b></font>
			</td>
		</tr>
	<c:forEach items="${order.orderItemList }" var="orderItem">	
		<tr bordercolor="gray" align="center">
			<td width="15%">
				<div><img src="<c:url value='${orderItem.book.image }'/>" height="200" width="200" /></div>
			</td>
			<td>书名：${orderItem.book.bookName }</td>
			<td>单价：${orderItem.book.price }</td>
			<td>作者：${orderItem.book.author }</td>
			<td>数量：${orderItem.num }</td>
			<td>小计：${orderItem.itemPrice }元</td>
		</tr>
	</c:forEach>
	</table>
	
	<form action="<c:url value='/OrderController/pay'/>" method="post">
		<input type="hidden" name="oid" value="${order.oid }"/>
		收货地址：<input type="text" name="address" size="50" /><br/>
		选择银行：<br/>
		<input type="radio" name="银行" value="工商银行" checked="checked"/>工商银行
		<input type="radio" name="银行" value="农业银行"/>农业银行<br/><br/>
		<input type="radio" name="银行" value="建设银行"/>建设银行
		<input type="radio" name="银行" value="南京银行"/>南京银行<br/><br/>
		<input type="radio" name="银行" value="交通银行"/>交通银行
		<input type="radio" name="银行" value="中国银行"/>中国银行<br/><br/>
		<input type="submit" value="前往付款" class="sub"/>
	</form>
</body>
</html>