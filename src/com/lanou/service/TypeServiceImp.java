package com.lanou.service;

import java.util.List;

import com.lanou.bean.Type;
import com.lanou.dao.ITypeDao;
import com.lanou.dao.TypeDaoImp;

public class TypeServiceImp implements ITypeService{

	private ITypeDao typedao = new TypeDaoImp();
	@Override
	public List<Type> getAll() throws Exception {
		List<Type> listtype = typedao.getAll(0);//1¼¶
		for(Type t :listtype) {
			Integer pid = t.getId();
			List<Type> listtype2 =typedao.getAll(pid);//2¼¶
			t.setChildren(listtype2);
			
			for(Type t2 :listtype2) {	
				List<Type> listtype3 =typedao.getAll(t2.getId());
				t2.setChildren(listtype3);
			}
		}
		return listtype;
	}
	@Override
	public void addType(String title, int parentid) throws Exception {


		typedao.addType(title, parentid);
		
	}
	@Override
	public void editType(int id, String title) throws Exception {
		
		typedao.editType(id, title);
		
	}
	@Override
	public void delType(int id) throws Exception {


		typedao.delType(id);
		
	}

}
