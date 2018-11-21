package com.my.bookStore.user.dao;

import com.my.bookStore.user.entity.Admin;
import com.my.bookStore.user.entity.User;

/**
 * dao接口
 * @author Administrator
 *
 */
public interface UserDao {
	/**
	 * 根据用户名查找
	 * @param username
	 * @return
	 */
	User findByUsername(String username);
	/**
	 * 根据email查找
	 * @param username
	 * @return
	 */
	User findByEmail(String email);
	
	/**
	 * 添加用户
	 * @param user
	 */
	void add(User user);
	/**
	 * 管理员登录
	 * @param username
	 * @return
	 */
	Admin adminLogin(String adminname);
}	
