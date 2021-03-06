/**
 * Class that is a repository for the Address Entities
 * @author Samuel McCosh
 */
package com.genesisY.nbGardensCatalogue.entityManagers;

import java.util.List;

import com.genesisY.nbGardensCatalogue.entities.Address;



public interface AddressManager {
	
	public void addAddress(Address a);
	
	public List<Address> getAddresses();

	public void editAddress(Address a);
	
	public void deleteAddress(Address a);
	
	public List<Address> getAddressByUsername(String username);
}
