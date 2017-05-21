package com.xb14620103.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourceUtils {
	private static ComboPooledDataSource ds = new ComboPooledDataSource();
	private static ThreadLocal<Connection> tl = new ThreadLocal<>();

	/**
	 * 获取数据源
	 * 
	 * @return 连接池
	 */
	public static DataSource getDataSource() {

		return ds;
	}

	/**
	 * 从当前线程上获取连接
	 * 
	 * @return 连接
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		Connection conn = tl.get();
		if (conn == null) {
			// 第一次获取创建一个连接，和当前的线程绑定
			conn = ds.getConnection();
			// 绑定
			tl.set(conn);
		}
		return conn;
	}

	/**
	 * 释放资源
	 * 
	 * @param conn
	 *            连接
	 * @param stmt
	 *            语句执行者
	 * @param rs
	 *            结果集
	 */
	public static void closeResourse(Connection conn, Statement stmt, ResultSet rs) {
		closeResourse(stmt, rs);
		closeConnection(conn);
	}

	public static void closeResourse(Statement stmt, ResultSet rs) {
		closeResultset(rs);
		closeStatement(stmt);
	}

	/**
	 * 释放连接
	 * 
	 * @param conn
	 *            连接
	 */
	public static void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("conn关闭异常");
			}
		}

		conn = null;
	}

	/**
	 * 释放语句执行者
	 * 
	 * @param stmt
	 *            连接
	 */
	public static void closeStatement(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("stmt关闭异常");
			}
		}

		stmt = null;
	}

	/**
	 * 释放结果集
	 * 
	 * @param rs
	 *            连接
	 */
	public static void closeResultset(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("rs关闭异常");
			}
		}

		rs = null;
	}

	// 开启事务
	public static void startTransaction() throws SQLException {
		// 获取连接
		getConnection().setAutoCommit(false);
	}

	// 事务提交
	public static void commitAndClose() {

		try {
			// 获取连接
			Connection conn = getConnection();
			// 提交事务
			conn.commit();
			// 释放资源
			conn.close();
			// 解除绑定
			tl.remove();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 事务回滚
	public static void rollbackAndClose() {

		try {
			// 获取连接
			Connection conn = getConnection();
			// 事务回滚
			conn.rollback();
			// 释放资源
			conn.close();
			// 解除绑定
			tl.remove();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
