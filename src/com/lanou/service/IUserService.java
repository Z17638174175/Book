package com.lanou.service;

import java.util.List;

import com.lanou.bean.User;

public interface IUserService {

	public List<User> getAllByPage(int pagenum, int pagecount) throws Exception;
	
	public int getPageCount() throws Exception;
	
	public void userAdd(String name, String pwd,String phone,String mail,String address) throws Exception ;
	
	public void userEditById(int id, String name, String pwd, String phone, String mail, String address)
			throws Exception;
	
	public void userDel(String id) throws Exception;
	
	public User getAllById(int id) throws Exception ;
	
	public User login(String name, String pwd) throws Exception;
}
