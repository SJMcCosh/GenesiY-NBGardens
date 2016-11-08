package com.genesisY.nbGardens.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.genesisY.nbGardens.services.BasketService;

@Named("addBasket")
@RequestScoped
public class AddToBasketController {
	
	@Inject private ProductsController productsController;
	@Inject private BasketService basketService;
	
	/**
	 * Sends the product that the user has clicked to the data store for the basket
	 */
	public String addToBasket(){
		
		System.out.println(">>>>>>>>>>>>>>>" + productsController.getProduct().getName());
		basketService.addProductToBasket(productsController.getProduct(), productsController.getQuantityOfItemsSelected());
		
		return "productpage";
	}
	
}
