package com.xb14620103.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.xb14620103.domain.Diary;
import com.xb14620103.service.DiaryService;

/**
 * Servlet implementation class LifeDayServlet
 */
@WebServlet("/lifeDay")
public class LifeDayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("utf-8");
		// 对提交的数据进行封装，成为一个Diary对象
		Diary dy = new Diary();
		String dt = new Date().toString();
		try {			
			BeanUtils.populate(dy, request.getParameterMap());
			dy.setLogdate(dt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("msg", "添加失败,请重新尝试！");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			return;
		}
		// 调用service 添加diary
		try {
			new DiaryService().addDiary(dy);
			System.out.println("添加成功,记录一条");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 重定向
		response.sendRedirect(request.getContextPath() + "/findAll");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
