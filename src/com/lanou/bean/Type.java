package com.lanou.bean;

import java.io.Serializable;
import java.util.List;

public class Type implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String typename;
	
	private Integer parentid;
	
	private List<Type> children;

	private String title;
	
	public Type() {
		super();
	}

    

	public Type(Integer id, Integer parentid, List<Type> children, String title) {
		super();
		this.id = id;
		this.parentid = parentid;
		this.children = children;
		this.title = title;
	}



	public Type(Integer id, List<Type> children, String title) {
		super();
		this.id = id;
		this.children = children;
		this.title = title;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public Integer getParentid() {
		return parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public List<Type> getChildren() {
		return children;
	}

	public void setChildren(List<Type> children) {
		this.children = children;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
