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
 * ButtonCheckServlet处理审核信息是通过还是否决的状态
 */
public class ButtonCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取请求参数
		
		String clubname = request.getParameter("clubname");//荣誉证书审核&社团成立审核&活动室申请审核
		String planid_wrong = request.getParameter("planid");//团委-工作计划审核
		String itemid_wrong = request.getParameter("itemid");//团委-物资采购审核
		String name = request.getParameter("name");//根据活动名称修改申请活动审核状态
		String type = request.getParameter("type");
		
		//2.根据type的值判断做什么操作，先获取服务层操作对象
		HonorCertifyService honor = new HonorCertifyService();
		NewClubService club = new NewClubService();
		ItemCheckService item = new ItemCheckService();
		PlanCheckService plan = new PlanCheckService();
		ActivityService activity = new ActivityService();
		ActivityroomService room = new ActivityroomService();
		
		PrintWriter pw = response.getWriter();
		try {
		if(type.equals("honor_passStatus1")) {
			//组织部荣誉证书审核通过
			boolean flag = honor.updateStatusForMinister(clubname, "pass");
			//回显信息
			if(flag) {pw.print("操作成功！");}else {pw.print("操作失败！");}
			
		}else if(type.equals("honor_rejectStatus1")) {
			//组织部荣誉证书审核否决
			boolean flag = honor.updateStatusForMinister(clubname, "reject");
			if(flag) {pw.print("操作成功！");}else {pw.print("操作失败！");}
		}else if(type.equals("honor_passStatus2")) {
			//团委荣誉证书审核通过
			boolean flag = honor.updateStatusForTeacher(clubname, "pass");
			if(flag) {pw.print("操作成功！");}else {pw.print("操作失败！");}
		}else if(type.equals("honor_rejectStatus2")) {
			//团委荣誉证书审核否决
			boolean flag = honor.updateStatusForTeacher(clubname, "reject");
			if(flag) {pw.print("操作成功！");}else {pw.print("操作失败！");}
		}else if(type.equals("plan_pass")) {
			//团委工作计划审核通过
			if(planid_wrong!=null) {
				int planid = Integer.parseInt(planid_wrong);
				boolean flag = plan.updateStatusForTeacher(planid, "pass");
				if(flag) {pw.print("操作成功！");}else {pw.print("操作失败！");}
			}
		}else if(type.equals("plan_reject")) {
			//团委工作计划审核否决
			if(planid_wrong!=null) {
				int planid = Integer.parseInt(planid_wrong);
				boolean flag = plan.updateStatusForTeacher(planid, "reject");
				if(flag) {pw.print("操作成功！");}else {pw.print("操作失败！");}
			}
		}else if(type.equals("item_pass")) {
			//团委物资采购审核通过
			if(itemid_wrong!=null) {
				int itemid = Integer.parseInt(itemid_wrong);
				boolean flag = item.updateStatusForTeacher(itemid,"pass");
				if(flag) {pw.print("操作成功！");}else {pw.print("操作失败！");}
			}
		}else if(type.equals("item_reject")) {
			//团委物资采购审核否决
			if(itemid_wrong!=null) {
				int itemid = Integer.parseInt(itemid_wrong);
				boolean flag = item.updateStatusForTeacher(itemid,"reject");
				if(flag) {pw.print("操作成功！");}else {pw.print("操作失败！");}
			}
		}else if(type.equals("club_passStatus1")) {
			//组织部审核通过
			boolean flag = club.updateStatusForMinister(clubname,"pass");
			//回显信息
			if(flag) {pw.print("操作成功！");}else {pw.print("操作失败！");}
		}else if(type.equals("club_rejectStatus1")) {
			//组织部审核否决
			boolean flag = club.updateStatusForMinister(clubname,"reject");
			//回显信息
			if(flag) {pw.print("操作成功！");}else {pw.print("操作失败！");}
		}else if(type.equals("club_passStatus2")) {
			//团委审核通过
			boolean flag = club.updateStatusForTeacher(clubname,"pass");
			if(flag) {pw.print("操作成功！");}else {pw.print("操作失败！");}
		}else if(type.equals("club_rejectStatus2")) {
			//团委审核否决
			boolean flag = club.updateStatusForTeacher(clubname, "reject");
			if(flag) {pw.print("操作成功！");}else {pw.print("操作失败！");}
			
		}else if(type.equals("activity_pass")){
			//活动管理部部审核活动通过
			boolean flag = activity.updateStatus(name,"pass");
			if(flag) {pw.print("操作成功！");}else {pw.print("操作失败！");}
		}else if(type.equals("activity_reject")){
			//活动管理部部审核活动否决
			boolean flag = activity.updateStatus(name,"reject");
			if(flag) {pw.print("操作成功！");}else {pw.print("操作失败！");}
		}else if(type.equals("activityRoom_pass")){
			//活动管理部部审核活动室申请通过
			boolean flag = room.updateStatus(clubname,"pass");
			if(flag) {pw.print("操作成功！");}else {pw.print("操作失败！");}
		}else if(type.equals("activityRoom_reject")){
			//活动管理部部审核活动室申请否决
			boolean flag = room.updateStatus(clubname,"reject");
			if(flag) {pw.print("操作成功！");}else {pw.print("操作失败！");}
		}else {
			System.out.println("审核状态模块ButtonCheckServlet请求参数错误");
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
