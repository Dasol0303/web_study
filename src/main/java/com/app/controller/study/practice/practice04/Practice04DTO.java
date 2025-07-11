package com.app.controller.study.practice.practice04;

public class Practice04DTO {

	String category;
	String product;
	
	String value001;
	String value099;
	
	String response001;
	String response099;
	
	
	public String getResponse001() {
		return response001;
	}
	public void setResponse001(String response001) {
		this.response001 = response001;
	}
	public String getResponse099() {
		return response099;
	}
	public void setResponse099(String response099) {
		this.response099 = response099;
	}
	
	
	public String getValue001() {
		return value001;
	}
	public void setValue001(String value001) {
		this.value001 = value001;
	}
	public String getValue099() {
		return value099;
	}
	public void setValue099(String value099) {
		this.value099 = value099;
	}
	
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	
	@Override
	public String toString() {
		return "Practice04DTO [category=" + category + ", product=" + product + "]";
	}
	


	
}
