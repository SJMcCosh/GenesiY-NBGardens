package com.genesisY.nbGardensCatalogue.entityManagers;

import java.util.List;

import javax.ejb.Singleton;

import com.genesisY.nbGardensCatalogue.entities.Product;


public interface ProductManager {

	/**
	 * Gets all the products from the database
	 * @return List of the products
	 */
	public List<Product> getProducts();
	
	/**
	 * gets a product from the database
	 * @param id of the product
	 * @return the product with the id
	 */
	public Product getProductByName(String name);
	
	public List<Product> getProductsByCategory(String category);
}
