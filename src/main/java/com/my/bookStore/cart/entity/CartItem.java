package com.my.bookStore.cart.entity;

import java.math.BigDecimal;

import com.my.bookStore.book.entity.Book;

/**
 * 购物车中条目
 * @author Administrator
 *
 */
public class CartItem {
	private Book book;	//具体商品
	private int	 num;	//商品数量
	
	/**
	 * 小计   使用BigDecimal避免二进制计算误差问题
	 * @return
	 */
	public double getItemPrice() {	
		BigDecimal b1 = new BigDecimal(book.getPrice()); //使用bigDecimal防止误差
		BigDecimal b2 = new BigDecimal(num);
		return b1.multiply(b2).doubleValue();
		//使用BigDecimal的multiply()方法进行乘运算，doubleValue()方法转化成double
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
}
