package com.genesisY.nbGardens.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.genesisY.nbGardens.services.AccountDetailsService;
import com.genesisY.nbGardens.services.AddressService;
import com.genesisY.nbGardensCatalogue.entities.Address;
import com.genesisY.nbGardensCatalogue.entities.Customer;

@SuppressWarnings("serial")
@Named("customer")
@SessionScoped
public class CustomerController implements Serializable {

	@Inject
	private AccountDetailsService accountDetailsService;
	@Inject
	private AddressService addressService;
	private Customer customer;
	private Address address;
	private DataModel<Address> dataModel = null;

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

	public String viewDetails() {
		String username = "davesmith";
		customer = accountDetailsService.getCustomerByUsername(username);
		dataModel = new ListDataModel(addressService.getAllAddresses(username));
		for (Address a:dataModel){
			if (a.isBillingAddress()){
				address = a;
				break;
			}
		}
		return "viewaccount";
	}



}
