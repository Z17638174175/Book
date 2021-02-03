package com.lanou.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.lanou.bean.*;
import com.lanou.util.JDBCUtil;

public class ProductDaoImp implements IProductDao{

	private ITypeDao typedao = new TypeDaoImp();

	@Override
	public int PageCount() throws Exception {
		String sql = "select count(*) count from t_product";
		ResultSet rs = JDBCUtil.qeuryUtil(sql, null);
		if(rs.next()) {
			Integer pagecont = rs.getInt("count");
			
	      return pagecont;
		}
		return 0;
	}

	@Override
	public List<Product> getAllByPage(int pagenum, int pagecount) throws Exception {
		String sql = "select * from t_product limit ?,?";
		Object[] os= {((pagenum-1)*pagecount), pagecount};;
		List<Product> listproduct = new ArrayList<>();
		ResultSet rs = JDBCUtil.qeuryUtil(sql, os);
		
		while(rs.next()) {
			Integer id = rs.getInt("id");
			String pname = rs.getString("pname");
			String pimg = rs.getString("pimg");
			Double price = rs.getDouble("price");
			String ptitle = rs.getString("ptitle");
			Integer pv = rs.getInt("pv");
			Integer typeid = rs.getInt("typeid");
			Type type3 = typedao.getAllById(typeid);//3
			Type type2 = typedao.getAllById(type3.getParentid());//2
			Type type1 = typedao.getAllById(type2.getParentid());//1
			String pnames = type1.getTitle()+"-"+type2.getTitle()+"-"+type3.getTitle();
			Product product = new Product(id, pname, pimg, price, ptitle, pv, pnames);
			listproduct.add(product);
	   
		}
		return listproduct;
	}

	@Override
	public void addProduct(String pname, String pimg, String price, String ptitle, String pv, String typeid)
			throws Exception {
		String sql = "insert into t_product (pname,pimg,price,ptitle,pv,typeid) values (?,?,?,?,?,?)";
	    Object[] os= {pname,pimg,price,ptitle,pv,typeid};
	    JDBCUtil.addDeleteUpdate(sql, os);
	}

	@Override
	public void delProduct(String id) throws Exception {
		String sql = "delete from t_product where id="+id;
		JDBCUtil.addDeleteUpdate(sql, null);
	}

	@Override
	public void editProduct(String id, String pname, String pimg, String price, String ptitle, String pv, String typeid)
			throws Exception {

		String sql = "update t_product set pname=?,pimg=?,price=?,ptitle=?,pv=?,typeid=? where id=?";
		Object[] os = {pname,pimg,price,ptitle,pv,typeid,id};
		JDBCUtil.addDeleteUpdate(sql, os);
		
	}

	@Override
	public List<Product> getAll() throws Exception {
		String sql = "select * from t_product";
		
		List<Product> listproduct = new ArrayList<>();
		ResultSet rs = JDBCUtil.qeuryUtil(sql, null);
		
		while(rs.next()) {
			Integer id = rs.getInt("id");
			String pname = rs.getString("pname");
			String pimg = rs.getString("pimg");
			Double price = rs.getDouble("price");
			String ptitle = rs.getString("ptitle");
			Integer pv = rs.getInt("pv");
			Integer typeid = rs.getInt("typeid");
			Product product = new Product(id, pname, pimg, price, ptitle, pv, typeid+"");
			listproduct.add(product);
	   
		}
		return listproduct;
	}

	@Override
	public Product getAllById(Integer id) throws Exception {
        String sql = "select * from t_product where id=?";
        Object[] os = {id};
		ResultSet rs = JDBCUtil.qeuryUtil(sql, os);
		Product product = null;
		while(rs.next()) {
			String pname = rs.getString("pname");
			String pimg = rs.getString("pimg");
			Double price = rs.getDouble("price");
			String ptitle = rs.getString("ptitle");
			Integer pv = rs.getInt("pv");
			Integer typeid = rs.getInt("typeid");
			product = new Product(id, pname, pimg, price, ptitle, pv, typeid+"");
		}
		return product;
	}

	@Override
	public List<Product> getAllByNeiRong(String neirong) throws Exception {
		String sql = "select * from t_product where pname like '%"+neirong+"%'";
		
		List<Product> listproduct = new ArrayList<>();
		ResultSet rs = JDBCUtil.qeuryUtil(sql, null);
		
		while(rs.next()) {
			Integer id = rs.getInt("id");
			String pname = rs.getString("pname");
			String pimg = rs.getString("pimg");
			Double price = rs.getDouble("price");
			String ptitle = rs.getString("ptitle");
			Integer pv = rs.getInt("pv");
			Integer typeid = rs.getInt("typeid");
			Type type3 = typedao.getAllById(typeid);//3
			Type type2 = typedao.getAllById(type3.getParentid());//2
			Type type1 = typedao.getAllById(type2.getParentid());//1
			String pnames = type1.getTitle()+"-"+type2.getTitle()+"-"+type3.getTitle();
			Product product = new Product(id, pname, pimg, price, ptitle, pv, pnames);
			listproduct.add(product);
	   
		}
		return listproduct;
	}

	@Override
	public List<Product> getAllByTypeId(Integer typeId) throws Exception {
		String sql = "select * from t_product where typeid=?";
        Object[] os = {typeId};
        List<Product> listproduct = new ArrayList<>();
		ResultSet rs = JDBCUtil.qeuryUtil(sql, os);
		Product product = null;
		while(rs.next()) {
			String pname = rs.getString("pname");
			String pimg = rs.getString("pimg");
			Double price = rs.getDouble("price");
			String ptitle = rs.getString("ptitle");
			Integer pv = rs.getInt("pv");
			Integer id = rs.getInt("id");
			product = new Product(id, pname, pimg, price, ptitle, pv, typeId+"");
			
			listproduct.add(product);
		}
		return listproduct;
	}
}
