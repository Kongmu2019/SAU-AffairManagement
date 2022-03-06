package edu.hfnu.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * 使用jspSmartUpload组件下载DownloadServlet2
 */
public class DownloadServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取要下载的文件名
		String filename = request.getParameter("file1");
		System.out.println(filename);
		
		//新建一个SmartUpload对象
		SmartUpload su = new SmartUpload();
		su.initialize(getServletConfig(), request, response);
		su.setContentDisposition(null);
		
//		File file = su.getFiles().getFile(0);
		try {
			//if(!file.isMissing())
				su.downloadFile("/upload/"+filename);
			//else {
//				PrintWriter pw = response.getWriter();
//				pw.print("<h2>文件"+file.getFileName()+"不存在，无法下载！！</h2>");
//				pw.flush();
//				pw.close();
//			}
		} catch (SmartUploadException e) {
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
