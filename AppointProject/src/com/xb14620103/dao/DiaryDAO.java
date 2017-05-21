package com.xb14620103.dao;


import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.xb14620103.domain.Diary;
import com.xb14620103.utils.DataSourceUtils;

public class DiaryDAO {

	/**
	 * 查找所有diary
	 * @return
	 * @throws SQLException 
	 */
	public List<Diary> findAll() throws SQLException {
		// TODO Auto-generated method stub
		//创建query对象
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from logrecord where delflag=0 order by id desc limit 5";
		List<Diary>  list = qr.query(sql, new BeanListHandler<Diary>(Diary.class));
		return list;
	}

	public List<Diary> findById(int id) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from logrecord where id = ? ";
		return qr.query(sql, new BeanListHandler<Diary>(Diary.class), id);
	}

	public void addDiary(Diary dy) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into logrecord(mood,title,details,logdate) values(?,?,?,?)";
		qr.update(sql,dy.getMood(),dy.getTitle(),dy.getDetails(),dy.getLogdate());
		
	}

	public void editDiary(Diary diary) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update logrecord set mood=?,title=?,details=? where id=?";
		qr.update(sql,diary.getMood(),diary.getTitle(),diary.getDetails(),diary.getId());
	}

	public void deleteDiary(int id) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update logrecord set delflag = 1 where id = ? ";
		qr.update(sql,id);
	}

	public List<Diary> findByPage(int addPage) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from logrecord where delflag=0 order by id desc limit ?";
		List<Diary>  list = qr.query(sql, new BeanListHandler<Diary>(Diary.class),addPage);
		return list;
	}

	public List<Diary> findDiaryByPage(int currPage, int i) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from logrecord where delflag=0 order by id desc limit ?,?";
		return qr.query(sql, new BeanListHandler<Diary>(Diary.class), (currPage-1)*5,5);
	}

	public int getCount() throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from logrecord";
		return ((Number) qr.query(sql, new ScalarHandler())).intValue();
	}	

}
