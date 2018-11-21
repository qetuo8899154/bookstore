package com.my.bookStore.user.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.bookStore.exception.UserException;
import com.my.bookStore.user.dao.UserDao;
import com.my.bookStore.user.entity.Admin;
import com.my.bookStore.user.entity.User;
import com.my.bookStore.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override		//传入页面表单信息 进行注册
	public void regist(User form) throws UserException {
		User username = userDao.findByUsername(form.getUsername());
		//校验用户名
		if(username!=null) throw new UserException("用户名已存在!");
		
		//插入用户到数据库
		userDao.add(form);
	}

	
	/**
	 * 登录功能
	 */
	@Override
	public User login(User form) throws UserException {
		/*
		 *1.使用username查询，得到User
		 *2.如果user为null，抛出异常(用户名不存在)
		 *3.比较form和user的密码，若不同，抛出异常(密码错误)
		 *4.返回user
		 */
		User user = userDao.findByUsername(form.getUsername());
		if(user==null) {
			throw new UserException("用户名不存在!");
		}
		if(!user.getPassword().equals(form.getPassword())) {
			throw new UserException("密码错误！");
		}
		return user; 
	}

	/**
	 * 管理员登录
	 * @param form
	 * @return
	 */
	@Override
	public Admin adminLogin(Admin form) throws UserException {
		Admin admin = userDao.adminLogin(form.getUsername());
		if(admin==null) {
			throw new UserException("用户名不存在!");
		}
		if(!admin.getPassword().equals(form.getPassword())) {
			throw new UserException("密码错误！");
		}
		return admin;
	}
	/**
	 * 检查用户名
	 */
	@Override
	public int checkUsername(String username) {
		User user = userDao.findByUsername(username);
		if(user==null) {
			return 0;	//0表示用户名不存在
		}else {
			return 1;
		}
	}
	
}
