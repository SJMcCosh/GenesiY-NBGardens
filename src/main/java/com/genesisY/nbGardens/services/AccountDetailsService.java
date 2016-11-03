package com.genesisY.nbGardens.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.genesisY.nbGardensCatalogue.entities.Customer;
import com.genesisY.nbGardensCatalogue.entityManagers.AccountManager;

@Stateless
public class AccountDetailsService {

	@Inject
	private AccountManager ami;

	private boolean userValidate(String username) {
		boolean validate = false;
		Pattern pattern = Pattern.compile("^[0-9a-zA-Z_]+$");
		Matcher matcher = pattern.matcher(username);
		if (username.length() > 7 && username.length() < 45) {
			if (matcher.find()) {
				validate = true;
			}
		}
		return validate;
	}

	public Customer getCustomerByUsername(String username) {
		try {
			if (username != null) {
				if (userValidate(username)) {
					return ami.findByUsername(username);
				}
			}
		} catch (NullPointerException npe) {

		}

		return null;
	}

}
