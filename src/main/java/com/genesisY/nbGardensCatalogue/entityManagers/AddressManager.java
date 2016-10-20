/**
 * Class that is a repository for the Address Entities
 * @author Samuel McCosh
 */
package com.genesisY.nbGardensCatalogue.entityManagers;

import java.util.List;

import com.genesisY.nbGardensCatalogue.entities.Address;
import com.genesisY.nbGardensCatalogue.entities.Product;


public interface AddressManager {
	
	public void addAddress(Address a);

	public List<Address> getAddress();
	
	public List<Address> getAddresses();
	
	public Address getAddress(long id);

	public void editAddress(Address a);
	
	public void deleteAddress(Address a);
}
