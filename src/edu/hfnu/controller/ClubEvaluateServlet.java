package edu.hfnu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.hfnu.model.ClubEvaluateTable;
import edu.hfnu.service.ClubEvaluateService;

/**
 * Servlet implementation class ClubEvaluateServlet
 */
public class ClubEvaluateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.收集各个删除用户html传来的请求参数，并封装数据到对象中
		String clubname = request.getParameter("clubname");
		String zhiliangS = request.getParameter("zhiliang");
		String yingxiangS = request.getParameter("yingxiang");
		String manyiS = request.getParameter("manyi");
		String hudongS = request.getParameter("hudong");
		String totalS = request.getParameter("total");
		String type = request.getParameter("type");
		
		//转换一些数据格式
		int zhiliang = Integer.valueOf(zhiliangS);
		int yingxiang = Integer.valueOf(yingxiangS);
		int manyi = Integer.valueOf(manyiS);
		int hudong = Integer.valueOf(hudongS);
		int total = Integer.valueOf(totalS);
		
		//封装数据到对象中
		ClubEvaluateTable c = new ClubEvaluateTable(clubname,zhiliang,yingxiang,manyi,hudong,total);
		
		//2.获取Service层对象，根据type的值进行判断是增加还是查询
		ClubEvaluateService service = new ClubEvaluateService();
		PrintWriter pw = response.getWriter();
		boolean flag = false;
		try {
			//团委添加一条社团年审信息
			flag = service.addOne(c);
			//3.向用户回显信息
			if(flag) {
				pw.print("评价"+clubname+"成功！");
			}else {
				pw.print("评价"+clubname+"失败！");
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
