package com.genesisY.nbGardens.controller;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.genesisY.nbGardens.services.AccountDetailsService;
import com.genesisY.nbGardens.businessLogic.EditDetailsService;
import com.genesisY.nbGardensCatalogue.entities.Customer;

@Named("editdetails")
@RequestScoped
public class EditDetailsController {

	@Inject
	private EditDetailsService detailEditor;
	private Customer customer;
	private String username;
	private String firstName;
	private String surname;
	private String phoneNumber;
	private String email;
	private String password;
	@Inject
	private AccountDetailsService ads;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstname) {
		this.firstName = firstname;
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

	public void setPhoneNumber(String phonenumber) {
		this.phoneNumber = phonenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String changeDetails() {
		boolean bool = detailEditor.editing(firstName, surname, phoneNumber, email, username, password);
		if (bool) {
			System.out.println(">>>DETAILS CHANGED<<<");
			Customer person = ads.getCustomerByUsername(username);
			System.out.println(">>>>>"+person.getUsername() + person.getFirstName() + person.getSurname());
			return "viewaccount";
		} else {
			return "index";
		}
	}
}
