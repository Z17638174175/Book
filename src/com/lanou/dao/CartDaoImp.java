package com.lanou.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lanou.bean.Carousel;
import com.lanou.bean.Cart;
import com.lanou.bean.Product;
import com.lanou.bean.User;
import com.lanou.util.JDBCUtil;

public class CartDaoImp implements ICartDao {

	
	private IUserDao userDao = new UserDaoImp();
	
	private IProductDao productDao = new ProductDaoImp();
	
	@Override
	public List<Cart> getAll(int pagenum, int pagecount) throws Exception {
		String sql = "select *from t_cart limit ?,?";
		Object[] os= {((pagenum-1)*pagecount), pagecount};
		
		List<Cart> listcart = new ArrayList<>();
		ResultSet rs = JDBCUtil.qeuryUtil(sql, os);
		while(rs.next()) {
			Integer id = rs.getInt("id");
			Integer userid = rs.getInt("userid");
			Integer productid = rs.getInt("productid");
			User user = userDao.getAllById(userid);
			Product product = productDao.getAllById(productid);
			Cart cart = new Cart(id, userid, user.getName(), user.getPhone(), productid,product.getPname());
			listcart.add(cart);
		
	}
		return listcart;
	}

	@Override
	public void delById(String id) throws Exception {
		String sql = "delete from t_cart where id=?";
	    Object[] os= {id};
	    JDBCUtil.addDeleteUpdate(sql, os);
   }

	@Override
	public int PageCount() throws Exception {
		String sql = "select count(*) count from t_cart";
		ResultSet rs = JDBCUtil.qeuryUtil(sql, null);
		if(rs.next()) {
			Integer pagecont = rs.getInt("count");
			
	      return pagecont;
		}
		return 0;
	}

	@Override
	public List<Cart> getAllByUserId(String id) throws Exception {
		String sql="select distinct productid,userid from t_cart where userid="+id;
		List<Cart> listcart = new ArrayList<>();
		ResultSet rs = JDBCUtil.qeuryUtil(sql, null);
		while(rs.next()) {
			
			Integer userid = rs.getInt("userid");
			Integer productid = rs.getInt("productid");
			User user = userDao.getAllById(userid);
			Product product = productDao.getAllById(productid);
			Cart cart = new Cart(productid, product.getPname(),productid);
			listcart.add(cart);
		
	}
		
		return listcart;
	}

	@Override
	public void addCart(int userid,int productid) throws Exception {
		String sql = "insert into t_cart (userid,productid)values(?,?)";
		Object[] os = {userid,productid};
		JDBCUtil.addDeleteUpdate(sql, os);
		
	}
	@Override
	public int getcount(String proid ,String userid) throws Exception {
		String sql="select count(id)  from t_cart where  productid=? and userid =?";
		Object[] os= {proid,userid};
		ResultSet rs=JDBCUtil.qeuryUtil(sql, os);
		if(rs.next()) {
			Integer pronum=rs.getInt("count(id)");
			return pronum;
		}
		return 0;
	}
	}


