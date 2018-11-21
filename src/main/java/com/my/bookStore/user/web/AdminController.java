package com.my.bookStore.user.web;


import java.lang.reflect.InvocationTargetException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.my.bookStore.exception.UserException;
import com.my.bookStore.user.entity.Admin;
import com.my.bookStore.user.service.Impl.UserServiceImpl;



@Controller
@RequestMapping(value="/AdminController")
public class AdminController{
	@Autowired
	private UserServiceImpl userService;
	/**
	 * 管理员登录
	 * @param request
	 * @return
	 */
	@RequestMapping("/login")
	public String login(HttpServletRequest request){
		Admin form = new Admin();
		try {
			BeanUtils.populate(form, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	
		try {
			Admin admin = userService.adminLogin(form);
			request.getSession().setAttribute("session_admin", admin);
			System.out.println(request.getSession().getAttribute("session_admin"));
			return "redirect:/jsps/admin/main.jsp";
		} catch (UserException e) {
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("form", form);
			return "admin/login";
		}
	}
	/**
	 * 退出方法
	 */
	@RequestMapping("/quit")
	public String quit(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/jsps/admin/login";
	}
}