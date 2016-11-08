package com.genesisY.nbGardens.services;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.genesisY.nbGardensCatalogue.entities.Address;
import com.genesisY.nbGardensCatalogue.entities.Customer;
import com.genesisY.nbGardensCatalogue.entityManagers.AddressManager;

@Stateless
public class AddressService {

	@Inject
	private AddressManager addressManager;

	private boolean userValidate(String username) {
		boolean validate = false;
		Pattern pattern = Pattern.compile("^[0-9a-zA-Z_]+$");
		Matcher matcher = pattern.matcher(username);
		if (username.length() > 7 && username.length() < 45) {
			if (!matcher.find()) {
				return validate;
			}
		}
		validate = true;
		return validate;
	}

	public List<Address> getAllAddresses(String username) {
		if (userValidate(username)) {
			List<Address> addresses = addressManager.getAddressByUsername(username);
			for (Address a : addresses) {
				if (a.getAddressLine1().equals("1 Street") && a.getTownCity().equals("TownCity")
						&& a.getPostcode().equals("A1 1AA")) {
					addresses.remove(a);
				}
			}
			return addresses;
		} else {
			return null;
		}
		
		
			
			
			
		}
	
	public void addAddress(String addressLine1, String addressLine2, String addressLine3, String townCity, String county, String postcode, boolean billingAddress, Customer customer){
	
		Address a = new Address(addressLine1, addressLine2, addressLine3, townCity, county, postcode, billingAddress, customer); 
		
		if( a != null){
		
		addressManager.addAddress(a);
		}
	}
	}
	
	
	
	

