<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
            <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的订单</title>
	<style type="text/css">
		tr{
			text-align: center;
	}
	</style>
</head>
<body>
	<h1>我的订单</h1>
	<table border="1" width="100%" cellspacing="0" background="black">
	 <c:forEach items="${myOrders }" var="order">
		<tr bgcolor="gray" bordercolor="gray">
			<td colspan="6">
				订单编号：${order.oid} &nbsp;&nbsp; &nbsp;
				成交时间：<fmt:formatDate pattern="yyyy-mm-dd hh:mm:ss" value="${order.ordertime }"/>  &nbsp;&nbsp;&nbsp;
				金额：<font color="red"><b>${order.totalPrice}元</b></font>&nbsp;
  			 <c:choose>
				<c:when test="${order.state eq 1}">
					<a href="<c:url value='/OrderController/loadOrder?oid=${order.oid }'/>">付款</a>
				</c:when>
				<c:when test="${order.state eq 2}">等待发货</c:when>
				<c:when test="${order.state eq 3}">
					<a href="<c:url value='/OrderController/confirm?oid=${order.oid }'/>">确认收货</a>
				</c:when>
				<c:when test="${order.state eq 4}">订单已完成</c:when>
			 </c:choose>	
			</td>
		</tr>
		<c:forEach items="${order.orderItemList }" var="orderItem">
			<tr>
				<td width="15%">
					<div><img src="<c:url value='${orderItem.book.image }'/>" height="200" width="200" /> </div>
				</td>
				<td>书名：${orderItem.book.bookName }</td>
				<td>单价：${orderItem.book.price }</td>
				<td>作者：${orderItem.book.author }</td>
				<td>数量：${orderItem.num }</td>
				<td>小计：${orderItem.itemPrice }元</td>
			</tr>
		</c:forEach>
	 </c:forEach>
	</table>
</body>
</html>