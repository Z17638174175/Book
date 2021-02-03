package com.lanou.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;

import com.lanou.dao.IAdminDao;

public class MapperUtil {

	public static Object getMapper(Class<?> t)  {
		Object o =null;
		try {
			String resource = "Mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession openSession = sqlSessionFactory.openSession(true);
				o = openSession.getMapper(t.getClass());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
			return o;
				
			
	}
}
