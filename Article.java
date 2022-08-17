package com.micky4774.pruebaTecnica;

public class Article {
	
	
	public Article() {
		// TODO Auto-generated constructor stub
		this.description = "";
		this.quantity = 0;
		this.discountFlag = false;
		this.subtotal = 0;
		this.product = new Product();
	}
	
	public Article(Product product) {
		this.product = product;
	}
	
	private Product product = new Product();
	private String description = "";
	private int quantity = 0;
	private boolean discountFlag = false;
	private int subtotal = 0;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public boolean isDiscountFlag() {
		return discountFlag;
	}
	
	public int getSubtotal() {
		return subtotal;
	}
	public void setDiscountFlag(boolean discountFlag) {
		this.discountFlag = discountFlag;
	}
	
	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	
	

	
}
