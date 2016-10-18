package com.genesisY.nbGardens.businessLogic;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.genesisY.nbGardensCatalogue.entities.Customer;

@RequestScoped
public class EditDetailsService {

	@Inject
	private Customer c;
	@Inject
	private LoginService passing;

	public Customer getC() {
		return c;
	}

	public void setC(Customer c) {
		this.c = c;
	}

	public boolean editing(String firstName, String surname, String phoneNumber, String email, String username, String password) {
//		Return a boolean and when authenticate = true;
		boolean auth = passing.passCheck(username, password);
		if (auth){
			c.setFirstName(firstName);
			c.setSurname(surname);
			c.setPhoneNumber(phoneNumber);
			c.setEmail(email);
			return true;
		}
		else{
			return false;
		}
	}

	public Customer tester() {
		;
	}
}
