package com.genesisY.nbGardens.controller;



import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.genesisY.nbGardens.services.CheckoutService;



@Named("checkout")
@RequestScoped
public class CheckoutController {
	
	@Inject private BasketController basketController;
	@Inject private CheckoutService checkoutService;
	@Inject private CustomerController customerController;
	

	public String checkout(){
		checkoutService.checkout(basketController.getDataModel(), customerController.getCustomer().getUsername());
		basketController.setModelToNull();
		return "checkoutcomplete";
	}
	
}
