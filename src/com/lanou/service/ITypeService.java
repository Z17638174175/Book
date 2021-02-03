package com.lanou.service;

import java.util.List;

import com.lanou.bean.Type;

public interface ITypeService {

	public List<Type> getAll() throws Exception;
	
	public void addType(String title, int parentid) throws Exception ;
	
	public void editType(int id, String title) throws Exception;
	
	public void delType(int id) throws Exception;
}
