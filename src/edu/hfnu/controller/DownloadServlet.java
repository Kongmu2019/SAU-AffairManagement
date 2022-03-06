package edu.hfnu.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.hfnu.utils.DownUtils;

/**
 * Servlet implementation class DownloadServlet
 */
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//1.获取下载的文件名称
		String filename = request.getParameter("file1");
	
		//2.获取文件的MIME类型
		String filetype = request.getServletContext().getMimeType(filename);
		//利用downutils工具类来解决下载文件的文件名中文乱码问题
		String name = DownUtils.filenameEncoding(filename, request);
		//3.设置两个响应头
		response.addHeader("Content-Type", filetype);
		response.addHeader("Content-Disposition", "attachment;filename="+name);
		//4.文件的下载
		String folder = "/upload/";
			//4.1获取文件的输入流
			InputStream in = getServletContext().getResourceAsStream(folder+filename);
			//4.2获取响应输出流
			OutputStream out = response.getOutputStream();
		//5.流的对接
		byte[] buffer = new byte[1024];
		int len = 0;
		//6.循环读取流中的元素
		while((len = in.read(buffer)) != -1) {
			out.write(buffer, 0, len);
		}
		//7.好借好还，再借不难：关闭输入输出流对象
		out.close();
		in.close();
		
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
