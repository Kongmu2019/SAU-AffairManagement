package edu.hfnu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.hfnu.model.AwardNameTable;
import edu.hfnu.model.JsonFormat;
import edu.hfnu.service.AwardNameService;

/**
 * AwardNameServlet处理获奖人员名单
 */
public class AwardNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * clubname:data.field.club
 	   ,activityname:data.field.activity
 	   ,prizewinner:data.field.name
 	  ,prize:data.field.award
 	   ,type:"submit"
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取html上传的参数
		String clubname = request.getParameter("clubname");
		String activityname = request.getParameter("activityname");
		String prizewinner = request.getParameter("prizewinner");
		String prize = request.getParameter("prize");
		String type = request.getParameter("type");
		
		//2.判断type类型，分开处理
		AwardNameService service = new AwardNameService();
		boolean flag = false;
		PrintWriter pw = response.getWriter();
		try {
		if(type.equals("submit")) {
			//如果是上传一条获奖记录
			AwardNameTable obj = new AwardNameTable(clubname,activityname,prizewinner,prize);
			flag = service.addOne(obj);
			
			//回显用户信息
			if(flag) {
				pw.print("上传一条获奖人员记录成功！");
			}else {
				pw.print("上传一条获奖人员记录失败！");
			}
		}else if(type.equals("announcement")) {
			//如果是公布获奖人员名单
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
			System.out.println("获奖人员名单Servlet请求参数错误");
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
