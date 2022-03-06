package edu.hfnu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用来处理用户退出登录的LoginOutServlet
 */
public class LoginOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1.获取需要注销的用户类别
		String type = request.getParameter("type");
		
		//2.根据类别判断
		if(type.substring(0, 7).equals("shelian")) {
			//从session中移除社联用户
			request.getSession().removeAttribute("currentUser"+type.substring(7));
			request.getSession().removeAttribute("currentUserId"+type.substring(7));
			request.getSession().removeAttribute("currentUserName"+type.substring(7));
			request.getSession().removeAttribute("currentUserDept"+type.substring(7));
		}else if(type.equals("tuanwei")) {
			//从session中移除团委用户
			request.getSession().removeAttribute("currentUser1");
			request.getSession().removeAttribute("currentUserId1");
			request.getSession().removeAttribute("currentUserName1");
		}else if(type.equals("shezhang")) {
			//从session中移除社长用户
			request.getSession().removeAttribute("currentUser2");
			request.getSession().removeAttribute("currentUserId2");
			request.getSession().removeAttribute("currentUserName2");
			request.getSession().removeAttribute("currentUserClub");
		}else {
			System.out.println("参数传递错误");
		}
		
		//清除Cookie
		Cookie c = new Cookie("loginname","");
		c.setMaxAge(0);
		c.setPath(request.getContextPath());
		response.addCookie(c);
				
		//重定向到登录页
		response.sendRedirect(request.getContextPath()+"/login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
