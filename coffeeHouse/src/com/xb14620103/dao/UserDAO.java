package com.xb14620103.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.xb14620103.domain.User;
import com.xb14620103.utils.DataSourceUtils;

public class UserDAO {

	public void add(User user) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into user(username,password,type) values(?,?,?)";
		qr.update(sql, user.getUsername(),user.getPassword(),user.getType());
	}

	public User findByUsername(String username) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where username=?;";
		return qr.query(sql, new BeanHandler<User>(User.class),username);
	}

}
