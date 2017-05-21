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
		// ���ñ���
		request.setCharacterEncoding("utf-8");
		// ���ύ�����ݽ��з�װ����Ϊһ��Diary����
		Diary dy = new Diary();
		String dt = new Date().toString();
		try {			
			BeanUtils.populate(dy, request.getParameterMap());
			dy.setLogdate(dt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("msg", "���ʧ��,�����³��ԣ�");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			return;
		}
		// ����service ���diary
		try {
			new DiaryService().addDiary(dy);
			System.out.println("��ӳɹ�,��¼һ��");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// �ض���
		response.sendRedirect(request.getContextPath() + "/findAll");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
