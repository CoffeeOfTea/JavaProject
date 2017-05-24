package com.xb14620103.web.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/baseServlet")
public class BaseServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Class<? extends BaseServlet> clazz = this.getClass();
		String name = req.getParameter("method");
		if(name == null){
			name = "index";
		}
		try {
			Method method = clazz.getMethod(name, HttpServletRequest.class,HttpServletResponse.class);
			String s = (String) method.invoke(this,req,resp);
			if(s != null){
				req.getRequestDispatcher(s).forward(req, resp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	public String index(HttpServletRequest req, HttpServletResponse resp){
		return null;
	}
}
