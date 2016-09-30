/**
 * Interface to be implemented in offline + online CustomerManager classes
 * @author Brian McLaughlin
 */

package com.genesisY.nbGardensCatalogue.entityManagers.repositories;

import javax.ejb.Stateless;

import com.genesisY.nbGardensCatalogue.entities.Customer;

@Stateless
public interface CustomerRepository 
{
	//Read
	public void readCustomerDetails(Customer c);
	
	//Update
	
}
