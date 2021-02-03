package com.lanou.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
@WebServlet("/adminServlet")
public class AdminServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IAdminService  iAdminService = new AdminServiceImp();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String op = req.getParameter("op");
        if(op==null || op.equals("")) {
        	String pagenum = req.getParameter("page");
    		String pagecount = req.getParameter("limit");
    		
    		try {
    			int count = iAdminService.PageCount();
    			List<Admin> listadmin = iAdminService.getByPage(Integer.parseInt(pagenum), Integer.parseInt(pagecount));
    			JsonBean jsonStr = new JsonBean(0, "", count, listadmin);
    			String strJson = JSON.toJSONString(jsonStr);
    			resp.setContentType("text/html;charset=utf-8");//½â¾öÂÒÂë
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
        }else if(op.equals("add")) {
        	String adminname = req.getParameter("adminname");
    		String adminpwd = req.getParameter("adminpwd");
    		try {
				iAdminService.adminAdd(adminname, adminpwd);
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
				iAdminService.adminDel(id);
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
        	String adminname = req.getParameter("adminname");
    		String adminpwd = req.getParameter("adminpwd");
        	try {
				iAdminService.adminEdit(id, adminname, adminpwd);
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
        }
		
		
	}

}
