package com.micky4774.pruebaTecnica;

import java.util.HashMap;

public interface Discounts {
	
//	public Receipt discountByArticle(Article article);
	public Article applyDiscounts(Article article, HashMap<String, Article> basket, Product product);
	
	public Article discount_3By2InApples(Article article, Product apple);
	public Article discount_1EuroDeductionBy4EurosInPears(Article article, Product pear);
	public Article discount_1FreeOrangeBy2Pears(Article article, Product orange, Article pear);
	
}
