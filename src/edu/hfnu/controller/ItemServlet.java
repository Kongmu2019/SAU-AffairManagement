package edu.hfnu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.hfnu.DBUtilsDao.CommonDao;
import edu.hfnu.model.ItemsTable;
import edu.hfnu.model.JsonFormat;
import edu.hfnu.service.ItemsService;

/**
 * Servlet implementation class ItemServlet
 */
public class ItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	/**
	 *:data.field.itemid
 	   ,:data.field.itemname
 	   ,inventory:data.field.inventory
 	   ,type:"add"  search
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取传来的参数
		String idStr = request.getParameter("id");
		String itemid = request.getParameter("itemid");
		String itemname = request.getParameter("itemname");
		String inventory_wrong = request.getParameter("inventory");
		String type = request.getParameter("type");
		
		
		
		//判断
		ItemsService service = new ItemsService();
		boolean flag = false;
		PrintWriter pw = response.getWriter();
		try {
		if(type.equals("add")) {
			//如果是添加物资信息
			if(inventory_wrong!=null) {
			int inventory = Integer.parseInt(inventory_wrong);
			ItemsTable obj = new ItemsTable(itemid,itemname,inventory);
			flag = service.insert(obj);
			//回显用户信息
			if(flag) {
				pw.print("添加一条物资记录成功！");
			}else {
				pw.print("添加一条物资记录失败！");
			}
			}
		}else if(type.equals("search")) {
			//如果是查看所有物资信息
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
		}else if(type.equals("del")) {
			int id = Integer.parseInt(idStr);
			flag = CommonDao.delItems(id);
			if(flag) {
				pw.print("删除一条物资记录成功！");
			}else {
				pw.print("删除一条物资记录失败！");
			}
		}else if(type.equals("modify")) {
			//如果是修改物资库存数目
			if(inventory_wrong!=null) {
				int inventory = Integer.parseInt(inventory_wrong);
				flag = service.updateInventory(inventory, itemid);
				if(flag) {
					pw.print("修改一条物资记录成功！");
				}else {
					pw.print("修改一条物资记录失败！");
				}
			}
		}else {
			System.out.println("ItemsServlet物资管理参数传递错误--资管部");
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
