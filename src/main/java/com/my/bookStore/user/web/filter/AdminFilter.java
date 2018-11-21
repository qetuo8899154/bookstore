package com.my.bookStore.user.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class AdminFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String[] pass = new String[]{"login","regist"};
		String uri = request.getRequestURI();
		for(String str:pass) { //判断url中是否存在指定字符串，若存在则不过滤
			if(uri.indexOf(str) != -1) {
				filterChain.doFilter(request, response);
				return;
			}
		}
		Object obj = request.getSession().getAttribute("session_admin");
		if(obj!=null) {
			filterChain.doFilter(request, response);
		}else {		
			response.sendRedirect("/bookStore/jsps/admin/login.jsp");
		}
	}

}
