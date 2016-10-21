package com.genesisY.nbGardens.services;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.genesisY.nbGardensCatalogue.entities.Customer;
import com.genesisY.nbGardensCatalogue.entityManagers.AccountManager;

@Stateless
public class AccountDetailsService {

	@Inject
	private AccountManager ami;
	
	public Customer getCustomerByUsername( String username){
		try{
			if(username != null){
				return ami.findByUsername(username);
			}
		} catch(NullPointerException npe){
			
		}
		
		return null;
	}
	
	
	
}
