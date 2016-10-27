package com.genesisY.nbGardens.entityManagers;

import java.util.List;

import com.genesisY.nbGardens.entities.Product;

public interface ProductManager {

	public List<Product> getProducts();
	
	public Product getProduct(long id);

	public List<Product> getAllProducts();
	
	public void addProduct(Product product);
}
