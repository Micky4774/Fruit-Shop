package com.micky4774.pruebaTecnica;
import java.util.ArrayList;

public class Receipt {
	public ArrayList<Article> getBasket() {
		return basket;
	}
	public void setBasket(ArrayList<Article> basket) {
		this.basket = basket;
	}
	public ArrayList<Discount> getDiscounts() {
		return discounts;
	}
	public void setDiscounts(ArrayList<Discount> discounts) {
		this.discounts = discounts;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	private ArrayList<Article> basket;
	private ArrayList<Discount> discounts;
	private int totalPrice;
}
