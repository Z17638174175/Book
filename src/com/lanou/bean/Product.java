package com.lanou.bean;

import java.io.Serializable;

public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String pname;
	
	private String pimg;
	
	private Double price;
	
	private String ptitle;
	
	private Integer pv;
	
	private String pnames;

	
	
	public Product() {
		super();
	}

	

	public Product(Integer id, String pname, String pimg, Double price, String ptitle, Integer pv, String pnames) {
		super();
		this.id = id;
		this.pname = pname;
		this.pimg = pimg;
		this.price = price;
		this.ptitle = ptitle;
		this.pv = pv;
		this.pnames = pnames;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPimg() {
		return pimg;
	}

	public void setPimg(String pimg) {
		this.pimg = pimg;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getPtitle() {
		return ptitle;
	}

	public void setPtitle(String ptitle) {
		this.ptitle = ptitle;
	}

	public Integer getPv() {
		return pv;
	}

	public void setPv(Integer pv) {
		this.pv = pv;
	}

	

	public String getPnames() {
		return pnames;
	}



	public void setPnames(String pnames) {
		this.pnames = pnames;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	
}
