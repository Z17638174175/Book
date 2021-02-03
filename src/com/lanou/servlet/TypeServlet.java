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
import com.lanou.bean.JsonBean;
import com.lanou.bean.Type;

import com.lanou.service.ITypeService;
import com.lanou.service.TypeServiceImp;

@WebServlet("/typeServlet")
public class TypeServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ITypeService typeService = new TypeServiceImp();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String op = req.getParameter("op");
	    if(op==null || op.equals("")) {
			try {
				
				List<Type> listtype = typeService.getAll();
				JsonBean jsonStr = new JsonBean(0, "", null, listtype);
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
	    }else if(op.equals("addAndEdit")) {
	    	String id = req.getParameter("id");
			String title = req.getParameter("title");
			String parentid = req.getParameter("parentid");
	    	if(id==null||id.equals("")) {
	    		try {
					typeService.addType(title, Integer.parseInt(parentid));
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}else {
	    		try {
					typeService.editType(Integer.parseInt(id), title);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    	
	    	resp.setContentType("text/html;charset=utf-8");
			PrintWriter pw = resp.getWriter();
			JsonBean jb = new JsonBean(200, "", null, null);
			String jsonStr = JSON.toJSONString(jb);
			pw.write(jsonStr);
			pw.flush();
			pw.close();
	    }else if(op.equals("del")) {
	    	String id = req.getParameter("id");
	    	try {
				typeService.delType(Integer.parseInt(id));
				resp.setContentType("text/html;charset=utf-8");
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
	    }else if(op.equals("leibie")) {
          try {
				
				List<Type> listtype = typeService.getAll();
				
				
				String strJson = JSON.toJSONString(listtype);
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
}
