package com.my.bookStore.order.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.my.bookStore.order.entity.Order;
import com.my.bookStore.order.entity.OrderItem;

public interface OrderDao {
	/**
	 * 添加订单
	 */
	public void addOrder(Order order);
	/**
	 * 添加订单条目
	 */
	public void addOrderItemList(@Param("list") List<OrderItem> orderItemList);
	/**
	 * 通过uid查找订单
	 * @param uid 用户id
	 * @return
	 */
	public List<Order> findByUid(String uid);
	/**
	 * 通过oid查找订单条目详情
	 * @param oid 订单编号
	 * @return
	 */
	public List<OrderItem> findByOid(String oid);
	/**
	 * 通过oid查找单个订单
	 * @param oid
	 */
	public Order findOrderByOid(String oid);
	/**
	 * 修改订单状态
	 * @param oid
	 */
	public void updateState(@Param("oid")String oid,@Param("state")int state);

}
