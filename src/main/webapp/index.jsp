<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
 <head>
 	<script src="js/jquery-3.3.1.js"></script>
 	<script type="text/javascript">
 		$(function() {
			$('.ajax').click(function() {
				$.ajax({
					url:'jsps/user/regist.jsp',
					type:'get',
					data:'username='+$('.username').val()+'password='+$('.password').val(),
					success:function(){
						
					}
				})
			})
			$('.username').blur(function(){
				$.ajax({
					url:'/UserController/checkUsername',
					type:'post',
					data:'username='+$('username').val(),
					success:function(data){
						$('sp1').html(data);
					}
				})
			})
		})
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
