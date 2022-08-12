package com.micky4774.pruebaTecnica;

import java.util.ArrayList;

public interface Discounts {
	
//	public Receipt discountByArticle(Article article);
	public Receipt applyDiscounts(ArrayList<Product> products);
	
	public Article discount_3By2InApples(Article apple);
	public Article discount_1EuroDeductionBy4EurosInPears(Article pear);
	public Article discount_1FreeOrangeBy2Pears(Article orange, Article pear);
	
}
