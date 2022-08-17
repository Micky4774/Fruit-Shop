package com.micky4774.pruebaTecnica;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Purchase implements Discounts{
	
	private HashMap<String, Article> basketMap;
	private ArrayList<Article> basketList;
	
	
 	
	
	public HashMap<String, Article> getBasketMap() {
		return basketMap;
	}

	public void setBasketMap(HashMap<String, Article> basketMap) {
		this.basketMap = basketMap;
	}

	public ArrayList<Article> getBasketList() {
		return basketList;
	}

	public void setBasketList(ArrayList<Article> basketList) {
		this.basketList = basketList;
	}

	public Receipt applyDiscounts(HashMap<String, Product> productsCatalog) {
		
		/*HashMap<String, Article> basket = this.basketMap;
		Set<Map.Entry<String, Product>> entries = productsCatalog.entrySet();
		for(Map.Entry<String, Product> thisPair : entries) {
			basket.put(thisPair.getKey(), basket.get(thisPair.getKey()).applyDiscounts(thisPair.getKey())        thisPair.getValue().applyDiscounts(basket.get(thisPair.getKey())));
		}*/
		HashMap<String, Article> basket = this.basketMap;
		Set<Map.Entry<String, Article>> entries = basket.entrySet();
		String description;
		Article article;
		for(Map.Entry<String, Article> thisPair : entries) {
			description = thisPair.getKey();
			article = basket.get(thisPair.getKey());
			basket.put(description, applyDiscounts(article, basket, productsCatalog.get(description)));        
		}
		Set<Map.Entry<String, Article>> basketEntries = basket.entrySet();
		int total_price=0;
		ArrayList<Discount> discounts = new ArrayList<Discount>();
		for(Map.Entry<String, Article> thisPair : basketEntries) {
			total_price += thisPair.getValue().getSubtotal();
			if (thisPair.getValue().isDiscountFlag()) {
				discounts.add(productsCatalog.get(thisPair.getKey()).getDiscount());
			}
		}
		ArrayList<Article> list = this.getBasketList();
		Receipt receipt = new Receipt();
		receipt.setBasket(list);
		receipt.setTotalPrice(total_price);
		receipt.setDiscounts(discounts);
		
		return receipt;
		
		
		
		
	}
	
	public Article applyDiscounts(Article article, HashMap<String, Article> basket, Product product) {
		// TODO Auto-generated method stub
			Article outputArticle = new Article();
			switch (article.getDescription()) {
				case "Apple":
					outputArticle = discount_3By2InApples(article, product);
					break;
				case "Pear":
					outputArticle = discount_1EuroDeductionBy4EurosInPears(article, product);
					break;
				case "Orange":
					outputArticle = discount_1FreeOrangeBy2Pears(article, product, basket.get("Pear"));
					break;
				default:
					
			}
			return outputArticle;
			
		
	}

	public Article discount_3By2InApples(Article article, Product apple) {
		// TODO Auto-generated method stub
		int apples = article.getQuantity();
		int apples_price = (apples/apple.getDiscount().getAdvantage())*apple.getDiscount().getReason()*apple.getPrice() + (apples%3)*apple.getPrice();
		article.setSubtotal(apples_price);
		article.setDiscountFlag((apples/apple.getDiscount().getAdvantage())!=0);
		article.setProduct(apple);
		article.getProduct().getDiscount().setDescription("3By2InApples");
		return article;
	}

	public Article discount_1EuroDeductionBy4EurosInPears(Article article, Product pear) {
		// TODO Auto-generated method stub
		int pears = article.getQuantity();
		int pears_price = (pears*pear.getPrice());
		pears_price -= (int) ((pears*pear.getPrice())/pear.getDiscount().getReason())*pear.getDiscount().getAdvantage();
		article.setDiscountFlag(((pears*pear.getPrice())/pear.getDiscount().getReason())!=0);
		article.setSubtotal(pears_price);
		article.setProduct(pear);
		article.getProduct().getDiscount().setDescription("1EuroDeductionBy4EurosInPears");
		return article;
	}

	public Article discount_1FreeOrangeBy2Pears(Article article, Product orange, Article pear) {
		// TODO Auto-generated method stub
		int initial_oranges = article.getQuantity();
		int final_oranges = initial_oranges + (pear.getQuantity()/orange.getDiscount().getReason());
		int oranges_price = initial_oranges * orange.getPrice();
		article.setQuantity(final_oranges);
		article.setSubtotal(oranges_price);
		article.setDiscountFlag((pear.getQuantity()/orange.getDiscount().getReason())!=0);
		article.setProduct(orange);
		article.getProduct().getDiscount().setDescription("1FreeOrangeBy2Pears");
		return article;
	}
	

	
}
