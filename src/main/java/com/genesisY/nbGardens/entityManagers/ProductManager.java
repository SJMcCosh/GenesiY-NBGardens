package com.genesisY.nbGardens.entityManagers;

import java.util.List;

import javax.ejb.Singleton;

import com.genesisY.nbGardens.entities.Product;

public interface ProductManager {

	public List<Product> getProducts();
	
	public Product getProduct(long id);
	
	public void updateProduct(Product product);
}
