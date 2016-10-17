package com.genesisY.nbGardensCatalogue.entityManagers;

import java.util.ArrayList;
import java.util.List;

import com.genesisY.nbGardensCatalogue.entities.Customer;

public interface AccountManagerInterface {

	public void persistAccount(Customer customer);

	public void persistAccount(List<Customer> customerList);

	public ArrayList<Customer> customerList();

	public Customer findByUsername(String username);

}
