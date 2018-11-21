<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
 	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 	<title>后台主页面</title>
<style type="text/css">
	body{
		margin: 0px;
	}
	iframe{
		width:100%;
		border: 1px solid grey;
		margin: 0px;
	}
	.table{
		width:100%;
		height:100%;
		border: 1px solid grey;
	}
</style>
 </head>
 <body>
	<table class="table" align="center">
		<tr style="height:120px">
			<td colspan="2" align="center">
				<iframe src="<c:url value='/jsps/admin/top.jsp'/>" name="a_top"></iframe>
			</td>
		</tr>
		<tr>  <!--valign 内容对齐方式，top上对齐  -->
			<td valign="top"  width="300" >		
				<iframe frameborder="0" height="550"
				src="<c:url value='/jsps/admin/left.jsp'/>" name="a_left"></iframe>
			</td>
			<td valign="top">
				<iframe height="550" frameborder="0" src="<c:url value='/jsps/admin/body.jsp'/>" name="a_body"></iframe>
			</td>
		</tr>
	</table>
 </body>
</html>