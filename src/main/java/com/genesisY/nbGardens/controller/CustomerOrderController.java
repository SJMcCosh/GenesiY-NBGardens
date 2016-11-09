package com.genesisY.nbGardens.controller;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.genesisY.nbGardens.services.CustomerOrderService;
import com.genesisY.nbGardensCatalogue.entities.CustomerOrder;
import com.genesisY.nbGardensCatalogue.entities.Product;

@Named("customerorder")
@RequestScoped
public class CustomerOrderController {

	@Inject private CustomerOrderService customerOrderService;
	@Inject private CustomerController customerController;
	
	private DataModel<Product> prodDataModel;
	private CustomerOrder customerOrder;
	
	public String getProductList(){
		List<Product> prodList = new ArrayList<Product>();
		
		for(CustomerOrder c : customerOrderService.getCustomerOrders(customerController.getCustomer())){
			for(Product p : c.getProdList()){
				prodList.add(p);
			}
		}
		prodDataModel = new ListDataModel<Product>(prodList);
		
		return "previousorders";
	}

	public DataModel<Product> getProdDataModel() {
		return prodDataModel;
	}

	public void setProdDataModel(DataModel<Product> prodDataModel) {
		this.prodDataModel = prodDataModel;
	}
	
	
}
