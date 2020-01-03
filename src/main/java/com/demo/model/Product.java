package com.demo.model;

import java.util.Date;

public class Product {

	private int id;
	private String name;
	private Date mfd;
	
	public Product() {}
	
	public Product(int id, String name, Date mfd) {
		super();
		this.id = id;
		this.name = name;
		this.mfd = mfd;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", mfd=" + mfd + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getMfd() {
		return mfd;
	}
	public void setMfd(Date mfd) {
		this.mfd = mfd;
	}
	
	
}
