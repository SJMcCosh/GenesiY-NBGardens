package com.genesisY.nbGardens.controller;

import javax.enterprise.context.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.genesisY.nbGardens.services.AddressService;
import com.genesisY.nbGardensCatalogue.entities.Address;
import com.genesisY.nbGardensCatalogue.entities.Customer;

@Named("address")
@RequestScoped
public class AddressController {

	@Inject
	private AddressService addressService;
	@Inject
	private UserCredentials userCredentials;
	@Inject
	private CustomerController customerController;
	private Customer customer;
	private Address address;
	private DataModel<Address> dataModel = null;

	public AddressService getAddressService() {
		return addressService;
	}

	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}

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
	
	public String viewAddress(){
		String username = userCredentials.getUsername();
		System.out.println(username);
		dataModel = new ListDataModel<Address>(addressService.getAllAddresses(username));
		return "viewaddresses";
	}

	
	/**
	 * Gets the address a user wants to edit and redirects them to the edit address page
	 * @param id : of the address they want to edit
	 * @return String : either the edit deiails page if the id matches or does nothing
	 */
	public String editAddress(String id){
		System.out.println(">>>>>>>>>>>> edit address");
		try{
			int addid = Integer.parseInt(id);
			for(Address a : addressService.getAllAddresses(userCredentials.getUsername())){
				if(a.getAddressID() == addid){
					address = a;
					
				}
			}
			System.out.println(">>>>>>>>>>>>" + address.getAddressLine1());
			return "editaddress";	
		}catch(ClassCastException cce){
			return "viewaddresses";
		}
			
		
	}
	
	public String reassignBillingAddress(){
		return customerController.viewDetails();
	}
	
}
