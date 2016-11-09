package com.genesisY.nbGardens.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.genesisY.nbGardens.entities.Address;
import com.genesisY.nbGardens.entities.PaginationHelper;
import com.genesisY.nbGardens.entities.Supplier;
import com.genesisY.nbGardens.services.SupplierService;

@Named("addSupplierCont")
@SuppressWarnings("serial")
@SessionScoped
public class AddSupplierController implements Serializable {

	@Inject
	private SupplierService supplierService;
	private DataModel<Supplier> dataModel = null;
	private String name = "name"; 
	private String phone= "phone number"; 
	private String email= "example@nb.com"; 
	private String addressLine1= "line 1";
	private String addressLine2= "line 2";
	private String addressLine3= "line 3";
	private String townCity= "town";
	private String country= "country";
	private String postcode= "postcode"; 
	private Supplier supplier; 
	private Address address; 
	
	

	public String getName() {
		return name;
	}


	public String getPhone() {
		return phone;
	}


	public String getEmail() {
		return email;
	}


	public String getAddressLine1() {
		return addressLine1;
	}


	public String getAddressLine2() {
		return addressLine2;
	}


	public String getTownCity() {
		return townCity;
	}


	public String getCountry() {
		return country;
	}


	public String getPostcode() {
		return postcode;
	}


	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}


	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}


	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAddressLine3() {
		return addressLine3;
	}



	public void setTownCity(String townCity) {
		this.townCity = townCity;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public DataModel<Supplier> getDataModel() {
		return dataModel;
	}

	public void setDataModel(DataModel<Supplier> dataModel) {
		this.dataModel = dataModel;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	public String createNewSupplier()
	{
		 supplierService.addSupplier(name, phone, email, addressLine1, addressLine2, addressLine3, townCity, country, postcode);
	return "viewsupplier";
	}
	
	
	
}