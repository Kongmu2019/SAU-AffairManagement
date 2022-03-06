package edu.hfnu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jspsmart.upload.Request;

import edu.hfnu.model.ActivityTable;
import edu.hfnu.model.JsonFormat;
import edu.hfnu.service.ActivityService;
import edu.hfnu.service.AwardNameService;

/**
 * 处理社团活动申请的ActivityServlet
 */
public class ActivityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * clubname:data.field.clubname
 	   ,name:data.field.name
 	   ,activitytime:data.field.activitytime
 	   ,site:data.field.site
 	   ,scope:data.field.scope
 	   ,proprieter:data.field.proprieter
 	   ,status:"unread"
 	   ,type:"shezhang"
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //1.获取表单传来的参数
        String clubname = request.getParameter("clubname");
        String name = request.getParameter("name");
        String activitytime = request.getParameter("activitytime");
        String site = request.getParameter("site");
        String scope = request.getParameter("scope");
        String proprieter = request.getParameter("proprieter");
        String status = request.getParameter("status");
        String reason = request.getParameter("reason");
        String type = request.getParameter("type");
        
        //2.根据type判断
        ActivityService service = new ActivityService();
		boolean flag = false;
		PrintWriter pw = response.getWriter();
		try {
        if(type.equals("shezhang")) {
        	//社长传来的社团活动申请请求
        	ActivityTable obj = new ActivityTable(clubname,name,activitytime,site,scope,proprieter,status,reason);
        	flag = service.insert(obj);
        	//回显用户信息
			if(flag) {
				pw.print("上传一条活动申请记录成功！");
			}else {
				pw.print("上传一条活动申请记录失败！");
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
        	//如果是查询审核结果
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
        	System.out.println("活动申请Servlet参数失败");
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
