package com.lanou.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lanou.bean.Admin;

public interface IAdminDao {
    public Admin login(@Param("adminname")String adminname,@Param("adminpwd")String adminpwd) throws Exception;
    
    public int PageCount() throws Exception;
    
    public List<Admin> getByPage(@Param("pagenum")int pagenum,@Param("pagecount")int pagecount) throws Exception;
    
    public void adminAdd(@Param("adminname")String adminname,@Param("adminpwd") String pwd) throws Exception;
    
    public void adminDel(@Param("id")String id) throws Exception;
    
    public void adminEdit(@Param("id")String id,@Param("adminname")String adminname,@Param("adminpwd")String pwd) throws Exception;
    
}
