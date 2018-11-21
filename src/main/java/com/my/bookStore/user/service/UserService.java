package com.my.bookStore.user.service;

import com.my.bookStore.exception.UserException;
import com.my.bookStore.user.entity.Admin;
import com.my.bookStore.user.entity.User;

/**
 * 
 * @author Administrator
 *
 */
public interface UserService {
	
	/**
	 * 注册功能
	 * @throws UserException 
	 */
	void regist(User form) throws UserException;
	/**
	 * 登录功能
	 * @param form
	 * @throws UserException 
	 */
	User login(User form) throws UserException; 
	/**
	 * 管理员登录
	 * @param form
	 * @return
	 * @throws UserException
	 */
	Admin adminLogin(Admin form) throws UserException;
	/**
	 * 查找用户名是否存在
	 * @param username
	 * @return
	 */
	int checkUsername(String username);
}
