package com.lanou.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lanou.bean.Admin;
import com.lanou.bean.User;
import com.lanou.util.JDBCUtil;

public class UserDaoImp implements IUserDao{

	@Override
	public List<User> getAllByPage(int pagenum, int pagecount) throws Exception {
		String sql = "select *from t_user limit ?,?";
		Object[] os= {((pagenum-1)*pagecount), pagecount};;
		List<User> listuser = new ArrayList<>();
		ResultSet rs = JDBCUtil.qeuryUtil(sql, os);
		while(rs.next()) {
			Integer id = rs.getInt("id");
			String name = rs.getString("name");
			String pwd = rs.getString("pwd");
			String phone = rs.getString("phone");
			String mail = rs.getString("mail");
			String address = rs.getString("address");
			String backup1 = rs.getString("backup1");
			User user = new User(id, name, pwd, phone, mail, address, backup1);
			listuser.add(user);
	   
		}
		return listuser;
	}

	@Override
	public int getPageCount() throws Exception {
		String sql = "select count(*) count from t_user";
		ResultSet rs = JDBCUtil.qeuryUtil(sql, null);
		if(rs.next()) {
			Integer pagecont = rs.getInt("count");
			
	      return pagecont;
		}
		return 0;
	}

	@Override
	public void userAdd(String name, String pwd, String phone, String mail, String address) throws Exception {
		String sql = "insert into t_user (name,pwd,phone,mail,address) values (?,?,?,?,?)";
	    Object[] os= {name,pwd,phone,mail,address};
	    JDBCUtil.addDeleteUpdate(sql, os);
		
	}

	@Override
	public void userEditById(int id, String name, String pwd, String phone, String mail, String address)
			throws Exception {
		String sql = "update t_user set name=?,pwd=?,phone=?,mail=?,address=? where id=?";
		Object[] os = {name,pwd,phone,mail,address,id};
		JDBCUtil.addDeleteUpdate(sql, os);
		
	}

	@Override
	public void userDel(String id) throws Exception {
		String sql = "delete from t_user where id="+id;
		JDBCUtil.addDeleteUpdate(sql, null);
		
	}

	@Override
	public User login(String name, String pwd) throws Exception {
        System.out.println(name);	
        System.out.println(pwd);
		String sql = "select * from t_user where name=? and pwd=? ";
		Object[] os = {name,pwd};
		ResultSet rs = JDBCUtil.qeuryUtil(sql, os);
		if(rs.next()) {
			Integer id = rs.getInt("id");
			String phone = rs.getString("phone");
			String mail = rs.getString("mail");
			String address = rs.getString("address");
			String backup1 = rs.getString("backup1");
			System.out.println(id);
			User user = new User(id, name, pwd, phone, mail, address, backup1);
			
	      return user;
		}
		return null;
	}

	@Override
	public User getAllById(int id) throws Exception {
		String sql = "select *from t_user where id=?";
		Object[] os= {id};
		User user =null;
		ResultSet rs = JDBCUtil.qeuryUtil(sql, os);
		while(rs.next()) {
			String name = rs.getString("name");
			String pwd = rs.getString("pwd");
			String phone = rs.getString("phone");
			String mail = rs.getString("mail");
			String address = rs.getString("address");
			String backup1 = rs.getString("backup1");
			user = new User(id, name, pwd, phone, mail, address, backup1);
		}
		return user;
	}

}
