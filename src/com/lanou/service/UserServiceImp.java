package com.lanou.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.lanou.bean.User;
import com.lanou.dao.IUserDao;
import com.lanou.util.SQLSessionUtil;

public class UserServiceImp implements IUserService{

	@Override
	public List<User> getAllByPage(int pagenum, int pagecount) throws Exception {
		SqlSession openSession = SQLSessionUtil.getOpSession();
		IUserDao userDao = openSession.getMapper(IUserDao.class);
		return userDao.getAllByPage(pagenum, pagecount);
	}
	@Override
	public int getPageCount() throws Exception {
		SqlSession openSession = SQLSessionUtil.getOpSession();
		IUserDao userDao = openSession.getMapper(IUserDao.class);
		return userDao.getPageCount();
	}
	@Override
	public void userAdd(String name, String pwd, String phone, String mail, String address) throws Exception {
		SqlSession openSession = SQLSessionUtil.getOpSession();
		IUserDao userDao = openSession.getMapper(IUserDao.class);
		userDao.userAdd(name, pwd, phone, mail, address);
		openSession.commit();
	}
	@Override
	public void userEditById(int id, String name, String pwd, String phone, String mail, String address)
			throws Exception {
		SqlSession openSession = SQLSessionUtil.getOpSession();
		IUserDao userDao = openSession.getMapper(IUserDao.class);
		userDao.userEditById(id, name, pwd, phone, mail, address);
		openSession.commit();
		
	}
	@Override
	public void userDel(String id) throws Exception {
		// TODO Auto-generated method stub
		SqlSession openSession = SQLSessionUtil.getOpSession();
		IUserDao userDao = openSession.getMapper(IUserDao.class);
		userDao.userDel(id);
		openSession.commit();
	}
	@Override
	public User login(String name, String pwd) throws Exception {
		// TODO Auto-generated method stub
		SqlSession openSession = SQLSessionUtil.getOpSession();
		IUserDao userDao = openSession.getMapper(IUserDao.class);
		return userDao.login(name, pwd);
	}
	@Override
	public User getAllById(int id) throws Exception {
		// TODO Auto-generated method stub
		SqlSession openSession = SQLSessionUtil.getOpSession();
		IUserDao userDao = openSession.getMapper(IUserDao.class);
		return userDao.getAllById(id);
	}

}
