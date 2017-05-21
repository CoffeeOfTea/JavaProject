package com.xb14620103.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xb14620103.domain.Diary;
import com.xb14620103.service.DiaryService;

/**
 * Servlet implementation class DetailsServlet
 */
@WebServlet("/details")
public class DetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Diary> dlist = null;
		// ��ȡidֵ
		int id = Integer.parseInt(request.getParameter("id"));
		String by = request.getParameter("by");
		// ����idֵ����service ����list
		try {
			dlist = new DiaryService().findById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("msg", "����ҳ��չʾʧ�ܣ������ԣ�");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			return;
		}
		if(by != null && by.equals("1")){
			// ���dlist ��������
			request.setAttribute("dlist", dlist);
			// ����ת��
			request.getRequestDispatcher("/detailsBy.jsp").forward(request, response);
			return;
		}
		if (dlist != null) {
			// ���dlist ��������
			request.setAttribute("dlist", dlist);
			// ����ת��
			request.getRequestDispatcher("/details.jsp").forward(request, response);
		}
		else{
			request.setAttribute("msg", "����ҳ��չʾʧ�ܣ������ԣ�");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
