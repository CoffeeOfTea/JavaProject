package com.xb14620103.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.xb14620103.domain.User;
import com.xb14620103.service.UserService;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/user")
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * 注册
	 * @param req
	 * @param resp
	 * @return
	 */
	public String register(HttpServletRequest req, HttpServletResponse resp){
		//0.获取表单信息
		User user = new User();
		req.setAttribute("isnull", "");
		//封装数据
		try {
			user.setType("user");
			BeanUtils.populate(user, req.getParameterMap());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			req.setAttribute("msg", "封装数据失败，请重试！");
			return "/msg.jsp";
		}
		//1.调用service 加入数据库
		String str = null;
		try {
			str = new UserService().register(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			req.setAttribute("msg", "注册失败，请重试！");
			return "/msg.jsp";
		}
		//2.请求重定向，注册是否成功
		try {
			resp.sendRedirect(req.getContextPath()+"/"+str+".jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 登陆
	 * @param req
	 * @param resp
	 * @return
	 */
	public String login(HttpServletRequest req, HttpServletResponse resp){
		//0.获取表单信息
		User user = new User();
		//封装数据
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		user.setUsername(username);
		user.setPassword(password);
		//1.调用service 检查用户是否存在
		String str = null;
		try {
			str = new UserService().login(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			req.setAttribute("msg", "登陆失败，请检查用户名或密码是否正确！");
			return "/msg.jsp";
		}
		//登陆成功，请求转发
		if(str.equals("success")){
			
			req.getSession().setAttribute("username", username);
/*			System.out.println(username+"登陆了");
			ServletContext application = this.getServletContext();   
			//获取当前登陆人数
			String users = (String) application.getAttribute("users");
			if(users == null){
				users = username;
			}
			else{
				users += ","+username;
			}
			application.setAttribute("users", users);*/
			return "/main.jsp";
		}
		req.setAttribute("msg", "登陆失败，请检查用户名或密码是否正确！");
		return "/msg.jsp";
	}
	
	/**
	 * 发送消息
	 * @param req
	 * @param resp
	 * @return
	 */
	public String infoSend(HttpServletRequest req, HttpServletResponse resp){
		//设置响应编码
		resp.setCharacterEncoding("utf-8");
		HttpSession session = req.getSession();
		ServletContext application =session.getServletContext();
		String str = (String) application.getAttribute("infomation");
		//第一次发送 开始组装str字符串
		if(str == null){
			if(!req.getParameter("str").equals("")){
				str = (String) req.getSession().getAttribute("username")+":";
				str += "\r\n"; 
				str += req.getParameter("str");
			}
		}//第二次之后组装str
		else{
			
			if(!req.getParameter("str").equals("")){
				str += "\r\n";
				str += (String) req.getSession().getAttribute("username")+":";
				str += "\r\n";
				str += req.getParameter("str");
			}
		}
		application.setAttribute("infomation", str);
		try {
			resp.getWriter().println(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 展示数据
	 * @param req
	 * @param resp
	 * @return
	 */
	public String infoShow(HttpServletRequest req, HttpServletResponse resp){
		//设置响应编码
		resp.setCharacterEncoding("utf-8");
		ServletContext application = getServletContext();
		String str = (String) application.getAttribute("infomation");
		try {
			if(str != null)
				resp.getWriter().println(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 显示在线
	 * @param req
	 * @param resp
	 * @return
	 */
/*	public String onlineDisplay(HttpServletRequest req, HttpServletResponse resp){	
		//设置响应编码
		resp.setCharacterEncoding("utf-8");
		ServletContext application = getServletContext();
		String str = (String) application.getAttribute("users");
		try {
			if(str != null)
				resp.getWriter().println(str);
			System.out.println(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}*/
	
}
