package com.xb14620103.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xb14620103.domain.PageBean;
import com.xb14620103.service.DiaryService;

/**
 * Servlet implementation class FindAllServlet
 */
@WebServlet("/findAll")
public class FindAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cp = request.getParameter("currPage");
		int currPage =1;
		if(cp == null || cp.trim().equals("")){
			currPage = Integer.parseInt("1");
		}
		else{
			currPage = Integer.parseInt(cp);
		}
		PageBean pb = null; 
		//����service��ȡdiary����
		try {
			pb = new DiaryService().findAll(currPage);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("msg", "������������ʧ������������");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			return;
		}
		if(pb != null){
			//������������
			request.setAttribute("pb", pb);
			//����ת����indexҳ��
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		else{
			request.setAttribute("msg", "������������Ϊnullʧ������������");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
