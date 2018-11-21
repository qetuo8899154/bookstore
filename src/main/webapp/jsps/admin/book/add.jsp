<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加图书</title>
<style type="text/css">
	body{
		background-color:#fdedb5;
		}
</style>
</head>
<body>
	<h1>添加图书</h1>
	<h2>${msg}</h2>
	<form action="<c:url value='/AdminBookController/add'/>" method="post" enctype="multipart/form-data" id="form">
		图片：<input type="file" name="file" id="fileSize" onchange="checkSize();" /><br/>
		书名：<input type="text" name="bookName" /><br/>
		作者：<input type="text" name="author" /><br/>
		单价：<input type="text" name="price" />元<br/>
		分类：<select name="cid">
				<c:forEach items="${categoryList }" var="category">
					<option value="${category.cid }" >${category.categoryName }</option>
				</c:forEach>
			</select><br/>
		<input type="submit" value="添加图书"/>
	</form>
</body>
<script type="text/javascript">
	function checkSize(){
		var imagWidth =  document.getElementById("fileSize").files[0].width;
		var imagHeight =  document.getElementById("fileSize").files[0].height;
		if(imageWidth>200||imageHeight>200){
		alert("图片尺寸必须小于200*200！")
		}
	}

</script>
</html>