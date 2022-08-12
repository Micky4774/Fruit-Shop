package com.micky4774.pruebaTecnica;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

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

	public Receipt applyDiscounts(ArrayList<Product> productsCatalog) {
		
		HashMap<String, Article> basket = this.basketMap;
				
//		3By2InApples: flag=(apples/3)!=0
		basket.put("Apple", discount_3By2InApples(basket.get("Apple")));
				
		
//		1EuroDeductionBy4EurosInPears: flag=((pears*75)/400)!=0
		basket.put("Pear", discount_1EuroDeductionBy4EurosInPears(basket.get("Pear")));
		
		
//		1FreeOrangeBy2Pears: flag=(pears/2)!=0
		basket.put("Orange", discount_1FreeOrangeBy2Pears(basket.get("Orange"),basket.get("Pear")));
				
		ArrayList<Article> list = this.getBasketList();
		list.get(1).setQuantity(basket.get("Orange").getQuantity());
		int total_price = basket.get("Apple").getSubtotal() + basket.get("Pear").getSubtotal() + basket.get("Orange").getSubtotal();
		Receipt receipt = new Receipt();
		receipt.setBasket(list);
		receipt.setTotalPrice(total_price);
		ArrayList<Discount> discounts = new ArrayList<Discount>();
		Iterator<Product> it = productsCatalog.iterator();
		while(it.hasNext()) {
			Product product = it.next();
			if (basket.get(product.getDescription()).isDiscountFlag()) {
				discounts.add(product.getDiscount());
			}
		}
		receipt.setDiscounts(discounts);
		return receipt;
		
	}

	@Override
	public Article discount_3By2InApples(Article article) {
		// TODO Auto-generated method stub
		int apples = article.getQuantity();
		int apples_price = (int) (apples/3)*2*90;
		article.setSubtotal(apples_price);
		article.setDiscountFlag((apples/3)!=0);
		article.setDiscountDescription("3By2InApples");
		return article;
	}

	@Override
	public Article discount_1EuroDeductionBy4EurosInPears(Article article) {
		// TODO Auto-generated method stub
		int pears = article.getQuantity();
		int pears_price = (pears*75);
		pears_price -= (int) ((pears*75)/400)*100;
		article.setDiscountFlag(((pears*75)/400)!=0);
		article.setSubtotal(pears_price);
		article.setDiscountDescription("1EuroDeductionBy4EurosInPears");
		return article;
	}

	public Article discount_1FreeOrangeBy2Pears(Article orange, Article pear) {
		// TODO Auto-generated method stub
		int initial_oranges = orange.getQuantity();
		int final_oranges = initial_oranges + (pear.getQuantity()/2);
		int oranges_price = initial_oranges * 100;
		orange.setQuantity(final_oranges);
		orange.setSubtotal(oranges_price);
		orange.setDiscountDescription("1FreeOrangeBy2Pears");
		orange.setDiscountFlag((pear.getQuantity()/2)!=0);
		return orange;
	}

	
}
