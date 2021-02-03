package com.lanou.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.lanou.bean.Admin;
import com.lanou.bean.JsonBean;
import com.lanou.bean.User;
import com.lanou.service.IUserService;
import com.lanou.service.UserServiceImp;
@WebServlet("/userServlet")
public class UserServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private IUserService userService = new UserServiceImp();

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String op = req.getParameter("op");
    if(op==null || op.equals("")) {
    	String pagenum = req.getParameter("page");
		String pagecount = req.getParameter("limit");
		
		try {
			int count = userService.getPageCount();
			List<User> listadmin = userService.getAllByPage(Integer.parseInt(pagenum), Integer.parseInt(pagecount));
			JsonBean jsonStr = new JsonBean(0, "", count, listadmin);
			String strJson = JSON.toJSONString(jsonStr);
			resp.setContentType("text/html;charset=utf-8");//解决乱码
			PrintWriter pw = resp.getWriter();
			pw.write(strJson);
			pw.flush();
			pw.close();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
    
   @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   String op = req.getParameter("op");

	   if(op.equals("add")) {
		String name = req.getParameter("name");
	   	String pwd = req.getParameter("pwd");
	   	String phone = req.getParameter("phone");
	   	String mail = req.getParameter("mail");
	   	String address = req.getParameter("address");
	   		try {
	   			userService.userAdd(name, pwd, phone, mail, address);;
				PrintWriter pw = resp.getWriter();
				JsonBean jb = new JsonBean(200, "", null, null);
				String jsonStr = JSON.toJSONString(jb);
				pw.write(jsonStr);
				pw.flush();
				pw.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   }else if(op.equals("edit")) {
       	String id = req.getParameter("id");
       	String name = req.getParameter("name");
   		String pwd = req.getParameter("pwd");
   		String phone = req.getParameter("phone");
   		String mail = req.getParameter("mail");
   		String address = req.getParameter("address");
       	try {
       		userService.userEditById(Integer.parseInt(id), name, pwd, phone, mail, address);
				PrintWriter pw = resp.getWriter();
				JsonBean jb = new JsonBean(200, "", null, null);
				String jsonStr = JSON.toJSONString(jb);
				pw.write(jsonStr);
				pw.flush();
				pw.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
       }else if(op.equals("del")) {
         	String id = req.getParameter("id");
         	try {
       		    userService.userDel(id);
				PrintWriter pw = resp.getWriter();
				JsonBean jb = new JsonBean(200, "", null, null);
				String jsonStr = JSON.toJSONString(jb);
				pw.write(jsonStr);
				pw.flush();
				pw.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
       }else if(op.equals("login")) {
    	   String name = req.getParameter("name");
    		String pwd = req.getParameter("pwd");
    		
    		
    		try {
    			int pagecount = userService.getPageCount();
    			User user = userService.login(name, pwd);
    			int id = user.getId();
    			 Cookie c1 = new Cookie("id",id+"");
    			 c1.setMaxAge(10000);
    			 
    			 resp.addCookie(c1);
    			 Cookie c2 = new Cookie("name",name);
    			 c2.setMaxAge(10000);
    			 
    			 resp.addCookie(c2);
    			req.getSession().setAttribute("user", user);
    			JsonBean jsonStr = new JsonBean(0, "", pagecount, user);
    			String strJson = JSON.toJSONString(jsonStr);
    			resp.setContentType("text/html;charset=utf-8");//解决乱码
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
}
