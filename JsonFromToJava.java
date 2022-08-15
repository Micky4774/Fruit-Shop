package com.micky4774.pruebaTecnica;
import static java.lang.System.out;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JsonFromToJava implements Serialization{
	
	private Receipt receipt;
	private File input;
	private File output;
	
	
	public JsonFromToJava(File input){
		this.setInput(input);
		
	}
	
	public JsonFromToJava() {
		// TODO Auto-generated constructor stub
	}

	public void serialize(Receipt receipt) {
		try {
			
			ArrayList<Article> basket = receipt.getBasket();
			ArrayList<Discount> discounts = receipt.getDiscounts();
			int totalPrice = receipt.getTotalPrice();
			
			ObjectMapper mapper = new ObjectMapper();
			JsonNode rootNode = mapper.createObjectNode();
			ObjectNode objectNode = (ObjectNode) rootNode;
			
			objectNode.put("Total Price", (int) totalPrice);
			
			ArrayNode arrayArticles = mapper.createArrayNode();
			ArrayNode arrayDiscounts = mapper.createArrayNode();
			Iterator<Article> itArticles = basket.iterator();
			Iterator<Discount> itDiscounts = discounts.iterator();
			
			while(itArticles.hasNext()) {
				ObjectNode articleNode = mapper.createObjectNode();
				Article article = itArticles.next();
				articleNode.put("description", (String) article.getDescription());
				articleNode.put("quantity", (int) article.getQuantity());
				arrayArticles.add(articleNode);
			}
			objectNode.set("Articles Purchase", arrayArticles);
			
			while(itDiscounts.hasNext()) {			
				ObjectNode discountNode = mapper.createObjectNode();
				Discount discount = itDiscounts.next();
				discountNode.put("description", (String) discount.getDescription());
				arrayDiscounts.add(discountNode);
			}
			objectNode.set("Discounts Purchase", arrayDiscounts);
			Double randomDouble = new Double(Math.random());
			String randomString = randomDouble.toString();
			JsonFactory factory = new JsonFactory();
			JsonGenerator generator = factory.createGenerator(new File(Shopping.outputFolder + "\\jsonReceipt"+randomString+".json"),JsonEncoding.UTF8);
			generator.useDefaultPrettyPrinter();
			mapper.writeTree(generator, rootNode);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public Purchase deserialize(File input) {
		
		HashMap<String,Article> articlesMap = new HashMap<String,Article>();
		ArrayList<Article> articlesList = new ArrayList<Article>();
		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode rootNode = mapper.readTree(input);
			JsonNode arrayArticles = rootNode.get("Articles Purchase");

			for (int i = 0; i < arrayArticles.size(); i++){ 
				Article article = new Article();
				
				JsonNode articleNode = arrayArticles.get(i);
				article.setDescription(articleNode.get("description").textValue());
				article.setQuantity(articleNode.get("quantity").intValue());
				articlesMap.put(articleNode.get("description").textValue(), article);
				articlesList.add(article);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Purchase purchase = new Purchase();
		purchase.setBasketMap(articlesMap);
		purchase.setBasketList(articlesList);
		return purchase;
	}

	public Object getReceipt() {
		return receipt;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}

	public File getInput() {
		return input;
	}

	public void setInput(File input) {
		this.input = input;
	}

	public File getOutput() {
		return output;
	}

	public void setOutput(File output) {
		this.output = output;
	}

	public ArrayList<Product> deserializeProductsCatalog(File file) {
		// TODO Auto-generated method stub
		ArrayList<Product> products = new ArrayList<Product>();
		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode rootNode = mapper.readTree(file);
			JsonNode arrayProducts = rootNode.get("Products Catalog");

			for (int i = 0; i < arrayProducts.size(); i++){ 
				Product product = new Product();
				Discount discount = new Discount();
				
				JsonNode productNode = arrayProducts.get(i);
				product.setDescription(productNode.get("description").textValue());
				product.setPrice(productNode.get("price").intValue());
				JsonNode discountNode = productNode.get("discount");
				discount.setDescription(discountNode.get("description").textValue());
				discount.setReason(discountNode.get("reason").intValue());
				discount.setAdvantage(discountNode.get("advantage").intValue());
				product.setDiscount(discount);
				products.add(product);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}
}
