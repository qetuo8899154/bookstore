package com.my.bookStore.book.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.my.bookStore.book.entity.Book;
import com.my.bookStore.book.service.imp.BookServiceImp;

@Controller
@RequestMapping("/BookController")
public class BookController {
	@Autowired
	private BookServiceImp bookServiceImp;
	
	/**
	 * 查询所有图书
	 * @param request
	 * @return
	 */
	@RequestMapping("/findAll")
	public String findAll(HttpServletRequest request) {
		List<Book> bookList = bookServiceImp.findAll();
		request.setAttribute("bookList", bookList);
		return "book/list";
	}
	
	/**
	 * 按分类查询
	 * @param request
	 * @param cid
	 * @return
	 */
	@RequestMapping("/findByCategory")
	public String findByCategory(HttpServletRequest request,@RequestParam("cid") String cid) {
		List<Book> bookList	= bookServiceImp.findByCategory(cid);
		request.setAttribute("bookList", bookList);
		return "book/list";
	}
	
	@RequestMapping("/detail")
	public String detail(String bid,HttpServletRequest request) {
		Book book = bookServiceImp.bookDesc(bid);
		request.setAttribute("book", book);
		return "book/desc";
	}
}
