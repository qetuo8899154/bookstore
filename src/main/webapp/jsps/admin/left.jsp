<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台left</title>
	<style type="text/css">
	body{
		background-color:#fdedb5;
		}
	* { margin:0; padding:0;}
	ul, li { list-style:none;text-align:center;}
	a { text-decoration:none;color:#3ccbdb;}
	.nav { solid #ccc; border-right:none; overflow:hidden; margin:0px;background-color:#787878;}
	.yi{border-top:1px;}
	.yi a { width:300px; text-align:center; line-height:40px; display:block; solid #ccc;
	 background-color:#787878; color:white;border-top:1px dotted #ccc;border-bottom:1px dotted #ccc;}
	.yi a:hover{ background:#3ccbdb; }
	
	.yi ul { position:absolute; display:none;}
	.yi ul li { float:none;}
	.yi ul li a { border-right:none; border-top:1px dotted #ccc; background:#3ccbdb;}
	.yi ul li a:hover {background:orange;}
	.yi:hover ul{ display:block; }

</style>
 </head>
 <body>
<div class="nav">
	<h2 align="center" style="padding-top: 10px"><font style="color: white;">纸世界网上书城</font></h2>
  <ul>    
    <li class="yi"><a href="#">分类管理</a>
      <ul>
        <li><a href="<c:url value='/AdminCategoryController/findAll'/>" target="a_body" >查看分类</a></li>

        <li><a href="<c:url value='/jsps/admin/category/add.jsp'/>" target="a_body" >添加分类</a></li>
      </ul>
    </li>
    <li class="yi"><a href="#">图书管理</a>
      <ul>
		<li><a href="<c:url value='/AdminBookController/findAll'/>" target="a_body" >查看图书</a></li>
		<li><a href="<c:url value='/AdminBookController/loadCategorList'/>" target="a_body" >添加图书</a></li>
      </ul>
    </li>
    <li class="yi"><a href="#">订单管理</a>
      <ul>
        <li><a href="<c:url value='/AdminOrderController/findAll'/>" target="a_body" >查看订单</a></li>
        <li><a href="<c:url value='/AdminOrderController/update'/>" target="a_body" >修改订单</a></li>
      </ul>
    </li>
  </ul>
</div>
</body>
</html>