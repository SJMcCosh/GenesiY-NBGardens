package com.genesisY.nbGardensCatalogue.entityManagers;

import java.util.List;

import com.genesisY.nbGardensCatalogue.entities.Customer;
import com.genesisY.nbGardensCatalogue.entities.CustomerOrder;
import com.genesisY.nbGardensCatalogue.entities.Product;

public interface CustomerOrderManager {
	
	public List<CustomerOrder> getCustomerOrders(Customer customer);
	
	public List<Product> getProductsFromOrder(Customer customer, CustomerOrder customerOrder);
	

}
