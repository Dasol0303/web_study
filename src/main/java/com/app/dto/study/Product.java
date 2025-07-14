package com.app.dto.study;

public class Product {
	public String id;
	public String name;
	public int price;
	
	
	public Product() {}
	
	public Product(String id, String name, int price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	/*
	  getter setter를 사용하는 이유!
	  
	  1. private -> getter public
	  2. gettsetter 어떤 로직!
	  xx.price = -50;
	  xx.setPrice(-50);
	  if(p < 0)
	  3. spring
	  
	  xx.id = sddd;
	  set(id)
	 */
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
	
	
}
