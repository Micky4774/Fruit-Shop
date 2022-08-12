package com.micky4774.pruebaTecnica;

public class Discount {
	
	private String description;
	private String productName;
	private int reason;
	private int advantage;
	
	public Discount() {
		// TODO Auto-generated constructor stub
		this.description = "";
		this.productName = "";
		this.reason = 0;
		this.advantage = 0;
		
	}
	
	public int getReason() {
		return reason;
	}
	public void setReason(int reason) {
		this.reason = reason;
	}
	public int getAdvantage() {
		return advantage;
	}
	public void setAdvantage(int advantage) {
		this.advantage = advantage;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
}
