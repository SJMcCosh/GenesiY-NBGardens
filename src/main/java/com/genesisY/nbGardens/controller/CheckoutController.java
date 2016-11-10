package com.genesisY.nbGardens.controller;

import javax.enterprise.context.RequestScoped;
import javax.faces.model.DataModel;
import javax.inject.Inject;
import javax.inject.Named;


@Named("checkout")
@RequestScoped
public class CheckoutController {
	
	@Inject private AddressController addressController;

	
}
