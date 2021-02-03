package com.lanou.bean;

import java.io.Serializable;

public class Carousel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String Timg;

	
	
	public Carousel() {
		super();
	}

	public Carousel(Integer id, String timg) {
		super();
		this.id = id;
		Timg = timg;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTimg() {
		return Timg;
	}

	public void setTimg(String timg) {
		Timg = timg;
	}
	
	

}
