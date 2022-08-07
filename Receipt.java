import java.util.ArrayList;

public class Receipt {
	private ArrayList<Product> products;
	public ArrayList<Product> getProducts() {
		return products;
	}
	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
	public ArrayList<Discount> getDiscounts() {
		return discounts;
	}
	public void setDiscounts(ArrayList<Discount> discounts) {
		this.discounts = discounts;
	}
	public int getInvoice() {
		return Invoice;
	}
	public void setInvoice(int invoice) {
		Invoice = invoice;
	}
	private ArrayList<Discount> discounts;
	private int Invoice;
	
}
