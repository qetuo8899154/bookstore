package com.my.bookStore.book.entity;

import com.my.bookStore.category.entity.Category;

public class Book {
	private String bid;
	private String bookName;
	private double price;
	private String author;
	private String image;
	private Category category;
	private boolean del;
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public boolean isDel() {
		return del;
	}
	public void setDel(boolean del) {
		this.del = del;
	}
	@Override
	public String toString() {
		return "Book [bid=" + bid + ", bookName=" + bookName + ", price=" + price + ", author=" + author + ", image="
				+ image + ", category=" + category + ", del=" + del + "]";
	}
	
	
}
