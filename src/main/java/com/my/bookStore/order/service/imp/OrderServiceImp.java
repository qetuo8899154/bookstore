package com.my.bookStore.order.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.my.bookStore.exception.OrderException;
import com.my.bookStore.order.dao.OrderDao;
import com.my.bookStore.order.entity.Order;
import com.my.bookStore.order.entity.OrderItem;
import com.my.bookStore.order.service.OrderService;

@Service
public class OrderServiceImp implements OrderService{
	@Autowired
	private OrderDao orderDao;
	
	/**
	 * 添加订单
	 */
	@Transactional
	@Override
	public void addOrder(Order order) {
		orderDao.addOrder(order);
		orderDao.addOrderItemList(order.getOrderItemList());
	}
	/**
	 * 查找订单详情(包含订单条目)
	 */
	@Override
	public List<Order> myOrders(String uid) {
		List<Order> myOrders = orderDao.findByUid(uid);
		for(Order order:myOrders) {
			String oid = order.getOid();
			List<OrderItem> orderItemList =orderDao.findByOid(oid);
			order.setOrderItemList(orderItemList);	
		}
		return myOrders;
	}
	/**
	 * 加载订单
	 */
	@Override
	public Order loadOrder(String oid) {
		List<OrderItem> orderItemList = orderDao.findByOid(oid);
		Order order = orderDao.findOrderByOid(oid);
		order.setOrderItemList(orderItemList);
		return order;
	}
	/**
	 * 确认收货
	 * @throws Exception 
	 */
	@Override
	public void confirm(String oid) throws OrderException {
		int state = orderDao.findOrderByOid(oid).getState();
		if(state==3) {
			orderDao.updateState(oid, 4);;
		}else {
			throw new OrderException("确认收货失败！"); 
		}
	}
	/**
	 * 支付订单
	 * @param oid
	 */
	@Override
	public void pay(String oid) {
		int state = orderDao.findOrderByOid(oid).getState();
		if(state==1) {
			orderDao.updateState(oid, 2);
		}
	}


}
