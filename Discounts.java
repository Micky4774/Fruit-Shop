
public interface Discounts {
	Receipt productbyproduct(Discount discount, Receipt receipt, Purchase purchase);
	Receipt deductionbypurchase(Discount discount , int purchase, Receipt receipt);
}
