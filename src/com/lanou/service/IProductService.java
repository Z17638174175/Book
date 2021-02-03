package com.lanou.service;

import java.util.List;

import com.lanou.bean.Product;

public interface IProductService {

	public List<Product> getAllByPage(int pagenum, int pagecount) throws Exception;
	
	public int PageCount() throws Exception;
	
	public void addProduct(String pname, String pimg, String price, String ptitle, String pv, String typeid)
			throws Exception ;
	
	public void delProduct(String id) throws Exception;
	
	public void editProduct(String id, String pname, String pimg, String price, String ptitle, String pv, String typeid)
			throws Exception;
	
	public List<Product> getAll() throws Exception;
	
	public Product getAllById(Integer id) throws Exception;
	
	public List<Product> getAllByNeiRong(String neirong) throws Exception;
	
	public List<Product> getAllByTypeId(Integer typeId) throws Exception;
}
