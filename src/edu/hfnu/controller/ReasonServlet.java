package edu.hfnu.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.hfnu.service.ActivityService;
import edu.hfnu.service.ActivityroomService;
import edu.hfnu.service.HonorCertifyService;
import edu.hfnu.service.ItemCheckService;
import edu.hfnu.service.NewClubService;
import edu.hfnu.service.PlanCheckService;

/**
 * 用于实现更新否决原因的 ReasonServlet
 */
public class ReasonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	/**
	 *
    	id:data.id
    	,reason:value
    	,table:"activity"
    	,type:"add"
    
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取参数
		String idStr = request.getParameter("id");
		String reason = request.getParameter("reason");
		String table = request.getParameter("table");
		String type = request.getParameter("type");
		
		//2.根据type判断是add还是remove，再根据table判断应该对哪张表操作
		
		ActivityService activity = new ActivityService();
		ActivityroomService room = new ActivityroomService();
		ItemCheckService itemcheck = new ItemCheckService();
		PlanCheckService plan = new PlanCheckService();
		HonorCertifyService honor = new HonorCertifyService();
		NewClubService newclub = new NewClubService();
		boolean flag = false;
		PrintWriter pw = response.getWriter();
		if(type.equals("add")) {
			try {
			//如果是修改否决原因，根据表名找到对应表操作
			int id = Integer.parseInt(idStr);
			switch(table) {
			case "activity":
				//调用activity的service层中updateReason()方法
				flag = activity.updateReason(id, reason);
				break;
			case "activityroom":
				//调用activityroom的service层中updateReason()方法
				flag = room.updateReason(id, reason);
				break;
			case "honorcheck1":
				//组织部回填原因，调用honorcheck的service层中updateReason1()方法
				flag = honor.updateReason1(id, reason);
				break;
			case "honorcheck2":
				//团委回填原因，调用honorcheck的service层中updateReason2()方法
				flag = honor.updateReason2(id, reason);
				break;
			case "itemcheck":
				//调用itemcheck的service层中updateReason()方法
				flag = itemcheck.updateReason(id, reason);
				break;
			case "newclub1":
				//组织部回填否决理由，调用newclub的service层中updateReason1()方法
				flag = newclub.updateReason1(id, reason);
				break;
			case "newclub2":
				//团委回填否决理由，调用newclub的service层中updateReason2()方法
				flag = newclub.updateReason2(id, reason);
				break;
			case "plancheck":
				//调用plancheck的service层中updateReason()方法
				flag = plan.updateReason(id, reason);
				break;
			}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if(flag)
					pw.print("添加否决原因成功！");
				else
					pw.print("添加否决原因失败!");
				pw.flush();
				pw.close();
			}
		}else if(type.equals("remove")) {
			try {
			//如果是清空否决原因，根据表名找到对应表操作
			switch(table) {
			case "activity":
				//调用activity的service层中removeReason()方法
				
				break;
			case "activityroom":
				//调用activityroom的service层中removeReason()方法
				
				break;
			case "honorcheck":
				//调用honorcheck的service层中removeReason()方法
				
				break;
			case "itemcheck":
				//调用itemcheck的service层中removeReason()方法
				
				break;
			case "newclub":
				//调用newclub的service层中removeReason()方法
				
				break;
			case "plancheck":
				//调用plancheck的service层中removeReason()方法
				
				break;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(flag)
				pw.print("清除否决原因成功！");
			else
				pw.print("清除否决原因失败!");
			pw.flush();
			pw.close();
		}
		}else {
			System.out.println("用于回填否决原因的ReasonServlet的参数错误");
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
