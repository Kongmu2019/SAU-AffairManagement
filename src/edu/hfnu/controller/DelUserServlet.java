package edu.hfnu.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.hfnu.service.UserService;

/**
 * Servlet implementation class DelUserServlet
 */
public class DelUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.收集各个删除用户html传来的请求参数
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		
		
		//2.判断类型，分开处理，先取出Service层对象
		boolean flag = false;
		try {
		UserService service = new UserService();
		if(type.equals("tuanwei")) {
			flag = service.deleteTeacher(name);
		}else if(type.equals("shelian")) {
			flag = service.deleteMinister(name);
		}else if(type.equals("shezhang")) {
			flag = service.deleteProprieter(name);
		}else if(type.equals("all")) {
			//删除所有的社联部长信息
			flag = service.deleteAllMinister();
		}else {
			flag = false;
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//通过ajax回显给用户的信息
		
		PrintWriter pw = response.getWriter();
		try {
			if(type.equals("all")&&flag==true) {
				pw.print("删除所有社联部长在任信息成功！");
			}else if(flag) {
				pw.print("删除"+name+"用户成功！");
			}else {
				pw.print("删除"+name+"用户失败！");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			pw.flush();
			pw.close();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
