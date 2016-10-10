/**
 * CustomerManagerOffline class
 * Implements CustomerRepository interface
 * @author Brian McLaughlin
 */

package com.genesisY.nbGardensCatalogue.entityManagers.offline;

import javax.ejb.Stateless;

import com.genesisY.nbGardensCatalogue.entities.Customer;
import com.genesisY.nbGardensCatalogue.entityManagers.repositories.CustomerRepository;

@Stateless
public class CustomerManagerOffline implements CustomerRepository
{
	//Read
	public void readCustomerDetails(Customer c)
	{
		
	}

	@Override
	public void updateAddressDetails(Customer c) 
	{
		
	}

	@Override
	public void updateTelephoneNumber(Customer c) 
	{
		
	}
}
