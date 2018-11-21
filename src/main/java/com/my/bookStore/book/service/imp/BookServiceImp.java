package com.my.bookStore.book.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.bookStore.book.dao.BookDao;
import com.my.bookStore.book.entity.Book;
import com.my.bookStore.book.service.BookService;

@Service
public class BookServiceImp implements BookService{
	@Autowired
	private BookDao bookDao;
	
	/*
	 * 查询所有图书
	 * @see com.my.bookStore.book.service.BookService#findAll()
	 */
	@Override
	public List<Book> findAll() {
		return bookDao.findAll();
	}

	@Override
	public List<Book> findByCategory(String cid) {
		return bookDao.findByCategory(cid);
	}

	@Override
	public Book bookDesc(String bid) {
		return bookDao.bookDesc(bid);
	}
	@Override
	public void add(Book book) {
		bookDao.add(book);
	}
	@Override
	public void delete(String bid) {
		bookDao.delete(bid);
	}
	@Override
	public void edit(Book book) {
		bookDao.edit(book);
	}
	
}
