package com.xb14620103.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xb14620103.service.DiaryService;

/**
 * Servlet implementation class DeleteDiaryServlet
 */
@WebServlet("/deleteDiary")
public class DeleteDiaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡɾ������Ʒ
		int id = Integer.parseInt(request.getParameter("id").toString());
		//����ID����service
		try {
			new DiaryService().deleteDiary(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("msg", "ɾ��ʧ��,�����ԣ�");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			return;
		}
		//�ض���findAll
		response.sendRedirect(request.getContextPath()+"/findAll");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
