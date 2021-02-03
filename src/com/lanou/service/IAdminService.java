package com.lanou.service;

import java.util.List;

import com.lanou.bean.Admin;


public interface IAdminService {
	 public Admin login(String adminname,String adminpwd) throws Exception;
	 
	 public int PageCount() throws Exception;
	 
	 public List<Admin> getByPage(int pagenum,int pagecount) throws Exception;
	 
	 public void adminAdd(String adminname, String pwd) throws Exception;
	 
	 public void adminDel(String id) throws Exception;
	 
	 public void adminEdit(String id,String adminname,String pwd) throws Exception;
}
