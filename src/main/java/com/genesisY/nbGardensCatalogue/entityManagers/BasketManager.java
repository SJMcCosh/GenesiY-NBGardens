package com.genesisY.nbGardensCatalogue.entityManagers;

import java.util.List;

import com.genesisY.nbGardensCatalogue.entities.BasketItem;
import com.genesisY.nbGardensCatalogue.entities.Product;

public interface BasketManager {
	
	
	/**
	 * Gets all the products from the database
	 * @return List of the products
	 */
	public List<BasketItem> getBasketItems();
	
	public void addProductToCart(Product product);

}
