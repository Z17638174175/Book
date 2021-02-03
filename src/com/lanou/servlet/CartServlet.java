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
import com.lanou.bean.Cart;
import com.lanou.bean.JsonBean;
import com.lanou.service.CartServiceImp;
import com.lanou.service.ICartService;
@WebServlet("/cartServlet")
public class CartServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ICartService cartService = new CartServiceImp();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = null;
    	int count = 0;
		try {
			count = cartService.PageCount();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	Cookie[] cc = req.getCookies();
    	for(Cookie c : cc){
			 String key = c.getName();
		      if(key.equals("id")){
		    	 id = c.getValue();
		    	 
		      }
			}
    	
    	if(id!=null) {
    		List<Cart> listCart;
			try {
				listCart = cartService.getAllByUserId(id);
			
    			String strJson = JSON.toJSONString(listCart);
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
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String op = req.getParameter("op");
	        if(op==null || op.equals("")) {
	        	String pagenum = req.getParameter("page");
	    		String pagecount = req.getParameter("limit");
	    		
	    		try {
	    			int count = cartService.PageCount();
	    			List<Cart> listCart = cartService.getAll(Integer.parseInt(pagenum), Integer.parseInt(pagecount));
	    			JsonBean jsonStr = new JsonBean(0, "", count, listCart);
	    			String strJson = JSON.toJSONString(jsonStr);
	    			resp.setContentType("text/html;charset=utf-8");
	    			PrintWriter pw = resp.getWriter();
	    			pw.write(strJson);
	    			pw.flush();
	    			pw.close();
	    		}catch (Exception e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}
	        }else if(op.equals("del")) {
	        	String id = req.getParameter("id");
	        	try {
	        		cartService.delById(id);
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
	        }else if(op.equals("add")) {
	        	   String id = req.getParameter("id");
	        	   String userid = null;
	        	   Cookie[] cc = req.getCookies();
	        	   if(cc!=null) {
	        		   for(Cookie c : cc){
			       			 String key = c.getName();
			       		      if(key.equals("id")){
			       		    	userid = c.getValue();
			       		      }
		       			} 
	        	   }else {
	        		   PrintWriter pw = resp.getWriter();
	    				JsonBean jb = new JsonBean(0, "", null, null);
	    				String jsonStr = JSON.toJSONString(jb);
	    				pw.write(jsonStr);
	    				pw.flush();
	    				pw.close();
	        	   }
		           	if(userid!=null) {
		           		try {
		    	   			cartService.addCart(Integer.parseInt(userid), Integer.parseInt(id));
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
		           	}else {
			           		PrintWriter pw = resp.getWriter();
		    				JsonBean jb = new JsonBean(0, "", null, null);
		    				String jsonStr = JSON.toJSONString(jb);
		    				pw.write(jsonStr);
		    				pw.flush();
		    				pw.close();
		           	}
	    	   		
	        }
	}
	

}
