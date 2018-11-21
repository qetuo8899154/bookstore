package com.alex.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public abstract class BaseServlet extends HttpServlet {
	public void service(HttpServletRequest request,HttpServletResponse response) 
		throws ServletException,IOException{
		/*
		 * 获取参数，用来识别用户请求的方法,调用相应的方法
		 */
		String methodName = request.getParameter("method");
		if(methodName==null||methodName.trim().isEmpty()) {
			throw new RuntimeException("请传递需要调用的方法名称！");
		}
		/*
		 * 通过反射调用方法
		 * 1.得到method对象
		 */
		Class c = this.getClass();	//得到当前类的class对象
		Method method = null;
		try {
			method = c.getMethod(methodName,HttpServletRequest.class,HttpServletResponse.class );
		} catch (Exception e) {
			throw new RuntimeException("请求的方法"+method+"不存在！");
		}
		/*
		 * 2.调用method表示的方法*
		 */
		try {					//在具有指定参数的方法对象上调用此方法对象表示的底层方法
			String result = (String) method.invoke(this, request,response);		
			// 执行后返回的字符串,它表示转发或重定向的路径
			 
			/*
			 * 查看返回的字符串是否包含: 如果没有，默认转发
			 * 如果有，使用:分割，得到前缀和后缀
			 */
			if(result==null||result.trim().isEmpty()) {
				return;
			}
			if(result.contains(":")) {	//例： f:/login.jsp
				int index = result.indexOf(":");  //index=1
				String s = result.substring(0, index);	// 前缀：f
				String path = result.substring(index+1);	// 后缀：/login.jsp
				if(s.equalsIgnoreCase("r")) {		//redirect 重定向
					response.sendRedirect(request.getContextPath()+path) ;
				}else if(s.equalsIgnoreCase("f")){
					request.getRequestDispatcher(path).forward(request, response);
				}else {
					throw new RuntimeException("暂不支持"+s+"方法！");
				}	
			}else {	//没有: 默认转发
				request.getRequestDispatcher(result).forward(request, response);;
			}
		} catch (Exception e) {
			System.out.println(methodName+"方法内部异常！");
			throw new RuntimeException(e);
		}
		
		
	}
}
