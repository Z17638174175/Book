package com.lanou.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;

import com.lanou.dao.IAdminDao;

public class SQLSessionUtil {

	public static SqlSession getOpSession() throws IOException {
		
	String resource = "Mybatis-config.xml";
	InputStream inputStream = Resources.getResourceAsStream(resource);
	SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
	 SqlSession openSession = sqlSessionFactory.openSession();
		
		
		return openSession;
		
	}
}
