package com.lanou.service;

import java.util.List;

import com.lanou.bean.Product;
import com.lanou.dao.IProductDao;
import com.lanou.dao.ProductDaoImp;

public class ProductServiceImp implements IProductService{

	private IProductDao product = new ProductDaoImp();
	@Override
	public List<Product> getAllByPage(int pagenum, int pagecount) throws Exception {
		// TODO Auto-generated method stub
		return product.getAllByPage(pagenum, pagecount);
	}

	@Override
	public int PageCount() throws Exception {
		// TODO Auto-generated method stub
		return product.PageCount();
	}

	@Override
	public void addProduct(String pname, String pimg, String price, String ptitle, String pv, String typeid)
			throws Exception {
		// TODO Auto-generated method stub
		product.addProduct(pname, pimg, price, ptitle, pv, typeid);
		
	}

	@Override
	public void delProduct(String id) throws Exception {
		// TODO Auto-generated method stub
		product.delProduct(id);
		
	}

	@Override
	public void editProduct(String id, String pname, String pimg, String price, String ptitle, String pv, String typeid)
			throws Exception {
		// TODO Auto-generated method stub
		product.editProduct(id, pname, pimg, price, ptitle, pv, typeid);
		
	}

	@Override
	public List<Product> getAll() throws Exception {
		// TODO Auto-generated method stub
		return product.getAll();
	}

	@Override
	public Product getAllById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return product.getAllById(id);
	}

	@Override
	public List<Product> getAllByNeiRong(String neirong) throws Exception {
		// TODO Auto-generated method stub
		return product.getAllByNeiRong(neirong);
	}

	@Override
	public List<Product> getAllByTypeId(Integer typeId) throws Exception {
		// TODO Auto-generated method stub
		return product.getAllByTypeId(typeId);
	}

}
