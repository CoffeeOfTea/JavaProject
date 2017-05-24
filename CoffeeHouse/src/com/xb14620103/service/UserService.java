package com.xb14620103.service;

import java.sql.SQLException;

import com.xb14620103.dao.UserDAO;
import com.xb14620103.domain.User;

public class UserService {

	/**
	 * 注册
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public String register(User user) throws SQLException {
		// TODO Auto-generated method stub
		//检查用户名是否被占用
		User user2 = new UserDAO().findByUsername(user.getUsername());
		if(user2 == null){
			new UserDAO().add(user);
			return "success";
		}
		return "failed";
	}

	/**
	 * 登陆
	 * @param user
	 * @return
	 * @throws SQLException 
	 */
	public String login(User user) throws SQLException {
		// TODO Auto-generated method stub
		User user2 = new UserDAO().findByUsername(user.getUsername());
		if(user2.getPassword().equals(user.getPassword()))
			return "success";
		System.out.println("failed");
		System.out.println(user2.getPassword());
		System.out.println(user.getPassword());
		return "failed";
	}
	
}
