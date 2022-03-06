package edu.hfnu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import edu.hfnu.model.JsonFormat;

/**
 * Servlet implementation class UploadServlet
 */
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.新建一个SmartUpload对象，必选
		SmartUpload su = new SmartUpload();
		
		//2.上传初始化，必选
		su.initialize(getServletConfig(),request,response);
		
		//3.对上传文件设置限定条件，任选
		//int maxSize = 100000;//限制每个上传文件的最大长度为100K
		//su.setMaxFileSize(maxSize);
		su.setAllowedFilesList("doc,docx,pdf,jpg,xls,xlsx");//通过扩展名设定只允许上传word文档和excel文档和图片文件
		
		try {
			//通过扩展名设定禁止上传exe、bat、jsp等文件，其中两个逗号表示没有扩展名的文件
			su.setDeniedFilesList("exe,bat,jsp,htm,html,,");
			//上传文件，必选
			su.upload();
			//指定上传文件的保存目录，必选
			int num = su.save("/upload");
			System.out.println("成功保存的文件个数："+num);
		} catch (SQLException | SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//得到上传的文件对象
		File file = su.getFiles().getFile(0);
		String msg = "";
		int count = 1;	//默认给的
		if(file.isMissing()) {//如果文件不存在
			msg = "";
			
		}else {
			msg = file.getFileName();
		}
		
		//回显Json字符串给上传组件
		//1.实例化一个Layui数据表格规范json格式类
		JsonFormat format = new JsonFormat(0,msg,count,null);
		//2.创建ObjectMapper对象,将JsonFormat对象进行转化，变为json字符串
		ObjectMapper om = new ObjectMapper();
		String json = om.writeValueAsString(format);
		System.out.println(json);
		//3.输出json给ajax请求
		response.setContentType("application/json;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.print(json);
		pw.flush();
		pw.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
