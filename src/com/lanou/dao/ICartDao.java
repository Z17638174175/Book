package com.lanou.dao;

import java.util.List;

import com.lanou.bean.Cart;

public interface ICartDao {

	
	public List<Cart> getAll(int pagenum, int pagecount) throws Exception;
	
	public void delById(String id) throws Exception;
	
	public int PageCount() throws Exception ;
	
	public List<Cart> getAllByUserId(String id) throws Exception;
	
	public void addCart(int userid,int productid) throws Exception;

	int getcount(String proid,String userid) throws Exception;
	
}
