package com.lanou.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lanou.bean.Admin;
import com.lanou.bean.User;

public interface IUserDao {

	public List<User> getAllByPage(@Param("pagenum")int pagenum,@Param("pagecount") int pagecount) throws Exception;
	
	public int getPageCount() throws Exception;
	
	public void userAdd(@Param("name")String name,@Param("pwd") String pwd,@Param("phone")String phone,@Param("mail")String mail,@Param("address")String address) throws Exception ;
	
	public void userEditById(@Param("id")int id,@Param("name")String name, @Param("pwd")String pwd,@Param("phone")String phone,@Param("mail")String mail,@Param("address")String address) throws Exception ;
	
	public void userDel(@Param("id")String id) throws Exception;
	
	public User getAllById(@Param("id")int id) throws Exception ;
	
	public User login(@Param("name")String name,@Param("pwd")String pwd) throws Exception ;
	
	
}
