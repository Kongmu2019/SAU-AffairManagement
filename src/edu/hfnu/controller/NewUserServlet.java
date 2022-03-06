package edu.hfnu.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.hfnu.service.UserService;

/**
 * Servlet implementation class NewUserServlet
 */
public class NewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得从各个新建用户的html传来的请求参数
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String dept = "";
		String dept_wrong = request.getParameter("dept");
		String club = request.getParameter("club");
		String type = request.getParameter("type");
		
		//修复部门是英文的bug
		if(dept_wrong==null) {		//修复空指针异常
			dept = "";
		}else if(dept_wrong.equals("bangongshi")) {
			dept = "办公室";
		}else if(dept_wrong.equals("zuzhibu")) {
			dept = "组织部";
		}else if(dept_wrong.equals("ziguanbu")) {
			dept = "资源管理部";
		}else if(dept_wrong.equals("huigongbu")) {
			dept = "会员工作部";
		}else if(dept_wrong.equals("xuanchuanbu")) {
			dept = "宣传部";
		}else if(dept_wrong.equals("caiwubu")) {
			dept = "财务部";
		}else if(dept_wrong.equals("wailianbu")) {
			dept = "外联部";
		}else if(dept_wrong.equals("huoguanbu")) {
			dept = "活动管理部";
		}
		
		
		//2.判断类型，分开处理，先获取服务层对象
		boolean flag=false;
		try {
		UserService service = new UserService();
		
		if(type.equals("tuanwei")) {
			//在teachers表中新建用户
			flag = service.addTeacher(name, password);
		}else if(type.equals("shelian")) {
			//在ministers表中新建用户
			flag = service.addMinister(name, password, dept);
		}else if(type.equals("shezhang")) {
			//在proprieters表中新建用户
			flag = service.addProprieter(name, password, club);
		}else {
			flag=false;
			System.out.println("新建用户参数传输错误");
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//通过ajax回显给用户的信息
		
		PrintWriter pw = response.getWriter();
		try {
		if(flag) {
			pw.print("新增"+name+"用户成功！");
		}else {
			pw.print("新增"+name+"用户失败！");
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
