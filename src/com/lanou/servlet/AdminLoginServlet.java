package com.lanou.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.lanou.bean.Admin;
import com.lanou.bean.JsonBean;
import com.lanou.service.AdminServiceImp;
import com.lanou.service.IAdminService;

@WebServlet("/adminlogin")
public class AdminLoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IAdminService  iAdminService = new AdminServiceImp();
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String adminname = req.getParameter("adminname");
	String pwd = req.getParameter("password");
	
	try {
		int pagecount = iAdminService.PageCount();
		Admin admintsr = iAdminService.login(adminname, pwd);
		req.getSession().setAttribute("admintsr", admintsr);
		JsonBean jsonStr = new JsonBean(0, "", pagecount, admintsr);
		String strJson = JSON.toJSONString(jsonStr);
		resp.setContentType("text/html;charset=utf-8");//½â¾öÂÒÂë
		PrintWriter pw = resp.getWriter();
		pw.write(strJson);
		pw.flush();
		pw.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
