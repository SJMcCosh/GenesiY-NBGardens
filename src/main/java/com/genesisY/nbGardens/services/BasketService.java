package com.genesisY.nbGardens.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.genesisY.nbGardensCatalogue.entities.BasketItem;
import com.genesisY.nbGardensCatalogue.entities.Product;
import com.genesisY.nbGardensCatalogue.entityManagers.BasketManager;

@Stateless
public class BasketService{
	
	@Inject
	private BasketManager basketManager;
	
	@SuppressWarnings("unchecked")
	public List<BasketItem> getBasketItems() {		
		try {
			System.out.println("At service");
			return basketManager.getBasketItems();
			/*if (basketManager.getProducts().size() != 0) {
				
				System.out.println("Service Row Count: " + basketManager.getProducts().size());
				//return basketManager.getProducts();
			}else{
				System.out.println();
				return null;
			}*/
		} catch (NullPointerException npe) {
			System.out.println("Exception: " + npe.getStackTrace());
			return null;
		}
		
	}

	public void addProductToBasket(Product product){
		basketManager.addProductToCart(product);
	}
	
	
	
	

}
