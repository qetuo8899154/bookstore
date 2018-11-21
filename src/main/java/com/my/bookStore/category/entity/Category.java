package com.my.bookStore.category.entity;

public class Category {
	private String cid;
	private String categoryName;
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	@Override
	public String toString() {
		return "Category [cid=" + cid + ", categoryName=" + categoryName + "]";
	}
	
}
