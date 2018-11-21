<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Top</title>
	 <style type="text/css">
		body {
        	background: #8ce7f0;
        	margin: 0px;
        	color: #ffffff;
   		}
   		a {
   			text-decoration:none;
			text-indent:50px;
        	color: #ffffff;
        	font-weight: 900;
    	} 
		a:hover{
			text-decoration:underline;
		}
	</style>
 </head>
 <body>
<h1 style="text-align: center;">纸世界网上书城</h1>
<div style="font-size: 10pt; line-height: 10px;text-indent:50px;position:absolute;bottom:25px;">	

	<%--依据用户是否登陆显示不同的连接 --%>
	<c:choose>
		<c:when test="${empty sessionScope.session_user}">
			<a href="<c:url value='/jsps/user/login.jsp'/>" target="_parent">登录</a> |&nbsp; 
			<a href="<c:url value='/jsps/user/regist.jsp'/>" target="_parent">注册</a>
		</c:when>
  
		<c:otherwise>
		欢迎：${sessionScope.session_user.username}&nbsp;&nbsp;|&nbsp;&nbsp;
		  <a href="<c:url value='/jsps/cart/cartList.jsp'/>" target="body">我的购物车</a>&nbsp;&nbsp;|&nbsp;&nbsp;
		  <a href="<c:url value='/OrderController/myOrders'/>" target="body">我的订单</a>&nbsp;&nbsp;|&nbsp;&nbsp;
		  <a href="<c:url value='/jsps/user/pwd.jsp'/>" target="body">修改密码</a>&nbsp;&nbsp;|&nbsp;&nbsp;
		  <a href="<c:url value='/UserController/quit'/>" target="_parent">退出</a>    
		</c:otherwise>
	</c:choose>

</div>
 </body>
</html>