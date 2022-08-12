package com.micky4774.pruebaTecnica;
import java.io.File;
import java.util.ArrayList;

public interface Serialization {
	public void serialize(Receipt receipt);
	public Object deserialize(File input);
	public ArrayList<Product> deserializeProductsCatalog(File file);
}
