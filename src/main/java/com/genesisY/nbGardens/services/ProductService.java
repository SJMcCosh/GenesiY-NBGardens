package com.genesisY.nbGardens.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.faces.model.DataModel;
import javax.inject.Inject;

import com.genesisY.nbGardensCatalogue.entities.Product;
import com.genesisY.nbGardensCatalogue.entityManagers.ProductManager;

@Stateless

public class ProductService {

	@Inject
	private ProductManager productManager;

	/**
	 * Gets the products that a customer wants based on the category they chose
	 * @param category that the customer wants
	 * @return List<Product> : the list of products that have been returned from the data store
	 */
	@SuppressWarnings("unchecked")
	public List<Product> getAllProducts(String category) {
		try {
			if (category != null) {
				return productManager.getProducts();
			}else{
				return null;
			}
		} catch (NullPointerException npe) {
			return null;
		}
		
	}
	
	/**
	 * Gets a product based on the name that has been sent in
	 * @param name : String of the product
	 * @return Product : the product that has been returned
	 */
	public Product getProductByName(String name){
		return productManager.getProductByName(name);
	}

}
