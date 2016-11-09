package com.genesisY.nbGardensCatalogue.entityManagers.offline;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.genesisY.nbGardensCatalogue.entities.Customer;
import com.genesisY.nbGardensCatalogue.entities.CustomerOrder;
import com.genesisY.nbGardensCatalogue.entities.Product;
import com.genesisY.nbGardensCatalogue.entityManagers.CustomerOrderManager;
import com.genesisY.nbGardensCatalogue.initialData.InitialData;


@Stateless
public class CustomerOrderOffline implements CustomerOrderManager {

	@Inject private InitialData initialData;
	
	@Override
	public List<CustomerOrder> getCustomerOrders(Customer customer) {
		for (Customer c : initialData.getCustomerList()){
			if(c.getUsername().equals(customer.getUsername())){
				return c.getCustomerOrders();
			}
		}
		
		return null;
	}

	@Override
	public List<Product> getProductsFromOrder(Customer customer, CustomerOrder customerOrder) {
		
		for(CustomerOrder c : getCustomerOrders(customer)){
			return c.getProdList();
		}
		
		return null;
	}

}
