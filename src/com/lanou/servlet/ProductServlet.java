package com.lanou.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.alibaba.fastjson.JSON;
import com.lanou.bean.JsonBean;
import com.lanou.bean.Product;
import com.lanou.bean.*;
import com.lanou.dao.ITypeDao;
import com.lanou.dao.TypeDaoImp;
import com.lanou.service.IProductService;
import com.lanou.service.ProductServiceImp;


public class ProductServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private IProductService productService = new ProductServiceImp();
	
	private ITypeDao typedao = new TypeDaoImp();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("op");
	    if(op==null || op.equals("")) {
	    	String pagenum = req.getParameter("page");
			String pagecount = req.getParameter("limit");
			
			try {
				int count = productService.PageCount();
				List<Product> listproduct = productService.getAllByPage(Integer.parseInt(pagenum), Integer.parseInt(pagecount));
				JsonBean jsonStr = new JsonBean(0, "", count, listproduct);
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
		 if(op.equals("1")) {
		    	try {
		    		int count = productService.PageCount();
					List<Type> typelist = typedao.getAll(0);
					JsonBean jsonStr = new JsonBean(0, "", count, typelist);
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
		    }else if(op.equals("2")) {
		    	try {
		    		String parentid = req.getParameter("parentid");
		    		int count = productService.PageCount();
					List<Type> typelist = typedao.getAll(Integer.parseInt(parentid));
					JsonBean jsonStr = new JsonBean(0, "", count, typelist);
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
		    }else if(op.equals("3")) {
		    	try {
		    		String parentid = req.getParameter("parentid");
		    		int count = productService.PageCount();
					List<Type> typelist = typedao.getAll(Integer.parseInt(parentid));
					JsonBean jsonStr = new JsonBean(0, "", count, typelist);
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
		    }else if(op.equals("add")) {
		    	String pname = req.getParameter("pname");
		    	String price = req.getParameter("price");
		    	String ptitle = req.getParameter("ptitle");
		    	String pv = req.getParameter("pv");
		    	String typeid = req.getParameter("pid");
				Part part = req.getPart("nfile"); 
				String pimg = part.getSubmittedFileName();//上传的文件名称
				String path = req.getServletContext().getRealPath("");
				path = path.substring(0, path.lastIndexOf("\\"));
				path = path.substring(0, path.lastIndexOf("\\"));
				path = path+File.separator+"BookP"+File.separator;
				System.out.println(typeid);
				File f = new File(path);
				if(f.exists()){
					
				}else{
					f.mkdir();//创建文件夹
				}
				
				part.write(path+pimg);
				try {
					productService.addProduct(pname, pimg, price, ptitle, pv, typeid);
					
				} catch (Exception e) {
					
					e.printStackTrace();
				}
		    }else if(op.equals("del")) {
		    	String id = req.getParameter("id");
		    	try {
		    		productService.delProduct(id);
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
		    }else if(op.equals("edit")) {
		    	String id = req.getParameter("id");
		    	String pname = req.getParameter("pname");
		    	String price = req.getParameter("price");
		    	String ptitle = req.getParameter("ptitle");
		    	String pv = req.getParameter("pv");
		    	String typeid = req.getParameter("pid");
				Part part = req.getPart("nfile"); 
				String pimg = part.getSubmittedFileName();//上传的文件名称
				String path = req.getServletContext().getRealPath("");
				path = path.substring(0, path.lastIndexOf("\\"));
				path = path.substring(0, path.lastIndexOf("\\"));
				path = path+File.separator+"BookP"+File.separator;
				
				File f = new File(path);
				if(f.exists()){
					
				}else{
					f.mkdir();//创建文件夹
				}
				
				part.write(path+pimg);
				try {
					productService.editProduct(id, pname, pimg, price, ptitle, pv, typeid);
					
				} catch (Exception e) {
					
					e.printStackTrace();
				}
		    }else if(op.equals("getall")) {
		    	try {

					List<Product> listproduct = productService.getAll();
					String strJson = JSON.toJSONString(listproduct);
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
		    }else if(op.equals("xiangqing")) {
		    	String id = req.getParameter("id");
				Product product;
				
				try {
					product = productService.getAllById(Integer.parseInt(id));
					String strJson = JSON.toJSONString(product);
					
					resp.setContentType("text/html;charset=utf-8");//解决乱码
					PrintWriter pw = resp.getWriter();
					pw.write(strJson);
					pw.flush();
					pw.close();
				}catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
		    }else if(op.equals("serch")){
		    	try {
                    String serchname = req.getParameter("serchname");
					List<Product> listproduct = productService.getAllByNeiRong(serchname);
					String strJson = JSON.toJSONString(listproduct);
					resp.setContentType("text/html;charset=utf-8");//解决乱码
					PrintWriter pw = resp.getWriter();
					pw.write(strJson);
					pw.flush();
					pw.close();
				}  catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }else if(op.equals("typeserch")) {
		    	String id = req.getParameter("id");
				System.out.println(id);
				try {
					List<Product> listproduct = productService.getAllByTypeId(Integer.parseInt(id));
					String strJson = JSON.toJSONString(listproduct);
					resp.setContentType("text/html;charset=utf-8");//解决乱码
					PrintWriter pw = resp.getWriter();
					pw.write(strJson);
					pw.flush();
					pw.close();
				}catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		       }
	}
	}

