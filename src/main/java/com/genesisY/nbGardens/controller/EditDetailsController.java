package com.genesisY.nbGardens.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.genesisY.nbGardens.services.EditDetailsService;

@Named("editdetails")
@RequestScoped
public class EditDetailsController {

	private String firstname;
	private String surname;
	private String phoneNumber;
	private String email;
	private String username;
	private String password;
	private String error = "";

	@Inject
	private CustomerController customerController;

	@Inject
	private EditDetailsService editDetailsService;

	@Inject
	private ErrorController errorController;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String bindAttributes() {
		firstname = customerController.getCustomer().getFirstName();
		surname = customerController.getCustomer().getSurname();
		email = customerController.getCustomer().getEmail();
		phoneNumber = customerController.getCustomer().getPhoneNumber();
		return "editdetails";
	}

	public String updateCustomer() {
		System.out.println(username + " " + firstname);
		if (userValidate(username)) {
			if (editDetailsService.authenticatePassword(password)) {
				customerController.getCustomer().setFirstName(firstname);
				customerController.getCustomer().setSurname(surname);
				customerController.getCustomer().setEmail(email);
				customerController.getCustomer().setPhoneNumber(phoneNumber);
				editDetailsService.updateCustomerDetails(customerController.getCustomer());

				return "editdetails";

			}
			return "editdetails";
		} else {
			error = "Username or password is incorrect";
			return "editdetails";
		}

	}

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

}
