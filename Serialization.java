package com.micky4774.pruebaTecnica;
import java.io.File;
import java.util.HashMap;

public interface Serialization {
	public void serialize(Receipt receipt);
	public Object deserialize(File input, HashMap<String, Product> productsCatalog);
	public HashMap<String, Product> deserializeProductsCatalog(File file);
}
