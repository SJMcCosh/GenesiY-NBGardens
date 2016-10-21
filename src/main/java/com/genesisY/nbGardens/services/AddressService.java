package com.genesisY.nbGardens.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.genesisY.nbGardensCatalogue.entities.Address;
import com.genesisY.nbGardensCatalogue.entityManagers.AddressManager;

@Stateless
public class AddressService {

	@Inject
	private AddressManager addressManager;
	
	public List<Address> getAllAddresses(String username){
		List<Address> addresses = addressManager.getAddressByUsername(username);
		for (Address a: addresses){
			if (a.getAddressLine1().equals("1 Street") && a.getTownCity().equals("TownCity") && a.getPostcode().equals("A1 1AA")){
				addresses.remove(a);
			}
		}
		return addresses;
	}
}
