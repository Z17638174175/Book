package com.lanou.bean;

import java.io.Serializable;

public class Cart implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private Integer userid;
	
	private String username;
	
	private String phone;
	
	private Integer productid;
	
	private String pname;
	
	private Integer productnum;

	public Cart() {
		super();
	}

	

	public Cart(Integer productid, java.lang.String pname, Integer productnum) {
		super();
		this.productid = productid;
		this.pname = pname;
		this.productnum = productnum;
	}



	public Cart(Integer id, Integer userid, String username, String phone, Integer productid, String pname) {
		super();
		this.id = id;
		this.userid = userid;
		this.username = username;
		this.phone = phone;
		this.productid = productid;
		this.pname = pname;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getProductid() {
		return productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPname() {
		return pname;
	}

	public void String(String pname) {
		this.pname = pname;
	}



	public Integer getProductnum() {
		return productnum;
	}



	public void setProductnum(Integer productnum) {
		this.productnum = productnum;
	}



	public void setPname(String pname) {
		this.pname = pname;
	}
	
	
}
