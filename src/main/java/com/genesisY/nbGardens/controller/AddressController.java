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

	public String viewAddress() {
		String username = userCredentials.getUsername();
		System.out.println(username);
		dataModel = new ListDataModel<Address>(addressService.getAllAddresses(username));
		return "viewaddresses";
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
			System.out.println(">>>>>>>>>>>> " + id);
			int addid = Integer.parseInt(id);
			System.out.println(">>>>>>>>>>>> check fine");
			for (Address a : dataModel) {
				System.out.println(">>>>>>>>>>>> " + a.getAddressID());
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

	public String addAddress(String addressLine1, String addressLine2, String addressLine3, String townCity,
			String county, String postcode, Customer customer) {

		addressService.addAddress(addressLine1, addressLine2, addressLine3, townCity, county, postcode, false,
				customer);

		return "viewaddresses";

	}

}
