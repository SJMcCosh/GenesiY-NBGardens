package com.genesisY.nbGardens.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.genesisY.nbGardensCatalogue.entities.Customer;
import com.genesisY.nbGardensCatalogue.entityManagers.AccountManager;

@Stateless
public class EditDetailsService {

	@Inject
	private AccountManager accountManager;

	public void updateCustomerDetails(Customer customer) {
		accountManager.updateCustomerDetails(customer);
	}

	public boolean authenticateFirstName(String firstname) {
		boolean validate = false;
		Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
		Matcher matcher = pattern.matcher(firstname);
		if (firstname.length() < 35) {
			if (!matcher.find()) {
				return validate;
			}
		}
		validate = true;
		return validate;
	}

	public boolean authenticateLastName(String surname) {
		boolean validate = false;
		Pattern pattern = Pattern.compile("^[a-zA-Z-]+$");
		Matcher matcher = pattern.matcher(surname);
		if (surname.length() < 35) {
			if (!matcher.find()) {
				return validate;
			}
		}
		validate = true;
		return validate;
	}

	public boolean authenticateUsername(String username) {
		boolean validate = false;
		Pattern pattern = Pattern.compile("^[0-9a-zA-Z_]+$");
		Matcher matcher = pattern.matcher(username);
		if (username.length() > 7 && username.length() < 45) {
			if (!matcher.find()) {
				return validate;
			}
		}
		validate = true;
		return validate;
	}

	public boolean authenticatePhone(String phoneNumber) {
		boolean validate = false;
		String[] string = phoneNumber.split("^[ -]+&");
		phoneNumber = String.join("", string);
		Pattern pattern = Pattern.compile("^[0-9]+$");
		Matcher matcher = pattern.matcher(phoneNumber);
		if (phoneNumber.length() == 11) {
			if (!matcher.find()) {
				return validate;
			}
		}
		validate = true;
		return validate;
	}

	public boolean authenticateEmail(String email) {
		boolean validate = false;
		if (!email.contains("@"))
			return validate;
		Pattern pattern = Pattern.compile("^[a-zA-Z!#$%&'*+-/=?^_`{|}~.-]+$");
		Matcher matcher = pattern.matcher(email);
		if (email.length() > 6 && email.length() < 90) {
			if (!matcher.find()) {
				return validate;
			}
		}
		validate = true;
		return validate;
	}

	public boolean authenticatePassword(String password) {
		boolean validate = false;
		if (password.length() > 8 && password.length() < 35) {
			validate = true;
		}
		return validate;
	}

}
