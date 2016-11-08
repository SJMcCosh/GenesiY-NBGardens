package com.genesisY.nbGardens.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.genesisY.nbGardens.services.EditAddressService;

@Named("editaddress")
@RequestScoped
public class EditAddressController {
	
	private String addressLine1;
	private String addressLine2;
	private String addressLine3;
	private String townCity;
	private String county;
	private String postcode;
	
	@Inject private AddressController addressController;
	@Inject private EditAddressService editAddressService;
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
	public String getTowncity() {
		return townCity;
	}
	public void setTowncity(String townCity) {
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
	
	public String assignValues(){
		setAddressLine1(addressController.getAddress().getAddressLine1());
		setAddressLine2(addressController.getAddress().getAddressLine2());
		setAddressLine3(addressController.getAddress().getAddressLine3());
		setTowncity(addressController.getAddress().getTownCity());
		setCounty(addressController.getAddress().getCounty());
		setPostcode(addressController.getAddress().getPostcode());
		
		return "editaddress";
		
	}
	
	public String editAddressDetails(){
		addressController.getAddress().setAddressLine2(addressLine2);
		addressController.getAddress().setAddressLine1(addressLine1);
		addressController.getAddress().setAddressLine3(addressLine3);
		addressController.getAddress().setCounty(county);
		addressController.getAddress().setPostcode(postcode);
		addressController.getAddress().setTownCity(townCity);
		
		editAddressService.editDetails(addressController.getAddress());
		
		return "editaddress";
	}
	
	
}
