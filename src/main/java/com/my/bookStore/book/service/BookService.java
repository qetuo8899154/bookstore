package com.my.bookStore.book.service;

import java.util.List;

import com.my.bookStore.book.entity.Book;

public interface BookService {
	
	public List<Book> findAll();
	
	public List<Book> findByCategory(String cid);
	
	public Book bookDesc(String bid);
	
	void add(Book book);
	
	void delete(String bid);

	void edit(Book book);
}
