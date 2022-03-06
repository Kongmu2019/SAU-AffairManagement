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
import edu.hfnu.model.NewClubTable;
import edu.hfnu.service.NewClubService;

/**
 * 社团成立审核的NewClubServlet
 */
public class NewClubServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * clubname:data.field.clubname
 	   ,proprieter:data.field.proprieter
 	   ,applytime:data.field.applytime
 	   ,status1:"unread"
 	   ,status2:"unread"
 	   ,type:"shezhang"
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.获取请求参数
				String clubname = request.getParameter("clubname");
				String proprieter = request.getParameter("proprieter");
				String applytime = request.getParameter("applytime");
				String status1 = request.getParameter("status1");
				String status2 = request.getParameter("status2");
				String reason1 = request.getParameter("reason1");
				String reason2 = request.getParameter("reason2");
				String type = request.getParameter("type");
				
				//2.判断类型，分开处理
				NewClubService service = new NewClubService();
				boolean flag = false;
				PrintWriter pw = response.getWriter();
				try {
				if(type.equals("apply")) {
					//如果是社长申请成立新社团
					NewClubTable table = new NewClubTable(clubname,proprieter,applytime,status1,status2,reason1,reason2);
					flag = service.addOne(table);
					
					//回显信息
					if(flag) {
						pw.print("增加一条新社团申请记录成功！");
					}else {
						pw.print("增加一条新社团申请记录失败！");
					}
				}else if(type.equals("zuzhibu")) {
					//如果是组织部审核
					ArrayList data = (ArrayList) service.findAllByOne("unread");
					int numbers = service.countAll("unread");
					//1.实例化一个Layui数据表格规范json格式类
					JsonFormat format = new JsonFormat(0,"",numbers,data);
					//2.创建ObjectMapper对象,将JsonFormat对象进行转化，变为json字符串
					ObjectMapper om = new ObjectMapper();
					String json = om.writeValueAsString(format);
					
					//3.输出json给ajax请求
					response.setContentType("application/json;charset=utf-8");
					pw.print(json);
				}else if(type.equals("tuanwei")) {
					//如果是团委审核,只看组织部通过的审核请求，第一个参数为pass
					ArrayList data = (ArrayList) service.findAll("pass","unread");
					int numbers = service.countAll("pass","unread");
					//1.实例化一个Layui数据表格规范json格式类
					JsonFormat format = new JsonFormat(0,"",numbers,data);
					//2.创建ObjectMapper对象,将JsonFormat对象进行转化，变为json字符串
					ObjectMapper om = new ObjectMapper();
					String json = om.writeValueAsString(format);
					
					//3.输出json给ajax请求
					response.setContentType("application/json;charset=utf-8");
					pw.print(json);
					
				}else if(type.equals("select")) {
					//如果是社长查询审核结果
					ArrayList data = (ArrayList) service.findAll();
					int numbers = service.countAll();
					//1.实例化一个Layui数据表格规范json格式类
					JsonFormat format = new JsonFormat(0,"",numbers,data);
					//2.创建ObjectMapper对象,将JsonFormat对象进行转化，变为json字符串
					ObjectMapper om = new ObjectMapper();
					String json = om.writeValueAsString(format);
					
					//3.输出json给ajax请求
					response.setContentType("application/json;charset=utf-8");
					pw.print(json);
				}else {
					System.out.println("成立新社团申请参数错误");
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
