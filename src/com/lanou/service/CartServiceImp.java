package com.lanou.service;

import java.util.ArrayList;
import java.util.List;

import com.lanou.bean.Cart;
import com.lanou.dao.CartDaoImp;
import com.lanou.dao.ICartDao;

public class CartServiceImp implements ICartService {

	private ICartDao cartDao = new CartDaoImp();
	@Override
	public List<Cart> getAll(int pagenum, int pagecount) throws Exception {
		// TODO Auto-generated method stub
		return cartDao.getAll(pagenum, pagecount);
	}

	@Override
	public void delById(String id) throws Exception {
		// TODO Auto-generated method stub
		cartDao.delById(id);
		
	}

	@Override
	public int PageCount() throws Exception {
		// TODO Auto-generated method stub
		return cartDao.PageCount();
	}

	@Override
	public List<Cart> getAllByUserId(String id) throws Exception {
		List<Cart> newcartlist = new ArrayList<>();
		List<Cart> listcart = cartDao.getAllByUserId(id);
		for(Cart cart:listcart) {
			Integer productid=cart.getProductid();
			String proname=cart.getPname();
			Integer pronum=cartDao.getcount(cart.getProductnum()+"",id);
			Cart newcart=new Cart(productid, proname, pronum);
			newcartlist.add(newcart);
		}
		
		return newcartlist;
	}

	@Override
	public void addCart(int userid, int productid) throws Exception {
		// TODO Auto-generated method stub
		cartDao.addCart(userid, productid);
	}

}
