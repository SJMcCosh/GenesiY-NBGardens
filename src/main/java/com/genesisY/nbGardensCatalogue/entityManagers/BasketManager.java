package com.genesisY.nbGardensCatalogue.entityManagers;

import java.util.List;

import com.genesisY.nbGardensCatalogue.entities.BasketItem;

public interface BasketManager {
	
	
	/**
	 * Gets all the products from the database
	 * @return List of the products
	 */
	public List<BasketItem> getBasketItems();

}
