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
	private String addressLine1; 
	private String addressLine2; 
	private String addressLine3; 
	private String townCity; 
	private String county; 
	private String postcode; 
	

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

	public UserCredentials getUserCredentials() {
		return userCredentials;
	}

	public void setUserCredentials(UserCredentials userCredentials) {
		this.userCredentials = userCredentials;
	}

	public CustomerController getCustomerController() {
		return customerController;
	}

	public void setCustomerController(CustomerController customerController) {
		this.customerController = customerController;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAddressLine3() {
		return addressLine3;
	}

	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	public String getTownCity() {
		return townCity;
	}

	public void setTownCity(String townCity) {
		this.townCity = townCity;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	

	
	
	public String addAddress(String addressLine1, String addressLine2, String addressLine3, String townCity,String county, String postcode, Customer customer){
		
		
		addressService.addAddress(addressLine1, addressLine2, addressLine3, townCity, county, postcode, false, customer);
		
		
		
		
		return "viewaddresses";
		
		
		
	}
	
	
}
