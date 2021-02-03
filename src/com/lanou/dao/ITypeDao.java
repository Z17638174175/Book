package com.lanou.dao;

import java.util.List;

import com.lanou.bean.Type;

public interface ITypeDao {

	public List<Type> getAll(int parentid) throws Exception;
	
	public void addType(String title,int parentid) throws Exception;
	
	public void editType(int id,String title) throws Exception;
	
	public void delType(int id) throws Exception;
	
	public Type getAllById(int id) throws Exception;
}
