package edu.hfnu.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.hfnu.service.ClubService;

/**
 * 用来添加和删除社团信息的NewDropClubServlet，社团表现记录功能
 */
public class NewDropClubServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.获取从HTML传来的请求参数
		String clubname = request.getParameter("club");
		String pname = request.getParameter("pname");
		String creditStr = request.getParameter("credit");
		String type = request.getParameter("type");
		
		//2.判断是增加社团还是删除社团
		PrintWriter pw = response.getWriter();
		try {
		//获取服务层对象
		ClubService service = new ClubService();
		boolean flag = false;
		if(type.equals("new")) {
			int credit = Integer.valueOf(creditStr);
			flag = service.newClub(clubname, pname, credit);
		}else if(type.equals("drop")){
			flag = service.dropClub(clubname);
		}else if(type.equals("shezhang")){
			//组织部-社团社长换届：修改社团所属社长的信息
			flag = service.updateProprieter(clubname, pname);
		}else if(type.equals("performance")) {
			//社团表现记录
			int credit = Integer.valueOf(creditStr);
			flag = service.updateCredit(clubname, credit);
		}else {
			System.out.println("NewDropClubServlet请求参数出错");
		}
		
		//回显ajax信息给用户
		if(flag) {
			if(type.equals("new"))
				pw.print("创建"+clubname+"成功！");
			else if(type.equals("drop"))
				pw.print("删除"+clubname+"成功！");
			else if(type.equals("shezhang"))
				pw.print("社团所属社长信息修改成功！");
			else
				pw.print("修改社团表现记录成功！");
		}else {
			if(type.equals("new"))
				pw.print("创建"+clubname+"失败！");
			else if(type.equals("drop"))
				pw.print("删除"+clubname+"失败！");
			else if(type.equals("shezhang"))
				pw.print("社团所属社长信息修改失败！");
			else
				pw.print("修改社团表现记录失败！");
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
