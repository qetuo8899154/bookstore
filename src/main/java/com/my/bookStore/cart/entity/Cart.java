package com.my.bookStore.cart.entity;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

/**
 * 购物车
 * @author Administrator
 *
 */
@Service
public class Cart {
	private Map<String,CartItem> map = new LinkedHashMap<String,CartItem>();
	
	/**
	 * 总金额
	 * @return
	 */
	public double getTotalPrice() {
		BigDecimal total = new BigDecimal(0);
		for(CartItem c:map.values()) {	//总金额  = 所有条目小计 之和
			BigDecimal itemPrice = new BigDecimal(c.getItemPrice());
			total = total.add(itemPrice);	
		}
		return total.doubleValue();
	}
	
	/**
	 * 添加条目到购物车中
	 */
	public void add(CartItem cartItem) {
		if(map.containsKey(cartItem.getBook().getBid())) {//判断购物车中是否存在该条目
			CartItem cartItemOld = map.get(cartItem.getBook().getBid());
			cartItemOld.setNum(cartItemOld.getNum()+cartItem.getNum());
			//设置条目数量为旧数量+新增添的数量
			map.put(cartItem.getBook().getBid(), cartItemOld);
		}else {
			map.put(cartItem.getBook().getBid(), cartItem);
		}
	}
	/**
	 * 清空购物车
	 */
	public void clear() {
		map.clear();
	}
	/**
	 * 删除购物车条目
	 * @param bid
	 */
	public void delete(String bid) {
		map.remove(bid);
	}
	/**
	 * 获取所有条目
	 * @return
	 */
	public Collection<CartItem> getCartItems(){
		return map.values();
	}
}
