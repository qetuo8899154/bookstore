package com.my.bookStore.order.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.my.bookStore.cart.entity.Cart;
import com.my.bookStore.cart.entity.CartItem;
import com.my.bookStore.exception.OrderException;
import com.my.bookStore.order.entity.Order;
import com.my.bookStore.order.entity.OrderItem;
import com.my.bookStore.order.service.imp.OrderServiceImp;
import com.my.bookStore.user.entity.User;

import utils.CommonUtils;

@Controller
@RequestMapping("/OrderController")
public class OrderController {
	@Autowired
	private OrderServiceImp orderServiceImp;
	
	/**
	 * 创建订单
	 * @param request
	 * @return
	 */
	@RequestMapping("/addOrder")
	public String add(HttpServletRequest request) {	
		/*
		 *  从session中获取cart，通过cart生成订单，订单生成后清空cart
		 */
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		Order order = new Order();
		order.setOid(CommonUtils.uuid());
		order.setOrdertime(new Date());
		order.setTotalPrice(cart.getTotalPrice());
		order.setState(1);
		User user = (User) request.getSession().getAttribute("session_user");
		order.setUser(user);
		
		/*
		 * 创建订单条目集合
		 */
		List<OrderItem> orderItemList = new ArrayList<OrderItem>();
		for(CartItem cartItem:cart.getCartItems()) {
			OrderItem orderItem = new OrderItem();//创建订单条目
			orderItem.setNum(cartItem.getNum());
			orderItem.setItemPrice(cartItem.getItemPrice());
			orderItem.setOrder(order);
			orderItem.setBook(cartItem.getBook());
			orderItemList.add(orderItem);	//将订单条目添加到list
		}
		
		order.setOrderItemList(orderItemList);//将订单条目集合添加到订单中
		orderServiceImp.addOrder(order); //调用service层方法访问dao层
		cart.clear();//清空购物车
		request.setAttribute("order", order);
		return"order/desc";
	}
	
	/**
	 * 查询我的订单
	 * @return
	 */
	@RequestMapping("/myOrders")
	public String myOrders(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("session_user");
		List<Order> myOrders = orderServiceImp.myOrders(user.getUid());
		request.setAttribute("myOrders", myOrders);
		return "order/list";
	}
	/**
	 * 加载订单
	 * 1.通过页面传入的oid调用service方法得到order
	 * 2.保存到request
	 */
	@RequestMapping("/loadOrder")
	public String loadOrder(HttpServletRequest request,String oid) {
		request.setAttribute("order", orderServiceImp.loadOrder(oid));
		return "order/desc";
	}
	/**
	 * 确认收货
	 * @param request
	 * @param oid
	 * @return
	 */
	@RequestMapping("/confirm")
	public String confirm(HttpServletRequest request,String oid) {
		try {
			orderServiceImp.confirm(oid);
			request.setAttribute("msg", "确认收货成功！");
		} catch (OrderException e) {
			request.setAttribute("msg", e.getMessage());
		}
		return "msg";
	}
	/**
	 * 支付订单
	 * @param request
	 * @param oid
	 * @return
	 */
	@RequestMapping("/pay")
	public String pay(HttpServletRequest request,String oid) {
		orderServiceImp.pay(oid);
		request.setAttribute("msg", "支付成功,等待商家发货");
		return "msg";
	}
}
