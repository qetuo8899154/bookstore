<%@ page language="java" import="java.util.*" contentType="text/html; " 
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>用户注册页面</title>
	<script type="text/javascript">
		function checkPwd2(pwd2){
			var pwd1 = document.getElementById("password").value;
			var pwd2font = document.getElementById("pwd2font");
			if(pwd1!=pwd2){
				pwd2font.innerHTML = "<font color='red'>两次输入的密码不一致！</font>";
			}else{
				pwd2font.innerHTML = "<font color='green'>密码一致！</font>";
			}
		}
		function checkUsername(username){	//验证用户名是否可用
			var xhr = null;
			if(window.XMLHttpRequest){
				xhr = new XMLHttpRequest();
			}else{
				xhr = new ActiveXObject("Microsoft.XMLHttp");	
			}
			xhr.onreadystatechange = function(){
				if(xhr.readyState==4 && xhr.status==200){
					document.getElementById("sp1").innerHTML = xhr.responseText;
				}	
			}
			xhr.open("post","/bookStore/UserController/checkUsername",true);
			xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");
			xhr.send("username="+username);
		}
	
		function checkPassword(password){
			var xhr = null;
			if(window.XMLHttpRequest){
				xhr = new XMLHttpRequest();
			}else{
				xhr = new ActiveXObject("Microsoft.XMLHttp");	
			}
			xhr.onreadystatechange = function(){
				if(xhr.readyState==4 && xhr.status==200){
					document.getElementById("sp2").innerHTML = xhr.responseText;
				}
			}
			xhr.open("post","/bookStore/UserController/checkPassword",true);
			xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");
			xhr.send("password="+password);
		}
		function checkEmail(email){
			var xhr = null;
			if(window.XMLHttpRequest){
				xhr = new XMLHttpRequest();
			}else{
				xhr = new ActiveXObject("Microsoft.XMLHttp");
			}
			xhr.onreadystatechange = function(){
				if(xhr.readyState==4 && xhr.status==200){
					document.getElementById("sp3").innerHTML = xhr.responseText;
				}
			}
			xhr.open("POST","/bookStore/UserController/checkEmail",true);
			xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8");
			xhr.send("email="+email);
		}	
			
		function userRegist(){
			var username = document.getElementById("username").value;
			var password = document.getElementById("password").value;
			var email = document.getElementById("email").value;
			var xhr = null; 
			if(window.XMLHttpRequest){
				xhr = new XMLHttpRequest(); 
			}else{
				xhr = new ActiveXObject("Microsoft.XMLHttp");
			}
			xhr.onreadystatechange = function(){
				if(xhr.readyState==4 && xhr.status==200){
					var jsonString = xhr.responseText;
					eval("var jsonObj = " + jsonString);
					if(jsonObj.success){
						window.location = "/bookStore/jsps/user/login.jsp";
					}else{
						alert("注册失败!");
					}
				}
			}
			xhr.open("POST","/bookStore/UserController/regist",true);
			xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8");
			xhr.send("username="+username+"&password="+password+"&email="+email);
		}
	</script>
 </head>
  <body>
	<h1>注册页面</h1>
	<table>
		<tr>
			<td>用户名：</td>
		</tr>
		<tr>
			<td><input type="text" id="username" placeholder="请输入用户名" style="width:140px" onblur="checkUsername(this.value);" />
			<span id="sp1" style="text-align: left"></span></td>
		</tr>
		<tr>
			<td>密码：</td>
		
		</tr>
		<tr>
			<td><input type="password" name="password" id="password" placeholder="请输入密码" style="width:140px" onblur="checkPassword(this.value);" />
			<span id="sp2" style="text-align: left"></span></td>
		</tr>
		<tr>
			<td>重复密码：</td>
	
		</tr>
		<tr>
			<td><input type="password" name="password2" id="password2" placeholder="请再次输入密码" style="width:140px" onblur="checkPwd2(this.value);"/><span id="pwd2font"></span></td>
		</tr>
		<tr>
			<td>邮箱：</td>
			
		</tr>
		<tr> 
			<td><input type="text" id="email" placeholder="请输入邮箱地址" style="width:140px" onblur="checkEmail(this.value);" />
	<span id="sp3" style="text-align: left"></span></td>
		</tr>
		<tr>
			<td><input type="button" value="注册" onclick="userRegist();" style="background:#009999;color:white;border:none" />
			<a href="login.jsp"> <input type="button" value="返回登录页" style="background:#dddddd;color:black;border:none"/></a></td>
		</tr>
	</table>

 </body>
</html>