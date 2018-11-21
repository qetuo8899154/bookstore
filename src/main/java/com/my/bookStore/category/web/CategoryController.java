package com.my.bookStore.category.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.my.bookStore.category.service.imp.CategoryServiceImp;

@Controller
@RequestMapping("/CategoryController")
public class CategoryController {
	@Autowired
	private CategoryServiceImp categoryServiceImp;
	
	@RequestMapping("/findAll")
	public String findAll(HttpServletRequest request) {
		request.setAttribute("categoryList", categoryServiceImp.findAll());
		return "left";
	}
}
