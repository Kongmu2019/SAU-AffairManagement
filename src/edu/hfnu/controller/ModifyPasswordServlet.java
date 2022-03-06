package edu.hfnu.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.hfnu.service.LoginService;

/**
 * Servlet implementation class ModifyPasswordServlet
 */
public class ModifyPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//1.获取ajax传来的参数
		String name = request.getParameter("name");
		String oldpass = request.getParameter("oldpass");
		String newpass = request.getParameter("newpass");
		String type = request.getParameter("type");
		
		//2.根据type判断不同的用户类型，分开处理
		LoginService service = new LoginService();	//拿到login服务层
		PrintWriter pw = response.getWriter();
		try {
		if(type.equals("tuanwei")) {
			//2-1.校验旧密码是否正确
			boolean flag  = service.validateOldPasswordForTeacher(name, oldpass);
			if(!flag) {//如果不正确,ajax回显给用户信息
				pw.print("旧密码输入错误！");
			}else {
				//如果旧密码校验成功：
				service.updatePasswordForTeacher(name, newpass);
				pw.print("修改密码成功！");
			}
		}else if(type.equals("shelian")) {
			//2-1.校验旧密码是否正确
			boolean flag  = service.validateOldPasswordForMinister(name, oldpass);
			if(!flag) {//如果不正确,ajax回显给用户信息
				pw.print("旧密码输入错误！");
			}else {
				//如果旧密码校验成功：
				service.updatePasswordForMinister(name, newpass);
				pw.print("修改密码成功！");
			}
		}else if(type.equals("shezhang")){
			//2-1.校验旧密码是否正确
			boolean flag  = service.validateOldPasswordForProprieter(name, oldpass);
			if(!flag) {//如果不正确,ajax回显给用户信息
				pw.print("旧密码输入错误！");
			}else {
				//如果旧密码校验成功：
				service.updatePasswordForProprieter(name, newpass);
				pw.print("修改密码成功！");
			}
		}else {
			System.out.println("修改密码Servlet请求类型出错");
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			pw.flush();
			pw.close();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
