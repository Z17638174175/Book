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
import com.lanou.bean.Carousel;
import com.lanou.bean.JsonBean;
import com.lanou.service.CarouselServiceImp;
import com.lanou.service.ICarouselService;

public class CarouselServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
	private ICarouselService carouselService = new CarouselServiceImp();
 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("op");

		if(op==null || op.equals("")) {
			List<Carousel> listCarousel;
			try {
				listCarousel = carouselService.getAll();
				JsonBean jsonStr = new JsonBean(0, "", 10, listCarousel);
				String strJson = JSON.toJSONString(jsonStr);
				
				resp.setContentType("text/html;charset=utf-8");//解决乱码
				PrintWriter pw = resp.getWriter();
				pw.write(strJson);
				pw.flush();
				pw.close();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		}else if(op.equals("add")) {
			Part part = req.getPart("nfile"); 
			String name2 = part.getSubmittedFileName();//上传的文件名称
			String path = req.getServletContext().getRealPath("");
			path = path.substring(0, path.lastIndexOf("\\"));
			path = path.substring(0, path.lastIndexOf("\\"));
			path = path+File.separator+"BookP"+File.separator;
			
			File f = new File(path);
			if(f.exists()){
				
			}else{
				f.mkdir();//创建文件夹
			}
			
			part.write(path+name2);
			try {
				carouselService.addCarousel(name2);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}else if(op.equals("del")) {
			String id = req.getParameter("id");
			try {
				carouselService.delCarousel(id);
				JsonBean jsonStr = new JsonBean(200, "", 10, null);
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
