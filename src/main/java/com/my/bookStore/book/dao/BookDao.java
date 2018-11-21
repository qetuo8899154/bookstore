package com.my.bookStore.book.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.my.bookStore.book.entity.Book;

public interface BookDao {
	 List<Book> findAll();
	
	 List<Book> findByCategory(String cid);
	 /**
	  * 根据bid查询book详情
	  * @param bid
	  * @return
	  */
	 Book bookDesc(String bid);
	
	 int getCountByCid(String cid);
	 /**
	  * 添加图书
	  * @param book
	  */
	void add(@Param("book")Book book);
	/**
	 * 删除图书
	 * @param bid
	 */
	void delete(@Param("bid")String bid);
	/**
	 * 编辑图书
	 * @param book
	 */
	void edit(@Param("book")Book book);
}
