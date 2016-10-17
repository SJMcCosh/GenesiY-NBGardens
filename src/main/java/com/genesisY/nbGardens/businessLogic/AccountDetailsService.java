package com.genesisY.nbGardens.businessLogic;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.genesisY.nbGardensCatalogue.entities.Customer;
import com.genesisY.nbGardensCatalogue.entityManagers.AccountManagerInterface;

@RequestScoped
public class AccountDetailsService {

	@Inject
	private AccountManagerInterface ami;
	
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
