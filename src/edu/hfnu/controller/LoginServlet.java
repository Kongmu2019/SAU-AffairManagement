package edu.hfnu.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.hfnu.model.Minister;
import edu.hfnu.model.Proprieter;
import edu.hfnu.model.Teacher;
import edu.hfnu.service.LoginService;

/**
 * LoginServlet:登录功能
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//1.获取登录界面传来的用户名，密码，用户类型的信息，并判断是否空
		String username = request.getParameter("username").trim();
		String password = request.getParameter("password").trim();
		String usertype = request.getParameter("leixing").trim();
		
		//防止用户输入为空
		if(username.equals("")) {
			Map<String,String> errors = new HashMap<String,String>();
			errors.put("loginname", "用户名不能为空");
			request.setAttribute("errors", errors);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}else if(password.equals("")) {
			Map<String,String> errors = new HashMap<String,String>();
			errors.put("loginpass", "密码不能为空");
			request.setAttribute("errors", errors);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}else if(username.equals("")&&password.equals("")) {
			Map<String,String> errors = new HashMap<String,String>();
			errors.put("loginname", "用户名不能为空");
			errors.put("loginpass", "密码不能为空");
			request.setAttribute("errors", errors);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		
		
		//2.利用服务层访问数据库，先判断对应的用户类型，再调用相应的方法从数据库中检查用户名和密码是否正确
		LoginService login = new LoginService();
		try {
			if(login.validateByNameAndPwd(username, password, usertype)) {
				//1.查询成功，分三种用户类型对应处理
				if(usertype.equals("tuanwei")) {
					//团委老师
					Teacher teacher = login.findTeacherByName(username);
					//保存团委老师对象到HttpSession对象
					 request.getSession().setAttribute("currentUser9",teacher);
					 request.getSession().setAttribute("currentUserId9",teacher.getId());
					 request.getSession().setAttribute("currentUserName9",teacher.getName());
					 //重定向到团委老师管理界面
					 response.sendRedirect(request.getContextPath()+"/tuanwei.jsp");
					 return;
				}else if(usertype.equals("shelian")) {
					//如果是社联部长，则取出Minister对象，并获取该对象的dept值，重定向到对应部门管理主页
					Minister minister = login.findMinisterByName(username);
					
					 if(minister.getDept().equals("办公室")) {
						 //此时登录的是社联办公室部长，重定向到其管理页面
						//保存社联部长对象到HttpSession对象
						 request.getSession().setAttribute("currentUser1",minister);
						 request.getSession().setAttribute("currentUserId1",minister.getId());
						 request.getSession().setAttribute("currentUserName1",minister.getName());
						 request.getSession().setAttribute("currentUserDept1",minister.getDept());
						 response.sendRedirect(request.getContextPath()+"/bangongshi.jsp");
						 return;
					 }else if(minister.getDept().equals("财务部")) {
						 //财务部部长
						//保存社联部长对象到HttpSession对象
						 request.getSession().setAttribute("currentUser2",minister);
						 request.getSession().setAttribute("currentUserId2",minister.getId());
						 request.getSession().setAttribute("currentUserName2",minister.getName());
						 request.getSession().setAttribute("currentUserDept2",minister.getDept());
						 response.sendRedirect(request.getContextPath()+"/caiwubu.jsp");
						 return;
					 }else if(minister.getDept().equals("会员工作部")) {
						 //会员工作部
						//保存社联部长对象到HttpSession对象
						 request.getSession().setAttribute("currentUser3",minister);
						 request.getSession().setAttribute("currentUserId3",minister.getId());
						 request.getSession().setAttribute("currentUserName3",minister.getName());
						 request.getSession().setAttribute("currentUserDept3",minister.getDept());
						 response.sendRedirect(request.getContextPath()+"/huigongbu.jsp");
						 return;
					 }else if(minister.getDept().equals("活动管理部")) {
						 //活动管理部
						//保存社联部长对象到HttpSession对象
						 request.getSession().setAttribute("currentUser4",minister);
						 request.getSession().setAttribute("currentUserId4",minister.getId());
						 request.getSession().setAttribute("currentUserName4",minister.getName());
						 request.getSession().setAttribute("currentUserDept4",minister.getDept());
						 response.sendRedirect(request.getContextPath()+"/huoguanbu.jsp");
						 return;
					 }else if(minister.getDept().equals("外联部")) {
						 //外联部
						//保存社联部长对象到HttpSession对象
						 request.getSession().setAttribute("currentUser5",minister);
						 request.getSession().setAttribute("currentUserId5",minister.getId());
						 request.getSession().setAttribute("currentUserName5",minister.getName());
						 request.getSession().setAttribute("currentUserDept5",minister.getDept());
						 response.sendRedirect(request.getContextPath()+"/wailianbu.jsp");
						 return;
					 }else if(minister.getDept().equals("宣传部")) {
						 //宣传部
						//保存社联部长对象到HttpSession对象
						 request.getSession().setAttribute("currentUser6",minister);
						 request.getSession().setAttribute("currentUserId6",minister.getId());
						 request.getSession().setAttribute("currentUserName6",minister.getName());
						 request.getSession().setAttribute("currentUserDept6",minister.getDept());
						 response.sendRedirect(request.getContextPath()+"/xuanchuanbu.jsp");
						 return;
					 }else if(minister.getDept().equals("资源管理部")) {
						 //资源管理部
						//保存社联部长对象到HttpSession对象
						 request.getSession().setAttribute("currentUser7",minister);
						 request.getSession().setAttribute("currentUserId7",minister.getId());
						 request.getSession().setAttribute("currentUserName7",minister.getName());
						 request.getSession().setAttribute("currentUserDept7",minister.getDept());
						 response.sendRedirect(request.getContextPath()+"/ziguanbu.jsp");
						 return;
					 }else if(minister.getDept().equals("组织部")) {
						 //组织部
						//保存社联部长对象到HttpSession对象
						 request.getSession().setAttribute("currentUser8",minister);
						 request.getSession().setAttribute("currentUserId8",minister.getId());
						 request.getSession().setAttribute("currentUserName8",minister.getName());
						 request.getSession().setAttribute("currentUserDept8",minister.getDept());
						 response.sendRedirect(request.getContextPath()+"/zuzhibu.jsp");
						 return;
					 }
					
				}else if(usertype.equals("shezhang")){
					//社团负责人，即社长
					Proprieter proprieter = login.findProprieterByName(username);
					//保存社团负责人对象到HttpSession对象
					 request.getSession().setAttribute("currentUser10",proprieter);
					 request.getSession().setAttribute("currentUserId10",proprieter.getId());
					 request.getSession().setAttribute("currentUserName10",proprieter.getName());
					 request.getSession().setAttribute("currentUserClub",proprieter.getClub());
					 //重定向到社长管理界面
					 response.sendRedirect(request.getContextPath()+"/shezhang.jsp");
					 return;
				}else {
					System.out.println("登录LoginServlet参数用户类型传递错误！");
				}
				
				//获取用户名保存到cookie中 
				 String loginname = username; 
				 loginname =URLEncoder.encode(loginname, "utf-8");
				 Cookie cookie = new Cookie("loginname", loginname); 
				 cookie.setMaxAge(60 * 60 * 24 * 1);//保存1天
				 response.addCookie(cookie);
				
				
			}else if(login.isExistUser(username, usertype)) {
				//提示用户：用户名正确但密码不对
				Map<String,String> errors = new HashMap<String,String>();
				errors.put("loginpass", "密码错误");
				request.setAttribute("errors", errors);
				request.getRequestDispatcher("/login.jsp").forward(request, response);
				return;
			}else {
				//提示用户：该用户不存在
				Map<String,String> errors = new HashMap<String,String>();
				errors.put("loginname", "用户不存在");
				request.setAttribute("errors", errors);
				request.getRequestDispatcher("/login.jsp").forward(request, response);
				return;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
