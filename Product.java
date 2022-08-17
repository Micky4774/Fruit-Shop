package com.micky4774.pruebaTecnica;

public class Product {
	
	
	public Product() {
		// TODO Auto-generated constructor stub
		this.description = null;
		this.price = 0;
		this.setDiscount(new Discount());
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Discount getDiscount() {
		return discount;
	}
	public void setDiscount(Discount discount) {
		this.discount = discount;
	}
	private String description;
	private int price;
	private Discount discount;
	

}
