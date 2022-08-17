package com.micky4774.pruebaTecnica;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Shopping{
	public final static String inputFolder = "C:\\Users\\migsa\\Documents\\MyWorkspace\\prueba-tecnica\\target\\inputFolder";
	public final static String outputFolder = "C:\\Users\\migsa\\Documents\\MyWorkspace\\prueba-tecnica\\target\\outputFolder";
	public final static String dataStoreFolder = "C:\\Users\\migsa\\Documents\\MyWorkspace\\prueba-tecnica\\target\\dataSourceFolder";
	

	public static void main(String[] args) {
		File inputDir = new File(inputFolder);
		File dataStore = new File(dataStoreFolder);
		final HashMap<String, Product> productsCatalog = processProductsCatalog(dataStore.listFiles());
		ArrayList<Receipt> receiptsList = new ArrayList<Receipt>();
		ArrayList<Purchase> pickingsList = processPurchaseFiles(inputDir.listFiles(), productsCatalog);
		Iterator<Purchase> itPickings = pickingsList.iterator();
		while(itPickings.hasNext()) {
			receiptsList.add((itPickings.next()).applyDiscounts(productsCatalog));
		} 
		processReceipts(receiptsList);
	}
	
	private static HashMap<String, Product> processProductsCatalog(File[] files) {
		// TODO Auto-generated method stub
		JsonFromToJava jsonFromToJava = new JsonFromToJava();
		HashMap<String, Product> productsCatalog = null;
        for (File file : files) {
            productsCatalog = jsonFromToJava.deserializeProductsCatalog(file);
        }
        return productsCatalog;
	}

	private static void processReceipts(ArrayList<Receipt> receiptsList) {
		// TODO Auto-generated method stub
		
		JsonFromToJava jsonFromToJava = new JsonFromToJava();
		Iterator<Receipt> itReceipts = receiptsList.iterator();
		while(itReceipts.hasNext()) {
			jsonFromToJava.serialize(itReceipts.next());
			
        } 
	}

	private static ArrayList<Purchase> processPurchaseFiles(File[] files, HashMap<String, Product> productsCatalog) {
		
		JsonFromToJava jsonFromToJava = new JsonFromToJava();
		ArrayList<Purchase> pickingsList = new ArrayList<Purchase>();
        for (File file : files) {
            pickingsList.add((Purchase) jsonFromToJava.deserialize(file, productsCatalog));
        }
        return pickingsList;
    }
	
	
}


