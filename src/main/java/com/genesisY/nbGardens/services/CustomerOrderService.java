package com.genesisY.nbGardens.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.genesisY.nbGardensCatalogue.entities.Customer;
import com.genesisY.nbGardensCatalogue.entities.CustomerOrder;
import com.genesisY.nbGardensCatalogue.entityManagers.CustomerOrderManager;

@Stateless
public class CustomerOrderService {

	
	@Inject private CustomerOrderManager customerOrderManager;
	
	public List<CustomerOrder> getCustomerOrders(Customer customer){
		return customerOrderManager.getCustomerOrders(customer);
	}
}
