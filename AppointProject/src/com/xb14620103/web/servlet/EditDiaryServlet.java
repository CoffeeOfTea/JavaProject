package com.xb14620103.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.xb14620103.domain.Diary;
import com.xb14620103.service.DiaryService;

/**
 * Servlet implementation class EditDiaryServlet
 */
@WebServlet("/editDiary")
public class EditDiaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码
		request.setCharacterEncoding("utf-8");
		//封装数据到diary
		Diary diary = new Diary();
		try {
			BeanUtils.populate(diary, request.getParameterMap());			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("msg", "绑定diary失败，请重试！");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			return;
		}
		//调用service修改内容
		try {
			new DiaryService().editDiary(diary);
			System.out.println("修改id为"+request.getParameter("id")+"的记录");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("msg", "绑定diary失败，请重试！");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			return;
		}
		//重定向findAll
		response.sendRedirect(request.getContextPath()+"/findAll");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
