<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
 	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 	<title>主页面</title>
<style type="text/css">
	iframe{
		width:100%;
		height:100%;
	}
	.table{
		width:1300px;
		height:650px;
	}
</style>
 </head>
 <body>
	<table class="table" align="center">
		<tr style="height:120px">
			<td colspan="2" align="center">
				<iframe src="<c:url value='/jsps/top.jsp'/>" name="top"></iframe>
			</td>
		</tr>
		<tr>  <!--valign 内容对齐方式，top上对齐  -->
			<td valign="top"  width="300" style="padding:5px;">		
				<iframe frameborder="0"  
				src="<c:url value='/CategoryController/findAll'/>" name="left"></iframe>
			</td>
			<td>
				<iframe src="<c:url value='/jsps/body.jsp'/>" name="body"></iframe>
			</td>
		</tr>
	</table>
 </body>
</html>