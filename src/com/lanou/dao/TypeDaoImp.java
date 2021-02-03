package com.lanou.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lanou.bean.Type;

import com.lanou.util.JDBCUtil;

public class TypeDaoImp implements ITypeDao{

	@Override
	public List<Type> getAll(int parentid) throws Exception {
		String sql = "select * from pro_type where parentid="+parentid;

		List<Type> listtype = new ArrayList<>();
		ResultSet rs = JDBCUtil.qeuryUtil(sql, null);
		while(rs.next()) {
			Integer id = rs.getInt("id");
			String typename = rs.getString("typename");
			Type type = new Type(id, parentid, null, typename);
			listtype.add(type);
	   
		}
		return listtype;
		
	}

	@Override
	public void addType(String title, int parentid) throws Exception {
		String sql = "insert into pro_type (typename,parentid)values(?,?)";
		Object[] os = {title,parentid};
		JDBCUtil.addDeleteUpdate(sql, os);
	}

	@Override
	public void editType(int id, String title) throws Exception {
		
		String sql = "update pro_type set typename=? where id=?";
		Object[] os = {title,id};
		JDBCUtil.addDeleteUpdate(sql, os);
	}

	@Override
	public void delType(int id) throws Exception {
		String sql = "delete from pro_type where id=?";
		Object[] os = {id};
		JDBCUtil.addDeleteUpdate(sql, os);
		
	}

	@Override
	public Type getAllById(int id) throws Exception {
		String sql = "select * from pro_type where id=? ";
		Object[] os = {id};
		Type type =null;
		ResultSet rs = JDBCUtil.qeuryUtil(sql, os);
		while(rs.next()) {
			Integer parentid = rs.getInt("parentid");
			String typename = rs.getString("typename");
			 type = new Type(id, parentid, null, typename);
			
	   
		}
		return type;
	}
 
	
}
