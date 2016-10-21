package com.genesisY.nbGardens.services;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.genesisY.nbGardensCatalogue.entities.Address;
import com.genesisY.nbGardensCatalogue.entityManagers.AddressManager;

@RequestScoped
public class AddressService {

	@Inject
	private AddressManager addressManager;
	
	public List<Address> getAllAddresses(String username){
		List<Address> addresses = addressManager.getAddressByUsername(username);
		return addresses;
	}
}
