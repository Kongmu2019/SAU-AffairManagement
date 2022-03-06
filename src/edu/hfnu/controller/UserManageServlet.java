package edu.hfnu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.hfnu.model.JsonFormat;
import edu.hfnu.service.ClubService;
import edu.hfnu.service.UserService;

/**
 * 负责回传三类管理人员信息的UserManageServlet
 */
public class UserManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取html传入的参数
		String type = request.getParameter("type");
		
		
		//2.根据类型判断
		PrintWriter pw = response.getWriter();
		UserService user = new UserService();
		ClubService club = new ClubService();
		try {
		if(type.equals("clubinfo")) {
			//查询社团信息表
			ArrayList data = (ArrayList) club.findAll();
			int count = club.countAll();
			//1.实例化一个Layui数据表格规范json格式类
			JsonFormat format = new JsonFormat(0,"",count,data);
			//2.创建ObjectMapper对象,将JsonFormat对象进行转化，变为json字符串
			ObjectMapper om = new ObjectMapper();
			String json = om.writeValueAsString(format);
			
			//3.输出json给ajax请求
			response.setContentType("application/json;charset=utf-8");
			pw.print(json);
		}else if(type.equals("proprieters")) {
			//查询社长信息表
			ArrayList data = (ArrayList) user.findAllProprieters();
			int count = user.countAllProprieter();
			//1.实例化一个Layui数据表格规范json格式类
			JsonFormat format = new JsonFormat(0,"",count,data);
			//2.创建ObjectMapper对象,将JsonFormat对象进行转化，变为json字符串
			ObjectMapper om = new ObjectMapper();
			String json = om.writeValueAsString(format);
			
			//3.输出json给ajax请求
			response.setContentType("application/json;charset=utf-8");
			pw.print(json);
		}else if(type.equals("teachers")) {
			//查询团委老师表
			ArrayList data = (ArrayList) user.findAllTeachers();
			int count = user.countAllTeacher();
			//1.实例化一个Layui数据表格规范json格式类
			JsonFormat format = new JsonFormat(0,"",count,data);
			//2.创建ObjectMapper对象,将JsonFormat对象进行转化，变为json字符串
			ObjectMapper om = new ObjectMapper();
			String json = om.writeValueAsString(format);
			
			//3.输出json给ajax请求
			response.setContentType("application/json;charset=utf-8");
			pw.print(json);
		}else if(type.equals("ministers")) {
			//查询社联部长表
			ArrayList data = (ArrayList) user.findAllMinisters();
			int count = user.countAllMinister();
			//1.实例化一个Layui数据表格规范json格式类
			JsonFormat format = new JsonFormat(0,"",count,data);
			//2.创建ObjectMapper对象,将JsonFormat对象进行转化，变为json字符串
			ObjectMapper om = new ObjectMapper();
			String json = om.writeValueAsString(format);
			
			//3.输出json给ajax请求
			response.setContentType("application/json;charset=utf-8");
			pw.print(json);
		}else {
			System.out.println("用户管理Servlet参数异常");
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
