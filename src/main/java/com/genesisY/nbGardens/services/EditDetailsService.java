package com.genesisY.nbGardens.services;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.genesisY.nbGardens.services.LoginService;
import com.genesisY.nbGardensCatalogue.entityManagers.AccountManager;

@Stateless

public class EditDetailsService {

	@Inject
	private AccountManager accountManager;
	@Inject
	private LoginService passing;


	public boolean editing(String firstName, String surname, String phoneNumber, String email, String username, String password) {
//		Return a boolean and when authenticate = true;
		boolean auth = passing.passCheck(username, password);
		System.out.println("Deets " + auth);
		if (auth){
			accountManager.updateFirstName(firstName, username);
			accountManager.updateLastName(surname, username);
			accountManager.updatePhoneNum(phoneNumber, username);
			accountManager.updateEmail(email, username);
			return true;
		}
		else{
			return false;
		}
	}
}
