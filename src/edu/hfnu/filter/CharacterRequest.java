package edu.hfnu.filter;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;


public class CharacterRequest extends HttpServletRequestWrapper {

	
	private HttpServletRequest request;
	
	public CharacterRequest(HttpServletRequest req) {
		super(req);
		this.request = req;
		
	}

	@Override
	public String getParameter(String name) {
		String value = request.getParameter(name);
		if(value==null) {
			return null;
		}
		String method = request.getMethod();
		if(method.equalsIgnoreCase("get")) {
			try {
				value = new String(value.getBytes("iso-8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		return value;
	}
	
	
	
	
	
	
	
	
	
	
	

}
