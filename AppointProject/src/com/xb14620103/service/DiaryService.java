package com.xb14620103.service;

import java.sql.SQLException;
import java.util.List;

import com.xb14620103.dao.DiaryDAO;
import com.xb14620103.domain.Diary;
import com.xb14620103.domain.PageBean;

public class DiaryService {

	/**
	 * 查找所有diary
	 * @return
	 * @throws SQLException 
	 */
	public PageBean findAll(int currPage) throws SQLException {
		// TODO Auto-generated method stub
		//调用diaryDAO
		DiaryDAO dao = new DiaryDAO();
		//当前页内容List
		List<Diary> plist = dao.findDiaryByPage(currPage,5);
		//内容总条数 select count(*)
		int totalCount = dao.getCount();
		return new PageBean(plist, totalCount, 5, currPage);
		
	}

	public List<Diary> findById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return new DiaryDAO().findById(id);
	}

	public void addDiary(Diary dy) throws SQLException {
		// TODO Auto-generated method stub
		new DiaryDAO().addDiary(dy);
	}

	public void editDiary(Diary diary) throws SQLException {
		// TODO Auto-generated method stub
		new DiaryDAO().editDiary(diary);
	}

	public void deleteDiary(int id) throws SQLException {
		// TODO Auto-generated method stub
		new DiaryDAO().deleteDiary(id);
	}

	public List<Diary> findByPage(int addPage) throws SQLException {
		// TODO Auto-generated method stub
		return new DiaryDAO().findByPage(addPage);
	}

}
