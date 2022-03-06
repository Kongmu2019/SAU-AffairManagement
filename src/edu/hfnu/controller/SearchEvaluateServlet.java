package edu.hfnu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.hfnu.model.JsonFormat;
import edu.hfnu.service.ClubEvaluateService;

/**
 * SearchEvaluateServlet组织部-社团年审查询
 */
public class SearchEvaluateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.获取服务层对象,查询数据库，得到存有所有年审表对象的集合
		ClubEvaluateService service = new ClubEvaluateService();
		try {
			ArrayList data = (ArrayList) service.findAll();
			int count = service.countAll();
			//1.实例化一个Layui数据表格规范json格式类
			JsonFormat format = new JsonFormat(0,"",count,data);
			//2.创建ObjectMapper对象,将JsonFormat对象进行转化，变为json字符串
			ObjectMapper om = new ObjectMapper();
			String json = om.writeValueAsString(format);
			
			//3.输出json给ajax请求
			response.setContentType("application/json;charset=utf-8");
			PrintWriter pw = response.getWriter();
			pw.print(json);
			pw.flush();
			pw.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
