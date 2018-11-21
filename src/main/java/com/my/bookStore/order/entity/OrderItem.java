package com.my.bookStore.order.entity;

import com.my.bookStore.book.entity.Book;

/**
 * 订单条目类
 * @author Administrator
 *
 */
public class OrderItem {
	private String iid;
	private int num;
	private double itemPrice;
	private Order order;
	private Book book;
	
	public String getIid() {
		return iid;
	}
	public String getOid() {
		return order.getOid();
	}
	public String getBid() {
		return book.getBid();
	}
	public void setIid(String iid) {
		this.iid = iid;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
}
