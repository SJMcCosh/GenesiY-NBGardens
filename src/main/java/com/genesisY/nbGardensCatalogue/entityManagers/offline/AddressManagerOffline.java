/**
 * Class that is a allows the Address Entities to be created, read or updated
 * @author Samuel McCosh
 */

package com.genesisY.nbGardensCatalogue.entityManagers.offline;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.genesisY.nbGardensCatalogue.entities.Address;
import com.genesisY.nbGardensCatalogue.entityManagers.AddressManager;
import com.genesisY.nbGardensCatalogue.initialData.InitialData;

@Stateless
@Default
public class AddressManagerOffline implements AddressManager {
	
	@Inject
	private InitialData initialData;

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
	public Address getAddress(long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deleteAddress(Address a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editAddress(Address a) {
		// TODO Auto-generated method stub
		
	}

}
