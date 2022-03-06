package edu.hfnu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.hfnu.model.ItemCheckTable;
import edu.hfnu.model.JsonFormat;
import edu.hfnu.model.PlanCheckTable;
import edu.hfnu.service.ItemCheckService;

/**
 * 处理采购物资申请审核与提交
 */
public class ItemCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * date:data.field.date
 	   ,item:data.field.item
 	   ,price:data.field.price
 	   ,numbers
 	   ,status:"unread"
 	   ,type:"ziguanbu"
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取html上传的参数
		String date = request.getParameter("date");
		String item = request.getParameter("item");
		String priceStr = request.getParameter("price");
		String numbersStr = request.getParameter("numbers");
		String status = request.getParameter("status");
		String reason = request.getParameter("reason");
		String type = request.getParameter("type");
		
		//2.判断type类型，分开处理
		ItemCheckService service = new ItemCheckService();
		boolean flag = false;
		PrintWriter pw = response.getWriter();
		try {
		if(type.equals("ziguanbu")) {
			//如果是资源管理部上传一条采购物资审核记录
			int price = Integer.parseInt(priceStr);
			int numbers = Integer.parseInt(numbersStr);
			ItemCheckTable obj = new ItemCheckTable(date,item,price,numbers,status,reason);
			flag = service.insert(obj);
			
			//回显用户信息
			if(flag) {
				pw.print("上传一条采购物资记录成功！");
			}else {
				pw.print("上传一条采购物资记录失败！");
			}
		}else if(type.equals("tuanwei")) {
			//如果是团委审核工作计划
			ArrayList data = (ArrayList) service.findAllForTeacher("unread");
			int count = service.countAll("unread");
			//1.实例化一个Layui数据表格规范json格式类
			JsonFormat format = new JsonFormat(0,"",count,data);
			//2.创建ObjectMapper对象,将JsonFormat对象进行转化，变为json字符串
			ObjectMapper om = new ObjectMapper();
			String json = om.writeValueAsString(format);
			
			//3.输出json给ajax请求
			response.setContentType("application/json;charset=utf-8");
			pw.print(json);
		}else if(type.equals("status")) {
			//如果是资管部查询审核结果
			ArrayList data = (ArrayList) service.findAll();
			int count = service.countAll();
			//1.实例化一个Layui数据表格规范json格式类
			JsonFormat format = new JsonFormat(0,"",count,data);
			//2.创建ObjectMapper对象,将JsonFormat对象进行转化，变为json字符串
			ObjectMapper om = new ObjectMapper();
			String json = om.writeValueAsString(format);
			
			//3.输出json给ajax请求
			response.setContentType("application/json;charset=utf-8");
			pw.print(json);
			
		}else {
			System.out.println("物资采购申请Servlet请求参数错误");
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
