package com.genesisY.nbGardens.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.genesisY.nbGardens.services.EditDetailsService;
import com.genesisY.nbGardens.services.AccountDetailsService;

import com.genesisY.nbGardensCatalogue.entities.Customer;

@Named("detaileditor")
@ManagedBean
@RequestScoped
public class EditDetailsController {

	@Inject
	private EditDetailsService detailEditor;
	@Inject
	private AccountDetailsService accountDetailService;
	@Inject
	private CustomerController customerController;
	private String firstName = "";
	private String surname = "";
	private String phoneNumber = "";
	private String email = "";
	private String username = "";
	private String password = "";
	
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

	public String changeDetails() {
		System.out.println(">>>>>  hello" + getFirstName() + " " + getSurname() + " " + getPhoneNumber() + " " + getEmail() + " " + getUsername() + " "
				+ getPassword());
		if (!userValidate(username)){
			return "index";
		}
		boolean bool = detailEditor.editing(firstName, surname, phoneNumber, email, username, password);
		System.out.println(bool);
		if (bool) {
			System.out.println(">>>DETAILS CHANGED<<<");
			Customer person = accountDetailService.getCustomerByUsername(username);
			System.out.println(">>>>> " + person.getUsername() + person.getFirstName() + person.getSurname());
			return "viewaccount";
		} else {
			return "index";
		}
	}
	
	public String bindAttributes(){
		setFirstName(customerController.getCustomer().getFirstName());
		setSurname(customerController.getCustomer().getSurname());
		setPhoneNumber(customerController.getCustomer().getPhoneNumber());
		setEmail(customerController.getCustomer().getEmail());
		return "editdetails";
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
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
	
	
}
