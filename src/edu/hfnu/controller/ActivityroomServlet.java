package edu.hfnu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.hfnu.model.ActivityroomTable;
import edu.hfnu.model.JsonFormat;
import edu.hfnu.service.ActivityroomService;

/**
 * clubname:data.field.clubname
 	   ,timeblock:data.field.timeblock
 	   ,purpose:data.field.purpose
 	   ,proprieter:data.field.proprieter
 	   ,status:"unread"
 	   ,type:"shezhang"
 */
public class ActivityroomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.获得活动室使用申请表单传来的参数
		String clubname = request.getParameter("clubname");
		String timeblock = request.getParameter("timeblock");
		String purpose = request.getParameter("purpose");
		String proprieter = request.getParameter("proprieter");
		String status = request.getParameter("status");
		String reason = request.getParameter("reason");
		String type = request.getParameter("type");
		

		
		//2.根据type判断
		ActivityroomService service = new ActivityroomService();
		boolean flag = false;
		PrintWriter pw = response.getWriter();
		try {
        if(type.equals("shezhang")) {
        	//社长传来的社团活动申请请求
        	ActivityroomTable obj = new ActivityroomTable(clubname,timeblock,purpose,proprieter,status,reason);
        	flag = service.insert(obj);
        	//回显用户信息
			if(flag) {
				pw.print("上传一条活动室申请记录成功！");
			}else {
				pw.print("上传一条活动室申请记录失败！");
			}
        }else if(type.equals("huoguanbu")) {
        	//活管部要显示全部unread记录
        	ArrayList data = (ArrayList) service.findAll("unread");
			int count = service.countAll("unread");
			//1.实例化一个Layui数据表格规范json格式类
			JsonFormat format = new JsonFormat(0,"",count,data);
			//2.创建ObjectMapper对象,将JsonFormat对象进行转化，变为json字符串
			ObjectMapper om = new ObjectMapper();
			String json = om.writeValueAsString(format);
			
			//3.输出json给ajax请求
			response.setContentType("application/json;charset=utf-8");
			pw.print(json);
			
        }else if(type.equals("select")) {
        	//如果是社长想查看审核结果
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
        	System.out.println("活动室申请Servlet参数失败");
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
