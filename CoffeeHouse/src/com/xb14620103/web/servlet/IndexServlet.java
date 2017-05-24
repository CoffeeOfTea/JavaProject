package com.xb14620103.web.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/indexServlet")
public class IndexServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public String index(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return "/index.jsp";
	}
}
