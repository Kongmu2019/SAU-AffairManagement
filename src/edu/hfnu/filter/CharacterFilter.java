package edu.hfnu.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 防止全站中文乱码问题的Filter
 */
public class CharacterFilter implements Filter {

   
    public CharacterFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		//1.设置响应中文乱码
		resp.setContentType("text/html;charset=utf-8");
		
		//2.设置post请求乱码
		String method = req.getMethod();
		if(method.equalsIgnoreCase("post")) {
		req.setCharacterEncoding("utf-8");
		}
		
		//3.采用加强版的request请求，来处理get请求中文乱码问题
		CharacterRequest charaterRequest = new CharacterRequest(req);
		
		
		
		chain.doFilter(charaterRequest, resp);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
