package com.lanou.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;

import com.lanou.bean.Admin;
import com.lanou.dao.AdminDaoImp;
import com.lanou.dao.IAdminDao;
import com.lanou.util.SQLSessionUtil;


public class AdminServiceImp implements IAdminService{
	
	
		 
		
	
	@Override
	public Admin login(String adminname, String adminpwd) throws Exception {
		SqlSession openSession = SQLSessionUtil.getOpSession();
		IAdminDao iAdminDao =  openSession.getMapper(IAdminDao.class);
		Admin admin = iAdminDao.login("adminname","adminpwd");
		return admin;
	}
	@Override
	public int PageCount() throws Exception {
		SqlSession openSession = SQLSessionUtil.getOpSession();
		IAdminDao iAdminDao =  openSession.getMapper(IAdminDao.class);
		return iAdminDao.PageCount();
	}
	@Override
	public List<Admin> getByPage(int pagenum, int pagecount) throws Exception {
		
		SqlSession openSession = SQLSessionUtil.getOpSession();
		IAdminDao iAdminDao =  openSession.getMapper(IAdminDao.class);
		return iAdminDao.getByPage(pagenum, pagecount);
	}
	@Override
	public void adminAdd(String adminname, String pwd) throws Exception {
		SqlSession openSession = SQLSessionUtil.getOpSession();
		IAdminDao iAdminDao =  openSession.getMapper(IAdminDao.class);
		iAdminDao.adminAdd(adminname, pwd);
	}
	@Override
	public void adminDel(String id) throws Exception {
		SqlSession openSession = SQLSessionUtil.getOpSession();
		IAdminDao iAdminDao =  openSession.getMapper(IAdminDao.class);
		iAdminDao.adminDel(id);
		
	}
	@Override
	public void adminEdit(String id, String adminname, String pwd) throws Exception {
		// TODO Auto-generated method stub
		SqlSession openSession = SQLSessionUtil.getOpSession();
		IAdminDao iAdminDao =  openSession.getMapper(IAdminDao.class);
		iAdminDao.adminEdit(id, adminname, pwd);
	}
	
	
}
