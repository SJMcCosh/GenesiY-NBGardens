package com.genesisY.nbGardensCatalogue.entityManagers;

import java.util.List;

import javax.ejb.Singleton;

import com.genesisY.nbGardensCatalogue.entities.Product;

@Singleton
public interface ProductManager {

	public List<Product> getProducts();
	
	public Product getProduct(long id);
	public List<Product> getProduct();
}
