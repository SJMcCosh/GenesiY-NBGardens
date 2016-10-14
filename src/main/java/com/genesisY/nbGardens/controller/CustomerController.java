package com.genesisY.nbGardens.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.genesisY.nbGardensCatalogue.entities.Customer;

@SuppressWarnings("serial")
@Named("customer")
@SessionScoped
public class CustomerController implements Serializable{


	private Customer customer;
	

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public String login(){
		//TODO: use beans or whatever to login
		return "index";
	}
	
	public String gotoSignUp(){
		return "signup";
	}
	
}
