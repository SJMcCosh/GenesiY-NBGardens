/**
 * CustomerManagerOffline class
 * Implements CustomerRepository interface
 * @author Brian McLaughlin
 */

package com.genesisY.nbGardensCatalogue.entityManagers.offline;

import javax.ejb.Stateless;

import com.genesisY.nbGardensCatalogue.entities.Customer;
import com.genesisY.nbGardensCatalogue.entityManagers.CustomerManager;

@Stateless
public class CustomerManagerOffline implements CustomerManager
{
	//Read
	public void readCustomerDetails(Customer c)
	{
		
	}
	public void updateAddressDetails(Customer c) 
	{
		
	}

	public void updateTelephoneNumber(Customer c) 
	{
		
	}
}
