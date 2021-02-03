package com.lanou.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;

import com.lanou.bean.Admin;

public class Test {

	public static void main(String[] args) throws Exception {
		SqlSessionFactory sqlSessionFactory=null;
		SqlSession openSession=null;
		IAdminDao  iAdminDao =null;
		
		String resource = "Mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		 sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		 openSession = sqlSessionFactory.openSession();
		 iAdminDao =  openSession.getMapper(IAdminDao.class);
		 Admin admin = iAdminDao.login("admin", "123");
		 System.out.println(admin.getAdminname());
	}
}
