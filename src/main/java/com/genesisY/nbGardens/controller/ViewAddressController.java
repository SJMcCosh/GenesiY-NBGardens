package com.genesisY.nbGardens.controller;

import javax.enterprise.context.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.genesisY.nbGardens.services.AccountDetailsService;
import com.genesisY.nbGardens.services.AddressService;
import com.genesisY.nbGardensCatalogue.entities.Address;
import com.genesisY.nbGardensCatalogue.entities.Customer;

@Named("address")
@RequestScoped
public class ViewAddressController {

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
	
	public DataModel<Address> getDataModel() {
		return dataModel;
	}

	public void setDataModel(DataModel<Address> dataModel) {
		this.dataModel = dataModel;
	}
	
	public void viewAddress(){
		String username = "davesmith";
		dataModel = new ListDataModel(addressService.getAllAddresses(username));
	}
	
	public String removeAddress(){
		return "index";
	}
	
}
