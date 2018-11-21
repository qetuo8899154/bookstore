package com.my.bookStore.user.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.bookStore.cart.entity.Cart;
import com.my.bookStore.exception.UserException;
import com.my.bookStore.user.entity.User;
import com.my.bookStore.user.service.Impl.UserServiceImpl;

@Controller
@RequestMapping(value="/UserController")
public class UserController{
	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private Cart cart;
	
	Verify ver = new Verify();
	/**
	 * 检查用户名是否存在
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/checkUsername")
	public void checkUsername(HttpServletRequest request, HttpServletResponse response) throws IOException{
		boolean flag = false;
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("username");
		if(username==null||username.trim().isEmpty()){
			response.getWriter().print("<font color='red'>用户名不能为空！</font>");
		}else if(username.length()<3||username.length()>10){
			response.getWriter().print("<font color='red'>用户名长度必须在3~10之间！</font>");
		}else {
			int state = userService.checkUsername(username);
			if(state==0){
				response.getWriter().print("<font color='green'>用户名可用！</font>");
				flag = true;
			}else{
				response.getWriter().print("<font color='red'>用户名已存在！</font>");
			}
		}
		ver.setUsernameFlag(flag);
	}

	@RequestMapping("/checkPassword")
	public void checkPassword(HttpServletRequest request, HttpServletResponse response) throws IOException {
		boolean flag = false;
		response.setContentType("text/html;charset=utf-8");
		String password = request.getParameter("password");
		if(password==null||password.trim().isEmpty()||password==""){
			response.getWriter().print("<font color='red'>密码不能为空或包含空格!</font>");	
		}else if(password.length()<6||password.length()>15){
			response.getWriter().print("<font color='red'>密码长度必须在6~15之间!</font>");
		}else{
			response.getWriter().print("<font color='green'>密码可用!</font>");
			flag = true;
		}
		ver.setPasswordFlag(flag);
	}
	
	@RequestMapping("/checkEmail")
	@ResponseBody
	public void checkEmail(HttpServletRequest request, HttpServletResponse response) throws IOException {
		boolean flag = false;
		response.setContentType("text/html;charset=utf-8");
		String email = request.getParameter("email");
		if(email==null||email.trim().isEmpty()) {
			response.getWriter().print("<font color='red'>email不能为空！</font>");
		}else if(!email.matches("\\w+@\\w+.\\w+\\.?\\w*")) { //使用正则判断email格式
			response.getWriter().print("<font color='red'>email格式错误！</font>");
		}else {    
			response.getWriter().print("<font color='green'>email格式正确！</font>");
			flag = true;
		}
		ver.setEmailFlag(flag);
	}
	/**
	 * 注册
	 * @throws IOException 
	 */
	@RequestMapping("/regist") 
	public void regist(HttpServletRequest request,HttpServletResponse response) throws IOException{
		//封装表单数据
		User form = new User();
		try {	//使用beanutils的populate()方法将数据封装到form(User)对象中
			BeanUtils.populate(form, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		StringBuilder json = new StringBuilder();
		if(ver.isUsernameFlag()&ver.isPasswordFlag()&ver.isEmailFlag()) {
			/*
			 * 调用service的regist()方法
			 */
			try {
				userService.regist(form);
				json.append("{\"success\":true}");
			} catch (UserException e) {
				e.printStackTrace();
			}			
		}else {
			json.append("{\"success\":false}");
		}
		response.getWriter().print(json);
	}
	/**
	 * 登录
	 * @param request
	 * @return
	 */
	@RequestMapping("/login")
	public String login(HttpServletRequest request){
		/*
		 * 1.封装数据到form中
		 * 2.输入校验
		 * 3.调用service的login()方法
		 * 4.保存用户信息到session中,然后重定向到index.jsp
		 */
		User form = new User(); 
		try {
			BeanUtils.populate(form, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		//调用service的login()方法
		try {
			User user = userService.login(form);
			request.getSession().setAttribute("session_user", user);
			//给用户添加购物车
			request.getSession().setAttribute("cart", cart);
			return "redirect:/jsps/main.jsp";
		} catch (UserException e) {
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("form", form);
			return "user/login";
		}
	}
	/**
	 * 退出方法
	 */
	@RequestMapping("/quit")
	public String quit(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/jsps/main.jsp";
	}
}