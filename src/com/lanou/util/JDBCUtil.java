package com.lanou.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;;

public class JDBCUtil {
	private static Connection con;
    private static PreparedStatement ps = null;
	private static Statement st = null;
	private static ResultSet rs = null;
	static {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://10.10.12.63:3306/bookmanage?useUnicode=true&characterEncoding=utf-8";
		String user = "root";
		String password = "root";
		con = DriverManager.getConnection(url, user, password);
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	}
	public static ResultSet qeuryUtil(String sql,Object[] os) throws Exception {
		
		ps = con.prepareStatement(sql); 
		if(os!=null&&os.length>0) {
			for(int i=0;i<os.length;i++) {
				ps.setObject(i+1, os[i]);
			}
		}
		rs=ps.executeQuery();
		return rs;
		
	}
	public static void addDeleteUpdate(String sql,Object[] os) throws Exception {
		ps = con.prepareStatement(sql); 
		if(os!=null&&os.length>0) {
			for(int i=0;i<os.length;i++) {
				ps.setObject(i+1, os[i]);
			}
		}
		ps.execute();
		
	}
	public static void closeRes() throws Exception{
		if(con!=null){
			con.close();
		}
		
		if(ps!=null){
			ps.close();
		}
		
		if(st!=null){
			st.close();
		}
		
		if(rs!=null){
			rs.close();
		}
		
		
	}
}
