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
        	background: #787878;
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
<h1 style="text-align: center;">纸世界网上书城后台管理系统</h1>
<div style="font-size: 10pt; line-height: 10px;text-indent:50px;position:absolute;bottom:25px;">	
		管理员：${sessionScope.session_admin.username}&nbsp;&nbsp;

</div>
 </body>
</html>