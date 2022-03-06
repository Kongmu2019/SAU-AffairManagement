package edu.hfnu.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import sun.misc.BASE64Encoder;

public class DownUtils {
	public static String filenameEncoding(String filename,HttpServletRequest request) throws UnsupportedEncodingException {
		String agent = request.getHeader("User-Agent");//获取浏览器
		if(agent.contains("Firefox")) {
			BASE64Encoder base64Encoder = new BASE64Encoder();
			filename = "=?utf-8?B?"+
					base64Encoder.encode(filename.getBytes("utf-8"))+
					"?=";
		}else if(agent.contains("MISE")) {
			filename = URLEncoder.encode(filename, "utf-8");
		}else {
			filename = URLEncoder.encode(filename, "utf-8");
		}
		return filename;
		
	}
}
