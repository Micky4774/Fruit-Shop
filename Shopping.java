/**
 * 
 */
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;// in play 2.3
/**
 * @author migsa
 *
 */
public class Shopping implements Discounts{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		try {
			ObjectMapper mapper = new ObjectMapper();
			JsonFactory f = new JsonFactory();
		    
		    JsonParser jsonDataStore = f.createJsonParser(new File("C:\\inputFolder\\jsonDataStore.json"));
		    JsonParser jsonPurchase = f.createJsonParser(new File("C:\\inputFolder\\jsonPurchase.json"));
			List<Product> products = mapper.readValue(jsonDataStore, new ArrayList<Product>(){});
			List<Article> articles = mapper.readValue(jsonPurchase, new ArrayList<Article>(){});
			
			
			/* 
			 * 
			 * remaining source code after applying discounts
			 * and gettin Receipt with information which
			 * must be parsed to a json file
			 */
			
			
			
		} catch (JsonGenerationException e) {
		    e.printStackTrace();
		} catch (JsonMappingException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	
	@Override
	public Receipt productbyproduct(Discount discount, Receipt receipt, Purchase purchase) {
		
		// TODO Auto-generated method stub
		return receipt;
	}
	@Override
	public Receipt deductionbypurchase(Discount discount, int purchase, Receipt receipt) {
		// TODO Auto-generated method stub
		return receipt;
	}

}
