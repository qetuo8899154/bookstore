package com.my.bookStore.order.service;

import java.util.List;

import com.my.bookStore.exception.OrderException;
import com.my.bookStore.order.entity.Order;

public interface OrderService {
	/**
	 * 添加订单
	 */
	void addOrder(Order order);
	/**
	 * 查找订单详情(包含订单条目)
	 */
	List<Order> myOrders(String uid);
	/**
	 * 加载订单
	 */
	Order loadOrder(String oid);
	/**
	 * 确认收货
	 * @param oid
	 */
	void confirm(String oid) throws OrderException ;
	/**
	 * 支付订单
	 * @param oid
	 */
	void pay(String oid);
}
