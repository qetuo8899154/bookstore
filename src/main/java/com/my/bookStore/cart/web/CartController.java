package com.my.bookStore.cart.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.my.bookStore.book.entity.Book;
import com.my.bookStore.book.service.imp.BookServiceImp;
import com.my.bookStore.cart.entity.Cart;
import com.my.bookStore.cart.entity.CartItem;

@Controller
@RequestMapping("/CartController")
public class CartController {
	@Autowired
	private Cart cart;
	@Autowired
	private BookServiceImp bookServiceImp;
	
	/**
	 * 添加购物条目
	 * 通过bid 得到book，通过num得到添加的数量，将book和num添加到条目中，再将条目添加到购物车
	 * @return
	 */
	@RequestMapping("/add")		
	public String add(HttpServletRequest request,@RequestParam("bid")  String bid,
			@RequestParam("num") String num) {
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		Book book = bookServiceImp.bookDesc(bid);
		CartItem cartItem = new CartItem();
		cartItem.setBook(book);	//把相关数据添加到条目中
		cartItem.setNum(Integer.parseInt(num)); 
		cart.add(cartItem); //把条目添加到购物车中
		return "cart/cartList";
	}
	
	/**
	 * 清空购物车
	 */
	@RequestMapping("/clear")
	public String clear(){
		cart.clear();
		return "cart/cartList";
	}
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request,@RequestParam("bid") String bid) {
		Cart cart  = (Cart) request.getSession().getAttribute("cart");
		cart.delete(bid);
		return "cart/cartList";
	}
	
}
