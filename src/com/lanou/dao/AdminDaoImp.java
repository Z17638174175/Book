package com.lanou.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lanou.bean.Admin;
import com.lanou.util.JDBCUtil;



public class AdminDaoImp implements IAdminDao{

	@Override
	public Admin login(String adminname,String adminpwd) throws Exception {
		String sql = "select * from t_admin where adminname=? and adminpwd = ? ";
		Object[] os = {adminname,adminpwd};
		ResultSet rs = JDBCUtil.qeuryUtil(sql, os);
		if(rs.next()) {
			Integer id = rs.getInt("id");
			Admin admin = new Admin(id, adminname, adminpwd);
	      return admin;
		}
		return null;
	}

	@Override
	public int PageCount() throws Exception {
		String sql = "select count(*) count from t_admin";
		ResultSet rs = JDBCUtil.qeuryUtil(sql, null);
		if(rs.next()) {
			Integer pagecont = rs.getInt("count");
			
	      return pagecont;
		}
		return 0;

}

	@Override
	public List<Admin> getByPage(int pagenum, int pagecount) throws Exception {
		
		String sql = "select *from t_admin limit ?,?";
		Object[] os= {((pagenum-1)*pagecount), pagecount};;
		List<Admin> listadmin = new ArrayList<>();
		ResultSet rs = JDBCUtil.qeuryUtil(sql, os);
		while(rs.next()) {
			Integer id = rs.getInt("id");
			String adminname = rs.getString("adminname");
			String adminpwd = rs.getString("adminpwd");
			Admin admin = new Admin(id, adminname, adminpwd);
			listadmin.add(admin);
	   
		}
		return listadmin;
	}

	@Override
	public void adminAdd(String adminname, String pwd) throws Exception {
	    String sql = "insert into t_admin (adminname,adminpwd) values (?,?)";
	    Object[] os= {adminname,pwd};
	    JDBCUtil.addDeleteUpdate(sql, os);
		
	}

	@Override
	public void adminDel(String id) throws Exception {
		String sql = "delete from t_admin where id="+id;
		JDBCUtil.addDeleteUpdate(sql, null);
		
	}

	@Override
	public void adminEdit(String id,String adminname,String pwd) throws Exception {
		String sql = "update t_admin set adminname=?,adminpwd=? where id=?";
		Object[] os = {adminname,pwd,id};
		JDBCUtil.addDeleteUpdate(sql, os);
		
	}
}
