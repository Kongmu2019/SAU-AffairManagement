package edu.hfnu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.hfnu.model.Contact1Table;
import edu.hfnu.model.Contact2Table;
import edu.hfnu.model.JsonFormat;
import edu.hfnu.service.ContactService;

/**
 * 实现社团、社联通讯目录的ContactServlet
 */
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * clubname:data.field.clubname
  	   ,proprieter:data.field.proprieter
 	   ,sex:data.field.sex
 	   ,grade:data.field.grade
  	   ,address:data.field.address
 	   ,mobilephone:data.field.mobilephone
  	   ,type:"club"
  	   
  	   dept:data.field.dept
 	   ,minister:data.field.minister
	   ,sex:data.field.sex
	   ,grade:data.field.grade
 	   ,address:data.field.address
	   ,mobilephone:data.field.mobilephone
 	   ,type:"union"
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.获取参数
		String clubname = request.getParameter("clubname");
		String dept = request.getParameter("dept");
		String minister = request.getParameter("minister");
		String proprieter = request.getParameter("proprieter");
		String sex = request.getParameter("sex");
		String grade = request.getParameter("grade");
		String address = request.getParameter("address");
		String mobilephone = request.getParameter("mobilephone");
		String type = request.getParameter("type");
		
		//根据type判断
		ContactService service = new ContactService();
		boolean flag = false;
		PrintWriter pw = response.getWriter();
		try {
		if(type.equals("club")) {
			//新增一条社团通讯记录
			Contact2Table obj = new Contact2Table(clubname,proprieter,sex,grade,address,mobilephone);
			flag = service.insertContact2(obj);
			if(flag) {pw.print("新增联系人成功！");}else {pw.print("新增联系人失败！");}
		}else if(type.equals("union")) {
			//新增一条社联通讯记录
			Contact1Table obj = new Contact1Table(dept,minister,sex,grade,address,mobilephone);
			flag = service.insertContact1(obj);
			if(flag) {pw.print("新增联系人成功！");}else {pw.print("新增联系人失败！");}
		}else if(type.equals("clubselect")) {
			//查询社团所有通讯记录
			ArrayList data = (ArrayList) service.findAllContact2();
			int numbers = service.countAllContact2();
			//1.实例化一个Layui数据表格规范json格式类
			JsonFormat format = new JsonFormat(0,"",numbers,data);
			//2.创建ObjectMapper对象,将JsonFormat对象进行转化，变为json字符串
			ObjectMapper om = new ObjectMapper();
			String json = om.writeValueAsString(format);
			
			//3.输出json给ajax请求
			response.setContentType("application/json;charset=utf-8");
			pw.print(json);
		}else if(type.equals("unionselect")) {
			//查询社联所有通讯记录
			ArrayList data = (ArrayList) service.findAllContact1();
			int numbers = service.countAllContact1();
			//1.实例化一个Layui数据表格规范json格式类
			JsonFormat format = new JsonFormat(0,"",numbers,data);
			//2.创建ObjectMapper对象,将JsonFormat对象进行转化，变为json字符串
			ObjectMapper om = new ObjectMapper();
			String json = om.writeValueAsString(format);
			
			//3.输出json给ajax请求
			response.setContentType("application/json;charset=utf-8");
			pw.print(json);
			
		}else {
			System.out.println("办公室通讯管理Servlet参数传递错误");
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
