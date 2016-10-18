/**
 * Interface to be implemented in offline + online CustomerManager classes
 * @author Brian McLaughlin
 */

package com.genesisY.nbGardensCatalogue.entityManagers;

import javax.ejb.Stateless;

import com.genesisY.nbGardensCatalogue.entities.Customer;

@Stateless
public interface CustomerManager 
{
	//Read
	public void readCustomerDetails(Customer c);
	
	//Update
	public void updateAddressDetails(Customer c);
	public void updateTelephoneNumber(Customer c);
	
}
