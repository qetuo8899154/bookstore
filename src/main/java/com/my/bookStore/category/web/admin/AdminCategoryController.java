package com.my.bookStore.category.web.admin;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.my.bookStore.category.entity.Category;
import com.my.bookStore.category.service.imp.CategoryServiceImp;
import com.my.bookStore.exception.CategoryException;

@Controller
@RequestMapping("/AdminCategoryController")
public class AdminCategoryController {
	@Autowired
	private CategoryServiceImp categoryServiceImp;
	/**
	 * 查询所有分类
	 */
	@RequestMapping("/findAll")
	public String findAll(HttpServletRequest request){
		List<Category> categoryList = categoryServiceImp.findAll();
		request.setAttribute("categoryList",categoryList);
		return "admin/category/list";
	}
	/**
	 * 添加分类
	 * 
	 */
	@RequestMapping("/addCategory")
	public String addCategory(HttpServletRequest request) {
		Category category = new Category();
		try {
			BeanUtils.populate(category, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		categoryServiceImp.addCategory(category.getCategoryName());
		return "forward:/AdminCategoryController/findAll";
	}
	/**
	 * 删除分类
	 * @param categoryName
	 * @return
	 */
	@RequestMapping("/deleteCategory")
	public String deleteCategory(HttpServletRequest request,String cid) {
		try {
			categoryServiceImp.deleteCategory(cid);
			return "forward:/AdminCategoryController/findAll";
		} catch (CategoryException e) {
			request.setAttribute("msg", e.getMessage());
			return "admin/body";
		}
	
	}
	/**
	 * 修改分类
	 */
	@RequestMapping("/updateCategory")
	public String updateCategory(String nCategoryName,String cid,HttpServletRequest request) {
		try {
			categoryServiceImp.updateCategory(nCategoryName, cid);
			return "forward:/AdminCategoryController/findAll";
		} catch (CategoryException e) {
			request.setAttribute("msg", e.getMessage());
			return "admin/body";
		}
	}
	/**
	 * 加载分类
	 */
	@RequestMapping("/loadCategory")
	public String loadCategory(HttpServletRequest request,String cid) {
		Category category = categoryServiceImp.load(cid);
		request.setAttribute("category", category);
		return "admin/category/update";
	}
}
