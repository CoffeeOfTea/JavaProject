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
	 * ��ȡ����Դ
	 * 
	 * @return ���ӳ�
	 */
	public static DataSource getDataSource() {

		return ds;
	}

	/**
	 * �ӵ�ǰ�߳��ϻ�ȡ����
	 * 
	 * @return ����
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		Connection conn = tl.get();
		if (conn == null) {
			// ��һ�λ�ȡ����һ�����ӣ��͵�ǰ���̰߳�
			conn = ds.getConnection();
			// ��
			tl.set(conn);
		}
		return conn;
	}

	/**
	 * �ͷ���Դ
	 * 
	 * @param conn
	 *            ����
	 * @param stmt
	 *            ���ִ����
	 * @param rs
	 *            �����
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
	 * �ͷ�����
	 * 
	 * @param conn
	 *            ����
	 */
	public static void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("conn�ر��쳣");
			}
		}

		conn = null;
	}

	/**
	 * �ͷ����ִ����
	 * 
	 * @param stmt
	 *            ����
	 */
	public static void closeStatement(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("stmt�ر��쳣");
			}
		}

		stmt = null;
	}

	/**
	 * �ͷŽ����
	 * 
	 * @param rs
	 *            ����
	 */
	public static void closeResultset(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("rs�ر��쳣");
			}
		}

		rs = null;
	}

	// ��������
	public static void startTransaction() throws SQLException {
		// ��ȡ����
		getConnection().setAutoCommit(false);
	}

	// �����ύ
	public static void commitAndClose() {

		try {
			// ��ȡ����
			Connection conn = getConnection();
			// �ύ����
			conn.commit();
			// �ͷ���Դ
			conn.close();
			// �����
			tl.remove();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// ����ع�
	public static void rollbackAndClose() {

		try {
			// ��ȡ����
			Connection conn = getConnection();
			// ����ع�
			conn.rollback();
			// �ͷ���Դ
			conn.close();
			// �����
			tl.remove();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
