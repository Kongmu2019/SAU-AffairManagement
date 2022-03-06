package edu.hfnu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.hfnu.DBUtilsDao.CommonDao;

/**
 * 负责处理Layui数据表格中删除按钮的ButtonDeleteServlet
 */
public class ButtonDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.获取要删除行的id值和涉及修改的表格名称
		int id = Integer.parseInt(request.getParameter("id"));
		String table = request.getParameter("table");
		
		
		//2.根据对应表格来删除对应的行
		PrintWriter pw = response.getWriter();
		boolean flag = false;
		try {
			
			switch(table) {
			case "clubevaluate":
				flag = CommonDao.delClubevaluate(id);
				break;
			case "plancheck":
				flag = CommonDao.delPlancheck(id);
				break;
			case "itemcheck":
				flag = CommonDao.delItemcheck(id);
				break;
			case "contact1":
				flag = CommonDao.delContact1(id);
				break;
			case "contact2":
				flag = CommonDao.delContact2(id);
				break;
			case "items":
				flag = CommonDao.delItems(id);
				break;
			case "proprieters":
				flag = CommonDao.delProprieters(id);
				break;
			case "teachers":
				flag = CommonDao.delTeachers(id);
				break;
			case "ministers":
				flag = CommonDao.delMinisters(id);
				break;
			case "clubinfo":
				flag = CommonDao.delClubinfo(id);
				break;
			case "honorcheck":
				flag = CommonDao.delHonorcheck(id);
				break;
			case "activity":
				flag = CommonDao.delActivity(id);
				break;
			case "activityroom":
				flag = CommonDao.delActivityroom(id);
				break;
			case "newclub":
				flag = CommonDao.delNewclub(id);
				break;
			case "awardname":
				flag = CommonDao.delAwardname(id);
			default:
				System.out.println("删除行按钮ButtonDeleteServlet参数错误");
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//刷新缓存，关闭资源，好借好还，再借不难
			if(flag) {
				//回显数据给ajax
				pw.print("删除成功！");
			}else {
				pw.print("删除失败！");
			}
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
