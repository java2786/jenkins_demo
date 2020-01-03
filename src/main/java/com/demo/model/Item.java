package com.demo.model;

public class Item {

	private int id;
	private String name;
	private double price;
	private String desc;

	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Item(int id, String name, double price, String desc) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.desc = desc;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", price=" + price + ", desc=" + desc + "]";
	}

}
