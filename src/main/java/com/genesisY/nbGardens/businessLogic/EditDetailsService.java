package com.genesisY.nbGardens.businessLogic;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.genesisY.nbGardensCatalogue.entityManagers.AccountManager;

@RequestScoped
public class EditDetailsService {

	@Inject
	private AccountManager ami;
	@Inject
	private LoginService passing;


	public boolean editing(String firstName, String surname, String phoneNumber, String email, String username, String password) {
//		Return a boolean and when authenticate = true;
		boolean auth = passing.passCheck(username, password);
		if (auth){
			ami.updateFirstName(firstName, username);
			ami.updateLastName(surname, username);
			ami.updatePhoneNum(phoneNumber, username);
			ami.updateEmail(email, username);
			return true;
		}
		else{
			return false;
		}
	}
}
