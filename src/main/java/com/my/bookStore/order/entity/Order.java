package com.my.bookStore.order.entity;

import java.util.Date;
import java.util.List;

import com.my.bookStore.user.entity.User;

public class Order {
	private String oid;
	private Date ordertime;
	private double totalPrice;
	private int state;	//订单状态四种：1.未付款	2.未发货	3.已发货	4.已收货
	private User user;
	private String address;		
	
	private List<OrderItem> orderItemList;	//当前订单下所有条目
	
	public List<OrderItem> getOrderItemList() {
		return orderItemList;
	}
	public String getUid() {
		return user.getUid();
	}
	public void setOrderItemList(List<OrderItem> orderItemList) {
		this.orderItemList = orderItemList;
	}
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public Date getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
