package com.lanou.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req1 = (HttpServletRequest) req;
		HttpServletResponse resp1 = (HttpServletResponse) resp;
		String uri = req1.getRequestURI();
		if(uri.endsWith("login.html")||uri.endsWith("adminlogin")||uri.endsWith("fail.jsp")) {
			chain.doFilter(req1, resp1);
		}else {
			HttpSession session =  req1.getSession();
			Object obj = session.getAttribute("admintsr");
			if(obj!=null) {
				chain.doFilter(req1, resp1);
			}else {
				resp1.sendRedirect("login.html");
			}
		}
		
	}

}
