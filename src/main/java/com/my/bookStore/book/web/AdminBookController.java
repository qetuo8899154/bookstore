package com.my.bookStore.book.web;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.my.bookStore.book.entity.Book;
import com.my.bookStore.book.service.imp.BookServiceImp;
import com.my.bookStore.category.entity.Category;
import com.my.bookStore.category.service.imp.CategoryServiceImp;

import utils.CommonUtils;

@Controller
@RequestMapping("/AdminBookController")
public class AdminBookController {
	@Autowired
	private BookServiceImp bookServiceImp;
	@Autowired
	private CategoryServiceImp categoryServiceImp;
	/**
	 * 查找所有图书
	 * @param request
	 * @return
	 */
	@RequestMapping("/findAll")
	public String findAll(HttpServletRequest request) {
		List<Book> bookList = bookServiceImp.findAll();
		request.setAttribute("bookList", bookList);
		return "admin/book/list";
	}
	/**
	 * 查看图书详情
	 * @param bid
	 * @param request
	 * @return
	 */
	@RequestMapping("/detail")
	public String detail(String bid,HttpServletRequest request) {
		Book book = bookServiceImp.bookDesc(bid);
		List<Category> categoryList = categoryServiceImp.findAll();
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("book", book);
		return "admin/book/desc";
	}
	/**
	 * 加载分类信息
	 * @param request
	 * @return
	 */
	@RequestMapping("/loadCategorList")
	public String loadCategorList(HttpServletRequest request) {
		List<Category> categoryList = categoryServiceImp.findAll();
		request.setAttribute("categoryList", categoryList);
		return "admin/book/add";
	}
	/**
	 * 添加图书(需先加载分类信息)
	 * @param request
	 * @return
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	@RequestMapping("/add")
	public String add(HttpServletRequest request,MultipartFile file,String cid) throws IllegalAccessException, InvocationTargetException {
		//保存的路径
		String path = request.getServletContext().getRealPath("/img");
		//得到文件名称
		String fileName = file.getOriginalFilename();
		String newFileName = CommonUtils.uuid()+fileName;
		//上传到文件的全路径
		File newFile = new File(path, newFileName);
		//将本地文件上传到全路径
		try {
			file.transferTo(newFile);
			Book book = new Book();
			BeanUtils.populate(book, request.getParameterMap());
			book.setImage("/img/"+newFileName);
			Category category = new Category();
			category.setCid(cid);
			book.setCategory(category);
			bookServiceImp.add(book);
			request.setAttribute("msg", "添加图书成功");
			return "forward:/AdminBookController/findAll";
		} catch (Exception e) {			
			request.setAttribute("msg", "添加图书失败！");
			return "admin/book/add";
		} 	
	}
	/**
	 * 删除图书
	 * @param bid
	 * @param request
	 * @return
	 */
	@RequestMapping("/delete")
	public String delete(String bid,HttpServletRequest request) {
		bookServiceImp.delete(bid);
		request.setAttribute("msg", "删除图书成功！");
		return "forward:/AdminBookController/findAll";
	}
	/**
	 * 编辑图书
	 * @return
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request) throws IllegalAccessException, InvocationTargetException {
		Book book = new Book();
		Category category = new Category();
		BeanUtils.populate(book,request.getParameterMap());
		BeanUtils.populate(category, request.getParameterMap());
		book.setCategory(category);
		bookServiceImp.edit(book);
		return "forward:/AdminBookController/findAll";
	}
}
