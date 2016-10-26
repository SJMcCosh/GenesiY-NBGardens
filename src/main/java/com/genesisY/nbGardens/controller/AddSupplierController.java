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

@SuppressWarnings("serial")
@Named("supplierAdd")
@SessionScoped
public class AddSupplierController implements Serializable {

	@Inject
	private SupplierService supplierService;
	private DataModel<Supplier> dataModel = null;
	private PaginationHelper pagination;
	private int selected;
	private String name; 
	private String phone; 
	private String email; 
	private String addressLine1;
	private String addressLine2;
	private String addressLine3;
	private String townCity;
	private String country; 
	private String postcode; 
	
	
	
	
	
	

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

	
	
	public Supplier createNewSupplier()
	{
		Supplier s = new Supplier(name, phone, email, new Address(addressLine1, addressLine2, addressLine3, townCity, country, postcode));
			return s; 
	}
	
	
	
}