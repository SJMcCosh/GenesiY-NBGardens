package com.genesisY.nbGardens.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.faces.model.DataModel;
import javax.inject.Inject;

import com.genesisY.nbGardensCatalogue.entities.BasketItem;
import com.genesisY.nbGardensCatalogue.entities.Product;
import com.genesisY.nbGardensCatalogue.entityManagers.CustomerOrderManager;

@Stateless
public class CheckoutService {

	@Inject
	private CustomerOrderManager customerOrderManager;

	public void checkout(DataModel<BasketItem> prodModel, String customerID){
		List<Product> prodList = new ArrayList<Product>();
		for (BasketItem bi : prodModel){
			prodList.add(bi.getProduct());
		}
		
		double price = 0;
		for (BasketItem bi : prodModel){
			double itemPrice = bi.getQuantity() * bi.getProduct().getPrice();
			price += itemPrice;
		}
		customerOrderManager.addCustomerOrder(prodList, price, customerID);
	}


}
