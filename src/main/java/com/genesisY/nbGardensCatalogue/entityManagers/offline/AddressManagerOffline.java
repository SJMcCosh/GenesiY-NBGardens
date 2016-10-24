/**
 * Class that is a allows the Address Entities to be created, read or updated
 * @author Samuel McCosh
 */

package com.genesisY.nbGardensCatalogue.entityManagers.offline;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.genesisY.nbGardensCatalogue.entities.Address;
import com.genesisY.nbGardensCatalogue.entities.Customer;
import com.genesisY.nbGardensCatalogue.entityManagers.AccountManager;
import com.genesisY.nbGardensCatalogue.entityManagers.AddressManager;
import com.genesisY.nbGardensCatalogue.initialData.InitialData;

@Stateless
@Default
public class AddressManagerOffline implements AddressManager {
	
	@Inject
	private InitialData initialData;
	@Inject
	private AccountManager accountManager;

	@Override
	public void addAddress(Address a) {
		// TODO Auto-generated method stub
		initialData.addAddress(a);
	}

	@Override
	public List<Address> getAddresses() {
		return initialData.getAddressList();
	}


	@Override
	public void deleteAddress(Address a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editAddress(Address a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Address> getAddressByUsername(String username) {
		ArrayList<Address> addresses = new ArrayList<Address>();
		for (Address address:initialData.getAddressList()){
			Customer customer = address.getCustomer();
			if (customer.equals(accountManager.findByUsername(username))){
				addresses.add(address);
			}
		}
		return addresses;
	}

}
