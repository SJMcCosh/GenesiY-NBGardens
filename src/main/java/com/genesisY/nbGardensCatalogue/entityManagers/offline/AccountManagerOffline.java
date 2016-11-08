package com.genesisY.nbGardensCatalogue.entityManagers.offline;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.genesisY.nbGardensCatalogue.entities.Customer;
import com.genesisY.nbGardensCatalogue.entityManagers.AccountManager;
import com.genesisY.nbGardensCatalogue.initialData.InitialData;

@Stateless
@Default
public class AccountManagerOffline implements AccountManager{
	
	@Inject
	private InitialData initialData;

	@Override
	public void persistAccount(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void persistAccount(List<Customer> customerList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Customer> customerList() {
		// TODO Auto-generated method stub
		return initialData.getCustomerList();
	}

	@Override
	public Customer findByUsername(String username) {
		for (Customer c : initialData.getCustomerList()){
			if (c.getUsername().equals(username)){
				return c;
			}
		}
		
		return null;
	}

	@Override
	public void updatePassword(String password, String username) {
		Customer c = findByUsername(username);
		c.setPassword(password);
		
	}

	@Override
	public void updateCustomerDetails(Customer customer) {
		for(Customer c : initialData.getCustomerList()){
			if(c.getUsername().equals(customer.getUsername())){
				c.setFirstName(customer.getFirstName());
				c.setSurname(customer.getSurname());
				c.setEmail(customer.getEmail());
				c.setPhoneNumber(customer.getPhoneNumber());
			}
		}
		
	}
	
}
