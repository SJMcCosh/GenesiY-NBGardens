package com.genesisY.nbGardensCatalogue.entityManagers;

import java.util.ArrayList;
import java.util.List;

import com.genesisY.nbGardensCatalogue.entities.Customer;

public interface AccountManager {

	public void persistAccount(Customer customer);

	public void persistAccount(List<Customer> customerList);

	public ArrayList<Customer> customerList();

	public Customer findByUsername(String username);

	public void updateFirstName(String fname, String username);
	
	public void updateLastName(String lname, String username);
	
	public void updateEmail(String email, String username);
	
	public void updatePassword(String password, String username);
	
	public void updatePhoneNum(String phonenum, String username);
}
