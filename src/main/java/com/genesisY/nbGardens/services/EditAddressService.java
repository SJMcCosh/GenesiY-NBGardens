package com.genesisY.nbGardens.services;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.genesisY.nbGardensCatalogue.entities.Address;
import com.genesisY.nbGardensCatalogue.entityManagers.AddressManager;

@Stateless
public class EditAddressService {

	@Inject private AddressManager addressManager;
	
	public void editDetails(Address address){
		addressManager.editAddress(address);
	}
	
	public void deleteAddress(Address address){
		addressManager.deleteAddress(address);
	}
}
