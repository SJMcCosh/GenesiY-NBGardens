package com.genesisY.nbGardens.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	
	private boolean authenticateFirstName(String name){
		boolean validate = false;
		Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
		Matcher matcher = pattern.matcher(name);
		if (name.length() < 35) {
			if (!matcher.find()) {
				return validate;
			}
		}
		validate = true;
		return validate;
	}
	private boolean authenticateLastName(String name){
		boolean validate = false;
		Pattern pattern = Pattern.compile("^[a-zA-Z-]+$");
		Matcher matcher = pattern.matcher(name);
		if (name.length() < 35) {
			if (!matcher.find()) {
				return validate;
			}
		}
		validate = true;
		return validate;
	}
	private boolean authenticateUsername(String name){
		boolean validate = false;
		Pattern pattern = Pattern.compile("^[0-9a-zA-Z_]+$");
		Matcher matcher = pattern.matcher(name);
		if (name.length() > 7 && name.length() < 45) {
			if (!matcher.find()) {
				return validate;
			}
		}
		validate = true;
		return validate;
	}
	private boolean authenticatePhone(String name){
		boolean validate = false;
		String[] string = name.split("^[ -]+&");
		name = String.join("", string);
		Pattern pattern = Pattern.compile("^[0-9]+$");
		Matcher matcher = pattern.matcher(name);
		if (name.length() == 11) {
			if (!matcher.find()) {
				return validate;
			}
		}
		validate = true;
		return validate;
	}
	private boolean authenticateEmail(String name){
		boolean validate = false;
		if (!name.contains("@")) return validate;
		Pattern pattern = Pattern.compile("^[a-zA-Z!#$%&'*+-/=?^_`{|}~.-]+$");
		Matcher matcher = pattern.matcher(name);
		if (name.length() > 6 && name.length() < 90) {
			if (!matcher.find()) {
				return validate;
			}
		}
		validate = true;
		return validate;
	}
	private boolean authenticatePassword(String password){
		boolean validate = false;
		if (password.length() > 8 && password.length() < 35) {
				validate = true;
		}
		return validate;
	}


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
