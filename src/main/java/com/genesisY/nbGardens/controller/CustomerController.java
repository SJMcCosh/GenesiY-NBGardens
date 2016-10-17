package com.genesisY.nbGardens.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.genesisY.nbGardens.businessLogic.AccountDetailsService;
import com.genesisY.nbGardensCatalogue.entities.Address;
import com.genesisY.nbGardensCatalogue.entities.Customer;

@SuppressWarnings("serial")
@Named("customer")
@SessionScoped
public class CustomerController implements Serializable{

	@Inject private AccountDetailsService accountDetailsService;
	private Customer customer;
	private Address address;
	
	
	

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	public String viewDetails( String username){
		username = "davesmith";
		customer = accountDetailsService.getCustomerByUsername(username);
		return "viewaccount";
	}
	
	public String login(){
		//TODO: use beans or whatever to login
		return "index";
	}
	
	public String gotoSignUp(){
		return "signup";
	}
	
}
