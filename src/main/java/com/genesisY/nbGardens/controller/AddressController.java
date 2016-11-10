package com.genesisY.nbGardens.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.genesisY.nbGardens.services.AddressService;
import com.genesisY.nbGardens.services.EditAddressService;
import com.genesisY.nbGardensCatalogue.entities.Address;
import com.genesisY.nbGardensCatalogue.entities.Customer;

@Named("address")
@SessionScoped
public class AddressController implements Serializable {

	@Inject
	private AddressService addressService;
	@Inject
	private UserCredentials userCredentials;
	@Inject
	private CustomerController customerController;
	@Inject
	private EditAddressService editAddressService;
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

	public String viewAddress() {
		String username = userCredentials.getUsername();
		dataModel = new ListDataModel<Address>(addressService.getAllAddresses(username));
		return "viewaddresses";
	}
	
	public void getAddresses(){
		String username = userCredentials.getUsername();
		dataModel = new ListDataModel<Address>(addressService.getAllAddresses(username));
	}

	/**
	 * Gets the address a user wants to edit and redirects them to the edit
	 * address page
	 * 
	 * @param id
	 *            : of the address they want to edit
	 * @return String : either the edit deiails page if the id matches or does
	 *         nothing
	 */
	public void editAddress(String id) {
		try {
			int addid = Integer.parseInt(id);
			for (Address a : dataModel) {
				if (a.getAddressID() == addid) {
					address = a;
				}
			}

		} catch (NumberFormatException nfe) {

		} catch (NullPointerException npe) {

		}
	}

	public String deleteAddress(String id) {
		try {
			int addid = Integer.parseInt(id);

			for (Address a : dataModel) {
				if (a.getAddressID() == addid) {
					address = a;
					address.setActive(false);
					editAddressService.deleteAddress(address);

				}
			}
			return "viewaddresses";
		} catch (NumberFormatException nfe) {
			return "viewaddresses";
		}
	}

	public String reassignBillingAddress() {
		return customerController.viewDetails();
	}

	public CustomerController getCustomerController() {
		return customerController;
	}

	public void setCustomerController(CustomerController customerController) {
		this.customerController = customerController;
	}

	public String addAddress() {

		addressService.addAddress(addressLine1, addressLine2, addressLine3, townCity, county, postcode, false,
				customer);

		return "viewaddresses";

	}

}
